package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import interfaces.PanelCrearSala;
import logic.Equipo;
import logic.Sala;
import models.Modelo_Equipo;
import models.Modelo_Sala;

public class CrearSala_Controller implements ActionListener{
	
	PanelCrearSala panel;
	public CrearSala_Controller(PanelCrearSala panel) {
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(this.panel.getBtnRegistrar() == e.getSource()) {
			Sala sala = new Sala();
			if(!this.panel.getTxtNombreSala().getText().equals("") && !this.panel.getTxtNumeroComputadores().getText().equals("")) {
				if(!sala.salaExiste(this.panel.getTxtNombreSala().getText())) {
					if(sala.crearSala(new Modelo_Sala(0, this.panel.getTxtNombreSala().getText(), Integer.parseInt(this.panel.getTxtNumeroComputadores().getText())))) {
						
						Sala sala_new = new Sala();
						int pc = Integer.parseInt(this.panel.getTxtNumeroComputadores().getText());
						Modelo_Sala sala_aux = sala_new.obtenerSala(this.panel.getTxtNombreSala().getText());
						for (int i = 0; i < pc; i++) {
							Equipo equipo = new Equipo();
							equipo.crearEquipo(new Modelo_Equipo(0, "E0"+(i+1), sala_aux.getIDSALA()));
						}
						JOptionPane.showMessageDialog(null, "Sala creada correctamente!");
						this.panel.getTxtNombreSala().setText("");
						this.panel.getTxtNumeroComputadores().setText("");
						
					}else {
						JOptionPane.showMessageDialog(null, "Ocurrio un error a la hora de crear la sala!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Ya existe una sala con este nombre!");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Por favor, llene todos los campos!");
			}
		}
		
		if(e.getSource() == this.panel.getBtnLimpiar()) {
			this.panel.getTxtNombreSala().setText("");
			this.panel.getTxtNumeroComputadores().setText("");
		}
		
	}

}
