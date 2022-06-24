/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.modelo;

/**
 *
 *
 */
public class Cliente extends Pessoa {

    /**
     * @return the ajudaExcluir
     */
    public Integer getAjudaExcluir() {
        return ajudaExcluir;
    }

    /**
     * @param ajudaExcluir the ajudaExcluir to set
     */
    public void setAjudaExcluir(Integer ajudaExcluir) {
        this.ajudaExcluir = ajudaExcluir;
    }

    /**
     * @return the pesquisaCliente
     */
    public String getPesquisaCliente() {
        return pesquisaCliente;
    }

    /**
     * @param pesquisaCliente the pesquisaCliente to set
     */
    public void setPesquisaCliente(String pesquisaCliente) {
        this.pesquisaCliente = pesquisaCliente;
    }

    /**
     * @return the totalVendaCliente
     */
    public Integer getTotalVendaCliente() {
        return totalVendaCliente;
    }

    /**
     * @param totalVendaCliente the totalVendaCliente to set
     */
    public void setTotalVendaCliente(Integer totalVendaCliente) {
        this.totalVendaCliente = totalVendaCliente;
    }

    /**
     * @return the idCliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the idPessoaFK
     */
    public Integer getIdPessoaFK() {
        return idPessoaFK;
    }

    /**
     * @param idPessoaFK the idPessoaFK to set
     */
    public void setIdPessoaFK(Integer idPessoaFK) {
        this.idPessoaFK = idPessoaFK;
    }
    private Integer idCliente;

    private Integer idPessoaFK;

    private Integer totalVendaCliente;

    private String pesquisaCliente;

    private Integer ajudaExcluir;

    public void getCep(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
