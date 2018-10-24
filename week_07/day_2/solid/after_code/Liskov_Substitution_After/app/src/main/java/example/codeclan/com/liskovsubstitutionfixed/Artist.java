package example.codeclan.com.liskovsubstitutionfixed;

/**
 * Created by user on 27/06/2017.
 */

class Artist {
    public String drawShape(Shape shape) {
        return "I'm drawing a " + shape.getType().toLowerCase() + "!";
    }
}
