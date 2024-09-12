package tony.nguyen.bookingcarebe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tony.nguyen.bookingcarebe.domain.entity.UserRefreshTokenEntity;

import java.util.List;

public interface UserRefreshTokenRepository extends JpaRepository<UserRefreshTokenEntity, Integer> {
    List<Object> findAllByUserIdAndInvoke(Integer userId, Boolean invoke);
}