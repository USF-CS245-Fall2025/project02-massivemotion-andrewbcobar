import java.awt.*;

/**
 * CelestialBody class represents a generic celestial object with position, velocity, size, and color.
 * It provides methods to draw itself, move based on its velocity, and check if it is out of bounds.
 */
public class CelestialBody {
    /**
     * Instance variables for position (x, y), velocity (xVelo, yVelo), size, and color.
     */
    private int x, y;
    private int xVelo, yVelo;
    private int size;
    private Color color;

    /**
     * Constructor to initialize a CelestialBody with given parameters.
     */
    public CelestialBody(int x, int y, int xVelo, int yVelo, int size, Color color) {
        this.x = x;
        this.y = y;
        this.xVelo = xVelo;
        this.yVelo = yVelo;
        this.size = size;
        this.color = color;
    }

    /**
     * Draws the celestial body as a filled oval
     */
    public void drawMe(Graphics g) {
        g.setColor(this.color);
        g.fillOval(x, y, size/2, size/2);
    }

    /**
     * Moves the celestial body by updating its position based on its velocity.
     */
    public void move() {
        x+=xVelo;
        y+=yVelo;
    }

    /**
     * Checks if the celestial body is out of the given bounds.
     */
    public boolean isOutOfBounds(int width, int height) {
        return (x < -size || x > width + size || y < -size || y > height + size);
    }
}
