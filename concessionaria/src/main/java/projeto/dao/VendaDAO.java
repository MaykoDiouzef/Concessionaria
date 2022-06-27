/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import projeto.modelo.Venda;

/**
 *
 *
 */
public class VendaDAO {
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    String url = "jdbc:mysql://localhost:3306/concessionaria";
    String user = "root";
    String password = "123456";
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//##############################################################################

    public void inserir(Venda a) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
//************************* inserir venda **************************************
        PreparedStatement inserirVenda = con.prepareStatement(
                "insert into venda (idFuncionarioFK, idClienteFK, idVeiculoFK, valorVenda, tipoVenda) values (?,?,?,?,?)");

        inserirVenda.setInt(1, a.getIdVendaFuncionario());
        inserirVenda.setInt(2, a.getIdVendaCliente());
        inserirVenda.setInt(3, a.getIdVendaVeiculo());
        inserirVenda.setFloat(4, a.getValorVenda());
        inserirVenda.setString(5, a.getTipoVenda());
        inserirVenda.executeUpdate();
        inserirVenda.close();
//***************************** fechando conexão *******************************
        con.close();
    }
//##############################################################################  
}
