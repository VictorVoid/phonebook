package projetoFinal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ContatosPainel extends JPanel{
	private JLabel contatos;
	private JTable table; 
	private JScrollPane scrollTable;
	private JButton apagar;
	public BD banco;
	private JTextField tfnomes;
	public ContatosPainel (){
		
		definirComponentes ();
		mostrarBanco();
		definirEventos();
	}
	public void definirComponentes(){
		setLayout(null);
		setBackground (Color.white);
		contatos = new JLabel ("Contatos"); contatos.setFont(new Font ("Chiller",Font.LAYOUT_NO_START_CONTEXT,55));
		
		apagar = new JButton ("Apagar"); apagar.setBackground(Color.white);
		apagar.setBounds(420,305,80,30);
		contatos.setBounds(150,40,200,40);
		tfnomes = new JTextField ("Insira o nome aqui");
		
		tfnomes.setBounds(260,305,150,30);
		
		add(contatos);
		scrollTable = new JScrollPane();
		scrollTable.setBounds(100,100,400,200	);
		add(apagar);
		add(scrollTable);
		add(tfnomes);

	}
	public void mostrarBanco (){
		String sql = "SELECT * FROM contatos";
		banco = new BD();;
		 //Conexão
	try{
			if (banco.getConnection()){
			PreparedStatement statement = banco.connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
				// Adicionando um modelo
			DefaultTableModel tableModelo = new DefaultTableModel(new String []{},0){}; // pro título
			
			int quantidadeCol = resultSet.getMetaData().getColumnCount();
			
			for (int i = 1; i <= quantidadeCol; i++)
			tableModelo.addColumn(resultSet.getMetaData().getColumnName(i)); //Adcionando os titulos na coluna
			table = new JTable(tableModelo);
			DefaultTableModel dtm = (DefaultTableModel)table.getModel();
			while (resultSet.next()){ // enquanto houver regitro !
				try {
					String [] dados = new String [quantidadeCol];
					for(int i = 1;i <=quantidadeCol;i++){
						dados [i-1] = resultSet.getString(i);
					}
					dtm.addRow(dados); // ele pega a última linha 
					
				}catch (SQLException erro){
					JOptionPane.showMessageDialog (null, "Erro na Conexão");
				}
				JTableHeader titulos = table.getTableHeader(); // estanciando um objeto da tabela para personalizar oo título
				titulos.setBackground(new Color(0,162,232));
				titulos.setForeground(Color.white);
				titulos.setFont(new Font ("Arial",Font.BOLD,20));
				titulos.setBorder(new LineBorder(new Color(0,162,232)));
				table.setBorder(new LineBorder((new Color(0,162,232))));
				table.setBackground(Color.white); table.setForeground(Color.darkGray);
				scrollTable.setViewportView(table);
				//table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
				table.setCellSelectionEnabled(true);//true ou false irá selecionar somente uma célula
				
				
			}
			
				resultSet.close();
				statement.close();
				banco.close();
			
			}
	  }catch (Exception erro){
		JOptionPane.showMessageDialog(null,"Comando SQL inválido !"+erro.toString());
}
		
}
		public void definirEventos ()
		{
			apagar.addActionListener(new ActionListener (){
				public void actionPerformed (ActionEvent e){
					if (banco.getConnection()){
					try {
						if (tfnomes.getText().equals("")){
							JOptionPane.showMessageDialog (null,"Insira o nome !","Aviso !",JOptionPane.ERROR_MESSAGE);
							return;
						}
					String sql1 = "DELETE from contatos WHERE nome = ?";
					PreparedStatement statement = banco.connection.prepareStatement(sql1);
					statement.setString (1, tfnomes.getText());
					tfnomes.setText("");
					JOptionPane.showMessageDialog(null,"Contato apagado com sucesso !");
	
					statement.executeUpdate();
					statement.close(); 
					
					
					}catch (SQLException erro){
						System.err.println ("Erro de conexão 1");
					}
				}else
					JOptionPane.showMessageDialog(null,"ksd");
					
				}
			});
			
		}
		
	}  
	



