package com.ristorante.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ristorante.module.Prenotazione;
import com.ristorante.module.Tavolo;
import com.ristorante.service.PrenotazioneService;



/**
 * Implementazione dei metodi in PrenotazioneService
 */
public class PrenotazioneServiceImpl implements PrenotazioneService {
	private Connection conn;
	
	public PrenotazioneServiceImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public List<Prenotazione> getPrenotazioni() throws SQLException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery(SELECT_PRENOTAZIONE);
		List<Prenotazione> prenotazioni = new ArrayList<Prenotazione>();
		rs.last();
		rs.beforeFirst();
		while(rs.next()) {
			Prenotazione p = new Prenotazione();
			p.setId(rs.getInt(1));
			p.setData(rs.getDate(2));
			p.setOrario(rs.getInt(3));
			p.setTavolo(rs.getInt(4));
			prenotazioni.add(p);
			
		}
		return prenotazioni;
		
	}

	@Override
	public void insertPrenotazione(Prenotazione p) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(INSERT_PRENOTAZIONE,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ps.setDate(1, new java.sql.Date(p.getData().getTime()));
		ps.setInt(2, p.getOrario());
		ps.setInt(3, p.getTavolo()); //forse potrei passare anche il tavolo in input?? oppure fare il controllo del tavolo a monte e metterlo in Prenotazione p
		ResultSet rs = ps.executeQuery();
		conn.commit();
		
	}

	@Override
	public void updatePrenotazione(int id, Prenotazione p) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePrenotazione(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Prenotazione> controlloOrario(int orario, Date data) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
