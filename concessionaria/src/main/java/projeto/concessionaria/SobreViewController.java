/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projeto.concessionaria;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 *
 */
public class SobreViewController implements Initializable {

    @FXML
    private Label labelCadastroCliente;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void voltarIndex(ActionEvent event) {
        try {
            App.setRoot("indexView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void Usuario1(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        alert.setTitle("Informações da equipe");
        alert.setHeaderText(null);
        alert.setContentText("Informações do usuário.");
        alert.showAndWait();
    }

    @FXML
    private void Usuario2(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        alert.setTitle("Informações da equipe");
        alert.setHeaderText(null);
        alert.setContentText("Informações do usuário.");
        alert.showAndWait();
    }

    @FXML
    private void Usuario3(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        alert.setTitle("Informações da equipe");
        alert.setHeaderText(null);
        alert.setContentText("Informações do usuário.");
        alert.showAndWait();
    }

    @FXML
    private void Usuario4(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        alert.setTitle("Informações da equipe");
        alert.setHeaderText(null);
        alert.setContentText("Informações do usuário.");
        alert.showAndWait();
    }

    @FXML
    private void Usuario5(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        alert.setTitle("Informações da equipe");
        alert.setHeaderText(null);
        alert.setContentText("Informações do usuário.");
        alert.showAndWait();
    }

    @FXML
    private void Usuario6(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        alert.setTitle("Informações da equipe");
        alert.setHeaderText(null);
        alert.setContentText("Informações do usuário.");
        alert.showAndWait();
    }

    @FXML
    private void Usuario7(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        alert.setTitle("Informações da equipe");
        alert.setHeaderText(null);
        alert.setContentText("Informações do usuário.");
        alert.showAndWait();
    }

    @FXML
    private void Usuario8(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        alert.setTitle("Informações da equipe");
        alert.setHeaderText(null);
        alert.setContentText("Informações do usuário.");
        alert.showAndWait();
    }

}
