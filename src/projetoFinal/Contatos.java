package projetoFinal;

import java.awt.Color;
import java.awt.Container;
import java.awt.ScrollPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Contatos extends JFrame {
	
	private Container contentPane;
	

	
	public Contatos (){
		inicializarComponentes();
	}
	public void inicializarComponentes(){
		setVisible(true);
		setTitle("Agenda Telefônica");
		setResizable (false);
		setSize (600,400);
		setLocation(450,200);
		
		setBackground(Color.white);
		contentPane = getContentPane();
		ContatosPainel painel1 = new ContatosPainel ();
		contentPane.add(painel1);
	
		
	}
	
}