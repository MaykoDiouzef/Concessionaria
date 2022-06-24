/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import projeto.modelo.Veiculo;

/**
 *
 *
 */
public class VeiculoDAO {
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    String url = "jdbc:mysql://localhost:3306/adrianob_2022grupo3";
    String user = "root";
    String password = "!@0147#$";
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//##############################################################################

    public void inserir(Veiculo a) throws SQLException {
        //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adrianob_2022grupo3", "root", "!@0147#$");
        Connection con = DriverManager.getConnection(url, user, password);
//************************* inserir modelo *************************************
        PreparedStatement inserirModelo = con.prepareStatement(
                "insert into modelo (nomeFabricante, nomeCarro, versao, categoria) values (?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);

        inserirModelo.setString(1, a.getNomeFabricante());
        inserirModelo.setString(2, a.getNomeCarro());
        inserirModelo.setString(3, a.getVersao());
        inserirModelo.setString(4, a.getCategoria());
        inserirModelo.executeUpdate();

        // Recupera o id do modelo que foi inserido
        ResultSet pegarIdModlo = inserirModelo.getGeneratedKeys();
        if (pegarIdModlo.next()) {
            a.setIdModelo(pegarIdModlo.getInt(1));
        }
        inserirModelo.close();
//************************* inserir veiculo ************************************
        PreparedStatement inserirVeiculo = con.prepareStatement(
                "insert into veiculo (idModeloFK, situacao, condicao, numeroChassi, placa, valorPedido, quantidadePortas, anoFabricacao, anoModelo, cor, cilindro, cilindrada, torque, potencia, valvula, tipoCombustivel, aroPneu, larguraPneu, medidaPneu, tipoDirecao, freioAbs, freioDianteiro, freioTraseiro, transmissao, alarme, sistemaVidroDianteiro, sistemaVidroTraseiro, tanqueCombustivel) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        inserirVeiculo.setInt(1, a.getIdModelo());
        inserirVeiculo.setString(2, a.getSituacao());
        inserirVeiculo.setString(3, a.getCondicao());
        inserirVeiculo.setString(4, a.getNumeroChassi());
        inserirVeiculo.setString(5, a.getPlaca());
        inserirVeiculo.setFloat(6, a.getValorPedido());
        inserirVeiculo.setInt(7, a.getQuantidadePortas());
        inserirVeiculo.setString(8, a.getAnoFabricacao());
        inserirVeiculo.setString(9, a.getAnoModelo());
        inserirVeiculo.setString(10, a.getCor());
        inserirVeiculo.setInt(11, a.getCilindro());
        inserirVeiculo.setFloat(12, a.getCilindrada());
        inserirVeiculo.setFloat(13, a.getTorque());
        inserirVeiculo.setInt(14, a.getPotencia());
        inserirVeiculo.setInt(15, a.getValvula());
        inserirVeiculo.setString(16, a.getCombustivel());
        inserirVeiculo.setInt(17, a.getAroPneu());
        inserirVeiculo.setInt(18, a.getLarguraPneu());
        inserirVeiculo.setInt(19, a.getMedidaPneu());
        inserirVeiculo.setString(20, a.getTipoDirecao());
        inserirVeiculo.setString(21, a.getFreioAbs());
        inserirVeiculo.setString(22, a.getFreioDianteiro());
        inserirVeiculo.setString(23, a.getFreioTraseiro());
        inserirVeiculo.setString(24, a.getTransmissao());
        inserirVeiculo.setString(25, a.getAlarme());
        inserirVeiculo.setString(26, a.getSistemaVidroDianteiro());
        inserirVeiculo.setString(27, a.getSistemaVidroTraseiro());
        inserirVeiculo.setInt(28, a.getTanqueCombustivel());
        inserirVeiculo.executeUpdate();
        inserirVeiculo.close();
//***************************** fechando conexão *******************************
        con.close();
    }
//##############################################################################

    public void buscar(Veiculo a) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
//**************************** buscar veiculo ********************************** 
        PreparedStatement buscarVeiculo = con.prepareStatement(
                "select * from vwlistaveiculo where numeroChassi = ?");

        buscarVeiculo.setString(1, a.getPesquisaVeiculo());

        ResultSet resultadoVeiculo;

        resultadoVeiculo = buscarVeiculo.executeQuery();

        while (resultadoVeiculo.next()) {
            // apenas pegando os id
            a.setIdModelo(resultadoVeiculo.getInt("idModelo"));
            a.setIdVeiculo(resultadoVeiculo.getInt("idVeiculo"));
            // o resto das informações 
            a.setPesquisaVeiculo(resultadoVeiculo.getString("numeroChassi"));
            a.setNomeFabricante(resultadoVeiculo.getString("nomeFabricante"));
            a.setNomeCarro(resultadoVeiculo.getString("nomeCarro"));
            a.setVersao(resultadoVeiculo.getString("versao"));
            a.setCategoria(resultadoVeiculo.getString("categoria"));
            a.setSituacao(resultadoVeiculo.getString("situacao"));
            a.setCondicao(resultadoVeiculo.getString("condicao"));
            a.setNumeroChassi(resultadoVeiculo.getString("numeroChassi"));
            a.setPlaca(resultadoVeiculo.getString("placa"));
            a.setValorPedido(resultadoVeiculo.getFloat("valorPedido"));
            a.setQuantidadePortas(resultadoVeiculo.getInt("quantidadePortas"));
            a.setAnoFabricacao(resultadoVeiculo.getString("anoFabricacao"));
            a.setAnoModelo(resultadoVeiculo.getString("anoModelo"));
            a.setCor(resultadoVeiculo.getString("cor"));
            a.setCilindro(resultadoVeiculo.getInt("cilindro"));
            a.setCilindrada(resultadoVeiculo.getFloat("cilindrada"));
            a.setTorque(resultadoVeiculo.getFloat("torque"));
            a.setPotencia(resultadoVeiculo.getInt("potencia"));
            a.setValvula(resultadoVeiculo.getInt("valvula"));
            a.setCombustivel(resultadoVeiculo.getString("tipoCombustivel"));
            a.setAroPneu(resultadoVeiculo.getInt("aroPneu"));
            a.setLarguraPneu(resultadoVeiculo.getInt("larguraPneu"));
            a.setMedidaPneu(resultadoVeiculo.getInt("medidaPneu"));
            a.setTipoDirecao(resultadoVeiculo.getString("tipoDirecao"));
            a.setFreioAbs(resultadoVeiculo.getString("freioAbs"));
            a.setFreioDianteiro(resultadoVeiculo.getString("freioDianteiro"));
            a.setFreioTraseiro(resultadoVeiculo.getString("freioTraseiro"));
            a.setTransmissao(resultadoVeiculo.getString("transmissao"));
            a.setAlarme(resultadoVeiculo.getString("alarme"));
            a.setSistemaVidroDianteiro(resultadoVeiculo.getString("sistemaVidroDianteiro"));
            a.setSistemaVidroTraseiro(resultadoVeiculo.getString("sistemaVidroTraseiro"));
            a.setTanqueCombustivel(resultadoVeiculo.getInt("tanqueCombustivel"));
        }
        buscarVeiculo.close();
//***************************** fechando conexão *******************************
        con.close();
    }
//##############################################################################

    public void editar(Veiculo a) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
//*************************** buscar id para editar ****************************
        PreparedStatement buscarEditar = con.prepareStatement(
                "select * from vwlistaveiculo where numeroChassi = ?");

        buscarEditar.setString(1, a.getPesquisaVeiculo());

        ResultSet resultadoBuscarEditarVeiculo;

        resultadoBuscarEditarVeiculo = buscarEditar.executeQuery();

        while (resultadoBuscarEditarVeiculo.next()) {
            // apenas pegando os id
            a.setIdModelo(resultadoBuscarEditarVeiculo.getInt("idModelo"));
            a.setIdVeiculo(resultadoBuscarEditarVeiculo.getInt("idVeiculo"));
        }
        buscarEditar.close();
//************************ verifica se encontrou o id **************************
        if (a.getIdModelo() != null) {
//************************** editar modelo *************************************
            PreparedStatement editarModelo = con.prepareStatement(
                    "update modelo set nomeFabricante = ?, nomeCarro = ?, versao = ?, categoria = ? where idModelo = ?");

            editarModelo.setString(1, a.getNomeFabricante());
            editarModelo.setString(2, a.getNomeCarro());
            editarModelo.setString(3, a.getVersao());
            editarModelo.setString(4, a.getCategoria());
            editarModelo.setInt(5, a.getIdModelo());
            editarModelo.executeUpdate();
            editarModelo.close();
//*************************** editar veiculo ***********************************
            PreparedStatement editarVeiculo = con.prepareStatement(
                    "update veiculo set situacao = ?, condicao = ?, numeroChassi = ?, placa = ?, valorPedido = ?, quantidadePortas = ?, anoFabricacao = ?, anoModelo = ?, cor = ?, cilindro = ?, cilindrada = ?, torque = ?, potencia = ?, valvula = ?, tipoCombustivel = ?, aroPneu = ?, larguraPneu = ?, medidaPneu = ?, tipoDirecao = ?, freioAbs = ?, freioDianteiro = ?, freioTraseiro = ?, transmissao = ?, alarme = ?, sistemaVidroDianteiro = ?, sistemaVidroTraseiro = ?, tanqueCombustivel = ? where idVeiculo = ?");

            editarVeiculo.setString(1, a.getSituacao());
            editarVeiculo.setString(2, a.getCondicao());
            editarVeiculo.setString(3, a.getNumeroChassi());
            editarVeiculo.setString(4, a.getPlaca());
            editarVeiculo.setFloat(5, a.getValorPedido());
            editarVeiculo.setInt(6, a.getQuantidadePortas());
            editarVeiculo.setString(7, a.getAnoFabricacao());
            editarVeiculo.setString(8, a.getAnoModelo());
            editarVeiculo.setString(9, a.getCor());
            editarVeiculo.setInt(10, a.getCilindro());
            editarVeiculo.setFloat(11, a.getCilindrada());
            editarVeiculo.setFloat(12, a.getTorque());
            editarVeiculo.setInt(13, a.getPotencia());
            editarVeiculo.setInt(14, a.getValvula());
            editarVeiculo.setString(15, a.getCombustivel());
            editarVeiculo.setInt(16, a.getAroPneu());
            editarVeiculo.setInt(17, a.getLarguraPneu());
            editarVeiculo.setInt(18, a.getMedidaPneu());
            editarVeiculo.setString(19, a.getTipoDirecao());
            editarVeiculo.setString(20, a.getFreioAbs());
            editarVeiculo.setString(21, a.getFreioDianteiro());
            editarVeiculo.setString(22, a.getFreioTraseiro());
            editarVeiculo.setString(23, a.getTransmissao());
            editarVeiculo.setString(24, a.getAlarme());
            editarVeiculo.setString(25, a.getSistemaVidroDianteiro());
            editarVeiculo.setString(26, a.getSistemaVidroTraseiro());
            editarVeiculo.setInt(27, a.getTanqueCombustivel());
            editarVeiculo.setInt(28, a.getIdVeiculo());
            editarVeiculo.executeUpdate();
            editarVeiculo.close();
//***************************** fechando conexão ******************************* 
        }
        con.close();
    }
//##############################################################################

    public void excluir(Veiculo a) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
//******** Contar quantas vendas o veiculo foi vendido, sendo 0 nenhuma ********
        PreparedStatement contar = con.prepareStatement(
                "select count(idVeiculoFK) as 'total' from venda where idVeiculoFK = ?");

        contar.setInt(1, a.getAjudaExcluir());

        ResultSet resultadoVeiculo;

        resultadoVeiculo = contar.executeQuery();

        if (resultadoVeiculo.next()) {
            // apenas pegando o total
            a.setTotalVendaVeiculo(resultadoVeiculo.getInt("total"));
        }
        contar.close();
//*************** Buscar os Id para deletar onde for preciso *******************
        if (a.getTotalVendaVeiculo() == 0) {
            PreparedStatement buscarIdsVeiculo = con.prepareStatement(
                    "select * from vwlistaveiculo where idVeiculo = ?");
            buscarIdsVeiculo.setInt(1, a.getAjudaExcluir());

            ResultSet resultadoIdsVeiculo;

            resultadoIdsVeiculo = buscarIdsVeiculo.executeQuery();

            while (resultadoIdsVeiculo.next()) {
                // apenas pegando os id
                a.setIdModelo(resultadoIdsVeiculo.getInt("idModelo"));
                a.setIdVeiculo(resultadoIdsVeiculo.getInt("idVeiculo"));
            }
            buscarIdsVeiculo.close();
//************************* Deletar por tabela *********************************
            if (a.getIdVeiculo() != null) {
                PreparedStatement excluirVeiculo = con.prepareStatement(
                        "delete from veiculo where idVeiculo = ?");

                excluirVeiculo.setInt(1, a.getIdVeiculo());
                excluirVeiculo.executeUpdate();
                excluirVeiculo.close();
//************************* Deletar por tabela *********************************
                PreparedStatement excluirModelo = con.prepareStatement(
                        "delete from modelo where idModelo = ?");

                excluirModelo.setInt(1, a.getIdModelo());
                excluirModelo.executeUpdate();
                excluirModelo.close();
            }
        }
//********************************* Fim  ***************************************
        con.close();
    }
//##############################################################################
}
