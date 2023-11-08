import java.awt.Color;
import java.util.Random;


public class RainbowRobot extends Robots {
    private String[] colors = {"ROUGE", "NOIR", "BLEU", "JAUNE", "VERT", "MAGENTA", "GRIS", "VIOLET", "ORANGE"};
    
    private Random random;
    
    //constructeur du RainbowRobot
    public RainbowRobot(int x, int y) {
        super("VERT");
        random = new Random();
        afficherRobot(x,y);
    }
    
    //Methode qui permet de générer une couleur aléatoirement
    public void randomColor() {
        int n = random.nextInt(9); //On génère un nombre n aléatoire entre 1 et 9
        color = colors[n]; //on utilise ce nombre pour récuperer sa couleur correspondante dans la liste
        setColor(color); 
    }

    
    public void avancer(String direction){
        direction = direction.toUpperCase();
        int newX = super.x;
        int newY = super.y;
        switch(direction) {
            case "DROITE":
                newX ++;
                break;
            case "BAS":
                newY ++;
                break;
            case "GAUCHE":
                newX --;
                break;
            case "HAUT":
                newY --;
        }
        randomColor(); 
        afficherRobot(newX,newY);
    }
}



