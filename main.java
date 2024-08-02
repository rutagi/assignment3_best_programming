import java.util.logging.Logger;
import java.util.logging.Level;

public class Main {
    private static final Logger logger = LoggerSetup.logger;

    public static void main(String[] args) {
        RegistersDao dao = new RegistersDao();
        
        // Test connection
        try {
            dao.loadDriver(dao.getDbDriver());
            Connection con = dao.getConnection();
            if (con != null) {
                logger.info("Connection established successfully.");
                con.close();
            } else {
                logger.severe("Failed to establish connection.");
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred: ", e);
        }

        // Test insert operation
        Member member = new Member();
        member.setId(1);
        member.setNames("");
        member.setEmail("");
        member.setPassword("");

        String result = dao.insert(member);
        logger.info("Insert result: " + result);
        
        // Test login operation
        boolean loginStatus = dao.login("", "");
        logger.info("Login status: " + loginStatus);
    }
}
