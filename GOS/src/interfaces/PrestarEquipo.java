package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PrestarEquipo extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JButton btnBuscarUsuario;
	private JLabel lblTipoUsuario;
	private JLabel lblNombre;
	private JLabel lblCarrera;
	private JLabel lblApellido;
	private JLabel lblCorreo;
	private JLabel lblTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrestarEquipo frame = new PrestarEquipo();
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
	public PrestarEquipo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBanner = new JLabel("");
		ImageIcon imagen = new ImageIcon("C:\\Users\\Carlos\\Desktop\\U\\GOS\\src\\images\\banner.PNG");
		lblBanner.setBounds(0, 0, 850, 125);
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(), Image.SCALE_DEFAULT));
		contentPane.setLayout(null);
		lblBanner.setIcon(imagen);
		contentPane.add(lblBanner);
		
		JLabel lblSeleccionarUsuario = new JLabel("Buscar Usuario");
		lblSeleccionarUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSeleccionarUsuario.setBounds(58, 138, 186, 31);
		contentPane.add(lblSeleccionarUsuario);
		
		JLabel lblSeleccionarEquipo = new JLabel("Seleccionar Equipo");
		lblSeleccionarEquipo.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSeleccionarEquipo.setBounds(519, 138, 186, 31);
		contentPane.add(lblSeleccionarEquipo);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		txtUsuario.setBounds(85, 193, 151, 31);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 15));
		lblCodigo.setBounds(30, 202, 56, 16);
		contentPane.add(lblCodigo);
		
		btnBuscarUsuario = new JButton("Buscar");
		btnBuscarUsuario.setFont(new Font("Arial", Font.BOLD, 15));
		btnBuscarUsuario.setBounds(242, 198, 97, 25);
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
		
		lblTipoUsuario = new JLabel("Tipo usuario:");
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
	}
}
