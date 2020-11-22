import javax.swing.JOptionPane;

/**
* ---------------------------------------------------------------------------
* File name: Encounters.java
* Project name: LS_Code
* ---------------------------------------------------------------------------
* Creator's name and email: Samuel Pinnex, pinnexs@etsu.edu
                            Levi Walker, walkerls@etsu.edu
* Course: CSCI 1250-900
* Creation Date: November 9, 2020
* ---------------------------------------------------------------------------
**/

/**
 * This class arguably holds the most important operational code in the program. The encounters are the heart of Imageon, and this
 * class showcases this. Here you will find many encounter methods, calculation methods, and a large amount of 
 * text prompts that will be presented to the player as they navigate our game. In this class, players can interact with 
 * spiders, skeletons, and even a treasure dragon.
 * 
 * Created by Samuel Pinnex, Levi Walker
 * Created on 11/9/2020
 */
public class Encounters
{
    private int remainingHealth; // declares remainingHealth as an int type variable
    private int remainingPlayerHealth; // declares remainingPlayerHealth as an int type variable
    private int playerDMG; // declares playerDMG as an int type variable
    private int playerHealth;

    private int spiderDMG; // declares spiderDMG as an int type variable
    private int spiderHealth; // declares spiderHealth as an int type variable

    private int skeletonDMG; // declares skeletonDMG as an int type variable
    private int skeletonHealth; // declares skeletonHealth as an int type variable

    private int bossDMG; // declares bossDMG as an int type variable
    private int bossHealth; // declares bossHealth as an int type variable
    private int bossNum = 0; // declares bossNum as an int type variable, and also defines it as 0
 
    /**
     * This is the constructor for the Encounters class, and ensures that whenever a 
     * new Encounters instance is created that all of these included variables are 
     * interweaved within the now operational object (of whatever encounter is encoded).
     * 
     * Created by Samuel Pinnex, Levi Walker
     * Created on 11/10/2020
     */
    public Encounters()
    {
        bossHealth = 80; // defines bossHealth as 80
        bossDMG = 10; // defines bossDMG as 10
        skeletonDMG = 7; // defines skeletonDMG as 7
        skeletonHealth = 35; // defines skeletonHealth as 35
        spiderDMG = 6; // defines spiderDMG as 6
        spiderHealth = 48; // defines spiderHealth as 48
        remainingHealth = 0; // defines remainingHealth as 0
        remainingPlayerHealth = 0; // defines remainingPlayerHealth as 0
        playerDMG = 16; // defines playerDMG as 16
        playerHealth = 100;
    }


    /**
     * This method is called when the random generator in the driver pulls the respective ID number. When this method is called, 
     * it initiates the spider encounter. The player then has the choice to either attack or flee away from the enemy.
     * If the player attacks, the attack and health drop methods are called and the battle ensues. If the player flees, they
     * are asked if they are sure that is what they intend to do, and if it is they are allowed to do so.
     * The parameter here accepts the integer assigned to the playerHealth variable and is used to calculate certain 
     * health drops when the player is attacked by the mob.
     * 
     * Created by Levi Walker, Samuel Pinnex
     * Created on 11/13/2020
     * 
     * @param playerHealth
     * @return
     */
    public int spiderEncounter(int playerHealth)
    {

        JOptionPane.showMessageDialog(null, "You have encountered a dungeon spider!"); // intro prompt/message of encounter

        spiderHealth = 48; // while initially redundant, this is necessary to allow this encounter to work without issues. defines spiderHealth as 48
        spiderDMG = 6; // the description from the above comment applies here as well. defines spiderDMG as 6

            do // do-while loop that runs the battle menu as long as the spider's health is greater than 0
            {
                String input = JOptionPane.showInputDialog(spiderToString().trim()); // declares and defines String input as the spiderToString 

                if (input.equals("1")) // if the input is equal to 1, the spiderHasBeenAttacked() method is called
                {
                   spiderHasBeenAttacked(playerHealth); // method call to spiderHasBeenAttacked()
                }                                                                                                              
                else if (input.equals("2")) // if the input is equal to 2, the player is asked if they are sure they want to flee from the encounter
                {
                    String input2 = JOptionPane.showInputDialog("Are you sure you want to run away?").trim().toLowerCase(); // defines String input2 as the flee validation
                    if (input2.equals("yes")) // trims the answer, transfers it to lowercase, and if it is yes, the program allows the player to flee
                    {
                        JOptionPane.showMessageDialog(null, "Thomas ran away from the battle."); // flee confirmation message to player
                    }
                    else // if the player enters anything other than yes in the input box, the program accepts this answer as a no, and the player is sent back to battle
                    {
                        JOptionPane.showMessageDialog(null, "Thomas chose not to run away."); // flee deconfirmation message to the player
                        input = JOptionPane.showInputDialog(spiderToString().trim()); // player is sent back to the encounter screen
                    }
                }
                else // if the inital input on the battle screen is anything other than 1 or 2, this message is displayed to the player (error message)
                {
                    JOptionPane.showMessageDialog(null, "Invalid Input, Thomas. You must enter either 1 or 2 into the input dialog box."); // error message
                    input = JOptionPane.showInputDialog(spiderToString().trim()); // sends the player back to the battle screen
                }
            } while (remainingHealth > 0); // this whole encounter is only operational while the spider has an amount of health greater than 0

        bossCounter(playerHealth); // method call to the bossCounter method, this increments the bossNum variable

        return playerHealth; // returns the playerHealth variable, in order to manipulate the player object inside of the driver file

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

            // ^ this was an experimental version of the insides of our encounter methods, this was ditched early on in the testing process
    }


    /**
     * This method is called when the random generator in the driver pulls the respective ID number. When this method is called, 
     * it initiates the skeleton encounter. The player then has the choice to either attack or flee away from the enemy.
     * If the player attacks, the attack and health drop methods are called and the battle ensues. If the player flees, they
     * are asked if they are sure that is what they intend to do, and if it is they are allowed to do so.
     * The parameter here accepts the integer assigned to the playerHealth variable and is used to calculate certain 
     * health drops when the player is attacked by the mob.
     * 
     * Created by Levi Walker, Samuel Pinnex
     * Created on 11/13/2020
     * 
     * @param playerHealth
     * @return
     */
    public int skeletonEncounter(int playerHealth)
    {
        JOptionPane.showMessageDialog(null, "You have encountered a wretched skeleton!"); // intro prompt/message of encounter
        
        skeletonHealth = 35; // while initially redundant, this is necessary to allow this encounter to work without issues. defines skeleton health as 35
        skeletonDMG = 7; // the description from the above comment applies here as well. defines skeletonDMG as 7

            do // do-while loop that runs the battle menu as long as the skeleton's health is greater than 0
            {
                String input = JOptionPane.showInputDialog(skeletonToString().trim()); // declares and defines String input as the skeletonToString 

                if (input.equals("1")) // if the input is equal to 1, the skeletonHasBeenAttacked() method is called
                {
                    skeletonHasBeenAttacked(playerHealth); // method call to skeletonHasBeenAttacked()
                }                                                                                                              
                else if (input.equals("2")) // if the input is equal to 2, the player is asked if they are sure they want to flee from the encounter
                {
                    String input2 = JOptionPane.showInputDialog("Are you sure you want to run away?").trim().toLowerCase(); // defines String input2 as the flee validation
                    if (input2.equals("yes")) // trims the answer, transfers it to lowercase, and if it is yes, the program allows the player to flee
                    {
                        JOptionPane.showMessageDialog(null, "Thomas ran away from the battle."); // flee confirmation message to player
                    }
                    else // if the player enters anything other than yes in the input box, the program accepts this answer as a no, and the player is sent back to battle
                    {
                        JOptionPane.showMessageDialog(null, "Thomas chose not to run away."); // flee deconfirmation message to the player
                        input = JOptionPane.showInputDialog(skeletonToString().trim()); // player is sent back to the encounter screen
                    }
                }
                else // if the inital input on the battle screen is anything other than 1 or 2, this message is displayed to the player (error message)
                {
                    JOptionPane.showMessageDialog(null, "Invalid Input, Thomas. You must enter either 1 or 2 into the input dialog box."); // error message
                    input = JOptionPane.showInputDialog(skeletonToString().trim()); // sends the player back to the battle screen
                }
            } while (remainingHealth > 0); // this whole encounter is only operational while the skeleton has an amount of health greater than 0

        bossCounter(playerHealth); // method call to the bossCounter method, this increments the bossNum variable

        return playerHealth; // returns the playerHealth variable, in order to manipulate the player object inside of the driver file
    }


    /**
     * This method is called after three normal encounters are completed by the player. When this method is called, 
     * it initiates the boss encounter. The player then has the choice to either attack or flee away from the enemy.
     * If the player attacks, the attack and health drop methods are called and the battle ensues. If the player flees, they
     * are asked if they are sure that is what they intend to do, and if it is they are allowed to do so.
     * The parameter here accepts the integer assigned to the playerHealth variable and is used to calculate certain 
     * health drops when the player is attacked by the mob. At the end of the encounter, if the dragon is defeated,
     * the program will end- but not before displaying some outro text.
     * 
     * Created by Levi Walker, Samuel Pinnex
     * Created on 11/19/2020
     * 
     * @param playerHealth
     * @return
     */
    public int bossEncounter(int playerHealth)
    {

        JOptionPane.showMessageDialog(null, "You have encountered the treasure dragon!"); // intro prompt/message of encounter
        JOptionPane.showMessageDialog(null, "The room that awaits you presents a mighty dragon...\n who sits upon a large mountain of golden luxuries!"); // second prompt
        JOptionPane.showMessageDialog(null, "Good luck, Thomas!"); // you'll need it!
        
        bossHealth = 80; // defines bossHealth as 80
        bossDMG = 10; // defines bossDMG as 10

            do // do-while loop that runs the battle menu as long as the dragon's health is greater than 0
            {
                String input = JOptionPane.showInputDialog(bossToString().trim()); // declares and defines String input as the bossToString

                if (input.equals("1")) // if the input is equal to 1, the bossHasBeenAttacked() method is called
                {
                    bossHasBeenAttacked(playerHealth); // method call to bossHasBeenAttacked()
                }                                                                                                              
                else if (input.equals("2")) // if the input is equal to 2, the player is asked if they are sure they want to flee from the encounter
                {
                    String input2 = JOptionPane.showInputDialog("Are you sure you want to run away?").trim().toLowerCase(); // defines String input2 as the flee validation
                    if (input2.equals("yes")) // trims the answer, transfers it to lowercase, and if it is yes, the program allows the player to flee
                    {
                        JOptionPane.showMessageDialog(null, "Thomas ran away from the battle."); // flee confirmation message to player
                    }
                    else // if the player enters anything other than yes in the input box, the program accepts this answer as a no, and the player is sent back to battle
                    {
                        JOptionPane.showMessageDialog(null, "Thomas chose not to run away."); // flee deconfirmation message to the player
                        input = JOptionPane.showInputDialog(bossToString().trim()); // player is sent back to the encounter screen
                    }
                }
                else // if the inital input on the battle screen is anything other than 1 or 2, this message is displayed to the player (error message)
                {
                    JOptionPane.showMessageDialog(null, "Invalid Input, Thomas. You must enter either 1 or 2 into the input dialog box."); // error message
                    input = JOptionPane.showInputDialog(bossToString().trim()); // sends the player back to the battle screen
                }
            } while (remainingHealth > 0); // this whole encounter is only operational while the boss has an amount of health greater than 0

        return playerHealth; // returns the playerHealth variable, in order to manipulate the player object inside of the driver file
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
        skeletonHealthDrop();
        JOptionPane.showMessageDialog(null, "You attack the skeleton and it does 16 damage!\nThe skeleton's health is now " + remainingHealth + "."); 
        JOptionPane.showMessageDialog(null, "The skeleton attacks you and deals 7 damage!\nYour health drops to " + playerSkeletonHealthDrop(playerHealth) + ".");

        if (remainingHealth <= 0)
        {
            JOptionPane.showMessageDialog(null, "Thomas has defeated the wretched skeleton!");
        }
    }

    public void spiderHasBeenAttacked(int playerHealth)
    {
        spiderHealthDrop();
        JOptionPane.showMessageDialog(null, "You attack the spider and it does 16 damage!\nThe spider's health is now " + remainingHealth + "."); 
        JOptionPane.showMessageDialog(null, "The spider attacks you and deals 6 damage!\nYour health drops to " + playerSpiderHealthDrop(playerHealth) + ".");

        if (remainingHealth <= 0)
        {
            JOptionPane.showMessageDialog(null, "Thomas has slain the dungeon spider!");
        }
    }

    public void bossHasBeenAttacked(int playerHealth)
    {
        bossHealthDrop();
        JOptionPane.showMessageDialog(null, "You attack the mighty dragon and it does 16 damage!\nThe dragon's health is now " + remainingHealth + "."); 
        JOptionPane.showMessageDialog(null, "The dragon attacks you and deals a whopping 10 damage!\nYour health drops to " + playerBossHealthDrop(playerHealth) + ".");

        if (remainingHealth <= 0)
        {
            JOptionPane.showMessageDialog(null, "Thomas has slain the treasure dragon!\nThomas has triumphed over his Imageon.");
            JOptionPane.showMessageDialog(null, "Until next time, Thomas Stone...");

            System.exit(0); // exits the program
        }
    }

    public int playerSpiderHealthDrop(int playerHealth)
    {
        for(int i = 0; i < 1; i++)
        {
           remainingPlayerHealth = this.playerHealth -= spiderDMG;
        }

        return remainingPlayerHealth;
    }

    public int playerSkeletonHealthDrop(int playerHealth)
    {
        for(int i = 0; i < 1; i++)
        {
           remainingPlayerHealth = this.playerHealth -= skeletonDMG;
        }

        return remainingPlayerHealth;
    }

    public int playerBossHealthDrop(int playerHealth)
    {
        for(int i = 0; i < 1; i++)
        {
           remainingPlayerHealth = this.playerHealth -= bossDMG;
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


    /**
     * This method is internally called inside of the spider and skeleton encounter methods
     * in order to increment the bossNum field. We wanted the boss to appear after three 
     * regular encounters (spiders/skeletons). In order to achieve this feature, we needed 
     * to increment a field after every spider/skeleton encounter, and this is how we chose 
     * to do it. Via internal method calls, using this method as a counter. If the bossNum
     * is == to 2, the boss is triggered after that third encounter (spider/skeleton) is
     * finished. We had to set the bossNum cap to be == 2, because this intakes 0 as the
     * starting integer, and not 0 in it's incrementation. This accepts the playerHealth
     * as it's argument, which allows the playerHealth to travel through it uninterrupted.
     * 
     * Created by Levi Walker, Samuel Pinnex
     * Created on 11/19/2020
     * 
     * @param playerHealth
     * @return
     */
    public int bossCounter(int playerHealth)
    {
        for(int i = 0; i < 1; i++) // for loop that increments by 1 via utilizing a simple variable set-up
        {                          // if i is less than 1, increment i.
           bossNum++; // if i increments, increment bossNum by 1 as well (++)
        }

        if(bossNum == 2) // if bossNum is equal to 2, then the program issues the bossEncounter method to the player
        {
            bossEncounter(playerHealth); // method call to the boss encounter
        }

        return bossNum; // returns the bossNum
    }
    
} // end of Encounters.java
