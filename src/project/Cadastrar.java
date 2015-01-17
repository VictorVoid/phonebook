package projetoFinal;

import java.awt.Color;
import java.awt.Container;

import javax.swing.*;

public class Cadastrar extends JFrame {
	public static Container contentPane;
	
	
	public Cadastrar (){
		inicializarComponentes();
	}
	public void inicializarComponentes (){	
		setVisible(true);
		setTitle("Cadastro");
		setResizable (false);
		setSize (300,130);
		setLocation(650,200);
		
		setBackground(Color.white);
		contentPane = getContentPane();
		CadastrarPainel painel2 = new CadastrarPainel ();
		contentPane.add(painel2);
		
	}
}
