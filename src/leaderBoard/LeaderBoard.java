package leaderBoard;

import player.Player;
import player.PlayerInt;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeaderBoard implements LeaderBoardInt {

    private PriorityQueue<Player> leaderboard = new PriorityQueue<>();
    private int size;

    public LeaderBoard() {
        this.size = 5;
        Comparator<Player> playerComparator = Comparator.comparingLong(Player::getScore).reversed();
        this.leaderboard = new PriorityQueue<>(playerComparator);
    }

    public LeaderBoard(int size) {
        this.size = size;
        Comparator<Player> playerComparator = Comparator.comparingLong(Player::getScore).reversed();
        this.leaderboard = new PriorityQueue<>(playerComparator);
    }


    @Override
    public void addToLeaderboard(Player player) {
        leaderboard.offer(player);
        if (leaderboard.size() > size) {
            leaderboard.poll();
        }
    }

    @Override
    public void displayLeaderboard() {
        System.out.println("Leaderboard:");
        PriorityQueue<Player> temp = new PriorityQueue<>(leaderboard);
        while (!temp.isEmpty()) {
            Player player = temp.poll();
            System.out.println(player.getName() + " - " + player.getScore());
        }
    }
}
