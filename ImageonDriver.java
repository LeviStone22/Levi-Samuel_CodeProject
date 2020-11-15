import javax.swing.JOptionPane;



public class ImageonDriver 
{


    public static void main(String[] args) 
    {
        JOptionPane.showMessageDialog(null, "Welcome to Imageon. \nA text based adventure game by Levi Walker and Samuel Pinnex.");
        
        JOptionPane.showMessageDialog(null, "As a child, Thomas Stone was a very creative boy. \nHis imagination took him to rocky cliffs, undersea coral reefs, and sprawling dungeons with luxuries to discover. \nOur adventure today, takes us to the latter.");
    
        Player player = new Player(100, 5);
        Encounters spiderEncounter = new Encounters();
        
        // displaymenu();
        // menuSelection(input);  ask Erin about how to call these methods inside of the Driver

        // make RNG that randomly chooses skeleton or spider encounter occur
        // make switch statement, i.e. 1 will call the movement method, 2 will call the attack method, etc
        

        
        System.exit(0);
    }

    public static int displayMenu() 
    {
        String menu = "";  
        menu += "============= What will you do? ==============\n";
        menu += "1. Move to next room\n";
        menu += "2. View Inventory\n";
        menu += "0. Leave the Dungeon, you coward";

        String input = JOptionPane.showInputDialog(menu); 
        return Integer.parseInt(input);

    }

    public static void menuSelection(int menuOption)
    {
        

        switch(menuOption) 
        {
            case 1:
                spiderEncounter.spiderEncounter(); // Ask Erin how to call the Encounter methods from the Encounters class
                break;
            case 2:
                JOptionPane.showMessageDialog(null, player.showInventory()); 
                break;
            case 3:
                cart1.checkOut(); 
                break;
            case 0:
                farewell(); 
                break;
            default:
                error(); 
        }
    }


}
