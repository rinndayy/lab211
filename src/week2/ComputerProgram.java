/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week2;

/**
 *
 * @author ADMIN
 */
public class ComputerProgram {
    enum Operator {
        ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/"), EXPONENT("^"), EQUALS("=");

        private final String symbol;

        private Operator(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }

        private static Operator fromString(String symbol) {
            for (Operator op : Operator.values()) {
                if (op.getSymbol().equals(symbol)) {
                    return op;
                }
            }
            return null;

        }

    }

    public double calculate(double a, Operator operator, double b) {
        switch (operator) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }
                return a / b;
            case EXPONENT:
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Invalid operator.");
        }
    }

    public double calculateBMI(double weight, double height) {
        if (height < 0) {
            throw new ArithmeticException("height must greater than zero ");
        }
        return weight / (height * height);
    }

    public String getBMIStatus(double bmi) {
        if (bmi < 19) {
            return "UNDER-STANDARD";
        } else if (bmi < 25) {
            return "STANDARD";
        } else if (bmi < 30) {
            return "OVERWEIGHT";
        } else if (bmi < 40) {
            return "FAT - SHOULD LOSE WEIGHT";
        } else {
            return "VERY FAT - SHOULD LOSE WEIGHT IMMEDIATELY";
        }
    }

    public double validateNumber(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid number format.");
        }
    }

    public Operator validateOperator(String input) {
        Operator op = Operator.fromString(input);
        if (op == null) {
            throw new IllegalArgumentException("Invalid operator. Please input one of (+, -, *, /, ^, =).");
        }
        return op;
    }
}


