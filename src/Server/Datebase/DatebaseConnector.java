package Server.Datebase;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatebaseConnector {
    static String DB_URL = "jdbc:oracle:thin:@localhost:1521/xe";
    static Statement stmt = null;
    static java.sql.Connection conn = null;
    static ResultSet rs;

    static String USER = "hr";
    static String PASSWORD = "hr";


    public static void connect(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            System.out.println("Connecting to a select datebase...");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);

            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect(){
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            if (stmt != null)
                conn.close();
        } catch (SQLException se) {
        }// do nothing
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }//end finally try
    }

    public static ResultSet  getResultSet(String sql) {
        try {
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void execute(String sql){
        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
