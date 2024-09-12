package tony.nguyen.bookingcarebe.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "specialties")
public class SpecialtyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "created_date" , insertable = false, updatable = false)
    private Instant createdDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "updated_date", insertable = false, updatable = false)
    private Instant updatedDate;

}