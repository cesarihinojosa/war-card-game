package hw2.coreobjects;

public class PlayerVersionOne extends Player{

    public PlayerVersionOne(String name){
        this.name = name;
        createPile();
    }

    @Override
    public void addToPile(Card card) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToPile'");
    }
    
}
