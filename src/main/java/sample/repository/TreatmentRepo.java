package sample.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import sample.model.Treatment;

/**
 * Created by aziz on 15-3-17 :)
 */
@Repository
public interface TreatmentRepo extends GraphRepository<Treatment> {
}
