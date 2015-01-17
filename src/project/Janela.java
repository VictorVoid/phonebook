package projetoFinal;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Janela extends JFrame implements ActionListener{
		
	private Container content;
	private JMenuBar barra;
	private JMenu arquivo;
	private JMenuItem sair;
	public Janela (){
		barra = new JMenuBar (); barra.setBackground(Color.white);
		arquivo = new JMenu ("Arquivo"); 
		sair = new JMenuItem ("Sair"); sair.setForeground(Color.red); sair.setBackground(Color.white); 
		content = getContentPane();	
		arquivo.add(sair); 
		barra.add(arquivo);
		//setJMenuBar (barra);
		
		PaginaInicial painel1 = new PaginaInicial ();
		content.add(painel1);
		
		sair.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == sair){
			System.exit(0);
		}
	}
	
	public static void menu (){
		Janela menu = new Janela ();
		menu.setVisible(true);
		menu.setTitle("Agenda Telefônica");
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.setResizable (false);
		menu.setSize (350,365);
		menu.setLocation(450,200);
	}
}
