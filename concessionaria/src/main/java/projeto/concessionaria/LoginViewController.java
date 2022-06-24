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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 *
 */
public class LoginViewController implements Initializable {

    @FXML
    private Pane paneTelaLogin;
    @FXML
    private ImageView imageLogoLogin;
    @FXML
    private Label labelMatricula;
    @FXML
    private TextField txtMatricula;
    @FXML
    private Label labelSenha;
    @FXML
    private PasswordField txtSenha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void entrarIndex(ActionEvent event) {
        try {
            App.setRoot("indexView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void esqueciSenha(ActionEvent event) {
        try {
            App.setRoot("recuperaContaVerificacaoView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
