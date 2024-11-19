package tony.nguyen.bookingcarebe.domain.entity_elastic;

import jakarta.persistence.*;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.Instant;

@Document(indexName = "clinics")
public class ClinicElasticEntityRepository {
    @Id
    private Integer id;
    private String name;
    private String description;
    private String imagePath;
    private Integer provinceId;
    private Integer districtId;
    private Integer wardId;
    private Integer address;
    private Instant createdDate;
    private Boolean isDeleted;
    private Instant updatedDate;
}