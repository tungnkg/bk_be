package tony.nguyen.bookingcarebe.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tony.nguyen.bookingcarebe.domain.adapter.RoleAdapter;
import tony.nguyen.bookingcarebe.domain.adapter.UserAdapter;
import tony.nguyen.bookingcarebe.domain.entity.UserEntity;
import tony.nguyen.bookingcarebe.domain.model.Role;
import tony.nguyen.bookingcarebe.domain.model.User;
import tony.nguyen.bookingcarebe.domain.model.UserRole;
import tony.nguyen.bookingcarebe.repository.UserRepository;
import tony.nguyen.bookingcarebe.service.dto.CustomUserDetails;
import tony.nguyen.bookingcarebe.shared.utils.ModelTransformUtils;
import tony.nguyen.bookingcarebe.shared.utils.SecurityUtils;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserAdapter userAdapter;
    private final RoleAdapter roleAdapter;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userAdapter.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        enrichRole(user);
        return new CustomUserDetails(user);
    }

    public void enrichRole(User users) {
        if (users == null ) return;
        List<UserRole> userRoles = roleAdapter.findAllByUserIdIn( List.of(users.getId()));
        List<Integer> allRoleIds = ModelTransformUtils.getAttribute(userRoles, UserRole::getRoleId);
        List<Role> roles = roleAdapter.findAllByIdIn(allRoleIds);
        users.setRoles(roles);
    }

    public boolean hasRole(String authRole) {
        User user = SecurityUtils.getCurrentUserDetails();
        if (user == null) {
            return false;
        }

        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            if (Objects.equals(role.getName(), authRole)) {
                return true;
            }
        }
        return false;
    }
}
