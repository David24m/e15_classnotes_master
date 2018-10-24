package example.codeclan.com.liskovsubstitutionfixed;

/**
 * Created by user on 27/06/2017.
 */

abstract class Shape {
    public final String getType(){
        return getClass().getSimpleName();
    }
}
