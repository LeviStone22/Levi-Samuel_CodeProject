import java.util.ArrayList;

public class Player 
{
    private int playerHealth;
    private int playerDMG;
    private ArrayList<Item> inventory;
    private Item weapon;
    private Item potion;
    private PlayerAction paction;

    public Player(int playerHealth, int playerDMG)
    {
        inventory = new ArrayList<>();
        addWeapon();
        addPotion();
        paction = new PlayerAction(); // plan on moving this elsewhere
    }


    public void addWeapon()
    {
        weapon = new Item("Thomas' Blade", 16, 0);
        inventory.add(weapon);
    }

    public void addPotion()
    {
        potion = new Item("Health Potion", 0, 40);
        inventory.add(potion);
    }

    public String showInventory()
    {
        String inventoryStock = "";
        inventoryStock += "~-~-~-~-~ Thomas' Inventory ~-~-~-~-~\n";
        inventoryStock += "There are " + inventory.size() + " items in your inventory.\n\n";

        for(Item item : inventory)
        {
            inventoryStock += item.toString() + "\n\n";
        }

        return inventoryStock;

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



}
