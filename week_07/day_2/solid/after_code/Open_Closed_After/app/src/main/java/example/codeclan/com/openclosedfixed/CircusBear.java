package example.codeclan.com.openclosedfixed;

/**
 * Created by user on 27/06/2017.
 */

public class CircusBear extends Bear{

    private boolean isDancing;

    public String dance(){
        this.isDancing = true;
        return "This is my dancing, don't laugh, bears aren't built for this.";
    }

    // non-essential Annotation to indicate a method which overrides its superclass
    @Override
    public String eat(Edible food){
        if (food.isTreat() && !this.isDancing) {
            return "Can't eat treat if not dancing";
        }

        return super.eat(food);
    }
}
