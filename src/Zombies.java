import javax.swing.*;
import java.util.ArrayList;

class ZombieGame {
    private int playerHealth;
    private int zombieHealth;
    private ArrayList<String> weapons;

    public ZombieGame() {
        this.playerHealth = 100;
        this.zombieHealth = 50;

        this.weapons = new ArrayList<>();
        this.weapons.add("Axe");
        this.weapons.add("Pistol");
        this.weapons.add("Baseball bat");
        this.weapons.add("Hands");
        this.weapons.add("Teaszer");
        this.weapons.add("Ak-47");
        this.weapons.add("Grenade launcher");
    }

    public void playGame(int weaponChoice) {
        JOptionPane.showMessageDialog(null, "You encounter a zombie!");

        while (playerHealth > 0 && zombieHealth > 0) {
            String weaponUsed = weapons.get(weaponChoice - 1);

            int playerDamage = calculatePlayerDamage(weaponUsed);
            int zombieDamage = calculateZombieDamage();

            zombieHealth -= playerDamage;
            playerHealth -= zombieDamage;

            JOptionPane.showMessageDialog(null,
                    "You attacked the zombie with " + weaponUsed + " and dealt " + playerDamage + " damage.\n"
                            + "The zombie attacked you and dealt " + zombieDamage + " damage.\n" + "Player Health: "
                            + playerHealth + "\nZombie Health: " + zombieHealth);

            if (zombieHealth <= 0) {
                JOptionPane.showMessageDialog(null, "You defeated the zombie. You win!");
            } else if (playerHealth <= 0) {
                JOptionPane.showMessageDialog(null, "You were defeated by the zombie. Game over.");
            }
        }
    }

    private int calculatePlayerDamage(String weapon) {
        switch (weapon) {
            case "Axe":
                return (int) (Math.random() * 20) + 10;
            case "Pistol":
                return (int) (Math.random() * 25) + 15;
            case "Baseball bat":
                return (int) (Math.random() * 15) + 20;
            case "Hands":
                return (int) (Math.random() * 10) + 2;
            case "Teaszer":
                return (int) (Math.random() * 25) + 15;
            case "Ak-47":
                return (int) (Math.random() * 25) + 50;
            case "Grenade launcher":
                return (int) (Math.random() * 25) + 50;
            default:
                return 0;
        }
    }

    private int calculateZombieDamage() {
        return (int) (Math.random() * 15) + 5;
    }
}
