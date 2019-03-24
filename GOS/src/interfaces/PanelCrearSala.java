package interfaces;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.CrearSala_Controller;
import controller.RegistrarUsuario_Controller;
import logic.Carrera;
import logic.Tipo;
import javax.swing.SwingConstants;

public class PanelCrearSala extends JPanel {
	
	private JTextField txtNombreSala;
	private JTextField txtNumeroComputadores;
	private JButton btnRegistrar;
	private JButton btnLimpiar;

	/**
	 * Create the panel.
	 */
	public PanelCrearSala() {
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblFormularioRegistroEstudiantes = new JLabel("Formulario Registrar Sala");
		lblFormularioRegistroEstudiantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormularioRegistroEstudiantes.setFont(new Font("Arial", Font.PLAIN, 30));
		lblFormularioRegistroEstudiantes.setBounds(15, 13, 900, 35);
		add(lblFormularioRegistroEstudiantes);
		
		JLabel lblCodigo = new JLabel("Nombre Sala");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCodigo.setBounds(267, 76, 136, 25);
		add(lblCodigo);
		
		JLabel lblNombe = new JLabel("Total Computadores");
		lblNombe.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNombe.setBounds(235, 139, 194, 25);
		add(lblNombe);
		
		txtNombreSala = new JTextField();
		txtNombreSala.setFont(new Font("Arial", Font.PLAIN, 17));
		txtNombreSala.setBounds(444, 76, 202, 25);
		add(txtNombreSala);
		txtNombreSala.setColumns(10);
		
		txtNumeroComputadores = new JTextField();
		txtNumeroComputadores.setFont(new Font("Arial", Font.PLAIN, 17));
		txtNumeroComputadores.setColumns(10);
		txtNumeroComputadores.setBounds(444, 139, 202, 25);
		add(txtNumeroComputadores);
		
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
		
		btnRegistrar.addActionListener(new CrearSala_Controller(this));
		btnLimpiar.addActionListener(new CrearSala_Controller(this));

	}

	public JTextField getTxtNombreSala() {
		return txtNombreSala;
	}

	public void setTxtNombreSala(JTextField txtNombreSala) {
		this.txtNombreSala = txtNombreSala;
	}

	public JTextField getTxtNumeroComputadores() {
		return txtNumeroComputadores;
	}

	public void setTxtNumeroComputadores(JTextField txtNumeroComputadores) {
		this.txtNumeroComputadores = txtNumeroComputadores;
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
