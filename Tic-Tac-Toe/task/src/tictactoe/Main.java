package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //create empty board size 3x3
        String[][] matrix = new String[3][3];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length; ++j) {
                matrix[i][j] = " ";
            }
        }
        buildBoard(matrix);
        coordinate(matrix);
    }

    public static void buildBoard(String[][] matrix) {
        //print empty board with borders
        System.out.println("---------");
        for (String[] strings : matrix) {
            System.out.print("|" + " ");
            for (int j = 0; j < matrix.length; ++j) {
                System.out.print(strings[j].replace("_", " ") + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    public static void coordinate(String[][] matrix) {
        boolean isChanged;
        boolean xTurn = true;
        boolean won = false;
        boolean xWon = false;
        boolean oWon = false;
        boolean draw = false;
        int count = 0;
        //lop until someone wins or is a draw
        do {
            //try main code and catch input exceptions
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the coordinates: ");
                //coordinate input
                int xCoordinate = sc.nextInt();
                int yCoordinate = sc.nextInt();
                //check if coordinates are between 1 and 3
                if (xCoordinate >= 1 && xCoordinate <= 3 && yCoordinate >= 1 && yCoordinate <= 3) {
                    //check if required space is empty
                    if (matrix[Math.abs(3 - yCoordinate)][Math.abs(xCoordinate - 1)].equals(" ")) {
                        //check if its x turn or o
                        if (xTurn) {
                            //replace empty space with X or O
                            matrix[Math.abs(3 - yCoordinate)][Math.abs(xCoordinate - 1)] = "X";
                            isChanged = true;
                            xTurn = false;
                        } else {
                            matrix[Math.abs(3 - yCoordinate)][Math.abs(xCoordinate - 1)] = "O";
                            isChanged = true;
                            xTurn = true;
                        }
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        isChanged = false;
                    }
                    xWon = victory(matrix, "X");
                    oWon = victory(matrix, "O");
                    if (xWon || oWon) {
                        won = true;
                    }
                    if (count == 9) {
                        draw = true;
                        won = true;
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (isChanged) {
                    count++;
                    buildBoard(matrix);
                }
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
            }
        } while (!won);

        if (xWon) {
            System.out.println("X wins");
        } else if (oWon) {
            System.out.println("O wins");
        } else if (draw) {
            System.out.println("Draw");
        }
    }

    public static boolean victory(String[][] matrix, String piece) {
        int counter = 0;
        for (String[] strings : matrix) {
            for (String string : strings) {
                if (counter == 3)
                    break;
                if (string.equals(piece))
                    counter++;
                else
                    counter = 0;
            }
            if (counter != 3)
                counter = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (counter == 3)
                    break;
                if (matrix[j][i].equals(piece))
                    counter++;
                else
                    counter = 0;
            }
            if (counter != 3)
                counter = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (counter == 3)
                break;
            if (matrix[i][i].equals(piece))
                counter++;
            else
                counter = 0;
        }
        if (matrix[0][2].equals(piece) && matrix[1][1].equals(piece) && matrix[2][0].equals(piece))
            counter = 3;
        return counter == 3;
    }
}
