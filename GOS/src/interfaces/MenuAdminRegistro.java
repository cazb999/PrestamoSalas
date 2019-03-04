package interfaces;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class MenuAdminRegistro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdminRegistro frame = new MenuAdminRegistro();
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
	public MenuAdminRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBanner = new JLabel("");
		ImageIcon imagen = new ImageIcon("C:\\Users\\GTX10504GB\\Documents\\Proyectos Eclipse\\GOS\\src\\images\\banner.PNG");
		lblBanner.setBounds(0, 0, 782, 125);
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(), Image.SCALE_DEFAULT));
		contentPane.setLayout(null);
		lblBanner.setIcon(imagen);
		contentPane.add(lblBanner);
		
		JButton btnGestionarUsuario = new JButton("<html><p>Gestionar</p><p>Usuarios</p></html>");
		btnGestionarUsuario.setForeground(Color.WHITE);
		btnGestionarUsuario.setBackground(Color.BLACK);
		btnGestionarUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		btnGestionarUsuario.setBounds(72, 235, 170, 64);
		contentPane.add(btnGestionarUsuario);
		
		JButton btnGestionarSalas = new JButton("<html><p>Gestionar</p><p>Salas</p></html>");
		btnGestionarSalas.setForeground(Color.WHITE);
		btnGestionarSalas.setBackground(Color.BLACK);
		btnGestionarSalas.setFont(new Font("Arial", Font.PLAIN, 20));
		btnGestionarSalas.setBounds(315, 235, 170, 64);
		contentPane.add(btnGestionarSalas);
		
		JButton btnAsignacionSalas = new JButton("<html><p>Asignaci\u00F3n</p><p>Salas</p></html>");
		btnAsignacionSalas.setForeground(Color.WHITE);
		btnAsignacionSalas.setBackground(Color.BLACK);
		btnAsignacionSalas.setFont(new Font("Arial", Font.PLAIN, 20));
		btnAsignacionSalas.setBounds(557, 235, 170, 64);
		contentPane.add(btnAsignacionSalas);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setFont(new Font("Arial", Font.PLAIN, 30));
		lblUsuarios.setBounds(100, 160, 150, 35);
		contentPane.add(lblUsuarios);
		
		JLabel lblSalas = new JLabel("Salas");
		lblSalas.setFont(new Font("Arial", Font.PLAIN, 30));
		lblSalas.setBounds(350, 160, 100, 35);
		contentPane.add(lblSalas);
		
		JLabel lblAsignacin = new JLabel("Asignaci\u00F3n");
		lblAsignacin.setFont(new Font("Arial", Font.PLAIN, 30));
		lblAsignacin.setBounds(550, 160, 150, 35);
		contentPane.add(lblAsignacin);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setBackground(Color.DARK_GRAY);
		btnRegresar.setBounds(295, 360, 100, 30);
		contentPane.add(btnRegresar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.DARK_GRAY);
		btnSalir.setBounds(405, 360, 100, 30);
		contentPane.add(btnSalir);
	}
}
