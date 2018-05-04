package parser;

import matrix.Matrix;

public class MatrixParse {
    public static Matrix parse(String matrixString) {
        String substring = matrixString
                .substring(1, matrixString.length() - 1);

        int rows = 0;
        for (char c : substring.toCharArray())
            if (c == '[')
                rows++;

        double[][] doubles = new double[rows][];

        for (int i = 0, index = substring.indexOf('['); index != -1; i++, index = substring.indexOf('[')) {
            int cb = substring.indexOf(']');
            String[] numbers = substring
                    .substring(index + 1, cb)
                    .split(",");
            doubles[i] = new double[numbers.length];
            for (int j = 0; j < numbers.length; j++)
                doubles[i][j] = Double.parseDouble(numbers[j]);
            substring = substring
                    .substring(cb + 1, substring.length());
        }

        return new Matrix(doubles);
    }
}