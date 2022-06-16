package guru.bonacci.kafkamongo;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import guru.bonacci.kafkamongo.domain.KafkaFoo;
import guru.bonacci.kafkamongo.domain.MongoFoo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FooService {

  private final FooRepository fooRepo;
  private final KafkaTemplate<String, KafkaFoo> kafkaTemplate;
  

  @Transactional("transactionManager")
  public MongoFoo create(MongoFoo foo) {
    var kafkaFoo = KafkaFoo.from(foo); 
    kafkaTemplate.send("foo", kafkaFoo.getId(), kafkaFoo);
    return fooRepo.save(foo);
  }
}
