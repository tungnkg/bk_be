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
@Table(name = "provinces")
public class ProvinceEntity {
    @Id
    @Column(name = "id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

}