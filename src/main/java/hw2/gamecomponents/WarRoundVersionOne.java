package hw2.gamecomponents;

import hw2.coreobjects.Dealer;
import hw2.coreobjects.Player;
import hw2.coreobjects.PlayerVersionOne;

public class WarRoundVersionOne implements WarRound{

    Dealer dealer = Dealer.getInstance();
    int NUMBER_OF_ADDITIONAL_CARDS = 3;

    @Override
    public Player war(Player[] players) {
        Player winner = new PlayerVersionOne("Winner");
       do{
        winner = playRoundOfWar(players);
       }while(tie(winner));

       giveCardsToWinner(players, winner);
       clearCardsInPlay(players);
       return winner;
    }

    private Player playRoundOfWar(Player[] players) {
        for(int i = 0; i < players.length; i++){
            for(int j= 0; j < NUMBER_OF_ADDITIONAL_CARDS; j++){
                players[i].playCard();
            }
        }
        int highestCard = dealer.determineHighestCard(players);
        int numberOfWinners = dealer.countNumberOfWinners(players, highestCard);
        if(numberOfWinners > 1){
            return null;
        }
        return dealer.determineWinner(players, highestCard);
    }

    private boolean tie(Player winner) {
        if(winner == null){
            return true;
        }
        else{
            return false;
        }
    }

    private void giveCardsToWinner(Player[] players, Player winner){
        for(int i = 0; i < players.length; i++){
            winner.addAllCardsToBottomOfPile(players[i].getAllCardsInPlay());
        }
    }

    private void clearCardsInPlay(Player[] players){//i feel should probalby be in Player
        for(int i = 0; i < players.length; i++){
            players[i].clearCardsInPlay();
        }
    }
    
}
