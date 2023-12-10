import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

public class GameMechanicsTestSuit {

    @Nested
    @DisplayName("Tests for 'O' wins")
    class TestsOWins {

        @Test
        void winByOInRow1() {
            //Given
            GameMechanics gameMechanics = new GameMechanics();
            int winnerPlayer = 0;
            int[][] arrayOfFields = {
                    {2, 2, 2},
                    {0, 0, 0},
                    {0, 0, 0}
            };
            //When
            if (arrayOfFields[0][0] == arrayOfFields[0][1] && arrayOfFields[0][1] == arrayOfFields[0][2] && arrayOfFields[0][0] != 0) {
                winnerPlayer = arrayOfFields[0][0];
            }
            //Then
            assertEquals(2, winnerPlayer);
        }

        @Test
        void winByOInRow2() {
            //Given
            GameMechanics gameMechanics = new GameMechanics();
            int winnerPlayer = 0;
            int[][] arrayOfFields = {
                    {0, 0, 0},
                    {2, 2, 2},
                    {0, 0, 0}
            };
            //When
            if (arrayOfFields[1][0] == arrayOfFields[1][1] && arrayOfFields[1][1] == arrayOfFields[1][2] && arrayOfFields[1][2] != 0) {
                winnerPlayer = arrayOfFields[1][0];
            }
            //Then
            assertEquals(2, winnerPlayer);
        }


        @Test
        void winByOInRow3() {
            //Given
            GameMechanics gameMechanics = new GameMechanics();
            int winnerPlayer = 0;
            int[][] arrayOfFields = {
                    {0, 0, 0},
                    {0, 0, 0},
                    {2, 2, 2}
            };
            //When
            if (arrayOfFields[2][0] == arrayOfFields[2][1] && arrayOfFields[2][1] == arrayOfFields[2][2] && arrayOfFields[2][2] != 0) {
                winnerPlayer = arrayOfFields[2][0];
            }
            //Then
            assertEquals(2, winnerPlayer);
        }

        @Test
        void winByOInColumn1() {
            //Given
            GameMechanics gameMechanics = new GameMechanics();
            int winnerPlayer = 0;
            int[][] arrayOfFields = {
                    {2, 0, 0},
                    {2, 0, 0},
                    {2, 0, 0}
            };
            //When
            if (arrayOfFields[0][0] == arrayOfFields[1][0] && arrayOfFields[1][0] == arrayOfFields[2][0] && arrayOfFields[2][0] != 0) {
                winnerPlayer = arrayOfFields[0][0];
            }
            //Then
            assertEquals(2, winnerPlayer);
        }

        @Test
        void winByOInColumn2() {
            //Given
            GameMechanics gameMechanics = new GameMechanics();
            int winnerPlayer = 0;
            int[][] arrayOfFields = {
                    {0, 2, 0},
                    {0, 2, 0},
                    {0, 2, 0}
            };
            //When
            if (arrayOfFields[0][1] == arrayOfFields[1][1] && arrayOfFields[1][1] == arrayOfFields[2][1] && arrayOfFields[2][1] != 0) {
                winnerPlayer = arrayOfFields[0][1];
            }
            //Then
            assertEquals(2, winnerPlayer);
        }

        @Test
        void winByOInColumn3() {
            //Given
            GameMechanics gameMechanics = new GameMechanics();
            int winnerPlayer = 0;
            int[][] arrayOfFields = {
                    {0, 0, 2},
                    {0, 0, 2},
                    {0, 0, 2}
            };
            //When
            if (arrayOfFields[0][2] == arrayOfFields[1][2] && arrayOfFields[1][2] == arrayOfFields[2][2] && arrayOfFields[2][2] != 0) {
                winnerPlayer = arrayOfFields[0][2];
            }
            //Then
            assertEquals(2, winnerPlayer);
        }

        @Test
        void winByODiagonally1() {
            //Given
            GameMechanics gameMechanics = new GameMechanics();
            int winnerPlayer = 0;
            int[][] arrayOfFields = {
                    {0, 0, 2},
                    {0, 2, 0},
                    {2, 0, 0}
            };
            //When
            if (arrayOfFields[2][0] == arrayOfFields[1][1] && arrayOfFields[1][1] == arrayOfFields[0][2] && arrayOfFields[0][2] != 0) {
                winnerPlayer = arrayOfFields[2][0];
            }
            //Then
            assertEquals(2, winnerPlayer);
        }

        @Test
        void winByODiagonally2() {
            //Given
            GameMechanics gameMechanics = new GameMechanics();
            int winnerPlayer = 0;
            int[][] arrayOfFields = {
                    {2, 0, 0},
                    {0, 2, 0},
                    {0, 0, 2}
            };
            //When
            if (arrayOfFields[0][0] == arrayOfFields[1][1] && arrayOfFields[1][1] == arrayOfFields[2][2] && arrayOfFields[2][2] != 0) {
                winnerPlayer = arrayOfFields[0][0];
            }
            //Then
            assertEquals(2, winnerPlayer);
        }
    }

    @Nested
    @DisplayName("Tests for 'X' wins")
    class TestsXWins {

        @Test
        void winByXInRow1() {
            //Given
            GameMechanics gameMechanics = new GameMechanics();
            int winnerPlayer = 0;
            int[][] arrayOfFields = {
                    {1, 1, 1},
                    {0, 0, 0},
                    {0, 0, 0}
            };
            //When
            if (arrayOfFields[0][0] == arrayOfFields[0][1] && arrayOfFields[0][1] == arrayOfFields[0][2] && arrayOfFields[0][2] != 0) {
                winnerPlayer = arrayOfFields[0][0];
            }
            //Then
            assertEquals(1, winnerPlayer);
        }

        @Test
        void winByXInRow2() {
            //Given
            GameMechanics gameMechanics = new GameMechanics();
            int winnerPlayer = 0;
            int[][] arrayOfFields = {
                    {0, 0, 0},
                    {1, 1, 1},
                    {0, 0, 0}
            };
            if (arrayOfFields[1][0] == arrayOfFields[1][1] && arrayOfFields[1][1] == arrayOfFields[1][2] && arrayOfFields[1][2] != 0) {
                winnerPlayer = arrayOfFields[1][0];
            }
            //Then
            assertEquals(1, winnerPlayer);
        }

        @Test
        void winByXInRow3() {
            //Given
            GameMechanics gameMechanics = new GameMechanics();
            int winnerPlayer = 0;
            int[][] arrayOfFields = {
                    {0, 0, 0},
                    {0, 0, 0},
                    {1, 1, 1}
            };
            //When
            if (arrayOfFields[2][0] == arrayOfFields[2][1] && arrayOfFields[2][1] == arrayOfFields[2][2] && arrayOfFields[2][2] != 0) {
                winnerPlayer = arrayOfFields[2][0];
            }
            //Then
            assertEquals(1, winnerPlayer);
        }

        @Test
        void winByXInColumn1() {
            //Given
            GameMechanics gameMechanics = new GameMechanics();
            int winnerPlayer = 0;
            int[][] arrayOfFields = {
                    {1, 0, 0},
                    {1, 0, 0},
                    {1, 0, 0}
            };
            //When
            if (arrayOfFields[0][0] == arrayOfFields[1][0] && arrayOfFields[1][0] == arrayOfFields[2][0] && arrayOfFields[2][0] != 0) {
                winnerPlayer = arrayOfFields[0][0];
            }
            //Then
            assertEquals(1, winnerPlayer);
        }

        @Test
        void winByXInColumn2() {
            //Given
            GameMechanics gameMechanics = new GameMechanics();
            int winnerPlayer = 0;
            int[][] arrayOfFields = {
                    {0, 1, 0},
                    {0, 1, 0},
                    {0, 1, 0}
            };
            //When
            if (arrayOfFields[0][1] == arrayOfFields[1][1] && arrayOfFields[1][1] == arrayOfFields[2][1] && arrayOfFields[2][1] != 0) {
                winnerPlayer = arrayOfFields[0][1];
            }
            //Then
            assertEquals(1, winnerPlayer);
        }

        @Test
        void winByXInColumn3() {
            //Given
            GameMechanics gameMechanics = new GameMechanics();
            int winnerPlayer = 0;
            int[][] arrayOfFields = {
                    {0, 0, 1},
                    {0, 0, 1},
                    {0, 0, 1}
            };
            //When
            if (arrayOfFields[0][2] == arrayOfFields[1][2] && arrayOfFields[1][2] == arrayOfFields[2][2] && arrayOfFields[2][2] != 0) {
                winnerPlayer = arrayOfFields[0][2];
            }
            //Then
            assertEquals(1, winnerPlayer);
        }

        @Test
        void winByXDiagonally1() {
            //Given
            GameMechanics gameMechanics = new GameMechanics();
            int winnerPlayer = 0;
            int[][] arrayOfFields = {
                    {0, 0, 1},
                    {0, 1, 0},
                    {1, 0, 0}
            };
            //When
            if (arrayOfFields[2][0] == arrayOfFields[1][1] && arrayOfFields[1][1] == arrayOfFields[0][2] && arrayOfFields[0][2] != 0) {
                winnerPlayer = arrayOfFields[2][0];
            }
            //Then
            assertEquals(1, winnerPlayer);
        }

        @Test
        void winByXDiagonally2() {
            //Given
            GameMechanics gameMechanics = new GameMechanics();
            int winnerPlayer = 0;
            int[][] arrayOfFields = {
                    {1, 0, 0},
                    {0, 1, 0},
                    {0, 0, 1}
            };
            //When
            if (arrayOfFields[0][0] == arrayOfFields[1][1] && arrayOfFields[1][1] == arrayOfFields[2][2] && arrayOfFields[2][2] != 0) {
                winnerPlayer = arrayOfFields[0][0];
            }
            //Then
            assertEquals(1, winnerPlayer);
        }
    }


    @Test
    void FullMapTest() {
        //Given
        GameMechanics gameMechanics = new GameMechanics();
        int winnerPlayer = 0;
        boolean end = false;
        int[][] arrayOfFields = {
                {1, 1, 2},
                {2, 2, 1},
                {1, 2, 1}
        };
        //When
        int min = 2;
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
        if (arrayOfFields[0][0] == arrayOfFields[0][1] && arrayOfFields[0][1] == arrayOfFields[0][2] && arrayOfFields[0][0] != 0) {
            end = true;
            winnerPlayer = arrayOfFields[0][0];
        } else if (arrayOfFields[1][0] == arrayOfFields[1][1] && arrayOfFields[1][1] == arrayOfFields[1][2] && arrayOfFields[1][2] != 0) {
            end = true;
            winnerPlayer = arrayOfFields[1][0];
        } else if (arrayOfFields[2][0] == arrayOfFields[2][1] && arrayOfFields[2][1] == arrayOfFields[2][2] && arrayOfFields[2][2] != 0) {
            end = true;
            winnerPlayer = arrayOfFields[2][0];
        } else if (arrayOfFields[0][0] == arrayOfFields[1][0] && arrayOfFields[1][0] == arrayOfFields[2][0] && arrayOfFields[2][0] != 0) {
            end = true;
            winnerPlayer = arrayOfFields[0][0];
        } else if (arrayOfFields[0][1] == arrayOfFields[1][1] && arrayOfFields[1][1] == arrayOfFields[2][1] && arrayOfFields[2][1] != 0) {
            end = true;
            winnerPlayer = arrayOfFields[0][1];
        } else if (arrayOfFields[0][2] == arrayOfFields[1][2] && arrayOfFields[1][2] == arrayOfFields[2][2] && arrayOfFields[2][2] != 0) {
            end = true;
            winnerPlayer = arrayOfFields[0][2];
        } else if (arrayOfFields[0][0] == arrayOfFields[1][1] && arrayOfFields[1][1] == arrayOfFields[2][2] && arrayOfFields[2][2] != 0) {
            end = true;
            winnerPlayer = arrayOfFields[0][0];
        } else if (arrayOfFields[2][0] == arrayOfFields[1][0] && arrayOfFields[1][0] == arrayOfFields[0][2] && arrayOfFields[0][2] != 0) {
            end = true;
            winnerPlayer = arrayOfFields[2][0];
        }
        //Then
        assertTrue(end);
        assertEquals(0, winnerPlayer);
    }
    @Test
    void fieldNotFoundExceptionTest() throws FieldNotFoundException, NotEmptyFieldException {
        //Given
        GameMechanics gameMechanics = new GameMechanics();
        MockedStatic<Console> consoleMock = mockStatic(Console.class);
        when(Console.moveReaderColumns()).thenReturn("22");
        when(Console.moveReaderRows()).thenReturn("4");
        //When&Then
        assertThrows(FieldNotFoundException.class, gameMechanics::makeAMove);
    }
    @Test
    void notEmptyFieldExceptionTest() throws FieldNotFoundException, NotEmptyFieldException {
        //Given
        GameMechanics gameMechanics = new GameMechanics();
        MockedStatic<Console> consoleMock = mockStatic(Console.class);
        when(Console.moveReaderColumns()).thenReturn("2");
        when(Console.moveReaderRows()).thenReturn("1");
        MockedStatic<GameMechanics> gameMechanicsMockedStatic = mockStatic(GameMechanics.class);
        int[][] arrayOfFields = {
                {1, 1, 2},
                {2, 2, 1},
                {1, 2, 1},
        };
        when(GameMechanics.getArrayOfFields()).thenReturn(arrayOfFields);
        //When&Then
        assertThrows(NotEmptyFieldException.class, gameMechanics::makeAMove);
    }
}
