public class TheGame {
    GameMechanics gameMechanics = new GameMechanics();


    public void game () {
        if (GameMechanics.getNumberOfPlayers() == 0) {
            try {
                gameMechanics.howManyPlayers();
            } catch (InvalidNumberOfPlayersException e) {
                Console.exceptionMessage(e.getMessage());
                game();
            }
        }
        if (GameMechanics.getVersionOfGame() == 0) {
            try {
                gameMechanics.whatVersionOfGame();
            } catch (InvalidVersionNumberException e) {
                Console.exceptionMessage(e.getMessage());
                game();
            }
        }
        gameMechanics.multiGameLoop();
        if (GameMechanics.isEnd()) {
            Console.farewell();
        }
    }
}
