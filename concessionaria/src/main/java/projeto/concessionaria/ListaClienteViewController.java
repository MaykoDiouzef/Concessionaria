/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package projeto.concessionaria;

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

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import projeto.dao.ClienteDAO;
import projeto.modelo.Cliente;

/**
 * FXML Controller class
 *
 *
 */
public class ListaClienteViewController implements Initializable {

    @FXML
    private Pane pnCadastroCliente;
    @FXML
    private Label labelCadastroCliente;
    @FXML
    private Label lblNome;
    @FXML
    private TextField txtNome;
    @FXML
    private Label lblEmail;
    @FXML
    private TextField txtEmail;
    @FXML
    private Label lblTelefone;
    @FXML
    private TextField txtTelefone;
    @FXML
    private Label lblLogradouro;
    @FXML
    private TextField txtLogradouro;
    @FXML
    private Label lblBairro;
    @FXML
    private TextField txtBairro;
    @FXML
    private Label lblNumero;
    @FXML
    private TextField txtNumero;
    @FXML
    private Label lblCidade;
    @FXML
    private TextField txtCidade;
    @FXML
    private Label lblEstado;
    @FXML
    private TextField txtEstado;
    @FXML
    private Label lblPais;
    @FXML
    private TextField txtPais;
    @FXML
    private TextField txtPesquisarCliente;
    @FXML
    private TextField txtCpf;
    @FXML
    private Label lblCpf;
    @FXML
    private Label labelCadastroCliente1;
    @FXML
    private Label lblCep;
    @FXML
    private TextField txtCep;

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

    private void limpaTextField() {
        txtPesquisarCliente.setText("");
        txtNome.setText("");
        txtCpf.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
        txtLogradouro.setText("");
        txtBairro.setText("");
        txtNumero.setText("");
        txtCidade.setText("");
        txtCep.setText("");
        txtEstado.setText("");
        txtPais.setText("");
    }

    @FXML
    private void btnpesquisarcliente(ActionEvent event) throws SQLException {

        String vazio = "";
        String verificaPesquisa = (String.valueOf(txtPesquisarCliente.getText()));
        String verificaNome = (String.valueOf(txtNome.getText()));

        if (vazio.equals(verificaPesquisa)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Informe o CPF do cliente, para poder pesquisar os registros!");
            alert.showAndWait();
        } else {
            try {

                Cliente cliente = new Cliente();
                cliente.setPesquisaCliente(txtPesquisarCliente.getText());
                ClienteDAO dao = new ClienteDAO();
                dao.buscar(cliente);

                try {
                    if (cliente.getIdCliente() != null) {
                        limpaTextField();
                        txtPesquisarCliente.setText(String.valueOf(cliente.getPesquisaCliente()));
                        txtCpf.setText(String.valueOf(cliente.getCpf()));
                        txtNome.setText(String.valueOf(cliente.getNome()));
                        txtEmail.setText(String.valueOf(cliente.getEmail()));
                        txtTelefone.setText(String.valueOf(cliente.getTelefone()));
                        txtLogradouro.setText(String.valueOf(cliente.getLogradouro()));
                        txtBairro.setText(String.valueOf(cliente.getBairro()));
                        txtNumero.setText(String.valueOf(cliente.getNumero()));
                        txtCep.setText(String.valueOf(cliente.getCep()));
                        txtCidade.setText(String.valueOf(cliente.getCidade()));
                        txtEstado.setText(String.valueOf(cliente.getEstado()));
                        txtPais.setText(String.valueOf(cliente.getPais()));
                    } else {
                        limpaTextField();
                        txtPesquisarCliente.setText(String.valueOf(cliente.getPesquisaCliente()));
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro!");
                        alert.setHeaderText(null);
                        alert.setContentText("Verifique o CPF!");
                        alert.showAndWait();
                    }
                } catch (Exception e) {
                    Logger.getLogger(ListaClienteViewController.class.getName()).log(Level.SEVERE, null, e);
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro!");
                    alert.setHeaderText(null);
                    alert.setContentText("Algo de errado ao exibir as informações!");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                Logger.getLogger(ListaClienteViewController.class.getName()).log(Level.SEVERE, null, e);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro!");
                alert.setHeaderText(null);
                alert.setContentText("Algo de errado na pesquisa!");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void btneditarcliente(ActionEvent event) throws SQLException {

        String vazio = "";
        String verificaPesquisa = (String.valueOf(txtPesquisarCliente.getText()));
        String verificaNome = (String.valueOf(txtNome.getText()));

        if (vazio.equals(verificaPesquisa)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Informe o CPF do cliente, para poder editar os registros!");
            alert.showAndWait();
        } else if (vazio.equals(verificaNome)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Informe o CPF do cliente corretamente, para poder editar os registros!");
            alert.showAndWait();
        } else {
            try {

                Cliente cliente = new Cliente();
                ClienteDAO dao = new ClienteDAO();
                cliente.setPesquisaCliente(txtPesquisarCliente.getText());
                dao.buscar(cliente);

                if (cliente.getIdPessoa() != null) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Editar informações do cliente!");
                    alert.setHeaderText(null);
                    alert.setContentText("Deseja alterar as informações do cliente?");
                    Optional<ButtonType> showAndWait = alert.showAndWait();
                    if (showAndWait.isPresent() && showAndWait.get() == ButtonType.OK) {

                        cliente.setPesquisaCliente(txtPesquisarCliente.getText());
                        cliente.setCpf(txtCpf.getText());
                        cliente.setNome(txtNome.getText());
                        cliente.setEmail(txtEmail.getText());
                        cliente.setTelefone(txtTelefone.getText());
                        cliente.setLogradouro(txtLogradouro.getText());
                        cliente.setBairro(txtBairro.getText());
                        cliente.setNumero(txtNumero.getText());
                        cliente.setCep(txtCep.getText());
                        cliente.setCidade(txtCidade.getText());
                        cliente.setEstado(txtEstado.getText());
                        cliente.setPais(txtPais.getText());
                        dao.editar(cliente);

                        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Sucesso!");
                        alerta.setHeaderText(null);
                        alerta.setContentText("As informações do cliente foram alteradas com sucesso!");
                        alerta.showAndWait();

                    } else {
                        limpaTextField();
                        txtPesquisarCliente.setText(String.valueOf(cliente.getPesquisaCliente()));
                        txtNome.setText(String.valueOf(cliente.getNome()));
                        txtCpf.setText(String.valueOf(cliente.getCpf()));
                        txtEmail.setText(String.valueOf(cliente.getEmail()));
                        txtTelefone.setText(String.valueOf(cliente.getTelefone()));
                        txtLogradouro.setText(String.valueOf(cliente.getLogradouro()));
                        txtBairro.setText(String.valueOf(cliente.getBairro()));
                        txtNumero.setText(String.valueOf(cliente.getNumero()));
                        txtCep.setText(String.valueOf(cliente.getCep()));
                        txtCidade.setText(String.valueOf(cliente.getCidade()));
                        txtEstado.setText(String.valueOf(cliente.getEstado()));
                        txtPais.setText(String.valueOf(cliente.getPais()));
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro!");
                    alert.setHeaderText(null);
                    alert.setContentText("Verifique o CPF do cliente!");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                Logger.getLogger(ListaClienteViewController.class.getName()).log(Level.SEVERE, null, e);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro!");
                alert.setHeaderText(null);
                alert.setContentText("Erro ao editar informações do cliente!");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void btnexcluircliente(ActionEvent event) throws SQLException, IOException {

        String vazio = "";
        String verificaPesquisa = (String.valueOf(txtPesquisarCliente.getText()));
        String verificaNome = (String.valueOf(txtNome.getText()));

        if (vazio.equals(verificaPesquisa)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Informe o CPF do cliente, para poder excluir os registros!");
            alert.showAndWait();
        } else if (vazio.equals(verificaNome)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Informe o CPF do cliente corretamente, para poder excluir os registros!");
            alert.showAndWait();
        } else {
            try {
                Cliente cliente = new Cliente();
                cliente.setPesquisaCliente(String.valueOf(txtPesquisarCliente.getText()));
                ClienteDAO dao = new ClienteDAO();
                dao.buscar(cliente);

                if (cliente.getIdCliente() != null) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Excluir informações do cliente");
                    alert.setHeaderText(null);
                    alert.setContentText("Deseja deletar as informações do cliente?");
                    Optional<ButtonType> showAndWait = alert.showAndWait();
                    if (showAndWait.isPresent() && showAndWait.get() == ButtonType.OK) {

                        cliente.setAjudaExcluir(cliente.getIdCliente());
                        dao.excluir(cliente);

                        if (cliente.getTotalVendaCliente() != 0) {
                            Alert alerta = new Alert(Alert.AlertType.ERROR);
                            alerta.setTitle("Erro!");
                            alerta.setHeaderText(null);
                            alerta.setContentText("Não é possível deletar, pois existe vendas vinculadas a este cliente!");
                            alerta.showAndWait();
                        } else {
                            limpaTextField();
                            Alert alerta = new Alert(Alert.AlertType.WARNING);
                            alerta.setTitle("Sucesso!");
                            alerta.setHeaderText(null);
                            alerta.setContentText("As informações do cliente foram deletas com sucesso!");
                            alerta.showAndWait();
                        }
                    }
                } else {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Erro!");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Informe o CPF do cliente corretamente, para poder excluir os registros!");
                    alerta.showAndWait();
                }
            } catch (SQLException e) {
                Logger.getLogger(ListaClienteViewController.class.getName()).log(Level.SEVERE, null, e);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro!");
                alert.setHeaderText(null);
                alert.setContentText("Erro ao excluir informações do cliente!");
                alert.showAndWait();
            }
        }
    }
}
