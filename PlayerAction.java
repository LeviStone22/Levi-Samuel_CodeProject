/**
* ---------------------------------------------------------------------------
* File name: PlayerAction.java
* Project name: LS_Code
* ---------------------------------------------------------------------------
* Creator's name and email: Samuel Pinnex, pinnexs@etsu.edu
* Course: CSCI 1250-900
* Creation Date: November 10, 2020
* ---------------------------------------------------------------------------
**/


/**
 * This is the PlayerAction class that was mostly used in the very early stages of this programs development and was going to be used for the 
 * actions the user will take, such as healing and attacking. We didn't want this class to do nothing, so we did follow through with the healing option
 * 
 * Created by Samuel Pinnex
 * Date Created: 11/10/2020
 */
public class PlayerAction 
{
    
    int weaponDMG;      // creates the weaponDMG variable that was going to be used for the player's weapon
    int potionHealing;  // creates the potionHealing variable that is used to heal the player


    /**
     * This is the playerAttack() method that was going to be used in the program to allow the user to attack and this method would calculate the 
     * amount of health would be taken away from the monster's health using the weaponDMG variable 
     * 
     * Created By: Samuel Pinnex
     * Date Created: 11/10/2020
     * @return
     */
    public int playerAttack() // do what we did with playerHealing() as we did here
    {
        int attackDamage = 0;       // creates the attackDamage variable and assigns it to the value of 0
        int spiderHealth = 48;      // creates the spiderHealth variable and assigns it to the value of 48

        weaponDMG = 16;     // assigns the weaponDMG variable to a set value of 16

        
        attackDamage = spiderHealth - weaponDMG;        // assigns the attackDamage variable to the result of the spiderHealth being subtracted by the weaponDMG variable

        return attackDamage;        // returns the attackDamage variable, which is the result of the calculation above
    }



    /**
     * This is the playerHealing() method that is used to heal the player's health after an encounter
     * 
     * Created By: Samuel Pinnex
     * Date Created: 11/10/2020
     * @return
     */
    public int playerHealing(int playerHealth)
    {
        potionHealing = 40;     // assigns the potionHealing variable to the set value of 40

        return potionHealing;       // returns the potionHealing variable
    }
    

    // public boolean playerFlee()
    // {
        
    // }

}// end of PlayerAction.java
