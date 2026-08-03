import java.sql.*;
import java.util.Scanner;

public class SQLcommands {


    // case 1 : add a course 
    public void add_course(Connection conn, Scanner keyboard) throws SQLException
    {
        Statement st = conn.createStatement();
        System.out.println("Add a course");
        System.out.println("Please input course code: ");
        String CourseCode = keyboard.nextLine().toUpperCase().trim();
        System.out.println("Please input course title: ");
        String CourseTitle = keyboard.nextLine().trim();
        String Query = "Select code from Course where code = '" + CourseCode + "'";
        ResultSet rs = st.executeQuery(Query);
        if (rs.next())
        { 
            System.out.println("Course already exists");
            return;
        }
        Query = "Insert into Course (code, title) values ('" + CourseCode + "', '" + CourseTitle + "')";
        try 
        { 
            st.executeUpdate(Query); 
        }
        catch (SQLException e) 
        { 
            System.out.println("Message: "+ e.getMessage());
        }
        rs.close();
        st.close();
        System.out.println("A new course is added.");
    }

    //case 2 : delete a course
    public void delete_course(Connection conn, Scanner keyboard) throws SQLException
    {
        Statement st = conn.createStatement();
        System.out.println("Delete a course");
        System.out.print("Please input course code: ");
        String CourseCode = keyboard.nextLine().toUpperCase().trim();
        String Query = "Select code from course where code = '" + CourseCode + "'";
        ResultSet rs = st.executeQuery(Query);
        if (!rs.next())
        {
            System.out.println("Course does not exist");
            rs.close();
            st.close();
            return;
        }
        rs.close();

        Query = "Delete from Course where code = '" + CourseCode + "'";
        try 
        { 
            st.executeUpdate(Query);
        }
        catch (SQLException e)
        {
            System.out.println("Message: "+ e.getMessage());
        }
        st.close();
        System.out.println("Course deleted.");

    }


    //case 3 : add a student
    public void add_student(Connection conn, Scanner keyboard) throws SQLException
    { 
        Statement st = conn.createStatement();
        // adding logic to allow users to add multiple students 
        System.out.println("How many students would you like to add?");
        String num_students = keyboard.nextLine().trim();
        int count = Integer.parseInt(num_students);
        while (count > 0) 
        {
            System.out.println("Enter student ssn:");
            String ssn = keyboard.nextLine().trim();
            System.out.println("Enter student name: ");
            String name = keyboard.nextLine().trim();
            System.out.println("Enter student address: ");
            String address = keyboard.nextLine().trim();
            System.out.println("Enter student major: ");
            String major = keyboard.nextLine().trim();
            String Query = "Insert into Student values ('" + ssn + "','" + name + "', '" + address + "', '" + major + "')";
            st.executeUpdate(Query);
            System.out.println("Student added successfully");
            count--;
        }
        st.close();
    
    }

    //case 4 : delete a student
    public void delete_student(Connection conn, Scanner keyboard) throws SQLException
    {

    }

    //case 6 : student registration
    public void student_registration(Connection conn, Scanner keyboard) throws SQLException
    {

    }

    // case 8 handled in driver.java 
}
