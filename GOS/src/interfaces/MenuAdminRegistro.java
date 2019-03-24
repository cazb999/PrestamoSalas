package interfaces;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class MenuAdminRegistro extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	private JButton btnSalir;
	private JButton btnRegresar;
	private JButton btnGestionarCarreras;
	private JButton btnGestionarSalas;
	private JButton btnGestionarUsuario;
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
		
		Imagen i = new Imagen();
		JLabel lblBanner = new JLabel("");
		ImageIcon imagen = new ImageIcon(i.RUTA_IMAGEN);
		lblBanner.setBounds(0, 0, 782, 125);
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(), Image.SCALE_DEFAULT));
		contentPane.setLayout(null);
		lblBanner.setIcon(imagen);
		contentPane.add(lblBanner);
		
		btnGestionarUsuario = new JButton("<html><p>Gestionar</p><p>Usuarios</p></html>");
		btnGestionarUsuario.setForeground(Color.WHITE);
		btnGestionarUsuario.setBackground(Color.BLACK);
		btnGestionarUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		btnGestionarUsuario.setBounds(72, 235, 170, 64);
		contentPane.add(btnGestionarUsuario);
		
		btnGestionarSalas = new JButton("<html><p>Gestionar</p><p>Salas</p></html>");
		btnGestionarSalas.setForeground(Color.WHITE);
		btnGestionarSalas.setBackground(Color.BLACK);
		btnGestionarSalas.setFont(new Font("Arial", Font.PLAIN, 20));
		btnGestionarSalas.setBounds(315, 235, 170, 64);
		contentPane.add(btnGestionarSalas);
		
		btnGestionarCarreras = new JButton("<html><p>Gestionar</p><p>Carreras</p></html>");
		btnGestionarCarreras.setForeground(Color.WHITE);
		btnGestionarCarreras.setBackground(Color.BLACK);
		btnGestionarCarreras.setFont(new Font("Arial", Font.PLAIN, 20));
		btnGestionarCarreras.setBounds(557, 235, 170, 64);
		contentPane.add(btnGestionarCarreras);
		
		JLabel lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setFont(new Font("Arial", Font.PLAIN, 30));
		lblUsuarios.setBounds(72, 160, 170, 35);
		contentPane.add(lblUsuarios);
		
		JLabel lblSalas = new JLabel("Salas");
		lblSalas.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalas.setFont(new Font("Arial", Font.PLAIN, 30));
		lblSalas.setBounds(315, 160, 170, 35);
		contentPane.add(lblSalas);
		
		JLabel lblAsignacin = new JLabel("Carreras");
		lblAsignacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAsignacin.setFont(new Font("Arial", Font.PLAIN, 30));
		lblAsignacin.setBounds(557, 160, 170, 35);
		contentPane.add(lblAsignacin);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setBackground(Color.DARK_GRAY);
		btnRegresar.setBounds(295, 360, 100, 30);
		contentPane.add(btnRegresar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.DARK_GRAY);
		btnSalir.setBounds(405, 360, 100, 30);
		contentPane.add(btnSalir);
		
		btnGestionarSalas.addActionListener(this);
		btnGestionarUsuario.addActionListener(this);
		btnGestionarCarreras.addActionListener(this);
		btnRegresar.addActionListener(this);
		btnSalir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnSalir) {
			this.dispose();
		}
		
		if(e.getSource() == btnRegresar) {
			MenuAdmin ma = new MenuAdmin();
			ma.setVisible(true);
			ma.setLocationRelativeTo(null);
			ma.setResizable(false);
			this.dispose();
		}
		
		if(e.getSource() == btnGestionarUsuario) {
			CRUD_Usuario cu = new CRUD_Usuario();
			cu.setVisible(true);
			cu.setLocationRelativeTo(null);
			cu.setResizable(false);
			this.dispose();
		}
		
		if(e.getSource() == btnGestionarSalas) {
			CRUD_Salas cs = new CRUD_Salas();
			cs.setVisible(true);
			cs.setLocationRelativeTo(null);
			cs.setResizable(false);
			this.dispose();
		}
		
		if(e.getSource() == btnGestionarCarreras) {
			CRUD_Carreras cc = new CRUD_Carreras();
			cc.setVisible(true);
			cc.setLocationRelativeTo(null);
			cc.setResizable(false);
			this.dispose();
		}
		
	}
}
