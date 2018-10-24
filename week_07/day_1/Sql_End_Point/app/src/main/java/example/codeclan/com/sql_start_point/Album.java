package example.codeclan.com.sql_start_point;

/**
 * Created by user on 30/08/2017.
 */

import java.sql.ResultSet;

import db.SqlRunner;

public class Album {

    private String title;
    private String genre;
    private Artist artist;
    private int id;

    public Album(String title, String genre, Artist artist) {
        this.title = title;
        this.genre = genre;
        this.artist = artist;
    }

    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return this.genre;
    }

    public Artist getArtist()  {
        return this.artist;
    }

    public void save() {
        int artist_id = artist.getId();
        String sql = String.format(
                "INSERT INTO albums (title, genre, artist_id) VALUES ('%s', '%s', %d); "
                , this.title, this.genre, artist_id);
        this.id = SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

    public static void all(){
        String sql = "SELECT * FROM albums;";
        ResultSet rs = SqlRunner.executeQuery(sql);
        try {
            while (rs.next()) {
                String name = rs.getString("title");
                String genre = rs.getString("genre");
                int artistId = rs.getInt("artist_id");
                System.out.println(name);
                System.out.println(genre);
                System.out.println(artistId);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + " : " + e.getMessage());
            System.exit(0);
        } finally {
            SqlRunner.closeConnection();
        }
    }


    public static void deleteAll(){
        String sql = "DELETE FROM albums;";
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();

    }

    public void update() {
        String sql = String.format("UPDATE albums SET title = '%s' , SET genre = '%s', SET artist_id = %d " +
                        "WHERE id = %d;",
                this.title, this.genre, this.artist.getId(), this.id
        );
        SqlRunner.executeUpdate(sql);
        SqlRunner.closeConnection();
    }

}