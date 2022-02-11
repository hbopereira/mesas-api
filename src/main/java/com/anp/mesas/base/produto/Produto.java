package com.anp.mesas.base.produto;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.anp.mesas.base.BaseEntity;

@Entity
@Table(name = "produto")
public class Produto extends BaseEntity {

	private String descricao;
	private BigDecimal preco;

	public Produto() {

	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preço) {
		this.preco = preço;
	}

}
