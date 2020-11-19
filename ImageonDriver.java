import javax.swing.JOptionPane;
import java.util.Random;

// ask Erin how to change the health during battle (in the toString for spider/skeleton)

public class ImageonDriver 
{
    private static Encounters spiderEncounter;
    private static Encounters skeletonEncounter;
    private static Player player = new Player(100, 12);
    private static Random randy;

    public static void main(String[] args) 
    {
        JOptionPane.showMessageDialog(null, "Welcome to Imageon. \n\nA text based adventure game by Levi Walker and Samuel Pinnex.");
        
        JOptionPane.showMessageDialog(null, "As a child, Thomas Stone was a very creative boy. \n\nHis imagination took him to rocky cliffs, undersea coral reefs, and sprawling dungeons with luxuries to discover. \n\nOur adventure today, takes us to the latter.");
        
        JOptionPane.showMessageDialog(null, "While drinking a Capri Sun, Thomas looked at the ground and picked up a stick. \n\nThis stick would be his sword, and his beverage his potion. \n\nThomas closed his eyes and took a deep breath. When he opened them, he was inside his Imageon.");

        int menuOption = 0;
        do
        {
            menuOption = displayMenu();
            menuSelection(menuOption);
        } while (menuOption != 0);

        

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
            randy = new Random();
            int num = randy.nextInt(2);
    
            if(num == 0)
            {
                spiderEncounter = new Encounters();
                spiderEncounter.spiderEncounter(); // after 3 encounters, the boss is triggered. figure this out and we are home free more or less
            }
            else
            {
                skeletonEncounter = new Encounters();
                skeletonEncounter.skeletonEncounter();
            } 
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
