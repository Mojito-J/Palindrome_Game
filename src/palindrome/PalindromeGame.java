package palindrome;

import leaderBoard.LeaderBoard;
import player.Player;

import java.util.HashMap;
import java.util.Map;

public class PalindromeGame implements PalindromeInt {
    private Map<String, Integer> usedTexts;
    private LeaderBoard leaderboard;

    public PalindromeGame() {
        this.usedTexts = new HashMap<>();
        this.leaderboard = new LeaderBoard();
    }

    public PalindromeGame(int leaderboardSize) {
        this.usedTexts = new HashMap<>();
        this.leaderboard = new LeaderBoard(leaderboardSize);
    }


    @Override
    public boolean isPalindrome(String text) {
        String cleanText = text.replaceAll("[^а-яА-Яa-zA-Z]", "").toLowerCase();
        String reversed = new StringBuilder(cleanText).reverse().toString();
        return cleanText.equals(reversed);
    }

    public void processText(String text, String playerName) {
        if (isPalindrome(text) && !usedTexts.containsKey(text)) {
            int points = text.length();
            usedTexts.put(text, points);

            Player player = new Player(playerName);
            player.addScore(points);
            leaderboard.addToLeaderboard(player);
        } else {
            System.out.println(text + " :" + "Текст не является палиндромом!!!");
        }
    }

    public void displayLeaderboard() {
        leaderboard.displayLeaderboard();
    }
}
