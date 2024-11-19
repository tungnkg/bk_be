package tony.nguyen.bookingcarebe.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Entity
@Table(name = "districts")
public class DistrictEntity {
    @Id
    @Column(name = "id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "province_id", insertable = false, updatable = false)
    private Integer provinceId;

    @Column(name = "name", insertable = false, updatable = false)
    private String name;

}