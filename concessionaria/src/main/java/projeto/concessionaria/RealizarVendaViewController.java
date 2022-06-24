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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import projeto.dao.ClienteDAO;
import projeto.dao.VeiculoDAO;
import projeto.dao.VendaDAO;
import projeto.modelo.Cliente;
import projeto.modelo.Funcionario;
import projeto.modelo.Veiculo;
import projeto.modelo.Venda;

/**
 * FXML Controller class
 *
 *
 */
public class RealizarVendaViewController implements Initializable {

    @FXML
    private TabPane tbpnVenda;
    @FXML
    private Tab tbCliente;
    @FXML
    private Pane pnCliente;
    @FXML
    private Label lblVendaUm;
    @FXML
    private Label lblConfirmarDadosCliente;
    @FXML
    private Label lblInformeCPF;
    @FXML
    private TextField txtPesquisarCliente;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblExibeNome;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblExibeEmail;
    @FXML
    private Label lblTelefone;
    @FXML
    private Label lblExibeTelefone;
    @FXML
    private Label Logradouro;
    @FXML
    private Label lblExibeLogradouro;
    @FXML
    private Label lblExibeBairro;
    @FXML
    private Label lblBairro;
    @FXML
    private Label lblNumero;
    @FXML
    private Label lblExibeNumero;
    @FXML
    private Label lblExibeCidade;
    @FXML
    private Label lblCidade;
    @FXML
    private Label lblEstado;
    @FXML
    private Label lblExibeEstado;
    @FXML
    private Label lblExibePais;
    @FXML
    private Label lblPais;
    @FXML
    private Tab tbVeiculo;
    @FXML
    private Pane pnVeiculo;
    @FXML
    private Label lblVendaDois;
    @FXML
    private Label lblConfirmarDadosVeiculo;
    @FXML
    private TextField txtPesquisarVeiculo;
    @FXML
    private Label lblInformeChassi;
    @FXML
    private Label lblFabricante;
    @FXML
    private Label lblModelo;
    @FXML
    private Label lblVersao;
    @FXML
    private Label lblCategoria;
    @FXML
    private Label lblCor;
    @FXML
    private Label lblAnoFabricacao;
    @FXML
    private Label lblAnoModelo;
    @FXML
    private Label lblCondicaoVeiculo;
    @FXML
    private Label lblNumeroPortas;
    @FXML
    private Label lblTipoCambio;
    @FXML
    private Tab tbVenda;
    @FXML
    private Pane pnVenda;
    @FXML
    private Label lblVendaTres;
    @FXML
    private Label lblValorVenda;
    @FXML
    private TextField txtValorVenda;
    @FXML
    private Label lblFormaPagamento;
    @FXML
    private TextField txtFormaPagamento;
    @FXML
    private Label lblConfirmarDadosVenda;
    @FXML
    private Label lblExibeFabricante;
    @FXML
    private Label lblExibeModelo;
    @FXML
    private Label lblExibeVersao;
    @FXML
    private Label lblExibeCategoria;
    @FXML
    private Label lblExibeCor;
    @FXML
    private Label lblExibeAnoFabricacao;
    @FXML
    private Label lblExibeAnoModelo;
    @FXML
    private Label lblExibeCondicaoVeiculo;
    @FXML
    private Label lblExibeNumeroPortas;
    @FXML
    private Label lblExibeTipoCambio;
    @FXML
    private Label lblRecebeIdCliente;
    @FXML
    private Label lblRecebeIdVeiculo;
    @FXML
    private Label lblRecebeIdFuncionario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        limparLabelCliente();
        limparLabelVeiculo();
        limparTextField();
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

    private void limparLabelCliente() {

        lblRecebeIdCliente.setText("");
        lblExibeNome.setText("");
        lblExibeEmail.setText("");
        lblExibeTelefone.setText("");
        lblExibeLogradouro.setText("");
        lblExibeBairro.setText("");
        lblExibeNumero.setText("");
        //lblExibreCep.setText("");
        lblExibeCidade.setText("");
        lblExibeEstado.setText("");
        lblExibePais.setText("");
    }

    private void limparLabelVeiculo() {
        
        lblRecebeIdVeiculo.setText("");
        lblExibeAnoFabricacao.setText("");
        lblExibeAnoModelo.setText("");
        lblExibeCategoria.setText("");
        lblExibeCondicaoVeiculo.setText("");
        lblExibeCor.setText("");
        lblExibeFabricante.setText("");
        lblExibeModelo.setText("");
        lblExibeNumeroPortas.setText("");
        lblExibeTipoCambio.setText("");
        lblExibeVersao.setText("");
    }

    private void limparTextField() {
        
        lblRecebeIdFuncionario.setText("");
        txtFormaPagamento.setText("");
        txtValorVenda.setText("");
        txtPesquisarCliente.setText("");
        txtPesquisarVeiculo.setText("");
        
    }

    @FXML
    private void btnpesquisarcliente(ActionEvent event) {

        String vazio = "";
        String verificaPesquisa = (String.valueOf(txtPesquisarCliente.getText()));

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
                        limparLabelCliente();
                        
                        lblRecebeIdCliente.setText(String.valueOf(cliente.getIdCliente()));
                        txtPesquisarCliente.setText(String.valueOf(cliente.getPesquisaCliente()));
                        //lblExibeCpf.setText(String.valueOf(cliente.getCpf()));
                        lblExibeNome.setText(String.valueOf(cliente.getNome()));
                        lblExibeEmail.setText(String.valueOf(cliente.getEmail()));
                        lblExibeTelefone.setText(String.valueOf(cliente.getTelefone()));
                        lblExibeLogradouro.setText(String.valueOf(cliente.getLogradouro()));
                        lblExibeBairro.setText(String.valueOf(cliente.getBairro()));
                        lblExibeNumero.setText(String.valueOf(cliente.getNumero()));
                        //lblExibeCep.setText(String.valueOf(cliente.getCep()));
                        lblExibeCidade.setText(String.valueOf(cliente.getCidade()));
                        lblExibeEstado.setText(String.valueOf(cliente.getEstado()));
                        lblExibePais.setText(String.valueOf(cliente.getPais()));
                    } else {
                        limparLabelCliente();
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
    private void btnpesquisarveiculo(ActionEvent event) {

        String vazio = "";
        String verificaPesquisa = (String.valueOf(txtPesquisarVeiculo.getText()));

        if (vazio.equals(verificaPesquisa)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Informe o nº de chassi do carro, para poder pesquisar os registros!");
            alert.showAndWait();
        } else {
            try {
                Veiculo veiculo = new Veiculo();
                veiculo.setPesquisaVeiculo(txtPesquisarVeiculo.getText());
                VeiculoDAO dao = new VeiculoDAO();
                dao.buscar(veiculo);
                try {

                    if (veiculo.getIdModelo() != null) {
                        limparLabelVeiculo();
                        if (veiculo.getPlaca() == null) {
                            veiculo.setPlaca(String.valueOf(vazio));
                        }
                        
                        lblRecebeIdVeiculo.setText(String.valueOf(veiculo.getIdVeiculo()));
                        txtPesquisarVeiculo.setText(String.valueOf(veiculo.getPesquisaVeiculo()));
                        lblExibeAnoFabricacao.setText(veiculo.getAnoFabricacao());
                        lblExibeAnoModelo.setText(veiculo.getAnoModelo());
                        lblExibeCategoria.setText(veiculo.getCategoria());
                        lblExibeCondicaoVeiculo.setText(veiculo.getCondicao());
                        lblExibeCor.setText(veiculo.getCor());
                        lblExibeFabricante.setText(veiculo.getNomeFabricante());
                        lblExibeModelo.setText(veiculo.getNomeCarro());
                        lblExibeNumeroPortas.setText(String.valueOf(veiculo.getQuantidadePortas()));
                        lblExibeTipoCambio.setText(veiculo.getTransmissao());
                        lblExibeVersao.setText(veiculo.getVersao());

                    } else {
                        limparLabelVeiculo();
                        txtPesquisarVeiculo.setText(String.valueOf(veiculo.getPesquisaVeiculo()));
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro!");
                        alert.setHeaderText(null);
                        alert.setContentText("Verifique o nº de chassi do veículo!");
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
    private void btnrealizarvenda(ActionEvent event) {

        String vazio = "";

        if (vazio.equals(lblExibeNome.getText()) || vazio.equals(lblExibeFabricante.getText()) || vazio.equals(txtValorVenda.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Erro ao realizar a venda, verifique todos os campos!");
            alert.showAndWait();
        } else {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Venda de veículo");
            alert.setHeaderText(null);
            alert.setContentText("Deseja realizar a venda deste veículo?");
            Optional<ButtonType> showAndWait = alert.showAndWait();
            if (showAndWait.isPresent() && showAndWait.get() == ButtonType.OK) {

                try {

                    Funcionario funcionario = new Funcionario();
                    Venda venda = new Venda();
                    VendaDAO dao = new VendaDAO();

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                    String idTeste = "357970";
                    lblRecebeIdFuncionario.setText(idTeste);
                    funcionario.setIdFuncionario(Integer.valueOf(lblRecebeIdFuncionario.getText()));
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@                  
                    
                    venda.setIdVendaFuncionario(Integer.valueOf(lblRecebeIdFuncionario.getText()));
                    venda.setIdVendaCliente(Integer.valueOf(lblRecebeIdCliente.getText()));
                    venda.setIdVendaVeiculo(Integer.valueOf(lblRecebeIdVeiculo.getText()));
                    venda.setValorVenda(Float.valueOf(txtValorVenda.getText()));
                    venda.setTipoVenda(txtFormaPagamento.getText());
                    
                    dao.inserir(venda);
                    
                    limparLabelCliente();
                    limparLabelVeiculo();
                    limparTextField();
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Sucesso!");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Venda cadastradas com sucesso!");
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
                    limparLabelCliente();
                    limparLabelVeiculo();
                    limparTextField();
                }
            }
        }

    }

}
