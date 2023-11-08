
/**
 * Décrivez votre classe OrangeRobot ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
import java.util.Random;
/**
 * Write a description of class RobotMagenta here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RobotOrange extends Robots {
    private Random random = new Random();
    
    public RobotOrange(int x, int y) {
        super("ORANGE");
        super.afficherRobot(x, y);
    }
    
     public void bouger() {
          for (int i = 0; i < 5; i++) {
        int newX = random.nextInt(100);
        int newY = random.nextInt(51);
        if(x > 100 || y > 50) {
            newX = 5;
            newY = 5;
        }
        color="ORANGE";
        afficherRobot(newX,newY);
        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     }
    }
    

}


