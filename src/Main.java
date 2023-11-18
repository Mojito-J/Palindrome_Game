import palindrome.PalindromeGame;

public class Main {
    public static void main(String[] args) {
        PalindromeGame game = new PalindromeGame();


        game.processText("топот", "Player1");
        game.processText("а роза упала на лапу Азора", "Player2");
        game.processText("рарара", "Player3");
        game.processText("хи-их", "Player4");
        game.processText("Привет Мир", "Player5");


        game.displayLeaderboard();

    }
}