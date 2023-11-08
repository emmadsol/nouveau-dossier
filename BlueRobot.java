
/**
 * Décrivez votre classe BlueRobot ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */


public class BlueRobot extends Robots {
    private int tourner;
    
    public BlueRobot(int x, int y) {
        super("BLEU");
        tourner= 0;
        afficherRobot(x,y);
    }

    public void tourner() {
        if(tourner<3){
            tourner++;
        }else{
            tourner=0;
        }
    }

    public void avancer(){
        int newX = super.x;
        int newY = super.y;
        switch(tourner){
        case 0: 
            newX++;
            break;
        case 1:
            newY++;
            break;
        case 2:
             newX--;
             break;
        case 3: 
             newY--;
            break; 
        }
        color ="BLEU";
        afficherRobot(newX,newY);
        tourner();
    }
    
}


