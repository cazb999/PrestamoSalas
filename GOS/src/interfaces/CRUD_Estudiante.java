package interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class CRUD_Estudiante extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel panel;
	
	private JButton btnRegistrarEstudiante;
	private JButton btnActualizarEstudiante;
	private JButton btnEliminarEstudiante;
	private JButton btnBuscarEstudiante;
	private JButton btnRegresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUD_Estudiante frame = new CRUD_Estudiante();
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
	public CRUD_Estudiante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBanner = new JLabel("");
		ImageIcon imagen = new ImageIcon("C:\\Users\\Carlos\\Desktop\\U\\GOS\\src\\images\\banner.PNG");
		lblBanner.setBounds(0, 0, 982, 125);
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(), Image.SCALE_DEFAULT));
		lblBanner.setIcon(imagen);
		contentPane.add(lblBanner);
		
		btnRegistrarEstudiante = new JButton("Registrar Estudiante");
		btnRegistrarEstudiante.setForeground(Color.WHITE);
		btnRegistrarEstudiante.setBackground(Color.GRAY);
		btnRegistrarEstudiante.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegistrarEstudiante.setBounds(250, 140, 170, 30);
		contentPane.add(btnRegistrarEstudiante);
		
		btnActualizarEstudiante = new JButton("Actualizar Estudiante");
		btnActualizarEstudiante.setForeground(Color.WHITE);
		btnActualizarEstudiante.setBackground(Color.GRAY);
		btnActualizarEstudiante.setFont(new Font("Arial", Font.PLAIN, 15));
		btnActualizarEstudiante.setBounds(460, 140, 170, 30);
		contentPane.add(btnActualizarEstudiante);
		
		btnEliminarEstudiante = new JButton("Eliminar Estudiante");
		btnEliminarEstudiante.setForeground(Color.WHITE);
		btnEliminarEstudiante.setBackground(Color.GRAY);
		btnEliminarEstudiante.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEliminarEstudiante.setBounds(670, 140, 170, 30);
		contentPane.add(btnEliminarEstudiante);
		
		btnBuscarEstudiante = new JButton("Buscar Estudiante");
		btnBuscarEstudiante.setForeground(Color.WHITE);
		btnBuscarEstudiante.setBackground(Color.GRAY);
		btnBuscarEstudiante.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBuscarEstudiante.setBounds(40, 140, 170, 30);
		contentPane.add(btnBuscarEstudiante);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(25, 200, 930, 340);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setBackground(Color.DARK_GRAY);
		btnRegresar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegresar.setBounds(870, 140, 100, 30);
		contentPane.add(btnRegresar);
		
		btnBuscarEstudiante.addActionListener(this);
		btnRegistrarEstudiante.addActionListener(this);
		btnActualizarEstudiante.addActionListener(this);
		btnEliminarEstudiante.addActionListener(this);
		btnRegresar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnRegistrarEstudiante) {
			PanelRegistrarUsuario pru = new PanelRegistrarUsuario();
			pru.setSize(930, 340);
			pru.setLocation(0, 0);
			
			panel.removeAll();
			panel.add(pru);
			panel.revalidate();
			panel.repaint();
		}
		
		if(e.getSource() == btnBuscarEstudiante) {
			PanelBuscarUsuario pbu = new PanelBuscarUsuario();
			pbu.setSize(930, 340);
			pbu.setLocation(0, 0);
			
			panel.removeAll();
			panel.add(pbu);
			panel.revalidate();
			panel.repaint();
		}
		
		if(e.getSource() == btnActualizarEstudiante) {
			PanelActualizarEstudiante pau = new PanelActualizarEstudiante();
			pau.setSize(930, 340);
			pau.setLocation(0, 0);
			
			panel.removeAll();
			panel.add(pau);
			panel.revalidate();
			panel.repaint();
		}
		
		if(e.getSource() == btnEliminarEstudiante) {
			PanelEliminarEstudiante peu = new PanelEliminarEstudiante();
			peu.setSize(930, 340);
			peu.setLocation(0, 0);
			
			panel.removeAll();
			panel.add(peu);
			panel.revalidate();
			panel.repaint();
		}
		
	}
}
