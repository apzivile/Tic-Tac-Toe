import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int iChange = scanner.nextInt();
        int jChange = scanner.nextInt();

        matrix[iChange][jChange] = matrix[jChange][iChange];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(); matrix[i][j] = scanner.nextInt();
            }
        }

    }
}