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
import javafx.scene.control.ButtonType;

import javafx.scene.control.ComboBox;
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
public class ListaVeiculoViewController implements Initializable {

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
    private TextField txtCilindros;
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
    private TextField txtNomeFabricante;
    @FXML
    private TextField txtNomeCarro;
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
    private TextField txtPesquisarVeiculo;
    @FXML
    private TextField txtSituacao;
    @FXML
    private Label lblSituacaoVeiculo;

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
            Logger.getLogger(ListaVeiculoViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void voltarIndex(ActionEvent event) {
        voltar();
    }

    private void limpaTextField() {
        txtPesquisarVeiculo.setText("");
        txtSituacao.setText("");
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
    private void btnpesquisarveiculo(ActionEvent event) {

        String vazio = "";
        String verificaPesquisa = (String.valueOf(txtPesquisarVeiculo.getText()));
        String verificaCondicao = (String.valueOf(txtCondicao.getText()));

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
                        limpaTextField();
                        if (veiculo.getPlaca() == null) {
                            veiculo.setPlaca(String.valueOf(vazio));
                        }
                        txtPesquisarVeiculo.setText(String.valueOf(veiculo.getPesquisaVeiculo()));
                        txtNomeFabricante.setText(String.valueOf(veiculo.getNomeFabricante()));
                        txtNomeCarro.setText(String.valueOf(veiculo.getNomeCarro()));
                        txtVersao.setText(String.valueOf(veiculo.getVersao()));
                        txtCategoria.setText(String.valueOf(veiculo.getCategoria()));
                        txtSituacao.setText(String.valueOf(veiculo.getSituacao()));
                        txtCondicao.setText(String.valueOf(veiculo.getCondicao()));
                        txtNumeroChassi.setText(String.valueOf(veiculo.getNumeroChassi()));
                        txtPlaca.setText(String.valueOf(veiculo.getPlaca()));
                        txtValorPedido.setText(String.valueOf(veiculo.getValorPedido()));
                        txtQuantidadePortas.setText(String.valueOf(veiculo.getQuantidadePortas()));
                        txtAnoFabricacao.setText(String.valueOf(veiculo.getAnoFabricacao()));
                        txtAnoModelo.setText(String.valueOf(veiculo.getAnoModelo()));
                        txtCorCarro.setText(String.valueOf(veiculo.getCor()));
                        txtCilindros.setText(String.valueOf(veiculo.getCilindro()));
                        txtCilindradas.setText(String.valueOf(veiculo.getCilindrada()));
                        txtTorque.setText(String.valueOf(veiculo.getTorque()));
                        txtPotencia.setText(String.valueOf(veiculo.getPotencia()));
                        txtValvula.setText(String.valueOf(veiculo.getValvula()));
                        txtTipoCombustivel.setText(String.valueOf(veiculo.getCombustivel()));
                        txtAroPneu.setText(String.valueOf(veiculo.getAroPneu()));
                        txtLarguraPneu.setText(String.valueOf(veiculo.getLarguraPneu()));
                        txtMedidaPneu.setText(String.valueOf(veiculo.getMedidaPneu()));
                        txtTipoDirecao.setText(String.valueOf(veiculo.getTipoDirecao()));
                        txtFreioAbs.setText(String.valueOf(veiculo.getFreioAbs()));
                        txtFreioDianteiro.setText(String.valueOf(veiculo.getFreioDianteiro()));
                        txtFreioTraseiro.setText(String.valueOf(veiculo.getFreioTraseiro()));
                        txtCambio.setText(String.valueOf(veiculo.getTransmissao()));
                        txtAlarme.setText(String.valueOf(veiculo.getAlarme()));
                        txtVidroDianteiro.setText(String.valueOf(veiculo.getSistemaVidroDianteiro()));
                        txtVidroTraseiro.setText(String.valueOf(veiculo.getSistemaVidroTraseiro()));
                        txtQuantidadeCombustivel.setText(String.valueOf(veiculo.getTanqueCombustivel()));
                    } else {
                        limpaTextField();
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
    private void editarVeiculo(ActionEvent event) {

        String vazio = "";
        String verificaPesquisa = (String.valueOf(txtPesquisarVeiculo.getText()));
        String verificaCondicao = (String.valueOf(txtCondicao.getText()));

        if (vazio.equals(verificaPesquisa)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Informe o nº de chassi do veículo, para poder editar os registros!");
            alert.showAndWait();
        } else if (vazio.equals(verificaCondicao)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Informe o nº de chassi do veículo corretamente, para poder editar os registros!");
            alert.showAndWait();
        } else {
            try {

                Veiculo veiculo = new Veiculo();
                VeiculoDAO dao = new VeiculoDAO();
                veiculo.setPesquisaVeiculo(txtPesquisarVeiculo.getText());
                dao.buscar(veiculo);

                if (veiculo.getIdModelo() != null) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Editar informações do veículo");
                    alert.setHeaderText(null);
                    alert.setContentText("Deseja alterar as informações do veículo?");
                    Optional<ButtonType> showAndWait = alert.showAndWait();
                    if (showAndWait.isPresent() && showAndWait.get() == ButtonType.OK) {

                        veiculo.setPesquisaVeiculo(txtPesquisarVeiculo.getText());
                        veiculo.setNumeroChassi(txtNumeroChassi.getText());
                        veiculo.setNomeFabricante(txtNomeFabricante.getText());
                        veiculo.setNomeCarro(txtNomeCarro.getText());
                        veiculo.setVersao(txtVersao.getText());
                        veiculo.setCategoria(txtCategoria.getText());
                        veiculo.setCondicao(txtCondicao.getText());
                        veiculo.setSituacao(txtSituacao.getText());
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
                        dao.editar(veiculo);

                        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Sucesso!");
                        alerta.setHeaderText(null);
                        alerta.setContentText("As informações do veículo foram alterada com sucesso!");
                        alerta.showAndWait();
                              
                    } else {
                        limpaTextField();
                        txtPesquisarVeiculo.setText(String.valueOf(veiculo.getPesquisaVeiculo()));
                        txtNomeFabricante.setText(String.valueOf(veiculo.getNomeFabricante()));
                        txtNomeCarro.setText(String.valueOf(veiculo.getNomeCarro()));
                        txtVersao.setText(String.valueOf(veiculo.getVersao()));
                        txtCategoria.setText(String.valueOf(veiculo.getCategoria()));
                        txtSituacao.setText(String.valueOf(veiculo.getSituacao()));
                        txtCondicao.setText(String.valueOf(veiculo.getCondicao()));
                        txtNumeroChassi.setText(String.valueOf(veiculo.getNumeroChassi()));
                        txtPlaca.setText(String.valueOf(veiculo.getPlaca()));
                        txtValorPedido.setText(String.valueOf(veiculo.getValorPedido()));
                        txtQuantidadePortas.setText(String.valueOf(veiculo.getQuantidadePortas()));
                        txtAnoFabricacao.setText(String.valueOf(veiculo.getAnoFabricacao()));
                        txtAnoModelo.setText(String.valueOf(veiculo.getAnoModelo()));
                        txtCorCarro.setText(String.valueOf(veiculo.getCor()));
                        txtCilindros.setText(String.valueOf(veiculo.getCilindro()));
                        txtCilindradas.setText(String.valueOf(veiculo.getCilindrada()));
                        txtTorque.setText(String.valueOf(veiculo.getTorque()));
                        txtPotencia.setText(String.valueOf(veiculo.getPotencia()));
                        txtValvula.setText(String.valueOf(veiculo.getValvula()));
                        txtTipoCombustivel.setText(String.valueOf(veiculo.getCombustivel()));
                        txtAroPneu.setText(String.valueOf(veiculo.getAroPneu()));
                        txtLarguraPneu.setText(String.valueOf(veiculo.getLarguraPneu()));
                        txtMedidaPneu.setText(String.valueOf(veiculo.getMedidaPneu()));
                        txtTipoDirecao.setText(String.valueOf(veiculo.getTipoDirecao()));
                        txtFreioAbs.setText(String.valueOf(veiculo.getFreioAbs()));
                        txtFreioDianteiro.setText(String.valueOf(veiculo.getFreioDianteiro()));
                        txtFreioTraseiro.setText(String.valueOf(veiculo.getFreioTraseiro()));
                        txtCambio.setText(String.valueOf(veiculo.getTransmissao()));
                        txtAlarme.setText(String.valueOf(veiculo.getAlarme()));
                        txtVidroDianteiro.setText(String.valueOf(veiculo.getSistemaVidroDianteiro()));
                        txtVidroTraseiro.setText(String.valueOf(veiculo.getSistemaVidroTraseiro()));
                        txtQuantidadeCombustivel.setText(String.valueOf(veiculo.getTanqueCombustivel()));
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro!");
                    alert.setHeaderText(null);
                    alert.setContentText("Verifique o nº de chassi do veículo!");
                    alert.showAndWait();
                }
            } catch (SQLException e) {
                Logger.getLogger(ListaClienteViewController.class.getName()).log(Level.SEVERE, null, e);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro!");
                alert.setHeaderText(null);
                alert.setContentText("Erro ao editar informações do veiculo!");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void excluirVeiculo(ActionEvent event) {

        String vazio = "";
        String verificaPesquisa = (String.valueOf(txtPesquisarVeiculo.getText()));
        String verificaCondicao = (String.valueOf(txtCondicao.getText()));

        if (vazio.equals(verificaPesquisa)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Informe o nº de chassi do veículo, para poder excluir os registros!");
            alert.showAndWait();
        } else if (vazio.equals(verificaCondicao)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro!");
            alert.setHeaderText(null);
            alert.setContentText("Informe o nº de chassi do veículo corretamente, para poder excluir os registros!");
            alert.showAndWait();
        } else {
            try {
                Veiculo veiculo = new Veiculo();
                veiculo.setPesquisaVeiculo(String.valueOf(txtPesquisarVeiculo.getText()));
                VeiculoDAO dao = new VeiculoDAO();
                dao.buscar(veiculo);

                if (veiculo.getIdVeiculo() != null) {

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Excluir informações do veículo");
                    alert.setHeaderText(null);
                    alert.setContentText("Deseja deletar as informações do veículo?");
                    Optional<ButtonType> showAndWait = alert.showAndWait();
                    if (showAndWait.isPresent() && showAndWait.get() == ButtonType.OK) {

                        veiculo.setAjudaExcluir(veiculo.getIdVeiculo());
                        dao.excluir(veiculo);

                        if (veiculo.getTotalVendaVeiculo() != 0) {
                            Alert alerta = new Alert(Alert.AlertType.ERROR);
                            alerta.setTitle("Erro!");
                            alerta.setHeaderText(null);
                            alerta.setContentText("Não é possível deletar, pois existe vendas vinculadas a este veículo!");
                            alerta.showAndWait();
                        } else {
                            limpaTextField();
                            Alert alerta = new Alert(Alert.AlertType.WARNING);
                            alerta.setTitle("Sucesso!");
                            alerta.setHeaderText(null);
                            alerta.setContentText("As informações do veículo foram deletas com sucesso!");
                            alerta.showAndWait();
                        }
                    }
                } else {
                    Alert alerta = new Alert(Alert.AlertType.ERROR);
                    alerta.setTitle("Erro!");
                    alerta.setHeaderText(null);
                    alerta.setContentText("Informe o nº de chassi do veículo corretamente, para poder excluir os registros!");
                    alerta.showAndWait();
                }
            } catch (SQLException e) {
                Logger.getLogger(ListaClienteViewController.class.getName()).log(Level.SEVERE, null, e);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro!");
                alert.setHeaderText(null);
                alert.setContentText("Erro ao excluir informações do veículo!");
                alert.showAndWait();
            }
        }

    }
}
