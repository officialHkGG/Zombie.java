import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to my zombie game");
        JOptionPane.showMessageDialog(null, "© 2023 Hidro kourkis");

        boolean playAgain;
        do {
            playAgain = playGame();
        } while (playAgain);
    }

    private static boolean playGame() {
        ZombieGame game = new ZombieGame();

        int weaponChoice;
        try {
            weaponChoice = getWeaponChoice();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            return true;
        }

        while (weaponChoice < 1 || weaponChoice >7) {
            JOptionPane.showMessageDialog(null, "Invalid weapon choice. Please choose a valid weapon.");
            try {
                weaponChoice = getWeaponChoice();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                return true;
            }
        }

        game.playGame(weaponChoice);

        int playAgainOption = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again",
                JOptionPane.YES_NO_OPTION);

        return playAgainOption == JOptionPane.YES_OPTION;
    }

    private static int getWeaponChoice() {
        String userInput = JOptionPane.showInputDialog(
                null, "Choose a weapon to use:\n1. Axe\n2. Pistol\n3. Baseball bat\n4. Hands\n5. Teaszer\n6. Ak-47\n7. Grenade launcher"
        );

        if (userInput == null) {

            throw new NumberFormatException();
        }

        return Integer.parseInt(userInput);
    }
}
