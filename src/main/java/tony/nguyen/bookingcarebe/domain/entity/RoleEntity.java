package tony.nguyen.bookingcarebe.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Entity
@Table(name = "roles")
@Document(indexName = "roles")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

}