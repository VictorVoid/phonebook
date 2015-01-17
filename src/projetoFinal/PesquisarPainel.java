package projetoFinal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PesquisarPainel extends JPanel implements ActionListener{
	private JRadioButton nome,numero;
	private JLabel pergunta;
	private ButtonGroup grupo;
	private JTextField tfnome;
	private JButton btpesquisar;
	private JTable tabela;
	private JScrollPane scroll;
	
	private BD banco ;
	public PesquisarPainel (){
		setLayout (null);
		setBackground(new Color(0,162,232));
		tfnome = new JTextField ();

		nome = new JRadioButton ("Nome");
		numero = new JRadioButton ("Número");
		pergunta= new JLabel ("Informe o tipo de Busca");
		btpesquisar = new JButton (new ImageIcon ("Imagens//btpesquisar.png")); btpesquisar.setBackground(Color.white);
		tfnome.setBounds(40,30,200,30);
		btpesquisar.setBounds(240,30,50,30);
		pergunta.setBounds(80,60,200,30);
		grupo = new ButtonGroup();
		grupo.add(nome);
		grupo.add(numero);
		nome.setBounds (40,85,60,20); nome.setBackground(new Color(0,162,232)); nome.setForeground(Color.white);
		numero.setBounds(160,85,90,20); numero.setBackground(new Color(0,162,232)); numero.setForeground(Color.white);
		add(tfnome);
		add(nome);
		add(numero);
		add(pergunta);
		add(btpesquisar);
		btpesquisar.addActionListener(this);
		banco= new BD ();
		scroll = new JScrollPane();
		scroll.setBounds(40,112,250,150);
		add(scroll);
	}
	
	public void actionPerformed (ActionEvent e){
		if (e.getSource() == btpesquisar){
			if (nome.isSelected()){
				if (banco.getConnection()){
				pesquisaNome ();
				}else JOptionPane.showMessageDialog (null,"ERRO NA CONEXÃO");
			}else
				if (numero.isSelected()){
					if (banco.getConnection()){
					  pesquisaNumero();
					}
				}else
					if (!numero.isSelected() &&!nome.isSelected()){
						JOptionPane.showMessageDialog (null,"Selecione uma opção de busca! ");
					}
			
			
		}
	}
	public void pesquisaNome ()
	{
		String sql = "SELECT * FROM contatos where nome = ? "; 
		try {
			PreparedStatement statement = banco.connection.prepareStatement (sql);
			statement.setString(1, tfnome.getText());
			
			ResultSet resultSet = statement.executeQuery() ;
				
			DefaultTableModel tabelaModelo = new DefaultTableModel(new String []{},0){};
			int qtdeColuna = resultSet.getMetaData().getColumnCount();
			
			for (int i = 1; i <= qtdeColuna;i++)
				tabelaModelo.addColumn(resultSet.getMetaData().getColumnName(i));
			tabela = new JTable (tabelaModelo);
			
			DefaultTableModel dtm = (DefaultTableModel)tabela.getModel();
			while (resultSet.next()){
				try {
				String [] dados = new String [qtdeColuna];	
					
				for (int i = 1; i <= qtdeColuna;i++){
					dados [i-1] = resultSet.getString (i);
						
				}
					dtm.addRow(dados);
				}catch (SQLException err){}
				
				scroll.setViewportView(tabela);
			}
			
			statement.close();
			resultSet.close();
			banco.close();
			
			
		}catch (SQLException erro){
			JOptionPane.showMessageDialog (null, "ERRO NA CONEXAO ! :D"+erro.toString());
					
		}
		
	}
	public void pesquisaNumero (){
		
		String sql = "SELECT * FROM contatos where numero = ? "; 
		try {
			PreparedStatement statement = banco.connection.prepareStatement (sql);
			statement.setString(1, tfnome.getText());
			
			ResultSet resultSet = statement.executeQuery() ;
				
			DefaultTableModel tabelaModelo = new DefaultTableModel(new String []{},0){};
			int qtdeColuna = resultSet.getMetaData().getColumnCount();
			
			for (int i = 1; i <= qtdeColuna;i++)
				tabelaModelo.addColumn(resultSet.getMetaData().getColumnName(i));
			tabela = new JTable (tabelaModelo);
			
			DefaultTableModel dtm = (DefaultTableModel)tabela.getModel();
			while (resultSet.next()){
				try {
				String [] dados = new String [qtdeColuna];	
					
				for (int i = 1; i <= qtdeColuna;i++){
					dados [i-1] = resultSet.getString (i);
						
				}
					dtm.addRow(dados);
				}catch (SQLException err){}
				
				scroll.setViewportView(tabela);
			}
			
			statement.close();
			resultSet.close();
			banco.close();
			
			
		}catch (SQLException erro){
			JOptionPane.showMessageDialog (null, "ERRO NA CONEXAO ! :D"+erro.toString());
					
		}
		
	}
		

}
