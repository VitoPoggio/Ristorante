package com.ristorante.module;

import java.util.Date;

/**
 * Classe Prenotazione: Rappresenta una prenotazione effettuata da un utente.
 */

public class Prenotazione {
	
	//nuova prenotazione recupero lista tavoli con posti richiesti o maggiori, controllo se esiste prenotazione con data e orario richiesti
	private int id;
	private Date data;
	private int orario;
	private int tavolo;
	public Prenotazione() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getOrario() {
		return orario;
	}
	public void setOrario(int orario) {
		this.orario = orario;
	}
	public int getTavolo() {
		return tavolo;
	}
	public void setTavolo(int tavolo) {
		this.tavolo = tavolo;
	}
	
	
	
	
}
