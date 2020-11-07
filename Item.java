

public class Item 
{
    private int damage; 
    private int healing; 
    private String name; 

    
    public Item (String name, int damage, int healing)
    {
        setName(name);
        setDamage(damage);
        setHealing(healing);
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public void setDamage(int damage)
    {
        this.damage = damage;
    }


    public void setHealing(int healing)
    {
        this.healing = healing;
    }


    public String getName() 
    {
        return name;
    }


    public int getDamage() 
    {
        return damage;
    }


    public int getHealing() 
    {
        return healing;
    }


    public String toString()
    {
        String msg = "";

        msg += "\n" + getName();
        msg += "\nDAMAGE: " + getDamage();
        msg += "\nHEALING: " + getHealing();

        return msg;
    }

}