package guru.bonacci.kafkamongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import guru.bonacci.kafkamongo.domain.Bar;

@Repository
public interface FooRepository extends MongoRepository<Bar, String> {
}
