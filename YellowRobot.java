
/**
 * Décrivez votre classe YellowRobot ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class YellowRobot extends Robots
{
    public YellowRobot(int x, int y) {
        super("JAUNE");
        super.afficherRobot(x,y);
    }
    //la méthode qui permet au robot de se déplacer en diagonales.
    public void avancer(String direction){
        direction = direction.toUpperCase();
        int newX = super.x;
        int newY = super.y;
        switch(direction) {
            case "DROITE":
                super.x ++;
                super.y ++;
                break;
            case "GAUCHE":
                super.x --;
                super.y ++;
                break;
        }
        color="JAUNE";
        afficherRobot(newX,newY);
    }
}
    