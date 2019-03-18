package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.PrestamoEquipo_Controller;
import controller.PrestamoSala_Controller;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;

public class PrestarSala extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JButton btnBuscarUsuario;
	private JLabel lblNombre;
	private JLabel lblCarrera;
	private JLabel lblApellido;
	private JLabel lblCorreo;
	private JLabel lblTipo;
	private JTable tableHorarios;
	private JButton btnPrestar;
	private JButton btnCancelar;
	private JComboBox cbxSalas;
	private JCalendar dateDia;
	private JButton btnDisponibilidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrestarSala frame = new PrestarSala();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrestarSala() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 850);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBanner = new JLabel("");
		ImageIcon imagen = new ImageIcon("C:\\Users\\Carlos\\Desktop\\U\\GOS\\src\\images\\banner.PNG");
		lblBanner.setBounds(0, 0, 933, 125);
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(), Image.SCALE_DEFAULT));
		contentPane.setLayout(null);
		lblBanner.setIcon(imagen);
		contentPane.add(lblBanner);
		
		JLabel lblSeleccionarUsuario = new JLabel("Buscar Usuario");
		lblSeleccionarUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSeleccionarUsuario.setBounds(58, 138, 186, 31);
		contentPane.add(lblSeleccionarUsuario);
		
		JLabel lblSeleccionarEquipo = new JLabel("Seleccionar Sala");
		lblSeleccionarEquipo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSeleccionarEquipo.setBounds(519, 138, 186, 31);
		contentPane.add(lblSeleccionarEquipo);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		txtUsuario.setBounds(85, 193, 151, 31);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 15));
		lblCodigo.setBounds(30, 202, 56, 16);
		contentPane.add(lblCodigo);
		
		btnBuscarUsuario = new JButton("Buscar");
		btnBuscarUsuario.setForeground(Color.WHITE);
		btnBuscarUsuario.setBackground(Color.DARK_GRAY);
		btnBuscarUsuario.setFont(new Font("Arial", Font.BOLD, 15));
		btnBuscarUsuario.setBounds(248, 193, 97, 30);
		contentPane.add(btnBuscarUsuario);
		
		JLabel lbl1 = new JLabel("Nombre:");
		lbl1.setBounds(30, 250, 56, 16);
		contentPane.add(lbl1);
		
		JLabel lbl2 = new JLabel("Apellido:");
		lbl2.setBounds(198, 250, 56, 16);
		contentPane.add(lbl2);
		
		JLabel lbl3 = new JLabel("Carrera:");
		lbl3.setBounds(30, 298, 56, 16);
		contentPane.add(lbl3);
		
		JLabel lbl4 = new JLabel("Correo:");
		lbl4.setBounds(198, 298, 56, 16);
		contentPane.add(lbl4);
		
		JLabel lblTipoUsuario = new JLabel("Tipo usuario:");
		lblTipoUsuario.setBounds(30, 346, 84, 16);
		contentPane.add(lblTipoUsuario);
		
		lblNombre = new JLabel("");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(85, 250, 101, 16);
		contentPane.add(lblNombre);
		
		lblCarrera = new JLabel("");
		lblCarrera.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCarrera.setBounds(85, 298, 101, 16);
		contentPane.add(lblCarrera);
		
		lblApellido = new JLabel("");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellido.setBounds(253, 250, 101, 16);
		contentPane.add(lblApellido);
		
		lblCorreo = new JLabel("");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCorreo.setBounds(253, 298, 101, 16);
		contentPane.add(lblCorreo);
		
		lblTipo = new JLabel("");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipo.setBounds(126, 346, 101, 16);
		contentPane.add(lblTipo);
		
		JLabel lblSalasDisponibles = new JLabel("Salas");
		lblSalasDisponibles.setFont(new Font("Arial", Font.BOLD, 15));
		lblSalasDisponibles.setBounds(421, 198, 56, 25);
		contentPane.add(lblSalasDisponibles);
		
		cbxSalas = new JComboBox();
		cbxSalas.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una sala"}));
		cbxSalas.setSelectedIndex(0);
		cbxSalas.setBounds(573, 198, 202, 25);
		cbxSalas.setEnabled(false);
		getContentPane().add(cbxSalas);
		
		JLabel lblSeleccioneElEquipo = new JLabel("Seleccione el d\u00EDa");
		lblSeleccioneElEquipo.setFont(new Font("Arial", Font.BOLD, 15));
		lblSeleccioneElEquipo.setBounds(421, 265, 158, 25);
		contentPane.add(lblSeleccioneElEquipo);
		
		btnPrestar = new JButton("Prestar");
		btnPrestar.setForeground(Color.WHITE);
		btnPrestar.setFont(new Font("Arial", Font.BOLD, 15));
		btnPrestar.setBackground(Color.DARK_GRAY);
		btnPrestar.setBounds(693, 748, 97, 30);
		contentPane.add(btnPrestar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 15));
		btnCancelar.setBackground(Color.DARK_GRAY);
		btnCancelar.setBounds(584, 748, 97, 30);
		contentPane.add(btnCancelar);
		
		Object[][] data = {
			{"7 - 8", null, null, null, null, null, null},
			{"8 - 9", null, null, null, null, null, null},
			{"9 - 10", null, null, null, null, null, null},
			{"10 - 11", null, null, null, null, null, null},
			{"11 - 12", null, null, null, null, null, null},
			{"12 - 13", null, null, null, null, null, null},
			{"13 - 14", null, null, null, null, null, null},
			{"14 - 15", null, null, null, null, null, null},
			{"15 - 16", null, null, null, null, null, null},
			{"16 - 17", null, null, null, null, null, null},
			{"17 - 18", null, null, null, null, null, null},
			{"18 - 19", null, null, null, null, null, null},
			{"19 - 20", null, null, null, null, null, null},
			{"20 - 21", null, null, null, null, null, null},
			{"21 - 22", null, null, null, null, null, null},
		};
		String[] columnas = {"Hora", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
		DefaultTableModel dtm= new DefaultTableModel(data, columnas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 464, 880, 271);
		contentPane.add(scrollPane);
		tableHorarios = new JTable(dtm);
		scrollPane.setViewportView(tableHorarios);
		tableHorarios.setCellSelectionEnabled(true);
		
		dateDia = new JCalendar();
		dateDia.setBounds(573, 250, 202, 155);
		dateDia.setEnabled(false);
		contentPane.add(dateDia);
		
		btnDisponibilidad = new JButton("Buscar Disponibilidad");
		btnDisponibilidad.setForeground(Color.WHITE);
		btnDisponibilidad.setFont(new Font("Arial", Font.BOLD, 15));
		btnDisponibilidad.setBackground(Color.DARK_GRAY);
		btnDisponibilidad.setBounds(573, 421, 202, 30);
		btnDisponibilidad.setEnabled(false);
		contentPane.add(btnDisponibilidad);
		
		btnBuscarUsuario.addActionListener(new PrestamoSala_Controller(this));
		btnCancelar.addActionListener(new PrestamoSala_Controller(this));
		btnPrestar.addActionListener(new PrestamoSala_Controller(this));
		btnDisponibilidad.addActionListener(new PrestamoSala_Controller(this));
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JButton getBtnBuscarUsuario() {
		return btnBuscarUsuario;
	}

	public void setBtnBuscarUsuario(JButton btnBuscarUsuario) {
		this.btnBuscarUsuario = btnBuscarUsuario;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblCarrera() {
		return lblCarrera;
	}

	public void setLblCarrera(JLabel lblCarrera) {
		this.lblCarrera = lblCarrera;
	}

	public JLabel getLblApellido() {
		return lblApellido;
	}

	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	public JLabel getLblCorreo() {
		return lblCorreo;
	}

	public void setLblCorreo(JLabel lblCorreo) {
		this.lblCorreo = lblCorreo;
	}

	public JLabel getLblTipo() {
		return lblTipo;
	}

	public void setLblTipo(JLabel lblTipo) {
		this.lblTipo = lblTipo;
	}

	public JTable getTableHorarios() {
		return tableHorarios;
	}

	public void setTableHorarios(JTable tableHorarios) {
		this.tableHorarios = tableHorarios;
	}

	public JComboBox getCbxSalas() {
		return cbxSalas;
	}

	public void setCbxSalas(JComboBox cbxSalas) {
		this.cbxSalas = cbxSalas;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JCalendar getDateDia() {
		return dateDia;
	}

	public void setDateDia(JCalendar dateDia) {
		this.dateDia = dateDia;
	}

	public JButton getBtnPrestar() {
		return btnPrestar;
	}

	public void setBtnPrestar(JButton btnPrestar) {
		this.btnPrestar = btnPrestar;
	}

	public JButton getBtnDisponibilidad() {
		return btnDisponibilidad;
	}

	public void setBtnDisponibilidad(JButton btnDisponibilidad) {
		this.btnDisponibilidad = btnDisponibilidad;
	}
	
	
}
