import java.util.ArrayList;

public class Player 
{
    private int playerHealth;
    private int playerDMG;
    private ArrayList<Item> inventory;
    private Item weapon;
    private Item potion;
    private PlayerAction paction;

    public Player()
    {
        playerHealth = 100;
        playerDMG = 16;
        inventory = new ArrayList<>();
        addWeapon();
        addPotion();
        paction = new PlayerAction(); // plan on moving this elsewhere
    }


    public void addWeapon()
    {
        weapon = new Item("Thomas' Blade", 16, 0); // creates a new item that acts as a weapon for the user
        inventory.add(weapon); // adds the item to the inventory (array list)
    }

    public void addPotion()
    {
        potion = new Item("Health Potion", 0, 40); // creates a new item that acts as a health potion
        inventory.add(potion); // adds the item to the inventory (array list)
    }

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

    public void useHealthPotion()
    {
        playerHealth += paction.playerHealing();
    }
    

    public int getTotalDamage()
    {
        int msg = 0;

        for(Item item : inventory)
        {
            msg += item.getDamage();
        }

        return msg;
    }

    public int getPlayerHealth()
    {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) 
    {
        this.playerHealth = playerHealth;
    }

}
