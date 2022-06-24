/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.modelo;

/**
 *
 *
 */
public class Endereco {

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the idEndereco
     */
    public Integer getIdEndereco() {
        return idEndereco;
    }

    /**
     * @param idEndereco the idEndereco to set
     */
    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    /**
     * @return the idEnderecoFK
     */
    public Integer getIdEnderecoFK() {
        return idEnderecoFK;
    }

    /**
     * @param idEnderecoFK the idEnderecoFK to set
     */
    public void setIdEnderecoFK(Integer idEnderecoFK) {
        this.idEnderecoFK = idEnderecoFK;
    }

    /**
     * @return the idCidade
     */
    public Integer getIdCidade() {
        return idCidade;
    }

    /**
     * @param idCidade the idCidade to set
     */
    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    /**
     * @return the idCidadeFK
     */
    public Integer getIdCidadeFK() {
        return idCidadeFK;
    }

    /**
     * @param idCidadeFK the idCidadeFK to set
     */
    public void setIdCidadeFK(Integer idCidadeFK) {
        this.idCidadeFK = idCidadeFK;
    }

    /**
     * @return the idEstado
     */
    public Integer getIdEstado() {
        return idEstado;
    }

    /**
     * @param idEstado the idEstado to set
     */
    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    /**
     * @return the idEstadoFK
     */
    public Integer getIdEstadoFK() {
        return idEstadoFK;
    }

    /**
     * @param idEstadoFK the idEstadoFK to set
     */
    public void setIdEstadoFK(Integer idEstadoFK) {
        this.idEstadoFK = idEstadoFK;
    }

    /**
     * @return the idPais
     */
    public Integer getIdPais() {
        return idPais;
    }

    /**
     * @param idPais the idPais to set
     */
    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    /**
     * @return the idPaisFK
     */
    public Integer getIdPaisFK() {
        return idPaisFK;
    }

    /**
     * @param idPaisFK the idPaisFK to set
     */
    public void setIdPaisFK(Integer idPaisFK) {
        this.idPaisFK = idPaisFK;
    }

    private String logradouro;

    private String bairro;

    private String numero;

    private String cep;

    private String cidade;

    private String estado;

    private String pais;

    private Integer idEndereco;

    private Integer idEnderecoFK;

    private Integer idCidade;

    private Integer idCidadeFK;

    private Integer idEstado;

    private Integer idEstadoFK;

    private Integer idPais;

    private Integer idPaisFK;

}
