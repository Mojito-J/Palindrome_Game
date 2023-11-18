package player;

import java.util.Objects;

public class Player implements PlayerInt {

    private String name;
    private long score;


    public Player(String name) {
        this.name = name;
        this.score = 0;
    }


    @Override
    public void addScore(long points) {
        score += points;
    }

    public String getName() {
        return name;
    }

    public long getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return score == player.score && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
