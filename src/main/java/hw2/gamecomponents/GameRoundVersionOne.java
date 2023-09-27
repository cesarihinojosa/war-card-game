package hw2.gamecomponents;

import hw2.coreobjects.Dealer;
import hw2.coreobjects.Player;
import hw2.coreobjects.PlayerVersionOne;

public class GameRoundVersionOne implements GameRound{

    Dealer dealer = Dealer.getInstance();

    @Override
    public Player playRound(Player[] players){
        playCards(players);
        int highestCard = dealer.determineHighestCard(players);
        Player winner = new PlayerVersionOne("Winner");
        winner = dealer.determineWinner(players, highestCard);
        int numberOfWinners = dealer.countNumberOfWinners(players, highestCard);
    
        if(numberOfWinners > 1){ //war
            clearCardsInPlay(players);
            return null;
        }
        else{
            giveCardsToWinner(players, winner);
            return winner;
        }
    }

    private void playCards(Player[] players){
        for(int i = 0; i < players.length; i++){
            players[i].playCard();
        }
    }

    private void clearCardsInPlay(Player[] players){
        for(int i = 0; i < players.length; i++){
            players[i].clearCardsInPlay();
        }
    }

    private void giveCardsToWinner(Player[] players, Player winner){
        for(int i = 0; i < players.length; i++){
            winner.addCardToBottomOfPile(players[i].getCardInPlay());
            players[i].clearCardsInPlay();
        }
    }
    
}