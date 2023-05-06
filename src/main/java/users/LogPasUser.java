package users;

import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
@EqualsAndHashCode
public class LogPasUser implements Serializable {
    private String login;
    private String password;

    public LogPasUser(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public LogPasUser() {

    }
}
