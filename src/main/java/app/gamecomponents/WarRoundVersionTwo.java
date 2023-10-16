package app.gamecomponents;

import app.coreobjects.Dealer;
import app.coreobjects.Player;

public class WarRoundVersionTwo implements WarRound {

    Dealer dealer = Dealer.getInstance();
    boolean gameEndsInTie = false;
    final int NUMBER_OF_ADDITIONAL_CARDS = 3;

    /*
     * This version of WarRound is compatible with n players; n > 1
     * 3 additional cards during the war.
     */
    public Player war(Player[] players) {
        Player winner;
        do {
            winner = playRoundOfWar(players);
        } while (tie(winner) && gameEndsInTie == false);

        if(winner == null){
            clearCardsInPlay(players);
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
                if (canPlayerPlayCards(players, i)) {
                    players[i].playCard();
                }
            }
        }
    }

    private boolean canPlayerPlayCards(Player[] players, int indexOfPlayer) {
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

    private void clearCardsInPlay(Player[] players) {
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
