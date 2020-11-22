import javax.swing.JOptionPane;

/**
* ---------------------------------------------------------------------------
* File name: PlayerUI.java
* Project name: LS_Code
* ---------------------------------------------------------------------------
* Creator's name and email: Levi Walker, walkerls@etsu.edu
* Course: CSCI 1250-900
* Creation Date: November 9, 2020
* ---------------------------------------------------------------------------
**/

/**
 * This is the class that holds the meat of PlayerUI. This isn't a totally utilized class in our program, but we
 * consider it a "beta-tested" class in our program, that just didn't make it to be implemented in our final program.
 * 
 * Created by Levi Walker
 * Created on 11/9/2020
 */
public class PlayerUI 
{
    int playerHealth; // declares playerHealth as an int variable
    int playerDMG; // declares playerDMG as an int variable


    /**
     * This is the constructor of the PlayerUI class, which constructs (or was intended to construct)
     * a PlayerUI instance for the player or user of this program. It would have included a toString method
     * that would have shown all of the data of the game (the encounter data, player stats data, etc.) to the user
     * while they were interacting with the program's systems.
     * 
     * Created Levi Walker
     * Created on 11/9/2020
     */
    public PlayerUI()
    {
        JOptionPane.showMessageDialog(null, "HEALTH: " + playerHealth);
        JOptionPane.showMessageDialog(null, "\nCURRENT DMG: " + playerDMG);
    }


    /**
     * This is a getter method that retrives and returns the health variable associated with the player. 
     * This can be used wherever the program needs it to be used.
     * 
     * Created by Levi Walker
     * Created on 11/9/2020
     * @return
     */
    public int getHealth()
    {
        return playerHealth; // returns playerHealth
    }

    /**
     * This is a getter method that retrives and returns the damage variable associated with the player. 
     * This can be used wherever the program needs it to be used.
     * 
     * Created by Levi Walker
     * Created on 11/9/2020
     * @return
     */
    public int getDMG()
    {
        return playerDMG; // returns playerDMG
    }


}


