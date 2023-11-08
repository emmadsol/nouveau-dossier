import java.awt.*;

public class RedRobot extends Robots {
    private int vitesse;
    //le constructeur, où l'on peut initialiser la position du robot au départ.
    public RedRobot(int x, int y) {
        super("ROUGE");
        afficherRobot(x,y);
        vitesse = 1;
    }
    
    //la méthode avancer adaptée à la vitesse du robot. On entre une direction.
    public void avancer(String direction){
        direction = direction.toUpperCase(); //On s'assure que la chaine de caractère est bien en majuscule.
        //On utilise pas directement x et y pour pouvoir vérifier les valeurs
        int newX = super.x;
        int newY = super.y;
        switch(direction) {
            case "DROITE":
                newX += vitesse;
                break;
            case "BAS":
                newY += vitesse;
                break;
            case "GAUCHE":
                newX -= vitesse;
                break;
            case "HAUT":
                newY -= vitesse;
        }
        color="ROUGE";
        afficherRobot(newX, newY);  
    } 
    
    // Augmente la vitesse de 1px
    public void accelerer() {
        vitesse++; 
    }
    
    // Réduire la vitesse de 1px, en s'assurant qu'elle ne devienne pas négative.
    public void ralentir() {
        if (vitesse > 1) {
            vitesse--; 
        }
    }
}