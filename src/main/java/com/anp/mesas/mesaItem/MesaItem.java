package com.anp.mesas.mesaItem;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.anp.mesas.base.BaseEntity;
import com.anp.mesas.base.produto.Produto;

@Entity
@Table(name = "mesaItem")
public class MesaItem extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	private BigDecimal quantidade;

	public MesaItem() {

	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

}
