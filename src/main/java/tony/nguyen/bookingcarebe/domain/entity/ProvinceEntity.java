package tony.nguyen.bookingcarebe.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "province")
public class ProvinceEntity {
    @Id
    @Column(name = "province_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

}