package materials;

import java.util.Random;

public class Coin {

    private CoinState coinState;
    private static Coin coin = null;


    private Coin() {
    }

    public static Coin getInstance() {
        if (coin == null) {
            coin = new Coin();
        }
        return coin;
    }

    /**
     * Change l'état de la pièce.
     * 50% de probabilité d'obtenir HEADS, 50% de probabilité d'obtenir TAILS
     */
    public void throwCoin() {
        // TODO : Votre code ici
        Random lancer = new Random();
        coinState = (lancer.nextInt(2) == 0) ? CoinState.HEADS : CoinState.TAILS;
    }

    public CoinState getState() {
        return coinState;
    }


}
