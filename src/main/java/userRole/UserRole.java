package userRole;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import users.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_role")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_role_id;
    @Column(name = "role")
    private String role;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(
            name = "roles_users",
            joinColumns = @JoinColumn(name = "user_role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_login")
    )
    @Fetch(FetchMode.SUBSELECT)
    private List<User> users;

    public UserRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return  role;
    }
}
