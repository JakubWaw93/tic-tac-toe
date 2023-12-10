import java.util.Scanner;

public class Console {

    private static final Scanner input = new Scanner(System.in);
    static GameMechanics gameMechanics = new GameMechanics();

    public static String howManyPlayers(){
        System.out.println("1 Player or 2 Players? ('1'/'2')");
        return input.nextLine();
    }

    public static void updateConsole() {
        String[][] fieldsMark = new String[3][3];
        int[][] fields = GameMechanics.getArrayOfFields();
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                fieldsMark[i][j]=" ";
                if (fields[i][j] == 1) {
                    fieldsMark[i][j] = "X";
                } else if (fields[i][j] == 2) {
                    fieldsMark[i][j] = "O";
                }
            }
        }
        System.out.println("  | 1 | 2 | 3 |");
        System.out.println("1 | " + fieldsMark[0][0] + " | " + fieldsMark[0][1] + " | " + fieldsMark[0][2] + " |");
        System.out.println("2 | " + fieldsMark[1][0] + " | " + fieldsMark[1][1] + " | " + fieldsMark[1][2] + " |");
        System.out.println("3 | " + fieldsMark[2][0] + " | " + fieldsMark[2][1] + " | " + fieldsMark[2][2] + " |");
    }
    public static void showWinner(){
        if (gameMechanics.getWinnerPlayer()==1) {
            System.out.println("The winner is player: " + gameMechanics.getWinnerPlayer());
        } else if (gameMechanics.getWinnerPlayer()==2) {
            if (gameMechanics.getNumberOfPlayers()==2) {
                System.out.println("The winner is player: " + gameMechanics.getWinnerPlayer());
            }else {
                System.out.println("Computer is the winner.");
            }
        } else {
            System.out.println("It's a draw.");
        }
    }

    public static void showInstructions(){
        System.out.println("To choose a field use correct Key: ");
        System.out.println("Key 1 - column/row 1");
        System.out.println("Key 2 - column/row 2");
        System.out.println("Key 3 - column/row 3");
        System.out.println("  | 1 | 2 | 3 |");
        System.out.println("1 |1.2|1.2|1.3|");
        System.out.println("2 |2.1|2.1|2.2|");
        System.out.println("3 |3.1|3.2|3.3|");
    }


    public static void whoseTurn(){
        if (GameMechanics.getTurnOfPlayer()==1) {
            System.out.println("Player's " + GameMechanics.getTurnOfPlayer() + " turn.");
        } else if (GameMechanics.getTurnOfPlayer()==2) {
            System.out.println("Player's " + GameMechanics.getTurnOfPlayer() + " turn.");

        }
    }
    public static String moveReaderColumns(){
        System.out.println("Choose a column (1/2/3)");
        return input.nextLine();
    }
    public static String moveReaderRows(){
        System.out.println("Choose a row (1/2/3)");
        return input.nextLine();
    }

    public static void sayComputerMove(){
        System.out.println("Computer turn.");
    }
    public static void numberFormatExceptionMessage(){
        System.out.println("You have to choose a number.");
    }
    public static void exceptionMessage(String s){
        System.out.println(s);
    }
    public static void showPoints() {
        if (gameMechanics.getNumberOfPlayers() == 1) {
            System.out.println("Player 1 points: " + GameMechanics.getPlayer1Points() + "\nPlayer 2 points: "
                    + GameMechanics.getPlayer2Points());
        } else if (gameMechanics.getNumberOfPlayers() == 2){
            System.out.println("Player 1 points: " + GameMechanics.getPlayer1Points() + "\nComputer points: "
                    + GameMechanics.getPlayer2Points());
        }
    }
    public static String playAgain(){
        System.out.println("Do You want to play again? (1-YES/2-NO)");
        return input.nextLine();
    }
    public static void farewell(){
        System.out.println("Until next time...");
    }




}
