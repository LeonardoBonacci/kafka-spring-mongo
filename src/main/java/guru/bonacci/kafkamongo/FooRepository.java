package guru.bonacci.kafkamongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import guru.bonacci.kafkamongo.domain.MongoFoo;

@Repository
@Transactional("transactionManager")
public interface FooRepository extends MongoRepository<MongoFoo, String> {
}
