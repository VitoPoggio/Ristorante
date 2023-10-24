package com.ristorante.service;

import java.sql.SQLException;
import java.util.List;

import com.ristorante.module.Tavolo;

/**
 * Interfaccia Service di Tavolo con query e metodi da implementare
 */

public interface TavoloService {
	String SELECT_TAVOLO="SELECT * FROM tavolo";
	String INSERT_TAVOLO="INSERT INTO tavolo (numeroPosti) values (?) ";
	String UPDATE_TAVOLO="SELECT * from tavolo WHERE id=?";
	String DELETE_TAVOLO="SELECT id FROM tavolo WHERE id=?";
	String TAVOLI_DISP="SELECT * FROM tavolo where numeroPosti>=? AND stato=1";
	
	List<Tavolo> getTavoli() throws SQLException;
	void insertTavolo(int numeroPosti) throws SQLException;
	void updateTavolo(int id, Tavolo t) throws SQLException;
	void deleteTavolo(int id) throws SQLException;
	List<Tavolo> tavoliPerPersone(int numeroPosti) throws SQLException;
	
}
