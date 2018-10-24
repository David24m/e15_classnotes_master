package example.codeclan.com.sql_start_point;

/**
 * Created by user on 30/08/2017.
 */

import java.sql.ResultSet;

import db.SqlRunner;

public class Artist {

    private String name;
    private int id;

    public static void deleteAll(){
        String sql = "DELETE FROM artists;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void delete() {
        String sql = String.format("DELETE FROM artists WHERE id = %d;", this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public void update(){
        String sql = String.format("UPDATE artists SET name = '%s' WHERE id = %d;", this.name, this.id);
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }


    public static void all(){
        String sql = "SELECT * FROM artists;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try{
            while( rs.next() ){
                String name = rs.getString("name");
                System.out.println(name);
            }
        } catch( Exception e){
            System.err.println( e.getClass().getName() + " : " + e.getMessage() );
            System.exit(0);
        }finally{
            SqlRunner.closeConnection();
        }
    }





    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }


    public void save() {
        String sql = String.format("INSERT INTO artists (name) VALUES ('%s');", name);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }




}