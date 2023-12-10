import java.util.Arrays;
import java.util.Random;
import java.util.random.RandomGenerator;

public class GameMechanics {

    private static int numberOfPlayers;
    private static final int [][] arrayOfFields = new int [3][3];
    private static int turnOfPlayer;
    private boolean end = false;
    private boolean totalEnd = false;
    private static int winnerPlayer;
    private static int player1Points;
    private static int player2Points;


    public static int[][] getArrayOfFields() {
        return arrayOfFields;
    }

    public void howManyPlayers() throws InvalidNumberOfPlayersException {
        try {
            int players = Integer.parseInt(Console.howManyPlayers());
            if (players == 1 || players == 2) {
                numberOfPlayers = players;
            } else {
                throw new InvalidNumberOfPlayersException("Choose 1 player to play against computer, \nor 2 players to play with your friend.");
            }
        }catch (NumberFormatException e){
            Console.numberFormatExceptionMessage();
            howManyPlayers();
        }
    }

    public void makeAMove() throws FieldNotFoundException, NotEmptyFieldException {
        try {
            int moveI=Integer.parseInt(Console.moveReaderRows())-1;
            int moveJ=Integer.parseInt(Console.moveReaderColumns())-1;
            if (moveI >=0 && moveI <3 && moveJ >=0 && moveJ <3) {
                if (arrayOfFields[moveI][moveJ] == 0) {
                    arrayOfFields[moveI][moveJ] = turnOfPlayer;
                } else {
                    throw new NotEmptyFieldException("This field is not empty, You must choose empty field");
                }
            } else {
                throw new FieldNotFoundException("There is no such field!");
            }
        } catch (NumberFormatException e){
            Console.numberFormatExceptionMessage();
            makeAMove();
        }
    }
    public void computerMove(){
        Console.sayComputerMove();
        RandomGenerator random = new Random();
        boolean emptyField = false;
        while (!emptyField){
            int i = random.nextInt(arrayOfFields.length);
            int j = random.nextInt(arrayOfFields.length);
            if (arrayOfFields[i][j]==0){
                arrayOfFields[i][j]=turnOfPlayer;
                emptyField=true;
            }
        }
    }
    public void arrayOfMoves() throws FieldNotFoundException, NotEmptyFieldException {
        Console.whoseTurn();
        if (numberOfPlayers==2) {
            makeAMove();
        } else if (numberOfPlayers==1) {
            if (turnOfPlayer==1) {
                makeAMove();
            } else if (turnOfPlayer==2) {
                computerMove();
            }
        }
    }

    public void addingPoint(){
        if (end){
            if (winnerPlayer==1) {
                player1Points++;
            } else if (winnerPlayer == 2) {
                player2Points++;
            }
        }
    }
    public void changeTurn(){
        if (turnOfPlayer==1) {
            turnOfPlayer = 2;
        } else if (turnOfPlayer==2) {
            turnOfPlayer=1;
        }
    }
    public void checkForVictory(){
        for (int i=0; i < arrayOfFields.length;i++) {
            for (int j = 0; j < arrayOfFields[i].length; j++) {

            }
        }
    }
    public void checkForFullMap(){
        int min=2;
        for (int[] arrayOfField : arrayOfFields) {
            for (int i : arrayOfField) {
                if (i < min) {
                    min = i;
                }
            }
        }
        if (min > 0) {
            end = true;
        }
    }

    public void singleGameLoop(){
        while (!isEnd()){
            try {
                arrayOfMoves();
            } catch (FieldNotFoundException | NotEmptyFieldException e){
                Console.exceptionMessage(e.getMessage());
                singleGameLoop();
            }
            Console.updateConsole();
            checkForVictory();
            checkForFullMap();
            if (!isEnd()) {
                changeTurn();
            }
        }
    }
    public void multiGameLoop(){
        while (!totalEnd) {
            while (!end) {
                setNewArray();
                GameMechanics.setTurnOfPlayer(1);
                Console.showInstructions();
                singleGameLoop();
                Console.showWinner();
                addingPoint();
                Console.showPoints();
            }
            try {
                playAgainMechanics();
            } catch (PlayAgainWrongOptionException e) {
                Console.exceptionMessage(e.getMessage());
            }
        }

    }
    public void playAgainMechanics() throws PlayAgainWrongOptionException{
        try {
            int playerChoice = Integer.parseInt(Console.playAgain());
            if (playerChoice == 1) {
                winnerPlayer = 0;
                end = false;
            } else if (playerChoice == 2) {
                totalEnd = true;
            } else {
                throw new PlayAgainWrongOptionException("Press '1' to play again or '2' to end.");
            }
        }catch (NumberFormatException e){
            Console.numberFormatExceptionMessage();
            playAgainMechanics();
        }
    }
    public void setNewArray() {
        for (int[] arrayOfField : arrayOfFields) {
            Arrays.fill(arrayOfField, 0);
        }
    }

    public static int getPlayer1Points() {
        return player1Points;
    }

    public static int getPlayer2Points() {
        return player2Points;
    }

    public static int getTurnOfPlayer() {
        return turnOfPlayer;
    }
    public int getWinnerPlayer() {
        return winnerPlayer;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public boolean isEnd() {
        return end;
    }

    public static void setTurnOfPlayer(int turnOfPlayer) {
        GameMechanics.turnOfPlayer = turnOfPlayer;
    }
}
