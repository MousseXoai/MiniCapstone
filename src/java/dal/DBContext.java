package dal;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBContext {
    protected Connection connection;
    public DBContext()
    {
        try {
            // Edit URL , username, password to authenticate with your MS SQL Server
            String url = "jdbc:sqlserver://TOMTOM\\MSSQLSERVER:1433;databaseName= ShopTech";
            String username = "sa";
            String password = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");     
            connection = DriverManager.getConnection(url, username, password);
            // Kiểm tra kết nối thành công
            if (connection != null) {
                System.out.println("Kết nối SQL Server thành công!");
            } else {
                System.out.println("Kết nối SQL Server không thành công!");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }
}
