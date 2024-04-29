
package electricity_billing_system;

import java.sql.*;
public class Conn {
    Connection c;
    Statement s,s1;
    Conn(){
        try{
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs","root","$uBHrO@&123");
            s= c.createStatement();
//            s1=c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
