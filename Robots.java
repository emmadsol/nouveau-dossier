import java.util.ArrayList;
/**
 * Classe mère Robots.
 *
 * @author groupe 7
 * @version novembre 2023
 */
public class Robots {
    protected int x;  // Coordonnée x sur le canvas
    protected int y;  // Coordonnée y sur le canvas
    private World world;
    private Boolean position = true; 
    protected String color;
    private int width = 4;
    private int height = 5;
    public Robots(String colorRobot){
        color = colorRobot;
        world = new World(color);
        World.setList(this);
    }
    //getters pour récupérer la position du robot
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
    //setter pour eventuellement changer la couleur du robot
    public void setColor(String color) {
        this.color = color;
    }
    
    //vérifie si le robot ne sort pas du Canva, si il sort, le replace en haut à gauche du canvas
    public void goodPosition(){
        if (this.y<50 && this.y>=0 && this.x<100 && this.x>=0){
            position = true;
        }else{
            position = false;
            System.out.println("Le robot sort du canvas");
            //Le robot est replacé en haut du canvas
            x=0;
            y=0;
        }
    }
    
    //Vérifie que le robot ne rentre pas en collision avec un autre
     public boolean collision(int newX, int newY) {  
        ArrayList<Robots> listeRobots = new ArrayList<>();
        listeRobots = World.getList();
        for (Robots otherRobot : listeRobots ) {
            //On ne compare pas le robot à ses propres données
            if (this != otherRobot){
                //on créer une hitbox autour du robot
                if(newX < otherRobot.getX() + width && newX + width > otherRobot.getX() &&
                newY < otherRobot.getY() + height && newY + height > otherRobot.getY()) {
                System.out.println("Attention, collision ! Prenez donc un autre chemin...");
                return false;
                
                }
            }
        }
        return true;
    }
    
    // Affiche le robot si il remplit les conditions,sinon le place en haut à gauche
    public void afficherRobot(int newX, int newY) {
        goodPosition(); 
        world.setColourbody(color);
        if(collision(newX,newY)){
            x = newX;
            y = newY;
        }else{
            world.afficherCollision(newX,newY);
        }
        world.afficherRobot(x,y);
    }
    

}