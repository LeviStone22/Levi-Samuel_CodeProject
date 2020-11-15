import javax.swing.JOptionPane;



public class ImageonDriver 
{


    public static void main(String[] args) 
    {
        JOptionPane.showMessageDialog(null, "Welcome to Imageon. \nA text based adventure game by Levi Walker and Samuel Pinnex.");
        
        JOptionPane.showMessageDialog(null, "As a child, Thomas Stone was a very creative boy. \nHis imagination took him to rocky cliffs, undersea coral reefs, and sprawling dungeons with luxuries to discover. \nOur adventure today, takes us to the latter.");
    
        Player player = new Player(100, 5);
    

        // make RNG that randomly chooses skeleton or spider encounter occur
        // make switch statement, i.e. 1 will call the movement method, 2 will call the attack method, etc
        

        
        System.exit(0);
    }



}
