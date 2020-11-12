import javax.swing.JOptionPane;


public class Encounters 
{
    int remainingHealth = 0;
    int playerDMG = 12;
    String attackOption = "";
    String mobName = "";
    int encounterNum = 0;
    String encounterLoot = "";

    int spiderDMG = 0;
    int spiderHealth = 0;

    int skeletonDMG = 0;
    int skeletonHealth = 0;

    int bossDMG = 0;
    int bossHealth = 0;

    public Encounters()
    {
        JOptionPane.showMessageDialog(null, "A " + mobName + " appears!");
    }


// in a future if statement, we will call one of these encounter methods via a random generator
// i.e. if the random generator generates 2, then we will call this spiderEncounter method, if it 
// generates a 1, we could call the skeletonEncounter method, and we can make a do while loop around
// that if statement to ensure that after a pre-determined amount of encounters with spiders and skeletons
// that the player will then encounter the boss.
    public void spiderEncounter()
    {
        JOptionPane.showMessageDialog(null, "You have encountered a dungeon spider!");
        
        spiderHealth = 50;
        spiderDMG = 6;

        do
        {
            JOptionPane.showInputDialog("Would you like to attack?").trim().toLowerCase();
            String input = attackOption;

            if (attackOption == "yes")
            {
                remainingHealth = spiderHealth - playerDMG;
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