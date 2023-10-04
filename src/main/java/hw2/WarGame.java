package hw2;

public class WarGame 
{
    public static void main( String[] args )
    {
        System.out.println("---------START OF PROGRAM---------");
        System.out.println("seed: " + args[0]);
        PlayGame.play(args);
    }
}
