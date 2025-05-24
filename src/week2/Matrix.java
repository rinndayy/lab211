/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week2;

import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Matrix {
     private int rows;
    private int cols;
    private double[][] data;

    // Constructor
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    // Getters
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double[][] getData() {
        return data;
    }

    // Input matrix values
    public void inputMatrix(Scanner scanner) {
        System.out.println("Enter values for a " + rows + "x" + cols + " matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                while (true) {
                    System.out.print("Element [" + i + "][" + j + "]: ");
                    if (scanner.hasNextDouble()) {
                        data[i][j] = scanner.nextDouble();
                        break;
                    } else {
                        System.out.println("Values of matrix must be a number.");
                        scanner.next(); // Consume invalid input
                    }
                }
            }
        }
    }

    // Display the matrix
    public void displayMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("["  + data[i][j] + "]");
            }
            System.out.println();
        }
    }

    // Addition
    public Matrix additionMatrix(Matrix matrix2) {
        if (this.rows != matrix2.rows || this.cols != matrix2.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + matrix2.data[i][j];
            }
        }
        return result;
    }

    // Subtraction
    public Matrix subtractionMatrix(Matrix matrix2) {
        if (this.rows != matrix2.rows || this.cols != matrix2.cols) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for subtraction.");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] - matrix2.data[i][j];
            }
        }
        return result;
    }

    // Multiplication
    public Matrix multiplicationMatrix(Matrix matrix2) {
        if (this.cols != matrix2.rows) {
            throw new IllegalArgumentException("Number of columns of the first matrix must equal number of rows of the second matrix.");
        }
        Matrix result = new Matrix(this.rows, matrix2.cols);
        for (int i = 0; i < result.rows; i++) {
            for (int j = 0; j < result.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * matrix2.data[k][j];
                }
            }
        }
        return result;
    }
}
