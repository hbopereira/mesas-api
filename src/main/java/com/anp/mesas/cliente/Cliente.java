package com.anp.mesas.cliente;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.anp.mesas.base.BaseEntity;

@Entity
@Table(name = "cliente")
public class Cliente extends BaseEntity {

	private String nome;

	public Cliente() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
