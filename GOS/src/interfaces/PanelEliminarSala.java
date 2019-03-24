package interfaces;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.EliminarSala_Controller;

public class PanelEliminarSala extends JPanel {
	
	private JTextField txtNombre;
	private JTextField txtNumeroComputadores;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	private JLabel label;
	private JTextField txtBuscarSala;
	private JButton btnBuscar;

	/**
	 * Create the panel.
	 */
	public PanelEliminarSala() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblFormularioRegistroEstudiantes = new JLabel("Formulario Eliminar Sala");
		lblFormularioRegistroEstudiantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormularioRegistroEstudiantes.setFont(new Font("Arial", Font.PLAIN, 30));
		lblFormularioRegistroEstudiantes.setBounds(15, 13, 900, 35);
		add(lblFormularioRegistroEstudiantes);
		
		JLabel lblCodigo = new JLabel("Sala");
		lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCodigo.setBounds(235, 132, 178, 25);
		add(lblCodigo);
		
		JLabel lblNombe = new JLabel("Total Computadores");
		lblNombe.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNombe.setBounds(235, 179, 194, 25);
		add(lblNombe);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 17));
		txtNombre.setBounds(444, 132, 202, 25);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtNumeroComputadores = new JTextField();
		txtNumeroComputadores.setEditable(false);
		txtNumeroComputadores.setFont(new Font("Arial", Font.PLAIN, 17));
		txtNumeroComputadores.setColumns(10);
		txtNumeroComputadores.setBounds(444, 179, 202, 25);
		add(txtNumeroComputadores);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEliminar.setBounds(360, 235, 100, 30);
		add(btnEliminar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setEnabled(false);
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLimpiar.setBounds(508, 235, 100, 30);
		add(btnLimpiar);
		
		label = new JLabel("Nombre Sala");
		label.setFont(new Font("Arial", Font.PLAIN, 20));
		label.setBounds(267, 64, 136, 25);
		add(label);
		
		txtBuscarSala = new JTextField();
		txtBuscarSala.setFont(new Font("Arial", Font.PLAIN, 17));
		txtBuscarSala.setColumns(10);
		txtBuscarSala.setBounds(444, 64, 202, 25);
		add(txtBuscarSala);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscar.setBackground(Color.BLACK);
		btnBuscar.setBounds(661, 64, 100, 30);
		add(btnBuscar);
		
		btnEliminar.addActionListener(new EliminarSala_Controller(this));
		btnLimpiar.addActionListener(new EliminarSala_Controller(this));
		btnBuscar.addActionListener(new EliminarSala_Controller(this));

	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtNumeroComputadores() {
		return txtNumeroComputadores;
	}

	public void setTxtNumeroComputadores(JTextField txtNumeroComputadores) {
		this.txtNumeroComputadores = txtNumeroComputadores;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	public JTextField getTxtBuscarSala() {
		return txtBuscarSala;
	}

	public void setTxtBuscarSala(JTextField txtBuscarSala) {
		this.txtBuscarSala = txtBuscarSala;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}
	
	

}
