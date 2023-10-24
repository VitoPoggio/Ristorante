package com.ristorante.module;

/**
 * Classe Tavolo: Rappresenta un tavolo del ristorante.
 */
public class Tavolo {

	private int id;
	private int numeroPosti;
	private boolean stato;

	public Tavolo() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}

	public boolean isStato() {
		return stato;
	}

	public void setStato(boolean stato) {
		this.stato = stato;
	}

}
