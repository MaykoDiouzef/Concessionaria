/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.modelo;

/**
 *
 * @author Mayko Diouzef
 */
public class Venda {

    /**
     * @return the idVenda
     */
    public Integer getIdVenda() {
        return idVenda;
    }

    /**
     * @param idVenda the idVenda to set
     */
    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    /**
     * @return the idVendaCliente
     */
    public Integer getIdVendaCliente() {
        return idVendaCliente;
    }

    /**
     * @param idVendaCliente the idVendaCliente to set
     */
    public void setIdVendaCliente(Integer idVendaCliente) {
        this.idVendaCliente = idVendaCliente;
    }

    /**
     * @return the idVendaVeiculo
     */
    public Integer getIdVendaVeiculo() {
        return idVendaVeiculo;
    }

    /**
     * @param idVendaVeiculo the idVendaVeiculo to set
     */
    public void setIdVendaVeiculo(Integer idVendaVeiculo) {
        this.idVendaVeiculo = idVendaVeiculo;
    }

    /**
     * @return the idVendaFuncionario
     */
    public Integer getIdVendaFuncionario() {
        return idVendaFuncionario;
    }

    /**
     * @param idVendaFuncionario the idVendaFuncionario to set
     */
    public void setIdVendaFuncionario(Integer idVendaFuncionario) {
        this.idVendaFuncionario = idVendaFuncionario;
    }

    /**
     * @return the valorVenda
     */
    public Float getValorVenda() {
        return valorVenda;
    }

    /**
     * @param valorVenda the valorVenda to set
     */
    public void setValorVenda(Float valorVenda) {
        this.valorVenda = valorVenda;
    }

    /**
     * @return the tipoVenda
     */
    public String getTipoVenda() {
        return tipoVenda;
    }

    /**
     * @param tipoVenda the tipoVenda to set
     */
    public void setTipoVenda(String tipoVenda) {
        this.tipoVenda = tipoVenda;
    }
    
    private Integer idVenda;
    
    private Integer idVendaCliente;
    
    private Integer idVendaVeiculo;
    
    private Integer idVendaFuncionario;
    
    private Float valorVenda;
    
    private String tipoVenda;
    
}
