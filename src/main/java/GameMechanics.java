import java.util.Arrays;
import java.util.Random;
import java.util.random.RandomGenerator;

public class GameMechanics {

    private static int numberOfPlayers=0;
    private static final int [][] arrayOfFields = new int [3][3];
    private static final int [][] biggerArrayOfFields = new int [10][10];
    private static int turnOfPlayer;
    private static boolean end = false;
    private boolean totalEnd = false;
    private static int winnerPlayer=0;
    private static int player1Points;
    private static int player2Points;
    private static int versionOfGame=0;



    public static int[][] getArrayOfFields() {
        return arrayOfFields;
    }
    public static int[][] getBiggerArrayOfFields() {
        return biggerArrayOfFields;
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
    public void whatVersionOfGame() throws InvalidVersionNumberException{
        try{
            int version = Integer.parseInt(Console.whatVersionOfGame());
            if (version == 1 || version == 2) {
                versionOfGame=version;
            }else{
                throw new InvalidVersionNumberException("Choose 1 to play classic game, or 2 to play extended version");
            }
        }catch (NumberFormatException e){
            Console.numberFormatExceptionMessage();
            whatVersionOfGame();
        }
    }

    public void makeAMove() throws FieldNotFoundException, NotEmptyFieldException {
        try {
            int moveI=Integer.parseInt(Console.moveReaderRows())-1;
            int moveJ=Integer.parseInt(Console.moveReaderColumns())-1;
            if (moveI >=0 && moveI <3 && moveJ >=0 && moveJ <3) {
                if (getArrayOfFields()[moveI][moveJ] == 0) {
                    getArrayOfFields()[moveI][moveJ] = turnOfPlayer;
                } else {
                    throw new NotEmptyFieldException("This field is not empty, You must choose empty field");
                }
            }else if (moveI == -1 || moveJ ==-1) {
                end = true;
            } else {
                throw new FieldNotFoundException("There is no such field!");
            }
        } catch (NumberFormatException e){
            Console.numberFormatExceptionMessage();
            makeAMove();
        }
    }
    public void makeAMoveForBiggerMap() throws FieldNotFoundException, NotEmptyFieldException {
        try {
            int moveI=Integer.parseInt(Console.moveReaderRows())-1;
            int moveJ=Integer.parseInt(Console.moveReaderColumns())-1;
            if (moveI >=0 && moveI <biggerArrayOfFields.length && moveJ >=0 && moveJ <biggerArrayOfFields.length) {
                if (biggerArrayOfFields[moveI][moveJ] == 0) {
                    biggerArrayOfFields[moveI][moveJ] = turnOfPlayer;
                } else {
                    throw new NotEmptyFieldException("This field is not empty, You must choose empty field");
                }
            }else if (moveI == -1 || moveJ ==-1){
                end=true;
            } else {
                throw new FieldNotFoundException("There is no such field!");
            }
        } catch (NumberFormatException e){
            Console.numberFormatExceptionMessage();
            makeAMoveForBiggerMap();
        }
    }
    public void computerMove(){
        Console.sayComputerMove();
        RandomGenerator random = new Random();
        boolean emptyField = false;
        while (!emptyField){
            if (versionOfGame==1) {
                int i = random.nextInt(arrayOfFields.length);
                int j = random.nextInt(arrayOfFields.length);
                if (arrayOfFields[i][j] == 0) {
                    arrayOfFields[i][j] = turnOfPlayer;
                    emptyField = true;
                }
            } else if (versionOfGame==2) {
                int i = random.nextInt(biggerArrayOfFields.length);
                int j = random.nextInt(biggerArrayOfFields.length);
                if (biggerArrayOfFields[i][j] == 0) {
                    biggerArrayOfFields[i][j] = turnOfPlayer;
                    emptyField = true;
                }
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
    public void arrayOfMovesForBiggerMap() throws FieldNotFoundException, NotEmptyFieldException {
        Console.whoseTurn();
        if (numberOfPlayers==2) {
            makeAMoveForBiggerMap();
        } else if (numberOfPlayers==1) {
            if (turnOfPlayer==1) {
                makeAMoveForBiggerMap();
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
    public void checkForVictory() {
        if(arrayOfFields[0][0]==arrayOfFields[0][1]&&arrayOfFields[0][1]==arrayOfFields[0][2]&&arrayOfFields[0][0]!=0){
            end=true;
            winnerPlayer=arrayOfFields[0][0];
        }else if(arrayOfFields[1][0]==arrayOfFields[1][1]&&arrayOfFields[1][1]==arrayOfFields[1][2]&&arrayOfFields[1][2]!=0){
            end=true;
            winnerPlayer=arrayOfFields[1][0];
        }else if(arrayOfFields[2][0]==arrayOfFields[2][1]&&arrayOfFields[2][1]==arrayOfFields[2][2]&&arrayOfFields[2][2]!=0){
            end=true;
            winnerPlayer=arrayOfFields[2][0];
        }else if(arrayOfFields[0][0]==arrayOfFields[1][0]&&arrayOfFields[1][0]==arrayOfFields[2][0]&&arrayOfFields[2][0]!=0){
            end=true;
            winnerPlayer=arrayOfFields[0][0];
        }else if(arrayOfFields[0][1]==arrayOfFields[1][1]&&arrayOfFields[1][1]==arrayOfFields[2][1]&&arrayOfFields[2][1]!=0){
            end=true;
            winnerPlayer=arrayOfFields[0][1];
        }else if(arrayOfFields[0][2]==arrayOfFields[1][2]&&arrayOfFields[1][2]==arrayOfFields[2][2]&&arrayOfFields[2][2]!=0){
            end=true;
            winnerPlayer=arrayOfFields[0][2];
        }else if(arrayOfFields[0][0]==arrayOfFields[1][1]&&arrayOfFields[1][1]==arrayOfFields[2][2]&&arrayOfFields[2][2]!=0){
            end=true;
            winnerPlayer=arrayOfFields[0][0];
        }else if(arrayOfFields[2][0]==arrayOfFields[1][1]&&arrayOfFields[1][1]==arrayOfFields[0][2]&&arrayOfFields[0][2]!=0){
            end=true;
            winnerPlayer=arrayOfFields[2][0];
        }
    }
    public int checkForVictoryForBiggerMap() {
        int[][] biggerArrayOfFields = getBiggerArrayOfFields();
        for (int k = 0; k < 6; k++) {
            for (int l = 0; l < 6; l++) {
                for (int i = 0; i < 5; i++) {
                    if (biggerArrayOfFields[i + k][0 + l] == biggerArrayOfFields[i + k][1 + l] && biggerArrayOfFields[i + k][1 + l] == biggerArrayOfFields[i + k][2 + l] && biggerArrayOfFields[i + k][2 + l] == biggerArrayOfFields[i + k][3 + l] && biggerArrayOfFields[i + k][3 + l] == biggerArrayOfFields[i + k][4 + l] && biggerArrayOfFields[i + k][4 + l] != 0) {
                        end = true;
                        winnerPlayer = biggerArrayOfFields[i + k][0 + l];
                    }
                }
                for (int j = 0; j < 5; j++) {
                    if (biggerArrayOfFields[0 + k][j + l] == biggerArrayOfFields[1 + k][j + l] && biggerArrayOfFields[1 + k][j + l] == biggerArrayOfFields[2 + k][j + l] && biggerArrayOfFields[2 + k][j + l] == biggerArrayOfFields[3 + k][j + l] && biggerArrayOfFields[3 + k][j + l] == biggerArrayOfFields[4 + k][j + l] && biggerArrayOfFields[4 + k][j + l] != 0) {
                        end = true;
                        winnerPlayer = biggerArrayOfFields[0 + k][j + l];
                    }
                }
                if (biggerArrayOfFields[0 + k][0 + l] == biggerArrayOfFields[1 + k][1 + l] && biggerArrayOfFields[1 + k][1 + l] == biggerArrayOfFields[2 + k][2 + l] && biggerArrayOfFields[2 + k][2 + l] == biggerArrayOfFields[3 + k][3 + l] && biggerArrayOfFields[3 + k][3 + l] == biggerArrayOfFields[4 + k][4 + l] && biggerArrayOfFields[4 + k][4 + l] != 0) {
                    end = true;
                    winnerPlayer = biggerArrayOfFields[0 + k][0 + l];
                } else if (biggerArrayOfFields[4 + k][0 + l] == biggerArrayOfFields[3 + k][1 + l] && biggerArrayOfFields[3 + k][1 + l] == biggerArrayOfFields[2 + k][2 + l] && biggerArrayOfFields[2 + k][2 + l] == biggerArrayOfFields[1 + k][3 + l] && biggerArrayOfFields[1 + k][3 + l] == biggerArrayOfFields[0 + k][4 + l] && biggerArrayOfFields[0 + k][4 + l] != 0) {
                    end = true;
                    winnerPlayer = biggerArrayOfFields[4 + k][0 + l];
                }
            }

        }return winnerPlayer;
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
    public void checkForFullBiggerMap(){
        int min=2;
        for (int[] arrayOfField : biggerArrayOfFields) {
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
    public void singleGameLoopForBiggerMap(){
        while (!isEnd()){
            try {
                arrayOfMovesForBiggerMap();
            } catch (FieldNotFoundException | NotEmptyFieldException e){
                Console.exceptionMessage(e.getMessage());
                singleGameLoopForBiggerMap();
            }
            Console.updateConsoleForBiggerMap();
            checkForVictoryForBiggerMap();
            checkForFullBiggerMap();
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
    public void multiGameLoopForBiggerMap(){
        while (!totalEnd) {
            while (!end) {
                setNewBiggerArray();
                GameMechanics.setTurnOfPlayer(1);
                Console.showInstructionsForBiggerMap();
                singleGameLoopForBiggerMap();
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
    public void setNewBiggerArray() {
        for (int[] arrayOfField : biggerArrayOfFields) {
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
    public static int getWinnerPlayer() {
        return winnerPlayer;
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public static int getVersionOfGame() {
        return versionOfGame;
    }

    public static boolean isEnd() {
        return end;
    }

    public static void setTurnOfPlayer(int turnOfPlayer) {
        GameMechanics.turnOfPlayer = turnOfPlayer;
    }
}
