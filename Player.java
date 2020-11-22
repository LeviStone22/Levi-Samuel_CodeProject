import java.util.ArrayList;
/**
* ---------------------------------------------------------------------------
* File name: Player.java
* Project name: LS_Code
* ---------------------------------------------------------------------------
* Creator's name and email: Samuel Pinnex, pinnexs@etsu.edu
* Course: CSCI 1250-900
* Creation Date: November 9, 2020
* ---------------------------------------------------------------------------
**/


/**
 * This is the Player class that holds all of the methods and information needed to not only create the Player object that is used throughout the 
 * program, but also the methods used to affect gameplay
 * 
 * Created by Samuel Pinnex
 * Date Created: 11/9/2020
 */
public class Player 
{
    private int playerHealth;       // creates the playerHealth variable to be used for the player object 
    private int playerDMG;          // creates the playerDMG variable that is used to deal damage to the monster's health
    private ArrayList<Item> inventory;      // this is the ArrayList that is used to hold the items the user will have in their inventory
    private Item weapon;                // creates a new weapon variable of the Item type to be used for the damage
    private Item potion;                // creates a new potion variable of the Item type to be used for increasing the player's health
    private PlayerAction paction;       // created a new variable of the PlayerAction type that is used to create new PlayerActions for the user to use


    /**
     * This is the Player() constructor that is used to create the Player object that is used throughout the program
     * The Player object is used to call methods from the Driver
     * 
     * Created By: Samuel Pinnex
     * Date Created: 11/9/2020
     */
    public Player()
    {
        playerHealth = 100;         // assigns the playerHealth variable to the value of 100, representing the player's health
        playerDMG = 16;             // assigns the playerDMG variable to the value of 16, representing the player's damage 
        inventory = new ArrayList<>();      // created the new ArrayList by the name of Inventory that holds the items the player will carry
        addWeapon();        // method call for the addWeapon() method that adds a new weapon in the constructor to be used in the program, the player will start with this object
        addPotion();        //  // method call for the addPotion() method that adds a new potion in the constructor to be used in the program, the player will start with this potion
        paction = new PlayerAction(); // plan on moving this elsewhere // creates a new PlayerAction by the name of paction to be used in the program
    }



    /**
     * This is the addWeapon() method that houses a newly created weapon object and then adds it to the inventory ArrayList
     * 
     * Created By: Samuel Pinnex
     * Date Created: 11/10/2020
     */
    public void addWeapon()
    {
        weapon = new Item("Thomas' Blade", 16, 0); // creates a new item that acts as a weapon for the user and sets the damage of the weapon to a specific value
        inventory.add(weapon); // adds the item to the inventory (array list)
    }


    /**
     * This is the addPotion() method that houses a newly created potion object and then adds it to the inventory ArrayList
     * 
     * Created By: Samuel Pinnex
     * Date Created: 11/10/2020
     */
    public void addPotion()
    {
        potion = new Item("Health Potion", 0, 40); // creates a new item that acts as a health potion and assigns a specific value that will increase the Player's health
        inventory.add(potion); // adds the item to the inventory (array list)
    }


    /**
     * This is the showInventory() method that is used to display the Player's inventory that displays the ArrayList that is inventory
     * 
     * Created By: Samuel Pinnex
     * Date Created: 11/10/2020
     * @return
     */
    public String showInventory()
    {
        String inventoryStock = ""; // declares a blank String message named inventoryStock
        inventoryStock += "~-~-~-~-~ Thomas' Inventory ~-~-~-~-~\n"; // inventory header message that displays to the player
        inventoryStock += "There are " + inventory.size() + " items in your inventory.\n\n"; // displays the array list's (inventory) size within a message for the player

        for(Item item : inventory) // for each loop that, for each item in the inventory array list, prints out the toString for those items in the inventory display
        {
            inventoryStock += item.toString() + "\n\n"; // this is triggered by pressing "2" on the driver menu
        }

        return inventoryStock; // returns inventoryStock

    }



    /**
     * This is the useHealthPotion() method that is used to increase the Player's health when it is low. Inside of the method there is a
     * method call for the playerHealing() method that does the math 
     * 
     * 
     * Created By: Samuel Pinnex
     * Date Created: 11/12/2020
     */
    public void useHealthPotion()
    {
        playerHealth += paction.playerHealing();        // assigns the playerHealth variable to the paction variable that is calling the playerHealing() method
    }
    


    /**
     * This is the getTotalDamage() method that is used to get the damage value assigned to the item inside of the inventory ArrayList
     * 
     * Created By: Samuel Pinnex
     * Date Created: 11/12/2020
     * @return
     */
    public int getTotalDamage()
    {
        int msg = 0;    // assigns the msg to the value of 0

        for(Item item : inventory)      // this for-each loop is used to display the ArrayList holding the Player's items
        {
            msg += item.getDamage();    // assigns the msg variable to the item variable that is calling the getDamage() method
        }

        return msg;     // returns the msg
    }


    /**
     * This is the getPlayerHealth() method that is used to get the specific value that is associated with the playerHealth variable
     * 
     * Created By; Samuel Pinnex
     * Date Created: 11/12/2020
     * @return
     */
    public int getPlayerHealth()
    {
        return playerHealth;
    }


    /**
     * This is the setPlayerHealth() method that is used to assign a specific value to the playerHealth variable
     * 
     * Created By: Samuel Pinnex
     * Date Created: 11/12/2020
     * @param playerHealth
     */
    public void setPlayerHealth(int playerHealth) 
    {
        this.playerHealth = playerHealth;       // assigns the playerHealth variable to itself using the this keyword
    }

}
