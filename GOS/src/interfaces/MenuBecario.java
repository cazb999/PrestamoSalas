package interfaces;

import java.awt.BorderLayout;
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
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MenuBecario extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnPrestarSalaProfe;
	private JButton btnSalir;
	private JButton btnPrestarEquipo;
	private JLabel lblGestionDePrestamos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuBecario frame = new MenuBecario();
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
	public MenuBecario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Imagen i = new Imagen();
		JLabel lblBanner = new JLabel("");
		lblBanner.setBounds(0, 0, 782, 125);
		ImageIcon imagen = new ImageIcon(i.RUTA_IMAGEN);
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(), Image.SCALE_DEFAULT));
		contentPane.setLayout(null);
		lblBanner.setIcon(imagen);
		contentPane.add(lblBanner);
		
		btnPrestarSalaProfe = new JButton("Gestionar Salas");
		btnPrestarSalaProfe.setBounds(484, 236, 172, 59);
		btnPrestarSalaProfe.setBackground(Color.BLACK);
		btnPrestarSalaProfe.setForeground(Color.WHITE);
		btnPrestarSalaProfe.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(btnPrestarSalaProfe);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(346, 394, 100, 30);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.GRAY);
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(btnSalir);
		
		btnPrestarEquipo = new JButton("Gestionar Equipos");
		btnPrestarEquipo.setBounds(147, 236, 195, 59);
		btnPrestarEquipo.setForeground(Color.WHITE);
		btnPrestarEquipo.setFont(new Font("Arial", Font.PLAIN, 15));
		btnPrestarEquipo.setBackground(Color.BLACK);
		contentPane.add(btnPrestarEquipo);
		
		lblGestionDePrestamos = new JLabel("Gestion de prestamos de equipo y salas");
		lblGestionDePrestamos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDePrestamos.setBounds(10, 147, 760, 34);
		lblGestionDePrestamos.setFont(new Font("Arial", Font.PLAIN, 30));
		contentPane.add(lblGestionDePrestamos);
		btnPrestarEquipo.addActionListener(this);
		btnPrestarSalaProfe.addActionListener(this);
		btnSalir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(btnPrestarEquipo == e.getSource()) {
			PrestarEquipo pe = new PrestarEquipo();
			pe.setVisible(true);
        	pe.setLocationRelativeTo(null);
        	pe.setResizable(false);
        	this.dispose();
		}
		
		if(btnPrestarSalaProfe == e.getSource()) {
			PrestarSala ps = new PrestarSala();
			ps.setVisible(true);
        	ps.setLocationRelativeTo(null);
        	ps.setResizable(false);
        	this.dispose();
		}
		
		if(btnSalir == e.getSource()) {
			this.dispose();
		}
		
	}
}
