package guru.bonacci.kafkamongo.domain;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Document("bar")
@NoArgsConstructor
@AllArgsConstructor
public class Bar {

  @Id 
  private String id;

  @NotNull(message = "name must not be null")
  private String name;
}