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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 *
 */
public class RedefinirSenhaViewController implements Initializable {

    @FXML
    private Pane paneRedefinirSenha;
    @FXML
    private Label labelNovaSenha;
    @FXML
    private PasswordField txtNovaSenha;
    @FXML
    private Label labelNovaSenhaConfirma;
    @FXML
    private PasswordField txtNovaSenhaConfirma;
    @FXML
    private Label labelAlterarSenha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void loginConta(ActionEvent event) {
        try {
            App.setRoot("loginView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void verificaConta(ActionEvent event) {
        try {
            App.setRoot("recuperaContaVerificacaoView");
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

    @FXML
    private void linkVerificacaoConta(ActionEvent event) {
        try {
            App.setRoot("recuperaContaVerificacaoView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
