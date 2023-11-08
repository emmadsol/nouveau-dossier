import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Draws robots on a canvas.
 * 
 * @author Patrick Girard 
 * @version 2021.08
 */

public class World {
    static private Canvas canvas = Canvas.getCanvas(); 
    static private Random randomGenerator;
    static private ArrayList<Robots> listeDesRobots = new ArrayList<>();
    
    private int n = 0;
    private int lo = 31;
    private int la = 30;
    private int plo = 8;
    private int pla = 10;
    private int tlo = 26;
    private int tla = 13;
    private int qla = 4;
    private int milieu = 240;
    static private String colourBody ="";
    static private String colourLeg = "NOIR";
    static private String colourEye = "NOIR";
    private Integer corps;
    private Integer brasG;
    private Integer brasD;
    private Integer jambeG;
    private Integer jambeD;
    private Integer tete;
    private Integer oeilD;
    private Integer oeilG;
    public World ( String colourBody )
    {
        // The random generator is instanciated if necessary
        if (randomGenerator == null) randomGenerator = new Random();
        // The different objects of the robot are instanciated, to allow the process of identification 
        // of graphical objects in the canvas. 
        corps = new Integer(randomGenerator.nextInt());
        brasG = new Integer(randomGenerator.nextInt());
        brasD = new Integer(randomGenerator.nextInt());
        jambeG = new Integer(randomGenerator.nextInt());
        jambeD = new Integer(randomGenerator.nextInt());
        tete = new Integer(randomGenerator.nextInt());
        oeilD = new Integer(randomGenerator.nextInt());
        oeilG = new Integer(randomGenerator.nextInt());

        this.colourBody = colourBody;
        
    }
      public static ArrayList getList() {
        return listeDesRobots;
    }
      public static void setList(Robots robot) {
        listeDesRobots.add(robot);
    }
    public static void setColourbody(String color) {
        colourBody = color;
    }
    public void afficherRobot(int x, int y){
        int xp = x*10 ;
        int yp = y*10 ;
        Canvas canvas = Canvas.getCanvas(); 
        canvas.draw(brasG, colourLeg, new Rectangle(xp, yp+15, 
                                     plo, pla));
        canvas.draw(brasD, colourLeg, new Rectangle(xp+la+2, yp+15, 
                                     plo, pla));
        canvas.draw(jambeG, colourLeg, new Rectangle(xp+10, yp+40, 
                                     plo, pla));
        canvas.draw(jambeD, colourLeg, new Rectangle(xp+la-8, yp+40, 
                                     plo, pla));
        canvas.draw(tete, colourBody, new Rectangle(xp+14, yp, 
                                     tla, tlo));
        canvas.draw(oeilG, colourEye, new Ellipse2D.Double(xp+14, yp+2, 
                                     qla, qla));
        canvas.draw(oeilD, colourEye, new Ellipse2D.Double(xp+21, yp+2, 
                                     qla, qla));
        canvas.draw(corps, colourBody, new Rectangle(xp+5, yp+12, 
                                     la, lo));
    }
    public void afficherCollision(int x, int y) {
        //On fait clignoter le robot un petit temps lors d'une collision
    for (int i = 0; i < 4; i++) {
        colourBody="ROUGE";
        afficherRobot(x, y);
        // Pause de 200 milliseconds.
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        colourBody="NOIR";
        afficherRobot(x, y);
        // Pause de 200 milliseconds.
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
    }
    
