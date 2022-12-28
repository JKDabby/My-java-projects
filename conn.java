/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pm;
import java.sql.*;
/**
 *
 * @author Laptopgame
 */
public class conn {
    Statement s;
    public conn(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dulieu_taikhoan","root","Crossfire123");
        s = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
            }
        }    
    public static void main(String args[]){
        conn e = new conn();
    }
}
