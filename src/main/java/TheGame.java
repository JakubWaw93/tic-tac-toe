public class TheGame {
    GameMechanics gameMechanics = new GameMechanics();


    public void game () {
        try {
            gameMechanics.howManyPlayers();
        } catch (InvalidNumberOfPlayersException e) {
            Console.exceptionMessage(e.getMessage());
            game();
        }
        gameMechanics.multiGameLoop();
        Console.farewell();
    }
}
