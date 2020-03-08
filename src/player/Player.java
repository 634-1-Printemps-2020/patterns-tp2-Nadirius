package player;

import materials.Coin;

import java.util.Objects;

public class Player {

    private int id;

    public Player(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return id == player.id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void play(Coin coin) {
        coin.throwCoin();
    }

}
