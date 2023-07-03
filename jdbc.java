import java.sql.*;
import java.util.*;
import java.io.*;


public class jdbc{
    public static Connection connect(){
        Connection con = null;
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
        return con;
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
            Connection con = jdbc.connect();
            String q = "insert into empdetail values (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Employee Name: ");
            String emp_name = br.readLine();

            System.out.println("Enter Father's Name: ");
            String emp_fname = br.readLine();

            System.out.println("Enter Employee ID: ");
            int emp_id = Integer.parseInt(br.readLine());

            System.out.println("Enter Employee Email ID: ");
            String emp_email = br.readLine();

            System.out.println("Enter Employee Position: ");
            String emp_pos = br.readLine();

            System.out.println("Enter Employee Contact: ");
            int emp_con = Integer.parseInt(br.readLine());

            System.out.println("Enter Employee Salary: ");
            int emp_sal = Integer.parseInt(br.readLine());

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
            String q = "select * from empdetail where empID=?";
            System.out.println("Enter Employee ID: ");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();

            Connection con = jdbc.connect();
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1,id);
            ResultSet set = pstmt.executeQuery();

            while(set.next()){
                String name = set.getString(1);
                String fname = set.getString(2);
                int empid = set.getInt(3);
                String email = set.getString(4);
                String pos = set.getString(5);
                int cont = set.getInt(6);
                int sal = set.getInt(7);

                System.out.println("Employee Name: "+name);
                System.out.println("Employee Father's Name: "+fname);
                System.out.println("Employee Id: "+empid);
                System.out.println("Employee Email ID: "+email);
                System.out.println("Employee Position: "+pos);
                System.out.println("Employee Contact: "+cont);
                System.out.println("Employee Salary: "+sal);

            }
            set.close();
            pstmt.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

/************************ To delete details of Employee *********************/
class emp_dlt extends jdbc{
    public void dlt(){
        try{
            String q = "delete from empdetail where emp_id=?";
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter Employee ID: ");
            String id= sc.nextLine();
            int emp_id = Integer.parseInt(id);

            Connection con = jdbc.connect();
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1,emp_id);
            pstmt.executeUpdate();
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
            System.out.print("To Update Employee Email ID Enter 3: ");
            System.out.print("To Update Employee Position Enter 4: ");
            System.out.print("To Update Employee Contact Enter 5: ");
            System.out.print("To Update Employee Salary Enter 6: ");
            System.out.print("Cannot Update Employee ID ");

            String q;
            String stri= sc.nextLine();
            int str = Integer.parseInt(stri);
            switch (str) {
                case 1 -> {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter New Name: ");
                    String name = br.readLine();

                    System.out.println("Enter Employee ID: ");
                    int emp_id = Integer.parseInt(br.readLine());

                    q = "update empdetail set emp_name=? where emp_id=?";

                    Connection con = jdbc.connect();
                    PreparedStatement pstmt = con.prepareStatement(q);
                    pstmt.setString(1,name);
                    pstmt.setInt(2,emp_id);
                    pstmt.executeUpdate();
                }
                case 2 -> {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter New Father's Name: ");
                    String fname = br.readLine();

                    System.out.println("Enter Employee ID: ");
                    int emp_id = Integer.parseInt(br.readLine());

                    q = "update empdetail set emp_fname=? where emp_id=?";

                    Connection con = jdbc.connect();
                    PreparedStatement pstmt = con.prepareStatement(q);
                    pstmt.setString(1,fname);
                    pstmt.setInt(2,emp_id);
                    pstmt.executeUpdate();
                }
                case 3 -> {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter New Email: ");
                    String email = br.readLine();

                    System.out.println("Enter Employee ID: ");
                    int emp_id = Integer.parseInt(br.readLine());

                    q = "update empdetail set emp_email=? where emp_id=?";

                    Connection con = jdbc.connect();
                    PreparedStatement pstmt = con.prepareStatement(q);
                    pstmt.setString(1,email);
                    pstmt.setInt(2,emp_id);
                    pstmt.executeUpdate();
                }
                case 4 -> {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter New Position: ");
                    String pos = br.readLine();

                    System.out.println("Enter Employee ID: ");
                    int emp_id = Integer.parseInt(br.readLine());

                    q = "update empdetail set emp_pos=? where emp_id=?";

                    Connection con = jdbc.connect();
                    PreparedStatement pstmt = con.prepareStatement(q);
                    pstmt.setString(1,pos);
                    pstmt.setInt(2, emp_id);
                    pstmt.executeUpdate();
                }
                case 5 -> {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter New Contact: ");
                    int cont = Integer.parseInt(br.readLine());

                    System.out.println("Enter Employee ID: ");
                    int emp_id = Integer.parseInt(br.readLine());

                    q = "update empdetail set emp_con=? where emp_id=?";

                    Connection con = jdbc.connect();
                    PreparedStatement pstmt = con.prepareStatement(q);
                    pstmt.setInt(1,cont);
                    pstmt.setInt(2,emp_id);
                    pstmt.executeUpdate();
                }
                case 6 -> {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter New Salary: ");
                    int sal = Integer.parseInt(br.readLine());

                    System.out.println("Enter Employee ID: ");
                    int emp_id = Integer.parseInt(br.readLine());

                    q = "update empdetail set emp_sal=? where emp_id=?";

                    Connection con = jdbc.connect();
                    PreparedStatement pstmt = con.prepareStatement(q);
                    pstmt.setInt(1,sal);
                    pstmt.setInt(2,emp_id);
                    pstmt.executeUpdate();
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

/************************ To Exit from the EMS Portal *********************/

class CodeExit {
    public void out() {
        System.out.println("\n*****************************************");
        System.out.println("Thank You For Using our Software :) ");
        System.out.println("*****************************************");
        System.exit(0);
    }
}

/***************************** Main Class *******************************/
class EmployManagementSystem {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");

        Scanner sc=new Scanner(System.in);
        emp_view epv =new emp_view();

        int i=0;
        mainmenu obj1 = new mainmenu();
        obj1.menu();

        while(i<6) {
            System.out.print("\nPlease Enter choice :");
            i=Integer.parseInt(sc.nextLine());

            switch (i) {
                case 1 -> {
                    emp_add ep = new emp_add();
                    ep.add();

                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                }
                case 2 -> {
                    emp_view ep = new emp_view();
                    ep.view();

                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                }
                case 3 -> {
                    emp_dlt epr = new emp_dlt();
                    epr.dlt();

                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                }
                case 4 -> {
                    emp_update epr = new emp_update();
                    epr.update();

                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    obj1.menu();
                    break;
                }
                case 5 -> {
                    CodeExit obj = new CodeExit();
                    obj.out();
                }
            }
        }
    }
}