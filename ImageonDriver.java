import javax.swing.JOptionPane;
import java.util.Random;

/**
* ---------------------------------------------------------------------------
* File name: ImageonDriver.java
* Project name: LS_Code
* ---------------------------------------------------------------------------
* Creator's name and email: Levi Walker, walkerls@etsu.edu
                            Samuel Pinnex, pinnexs@etsu.edu
* Course: CSCI 1250-900
* Creation Date: November 12, 2020
* ---------------------------------------------------------------------------
**/



/**
 * This is the ImageonDriver class that is used to drive the entire program and holds the switch-statement with the different menu options 
 * for the player's interaction with the game. 
 * 
 * 
 * Created by Samuel Pinnex, Levi Walker
 * Created on 11/12/2020
 */
public class ImageonDriver 
{
    private static Encounters spiderEncounter = new Encounters();       // creates the new Encounter object by the name of spiderEncounter
    private static Encounters skeletonEncounter = new Encounters();     // creates the new Encounter object by the name of skeletonEncounter 
    private static Player player = new Player();        // creates new Player object to be used in the program, this is the only one
    private static Random randy;        // creates the new random generator object by the name of randy



    /**
     * This is the main method used in the Driver and holds the introductory messages for the user to introduce them to the program and 
     * provides lore and an immersive introduction to the game
     * 
     * Created By: Samuel Pinnex, Levi Walker
     * Date Created: 11/12/2020
     * @param args
     */
    public static void main(String[] args) 
    {
        JOptionPane.showMessageDialog(null, "Welcome to Imageon. \n\nA text based adventure game by Levi Walker and Samuel Pinnex.");
        
        JOptionPane.showMessageDialog(null, "As a child, Thomas Stone was a very creative boy. \n\nHis imagination took him to rocky cliffs, undersea coral reefs, and sprawling dungeons with luxuries to discover. \n\nOur adventure today, takes us to the latter.");
        
        JOptionPane.showMessageDialog(null, "While drinking a Capri Sun, Thomas looked at the ground and picked up a stick. \n\nThis stick would be his sword, and his beverage his potion. \n\nThomas closed his eyes and took a deep breath. When he opened them, he was inside his Imageon.");

        int menuOption = 0;     // assigns the menuOption variable to a empty String
        do      // this do-while statement is used to end the program if the menu option "0" is chosen
        {
            menuOption = displayMenu();     // calls the displayMenu() method and assigns the menuOption to it
            menuSelection(menuOption);      // calls the menuSelection() method with the menuOption inside of its parameters
        } while (menuOption != 0);

        player.addWeapon();     // calls the addWeapon() method using the player object, this gives the player their weapon to deal damage with
        player.addPotion();     // calls the addPotion() method using the player object, this gives the player their potion to heal with

        System.exit(0); // exits the program
    }



    /**
     * This is the displayMenu() that holds the display menu that shows the multiple options the player can choose from, all of which provide 
     * a special purpose of gameplay for the user
     * 
     * Created By: Samuel Pinnex, Levi Walker
     * Date Created: 11/12/2020
     * @return
     */
    public static int displayMenu() 
    {
        String menu = "";           // assigns the menu variable to an empty String
        menu += "============= What will you do? ==============\n";     
        menu += "1. Move to next room\n";
        menu += "2. View Inventory\n";
        menu += "3. Drink Health Potion\n";
        menu += "0. Leave the Imageon, you coward";

        String input = JOptionPane.showInputDialog(menu);       // assigns the input to the JOptionPane containing the String menu
        return Integer.parseInt(input);             // return Integer.parseInt(input)

    }


    /**
     * This method hosts the main menu of the game, and serves to redirect the player to different methods depending on
     * what they enter in the input dialog boxes while interacting with the program. There is an if statement that 
     * utilizes the random generator that is also housed here, and together they operate to randomly select one of 
     * the two mob encounters. They accept the health variables of the player as parameters. The menu method itself
     * accepts the integer associated with menuOption as the parameter, in order to accurately operate according 
     * to the player's choices.
     * 
     * Created by Levi Walker, Samuel Pinnex
     * Created on 11/10/2020
     * 
     * @param menuOption
     */
    public static void menuSelection(int menuOption)
    {
        
        switch(menuOption) // initiation of switch menu, accepts menuOption as the parameter (the integer that controls it's operation)
        {
            case 1: // if 1 is entered into the input dialog box by the user...
            randy = new Random(); // creates a new random object named "randy"
            int num = randy.nextInt(2); // the random object picks a random number between 0 and 1, making the cap of integers 2
    
            if(num == 0) // if the number generator generates 0, the spider encounter method is called from the Encounters class
            {
                int remPlayerHealth = spiderEncounter.spiderEncounter(player.getPlayerHealth()); // after 3 encounters (any kind), the boss is triggered
                player.setPlayerHealth(remPlayerHealth); // the player's health is passed around a lot here, but it is necessary to carry the math over to the driver
            }
            else // if 1 is generated instead of 0, then the skeleton encounter method is called
            {
                int remPlayerHealth = skeletonEncounter.skeletonEncounter(player.getPlayerHealth()); // calls skeleton encounter method, preps it for player health carry over
                player.setPlayerHealth(remPlayerHealth); // same as spider method, the player's health is passed around here as well in order to carry over the information to the driver.
            } 
                break; // breaks the case afterwards to bring the player back to the main menu
            case 2: // if 2 is entered into the input dialog box by the user...
                JOptionPane.showMessageDialog(null, player.showInventory(), "~INVENTORY~", JOptionPane.PLAIN_MESSAGE); // the player's inventory is displayed via calling the array list
                JOptionPane.showMessageDialog(null, "Your total damage is " + player.getTotalDamage() + "."); // displays a message after viewing the inventory that shows the player's total damage
                break; // breaks the case afterwards to bring the player back to the main menu
            case 3:
               int remAPlayerHealth = player.useHealthPotion(48);
               player.setPlayerHealth(remAPlayerHealth);
                JOptionPane.showMessageDialog(null, "Thomas drinks the health potion, increasing his health!");
                break;
            case 0: // if 0 is entered into the input dialog box by the user...
                goodbyeExit(); // the goodbye method is called, which exits the program
                break; // breaks the case afterwards
            default: // if anything other than 1, 2, or 0 is entered into the input dialog box by the user...
                error(); // the error method is called and displays an error message to the user, who then is returned to the main menu
                break; // breaks the case afterwards to bring the player back to the main menu
        }

    }


    /**
     * This method is called when the player exits the program on their own behalf, therefore
     * presenting them with this goodbye prompt.
     * 
     * Created by Samuel Pinnex, Levi Walker
     * Created on 11/15/2020
     */
    public static void goodbyeExit()
    {
        JOptionPane.showMessageDialog(null, "Until next time, Thomas...");
    }


    /**
     * This method is called when the player enters in an incorrect input. This method prompts the player
     * with the error message shown below, and then redirects them to the main menu.
     * 
     * Created by Levi Walker, Samuel Pinnex
     * Created on 11/15/2020
     */
    public static void error()
    {
        JOptionPane.showMessageDialog(null, "Invalid input from player. Please retry.", "Try again, Thomas.", JOptionPane.ERROR_MESSAGE);
    }


} // end of ImageonDriver.java
