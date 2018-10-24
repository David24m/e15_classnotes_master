package example.codeclan.com.employee_starter;

/**
 * Created by user on 30/08/2017.
 */

import java.sql.ResultSet;
import java.util.ArrayList;

import db.SqlRunner;

public class Department {
    private int id;
    private String title;

    public Department(String title) {
        this.title = title;
    }

    public Department(int id, String title) {
        this(title);
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void save() {
        String sql = String.format("INSERT INTO departments (title) VALUES ('%s');", title);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void deleteAll(){
        String sql = "DELETE FROM departments;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void delete() {
        String sql = String.format("DELETE FROM departments WHERE id = %d;", this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void update(){
        String sql = String.format("UPDATE departments SET title = '%s' WHERE id = %d;", this.title, this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }


    public static void all(){
        String sql = "SELECT * FROM departments;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try{
            while( rs.next() ){
                String title = rs.getString("title");
                System.out.println(title);
            }
        } catch( Exception e){
            System.err.println( e.getClass().getName() + " : " + e.getMessage() );
            System.exit(0);
        }finally{
            SqlRunner.closeConnection();
        }
    }

    public static Department getDepartmentByTitle(String titleToSearch){
        String sql = String.format
                ("SELECT * FROM departments WHERE departments.title = '%s';", titleToSearch);
        ResultSet rs = SqlRunner.executeQuery(sql);
        Department department = null;
        try{
            if( rs.next() ){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                System.out.println(title);
                department = new Department(id, title);
            }
            return department;
        } catch( Exception e){
            System.err.println( e.getClass().getName() + " : " + e.getMessage() );
            System.exit(0);
        }finally{
            SqlRunner.closeConnection();
            return department;
        }
    }
}