import javax.swing.JOptionPane;



public class ImageonDriver 
{
    private static Encounters spiderEncounter;
    private static Player player;

    public static void main(String[] args) 
    {
        JOptionPane.showMessageDialog(null, "Welcome to Imageon. \nA text based adventure game by Levi Walker and Samuel Pinnex.");
        
        JOptionPane.showMessageDialog(null, "As a child, Thomas Stone was a very creative boy. \nHis imagination took him to rocky cliffs, undersea coral reefs, and sprawling dungeons with luxuries to discover. \nOur adventure today, takes us to the latter.");
        
        int menuOption = 0;
        do
        {
            menuOption = displayMenu();
            menuSelection(menuOption);
        } while (menuOption != 0);

        player = new Player(100, 12);

        player.addWeapon();
        player.addPotion();

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
        menu += "0. Leave the Imageon, you coward";

        String input = JOptionPane.showInputDialog(menu); 
        return Integer.parseInt(input);

    }

    public static void menuSelection(int menuOption)
    {
        
        switch(menuOption) 
        {
            case 1:
                spiderEncounter = new Encounters();
                spiderEncounter.spiderEncounter();
                break;
            case 2:
                JOptionPane.showMessageDialog(null, player.showInventory(), "~INVENTORY~", JOptionPane.PLAIN_MESSAGE); 
                break;
            case 0:
                goodbyeExit();
                break;
            default:
                error();
                break;
        }

    }

    public static void goodbyeExit()
    {
        JOptionPane.showMessageDialog(null, "Until next time, Thomas...");
    }

    public static void error()
    {
        JOptionPane.showMessageDialog(null, "Invalid input from player. Please retry.", "Try again, Thomas.", JOptionPane.ERROR_MESSAGE);
    }

}
