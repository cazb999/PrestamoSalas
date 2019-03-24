package interfaces;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import controller.GestionCarreras_Controller;
import controller.ListarSalas_Controller;

public class PanelListarCarrera extends JPanel {
	
	private JList list;
	/**
	 * Create the panel.
	 */
	public PanelListarCarrera() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JLabel lblFormularioRegistroEstudiantes = new JLabel("Listado de carreras");
		lblFormularioRegistroEstudiantes.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormularioRegistroEstudiantes.setFont(new Font("Arial", Font.PLAIN, 30));
		lblFormularioRegistroEstudiantes.setBounds(15, 13, 900, 35);
		add(lblFormularioRegistroEstudiantes);
		
		GestionCarreras_Controller gc = new GestionCarreras_Controller();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 93, 607, 180);
		add(scrollPane);
		
		list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setEnabled(false);
		list.setFont(new Font("Arial", Font.BOLD, 20));
		scrollPane.setViewportView(list);
		gc.listar(list);
	}

}
