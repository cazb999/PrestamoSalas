package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import interfaces.PanelCrearCarrera;
import interfaces.PanelEliminarCarrera;
import logic.Carrera;
import logic.Sala;
import models.Modelo_Sala;

public class GestionCarreras_Controller implements ActionListener {

	PanelCrearCarrera panelCrear;
	PanelEliminarCarrera panelEliminar;

	public GestionCarreras_Controller(PanelCrearCarrera panelCrear) {
		this.panelCrear = panelCrear;
	}

	public GestionCarreras_Controller(PanelEliminarCarrera panelEliminar) {
		this.panelEliminar = panelEliminar;
	}
	
	public GestionCarreras_Controller() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (this.panelCrear != null) {
			if (this.panelCrear.getBtnRegistrar() == e.getSource()) {
				if (!this.panelCrear.getTxtNombreSala().getText().equals("")) {
					Carrera c = new Carrera();
					if (!c.carreraExiste(this.panelCrear.getTxtNombreSala().getText())) {
						if (c.crearCarrera(this.panelCrear.getTxtNombreSala().getText())) {
							JOptionPane.showMessageDialog(null, "Carrera registrada con exito!");
							this.panelCrear.getTxtNombreSala().setText("");
						} else {
							JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Esta carrera ya existe!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese una carrera para registrar!");
				}
			}

			if (e.getSource() == this.panelCrear.getBtnLimpiar()) {
				this.panelCrear.getTxtNombreSala().setText("");
			}
		}

		if (this.panelEliminar != null) {
			if (e.getSource() == this.panelEliminar.getBtnEliminar()) {
				if (!this.panelEliminar.getTxtNombreSala().getText().equals("")) {
					Carrera c = new Carrera();
					if (c.carreraExiste(this.panelEliminar.getTxtNombreSala().getText())) {
						if (c.eliminarCarrera(this.panelEliminar.getTxtNombreSala().getText())) {
							JOptionPane.showMessageDialog(null, "Carrera eliminada con exito!");
							this.panelEliminar.getTxtNombreSala().setText("");
						} else {
							JOptionPane.showMessageDialog(null, "Ocurrió un error al registrar!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Esta carrera no existe!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, ingrese una carrera para eliminar!");
				}
			}

			if (e.getSource() == this.panelEliminar.getBtnLimpiar()) {
				this.panelEliminar.getTxtNombreSala().setText("");
			}
		}

	}
	
	public void listar(JList lista) {
		Carrera carrera = new Carrera();
		ArrayList<String[]> carreras = carrera.obtenerCarreras();
		DefaultListModel modelo = new DefaultListModel();
		for(int i = 0; i < carreras.size(); i++){
		        modelo.addElement((i+1)+". Nombre de la carrera: "+carreras.get(i)[1]);
		}
		lista.setModel(modelo);
	}

}
