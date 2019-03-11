package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Login_Controller;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JButton btnLogin;
	private JPasswordField txtContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBanner = new JLabel("");
		ImageIcon imagen = new ImageIcon("C:\\Users\\Carlos\\Desktop\\U\\GOS\\src\\images\\banner.PNG");
		lblBanner.setBounds(0, 0, 782, 125);
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(), Image.SCALE_DEFAULT));
		lblBanner.setIcon(imagen);
		contentPane.add(lblBanner);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Arial", Font.BOLD, 30));
		lblUsuario.setBounds(110, 166, 112, 35);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setFont(new Font("Arial", Font.BOLD, 30));
		lblContrasena.setBounds(110, 265, 172, 51);
		contentPane.add(lblContrasena);
		
		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Usuario");
		txtUsuario.setForeground(Color.BLACK);
		txtUsuario.setBackground(Color.LIGHT_GRAY);
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 25));
		txtUsuario.setBounds(460, 168, 200, 35);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(20);
		
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 25));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setBounds(325, 381, 150, 45);
		contentPane.add(btnLogin);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setColumns(20);
		txtContrasena.setBackground(Color.LIGHT_GRAY);
		txtContrasena.setFont(new Font("Arial", Font.PLAIN, 25));
		txtContrasena.setBounds(460, 275, 200, 35);
		contentPane.add(txtContrasena);
		
		btnLogin.addActionListener(new Login_Controller(this));
	}
	
	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JPasswordField getTxtContrasena() {
		return txtContrasena;
	}

	public void setTxtContrasena(JPasswordField txtContrasena) {
		this.txtContrasena = txtContrasena;
	}

	public JButton getBtnLogin() {
		return btnLogin;
	}

	public void setBtnLogin(JButton btnLogin) {
		this.btnLogin = btnLogin;
	}
	
	
}
