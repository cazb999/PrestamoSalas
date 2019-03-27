package interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import controller.Estadisticas_Controller;

public class Reporte_Estadistica extends JFrame implements ActionListener{

	private JPanel contentPane;
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
		lblEstadisticas.setBounds(15, 141, 171, 34);
		contentPane.add(lblEstadisticas);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 248, 365, 180);
		getContentPane().add(scrollPane);
		
		Estadisticas_Controller est_1 = new Estadisticas_Controller();
		JList list = new JList();
		list.setForeground(Color.DARK_GRAY);
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Arial", Font.PLAIN, 14));
		est_1.salasMasConsultadas(list);
		
		JLabel lblSalasMsConsultadas = new JLabel("Salas m\u00E1s consultadas");
		lblSalasMsConsultadas.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSalasMsConsultadas.setBounds(28, 214, 362, 34);
		contentPane.add(lblSalasMsConsultadas);
		
		JLabel lblUsuariosMsRecurrentes = new JLabel("Usuarios m\u00E1s recurrentes");
		lblUsuariosMsRecurrentes.setFont(new Font("Arial", Font.PLAIN, 20));
		lblUsuariosMsRecurrentes.setBounds(518, 214, 362, 34);
		contentPane.add(lblUsuariosMsRecurrentes);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(515, 248, 365, 180);
		contentPane.add(scrollPane_1);
		
		Estadisticas_Controller est_2 = new Estadisticas_Controller();
		JList list_1 = new JList();
		list_1.setForeground(Color.DARK_GRAY);
		scrollPane_1.setViewportView(list_1);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setFont(new Font("Arial", Font.PLAIN, 14));
		est_2.usuariosMasRecurrentes(list_1);
		
		btnRegresar.addActionListener(this);
		btnSalir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnRegresar) {
			MenuAdmin ma = new MenuAdmin();
			ma.setVisible(true);
			ma.setLocationRelativeTo(null);
			ma.setResizable(false);
			this.dispose();
		}
		
		if(e.getSource() == btnSalir) {
			this.dispose();
		}
		
	}
}
