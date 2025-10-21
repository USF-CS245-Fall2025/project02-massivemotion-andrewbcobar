import java.awt.*;


public class Comet extends CelestialBody {
    
    //Call super() constructor of Parent Class CelestialBody
    public Comet(int x, int y, int vx, int vy, int size, Color color) {
        super(x, y, vx, vy, size, color);
    }

    //Method to be called in actionPerformed
    @Override
    public void update() {
        move();
    }
}
