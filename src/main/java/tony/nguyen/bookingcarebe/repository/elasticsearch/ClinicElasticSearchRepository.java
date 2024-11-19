package tony.nguyen.bookingcarebe.repository.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import tony.nguyen.bookingcarebe.domain.entity_elastic.ClinicElasticEntityRepository;

public interface ClinicElasticSearchRepository extends ElasticsearchRepository<ClinicElasticEntityRepository, Integer> {
}
