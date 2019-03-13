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
	private JButton btnDevolverSalaProfe;
	private JButton btnSalir;
	private JButton btnDevolverEquipo;
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
		
		
		JLabel lblBanner = new JLabel("");
		lblBanner.setBounds(0, 0, 782, 125);
		ImageIcon imagen = new ImageIcon("C:\\Users\\Carlos\\Desktop\\U\\GOS\\src\\images\\banner.PNG");
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(), Image.SCALE_DEFAULT));
		contentPane.setLayout(null);
		lblBanner.setIcon(imagen);
		contentPane.add(lblBanner);
		
		btnPrestarSalaProfe = new JButton("Prestar Sala");
		btnPrestarSalaProfe.setBounds(500, 227, 150, 35);
		btnPrestarSalaProfe.setBackground(Color.BLACK);
		btnPrestarSalaProfe.setForeground(Color.WHITE);
		btnPrestarSalaProfe.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(btnPrestarSalaProfe);
		
		btnDevolverSalaProfe = new JButton("Devolver Sala");
		btnDevolverSalaProfe.setBounds(500, 303, 150, 35);
		btnDevolverSalaProfe.setForeground(Color.WHITE);
		btnDevolverSalaProfe.setBackground(Color.BLACK);
		btnDevolverSalaProfe.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(btnDevolverSalaProfe);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(346, 394, 100, 30);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.GRAY);
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 15));
		contentPane.add(btnSalir);
		
		btnDevolverEquipo = new JButton("Devolver Equipo");
		btnDevolverEquipo.setBounds(148, 303, 150, 35);
		btnDevolverEquipo.setForeground(Color.WHITE);
		btnDevolverEquipo.setFont(new Font("Arial", Font.PLAIN, 15));
		btnDevolverEquipo.setBackground(Color.BLACK);
		contentPane.add(btnDevolverEquipo);
		
		btnPrestarEquipo = new JButton("Prestar Equipo");
		btnPrestarEquipo.setBounds(148, 227, 150, 35);
		btnPrestarEquipo.setForeground(Color.WHITE);
		btnPrestarEquipo.setFont(new Font("Arial", Font.PLAIN, 15));
		btnPrestarEquipo.setBackground(Color.BLACK);
		contentPane.add(btnPrestarEquipo);
		
		lblGestionDePrestamos = new JLabel("Gestion de prestamos de equipo y salas");
		lblGestionDePrestamos.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDePrestamos.setBounds(10, 147, 760, 34);
		lblGestionDePrestamos.setFont(new Font("Arial", Font.PLAIN, 30));
		contentPane.add(lblGestionDePrestamos);
		
		btnDevolverEquipo.addActionListener(this);
		btnDevolverSalaProfe.addActionListener(this);
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
		
		if(btnSalir == e.getSource()) {
			this.dispose();
		}
		
	}
}
