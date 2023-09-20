package hw2.coreobjects;

public class Dealer {

    private static Dealer dealer = null;

    private Dealer(){
    }

    public static Dealer getInstance(){
        if (dealer == null) {
            dealer = new Dealer();
        }
        return dealer;
    }

    public void shuffleDeck(){
    }

    public void dealCards(){
    }

}
