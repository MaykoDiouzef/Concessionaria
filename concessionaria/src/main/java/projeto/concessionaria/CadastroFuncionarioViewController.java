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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 *
 */
public class CadastroFuncionarioViewController implements Initializable {

    @FXML
    private Pane pnCadastroFuncionario;
    @FXML
    private TabPane tbpnFuncionario;
    @FXML
    private Tab tbDadosPessoaisFuncionario;
    @FXML
    private Pane pnDadosPessoaisFuncionario;
    @FXML
    private Label lblCadastroFuncionarioUm;
    @FXML
    private Label lblNome;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCPF;
    @FXML
    private Label lblCPF;
    @FXML
    private TextField txtEmail;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblTelefone;
    @FXML
    private TextField txtTelefone;
    @FXML
    private Label lblCEP;
    @FXML
    private TextField txtCEP;
    @FXML
    private Label lblBairro;
    @FXML
    private TextField txtBairro;
    @FXML
    private TextField txtNumero;
    @FXML
    private Label lblNumero;
    @FXML
    private Label lblLogradouro;
    @FXML
    private TextField txtLogradouro;
    @FXML
    private Label lblCidade;
    @FXML
    private TextField txtCidade;
    @FXML
    private TextField txtEstado;
    @FXML
    private Label lblEstado;
    @FXML
    private TextField txtPais;
    @FXML
    private Label lblPais;
    @FXML
    private Tab tbAdministrativo;
    @FXML
    private Pane pnAdministrativo;
    @FXML
    private Label lblMatricula;
    @FXML
    private TextField txtMatricula;
    @FXML
    private Label lblDataNascimento;
    @FXML
    private DatePicker dtDataNascimento;
    @FXML
    private Label lblSexo;
    @FXML
    private ComboBox<?> CbSexo;
    @FXML
    private Label lblSenha;
    @FXML
    private Label lblPerguntaSeguranca;
    @FXML
    private TextField txtPerguntaSeguranca;
    @FXML
    private Label lblRespostaSeguranca;
    @FXML
    private TextField txtRespostaSeguranca;
    @FXML
    private Label lblStatus;
    @FXML
    private ComboBox<?> cbStatus;
    @FXML
    private Label lblCargo;
    @FXML
    private ComboBox<?> cbCargo;
    @FXML
    private DatePicker dtDataContratacao;
    @FXML
    private Label lblSalario;
    @FXML
    private TextField txtSalario;
    @FXML
    private Label lblCadastroFuncionarioDois;
    @FXML
    private PasswordField psSenha;
    @FXML
    private Label lblDataContratacao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void voltar() {
        try {
            App.setRoot("indexView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void voltarIndex(ActionEvent event) {
        voltar();
    }

    @FXML
    private void btncadastrarFuncionario(ActionEvent event) {
    }

}
