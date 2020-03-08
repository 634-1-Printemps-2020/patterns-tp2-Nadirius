package game;

import materials.Coin;
import materials.CoinState;
import player.Player;
import utils.Statistics;

import java.util.*;

public class Game {

    private Rules rules;
    private Coin coin;
    private Map<Player, List<CoinState>> history;

    public Game() {
        history = new HashMap<>();
    }

    /**
     * Ajouter un nouveau joueur au jeu
     *
     * @param player le nouveau joueur
     */
    public void addPlayer(Player player) {
        // TODO: Votre code ici
        if (!history.containsKey(player)) {
            history.put(player, new ArrayList<>());
        }
    }

    /**
     * Faire joueur tous les joueurs et stocker chaque partie dans history
     */
    public void play() {
        // TODO: Votre code ici
        rules = new Rules();
        coin = Coin.getInstance();
        Set<Player> players = new HashSet<>(history.keySet());
        while (!players.isEmpty())
            for (Iterator<Player> it = players.iterator(); it.hasNext(); ) {
                Player p = it.next();
                p.play(coin);
                history.get(p).add(coin.getState());
                if (rules.checkWin(history.get(p)))
                    it.remove();
            }
    }


    /**
     * Calculer des statistiques de la partie précédente
     *
     * @return Statistics
     */
    public Statistics getStatistics() {
        // TODO: Votre code ici
        return new Statistics(averageToWin(), fewerMovesToWin(), mostMovesToWin(), totalNumberMoves());
    }

    /**
     * Le nombre le plus grand de lancers pour avoir gagné une partie
     *
     * @return mostMovesToWin
     */
    private int mostMovesToWin() {
        //System.out.println("Le nombre le plus grand de lancers pour avoir gagné une partie :" + history.values().stream().max(Comparator.comparing(List::size)).get().size());
        return history.values().stream().max(Comparator.comparing(List::size)).get().size();
    }

    /**
     * Le nombre le plus petit de lancers pour avoir gagné une partie
     *
     * @return fewerMovesToWin
     */
    private int fewerMovesToWin() {
        //System.out.println("Le nombre le plus petit de lancers pour avoir gagné une partie :" + history.values().stream().min(Comparator.comparing(List::size)).get().size());
        return history.values().stream().min(Comparator.comparing(List::size)).get().size();
    }

    /**
     * Nombre total de lancers pour tous les joueurs
     *
     * @return totalNumberMoves
     */
    private int totalNumberMoves() {
        //System.out.println("Nombre total de lancers pour tous les joueurs :" + history.keySet().parallelStream().map(x -> history.get(x).size()).reduce(0, Integer::sum));
        return history.keySet().parallelStream().map(x -> history.get(x).size()).reduce(0, Integer::sum);
    }

    /**
     * Le nombre moyen de lancers pour gagner une partie
     *
     * @return averageToWin
     */
    private float averageToWin() {
        //System.out.println("Le nombre moyen de lancers pour gagner une partie :" + (float)totalNumberMoves()/history.keySet().size());
        return (float) totalNumberMoves() / history.keySet().size();
    }

    /**
     * Obtenir l'historique de tous les joueurs de la partie précédente
     *
     * @return Map contenant chaque joueur et la liste des ses lancers
     */
    public Map<Player, List<CoinState>> getHistory() {
        // TODO: Votre code ici
        return history;
    }


    /**
     * Obtenir l'historique d'un joueur spécifique
     *
     * @param player instance du joueur pour lequel on veut avoir l'historique
     * @return la liste des lancers d'un joueur
     */
    public List<CoinState> getSpecificHistory(Player player) {
        // TODO: Votre code ici
        return history.get(player);
    }

}
