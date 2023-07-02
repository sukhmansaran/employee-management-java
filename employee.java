import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;
import java.io.*;


class jdbc{
    protected static Connection con;
    public void connect(){
        try {
            //creating connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/employee";
            String username = "root";
            String password = "1234";
            con = DriverManager.getConnection(url, username, password);

            //creating table
//            String q = "create table empdetail(emp_name varchar(15), emp_fname varchar(15), empID int(7) primary key, emp_email varchar(15), emp_pos varchar(9), emp_con int(10), emp_sal int(10))";
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate(q);
//            con.close();

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

class emp_add extends jdbc{
    public void add(){
        try{
            String q = "insert into empdetail values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Employee Name: ");
            String emp_name = br.readLine();

            System.out.println("Enter Father's Name: ");
            String emp_fname = br.readLine();

            System.out.println("Enter Employee ID: ");
            String empid = br.readLine();
            int emp_id = Integer.parseInt(empid);

            System.out.println("Enter Employee Email ID: ");
            String emp_email = br.readLine();

            System.out.println("Enter Employee Position: ");
            String emp_pos = br.readLine();

            System.out.println("Enter Employee Contact: ");
            String empcon = br.readLine();
            int emp_con = Integer.parseInt(empcon);

            System.out.println("Enter Employee Salary: ");
            String empsal = br.readLine();
            int emp_sal = Integer.parseInt(empsal);

            pstmt.setString(1,emp_name);
            pstmt.setString(2,emp_fname);
            pstmt.setInt(3,emp_id);
            pstmt.setString(4,emp_email);
            pstmt.setString(5,emp_pos);
            pstmt.setInt(6,emp_con);
            pstmt.setInt(7,emp_sal);
            pstmt.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

/************************ To view details of Employee *********************/
class emp_view extends jdbc{
    public void view(){
        try{
            String q = "select * from empdetail";
            PreparedStatement pstmt = con.prepareStatement(q);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}


/************************ To update details of Employee *********************/
class emp_update extends jdbc{
    public void update(){
        try {
            Scanner sc= new Scanner(System.in);
            System.out.print("To Update Employee Name Enter 1: ");
            System.out.print("To Update Father's Name Enter 2: ");
            System.out.print("To Update Employee ID Enter 3: ");
            System.out.print("To Update Employee Email ID Enter 4: ");
            System.out.print("To Update Employee Position Enter 5: ");
            System.out.print("To Update Employee Contact Enter 6: ");
            System.out.print("To Update Employee Salary Enter 7: ");

            String stri= sc.nextLine();
            int str = Integer.parseInt(stri);
            switch (str) {
                case 1:
                    System.out.println("Enter New Name: ");
                    Scanner s1= new Scanner(System.in);
                    String st1= s1.nextLine();
                    break;
                case 2:
                    System.out.println("Enter New Name: ");
                    Scanner s2= new Scanner(System.in);
                    String st2= s2.nextLine();
                    break;
                case 3:
                    System.out.println("Enter New Employee ID: ");
                    Scanner s3= new Scanner(System.in);
                    String st3= s3.nextLine();
                    break;
                case 4:
                    System.out.println("Enter New Email ID: ");
                    Scanner s4= new Scanner(System.in);
                    String st4= s4.nextLine();
                    break;
                case 5:
                    System.out.println("Enter New Employee Position: ");
                    Scanner s5= new Scanner(System.in);
                    String st5= s5.nextLine();
                    break;
                case 6:
                    System.out.println("Enter New Employee Contact: ");
                    Scanner s6= new Scanner(System.in);
                    String st6= s6.nextLine();
                    break;
                case 7:
                    System.out.println("Enter New Employee Salary");
                    Scanner s7= new Scanner(System.in);
                    String st7= s7.nextLine();
                    break;
            }
            String q = "update empdetail";
            PreparedStatement pstmt = con.prepareStatement(q);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}