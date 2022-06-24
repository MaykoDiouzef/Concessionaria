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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 *
 */
public class IndexViewController implements Initializable {

    @FXML
    private ImageView imageLogoIndex;
    @FXML
    private Pane pnIndex;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnvoltarLogin(ActionEvent event) {
        try {
            App.setRoot("loginView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void btncadastroveiculo(ActionEvent event) {
        try {
            App.setRoot("cadastroVeiculoView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void vendaVeiculo(ActionEvent event) {
        try {
            App.setRoot("realizarVendaView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void btncadastrocliente(ActionEvent event) {
        try {
            App.setRoot("cadastroClienteView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void btncadastrofuncionario(ActionEvent event) {
        try {
            App.setRoot("cadastroFuncionarioView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void btnlistacliente(ActionEvent event) {
        try {
            App.setRoot("listaClienteView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void btnlistaveiculo(ActionEvent event) {
        try {
            App.setRoot("listaVeiculoView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void btnlistafuncionario(ActionEvent event) {
        try {
            App.setRoot("listaFuncionarioView");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void telaSobre(MouseEvent event) {
        try {
            App.setRoot("sobreView");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
