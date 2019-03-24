package interfaces;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.RegistrarUsuario_Controller;
import logic.Carrera;
import logic.Tipo;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class PanelRegistrarUsuario extends JPanel {
	
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JButton btnRegistrar;
	private JButton btnLimpiar;
	private JComboBox cbxCarrera;
	private JComboBox cbxTipo;
	private JTextField txtCorreo;
	private JTextField txtContrasena;

	/**
	 * Create the panel.
	 */
	public PanelRegistrarUsuario() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblFormularioRegistroEstudiantes = new JLabel("Formulario Registro Usuario");
		lblFormularioRegistroEstudiantes.setFont(new Font("Arial", Font.PLAIN, 30));
		lblFormularioRegistroEstudiantes.setBounds(257, 13, 430, 35);
		add(lblFormularioRegistroEstudiantes);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo (*)");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCodigo.setBounds(166, 64, 101, 25);
		add(lblCodigo);
		
		JLabel lblNombe = new JLabel("Nombre (*)");
		lblNombe.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNombe.setBounds(166, 105, 101, 25);
		add(lblNombe);
		
		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCarrera.setBounds(482, 187, 70, 25);
		add(lblCarrera);
		
		JLabel lblTipo = new JLabel("Tipo (*)");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTipo.setBounds(166, 146, 70, 25);
		add(lblTipo);
		
		JLabel lblApellido = new JLabel("Apellido (*)");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 20));
		lblApellido.setBounds(482, 64, 108, 25);
		add(lblApellido);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 17));
		txtCodigo.setBounds(282, 64, 150, 25);
		add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 17));
		txtNombre.setColumns(10);
		txtNombre.setBounds(282, 105, 150, 25);
		add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Arial", Font.PLAIN, 17));
		txtApellido.setColumns(10);
		txtApellido.setBounds(605, 64, 150, 25);
		add(txtApellido);
		
		cbxCarrera = new JComboBox();
		cbxCarrera.setBounds(605, 187, 150, 25);
		add(cbxCarrera);
		
		cbxTipo = new JComboBox();
		cbxTipo.setBounds(282, 147, 150, 25);
		add(cbxTipo);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(Color.BLACK);
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegistrar.setBounds(360, 242, 100, 30);
		add(btnRegistrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLimpiar.setBounds(508, 242, 100, 30);
		add(btnLimpiar);
		
		btnLimpiar.addActionListener(new RegistrarUsuario_Controller(this));
		btnRegistrar.addActionListener(new RegistrarUsuario_Controller(this));
		
		Carrera c = new Carrera();
		ArrayList<String[]> carreras = c.obtenerCarreras();
		cbxCarrera.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una carrera"}));
		cbxCarrera.setSelectedIndex(0);
		cbxCarrera.addItem("No aplica");
		for (int i = 0; i < carreras.size(); i++) {
			cbxCarrera.addItem(carreras.get(i)[1]);
		}
		
		Tipo t = new Tipo();
		ArrayList<String[]> tipos = t.obtenerTipos();
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Seleccione un tipo"}));
		cbxTipo.setSelectedIndex(0);
		
		JLabel lblCorreo = new JLabel("Correo (*)");
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCorreo.setBounds(482, 105, 108, 25);
		add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Arial", Font.PLAIN, 17));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(605, 105, 150, 25);
		add(txtCorreo);
		
		JLabel lblContrasena = new JLabel("Contrasena");
		lblContrasena.setFont(new Font("Arial", Font.PLAIN, 20));
		lblContrasena.setBounds(482, 146, 108, 25);
		add(lblContrasena);
		
		txtContrasena = new JTextField();
		txtContrasena.setFont(new Font("Arial", Font.PLAIN, 17));
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(605, 146, 150, 25);
		add(txtContrasena);
		for (int i = 0; i < tipos.size(); i++) {
			cbxTipo.addItem(tipos.get(i)[1]);
		}
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

	public JComboBox getCbxCarrera() {
		return cbxCarrera;
	}

	public void setCbxCarrera(JComboBox cbxCarrera) {
		this.cbxCarrera = cbxCarrera;
	}

	public JComboBox getCbxTipo() {
		return cbxTipo;
	}

	public void setCbxTipo(JComboBox cbxTipo) {
		this.cbxTipo = cbxTipo;
	}

	public JTextField getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public JTextField getTxtContrasena() {
		return txtContrasena;
	}

	public void setTxtContrasena(JTextField txtContrasena) {
		this.txtContrasena = txtContrasena;
	}
	
	
}
