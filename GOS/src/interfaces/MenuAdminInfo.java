package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuAdminInfo extends JFrame {

	private JPanel contentPane;
	
	private JButton btnVerEstadisticas;
	private JButton btnVerHorario;
	private JButton btnSalir;
	private JButton btnRegresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdminInfo frame = new MenuAdminInfo();
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
	public MenuAdminInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 415);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblBanner = new JLabel("");
		ImageIcon imagen = new ImageIcon("C:\\Users\\GTX10504GB\\Documents\\Proyectos Eclipse\\GOS\\src\\images\\banner.PNG");
		lblBanner.setBounds(0, 0, 782, 125);
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(), Image.SCALE_DEFAULT));
		lblBanner.setIcon(imagen);
		contentPane.add(lblBanner);
		
		JLabel lblEstadisticas = new JLabel("Estad\u00EDsticas");
		lblEstadisticas.setFont(new Font("Arial", Font.PLAIN, 30));
		lblEstadisticas.setBounds(100, 147, 171, 34);
		contentPane.add(lblEstadisticas);
		
		JLabel lblHorario = new JLabel("Horario Salas");
		lblHorario.setFont(new Font("Arial", Font.PLAIN, 30));
		lblHorario.setBounds(512, 147, 200, 34);
		contentPane.add(lblHorario);
		
		btnVerEstadisticas = new JButton("Ver Estad\u00EDsticas");
		btnVerEstadisticas.setForeground(Color.WHITE);
		btnVerEstadisticas.setBackground(Color.BLACK);
		btnVerEstadisticas.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVerEstadisticas.setBounds(105, 227, 150, 40);
		contentPane.add(btnVerEstadisticas);
		
		btnVerHorario = new JButton("Ver Horarios");
		btnVerHorario.setBackground(Color.BLACK);
		btnVerHorario.setForeground(Color.WHITE);
		btnVerHorario.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVerHorario.setBounds(526, 227, 150, 40);
		contentPane.add(btnVerHorario);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.GRAY);
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSalir.setBounds(389, 325, 100, 30);
		contentPane.add(btnSalir);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegresar.setBackground(Color.GRAY);
		btnRegresar.setBounds(285, 325, 100, 30);
		contentPane.add(btnRegresar);
	}

}
