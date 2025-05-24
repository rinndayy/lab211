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
public class CalculatePerimeterAndArea {
    private double width, length, radius, sideA, sideB, sideC;

    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        
// Input for Rectangle
        System.out.print("Please input side width of Rectangle: ");
        width = scanner.nextDouble();
        System.out.print("Please input length of Rectangle: ");
        length = scanner.nextDouble();
        
// Input for Circle
        System.out.print("Please input radius of Circle: ");
        radius = scanner.nextDouble();
        
// Input for Triangle
        System.out.print("Please input side A of Triangle: ");
        sideA = scanner.nextDouble();
        System.out.print("Please input side B of Triangle: ");
        sideB = scanner.nextDouble();
        System.out.print("Please input side C of Triangle: ");
        sideC = scanner.nextDouble();

    }

    public void calculateAndDisplay() {
        // Rectangle
        double rectArea = width * length;
        double rectPerimeter = 2 * (width + length);
        
        System.out.println("-----Rectangle-----");
        System.out.printf("Width: %.2f\n", width);
        System.out.printf("Length: %.2f\n", length);
        System.out.printf("Area: %.2f\n", rectArea);
        System.out.printf("Perimeter: %.2f\n", rectPerimeter);
        // Circle
        double circleArea = Math.PI * radius * radius;
        double circlePerimeter = 2 * Math.PI * radius;
        
        System.out.println("-----Circle-----");
        System.out.printf("Radius: %.2f\n", radius);
        System.out.printf("Area: %.2f\n", circleArea);
        System.out.printf("Perimeter: %.2f\n", circlePerimeter);
        // Triangle
        double triPerimeter = sideA + sideB + sideC;
        double s = triPerimeter / 2; // Semi-perimeter for Heron's formula
        double triArea = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        
        System.out.println("-----Triangle-----");
        System.out.printf("Side A: %.2f\n", sideA);
        System.out.printf("Side B: %.2f\n", sideB);
        System.out.printf("Side C: %.2f\n", sideC);
        System.out.printf("Area: %.2f\n", triArea);
        System.out.printf("Perimeter: %.2f\n", triPerimeter);
    }
}
