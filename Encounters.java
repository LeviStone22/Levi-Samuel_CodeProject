import javax.swing.JOptionPane;


public class Encounters // move all values to the constructor, keep all declarations inside of class
{
    private int remainingHealth;
    private int playerDMG;
    private String attackOption;
    private int encounterNum;

    private int spiderDMG;
    private int spiderHealth;

    private int skeletonDMG;
    private int skeletonHealth;

    private int bossDMG;
    private int bossHealth;

    public Encounters()
    {
        bossHealth = 0;
        bossDMG = 0;
        skeletonDMG = 0;
        skeletonHealth = 0;
        spiderDMG = 6;
        spiderHealth = 48;
        encounterNum = 0;
        attackOption = "";
        remainingHealth = 0;
        playerDMG = 16;
    }


// in a future if statement, we will call one of these encounter methods via a random generator
// i.e. if the random generator generates 2, then we will call this spiderEncounter method, if it 
// generates a 1, we could call the skeletonEncounter method, and we can make a do while loop around
// that if statement to ensure that after a pre-determined amount of encounters with spiders and skeletons
// that the player will then encounter the boss.
    public void spiderEncounter()
    {
        // We can make a switch statement inside of this encounter method, and in the switch statement, for instance "Flee" we can use JOptionPane, and 
        // then we can call the "move to next room method"

        JOptionPane.showMessageDialog(null, "You have encountered a dungeon spider!");

        spiderHealth = 48;
        spiderDMG = 6;

            do
            {
                String input = JOptionPane.showInputDialog(spiderToString().trim());

                if (input.equals("1"))
                {
                   spiderHasBeenAttacked();
                }                                                                                                              
                else if (input.equals("2"))
                {
                    String input2 = JOptionPane.showInputDialog("Are you sure you want to run away?").trim().toLowerCase();
                    if (input2.equals("yes"))
                    {
                        JOptionPane.showMessageDialog(null, "Thomas ran away from the battle.");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Thomas chose not to run away.");
                        input = JOptionPane.showInputDialog(spiderToString().trim());
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Input, Thomas. You must enter either 1 or 2 into the input dialog box.");  
                    input = JOptionPane.showInputDialog(spiderToString().trim());
                }
            } while (remainingHealth > 0); // ASK ERIN WHY THE or || statement DOES NOT WORK HERE. <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


                // do
                // {
                //     JOptionPane.showInputDialog("Would you like to attack?").trim().toLowerCase();
                //     String input = attackOption;

                //     if (attackOption.equals("yes")) // if using the toString, change "yes" to "1"
                //     {
                //         remainingHealth = spiderHealth - playerDMG; // if using the toString, use spiderHealth -= playerDMG, then the same for playerHealth
                //         JOptionPane.showInputDialog("You attack the spider and it does 12 damage! The spider's health is now " + remainingHealth + ". Would you like to attack again?");
                //         String input2 = attackOption;
                //     }

                // } while (spiderHealth > 0);
    }

    public void skeletonEncounter()
    {
        JOptionPane.showMessageDialog(null, "You have encountered a wretched skeleton!");
        
        skeletonHealth = 35;
        skeletonDMG = 10;

            do
            {
                String input = JOptionPane.showInputDialog(skeletonToString().trim());

                if (input.equals("1"))
                {
                    skeletonHasBeenAttacked();
                }                                                                                                              
                else if (input.equals("2"))
                {
                    String input2 = JOptionPane.showInputDialog("Are you sure you want to run away?").trim().toLowerCase();
                    if (input2.equals("yes"))
                    {
                        JOptionPane.showMessageDialog(null, "Thomas ran away from the battle.");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Thomas chose not to run away.");
                        input = JOptionPane.showInputDialog(skeletonToString().trim());
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Input, Thomas. You must enter either 1 or 2 into the input dialog box.");  
                    input = JOptionPane.showInputDialog(skeletonToString().trim());
                }
            } while (remainingHealth > 0);

    }


    public String spiderToString()
    {
        String encounterMSG = "";

        encounterMSG += "================ Dungeon Spider ================\n";
        encounterMSG += "\nSpider HP: " + spiderHealth + "\n";
        encounterMSG += "\n\tWhat would you like to do?\n"; 
        encounterMSG += "\t1. Attack!\n";
        // encounterMSG += "\t2. Drink a health potion\n";
        encounterMSG += "\t2. Flee...\n";

        return encounterMSG;
    }

    public String skeletonToString()
    {
        String encounterMSG = "";

        encounterMSG += "================ Wretched Skeleton ================\n";
        encounterMSG += "\nSkeleton HP: " + skeletonHealth + "\n";
        encounterMSG += "\n\tWhat would you like to do?\n"; 
        encounterMSG += "\t1. Attack!\n";
        // encounterMSG += "\t2. Drink a health potion\n";
        encounterMSG += "\t2. Flee...\n";

        return encounterMSG;
    }


    public void skeletonHasBeenAttacked()
    {
        skeletonHealthDrop(); // if using the toString, use spiderHealth -= playerDMG, then the same for playerHealth
        JOptionPane.showMessageDialog(null, "You attack the skeleton and it does 16 damage!\nThe skeleton's health is now " + remainingHealth + "."); 
        JOptionPane.showMessageDialog(null, "The skeleton attacks you and deals 6 damage!\nYour health drops to "); // IF WE ATTACK FIRST, THE FLEE OPTION DOES NOT WORK <<<<<<<<<<<<<<<<<<<<<

        if (remainingHealth <= 0)
        {
            JOptionPane.showMessageDialog(null, "Thomas has defeated the wretched skeleton!");
        }
    }

    public void spiderHasBeenAttacked()
    {
        spiderHealthDrop(); // if using the toString, use spiderHealth -= playerDMG, then the same for playerHealth
        JOptionPane.showMessageDialog(null, "You attack the spider and it does 16 damage!\nThe spider's health is now " + remainingHealth + "."); 
        JOptionPane.showMessageDialog(null, "The spider attacks you and deals 6 damage!\nYour health drops to "); // IF WE ATTACK FIRST, THE FLEE OPTION DOES NOT WORK <<<<<<<<<<<<<<<<<<<<<

        if (remainingHealth <= 0)
        {
            JOptionPane.showMessageDialog(null, "Thomas has slain the dungeon spider!");
        }
    }

    public int skeletonHealthDrop()
    {
        for(int i = 0; i < 1; i++)
        {
           remainingHealth = skeletonHealth -= playerDMG;
        }

        return remainingHealth;
    }

    public int spiderHealthDrop()
    {
        for(int i = 0; i < 1; i++)
        {
           remainingHealth = spiderHealth -= playerDMG;
        }

        return remainingHealth;
    }
}
