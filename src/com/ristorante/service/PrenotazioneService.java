package com.ristorante.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.ristorante.module.Prenotazione;

/**
 * Interfaccia Service di Prenotazione con query e metodi da implementare
 */
public interface PrenotazioneService {

	String SELECT_PRENOTAZIONE="SELECT * FROM prenotazione";
	String INSERT_PRENOTAZIONE="INSERT INTO prenotazione (data, orario, tavolo) values (?,?,?) ";
	String UPDATE_PRENOTAZIONE="SELECT * from prenotazione WHERE id=?";
	String DELETE_PRENOTAZIONE="SELECT id FROM prenotazione WHERE id=?";
	String CONTROLLO_ORARIO="SELECT * FROM prenotazione WHERE orario=? AND data=?";
	
	
	List<Prenotazione> getPrenotazioni() throws SQLException;
	void insertPrenotazione(Prenotazione p) throws SQLException;
	void updatePrenotazione(int id, Prenotazione p) throws SQLException;
	void deletePrenotazione(int id) throws SQLException;
	List<Prenotazione> controlloOrario(int orario, Date data) throws SQLException;
	
	
	
	
}
