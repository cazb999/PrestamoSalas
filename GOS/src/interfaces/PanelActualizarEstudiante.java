package interfaces;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ActualizarUsuario_Controller;
import logic.Carrera;
import logic.Tipo;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

public class PanelActualizarEstudiante extends JPanel {
	
	
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JButton btnActualizar;
	private JButton btnLimpiar;
	private JComboBox cbxCarrera;
	private JComboBox cbxTipo;
	private JTextField txtCorreo;
	private JTextField txtContrasena;
	private JTextField txtBuscarCodigo;
	private JLabel lblCdigo;
	private JButton btnBuscar;
	/**
	 * Create the panel.
	 */
	public PanelActualizarEstudiante() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblFormularioRegistroEstudiantes = new JLabel("Formulario Actualizar Usuario");
		lblFormularioRegistroEstudiantes.setFont(new Font("Arial", Font.PLAIN, 30));
		lblFormularioRegistroEstudiantes.setBounds(257, 13, 430, 35);
		add(lblFormularioRegistroEstudiantes);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo (*)");
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCodigo.setBounds(166, 120, 101, 25);
		add(lblCodigo);
		
		JLabel lblNombe = new JLabel("Nombre (*)");
		lblNombe.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNombe.setBounds(166, 161, 101, 25);
		add(lblNombe);
		
		JLabel lblCarrera = new JLabel("Carrera");
		lblCarrera.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCarrera.setBounds(482, 243, 70, 25);
		add(lblCarrera);
		
		JLabel lblTipo = new JLabel("Tipo (*)");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTipo.setBounds(166, 202, 70, 25);
		add(lblTipo);
		
		JLabel lblApellido = new JLabel("Apellido (*)");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 20));
		lblApellido.setBounds(482, 120, 108, 25);
		add(lblApellido);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Arial", Font.PLAIN, 17));
		txtCodigo.setBounds(282, 120, 150, 25);
		add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 17));
		txtNombre.setColumns(10);
		txtNombre.setBounds(282, 161, 150, 25);
		add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Arial", Font.PLAIN, 17));
		txtApellido.setColumns(10);
		txtApellido.setBounds(605, 120, 150, 25);
		add(txtApellido);
		
		cbxCarrera = new JComboBox();
		cbxCarrera.setBounds(605, 243, 150, 25);
		add(cbxCarrera);
		
		cbxTipo = new JComboBox();
		cbxTipo.setBounds(282, 203, 150, 25);
		add(cbxTipo);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(Color.BLACK);
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnActualizar.setBounds(360, 284, 100, 30);
		add(btnActualizar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(Color.BLACK);
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLimpiar.setBounds(508, 284, 100, 30);
		add(btnLimpiar);
		
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
		for (int i = 0; i < tipos.size(); i++) {
			cbxTipo.addItem(tipos.get(i)[1]);
		}
		
		JLabel lblCorreo = new JLabel("Correo (*)");
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCorreo.setBounds(482, 161, 108, 25);
		add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Arial", Font.PLAIN, 17));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(605, 161, 210, 25);
		add(txtCorreo);
		
		JLabel lblContrasena = new JLabel("Contrasena");
		lblContrasena.setFont(new Font("Arial", Font.PLAIN, 20));
		lblContrasena.setBounds(482, 202, 108, 25);
		add(lblContrasena);
		
		txtContrasena = new JTextField();
		txtContrasena.setFont(new Font("Arial", Font.PLAIN, 17));
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(605, 202, 150, 25);
		add(txtContrasena);
		
		txtBuscarCodigo = new JTextField();
		txtBuscarCodigo.setFont(new Font("Arial", Font.PLAIN, 17));
		txtBuscarCodigo.setColumns(10);
		txtBuscarCodigo.setBounds(383, 64, 150, 25);
		add(txtBuscarCodigo);
		
		lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCdigo.setBounds(267, 64, 101, 25);
		add(lblCdigo);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscar.setBackground(Color.BLACK);
		btnBuscar.setBounds(561, 63, 100, 30);
		add(btnBuscar);
		
		btnActualizar.addActionListener(new ActualizarUsuario_Controller(this));
		btnBuscar.addActionListener(new ActualizarUsuario_Controller(this));
		btnLimpiar.addActionListener(new ActualizarUsuario_Controller(this));
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
	public JButton getBtnActualizar() {
		return btnActualizar;
	}
	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
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
	public JTextField getTxtBuscarCodigo() {
		return txtBuscarCodigo;
	}
	public void setTxtBuscarCodigo(JTextField txtBuscarCodigo) {
		this.txtBuscarCodigo = txtBuscarCodigo;
	}
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}
	
	
}
