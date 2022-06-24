/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto.modelo;

import java.util.Date;

public class Funcionario extends Pessoa {

    /**
     * @return the idFuncionario
     */
    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the as
     */
    public Integer getAs() {
        return as;
    }

    /**
     * @param as the as to set
     */
    public void setAs(Integer as) {
        this.as = as;
    }

    /**
     * @return the matricula
     */
    public Integer getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the cargo
     */
    public Integer getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(Integer cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the salario
     */
    public Double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    /**
     * @return the data_contratacao
     */
    public Date getData_contratacao() {
        return data_contratacao;
    }

    /**
     * @param data_contratacao the data_contratacao to set
     */
    public void setData_contratacao(Date data_contratacao) {
        this.data_contratacao = data_contratacao;
    }

    /**
     * @return the data_demicao
     */
    public Date getData_demicao() {
        return data_demicao;
    }

    /**
     * @param data_demicao the data_demicao to set
     */
    public void setData_demicao(Date data_demicao) {
        this.data_demicao = data_demicao;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the pergunta_seguranca
     */
    public String getPergunta_seguranca() {
        return pergunta_seguranca;
    }

    /**
     * @param pergunta_seguranca the pergunta_seguranca to set
     */
    public void setPergunta_seguranca(String pergunta_seguranca) {
        this.pergunta_seguranca = pergunta_seguranca;
    }

    /**
     * @return the resposta_seguranca
     */
    public String getResposta_seguranca() {
        return resposta_seguranca;
    }

    /**
     * @param resposta_seguranca the resposta_seguranca to set
     */
    public void setResposta_seguranca(String resposta_seguranca) {
        this.resposta_seguranca = resposta_seguranca;
    }

    /**
     * @return the data_criacao
     */
    public Date getData_criacao() {
        return data_criacao;
    }

    /**
     * @param data_criacao the data_criacao to set
     */
    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    private Integer idFuncionario;
    private Integer as;
    private Integer matricula;
    private Integer cargo;
    private Double salario;
    private Date data_contratacao;
    private Date data_demicao;
    private String login;
    private String senha;
    private String pergunta_seguranca;
    private String resposta_seguranca;
    private Date data_criacao;

}
