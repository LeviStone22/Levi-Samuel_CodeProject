import javax.swing.JOptionPane;


public class Encounters // move all values to the constructor, keep all declarations inside of class
{
    private int remainingHealth;
    private int remainingPlayerHealth;
    private int playerDMG;

    private int spiderDMG;
    private int spiderHealth;

    private int skeletonDMG;
    private int skeletonHealth;

    private int bossDMG;
    private int bossHealth;
    private int bossNum = 0;

    public Encounters()
    {
        bossHealth = 80;
        bossDMG = 14;
        skeletonDMG = 10;
        skeletonHealth = 35;
        spiderDMG = 6;
        spiderHealth = 48;
        remainingHealth = 0;
        remainingPlayerHealth = 0;
        playerDMG = 16;
    }


    public int spiderEncounter(int playerHealth)
    {

        JOptionPane.showMessageDialog(null, "You have encountered a dungeon spider!");

        spiderHealth = 48;
        spiderDMG = 6;

            do
            {
                String input = JOptionPane.showInputDialog(spiderToString().trim());

                if (input.equals("1"))
                {
                   spiderHasBeenAttacked(playerHealth);
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
            } while (remainingHealth > 0);

        bossCounter(playerHealth);

        return playerHealth;

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

    public int skeletonEncounter(int playerHealth)
    {
        JOptionPane.showMessageDialog(null, "You have encountered a wretched skeleton!");
        
        skeletonHealth = 35;
        skeletonDMG = 10;

            do
            {
                String input = JOptionPane.showInputDialog(skeletonToString().trim());

                if (input.equals("1"))
                {
                    skeletonHasBeenAttacked(playerHealth);
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

        bossCounter(playerHealth);

        return playerHealth;
    }

    public int bossEncounter(int playerHealth)
    {

        JOptionPane.showMessageDialog(null, "You have encountered the treasure dragon!");
        JOptionPane.showMessageDialog(null, "The room that awaits you presents a mighty dragon...\n who sits upon a large mountain of golden luxuries!");
        JOptionPane.showMessageDialog(null, "Good luck, Thomas!");
        
        bossHealth = 80;
        bossDMG = 14;

            do
            {
                String input = JOptionPane.showInputDialog(bossToString().trim());

                if (input.equals("1"))
                {
                    bossHasBeenAttacked(playerHealth);
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
                        input = JOptionPane.showInputDialog(bossToString().trim());
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Input, Thomas. You must enter either 1 or 2 into the input dialog box.");  
                    input = JOptionPane.showInputDialog(bossToString().trim());
                }
            } while (remainingHealth > 0);

        return playerHealth;
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

    public String bossToString()
    {
        String encounterMSG = "";

        encounterMSG += "================ Treasure Dragon ================\n";
        encounterMSG += "\nDragon HP: " + bossHealth + "\n";
        encounterMSG += "\n\tWhat would you like to do?\n"; 
        encounterMSG += "\t1. Attack!\n";
        // encounterMSG += "\t2. Drink a health potion\n";
        encounterMSG += "\t2. Flee...\n";

        return encounterMSG;
    }

    
    public void skeletonHasBeenAttacked(int playerHealth)
    {
        skeletonHealthDrop(); // if using the toString, use spiderHealth -= playerDMG, then the same for playerHealth
        JOptionPane.showMessageDialog(null, "You attack the skeleton and it does 16 damage!\nThe skeleton's health is now " + remainingHealth + "."); 
        JOptionPane.showMessageDialog(null, "The skeleton attacks you and deals 10 damage!\nYour health drops to " + playerSkeletonHealthDrop(playerHealth) + ".");

        if (remainingHealth <= 0)
        {
            JOptionPane.showMessageDialog(null, "Thomas has defeated the wretched skeleton!");
        }
    }

    public void spiderHasBeenAttacked(int playerHealth)
    {
        spiderHealthDrop(); // if using the toString, use spiderHealth -= playerDMG, then the same for playerHealth
        JOptionPane.showMessageDialog(null, "You attack the spider and it does 16 damage!\nThe spider's health is now " + remainingHealth + "."); 
        JOptionPane.showMessageDialog(null, "The spider attacks you and deals 6 damage!\nYour health drops to " + playerSpiderHealthDrop(playerHealth) + ".");

        if (remainingHealth <= 0)
        {
            JOptionPane.showMessageDialog(null, "Thomas has slain the dungeon spider!");
        }
    }

    public void bossHasBeenAttacked(int playerHealth)
    {
        bossHealthDrop(); // if using the toString, use spiderHealth -= playerDMG, then the same for playerHealth
        JOptionPane.showMessageDialog(null, "You attack the mighty dragon and it does 16 damage!\nThe dragon's health is now " + remainingHealth + "."); 
        JOptionPane.showMessageDialog(null, "The dragon attacks you and deals a whopping 14 damage!\nYour health drops to " + playerBossHealthDrop(playerHealth) + ".");

        if (remainingHealth <= 0)
        {
            JOptionPane.showMessageDialog(null, "Thomas has slain the treasure dragon!\nThomas has triumphed over his Imageon.");
            JOptionPane.showMessageDialog(null, "Until next time, Thomas Stone...");

            System.exit(0);
        }
    }

    public int playerSpiderHealthDrop(int playerHealth)
    {
        for(int i = 0; i < 1; i++)
        {
           remainingPlayerHealth = playerHealth -= spiderDMG;
        }

        return remainingPlayerHealth;
    }

    public int playerSkeletonHealthDrop(int playerHealth)
    {
        for(int i = 0; i < 1; i++)
        {
           remainingPlayerHealth = playerHealth -= skeletonDMG;
        }

        return remainingPlayerHealth;
    }

    public int playerBossHealthDrop(int playerHealth)
    {
        for(int i = 0; i < 1; i++)
        {
           remainingPlayerHealth = playerHealth -= bossDMG;
        }

        return remainingPlayerHealth;
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

    public int bossHealthDrop()
    {
        for(int i = 0; i < 1; i++)
        {
           remainingHealth = bossHealth -= playerDMG;
        }

        return remainingHealth;
    }


    public int bossCounter(int playerHealth)
    {
        for(int i = 0; i < 1; i++)
        {
           bossNum++;
        }

        if(bossNum == 2)
        {
            bossEncounter(playerHealth);
        }

        return bossNum;
    }
    
} // end of Encounters.java
