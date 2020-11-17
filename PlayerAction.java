


public class PlayerAction 
{
    boolean movement;
    int weaponDMG;
    int potionHealing;

    public PlayerAction()
    {
       movement = true;
    }


    public int playerAttack() // do what we did with playerHealing() as we did here
    {
        int attackDamage = 0;
        int spiderHealth = 48;

        weaponDMG = 16;

        
        attackDamage = spiderHealth - weaponDMG;

        return attackDamage;
    }


    public int playerHealing() // maybe add an if-statement for validation that ensures that health cannot go over 100
    {
        potionHealing = 40;

        return potionHealing;
    }
    

    // public boolean playerFlee()
    // {
        
    // }

}
