package hw2.gamecomponents;

import hw2.coreobjects.Dealer;
import hw2.coreobjects.Player;

public class WarRoundVersionTwo implements WarRound {

    Dealer dealer = Dealer.getInstance();
    boolean gameEndsInTie = false;
    final int NUMBER_OF_ADDITIONAL_CARDS = 3;
    final int NUMBER_OF_PLAYERS = 2;

    /*
     * This version of WarRound is hardcoded for 2 players and
     * 3 additional cards during the war.
     */
    @Override
    public Player war(Player[] players) {
        Player winner;
        do {
            winner = playRoundOfWar(players);
        } while (tie(winner) && gameEndsInTie == false);

        if(winner == null){
            return winner;
        }
        else{
            giveCardsToWinner(players, winner);
            clearCardsInPlay(players);
            return winner;
        }
    }

    private Player playRoundOfWar(Player[] players) {
        playCards(players);
        int highestCard = dealer.determineHighestCard(players);
        int numberOfWinners = dealer.countNumberOfWinners(players, highestCard);
        if (numberOfWinners > 1) {// tie
            checkIfplayersHaveNoMoreCards(players);
            return null;
        }
        else{
            return dealer.determineWinner(players, highestCard);
        }
    }

    private void playCards(Player[] players) {
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < NUMBER_OF_ADDITIONAL_CARDS; j++) {
                if (canPlayCards(players, i)) {
                    players[i].playCard();
                }
            }
        }
    }

    private boolean canPlayCards(Player[] players, int indexOfPlayer) {
        if(players[indexOfPlayer].getPile().size() < 1){
            return false;
        }
        else{
            return true;
        }
    }

    private void checkIfplayersHaveNoMoreCards(Player[] players) {
        if (players[0].getPile().size() == 0){
            gameEndsInTie = true;
            returnCardsToPlayers(players);
        }
    }

    private boolean tie(Player winner) {
        if (winner == null) {
            return true;
        } else {
            return false;
        }
    }

    private void giveCardsToWinner(Player[] players, Player winner) {
        for (int i = 0; i < players.length; i++) {
            winner.addManyCardsToPile(players[i].getAllCardsInPlay());
        }
    }

    private void clearCardsInPlay(Player[] players) {// i feel should probalby be in Player
        for (int i = 0; i < players.length; i++) {
            players[i].clearCardsInPlay();
        }
    }

    private void returnCardsToPlayers(Player[] players){
        for (int i = 0; i < players.length; i++) {
            players[i].addManyCardsToPile(players[i].getAllCardsInPlay());
        }
    }
}
