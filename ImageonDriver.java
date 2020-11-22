import javax.swing.JOptionPane;
import java.util.Random;

// ask Erin how to change the health during battle (in the toString for spider/skeleton)

public class ImageonDriver 
{
    private static Encounters spiderEncounter = new Encounters();
    private static Encounters skeletonEncounter = new Encounters();
    private static Player player = new Player();
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
                int remPlayerHealth = spiderEncounter.spiderEncounter(player.getPlayerHealth()); // after 3 encounters, the boss is triggered.
                player.setPlayerHealth(remPlayerHealth);
            }
            else
            {
                int remPlayerHealth = skeletonEncounter.skeletonEncounter(player.getPlayerHealth());
                player.setPlayerHealth(remPlayerHealth);
            } 
                break;
            case 2:
                JOptionPane.showMessageDialog(null, player.showInventory(), "~INVENTORY~", JOptionPane.PLAIN_MESSAGE); 
                JOptionPane.showMessageDialog(null, "Your total damage is " + player.getTotalDamage() + ".");
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


} // end of ImageonDriver.java
