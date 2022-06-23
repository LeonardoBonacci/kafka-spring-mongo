package guru.bonacci.kafkamongo;


import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import guru.bonacci.kafkamongo.domain.Bar;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class AppHeroesAdmin implements CommandLineRunner {

  private final FooRepository repo;

  
	public static void main(String[] args) {
		SpringApplication.run(AppHeroesAdmin.class, args);
	}
	
	@Override
  public void run(String... args) throws Exception {

    log.info("save a couple");
    try {
      repo.save(new Bar(UUID.randomUUID().toString(), "..."));
      repo.save(new Bar(UUID.randomUUID().toString(), "..."));
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
    log.info("saved a couple");

    Thread.sleep(1000);
    
    // fetch all customers
    log.info("-------------------------------");
    for (Bar foo : repo.findAll()) {
      log.info(foo.toString());
    }
    log.info("-------------------------------");


  }
}
