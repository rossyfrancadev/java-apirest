package com.franca.models;

import java.io.Serializable;

import com.franca.enums.TipoPagamento;

public class Sale implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int idItemVenda;
	private TipoPagamento tipoPagamento;
	private Client cliente;
	private float totalPagar;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdItemVenda() {
		return idItemVenda;
	}

	public void setIdItemVenda(int idItemVenda) {
		this.idItemVenda = idItemVenda;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}

	public float getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(float totalPagar) {
		this.totalPagar = totalPagar;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", idItemVenda=" + idItemVenda + ", tipoPagamento=" + tipoPagamento + ", cliente="
				+ cliente + ", totalPagar=" + totalPagar + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
