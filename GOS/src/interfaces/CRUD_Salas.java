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

public class CRUD_Salas extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnCrearSala;
	private JButton btnRegresar;
	private JPanel panel;
	private JButton btnEliminarSala;
	private JButton btnListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUD_Salas frame = new CRUD_Salas();
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
	public CRUD_Salas() {
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
		
		btnCrearSala = new JButton("Crear Sala");
		btnCrearSala.setForeground(Color.WHITE);
		btnCrearSala.setBackground(Color.GRAY);
		btnCrearSala.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCrearSala.setBounds(40, 140, 170, 30);
		contentPane.add(btnCrearSala);
		
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
		
		btnEliminarSala = new JButton("Eliminar Sala");
		btnEliminarSala.setForeground(Color.WHITE);
		btnEliminarSala.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEliminarSala.setBackground(Color.GRAY);
		btnEliminarSala.setBounds(225, 141, 170, 30);
		contentPane.add(btnEliminarSala);
		
		btnListar = new JButton("Listar Salas");
		btnListar.setForeground(Color.WHITE);
		btnListar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnListar.setBackground(Color.GRAY);
		btnListar.setBounds(410, 140, 170, 30);
		contentPane.add(btnListar);
		
		btnCrearSala.addActionListener(this);
		btnEliminarSala.addActionListener(this);
		btnRegresar.addActionListener(this);
		btnListar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnCrearSala) {
			PanelCrearSala pcs = new PanelCrearSala();
			pcs.setSize(930, 280);
			pcs.setLocation(0, 0);
			
			panel.removeAll();
			panel.add(pcs);
			panel.revalidate();
			panel.repaint();
		}
		
		if(e.getSource() == btnEliminarSala) {
			PanelEliminarSala pes = new PanelEliminarSala();
			pes.setSize(930, 280);
			pes.setLocation(0, 0);
			
			panel.removeAll();
			panel.add(pes);
			panel.revalidate();
			panel.repaint();
		}
		
		if(e.getSource() == btnListar) {
			PanelListarSala pls = new PanelListarSala();
			pls.setSize(930, 280);
			pls.setLocation(0, 0);
			
			panel.removeAll();
			panel.add(pls);
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
