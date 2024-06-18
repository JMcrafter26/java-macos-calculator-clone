/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package taschenrechner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.image.Image;
// import javafx.scene.layout.StackPane;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;


import javafx.scene.control.Button;
import javafx.scene.Scene;
import java.io.IOException;

// import FXMLDocumentController.java;

/**
 *
 * @author John M.
 */
public class Taschenrechner extends Application {
    @FXML
    Button resultBtn;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.getIcons().add(new Image("icon.png"));
        stage.setTitle("Calculator");

        Font.loadFont(Taschenrechner.class.getResource("/Inter.ttf").toExternalForm(), 10);

        // import FXMLDocumentController.java
        FXMLDocumentController controller = new FXMLDocumentController();
        // on key press
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                controller.handleKeyPress(scene);
            }
        });

        // event listener for resizing the window
        final boolean[] isExpertMode = {false};

        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            System.out.println("Width: " + newVal);
            if (newVal.intValue() > 800 && !isExpertMode[0]) {
                System.out.println("Switching to expert mode");
                try {
                    Parent expertRoot = FXMLLoader.load(getClass().getResource("Expert.fxml"));
                    Scene expertScene = new Scene(expertRoot);
                    stage.setScene(expertScene);
                    isExpertMode[0] = true;
                    stage.setMinWidth(820);
                    System.out.println("Successfully switched to expert mode");
                    System.out.println("Please just ignore the error message below, or fix it if you know how to");
                } catch (IOException e) {
                    System.out.println("Failed to switch to expert mode");
                    e.printStackTrace();
                }
            } else if (newVal.intValue() <= 800) {
                System.out.println("Width is 800 or less");
                if (isExpertMode[0]) {
                    System.out.println("Currently in expert mode, switching to normal mode");
                    try {
                        Parent mainRoot = FXMLLoader.load(getClass().getResource("Main.fxml"));
                        if (mainRoot == null) {
                            System.out.println("Failed to load Main.fxml");
                            return;
                        }
                        Scene mainScene = new Scene(mainRoot);
                        stage.setScene(mainScene);
                        isExpertMode[0] = false;
                        System.out.println("Successfully switched to normal mode");
                    } catch (IOException e) {
                        System.out.println("Failed to switch to normal mode");
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Not currently in expert mode, no need to switch");
                }
            }
        });


        // height
        scene.heightProperty().addListener((obs, oldVal, newVal) -> {
            System.out.println("Height: " + newVal);
        });

        // https://stackoverflow.com/questions/29080759/javafx-open-a-new-scene

        // set min width of the window
        stage.setMinWidth(360);
        stage.setMinHeight(480);
        stage.setMaximized(false);

    
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
