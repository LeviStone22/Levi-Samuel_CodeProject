import javax.swing.JOptionPane;

public class PlayerUI 
{
    int playerHealth;
    int playerDMG;


    public PlayerUI()
    {
        JOptionPane.showMessageDialog(null, "HEALTH: " + playerHealth);
        JOptionPane.showMessageDialog(null, "\nCURRENT DMG: " + playerDMG);
    }


    public int getHealth()
    {
        return playerHealth;
    }

    public int getDMG()
    {
        return playerDMG;
    }


}


