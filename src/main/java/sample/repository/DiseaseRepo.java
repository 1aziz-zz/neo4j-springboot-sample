package sample.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;
import sample.model.Disease;

/**
 * Created by aziz on 23-3-17 :)
 */
@Repository
public interface DiseaseRepo extends GraphRepository<Disease> {
}
