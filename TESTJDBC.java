package casestudy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TESTJDBC {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:XE"; // replace XE with your SID
        String username = "system";  // 
        String password = "manager";  // your DB password

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Oracle database!");

            // Create statement and execute query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM emp"); // replace with your table

            while (rs.next()) {
                System.out.println(rs.getInt(1) + " - " + rs.getString(2));
            }

            // Close connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}