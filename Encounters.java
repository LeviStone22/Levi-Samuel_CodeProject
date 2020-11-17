import javax.swing.JOptionPane;


public class Encounters // move all values to the constructor, keep all declarations inside of class
{
    int remainingHealth;
    int playerDMG;
    String attackOption;
    int encounterNum;

    int spiderDMG;
    int spiderHealth;

    int skeletonDMG;
    int skeletonHealth;

    int bossDMG;
    int bossHealth;

    public Encounters()
    {
        bossHealth = 0;
        bossDMG = 0;
        skeletonDMG = 0;
        skeletonHealth = 0;
        spiderDMG = 0;
        spiderHealth = 0;
        encounterNum = 0;
        attackOption = "";
        remainingHealth = 0;
        playerDMG = 12;
    }


// in a future if statement, we will call one of these encounter methods via a random generator
// i.e. if the random generator generates 2, then we will call this spiderEncounter method, if it 
// generates a 1, we could call the skeletonEncounter method, and we can make a do while loop around
// that if statement to ensure that after a pre-determined amount of encounters with spiders and skeletons
// that the player will then encounter the boss.
    public void spiderEncounter()
    {

        //  String encounterMSG = "";

        //  encounterMSG += "================ Dungeon Spider ================";
        //  encounterMSG += "\nYour HP: " + playerHealth;
        //  encounterMSG += "\nSpider HP: " + spiderHealth;
        //  encounterMSG += "\n\tWhat would you like to do?" 
        //  encounterMSG += "\t1. Attack";
        //  encounterMSG += "\t2. Drink a health potion";
        //  encounterMSG += "\t3. Flee!";

        //  return encounterMSG;
        
        // We can make a switch statement inside of this encounter method, and in the switch statement, for instance "Flee" we can use JOptionPane, and 
        // then we can call the "move to next room method"

        JOptionPane.showMessageDialog(null, "You have encountered a dungeon spider!");
        
        spiderHealth = 48;
        spiderDMG = 6;

        do
        {
            JOptionPane.showInputDialog("Would you like to attack?").trim().toLowerCase();
            String input = attackOption;

            if (attackOption.equals("yes")) // if using the toString, change "yes" to "1"
            {
                remainingHealth = spiderHealth - playerDMG; // if using the toString, use spiderHealth -= playerDMG, then the same for playerHealth
                JOptionPane.showInputDialog("You attack the spider and it does 12 damage! The spider's health is now " + remainingHealth + ". Would you like to attack again?");
                String input2 = attackOption;
            }

        } while (spiderHealth > 0);
    }

    public void skeletonEncounter()
    {
        JOptionPane.showMessageDialog(null, "You have encountered a skeleton!");
        
        skeletonHealth = 35;
        skeletonDMG = 10;

    }

}
