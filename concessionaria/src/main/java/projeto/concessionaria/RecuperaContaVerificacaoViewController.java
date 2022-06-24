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

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 *
 */
public class RecuperaContaVerificacaoViewController implements Initializable {

    @FXML
    private Pane paneVerificaConta;
    @FXML
    private Label labelMatricula;
    @FXML
    private TextField txtMatricula;
    @FXML
    private Label labelCPF;
    @FXML
    private TextField txtCPF;
    @FXML
    private Label labelEmail;
    @FXML
    private TextField txtEmail;
    @FXML
    private Label labelPerguntaSegurancaVerifica;
    @FXML
    private ComboBox<?> comboBoxPerguntaSegurancaVerifica;
    @FXML
    private Label labelRespostaSegurancaVerifica;
    @FXML
    private TextField txtRespostaSegurancaVerifica;
    @FXML
    private Label labelVerificaConta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void voltarLogin(ActionEvent event) {
        try {
            App.setRoot("loginView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void redefinirSenha(ActionEvent event) {
        try {
            App.setRoot("redefinirSenhaView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void linkLogin(ActionEvent event) {
        try {
            App.setRoot("loginView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
