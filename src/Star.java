import java.awt.*;

public class Star extends CelestialBody {

    //Call super() constructor of Parent Class CelestialBody
    public Star(int x, int y, int xVelo, int yVelo,int size, Color color) {
        super(x, y, xVelo, yVelo, size, color);
    }

    //Method to be called in actionPerformed
    public void update() {
        move();
    }

}
