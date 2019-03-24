package interfaces;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.BuscarUsuario_Controller;

import java.awt.Color;
import java.awt.Font;

public class PanelBuscarUsuario extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCarrera;
	private JButton btnBuscar;
	private JButton btnLimpiar;
	private JTextField txtBuscarEstudiante;
	private JTextField txtTipo;
	
	public PanelBuscarUsuario() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblFormularioRegistroEstudiantes = new JLabel("Formulario Buscar Usuario");
		lblFormularioRegistroEstudiantes.setFont(new Font("Arial", Font.PLAIN, 30));
		lblFormularioRegistroEstudiantes.setBounds(274, 13, 430, 35);
		add(lblFormularioRegistroEstudiantes);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCodigo.setBounds(182, 137, 70, 25);
		add(lblCodigo);
		
		JLabel lblNombe = new JLabel("Nombre");
		lblNombe.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNombe.setBounds(182, 194, 70, 25);
		add(lblNombe);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTipo.setBounds(182, 245, 70, 25);
		add(lblTipo);
		
		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCarrera.setBounds(496, 194, 70, 25);
		add(lblCarrera);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 20));
		lblApellido.setBounds(496, 137, 70, 25);
		add(lblApellido);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 17));
		txtCodigo.setBounds(282, 137, 150, 25);
		add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 17));
		txtNombre.setColumns(10);
		txtNombre.setBounds(282, 197, 150, 25);
		add(txtNombre);
		
		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		txtTipo.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTipo.setColumns(10);
		txtTipo.setBounds(282, 245, 150, 25);
		add(txtTipo);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setFont(new Font("Arial", Font.PLAIN, 17));
		txtApellido.setColumns(10);
		txtApellido.setBounds(605, 137, 150, 25);
		add(txtApellido);
		
		txtCarrera = new JTextField();
		txtCarrera.setEditable(false);
		txtCarrera.setFont(new Font("Arial", Font.PLAIN, 17));
		txtCarrera.setColumns(20);
		txtCarrera.setBounds(605, 197, 150, 25);
		add(txtCarrera);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.BLACK);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscar.setBounds(359, 292, 100, 30);
		add(btnBuscar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLimpiar.setBounds(507, 292, 100, 30);
		add(btnLimpiar);
		
		JLabel lblCodigoEstudiante = new JLabel("C\u00F3digo Usuario");
		lblCodigoEstudiante.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCodigoEstudiante.setBounds(309, 71, 170, 25);
		add(lblCodigoEstudiante);
		
		txtBuscarEstudiante = new JTextField();
		txtBuscarEstudiante.setFont(new Font("Arial", Font.PLAIN, 17));
		txtBuscarEstudiante.setColumns(10);
		txtBuscarEstudiante.setBounds(491, 71, 150, 25);
		add(txtBuscarEstudiante);
		
		btnBuscar.addActionListener(new BuscarUsuario_Controller(this));
		btnLimpiar.addActionListener(new BuscarUsuario_Controller(this));

	}

	public JTextField getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(JTextField txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtCarrera() {
		return txtCarrera;
	}

	public void setTxtCarrera(JTextField txtCarrera) {
		this.txtCarrera = txtCarrera;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public void setBtnLimpiar(JButton btnLimpiar) {
		this.btnLimpiar = btnLimpiar;
	}

	public JTextField getTxtBuscarEstudiante() {
		return txtBuscarEstudiante;
	}

	public void setTxtBuscarEstudiante(JTextField txtBuscarEstudiante) {
		this.txtBuscarEstudiante = txtBuscarEstudiante;
	}

	public JTextField getTxtTipo() {
		return txtTipo;
	}

	public void setTxtTipo(JTextField txtTipo) {
		this.txtTipo = txtTipo;
	}
	
	
	
	
}
