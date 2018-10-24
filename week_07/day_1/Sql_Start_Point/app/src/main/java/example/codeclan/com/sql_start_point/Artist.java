package example.codeclan.com.sql_start_point;

/**
 * Created by user on 30/08/2017.
 */

import db.SqlRunner;

public class Artist {

    private String name;
    private int id;

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
        String sql = "";
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }


}