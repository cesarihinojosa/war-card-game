// package hw2;

// import org.junit.Test;

// import hw2.coreobjects.Player;
// import hw2.coreobjects.PlayerVersionOne;
// import hw2.gameversions.GameOfWar;
// import hw2.gameversions.GameOfWarVersionOne;
// import hw2.gameversions.GameOfWarVersionTwo;

// public class PlayGameVersionOneTest {
//     int numOfRounds = 200;// TODO: change this to depend on the command arguments
//     GameOfWar gameOfWar = new GameOfWarVersionTwo();
//     PrintGame printGame = new PrintGame();

//     @Test
//     public void play(int a) {
//         setupGame();
//         for (int i = 0; i < numOfRounds; i++) {
//             Player winner = createPlayerObject();
//             winner = playRound();
//             if (winner == null) {
//                 winner = playWar();
//             }
//             if (gameEnded(winner)) {
//                 printStatus(winner);
//                 break;
//             }
//             printStatus(winner);
//             printScore();
//         }
//         printScore();
//         declareWinner();
//     }

//     private void setupGame() {
//         gameOfWar.setupGame.setup(gameOfWar.players);
//     }

//     private Player createPlayerObject() {
//         return new PlayerVersionOne();// change this to be variable
//     }

//     private Player playRound() {
//         return gameOfWar.gameRound.playRound(gameOfWar.players);
//     }

//     private Player playWar() {
//         printGame.printCurrentStatusWar(gameOfWar);
//         return gameOfWar.warRound.war(gameOfWar.players);
//     }

//     private void printStatus(Player winner) {
//         printGame.printCurrentStatusNormal(gameOfWar, winner);
//     }

//     private boolean gameEnded(Player winner) {
//         return gameOfWar.pointSystem.gameEnded(gameOfWar.players, winner);
//     }

//     private void declareWinner() {
//         Player winner = gameOfWar.pointSystem.determineWinner(gameOfWar.players);
//         if (winner != null) {
//             System.out.println(winner.getName() + " wins!");
//         } else {
//             System.out.println("tie!");
//         }
//         //System.exit(0);
//     }

//     private void printScore() {
//         printGame.printScore(gameOfWar.players);
//     }
// }
