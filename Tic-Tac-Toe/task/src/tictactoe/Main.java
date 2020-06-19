package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("");
        String cells = scanner.nextLine();
        String[] cellArray = cells.split("(?<=\\G...)");

        System.out.println("---------");
        for (String s : cellArray) {
            System.out.println("|" + s.replace("", " ") + "|");
        }
        System.out.println("---------");

        boolean xWins = false;
        boolean oWins = false;
        int xCount = 0;
        int oCount = 0;
        boolean empty = false;

        for (int i = 0; i < cells.length(); i++) {
            if (cells.charAt(i) == 'X') {
                xCount++;
            }
            if (cells.charAt(i) == 'O') {
                oCount++;
            }
            if (cells.charAt(i) == '_') {
                empty = true;
            }
        }
        if (cells.charAt(0) == 'X' && cells.charAt(4) == 'X' && cells.charAt(8) == 'X' ||
                cells.charAt(2) == 'X' && cells.charAt(4) == 'X' && cells.charAt(6) == 'X' ||
                cells.charAt(1) == 'X' && cells.charAt(4) == 'X' && cells.charAt(7) == 'X' ||
                cells.charAt(0) == 'X' && cells.charAt(3) == 'X' && cells.charAt(4) == 'X' ||
                cells.charAt(2) == 'X' && cells.charAt(5) == 'X' && cells.charAt(8) == 'X') {
            xWins = true;
        }
        if (cells.charAt(0) == 'O' && cells.charAt(4) == 'O' && cells.charAt(8) == 'O' ||
                cells.charAt(2) == 'O' && cells.charAt(4) == 'O' && cells.charAt(6) == 'O' ||
                cells.charAt(1) == 'O' && cells.charAt(4) == 'O' && cells.charAt(7) == 'O' ||
                cells.charAt(0) == 'O' && cells.charAt(3) == 'O' && cells.charAt(4) == 'O' ||
                cells.charAt(2) == 'O' && cells.charAt(5) == 'O' && cells.charAt(8) == 'O') {
            oWins = true;
        }
        if (cells.charAt(0) == 'X' && cells.charAt(1) == 'X' && cells.charAt(2) == 'X' ||
                cells.charAt(3) == 'X' && cells.charAt(4) == 'X' && cells.charAt(5) == 'X' ||
                cells.charAt(6) == 'X' && cells.charAt(7) == 'X' && cells.charAt(8) == 'X') {
            xWins = true;
        }
        if (cells.charAt(0) == 'O' && cells.charAt(1) == 'O' && cells.charAt(2) == 'O' ||
                cells.charAt(3) == 'O' && cells.charAt(4) == 'O' && cells.charAt(5) == 'O' ||
                cells.charAt(6) == 'O' && cells.charAt(7) == 'O' && cells.charAt(8) == 'O') {
            oWins = true;

        }
        if (xWins) {
            System.out.println("X wins");
        } else if (oWins && !empty) {
            System.out.println("O wins");
        } else if (xCount == oCount && empty) {
            System.out.println("Game not finished");
        } else if (!xWins && !oWins && !empty) {
            System.out.println("Draw");
        } else if (xWins && oWins || xCount > oCount || oCount > xCount) {
            System.out.println("Impossible");
        }

    }

}
