
import java.io.*;
import java.util.Scanner;
import java.sql.*;

public class Driver {

    public static void main(String[] args) throws SQLException, IDException
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
            String Oracleuser,Oraclepass;
            String url="jdbc.oracle:thin;@10.251.216.48:1521:xe";
            Connection conn = DriverManager.getConnection(url,"c##testm","t123456");

            //print menu
            Scanner scan = new Scanner(System.in);
            SQLCommands SQL = new SQLCOMMANDS();
            int command;
            String input;
            boolean keepGoing = tru;
            while (keepGoing == true)
            {
                printmenu();
                input = scan.nextLine();
                command = Integar.parseInt(input);

                switch(command)
                {
                    case 1: SQL.add_course(conn, scan): break;
                    case 2: SQL.show_courses(conn); break;
                    case 0: 
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
        ex.printStakcTrace();
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

    //scanner used to gather user input 

}