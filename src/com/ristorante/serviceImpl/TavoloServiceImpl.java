package com.ristorante.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.ristorante.module.Tavolo;
import com.ristorante.service.TavoloService;


/**
 * Implementazione dei metodi in TavoloService
 */
public class TavoloServiceImpl implements TavoloService {

	private Connection conn;
	
	public TavoloServiceImpl(Connection conn) {
		this.conn = conn;
	}
		
	@Override
	public List<Tavolo> getTavoli() throws SQLException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery(SELECT_TAVOLO);
		List<Tavolo> tavoli = new ArrayList<Tavolo>();
		rs.last();
		rs.beforeFirst();
		while(rs.next()) {
			Tavolo t = new Tavolo();
			t.setId(rs.getInt(1));
			t.setNumeroPosti(rs.getInt(2));
			t.setStato(rs.getBoolean(3)); //probabilmente non funzionerà perché su tabella è TINYINT
			tavoli.add(t);
			
		}
		return tavoli;
	}

	@Override
	public void insertTavolo(int numeroPosti) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(INSERT_TAVOLO,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ps.setInt(1, numeroPosti);
		//executeQuery non serve una query perchè la prenderà dal Prepared
		ResultSet rs = ps.executeQuery();
		conn.commit();
	}

	@Override
	public void updateTavolo(int id, Tavolo t) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(UPDATE_TAVOLO,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		rs.updateInt(1, id);
		rs.updateInt(2, t.getNumeroPosti());
		rs.updateBoolean(3, t.isStato());
		rs.updateRow();
		conn.commit();
		System.out.println("tavolo " + id + " aggiornato");
		
	}

	@Override
	public void deleteTavolo(int id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(DELETE_TAVOLO, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.first();
		rs.deleteRow();
		conn.commit();
		System.out.println("Rimosso Tavolo: " + id);
		
	}

	@Override
	public List<Tavolo> tavoliPerPersone(int numeroPosti) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(TAVOLI_DISP, ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		ps.setInt(1, numeroPosti);
		ResultSet rs = ps.executeQuery();
		List<Tavolo> tavoli = new ArrayList<Tavolo>();
		rs.last();
		rs.beforeFirst();
		while(rs.next()) {
			Tavolo t = new Tavolo();
			t.setId(rs.getInt(1));
			t.setNumeroPosti(rs.getInt(2));
			t.setStato(rs.getBoolean(3)); //probabilmente non funzionerà perché su tabella è TINYINT
			tavoli.add(t);
			
		}
		return tavoli;
	}

}
