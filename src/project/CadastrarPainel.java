package projetoFinal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class CadastrarPainel extends JPanel {
	
	private JLabel cadastro,nome,numero;
	private JTextField tfnome,tfnumero;
	private JButton salvar;
	private BD banco;

	public CadastrarPainel (){
		inicializarComponentes();
		definirEventos();
	}
	public void inicializarComponentes (){
		setLayout (null);
		setBackground (new Color(0,162,232));
		cadastro = new JLabel (new ImageIcon (""));
		nome = new JLabel ("Nome:");
		numero = new JLabel ("Número:");
		tfnome = new JTextField ();
		tfnumero = new JTextField ();
		salvar = new JButton ("Salvar");
		
		nome.setBounds(5,5,50,20);
		tfnome.setBounds (60,5,200,20);
		numero.setBounds(5,40,50,20);
		tfnumero.setBounds(60,40,200,20);
		salvar .setBounds (170,70,90,20);
		
		add(nome);
		add(numero);
		add(tfnome);
		add(tfnumero);
		add(salvar);
		
		banco = new BD();
	}
	
	public void definirEventos (){
		salvar.addActionListener(new ActionListener (){
			public void actionPerformed (ActionEvent e)
			{	
				if (tfnome.getText().equals("")&&tfnumero.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Campos obrigatórios");
					tfnome.requestFocus();
					tfnome.setBorder(new LineBorder(Color.red));
					tfnumero.setBorder(new LineBorder(Color.red));
					return;
				}else
				if (tfnome.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Campo 'Nome' Obrigatório");
					tfnome.requestFocus();
					tfnome.setBorder(new LineBorder(Color.red));
					return;
				}else
					if (tfnumero.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Campo 'Numero'Obrigatório");
					tfnumero.requestFocus();
					tfnumero.setBorder(new LineBorder (Color.red));
					return;
				}
				
				if (banco.getConnection()){
					salvar();
					  
			
					
				}
				
			}

			
		});
		
	}
	public void salvar (){
		
		String sql = "INSERT INTO contatos values (?,?)";
		try {
			PreparedStatement statement = banco.connection.prepareStatement(sql);
			statement.setString(1,tfnome.getText() );
			statement.setString(2, tfnumero.getText());
			tfnome.setText("");
			tfnumero.setText(""); 
			
			JOptionPane.showMessageDialog(null,"Dados inserido com Sucesso !");
			statement.executeUpdate();
			statement.close(); 	
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Falha na conexão!");
			e.printStackTrace();
			
		}
	}
	
	
}
