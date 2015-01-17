package projetoFinal;

import java.awt.Container;

import javax.swing.*;

public class Pesquisar extends JFrame {
	private Container contentPane;
	
	public Pesquisar (){
		
		inicializarComponentes();
	}
	public void inicializarComponentes (){
		setVisible(true);
		setTitle("Pesquisa");
		setResizable (false);
		setSize (335,300);
		setLocation(650,300);
		
		contentPane = getContentPane();
		PesquisarPainel j = new PesquisarPainel ();
		contentPane.add(j);
		
	}
}
