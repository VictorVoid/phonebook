package projetoFinal;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class PaginaInicial extends JPanel {
	
	private JButton btCadastrar,btContato,btSair,btPesquisar;
	private JLabel jlContatos;
	private Container contentPane;
	public PaginaInicial (){
		adicionarComponentes();
		definirEventos();
	}
	public void adicionarComponentes (){
		setLayout (null);
		btPesquisar = new JButton (new ImageIcon ("Imagens//Pesquisar.jpg"));
		btCadastrar = new JButton (new ImageIcon ("Imagens/Novo.png"));btCadastrar.setFont(new Font ("Chiller",Font.LAYOUT_NO_START_CONTEXT,25));
		btCadastrar.setToolTipText("Clique para Cadastrar um novo Contato");
		btContato = new JButton (new ImageIcon ("Imagens/Contatos.png"));btContato.setFont(new Font ("Chiller",Font.LAYOUT_NO_START_CONTEXT,25));
		btContato.setToolTipText("Clique pra visualizar seus contatos");
		btSair 		= new JButton (new ImageIcon ("Imagens//Sair.png")); btSair.setBackground(Color.blue);
		btSair.setToolTipText("Clique para sair");
		
		jlContatos = new JLabel (new ImageIcon ());
			
		setBackground (new Color(0,162,232));

		btCadastrar .setBounds(180,5,160,160);		btCadastrar	.setBackground(new Color (89,89,255)); btCadastrar.setForeground(Color.white);
		btContato .setBounds(5,5,160,160); 			//btContato	.setBackground(new Color (89,89,255)); btContato.setForeground(Color.white);
		btSair 		.setBounds(5,170,160,160);		btSair	.setBackground(Color.white);
		jlContatos  . setBounds (0,0,350,450);	
		btPesquisar.setBounds(180,170,160,160);
		btPesquisar.setToolTipText("Clique aqui para pesquisar");
		add(btCadastrar);
		add(btContato);
		add(btSair);
		add(jlContatos);
		add(btPesquisar);
	}

	public void definirEventos (){
		btContato.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent e){
				
				Contatos janela = new Contatos ();
				
			}
		});
		
		btCadastrar.addActionListener(new ActionListener (){
			public void actionPerformed(ActionEvent e){
				Cadastrar janela2 = new Cadastrar();
			}
			
		});
		btSair.addActionListener(new ActionListener (){
			public void actionPerformed (ActionEvent e){
				int s = JOptionPane.showConfirmDialog (null,"Tem certeza que deseja sair ?","Atenção",JOptionPane.YES_NO_OPTION);
				if (s == JOptionPane.YES_NO_OPTION){
					System.exit(0);
				}
					
				
			}
		});
		btPesquisar.addActionListener(new ActionListener (){
			public void actionPerformed (ActionEvent e){
				Pesquisar janela3 = new Pesquisar();
			}
		});
	}
}
