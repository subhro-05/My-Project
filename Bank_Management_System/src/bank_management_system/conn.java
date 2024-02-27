package bank_management_system;
import java.sql.*;

public class conn {
    Connection con;
    Statement s;
    public conn(){
        try{
            con=null;
            String url="jdbc:mysql://localhost:3306/";
            String db="bank";
            String driver="com.mysql.jdbc.Driver";
            String username="root";
            Class.forName(driver).newInstance();
            con=DriverManager.getConnection(url+db+username+"");
            s= con.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
