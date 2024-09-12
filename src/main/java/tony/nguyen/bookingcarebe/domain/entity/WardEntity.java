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
@Table(name = "wards")
public class WardEntity {
    @Id
    @Column(name = "wards_id", insertable = false, updatable = false, nullable = false)
    private Integer id;

    @Column(name = "district_id", insertable = false, updatable = false, nullable = false)
    private Integer districtId;

    @Column(name = "name", insertable = false, updatable = false, nullable = false)
    private String name;

}