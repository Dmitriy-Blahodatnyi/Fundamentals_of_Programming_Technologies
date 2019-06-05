package com.project.matrix;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.pow;

public class Matrix {
    private double[][] matrix;

    public Matrix(double[][] matrix) { setMatrix(matrix); }

    public double[][] getMatrix() { return matrix; }

    public void setMatrix(double[][] matrix) {
        if (isNull(matrix))
            throw new NullPointerException("The matrix is null!!!");
        if (hasEmptyRow(matrix))
            throw new IllegalStateException(
                    "The matrix is empty or has empty row(s)!!!");
        if (isNotMatrix(matrix))
            throw new IllegalArgumentException(
                    "The 2-dimensional array is not a matrix!!!");
        this.matrix = matrix;
    }

    private boolean isNull(double[][] matrix) { return matrix == null; }

    private boolean hasEmptyRow(double[][] matrix) {
        return matrix.length == 0 ||
                Arrays.stream(matrix).anyMatch(aMatrix -> aMatrix.length == 0);
    }

    private boolean isNotMatrix(double[][] matrix) {
        return Arrays.stream(matrix)
                .anyMatch(aMatrix -> aMatrix.length != matrix[0].length);
    }

    private boolean isSquareMatrix(double[][] matrix) {
        return matrix.length == matrix[0].length;
    }

    private boolean isSingleMatrix(double[][] matrix) {
        return matrix.length == 1;
    }

    public Matrix multiply(double number) {
        var rows = matrix.length;
        var columns = matrix[0].length;
        var result = new double[rows][columns];

        for (var i = 0; i < rows; i++)
            for (var j = 0; j < columns; j++)
                result[i][j] = matrix[i][j] * number;

        return new Matrix(result);
    }

    public Matrix multiply(Matrix mtr) {
        /*
         * multiplicand * multiplier = product
         * 4 multiplied by 3 (spoken as "3 times 4")
         * Here 3 and 4 are the "factors" and 12 is the "product".
         * */
        var multiplier = mtr.getMatrix();
        var aRows = matrix.length;
        var aColumns = matrix[0].length;
        var bRows = multiplier.length;
        var bColumns = multiplier[0].length;

        if (aColumns != bRows)
            throw new IllegalArgumentException("Count of columns: " + aColumns +
                    " of matrix-multiplicand IS NOT EQUAL TO count of rows: " +
                    bRows + " of matrix-multiplier => unable to multiply!!!");

        var product = new double[aRows][bColumns];

        for (var i = 0; i < aRows; i++)
            for (var j = 0; j < bColumns; j++)
                for (var k = 0; k < aColumns; k++)
                    product[i][j] += matrix[i][k] * multiplier[k][j];

        return new Matrix(product);
    }

    public Matrix addMatrix(Matrix mtr) {
        // augend + addend = sum
        var addend = mtr.getMatrix();
        var rows = matrix.length;
        var columns = matrix[0].length;

        if (rows != addend.length || columns != addend[0].length)
            throw new IllegalArgumentException("Unable to add matrices!!!");

        var sum = new double[rows][columns];
        for (var i = 0; i < rows; i++)
            for (var j = 0; j < columns; j++)
                sum[i][j] = matrix[i][j] + addend[i][j];

        return new Matrix(sum);
    }

    private Matrix findMinor(Matrix mtr, int row, int column) {
        var array = mtr.getMatrix();
        var minor = new double[array.length - 1][array.length - 1];

        for (var i = 0; i < array.length; i++)
            for (var j = 0; i != row && j < array[i].length; j++)
                if (j != column)
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] =
                            array[i][j];

        return new Matrix(minor);
    }

    private double findDeterminant(Matrix mtr) {
        var array = mtr.getMatrix();
        if (!isSquareMatrix(array))
            throw new IllegalArgumentException(
                    "Only in square matrix determinant can be found!!!");

        if (array.length == 1)
            return array[0][0];
        if (array.length == 2)
            return array[0][0] * array[1][1] - array[0][1] * array[1][0];

        return IntStream.range(0, array[0].length)
                .mapToDouble(i -> pow(-1, i) * array[0][i] *
                        findDeterminant(findMinor(new Matrix(array), 0, i)))
                .sum();
    }

    public Matrix findInvertibleMatrix() {
        var single = isSingleMatrix(matrix);
        if (single && this.matrix[0][0] != 0)
            return this;

        // знаходимо визначник матриці
        var determinant = single ? 0 : findDeterminant(this);
        if (determinant == 0)
            throw new IllegalArgumentException(
                    "The matrix is singular (degenerate) - вироджена!!!");

        var invertedMatrix = new double[matrix.length][matrix.length];

        // складаємо матрицю алгебраїчних доповнень
        for (var i = 0; i < matrix.length; i++)
            for (var j = 0; j < matrix[i].length; j++)
                invertedMatrix[i][j] = pow(-1, i + j) *
                        findDeterminant(findMinor(this, i, j));

        // транспонуємо матрицю та одразу ділимо на визначник
        var det = 1.0 / determinant;
        for (var i = 0; i < invertedMatrix.length; i++)
            for (var j = 0; j <= i; j++) {
                var temp = invertedMatrix[i][j];
                invertedMatrix[i][j] = invertedMatrix[j][i] * det;
                invertedMatrix[j][i] = temp * det;
            }

        return new Matrix(invertedMatrix);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        var matrix1 = (Matrix) o;
        return matrix[0].length == matrix1.getMatrix()[0].length &&
                matrix.length == matrix1.getMatrix().length &&
                Arrays.deepEquals(matrix, matrix1.getMatrix());
    }

    public String toString() {
        var builder = new StringBuilder("MATRIX={");
        Arrays.stream(this.matrix).forEach(aMatrix -> {
            builder.append(" [ ");
            IntStream.range(0, this.matrix[0].length)
                    .mapToObj(j -> String.format("%.2f ", aMatrix[j]))
                    .forEach(builder::append);
            builder.append("] ");
        });
        builder.append("}");
        return builder.toString();
    }
}