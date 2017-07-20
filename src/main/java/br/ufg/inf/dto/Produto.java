package br.ufg.inf.dto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
@SequenceGenerator(name = "SEQUENCE", sequenceName = "produto_produto_id_seq")
public class Produto implements Serializable {

    /**
     * Codigo do objeto
     */
    @Id
    @Column(name = "produto_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
    protected Long produtoId;

    @Column(name = "nome")
    private String nome;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "preco")
    private float preco;

    public Produto() {
        produtoId = new Long(-1);
    }

    public Produto(String nome, String codigo, float preco) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
    }

    /**
     * @return the produtoId
     */
    public Long getProdutoId() {
        return produtoId;
    }
    
    /**
     * @param produtoId the produtoId to set
     */
    public void setProdutoId(String produtoId) {
        this.produtoId = Long.valueOf(produtoId);
    }

    /**
     * @param produtoId the produtoId to set
     */
    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

}
