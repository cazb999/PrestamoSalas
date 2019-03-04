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
import javax.swing.JButton;
import java.awt.Font;

public class MenuAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdmin frame = new MenuAdmin();
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
	public MenuAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
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
		
		JButton btnPrestamo = new JButton("");
		btnPrestamo.setForeground(Color.WHITE);
		btnPrestamo.setBackground(Color.BLACK);
		btnPrestamo.setText("<html><p>Funciones de</p><p>Prestamos de Salas</p></html>");
		btnPrestamo.setFont(new Font("Arial", Font.PLAIN, 20));
		btnPrestamo.setBounds(12, 170, 230, 80);
		contentPane.add(btnPrestamo);
		
		JButton btnRegistroAsignacion = new JButton("");
		btnRegistroAsignacion.setForeground(Color.WHITE);
		btnRegistroAsignacion.setBackground(Color.BLACK);
		btnRegistroAsignacion.setFont(new Font("Arial", Font.PLAIN, 20));
		btnRegistroAsignacion.setText("<html><p>Operaciones de Registro</p><p>y Asignaci\u00F3n</p></html>");
		btnRegistroAsignacion.setBounds(254, 170, 274, 80);
		contentPane.add(btnRegistroAsignacion);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.GRAY);
		btnSalir.setBounds(350, 310, 100, 30);
		contentPane.add(btnSalir);
		
		JButton btnHorarioEstadsticas = new JButton("<html><p>Horario y</p><p>Estad\u00EDsticas</p></html>");
		btnHorarioEstadsticas.setForeground(Color.WHITE);
		btnHorarioEstadsticas.setFont(new Font("Arial", Font.PLAIN, 20));
		btnHorarioEstadsticas.setBackground(Color.BLACK);
		btnHorarioEstadsticas.setBounds(540, 170, 230, 80);
		contentPane.add(btnHorarioEstadsticas);
	}

}
