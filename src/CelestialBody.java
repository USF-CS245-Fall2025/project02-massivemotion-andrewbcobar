import java.awt.*;

public class CelestialBody {
    private int x, y;
    private int xVelo, yVelo;
    private int size;
    private Color color;

    public CelestialBody(int x, int y, int xVelo, int yVelo, int size, Color color) {
        this.x = x;
        this.y = y;
        this.xVelo = xVelo;
        this.yVelo = yVelo;
        this.size = size;
        this.color = color;
    }

    //Draw a circle to be the celestial object
    public void drawMe(Graphics g) {
        g.setColor(this.color);
        g.fillOval(x, y, size/2, size/2);
    }

    //move() method changes position - called on in update()
    public void move() {
        x+=xVelo;
        y+=yVelo;
    }

    //Called on in actionPerformed() to see if object is off screen
    public boolean isOutOfBounds(int width, int height) {
        return (x < -size || x > width + size || y < -size || y > height + size);
    }

    // //Will call move() in sub-classes
    // public abstract void update();
}
