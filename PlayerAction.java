


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
        int spiderHealth = 50;

        weaponDMG = 12;

        // (spiderHealth || skeletonHealth) ?
        attackDamage = spiderHealth - weaponDMG;

        return attackDamage;
    }


    public int playerHealing()
    {
        potionHealing = 40;

        return potionHealing;
    }
    

    // public boolean playerFlee()
    // {
        
    // }

}
