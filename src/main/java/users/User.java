package users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
   // private LocalDateTime localTime = LocalDateTime.now();

    @EmbeddedId
    private LogPasUser logPasUser;
    @Column(name = "user_name")
    private String UserName;
    @Column(name = "date_create")
    private LocalDate dateTime = LocalDate.now();
    @Column(name = "date_modification")
    private LocalDate dateMod;
    @Column(name = "roles")
    private int UserRoleId;

    public User(LogPasUser logPasUser
            , String userName
            , int userRoleId) {
        this.logPasUser = logPasUser;
        UserName = userName;
        this.dateTime = dateTime;
        this.dateMod = dateMod;
        UserRoleId = userRoleId;
    }
}
