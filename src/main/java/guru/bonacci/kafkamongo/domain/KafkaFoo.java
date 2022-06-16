package guru.bonacci.kafkamongo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KafkaFoo {

  private String id;
  private String name;
  
  
  public static KafkaFoo from(MongoFoo pool) {
    return new KafkaFoo(pool.getId(), pool.getName());
  }
}