/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package taschenrechner;

import java.net.URL;
import java.util.ResourceBundle;

import org.w3c.dom.Node;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.*;
import javafx.scene.Scene;

/**
 *
 * @author mohrjohn
 */
public class FXMLDocumentController implements Initializable {
    private String firstNumber = "";
    private String currentNumber = "";
    private boolean isOperatorClicked = false;


    @FXML
    Button resultBtn;
    @FXML
    private Button deleteKey;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void handleNumber(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonText = button.getText();

        if (isOperatorClicked) {
            calculate();
            isOperatorClicked = false;
        }

        addNumber(buttonText);
    }

    private String calculationType;

    @FXML
    void addAction(ActionEvent event) {
        calculationSetup("+");
    }

    @FXML
    void minusAction(ActionEvent event) {
        calculationSetup("-");
    }

    @FXML
    void divideAction(ActionEvent event) {
        calculationSetup("/");
    }

    @FXML
    void multiplicationAction(ActionEvent event) {
        calculationSetup("*");
    }

    @FXML
    void hadleX(ActionEvent event) {
        System.out.println("You clicked x");
    }

    @FXML
    void power2Action(ActionEvent event) {
        System.out.println("You clicked power2");
        if (currentNumber.equals("")) {
            return;
        }
        double number = Double.parseDouble(currentNumber);
        number = Math.pow(number, 2);
        currentNumber = String.valueOf(number);
        if (currentNumber.endsWith(".0")) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 2);
        }
        updateDisplay(currentNumber);
    }

    // negateAction
    @FXML
    void negateAction(ActionEvent event) {
        System.out.println("You clicked negate");
        if (currentNumber.equals("") && firstNumber.equals("")) {
            return;
        }
        if (currentNumber.equals("")) {
            currentNumber = firstNumber;
            firstNumber = "";
        }
        double number = Double.parseDouble(currentNumber);
        number = number * -1;
        currentNumber = String.valueOf(number);
        if (currentNumber.endsWith(".0")) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 2);
        }
        updateDisplay(currentNumber);
    }

    @FXML
    void percentAction(ActionEvent event) {
        System.out.println("You clicked percent");
        if (currentNumber.equals("")) {
            return;
        }
        double number = Double.parseDouble(currentNumber);
        number = number / 100;
        currentNumber = String.valueOf(number);
        updateDisplay(currentNumber);
    }

        // if the user clicks the delete button
        @FXML
        void handleDelete(ActionEvent event) {
            System.out.println("You clicked delete");
    
            if (currentNumber.length() == 0 && firstNumber.length() == 0) {
                return;
            }
            if (currentNumber.length() > 0) {
                currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
                updateDisplay(currentNumber);
                return;
            }
            if (firstNumber.length() > 0) {
                firstNumber = firstNumber.substring(0, firstNumber.length() - 1);
                updateDisplay(firstNumber);
                return;
            }
        }
    
        @FXML
        void handleClear(ActionEvent event) {
            System.out.println("You clicked clear");
            currentNumber = "";
            firstNumber = "";
    
            updateDisplay(currentNumber);
        }

    @FXML
    void handleDot(ActionEvent event) {
        System.out.println("You clicked dot");
        if (currentNumber.contains(".")) {
            return;
        }
        if (currentNumber.equals("")) {
            currentNumber = "0.";
        } else {
            currentNumber += ".";
        }
        updateDisplay(currentNumber);
    }

    public void calculationSetup(String calculationType){
        System.out.println("You clicked: " + calculationType);
        this.calculationType = calculationType;
     
        if (!firstNumber.equals("")) {
            System.out.println("First number: " + firstNumber);
            calculate();
            return;
        }
        System.out.println("Current number: " + currentNumber);
        this.calculationType = calculationType;
        firstNumber = currentNumber;
        currentNumber = "";
        isOperatorClicked = true;
        // updateDisplay(firstNumber);
    }

    @FXML
    void calculate() {
        double firstNumberDouble = 0.0;
        double secondNumberDouble = 0.0;
        try {
            firstNumberDouble = Double.parseDouble(firstNumber);
            secondNumberDouble = Double.parseDouble(currentNumber);
        } catch (NumberFormatException e) {
            // System.out.println("Invalid number format.");
            return;
        }
        System.out.println("Calculate: " + firstNumberDouble + " " + calculationType + " " + secondNumberDouble);

        double result = 0;
        switch (calculationType) {
            case "+":
                result = firstNumberDouble + secondNumberDouble;
                break;
            case "-":
                result = firstNumberDouble - secondNumberDouble;
                break;
            case "*":
                result = firstNumberDouble * secondNumberDouble;
                break;
            case "/":
                if (secondNumberDouble != 0) {
                    result = firstNumberDouble / secondNumberDouble;
                } else {
                    System.out.println("Cannot divide by zero.");
                    return;
                }
                break;
            default:
                break;
        }
        firstNumber = String.valueOf(result);
        currentNumber = "";
        // if firstNumber ends with .0, remove it
        if (firstNumber.endsWith(".0")) {
            firstNumber = firstNumber.substring(0, firstNumber.length() - 2);
        }
        System.out.println("Result: " + firstNumber);
        updateDisplay(firstNumber);
    }


    public void updateDisplay(String number) {
        // resultBtn.setText(currentNumber);
        if (number.equals("")) {
            number = "0";
        }

        // check if number is periodic
        number = handlePeriodicNumbers(number);

        resultBtn.setText(number);

        int fontSize = 60;
        if (number.length() > 6) {
            fontSize = 40;
        }
        if (number.length() > 10) {
            fontSize = 30;
        }
        if (number.length() > 18) {
            fontSize = 20;
        }

        resultBtn.setStyle("-fx-font-size: " + fontSize + "px;");
    }

    public void addNumber(String number) {
        if(currentNumber.equals("") && number.equals("0")){
            return;
        }
        System.out.println("Number: " + number);
        System.out.println("Lolol");
        currentNumber += number;
        updateDisplay(currentNumber);
    }

    public void test() {
        // To check what math functions are available

        /*
        Square root: Math.sqrt()
        Square root 3: Math.cbrt()
        Power 2: Math.pow()
        Power 3: Math.pow()
        Sin: Math.sin()
        Cos: Math.cos()
        Tan: Math.tan()
        Sinh: Math.sinh()
        Cosh: Math.cosh()
        Tanh: Math.tanh()
        Logarithm: Math.log()
        Exponential: Math.exp()
        Random: Math.random()
        PI: Math.PI
        Copy Result: resultBtn.getText()

        (15 items)
        */
    }

    // detect periodic numbers (e.g. 1/3 = 0.3333333333333333 or 0.2222222222222223) and round them
    public String handlePeriodicNumbers(String number) {
        // check if number has a period (.)
        if (number.contains(".")) {

            // first check if the second last and the third last digits are the same
            if (number.charAt(number.length() - 2) != number.charAt(number.length() - 3)) {
                return number;
            }

            // remove the last digit
            number = number.substring(0, number.length() - 1);
            System.out.println("Number: " + number);

            // check if the digits before the last period are the same, and count them
            int count = 0;
            for (int i = number.length() - 2; i >= 0; i--) {
                if (number.charAt(i) == number.charAt(i - 1)) {
                    count++;
                } else {
                    break;
                }
            }
            System.out.println("Count: " + count);
            // if the count is more than 2, remove the periodic digits
            if (count > 2) {
                number = number.substring(0, number.length() - count);
            }
            number += "..";
        }
        return number;
    }


    // listen for key presses (e.g. 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 or +, -, *, /)
    public void handleKeyPress(Scene scene) {
        scene.setOnKeyPressed(e -> {
            System.out.println("Key Pressed: " + e.getText());
            // check if key is a digit
            if (Character.isDigit(e.getText().charAt(0))) {
                // trigger handleNumber method
                addNumber("" + e.getText());
            }
        });
    }

}