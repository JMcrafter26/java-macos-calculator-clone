/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taschenrechner;

/**
 *
 * @author robby
 */

import javafx.scene.control.Button;
import javafx.scene.Scene;

public class Logic {
    int previusNumber = 0;
    String operator = "";
    long currentNumber = 0;
    javafx.scene.Scene scene; // Add a field for scene

    // Default constructor
    Logic() {
    }

    Logic(javafx.scene.Scene scene) {
        this.scene = scene; // Initialize scene in the constructor
    }

    public void handleNumber(int inputNumber) {

        // check if inputNumber is a digit
        // int number = Integer.parseInt(inputNumber);
        int number = inputNumber;

        System.out.println("You clicked: " + number);

        this.currentNumber = currentNumber * 10 + number;
        System.out.println("Current number: " + currentNumber);
        updateDisplay();
    }

    public void handleOperator(String inputOperator) {
        System.out.println("You clicked: " + inputOperator);
    }

    public void updateDisplay() {
        // use currentNumber and operator to update the display
        System.out.println("Update display");

        display(currentNumber + "");
    }

    public void display(String result) {
        System.out.println("Result: " + result);
        if (scene != null) {
            Button resultBtn = (Button) scene.lookup("#resultBtn");
            if (resultBtn != null) {
                resultBtn.setText(result);
                // based on the length of the result, set the font size
                if (result.length() > 7) {
                    resultBtn.setStyle("-fx-font-size: 30");
                } else {
                    resultBtn.setStyle("-fx-font-size: 60");
                }
            } else {
                System.out.println("Button with id 'resultBtn' not found");
            }
        } else {
            System.out.println("Scene is null");
        }
    }
}