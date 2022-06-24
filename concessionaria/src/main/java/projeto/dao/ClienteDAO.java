/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import projeto.modelo.Cliente;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 *
 */
public class ClienteDAO {

//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    String url = "jdbc:mysql://localhost:3306/adrianob_2022grupo3";
    String user = "root";
    String password = "!@0147#$";
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//##############################################################################

    public void inserir(Cliente a) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);

//************************** inserirPais **************************************
        PreparedStatement inserirPais = con.prepareStatement(
                "insert into pais (pais) values(?)",
                Statement.RETURN_GENERATED_KEYS);

        inserirPais.setString(1, a.getPais());
        inserirPais.executeUpdate();

        // Recupera o id do país que foi inserido
        ResultSet pegaIdPais = inserirPais.getGeneratedKeys();
        if (pegaIdPais.next()) {
            a.setIdPais(pegaIdPais.getInt(1));
        }

        inserirPais.close();
//************************** inserirEstado *************************************
        PreparedStatement inserirEstado = con.prepareStatement(
                "insert into estado (idPaisFK, estado) values(?,?)",
                Statement.RETURN_GENERATED_KEYS);

        inserirEstado.setInt(1, a.getIdPais());// inseri o id do pais que buscou acima
        inserirEstado.setString(2, a.getEstado());
        inserirEstado.executeUpdate();

        // Recupera o id do estado que foi inserido
        ResultSet pegaIdEstado = inserirEstado.getGeneratedKeys();
        if (pegaIdEstado.next()) {
            a.setIdEstado(pegaIdEstado.getInt(1));
        }

        inserirEstado.close();
//************************** inserirCidade *************************************
        PreparedStatement inserirCidade = con.prepareStatement(
                "insert into cidade (idEstadoFK, cidade) values(?,?)",
                Statement.RETURN_GENERATED_KEYS);

        inserirCidade.setInt(1, a.getIdEstado());// inseri o id do estado que buscou acima
        inserirCidade.setString(2, a.getCidade());
        inserirCidade.executeUpdate();

        // Recupera o id da cidade que foi inserido
        ResultSet pegaIdCidade = inserirCidade.getGeneratedKeys();
        if (pegaIdCidade.next()) {
            a.setIdCidade(pegaIdCidade.getInt(1));
        }

        inserirCidade.close();
//************************** inserirEndereco ***********************************
        PreparedStatement inserirEndereco = con.prepareStatement(
                "insert into endereco (idCidadeFK, logradouro, bairro, numero, cep) values(?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);

        inserirEndereco.setInt(1, a.getIdCidade()); // inseri o id da cidade que buscou acima
        inserirEndereco.setString(2, a.getLogradouro());
        inserirEndereco.setString(3, a.getBairro());
        inserirEndereco.setString(4, a.getNumero());
        inserirEndereco.setString(5, a.getCep());
        inserirEndereco.executeUpdate();

        // Recupera o id do endereço que foi inserido
        ResultSet pegaIdEndereco = inserirEndereco.getGeneratedKeys();
        if (pegaIdEndereco.next()) {
            a.setIdEndereco(pegaIdEndereco.getInt(1));
        }

        inserirEndereco.close();
//************************** inserirPessoa *************************************
        PreparedStatement inserirPessoa = con.prepareStatement(
                "insert into pessoa (idEnderecoFK, nome, email, telefone, cpf) values(?,?,?,?,?)",
                Statement.RETURN_GENERATED_KEYS);

        inserirPessoa.setInt(1, a.getIdEndereco());// inseri o id do endereço que buscou acima
        inserirPessoa.setString(2, a.getNome());
        inserirPessoa.setString(3, a.getEmail());
        inserirPessoa.setString(4, a.getTelefone());
        inserirPessoa.setString(5, a.getCpf());
        inserirPessoa.executeUpdate();

        // Recupera o id do endereço que foi inserido
        ResultSet pegaIdPessoa = inserirPessoa.getGeneratedKeys();
        if (pegaIdPessoa.next()) {
            a.setIdPessoa(pegaIdPessoa.getInt(1));
        }

        inserirPessoa.close();
//**************************** inserirCliente **********************************
        PreparedStatement inserirCliente = con.prepareStatement(
                "insert into cliente (idPessoaFK) values(?)");

        inserirCliente.setInt(1, a.getIdPessoa()); // inseri o id do endereço que buscou acima
        inserirCliente.executeUpdate();

        inserirCliente.close();
        
//******************************************************************************
         
        con.close();
    }

//##############################################################################
    public void buscar(Cliente a) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);

        PreparedStatement buscarCliente = con.prepareStatement(
                "select * from vwlistacliente where cpf = ?");

        buscarCliente.setString(1, a.getPesquisaCliente());

        ResultSet resultadoCliente;

        resultadoCliente = buscarCliente.executeQuery();

        while (resultadoCliente.next()) {
            // apenas pegando os id
            a.setIdCliente(resultadoCliente.getInt("idCliente"));
            a.setIdPessoa(resultadoCliente.getInt("idPessoa"));
            a.setIdEndereco(resultadoCliente.getInt("idEndereco"));
            a.setIdCidade(resultadoCliente.getInt("idCidade"));
            a.setIdEstado(resultadoCliente.getInt("idEstado"));
            a.setIdPais(resultadoCliente.getInt("idPais"));
            // Aqui começa a pegar os dados         
            a.setPesquisaCliente(resultadoCliente.getString("cpf"));
            a.setNome(resultadoCliente.getString("nome"));
            a.setEmail(resultadoCliente.getString("email"));
            a.setCpf(resultadoCliente.getString("cpf"));
            a.setTelefone(resultadoCliente.getString("telefone"));
            a.setLogradouro(resultadoCliente.getString("logradouro"));
            a.setBairro(resultadoCliente.getString("bairro"));
            a.setNumero(resultadoCliente.getString("numero"));
            a.setCep(resultadoCliente.getString("cep"));
            a.setCidade(resultadoCliente.getString("cidade"));
            a.setEstado(resultadoCliente.getString("estado"));
            a.setPais(resultadoCliente.getString("pais"));
        }

        buscarCliente.close();
        con.close();
    }

//##############################################################################
    public void editar(Cliente a) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
//***************************** buscar id para editar **************************
        PreparedStatement buscarCliente = con.prepareStatement(
                "select * from vwlistacliente where cpf = ?");

        buscarCliente.setString(1, a.getPesquisaCliente());

        ResultSet resultadoCliente;

        resultadoCliente = buscarCliente.executeQuery();

        while (resultadoCliente.next()) {
            // apenas pegando os id
            a.setIdCliente(resultadoCliente.getInt("idCliente"));
            a.setIdPessoa(resultadoCliente.getInt("idPessoa"));
            a.setIdEndereco(resultadoCliente.getInt("idEndereco"));
            a.setIdCidade(resultadoCliente.getInt("idCidade"));
            a.setIdEstado(resultadoCliente.getInt("idEstado"));
            a.setIdPais(resultadoCliente.getInt("idPais"));
        }
        buscarCliente.close();
//************************ verifica se encontrou o id **************************
        if (a.getIdPessoa() != null) {
//************************** editar cliente ************************************
            PreparedStatement editarCliente = con.prepareStatement(
                    "update pessoa set nome = ?, email = ?, telefone = ?, cpf = ? where idPessoa = ?");

            editarCliente.setString(1, a.getNome());
            editarCliente.setString(2, a.getEmail());
            editarCliente.setString(3, a.getTelefone());
            editarCliente.setString(4, a.getCpf());
            editarCliente.setInt(5, a.getIdPessoa());
            editarCliente.executeUpdate();
            editarCliente.close();
//************************** editarEndereco ************************************
            PreparedStatement editarEndereco = con.prepareStatement(
                    "update endereco set logradouro = ?, bairro = ?, numero = ?, cep = ? where idEndereco = ?");

            editarEndereco.setString(1, a.getLogradouro());
            editarEndereco.setString(2, a.getBairro());
            editarEndereco.setString(3, a.getNumero());
            editarEndereco.setString(4, a.getCep());
            editarEndereco.setInt(5, a.getIdEndereco());
            editarEndereco.executeUpdate();
            editarEndereco.close();
//****************************** editarCidade **********************************
            PreparedStatement editarCidade = con.prepareStatement(
                    "update cidade set cidade = ? where idCidade = ?");

            editarCidade.setString(1, a.getCidade());
            editarCidade.setInt(2, a.getIdCidade());
            editarCidade.executeUpdate();
            editarCidade.close();
//*************************** editarEstado *************************************
            PreparedStatement editarEstado = con.prepareStatement(
                    "update estado set estado = ? where idEstado = ?");

            editarEstado.setString(1, a.getEstado());
            editarEstado.setInt(2, a.getIdEstado());
            editarEstado.executeUpdate();
            editarEstado.close();
//*************************** editarPais ***************************************
            PreparedStatement editarPais = con.prepareStatement(
                    "update pais set pais = ? where idPais = ?");

            editarPais.setString(1, a.getPais());
            editarPais.setInt(2, a.getIdPais());
            editarPais.executeUpdate();
            editarPais.close();
//******************************************************************************
        }
        con.close();
    }

//##############################################################################
    public void excluir(Cliente a) throws SQLException {

        Connection con = DriverManager.getConnection(url, user, password);
//************ Contar quantas compras o cliente fez, sendo 0 nenhuma ***********
        PreparedStatement contar = con.prepareStatement(
                "select count(idClienteFK) as 'total' from venda where idClienteFK = ?");

        contar.setInt(1, a.getAjudaExcluir());

        ResultSet resultadoCliente;

        resultadoCliente = contar.executeQuery();

        if (resultadoCliente.next()) {
            // apenas pegando o total
            a.setTotalVendaCliente(resultadoCliente.getInt("total"));
        }
        contar.close();
//*************** Buscar os Id para deletar onde for preciso *******************
        if (a.getTotalVendaCliente() == 0) {
            PreparedStatement buscarIdsCliente = con.prepareStatement(
                    "select * from vwlistacliente where idCliente = ?");

            buscarIdsCliente.setInt(1, a.getAjudaExcluir());

            ResultSet resultadoIdsCliente;

            resultadoIdsCliente = buscarIdsCliente.executeQuery();

            while (resultadoIdsCliente.next()) {
                // apenas pegando os id
                a.setIdCliente(resultadoIdsCliente.getInt("idCliente"));
                a.setIdPessoa(resultadoIdsCliente.getInt("idPessoa"));
                a.setIdEndereco(resultadoIdsCliente.getInt("idEndereco"));
                //a.setIdCidade(resultadoIdsCliente.getInt("idCidade"));
                //a.setIdEstado(resultadoIdsCliente.getInt("idEstado"));
                //a.setIdPais(resultadoIdsCliente.getInt("idPais"));
            }
            buscarIdsCliente.close();
//************************* Deletar por tabela *********************************
            if (a.getIdCliente() != null) {
                PreparedStatement excluirDados = con.prepareStatement(
                        "delete from cliente where idCliente = ?");

                excluirDados.setInt(1, a.getIdCliente());
                excluirDados.executeUpdate();
                excluirDados.close();
//************************* Deletar por tabela *********************************
                PreparedStatement excluirPessoa = con.prepareStatement(
                        "delete from pessoa where idPessoa = ?");

                excluirPessoa.setInt(1, a.getIdPessoa());
                excluirPessoa.executeUpdate();
                excluirPessoa.close();
//************************* Deletar por tabela *********************************
                PreparedStatement excluirEndereco = con.prepareStatement(
                        "delete from endereco where idEndereco = ?");

                excluirEndereco.setInt(1, a.getIdEndereco());
                excluirEndereco.executeUpdate();
                excluirEndereco.close();
            }
        }
//********************************* Fim  ***************************************
        con.close();
    }
//##############################################################################
}
