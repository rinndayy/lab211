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
public class Test {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComputerProgram calculator = new ComputerProgram();
        CalculatePerimeterAndArea cal = new CalculatePerimeterAndArea();
        int choice;
        do {
            System.out.println("-------- MENU --------");
            System.out.println("1.Computer Program Calculate");
            System.out.println("2.Calculate perimeter and area");
            System.out.println("3.Matrix");
            System.out.println("4. Exit");
            System.out.println("Please in put your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    int option;
                    do {
//                        displayMenuOne();
                        System.out.println("========= Calculator Program =========");
                        System.out.println("1. Normal Calculator");
                        System.out.println("2. BMI Calculator");
                        System.out.println("3. Exit");
                        System.out.print("Please choose one option: ");
                        option = scanner.nextInt();
                        scanner.nextLine();
                        switch (option) {
                            case 1:
                                runNormalCalculator(scanner, calculator);
                                break;
                            case 2:
                                runBMICalculator(scanner, calculator);
                                break;
                            case 3:
                                System.out.println("Exiting program.");
                                break;
                            default:
                                System.out.println("Invalid choice. Please select 1, 2, or 3.");
                        }
                    } while (option != 3);
                    break;
                }
                case 2:
                    cal.inputData();
                    cal.calculateAndDisplay();
                    break;
                case 3:
                    while (true) {
                        System.out.println("-------- MENU --------");
                        System.out.println("1. Addition of Matrices");
                        System.out.println("2. Subtraction of Matrices");
                        System.out.println("3. Multiplication of Matrices");
                        System.out.println("4. Exit");
                        System.out.print("Please select an option: ");
                        int option = scanner.nextInt();

                        if (option == 4) {
                            System.out.println("Exiting program.");
                            break;
                        }

                        System.out.print("Enter the number of rows for the matrices: ");
                        int rows = scanner.nextInt();
                        System.out.print("Enter the number of columns for the matrices: ");
                        int cols = scanner.nextInt();

                        Matrix matrix1 = new Matrix(rows, cols);
                        Matrix matrix2 = new Matrix(rows, cols);

                        System.out.println("Enter values for Matrix 1:");
                        matrix1.inputMatrix(scanner);
                        System.out.println("Enter values for Matrix 2:");
                        matrix2.inputMatrix(scanner);

                        try {
                            Matrix result = null;
                            switch (option) {
                                case 1:
                                    result = matrix1.additionMatrix(matrix2);
                                    System.out.println("-------- Result --------");
                                    result.displayMatrix();
                                    break;
                                case 2:
                                    result = matrix1.subtractionMatrix(matrix2);
                                    System.out.println("-------- Result --------");
                                    result.displayMatrix();
                                    break;
                                case 3:
                                    System.out.print("Enter the number of columns for the second matrix: ");
                                    int colsMatrix2 = scanner.nextInt();
                                    matrix2 = new Matrix(cols, colsMatrix2); // Adjust the size of Matrix 2
                                    System.out.println("Enter values for the second matrix:");
                                    matrix2.inputMatrix(scanner);
                                    result = matrix1.multiplicationMatrix(matrix2);
                                    System.out.println("-------- Result --------");
                                    result.displayMatrix();
                                    break;
                                default:
                                    System.out.println("Invalid option. Please try again.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }

            }
        } while (choice != 4);
    }

//    private static void displayMenuOne() {
//        System.out.println("========= Calculator Program =========");
//        System.out.println("1. Normal Calculator");
//        System.out.println("2. BMI Calculator");
//        System.out.println("3. Exit");
//        System.out.print("Please choose one option: ");
//    }
    private static void runNormalCalculator(Scanner scanner, ComputerProgram calculator) {
        double memory = 0.0;
        boolean firstInput = true;
        while (true) {
            try {
                if (firstInput) {
                    System.out.print("Enter number: ");
                    memory = calculator.validateNumber(scanner.nextLine());
                    firstInput = false;
                }
                System.out.print("Enter Operator: ");
                ComputerProgram.Operator operator = calculator.validateOperator(scanner.nextLine());
                if (operator == ComputerProgram.Operator.EQUALS) {
                    System.out.println("Result: " + memory);
                    return;
                }
                System.out.print("Enter number: ");
                double number = calculator.validateNumber(scanner.nextLine());
                memory = calculator.calculate(memory, operator, number);
                System.out.println("Memory: " + memory);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void runBMICalculator(Scanner scanner, ComputerProgram calculator) {
        try {
            System.out.print("Enter Weight (kg): ");
            double weight = calculator.validateNumber(scanner.nextLine());
            System.out.print("Enter Height (cm): ");
            double heightCm = calculator.validateNumber(scanner.nextLine());
            double heightM = heightCm / 100.0;
            double bmi = calculator.calculateBMI(weight, heightM);
            System.out.printf("BMI Number: %.2f%n", bmi);
            System.out.println("BMI Status: " + calculator.getBMIStatus(bmi));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
