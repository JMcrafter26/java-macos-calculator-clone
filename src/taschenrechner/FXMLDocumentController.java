/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package taschenrechner;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.io.*;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author John M.
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

    @FXML
    void power3Action(ActionEvent event) {
        System.out.println("You clicked power3");
        if (currentNumber.equals("")) {
            return;
        }
        double number = Double.parseDouble(currentNumber);
        number = Math.pow(number, 3);
        currentNumber = String.valueOf(number);
        if (currentNumber.endsWith(".0")) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 2);
        }
        updateDisplay(currentNumber);
    }

    @FXML
    void squareRootAction(ActionEvent event) {
        System.out.println("You clicked squareRoot");
        if (currentNumber.equals("")) {
            return;
        }
        double number = Double.parseDouble(currentNumber);
        number = Math.sqrt(number);
        currentNumber = String.valueOf(number);
        if (currentNumber.endsWith(".0")) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 2);
        }
        updateDisplay(currentNumber);
    }

    @FXML
    void squareRoot3Action(ActionEvent event) {
        System.out.println("You clicked squareRoot3");
        if (currentNumber.equals("")) {
            return;
        }
        double number = Double.parseDouble(currentNumber);
        number = Math.cbrt(number);
        currentNumber = String.valueOf(number);
        if (currentNumber.endsWith(".0")) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 2);
        }
        updateDisplay(currentNumber);
    }

    @FXML
    void sinAction(ActionEvent event) {
        System.out.println("You clicked sin");
        if (currentNumber.equals("")) {
            return;
        }
        double number = Double.parseDouble(currentNumber);
        number = Math.sin(number);
        currentNumber = String.valueOf(number);
        if (currentNumber.endsWith(".0")) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 2);
        }
        updateDisplay(currentNumber);
    }

    @FXML
    void cosAction(ActionEvent event) {
        System.out.println("You clicked cos");
        if (currentNumber.equals("")) {
            return;
        }
        double number = Double.parseDouble(currentNumber);
        number = Math.cos(number);
        currentNumber = String.valueOf(number);
        if (currentNumber.endsWith(".0")) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 2);
        }
        updateDisplay(currentNumber);
    }

    @FXML
    void tanAction(ActionEvent event) {
        System.out.println("You clicked tan");
        if (currentNumber.equals("")) {
            return;
        }
        double number = Double.parseDouble(currentNumber);
        number = Math.tan(number);
        currentNumber = String.valueOf(number);
        if (currentNumber.endsWith(".0")) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 2);
        }
        updateDisplay(currentNumber);
    }

    @FXML
    void sinhAction(ActionEvent event) {
        System.out.println("You clicked sinh");
        if (currentNumber.equals("")) {
            return;
        }
        double number = Double.parseDouble(currentNumber);
        number = Math.sinh(number);
        currentNumber = String.valueOf(number);
        if (currentNumber.endsWith(".0")) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 2);
        }
        updateDisplay(currentNumber);
    }

    @FXML
    void coshAction(ActionEvent event) {
        System.out.println("You clicked cosh");
        if (currentNumber.equals("")) {
            return;
        }
        double number = Double.parseDouble(currentNumber);
        number = Math.cosh(number);
        currentNumber = String.valueOf(number);
        if (currentNumber.endsWith(".0")) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 2);
        }
        updateDisplay(currentNumber);
    }

    @FXML
    void tanhAction(ActionEvent event) {
        System.out.println("You clicked tanh");
        if (currentNumber.equals("")) {
            return;
        }
        double number = Double.parseDouble(currentNumber);
        number = Math.tanh(number);
        currentNumber = String.valueOf(number);
        if (currentNumber.endsWith(".0")) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 2);
        }
        updateDisplay(currentNumber);
    }

    @FXML
    void logAction(ActionEvent event) {
        System.out.println("You clicked log");
        if (currentNumber.equals("")) {
            return;
        }
        double number = Double.parseDouble(currentNumber);
        number = Math.log(number);
        currentNumber = String.valueOf(number);
        if (currentNumber.endsWith(".0")) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 2);
        }
        updateDisplay(currentNumber);
    }

    @FXML
    void randomAction(ActionEvent event) {
        System.out.println("You clicked random");
        double number = Math.random();
        currentNumber = String.valueOf(number);
        if (currentNumber.endsWith(".0")) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 2);
        }
        updateDisplay(currentNumber);
    }

    @FXML
    void piAction(ActionEvent event) {
        System.out.println("You clicked pi");
        currentNumber = String.valueOf(Math.PI);
        updateDisplay("π");
    }

    @FXML
    void copyResultAction(ActionEvent event) {
        System.out.println("Copying result...");
        String result = resultBtn.getText();
        if (result.equals("Error")) {
            return;
        }
        try {
            java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new java.awt.datatransfer.StringSelection(result), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Copied result: " + result);
    }

    @FXML
    void infoAction(ActionEvent event) {
        System.out.println("You clicked info");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("MacOS Calculator");
        alert.setHeaderText("This application was created by John M. aka JMcrafter26.");
        alert.setContentText("This is a simple calculator clone for MacOS in Java. It is a simple project for my Java class. It is a simple calculator that can do the basics.\n\nVersion: 1.2");

        // add GitHub link
        ButtonType githubButton = new ButtonType("GitHub");
        alert.getButtonTypes().add(githubButton);

        alert.showAndWait().ifPresent(response -> {
            if (response == githubButton) {
                System.out.println("Opening GitHub...");
                try {
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://github.com/JMcrafter26/java-macos-calculator-clone"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }});
        
        
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
        // if number is not a number, delete the number
        if (currentNumber.equals("Infinity") || currentNumber.equals("-Infinity") || currentNumber.equals("NaN")) {
            currentNumber = "";
            updateDisplay(currentNumber);
            return;
        }

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
        updateDisplay(currentNumber + "");
    }

    public void calculationSetup(String calculationType) {
        System.out.println("You clicked: " + calculationType);
        System.out.println("Old operator: " + this.calculationType);

   

        if (!firstNumber.equals("")) {
            System.out.println("First number: " + firstNumber);
            calculate();
            this.calculationType = calculationType;
            // firstNumber = currentNumber;
            return;
        }

        this.calculationType = calculationType;
        System.out.println("New operator: " + this.calculationType);

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

        switch (number) {
            case "Infinity":
                number = "∞";
                break;
            case "-Infinity":
                number = "-∞";
                break;
            case "NaN":
                number = "Error";
                break;
            default:
                break;
        }

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
        if (currentNumber.equals("") && number.equals("0")) {
            return;
        }
        System.out.println("Number: " + number);
        currentNumber += number;
        updateDisplay(currentNumber);
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
    // I don't know why this is not working :'(
    public void handleKeyPress(Scene scene) {
        scene.setOnKeyPressed(e -> {
            System.out.println("Key Pressed: " + e.getText());
            System.out.println("I don't know why this is not working :(");
            // check if key is a digit
            if (Character.isDigit(e.getText().charAt(0))) {
                // trigger handleNumber method
                addNumber("" + e.getText());
            }
        });
    }

}
