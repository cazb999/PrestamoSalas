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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CRUD_Carreras extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnCrearCarrera;
	private JButton btnRegresar;
	private JPanel panel;
	private JButton btnEliminarCarrera;
	private JButton btnListar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUD_Carreras frame = new CRUD_Carreras();
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
	public CRUD_Carreras() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 572);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Imagen i = new Imagen();
		JLabel lblBanner = new JLabel("");
		ImageIcon imagen = new ImageIcon(i.RUTA_IMAGEN);
		lblBanner.setBounds(0, 0, 982, 125);
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(), Image.SCALE_DEFAULT));
		lblBanner.setIcon(imagen);
		contentPane.add(lblBanner);
		
		btnCrearCarrera = new JButton("Crear Carrera");
		btnCrearCarrera.setForeground(Color.WHITE);
		btnCrearCarrera.setBackground(Color.GRAY);
		btnCrearCarrera.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCrearCarrera.setBounds(40, 140, 170, 30);
		contentPane.add(btnCrearCarrera);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(25, 200, 930, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInfo = new JLabel("Seleccione una operaci\u00F3n!");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setFont(new Font("Arial", Font.BOLD, 30));
		lblInfo.setBounds(15, 98, 900, 85);
		panel.add(lblInfo);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setForeground(Color.WHITE);
		btnRegresar.setBackground(Color.DARK_GRAY);
		btnRegresar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegresar.setBounds(855, 140, 100, 30);
		contentPane.add(btnRegresar);
		
		btnEliminarCarrera = new JButton("Eliminar Carrera");
		btnEliminarCarrera.setForeground(Color.WHITE);
		btnEliminarCarrera.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEliminarCarrera.setBackground(Color.GRAY);
		btnEliminarCarrera.setBounds(225, 141, 170, 30);
		contentPane.add(btnEliminarCarrera);
		
		btnListar = new JButton("Listar Carreras");
		btnListar.setForeground(Color.WHITE);
		btnListar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnListar.setBackground(Color.GRAY);
		btnListar.setBounds(410, 140, 170, 30);
		contentPane.add(btnListar);
		
		btnCrearCarrera.addActionListener(this);
		btnEliminarCarrera.addActionListener(this);
		btnListar.addActionListener(this);
		btnRegresar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnCrearCarrera) {
			PanelCrearCarrera pcc = new PanelCrearCarrera();
			pcc.setSize(930, 280);
			pcc.setLocation(0, 0);
			
			panel.removeAll();
			panel.add(pcc);
			panel.revalidate();
			panel.repaint();
		}
		
		if(e.getSource() == btnEliminarCarrera) {
			PanelEliminarCarrera pec = new PanelEliminarCarrera();
			pec.setSize(930, 280);
			pec.setLocation(0, 0);
			
			panel.removeAll();
			panel.add(pec);
			panel.revalidate();
			panel.repaint();
		}
		
		if(e.getSource() == btnListar) {
			PanelListarCarrera plc = new PanelListarCarrera();
			plc.setSize(930, 280);
			plc.setLocation(0, 0);
			
			panel.removeAll();
			panel.add(plc);
			panel.revalidate();
			panel.repaint();
		}
		
		if(e.getSource() == btnRegresar) {
			MenuAdminRegistro mar = new MenuAdminRegistro();
			mar.setVisible(true);
			mar.setLocationRelativeTo(null);
			mar.setResizable(false);
			this.dispose();
		}
		
	}

}
