package interfaces;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class PanelRegistrarUsuario extends JPanel {
	
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JButton btnRegistrar;
	private JButton btnLimpiar;

	/**
	 * Create the panel.
	 */
	public PanelRegistrarUsuario() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblFormularioRegistroEstudiantes = new JLabel("Formulario Registro Estudiantes");
		lblFormularioRegistroEstudiantes.setFont(new Font("Arial", Font.PLAIN, 30));
		lblFormularioRegistroEstudiantes.setBounds(257, 13, 430, 35);
		add(lblFormularioRegistroEstudiantes);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCodigo.setBounds(182, 101, 70, 25);
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
		lblApellido.setBounds(496, 101, 70, 25);
		add(lblApellido);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 17));
		txtCodigo.setBounds(282, 101, 150, 25);
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
		txtApellido.setBounds(605, 101, 150, 25);
		add(txtApellido);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(605, 197, 150, 25);
		add(comboBox);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(Color.BLACK);
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegistrar.setBounds(359, 292, 100, 30);
		add(btnRegistrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLimpiar.setBounds(507, 292, 100, 30);
		add(btnLimpiar);

	}
}
