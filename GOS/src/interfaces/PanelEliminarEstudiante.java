package interfaces;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

public class PanelEliminarEstudiante extends JPanel {
	
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JButton btnBuscar;
	private JButton btnLimpiar;
	private JTextField txtBuscarEstudiante;
	private JButton btnEliminar;
	/**
	 * Create the panel.
	 */
	public PanelEliminarEstudiante() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblFormularioRegistroEstudiantes = new JLabel("Formulario Eliminar Estudiante");
		lblFormularioRegistroEstudiantes.setFont(new Font("Arial", Font.PLAIN, 30));
		lblFormularioRegistroEstudiantes.setBounds(252, 13, 430, 35);
		add(lblFormularioRegistroEstudiantes);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCodigo.setBounds(182, 137, 70, 25);
		add(lblCodigo);
		
		JLabel lblNombe = new JLabel("Nombre");
		lblNombe.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNombe.setBounds(182, 194, 70, 25);
		add(lblNombe);
		
		JLabel lblTipo = new JLabel("Carrera");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTipo.setBounds(496, 194, 70, 25);
		add(lblTipo);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 20));
		lblApellido.setBounds(496, 137, 70, 25);
		add(lblApellido);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 17));
		txtCodigo.setBounds(282, 137, 150, 25);
		add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 17));
		txtNombre.setColumns(10);
		txtNombre.setBounds(282, 197, 150, 25);
		add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Arial", Font.PLAIN, 17));
		txtApellido.setColumns(10);
		txtApellido.setBounds(605, 137, 150, 25);
		add(txtApellido);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(605, 197, 150, 25);
		add(comboBox);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.BLACK);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscar.setBounds(592, 71, 100, 30);
		add(btnBuscar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLimpiar.setBounds(507, 292, 100, 30);
		add(btnLimpiar);
		
		JLabel lblCodigoEstudiante = new JLabel("C\u00F3digo Estudiante");
		lblCodigoEstudiante.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCodigoEstudiante.setBounds(246, 72, 170, 25);
		add(lblCodigoEstudiante);
		
		txtBuscarEstudiante = new JTextField();
		txtBuscarEstudiante.setFont(new Font("Arial", Font.PLAIN, 17));
		txtBuscarEstudiante.setColumns(10);
		txtBuscarEstudiante.setBounds(428, 72, 150, 25);
		add(txtBuscarEstudiante);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(322, 292, 100, 30);
		add(btnEliminar);
	}

}
