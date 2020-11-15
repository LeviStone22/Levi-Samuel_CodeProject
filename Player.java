import java.util.ArrayList;

public class Player 
{
    private int playerHealth;
    private int playerDMG;
    private ArrayList<Item> inventory;
    private Item weapon;
    private Item potion;

    public Player(int playerHealth, int playerDMG)
    {
        addWeapon();
        inventory = new ArrayList<>();
    }


    public void addWeapon()
    {
        weapon = new Item("Rusty Blade", 4, 0);
        inventory.add(weapon);
    }

    public void addPotion()
    {
        potion = new Item("Health Potion", 0, 10);
        inventory.add(potion);
    }

    public String showInventory()
    {
        String inventoryStock = "";
        inventoryStock += "There are " + inventory.size() + " items in your inventory.";

        for(Item item : inventory)
        {
            inventoryStock += item.toString() + "\n\n";
        }
        return inventoryStock;
    }
}
