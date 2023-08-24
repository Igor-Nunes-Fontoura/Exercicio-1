
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    public Connection conn;
    public Statement stm;
    public String sql;
    
    public String url = "jdbc:mysql://localhost:3306/exemplo_senac";
    public String user = "root";
    public String password = "07022003";
    
    public Connection connectDB(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            stm = conn.createStatement();
            
            System.out.println("Conectado");
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Falha na conexão");
            
        }
        return conn;
    }
    
}
