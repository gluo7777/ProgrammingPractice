import java.util.Arrays;

/**
 * Assumptions - Matrix contains only 0s or 1s - Matrix is m x n
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        ZeroMatrix m = new ZeroMatrix();
        m.print(new int[][] { new int[] { 0, 1, 0, 1 }, new int[] { 1, 1, 1, 1 }, new int[] { 0, 1, 1, 1 } });
    }

    private void print(int[][] matrix) {
        System.out.printf("Result of \n%s is \n%s\n", toStr(matrix), toStr(zeroMatrix(matrix)));
    }

    private String toStr(int[][] matrix) {
        String s = "";
        for (int[] row : matrix) {
            s += Arrays.toString(row) + "\n";
        }
        return s;
    }

    private int[][] zeroMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 0) {
            return matrix;
        }

        int m[] = new int[matrix.length]; // rows
        int n[] = new int[matrix[0].length]; // columns

        // mark rows and columns with at least 1 zero

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < n.length; j++) {
                if (matrix[i][j] == 0) {
                    m[i] = -1;
                    n[j] = -1;
                }
            }
        }

        // replace matrix value with zero if there is a zero in its row or column

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < n.length; j++) {
                if (m[i] == -1 || n[j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }
}