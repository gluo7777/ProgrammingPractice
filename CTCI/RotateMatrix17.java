public class RotateMatrix17 {
    public static void main(String[] args) {
        RotateMatrix17 r = new RotateMatrix17();
        r.test(new Character[][] { { 'a' } });
        r.test(new Character[][] { { 'a', 'b', 'c', 'd' }, { 'l', 'w', 'x', 'e' }, { 'k', 'y', 'z', 'f' },
                { 'j', 'i', 'h', 'g' } });
        r.test(new Character[][] { { 'a', 'b', 'c', 'd', '1' }, { 'l', 'w', 'x', 'e', '2' },
                { 'k', 'y', 'z', 'f', '3' }, { 'j', 'i', 'h', 'g', '4' }, { '5', '6', '7', '8', '9' } });
    }

    private void test(Character[][] matrix) {
        String before = Common.toStr(matrix);
        rotate(matrix);
        String after = Common.toStr(matrix);
        System.out.printf("Before:\n%s\nAfter:\n%s\n", before, after);
    }

    private void rotate(Character[][] matrix) {
        // input check
        if (matrix == null || matrix.length == 0) {
            return;
        }

        // not square
        for (int i = 0; i < matrix.length; i++) {
            if (matrix.length != matrix[i].length) {
                return;
            }
        }

        // rotate layer by layer
        int layers = matrix.length / 2;
        for (int i = 0; i < layers; i++) {
            rotate(matrix, i, matrix.length - 1 - i);
        }
    }

    // rotate in-place index by index
    private void rotate(Character[][] matrix, int start, int end) {
        for (int i = start; i < end; i++) {
            int offset = i - start;
            char temp = matrix[start][start + offset];
            matrix[start][start + offset] = matrix[start + offset][end];
            matrix[start + offset][end] = matrix[end][end - offset];
            matrix[end][end - offset] = matrix[end - offset][start];
            matrix[end - offset][start] = temp;
        }
    }

}