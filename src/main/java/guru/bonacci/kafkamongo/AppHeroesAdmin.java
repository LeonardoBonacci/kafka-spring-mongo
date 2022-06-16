package guru.bonacci.kafkamongo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import guru.bonacci.kafkamongo.domain.MongoFoo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement
@RequiredArgsConstructor
public class AppHeroesAdmin implements CommandLineRunner {

  private final FooService serv;
  private final FooRepository repo;

  
	public static void main(String[] args) {
		SpringApplication.run(AppHeroesAdmin.class, args);
	}
	
	@Override
  public void run(String... args) throws Exception {

    repo.deleteAll();

    log.info("save a couple");
    try {
      serv.create(new MongoFoo("Alice", "one"));
      serv.create(new MongoFoo("Alice", "two"));
      serv.create(new MongoFoo("Alice", null));
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
    log.info("saved a couple");

    Thread.sleep(1000);
    
    // fetch all customers
    log.info("-------------------------------");
    for (MongoFoo foo : repo.findAll()) {
      log.info(foo.toString());
    }
    log.info("-------------------------------");


  }
}
