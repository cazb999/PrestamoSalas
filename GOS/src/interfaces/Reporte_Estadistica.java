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

public class Reporte_Estadistica extends JFrame {

	private JPanel contentPane;
	
	private JButton btnVerEstadisticas;
	private JButton btnReportePrestamos;
	private JButton btnSalir;
	private JButton btnRegresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporte_Estadistica frame = new Reporte_Estadistica();
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
	public Reporte_Estadistica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Imagen i = new Imagen();
		JLabel lblBanner = new JLabel("");
		ImageIcon imagen = new ImageIcon(i.RUTA_IMAGEN);
		lblBanner.setBounds(0, 0, 908, 125);
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(), Image.SCALE_DEFAULT));
		lblBanner.setIcon(imagen);
		contentPane.add(lblBanner);
		
		JLabel lblEstadisticas = new JLabel("Estad\u00EDsticas");
		lblEstadisticas.setFont(new Font("Arial", Font.PLAIN, 30));
		lblEstadisticas.setBounds(35, 317, 171, 34);
		contentPane.add(lblEstadisticas);
		
		JLabel lblHorario = new JLabel("Reportes");
		lblHorario.setFont(new Font("Arial", Font.PLAIN, 30));
		lblHorario.setBounds(35, 141, 200, 34);
		contentPane.add(lblHorario);
		
		btnVerEstadisticas = new JButton("Ver Estad\u00EDsticas");
		btnVerEstadisticas.setForeground(Color.WHITE);
		btnVerEstadisticas.setBackground(Color.BLACK);
		btnVerEstadisticas.setFont(new Font("Arial", Font.PLAIN, 15));
		btnVerEstadisticas.setBounds(35, 367, 150, 40);
		contentPane.add(btnVerEstadisticas);
		
		btnReportePrestamos = new JButton("Reporte Prestamos Salas");
		btnReportePrestamos.setBackground(Color.BLACK);
		btnReportePrestamos.setForeground(Color.WHITE);
		btnReportePrestamos.setFont(new Font("Arial", Font.PLAIN, 15));
		btnReportePrestamos.setBounds(35, 191, 212, 40);
		contentPane.add(btnReportePrestamos);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.GRAY);
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSalir.setBounds(793, 498, 100, 30);
		contentPane.add(btnSalir);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegresar.setBackground(Color.GRAY);
		btnRegresar.setBounds(689, 498, 100, 30);
		contentPane.add(btnRegresar);
	}

}
