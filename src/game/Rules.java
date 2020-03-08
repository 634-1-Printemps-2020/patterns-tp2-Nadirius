package game;

import materials.CoinState;

import java.util.List;

public class Rules {

    /**
     * Cette méthode permet de déterminer si une suite d'états de pièce permet de gagner à une partie
     *
     * @param states liste d'états pour un joueur
     * @return true si un joueur a gagné, false sinon
     */
    public boolean checkWin(List<CoinState> states) {
        // TODO: Votre code ici
        int cpt = 0;
        for (CoinState state : states) {
            if (state.toString().equals("HEADS")) {
                cpt++;
            } else {
                cpt = 0;
            }
        }
        return cpt == 3;
    }
}
