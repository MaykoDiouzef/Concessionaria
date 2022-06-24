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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import projeto.dao.VeiculoDAO;
import projeto.modelo.Veiculo;

/**
 * FXML Controller class
 *
 *
 */
public class CadastroVeiculoViewController implements Initializable {

    @FXML
    private Pane paneCadastroFuncionario;
    @FXML
    private Tab janelaDadosPessoaisFuncionario;
    @FXML
    private Label labelCadastroFuncionarioUm;
    @FXML
    private Label lblCondicaoVeiculo;
    @FXML
    private Label lblValorPedido;
    @FXML
    private TextField txtValorPedido;
    @FXML
    private Label lblNumeroChassi;
    @FXML
    private TextField txtNumeroChassi;
    @FXML
    private Label lblPlaca;
    @FXML
    private TextField txtPlaca;
    @FXML
    private Label lblCorCarro;
    @FXML
    private TextField txtCorCarro;
    @FXML
    private Label lblDirecao;
    @FXML
    private Label lblAlarme;
    @FXML
    private Label lblVidroDianteiro;
    @FXML
    private Label lblVidroTraseiro;
    @FXML
    private Label lblQuantidadePortas;
    @FXML
    private TextField txtQuantidadePortas;
    @FXML
    private Label lblQuantidadeCombustivel;
    @FXML
    private TextField txtQuantidadeCombustivel;
    @FXML
    private Tab janelaAdministrativo;
    @FXML
    private Label labelCadastroFuncionarioDois;
    @FXML
    private Label lblFabricante;
    @FXML
    private Label lblModelo;
    @FXML
    private Label lblVersao;
    @FXML
    private TextField txtVersao;
    @FXML
    private Label lblAnoFabricacao;
    @FXML
    private TextField txtAnoFabricacao;
    @FXML
    private Label lblAnoModelo;
    @FXML
    private TextField txtAnoModelo;
    @FXML
    private Label lblCategoria;
    @FXML
    private Label labelCadastroVeiculoTres;
    @FXML
    private Label lblTipoCombustivel;
    @FXML
    private Label lblCambio;
    @FXML
    private Label lblCilindros;
    @FXML
    private Label lblCilindradas;
    @FXML
    private TextField txtCilindradas;
    @FXML
    private Label lblTorque;
    @FXML
    private TextField txtTorque;
    @FXML
    private Label lblPotencia;
    @FXML
    private TextField txtPotencia;
    @FXML
    private Label lblValvula;
    @FXML
    private TextField txtValvula;
    @FXML
    private Label labelCadastroVeiculoQuatro;
    @FXML
    private Label lblAroPneu;
    @FXML
    private TextField txtAroPneu;
    @FXML
    private Label lblLarguraPneu;
    @FXML
    private TextField txtLarguraPneu;
    @FXML
    private Label lblMedidaPneu;
    @FXML
    private TextField txtMedidaPneu;
    @FXML
    private Label lblFreioABS;
    @FXML
    private Label lblFreioDianteiro;
    @FXML
    private Label lblFreioTraseiro;
    @FXML
    private TextField txtCondicao;
    @FXML
    private TextField txtTipoDirecao;
    @FXML
    private TextField txtAlarme;
    @FXML
    private TextField txtVidroDianteiro;
    @FXML
    private TextField txtVidroTraseiro;
    @FXML
    private TextField txtCategoria;
    @FXML
    private TextField txtTipoCombustivel;
    @FXML
    private TextField txtCambio;
    @FXML
    private TextField txtFreioAbs;
    @FXML
    private TextField txtFreioDianteiro;
    @FXML
    private TextField txtFreioTraseiro;
    @FXML
    private TextField txtNomeFabricante;
    @FXML
    private TextField txtNomeCarro;
    @FXML
    private TextField txtCilindros;
    @FXML
    private Label lblSituacaoVeiculo;
    @FXML
    private TextField txtSituacao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtSituacao.setText("Disponível");
    }

    private void voltar() {
        try {
            App.setRoot("indexView");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void limpaTextField() {
        txtSituacao.setText("Disponível");
        txtCondicao.setText("");
        txtNumeroChassi.setText("");
        txtPlaca.setText("");
        txtValorPedido.setText("");
        txtQuantidadePortas.setText("");
        txtAnoFabricacao.setText("");
        txtAnoModelo.setText("");
        txtCorCarro.setText("");
        txtCilindros.setText("");
        txtCilindradas.setText("");
        txtTorque.setText("");
        txtPotencia.setText("");
        txtValvula.setText("");
        txtTipoCombustivel.setText("");
        txtAroPneu.setText("");
        txtLarguraPneu.setText("");
        txtMedidaPneu.setText("");
        txtTipoDirecao.setText("");
        txtFreioAbs.setText("");
        txtFreioDianteiro.setText("");
        txtFreioTraseiro.setText("");
        txtCambio.setText("");
        txtAlarme.setText("");
        txtVidroDianteiro.setText("");
        txtVidroTraseiro.setText("");
        txtQuantidadeCombustivel.setText("");
    }

    @FXML
    private void cadastrarVeiculo(ActionEvent event) throws SQLException {

        String vazio = "";

        //String verifica = (String.valueOf(txtAnoFabricacao.getText()));
        if (vazio.equals(txtAnoFabricacao.getText()) || vazio.equals(txtAnoModelo.getText()) || vazio.equals(txtAroPneu.getText()) || vazio.equals(txtCilindradas.getText()) || vazio.equals(txtCilindros.getText()) || vazio.equals(txtCorCarro.getText()) || vazio.equals(txtNomeFabricante.getText()) || vazio.equals(txtLarguraPneu.getText()) || vazio.equals(txtMedidaPneu.getText()) || vazio.equals(txtNomeCarro.getText()) || vazio.equals(txtNumeroChassi.getText()) || vazio.equals(txtPotencia.getText()) || vazio.equals(txtQuantidadeCombustivel.getText()) || vazio.equals(txtQuantidadePortas.getText()) || vazio.equals(txtTorque.getText()) || vazio.equals(txtValorPedido.getText()) || vazio.equals(txtValvula.getText()) || vazio.equals(txtVersao.getText())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Erro ao cadastrar o veículo, preencha todos os campos!");
            alert.showAndWait();
        } else {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Cadastro de veículo");
            alert.setHeaderText(null);
            alert.setContentText("Deseja cadastrar o veículo?");
            Optional<ButtonType> showAndWait = alert.showAndWait();
            if (showAndWait.isPresent() && showAndWait.get() == ButtonType.OK) {

                try {

                    Veiculo veiculo = new Veiculo();
                    veiculo.setSituacao(txtSituacao.getText());
                    veiculo.setNomeFabricante(txtNomeFabricante.getText());
                    veiculo.setNomeCarro(txtNomeCarro.getText());
                    veiculo.setVersao(txtVersao.getText());
                    veiculo.setCategoria(txtCategoria.getText());
                    veiculo.setCondicao(txtCondicao.getText());
                    veiculo.setNumeroChassi(txtNumeroChassi.getText());
                    veiculo.setPlaca(txtPlaca.getText());
                    veiculo.setValorPedido(Float.valueOf(txtValorPedido.getText()));
                    veiculo.setQuantidadePortas(Integer.valueOf(txtQuantidadePortas.getText()));
                    veiculo.setAnoFabricacao(txtAnoFabricacao.getText());
                    veiculo.setAnoModelo(txtAnoModelo.getText());
                    veiculo.setCor(txtCorCarro.getText());
                    veiculo.setCilindro(Integer.valueOf(txtCilindros.getText()));
                    veiculo.setCilindrada(Float.valueOf(txtCilindradas.getText()));
                    veiculo.setTorque(Float.valueOf(txtTorque.getText()));
                    veiculo.setPotencia(Integer.valueOf(txtPotencia.getText()));
                    veiculo.setValvula(Integer.valueOf(txtValvula.getText()));
                    veiculo.setCombustivel(txtTipoCombustivel.getText());
                    veiculo.setAroPneu(Integer.valueOf(txtAroPneu.getText()));
                    veiculo.setLarguraPneu(Integer.valueOf(txtLarguraPneu.getText()));
                    veiculo.setMedidaPneu(Integer.valueOf(txtMedidaPneu.getText()));
                    veiculo.setTipoDirecao(txtTipoDirecao.getText());
                    veiculo.setFreioAbs(txtFreioAbs.getText());
                    veiculo.setFreioDianteiro(txtFreioDianteiro.getText());
                    veiculo.setFreioTraseiro(txtFreioTraseiro.getText());
                    veiculo.setTransmissao(txtCambio.getText());
                    veiculo.setAlarme(txtAlarme.getText());
                    veiculo.setSistemaVidroDianteiro(txtVidroDianteiro.getText());
                    veiculo.setSistemaVidroTraseiro(txtVidroTraseiro.getText());
                    veiculo.setTanqueCombustivel(Integer.valueOf(txtQuantidadeCombustivel.getText()));
                    VeiculoDAO dao = new VeiculoDAO();
                    dao.inserir(veiculo);

                    limpaTextField();

                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Sucesso!");
                    alerta.setHeaderText(null);
                    alerta.setContentText("As informações do veículo foram cadastradas com sucesso!");
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

    @FXML
    private void voltarIndex(ActionEvent event) {
        voltar();
    }
}
