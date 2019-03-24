package interfaces;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.GestionCarreras_Controller;

public class PanelCrearCarrera extends JPanel {
	
	private JTextField txtNombreSala;
	private JButton btnRegistrar;
	private JButton btnLimpiar;
	/**
	 * Create the panel.
	 */
	public PanelCrearCarrera() {
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblFormularioRegistroEstudiantes = new JLabel("Formulario Registrar Carrera");
		lblFormularioRegistroEstudiantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormularioRegistroEstudiantes.setFont(new Font("Arial", Font.PLAIN, 30));
		lblFormularioRegistroEstudiantes.setBounds(15, 13, 900, 35);
		add(lblFormularioRegistroEstudiantes);
		
		JLabel lblCodigo = new JLabel("Nombre Carrera");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCodigo.setBounds(267, 118, 162, 25);
		add(lblCodigo);
		
		txtNombreSala = new JTextField();
		txtNombreSala.setFont(new Font("Arial", Font.PLAIN, 17));
		txtNombreSala.setBounds(444, 118, 202, 25);
		add(txtNombreSala);
		txtNombreSala.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(Color.BLACK);
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegistrar.setBounds(360, 206, 100, 30);
		add(btnRegistrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLimpiar.setBounds(508, 206, 100, 30);
		add(btnLimpiar);
		
		btnLimpiar.addActionListener(new GestionCarreras_Controller(this));
		btnRegistrar.addActionListener(new GestionCarreras_Controller(this));

	}
	
	public JTextField getTxtNombreSala() {
		return txtNombreSala;
	}
	public void setTxtNombreSala(JTextField txtNombreSala) {
		this.txtNombreSala = txtNombreSala;
	}
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}
	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}
	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}
	
	

}
