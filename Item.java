
/**
* ---------------------------------------------------------------------------
* File name: Item.java
* Project name: LS_Code
* ---------------------------------------------------------------------------
* Creator's name and email: Levi Walker, walkerls@etsu.edu
* Course: CSCI 1250-900
* Creation Date: November 9, 2020
* ---------------------------------------------------------------------------
**/

/**
 * This class serves to hold the Item constructor, and the field/variable getters and setters (methods). 
 * This class is how the program reads what objects to create, and what the damage and healing fields should
 * represent (integer value). This class also has the ability to assign a name to these instances that are
 * created here.
 * 
 * Created by Levi Walker
 * Created on 11/9/2020
 */
public class Item 
{
    private int damage; // declares the int variable named damage
    private int healing; // declares the int variable named healing
    private String name; // declares the String variable named name


    /**
     * This constructor has three parameters, those being the aforementioned globally declared variables (String name, 
     * int healing, and int damage).
     * This constructor also makes sure that if any instances are created using this constructor that the name, healing, and damage
     * variables are assigned to the instance upon creation. 
     * 
     * Created by Levi Walker
     * Created on 11/9/2020
     * 
     * @param name
     * @param damage
     * @param healing
     */
    public Item (String name, int damage, int healing)
    {
        setName(name); // calls setter method for name
        setDamage(damage); // calls setter method for damage
        setHealing(healing); // calls setter method for healing
    }


    /**
     * This is the setter method for the String name variable, and therefore sets/assigns the name to the instance/object
     * created using this class and constructor.
     * 
     * Created by Levi Walker
     * Created on 11/9/2020
     * 
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }


    /**
     * This is the setter method for the int damage variable, and therefore sets/assigns the name to the instance/object
     * created using this class and constructor.
     * 
     * Created by Levi Walker
     * Created on 11/9/2020
     * 
     * @param damage
     */
    public void setDamage(int damage)
    {
        this.damage = damage;
    }


    /**
     * This is the setter method for the int healing variable, and therefore sets/assigns the name to the instance/object
     * created using this class and constructor.
     * 
     * Created by Levi Walker
     * Created on 11/9/2020
     * 
     * @param healing
     */
    public void setHealing(int healing)
    {
        this.healing = healing;
    }


    /**
     * This is the getter method for the String name variable, which will retrieve and return the name of the object in question
     * to the program- wherever and however it is needed.
     * 
     * Created by Levi Walker
     * Created on 11/9/2020
     * 
     * @return
     */
    public String getName() 
    {
        return name;
    }


    /**
     * This is the getter method for the int damage variable, which will retrieve and return the name of the object in question
     * to the program- wherever and however it is needed.
     * 
     * Created by Levi Walker
     * Created on 11/9/2020
     * 
     * @return
     */
    public int getDamage() 
    {
        return damage;
    }


    /**
     * This is the getter method for the int healing variable, which will retrieve and return the name of the object in question
     * to the program- wherever and however it is needed.
     * 
     * Created by Levi Walker
     * Created on 11/9/2020
     * 
     * @return
     */
    public int getHealing() 
    {
        return healing;
    }


    /**
     * This method serves as the template/formatter for how information/fields are displayed for any object created here in this class.
     * It holds a message template that we can manipulate and edit to display the information however we want (used in inventory display).
     * 
     * Created by Levi Walker
     * Created on 11/9/2020
     */
    public String toString()
    {
        String msg = ""; // declares an empty String msg variable

        msg += "\n" + getName(); // adds the name of the object to the String msg by calling the getter method for the name variable
        msg += "\nDAMAGE: " + getDamage(); // adds the damage stat of the object to the String msg by calling the getter method for the damage variable
        msg += "\nHEALING: " + getHealing(); // adds the healing stat of the object to the String msg by calling the getter method for the healing variable

        return msg; // returns the message wherever it is needed in the program
    }

}