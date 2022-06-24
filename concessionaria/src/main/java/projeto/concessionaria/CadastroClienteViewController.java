/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projeto.concessionaria;

import projeto.dao.ClienteDAO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import projeto.modelo.Cliente;

/**
 * FXML Controller class
 *
 *
 */
public class CadastroClienteViewController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTelefone;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtEstado;
    @FXML
    private Label labelCadastroCliente;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblTelefone;
    @FXML
    private Label lblCidade;
    @FXML
    private Label lblEstado;
    @FXML
    private TextField txtBairro;
    @FXML
    private Label lblBairro;
    @FXML
    private Label lblNumero;
    @FXML
    private TextField txtNumero;
    @FXML
    private Label lblPais;
    @FXML
    private TextField txtPais;
    @FXML
    private Label lblLogradouro;
    @FXML
    private TextField txtLogradouro;
    @FXML
    private Pane pnCadastroCliente;
    @FXML
    private Label lblCPF;
    @FXML
    private TextField txtCpf;
    @FXML
    private Label labelCadastroCliente1;
    @FXML
    private Label lblCep;
    @FXML
    private TextField txtCep;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
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

    private void limpaTextField() {
        txtNome.setText("");
        txtCpf.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
        txtLogradouro.setText("");
        txtBairro.setText("");
        txtNumero.setText("");
        txtCep.setText("");
        txtCidade.setText("");
        txtEstado.setText("");
        txtPais.setText("");
    }

    @FXML
    private void cadastrarVoltarIndex(ActionEvent event) {

        String vazio = "";

        if (vazio.equals(txtNome.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Erro ao cadastrar o cliente, preencha todos os campos!");
            alert.showAndWait();
        } else {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Cadastro de cliente");
            alert.setHeaderText(null);
            alert.setContentText("Deseja cadastrar o cliente?");
            Optional<ButtonType> showAndWait = alert.showAndWait();
            if (showAndWait.isPresent() && showAndWait.get() == ButtonType.OK) {

                try {

                    Cliente cliente = new Cliente();
                    cliente.setNome(txtNome.getText());
                    cliente.setCpf(txtCpf.getText());
                    cliente.setEmail(txtEmail.getText());
                    cliente.setTelefone(txtTelefone.getText());
                    cliente.setLogradouro(txtLogradouro.getText());
                    cliente.setBairro(txtBairro.getText());
                    cliente.setNumero(txtNumero.getText());
                    cliente.setCep(txtCep.getText());
                    cliente.setCidade(txtCidade.getText());
                    cliente.setEstado(txtEstado.getText());
                    cliente.setPais(txtPais.getText());
                    ClienteDAO dao = new ClienteDAO();
                    dao.inserir(cliente);

                    limpaTextField();

                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Sucesso!");
                    alerta.setHeaderText(null);
                    alerta.setContentText("As informações do cliente foram cadastradas com sucesso!");
                    alerta.showAndWait();

                } catch (SQLException ex) {
                    Logger.getLogger(ListaClienteViewController.class.getName()).log(Level.SEVERE, null, ex);
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Erro");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Infelizmente existe algum erro no sistema.");
                    alerta.showAndWait();
                }
            } else {
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setTitle(null);
                alerta.setHeaderText(null);
                alerta.setContentText("Deseja limpar a tela?!");
                Optional<ButtonType> showAndWaitl = alerta.showAndWait();
                if (showAndWaitl.isPresent() && showAndWaitl.get() == ButtonType.OK) {
                    limpaTextField();
                }
            }
        }
    }
}
