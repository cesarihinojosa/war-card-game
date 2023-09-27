package hw2.gamecomponents;

import hw2.coreobjects.Player;
import hw2.coreobjects.PlayerVersionOne;

public class WarRoundVersionOne implements WarRound{

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
            for(int j= 0; j < 3; j++){
                players[i].playCard();
            }
        }
        int highestCard = determineHighestCard(players);
        int numberOfWinners = countNumberOfWinners(players, highestCard);
        if(numberOfWinners > 1){
            return null;
        }
        return determineWinner(players, highestCard);
    }

    private int determineHighestCard(Player[] players){
        int highestCard = 0;
        for(int i = 0; i < players.length; i++){
            if(players[i].getCardInPlay().getFaceValue() > highestCard){
                highestCard = players[i].getCardInPlay().getFaceValue();
            }
        }
        return highestCard;
    }

    private int countNumberOfWinners(Player[] players, int highestCard){
        int numberOfWinners = 0;
        for(int i = 0; i < players.length; i++){
            if(highestCard == players[i].getCardInPlay().getFaceValue()){
                numberOfWinners++;
            }
        }
        return numberOfWinners;
    }

    private Player determineWinner(Player[] players, int highestCard){
        int indexOfWinner = -1;
        for(int i = 0; i < players.length; i++){
            if(highestCard == players[i].getCardInPlay().getFaceValue()){
                indexOfWinner = i;
            }
        }
        return players[indexOfWinner];
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
            winner.addCardsToPile(players[i].getAllCardsInPlay());
        }
    }

    private void clearCardsInPlay(Player[] players){
        for(int i = 0; i < players.length; i++){
            players[i].clearCardsInPlay();
        }
    }
    
}
