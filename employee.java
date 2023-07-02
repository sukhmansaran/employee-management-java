import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.io.*;


class jdbc{
    public static void main(String [] args){
        try {
            //creating connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/employee";
            String username = "root";
            String password = "1234";
            Connection con = DriverManager.getConnection(url, username, password);

            //creating table
            String q = "create table empdetail(emp_name varchar(15), emp_fname varchar(15), empID int(7) primary key, emp_email varchar(15), emp_pos varchar(9), emp_con int(10), emp_sal int(10))";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);
            con.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

class mainmenu {
    public void menu() {
        System.out.println("\n\t\t\t  EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("\nPress 1 : To Add an Employee Details");
        System.out.println("Press 2 : To See an Employee Details ");
        System.out.println("Press 3 : To Remove an Employee");
        System.out.println("Press 4 : To Update Employee Details");
        System.out.println("Press 5 : To Exit the EMS Portal");
    }
}

/************************ To add details of Employee *********************/

class emp_add{
    public void add(){

    }
}

class emp_manage {
}
