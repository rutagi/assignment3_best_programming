import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class RegistersDao {
    private static final Logger logger = LoggerSetup.logger;
    private String dburl = "jdbc:postgresql://localhost:5432/mevsme";
    private String dbuname = "postgres";
    private String dbPassword = "Olibo0789@";
    private String dbDriver = "org.postgresql.Driver";

    public void loadDriver(String dbDriver) {
        try {
            Class.forName(dbDriver);
            logger.info("Database driver loaded successfully");
        } catch (ClassNotFoundException ex) {
            logger.severe("Failed to load database driver: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(dburl, dbuname, dbPassword);
            logger.info("Database connection established successfully");
        } catch (SQLException ex) {
            logger.severe("Failed to establish database connection: " + ex.getMessage());
            ex.printStackTrace();
        }
        return con;
    }

    public String insert(Member member) {
        loadDriver(dbDriver);
        Connection con = getConnection();
        String result1 = "Successfully registered";
        String sql = "INSERT INTO me (id, names, email, password) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, member.getId());
            ps.setString(2, member.getNames());
            ps.setString(3, member.getEmail());
            ps.setString(4, member.getPassword());
            ps.executeUpdate();
            logger.info("Member registered successfully: " + member);
        } catch (SQLException ex) {
            logger.severe("Registration failed: " + ex.getMessage());
            result1 = "Registration failed: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                    logger.info("Database connection closed");
                }
            } catch (SQLException e) {
                logger.severe("Failed to close database connection: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return result1;
    }

    public boolean login(String names, String password) {
        loadDriver(dbDriver);
        Connection con = getConnection();
        boolean status = false;
        String sql = "SELECT * FROM me WHERE names = ? AND password = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, names);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            if (status) {
                logger.info("Login successful for user: " + names);
            } else {
                logger.warning("Login failed for user: " + names);
            }
        } catch (SQLException ex) {
            logger.severe("Login failed: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                    logger.info("Database connection closed");
                }
            } catch (SQLException e) {
                logger.severe("Failed to close database connection: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return status;
    }
}
