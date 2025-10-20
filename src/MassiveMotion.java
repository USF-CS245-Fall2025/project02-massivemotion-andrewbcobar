import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class MassiveMotion extends JPanel implements ActionListener {

    protected Timer tm;
    private List<CelestialBody> bodies; //List of all Celestial Bodies


    //From Properties file
    private int windowX, windowY;
    private int timerDelay;
    private String listType;
    //Initial Star = center of solar system
    private int starPosX, starPosY, starSize, starVeloX, starVeloY;
    
    //
    private double genX, genY;
    private int bodySize, bodyVelo;

    /*
     * Constructor MassiveMotion() 
     *      call in main method with the txt file read in from command line
     *      using java.util.Properties, read file and instantiate instance variables
     */
    public MassiveMotion(String propfile) {
        Properties props = new Properties();
        try (FileReader reader = new FileReader(propfile)) { 
            props.load(reader);
            System.out.println("test? loading from " + propfile);
        } catch (IOException e) {
            System.out.println("error reading file " + propfile);
        }

        timerDelay = Integer.parseInt(props.getProperty("timer_delay"));
        listType = props.getProperty("list");
        windowX = Integer.parseInt(props.getProperty("window_size_x"));
        windowY = Integer.parseInt(props.getProperty("window_size_y"));

        starPosX = Integer.parseInt(props.getProperty("star_position_x"));
        starPosY = Integer.parseInt(props.getProperty("star_position_y"));
        starSize = Integer.parseInt(props.getProperty("star_size"));
        starVeloX = Integer.parseInt(props.getProperty("star_velocity_x"));
        starVeloY = Integer.parseInt(props.getProperty("star_velocity_y"));

        genX = Double.parseDouble(props.getProperty("gen_x"));
        genY = Double.parseDouble(props.getProperty("gen_y"));
        bodySize = Integer.parseInt(props.getProperty("body_size"));
        bodyVelo = Integer.parseInt(props.getProperty("body_velocity"));



        //Reads the listType from the property file. Instantiates list depending on listType
        if (listType.equals("arraylist")) {
            bodies = new ArrayList<CelestialBody>();
        } else if (listType.equals("single")) {
            bodies = new SingleLinkedList<CelestialBody>();
        } else if (listType.equals("double")) {
            bodies = new DoubleLinkedList<CelestialBody>();
        } else if (listType.equals("dummy head")) {
            bodies = new DummyHeadLinkedList<CelestialBody>();
        }

        //Create a CelestialBody of type Star using all of the values read from property file, and add to the list
        Star star = new Star(starPosX, starPosY, starVeloX, starVeloY, starSize, Color.RED);
        bodies.add(star);


        //Instantiate timer using timerDelay and start it for animations
        tm = new Timer(timerDelay, this);
        tm.start();
    }

    /*
     *  paintComonent()
     *      using a for-loop, draw all of the celestial objects within bodies list
     *      bodies.get(0) is the center star
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Probably best you leave this as is.

        //Color of Space
        g.setColor(new Color(21, 22, 38));
        //Fill a rect of the color of space to fill up the whole window
        g.fillRect(0, 0, windowX, windowY);

        //Using a standard for-loop, draw all celestial bodies in the bodies list
        for (int i = 0; i<bodies.size(); i++) {
            CelestialBody body = bodies.get(i);
            body.drawMe(g);
        }
    }


    /*
     * actionPerformed()
     *      updates based on timerDelay
     *      this methods will call update() of the CelestialBody class
     *      removes any comets that move offscreen
     *      using the property values of gen_x and gen_y, adds comets that...
     *          spawn in a random location off screen
     *          moves in a random direction
     *      call repaint() to continuously update the screen
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //Move all of the celestial bodies. Use a standard for-loop
        for (int i = 0; i<bodies.size(); i++) {
            CelestialBody body = bodies.get(i);
            body.update(); //this abstract method will call upon the move() method
        }

        //If a comet moves off screen, remove it from the list
        //Use a helper boolean method within the CelestialBody class
        for (int i = 0; i<bodies.size(); i++) {
            CelestialBody body = (CelestialBody) bodies.get(i);
            if(body.isOutOfBounds(windowX, windowY)) {
                bodies.remove(i);
                i--;
            }
        }
        
        //gen_x percent chance of comet moving left or right
        if(Math.random() < genX) {   
            fromTopOrBottom();
        }
        if (Math.random() < genY) {
            fromLeftOrRight();
        }
        repaint();
    }


    /*
     * Helper Method: fromTopOrBottom()
        *  this private method is called in actionPerformed every second
        *  boolean fromTop is 50% true or false by using the Math.random()
        *  position variables x and y are used
        *  x is a random value from 0 to the height of the window
        *  the value of y depends on the fromLeft random boolean.
        *      if true, y = 0 (Top)
        *      if false, y = height of the window
        *  vx and vy are the random velocity values using helper method random velocity
        *  vertical velocity is dependent on if fromLeft is true or false
        *      if true, comet is moving down (y+=yv)
        *      if false, comet is moving up (y-=yv)
        * using the x and y position, the horizontal and vertical velocity, add a new comet to the list of celestial bodies
     */
    private void fromTopOrBottom() {
        boolean fromTop = Math.random() < 0.5;
        int x = (int)(Math.random() * windowX);
        int y = fromTop ? 0 : windowY;
        System.out.println("x pos = " + x + "\ty pos = " + y);
        int vx = randomVelocity(bodyVelo);
        int vy = fromTop ? Math.abs(randomVelocity(bodyVelo)) : -Math.abs(randomVelocity(bodyVelo));

        bodies.add( new Comet (x, y, vx, vy, bodySize, Color.WHITE));

    }



    /*
     * Helper Method: fromLeftOrRight()
        *  this private method is called in actionPerformed every second
        *  boolean fromLeft is 50% true or false by using the Math.random()
        *  position variables x and y are used
        *  y is a random value from 0 to the height of the window
        *  the value of x depends on the fromLeft random boolean.
        *      if true, x = 0 (Left)
        *      if false, x = width of the window
        *  vx and vy are the random velocity values using helper method random velocity
        *  horizontal velocity is dependent on if fromLeft is true or false
        *      if true, comet is moving right (x+=xv)
        *      if false, comet is moving left (x-=xv)
        * using the x and y position, the horizontal and vertical velocity, add a new comet to the list of celestial bodies
     */
    private void fromLeftOrRight() {
        boolean fromLeft = Math.random() < 0.5;
        int y = (int) (Math.random() * windowY);
        int x = fromLeft ? 0: windowX;
        System.out.println("x pos = " + x + "\ty pos = " + y);
        int vx = fromLeft ? Math.abs(randomVelocity(bodyVelo)) : -Math.abs(randomVelocity(bodyVelo));
        int vy = randomVelocity(bodyVelo);

        bodies.add( new Comet(x, y, vx, vy, bodySize, Color.WHITE));
    }
    

    /*
     * Helper Method randomVelocity()
        *  Takes a velocity range of v 
        *      i.e. 3
        *  returns a random value between v and -v that is not 0
        *  
     */
    private int randomVelocity(int v) {
        int random = 0; //return value
        while (random == 0) {
            random = (int) (Math.random() * (2 * v+1)) - v;
        }
        return random;
    }

    //getter methods for jframe setsize within the main method
    public int getWindowX() { return windowX;}
    public int getWindowY() { return windowY; }

    public static void main(String[] args) {
        System.out.println("Massive Motion starting...");
        // MassiveMotion mm = new MassiveMotion(args[0]);
        MassiveMotion mm = new MassiveMotion("MassiveMotion.txt");

        JFrame jf = new JFrame();
        jf.setTitle("Massive Motion");
        jf.setSize(mm.getWindowX(), mm.getWindowY()); 
        jf.add(mm);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}