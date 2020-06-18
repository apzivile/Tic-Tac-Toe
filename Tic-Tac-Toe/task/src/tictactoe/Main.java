package tictactoe;

import java.util.Arrays;
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


        int n = 3;
        String[][] matrix = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.next();
            }
        }



        String[] cellMatrix = cells.split("(?<=\\G.)");
        int count=0;
        System.out.println(cellMatrix.length);

        //for (int i =0; i < cellMatrix.length;i++){

        if (cells.startsWith("XXX")) {
            System.out.println("X wins");
        }
        if (cells.startsWith("OOO")) {
            System.out.println("O wins");
        }
        if (cells.substring(1,2).equals("XXX")){

            //   for (int j = 0; j < cellMatrix.length;j++){
            //      cellMatrix[i][j]= Arrays.toString(cells.split("(?<=\\G.)"));
        }
        // }
        //   for (int i =0; i < cellMatrix.length;i++){
        // for (int j = 0; j < cellMatrix.length;j++){
        //     System.out.println(cellMatrix[i][j] + " ");
        //  }
        // System.out.println();
        //}
        //   System.out.println(cellMatrix[0][0] + " ");

    }

}
