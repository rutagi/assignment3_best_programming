import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/register", "/login", "/welcome.jsp"})

public class Register extends HttpServlet {
	private static final Logger logger = LoggerSetup.logger;
    private static final long serialVersionUID = 1L;

    public Register() {
        super();
        logger.info("Register instance created");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RegistersDao rdao = new RegistersDao();
        Connection con = rdao.getConnection();

        String sql = "SELECT * FROM me";
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            out.println("<html><body><h2>Registered Users</h2>");
            out.println("<table border='1'><tr><th>ID</th><th>Names</th><th>Email</th><th>Password</th></tr>");
            while (rs.next()) {
                int id = rs.getInt("id");
                String names = rs.getString("names");
                String email = rs.getString("email");
                String password = rs.getString("password");
                out.println("<tr><td>" + id + "</td><td>" + names + "</td><td>" + email + "</td><td>" + password + "</td></tr>");
            }
            out.println("</table></body></html>");
        } catch (SQLException ex) {
            ex.printStackTrace();
            out.println("Error retrieving data from database: " + ex.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String names = request.getParameter("names");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Member member = new Member(id, names, email, password);
        RegistersDao rdao = new RegistersDao();
        String result = rdao.insert(member);

        if (result.equals("Successfully registered")) {
            response.sendRedirect("Login.jsp"); // Redirect to login page after successful registration
        } else {
            response.getWriter().print(result); // Print error message if registration failed
        }
    }

}
