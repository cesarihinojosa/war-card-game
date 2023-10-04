package hw2.gamecomponents;

import hw2.coreobjects.Dealer;
import hw2.coreobjects.Player;

public class GameRoundVersionOne implements GameRound{

    Dealer dealer = Dealer.getInstance();

    /*
     * Can be played with n number of players. n >= 2. 
     */
    @Override
    public Player playRound(Player[] players){
        playCards(players);
        int highestCard = dealer.determineHighestCard(players);
        Player winner = dealer.determineWinner(players, highestCard);
        int numberOfWinners = dealer.countNumberOfWinners(players, highestCard);
        if(numberOfWinners > 1){ //war
            return null;
        }
        else{
            giveCardsToWinner(players, winner);
            clearCardsInPlay(players);
            return winner;
        }
    }

    private void playCards(Player[] players){
        for(int i = 0; i < players.length; i++){
            players[i].playCard();
        }
    }

    private void giveCardsToWinner(Player[] players, Player winner){
        for(int i = 0; i < players.length; i++){
            winner.addCardToPile(players[i].getCardInPlay());
        }
    }

    private void clearCardsInPlay(Player[] players) {// i feel should probalby be in Player
        for (int i = 0; i < players.length; i++) {
            players[i].clearCardsInPlay();
        }
    }
}