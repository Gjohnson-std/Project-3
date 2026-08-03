//import necessary packages 
//import java.io.*;
import java.util.Scanner;
import java.sql.*;

//public class print menu (Driver) 
public class Driver {

    //Oracle database username and password
    static String Oracleuser = "c##testm";
    static String Oraclepass = "t123456";
    
    public static void main(String[] args) throws SQLException
    {
        //connecting to database server (oracle)
        try 
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
    
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Could not load the driver");
        }
        //connect to oracle and validate the username and password 
        try 
        {
            String url = "jdbc:oracle:thin:@10.251.216.48:1521:xe";
            Connection conn = DriverManager.getConnection(url, Oracleuser, Oraclepass);
            Scanner scan = new Scanner(System.in);
            SQLcommands SQL = new SQLcommands();
            int command;
            String input;
            boolean keepGoing = true;
            while (keepGoing == true)
            {
                printmenu();
                input = scan.nextLine();
                command = Integer.parseInt(input);

                switch(command)
                {
                    case 1: SQL.add_course(conn, scan); break;
                    case 2: SQL.delete_course(conn, scan); break;
                    case 3: SQL.add_student(conn, scan); break;
                    case 4: SQL.delete_student(conn, scan); break;
                    case 6: SQL.student_registration(conn, scan); break;
                    case 8: 
                        System.out.println("The session has ended, Thank you!");
                        keepGoing = false;
                        conn.close(); 
                        break;
                }
            }
        } 
        catch (SQLException ex)
        {
        System.out.println("An error occured when connecting to the database server.");
        ex.printStackTrace();
        }
    }
    //making the start screen 
    public static void printmenu()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("***                                             ***");
        System.out.println("***     Welcome to Online Registration System   ***");
        System.out.println("***                                             ***");
        System.out.println("***************************************************");
        System.out.println(" 1. Add a course");
        System.out.println(" 2. Delete a course");
        System.out.println(" 3. Add a student");
        System.out.println(" 4. Delete a Student");
        System.out.println(" 5. Register a course(optional)");
        System.out.println(" 6. Check student registration");
        System.out.println(" 7. Upload grades(optional)");
        System.out.println(" 8. Quit");

    }

    static class UserInput {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Type the number corresponding to the action you want to perform: ");
            int number = Integer.parseInt(scan.nextLine());
        }
    }

}
