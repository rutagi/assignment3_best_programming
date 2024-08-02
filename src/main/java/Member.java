import java.util.logging.Logger;

public class Member {
private static final Logger logger = LoggerSetup.logger;
    private Integer id;
    private String names, email, password;

    public Member() {
        super();
        logger.info("Member instance created");
    }

    public Member(Integer id, String names, String email, String password) {
        super();
        this.id = id;
        this.names = names;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
