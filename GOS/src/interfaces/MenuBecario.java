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

public class MenuBecario extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	private JButton btnPrestarSalaEstudi;
	private JButton btnDevolverSalaEstudi;
	private JButton btnPrestarSalaProfe;
	private JButton btnDevolverSalaProfe;
	private JButton btnSalir;
	private JButton btnDevolverEquipo;
	private JButton btnPrestarEquipo;
	private JLabel label;

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
		contentPane.setLayout(null);
		
		
		JLabel lblBanner = new JLabel("");
		ImageIcon imagen = new ImageIcon("C:\\Users\\Carlos\\Desktop\\U\\GOS\\src\\images\\banner.PNG");
		lblBanner.setBounds(0, 0, 782, 125);
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(), Image.SCALE_DEFAULT));
		lblBanner.setIcon(imagen);
		contentPane.add(lblBanner);
		
		JLabel lblEstudiantes = new JLabel("Estudiantes");
		lblEstudiantes.setFont(new Font("Arial", Font.PLAIN, 30));
		lblEstudiantes.setBounds(306, 147, 171, 34);
		contentPane.add(lblEstudiantes);
		
		JLabel lblProfesores = new JLabel("Profesores");
		lblProfesores.setFont(new Font("Arial", Font.PLAIN, 30));
		lblProfesores.setBounds(540, 147, 142, 34);
		contentPane.add(lblProfesores);
		
		btnPrestarSalaEstudi = new JButton("Prestar Sala");
		btnPrestarSalaEstudi.setForeground(Color.WHITE);
		btnPrestarSalaEstudi.setBackground(Color.BLACK);
		btnPrestarSalaEstudi.setFont(new Font("Arial", Font.PLAIN, 15));
		btnPrestarSalaEstudi.setBounds(306, 227, 150, 35);
		contentPane.add(btnPrestarSalaEstudi);
		
		btnDevolverSalaEstudi = new JButton("Devolver Sala");
		btnDevolverSalaEstudi.setBackground(Color.BLACK);
		btnDevolverSalaEstudi.setForeground(Color.WHITE);
		btnDevolverSalaEstudi.setFont(new Font("Arial", Font.PLAIN, 15));
		btnDevolverSalaEstudi.setBounds(306, 303, 150, 35);
		contentPane.add(btnDevolverSalaEstudi);
		
		btnPrestarSalaProfe = new JButton("Prestar Sala");
		btnPrestarSalaProfe.setBackground(Color.BLACK);
		btnPrestarSalaProfe.setForeground(Color.WHITE);
		btnPrestarSalaProfe.setFont(new Font("Arial", Font.PLAIN, 15));
		btnPrestarSalaProfe.setBounds(540, 227, 150, 35);
		contentPane.add(btnPrestarSalaProfe);
		
		btnDevolverSalaProfe = new JButton("Devolver Sala");
		btnDevolverSalaProfe.setForeground(Color.WHITE);
		btnDevolverSalaProfe.setBackground(Color.BLACK);
		btnDevolverSalaProfe.setFont(new Font("Arial", Font.PLAIN, 15));
		btnDevolverSalaProfe.setBounds(540, 303, 150, 35);
		contentPane.add(btnDevolverSalaProfe);
		
		btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.GRAY);
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 15));
		btnSalir.setBounds(350, 410, 100, 30);
		contentPane.add(btnSalir);
		
		btnDevolverEquipo = new JButton("Devolver Equipo");
		btnDevolverEquipo.setForeground(Color.WHITE);
		btnDevolverEquipo.setFont(new Font("Arial", Font.PLAIN, 15));
		btnDevolverEquipo.setBackground(Color.BLACK);
		btnDevolverEquipo.setBounds(70, 303, 150, 35);
		contentPane.add(btnDevolverEquipo);
		
		btnPrestarEquipo = new JButton("Prestar Equipo");
		btnPrestarEquipo.setForeground(Color.WHITE);
		btnPrestarEquipo.setFont(new Font("Arial", Font.PLAIN, 15));
		btnPrestarEquipo.setBackground(Color.BLACK);
		btnPrestarEquipo.setBounds(70, 227, 150, 35);
		contentPane.add(btnPrestarEquipo);
		
		label = new JLabel("Estudiantes");
		label.setFont(new Font("Arial", Font.PLAIN, 30));
		label.setBounds(70, 147, 171, 34);
		contentPane.add(label);
		
		btnDevolverEquipo.addActionListener(this);
		btnDevolverSalaEstudi.addActionListener(this);
		btnDevolverSalaProfe.addActionListener(this);
		btnPrestarEquipo.addActionListener(this);
		btnPrestarSalaEstudi.addActionListener(this);
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
		
	}
}
