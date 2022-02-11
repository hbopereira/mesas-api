package com.anp.mesas.mesa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.anp.mesas.base.BaseEntity;
import com.anp.mesas.cliente.Cliente;
import com.anp.mesas.mesaItem.MesaItem;

@Entity
@Table(name = "mesa")
public class Mesa extends BaseEntity {

	private Long numero;
	private BigDecimal valorTotal;
	private Integer fechou;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "mesa_cliente", joinColumns = { @JoinColumn(name = "mesa_id") }, inverseJoinColumns = {
			@JoinColumn(name = "cliente_id") })
	private List<Cliente> clientes;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "mesa_mesaitem", joinColumns = { @JoinColumn(name = "mesa_id") }, inverseJoinColumns = {
			@JoinColumn(name = "mesaitem_id") })
	private List<MesaItem> itens;

	public Mesa() {
		clientes = new ArrayList<Cliente>();
		itens = new ArrayList<MesaItem>();
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Integer getFechou() {
		return fechou;
	}

	public void setFechou(Integer fechou) {
		this.fechou = fechou;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<MesaItem> getItens() {
		return itens;
	}

	public void setItens(List<MesaItem> itens) {
		this.itens = itens;
	}

}
