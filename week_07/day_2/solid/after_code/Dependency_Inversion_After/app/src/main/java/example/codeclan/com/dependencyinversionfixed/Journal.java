package example.codeclan.com.dependencyinversionfixed;

/**
 * Created by user on 27/06/2017.
 */

public interface Journal{
    public void write(String text);
    public String readLast();
}
