package users;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import userRole.UserRole;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode

public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//    @EmbeddedId
//    private LogPasUser logPasUser;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "date_create")
    private LocalDateTime dateTime;
    @Column(name = "date_modification")
    private LocalDateTime dateMod = LocalDateTime.now();

    @ManyToMany(cascade = CascadeType.MERGE,  fetch = FetchType.LAZY)
    @JoinTable(
            name = "roles_users",
            joinColumns = @JoinColumn(name = "user_login"),
            inverseJoinColumns = @JoinColumn(name = "user_role_id")
    )
    @Fetch(FetchMode.SUBSELECT)
    private List<UserRole> userRoles;

    public User(String login, String password, String userName) {
        this.login = login;
        this.password = password;
        this.userName = userName;
        this.dateTime = LocalDateTime.now();
        this.dateMod = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Пользователь: " +
                ", логин: '" + login + '\'' +
                ", пароль: '" + password + '\'' +
                ", Никнейм: '" + userName + '\'' +
                ", дата создания: " + dateTime +
                ", дата изменения: " + dateMod +
                ", роли: " + userRoles;
    }
}
