package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.PanelEliminarSala;
import logic.Equipo;
import logic.Sala;
import models.Modelo_Equipo;
import models.Modelo_Sala;

public class EliminarSala_Controller implements ActionListener{
	
	PanelEliminarSala panel;
	public EliminarSala_Controller(PanelEliminarSala panel) {
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.panel.getBtnBuscar()) {
			Sala sala = new Sala();
			if(!this.panel.getTxtBuscarSala().getText().equals("")) {
				if(sala.salaExiste(this.panel.getTxtBuscarSala().getText())) {
					Modelo_Sala modelo_sala = sala.obtenerSala(this.panel.getTxtBuscarSala().getText());
					this.panel.getTxtNombre().setText(modelo_sala.getNOMBRESALA());
					this.panel.getTxtNumeroComputadores().setText(modelo_sala.getCAPACIDADSALA()+"");
					this.panel.getBtnEliminar().setEnabled(true);
					this.panel.getBtnLimpiar().setEnabled(true);
					this.panel.getTxtBuscarSala().setEditable(false);
				}else {
					JOptionPane.showMessageDialog(null, "Esta sala no existe!");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Por favor, llene el campo para buscar!");
			}
		}
				
		if(e.getSource() == this.panel.getBtnEliminar()) {
			Sala sala = new Sala();
			if(!this.panel.getTxtBuscarSala().getText().equals("")) {
				if(sala.salaExiste(this.panel.getTxtBuscarSala().getText())) {
					Modelo_Sala modelo_sala = sala.obtenerSala(this.panel.getTxtBuscarSala().getText());
					Equipo equipo = new Equipo();
					ArrayList<Modelo_Equipo> equipos = equipo.obtenerEquipos(modelo_sala.getIDSALA());
					
					for (int i = 0; i < equipos.size(); i++) {
						Equipo eq = new Equipo();
						eq.eliminarEquipo(equipos.get(i).getNOMBREEQUIPO(), modelo_sala.getIDSALA());
					}
					
					Sala s = new Sala();
					if(s.eliminarSala(modelo_sala.getNOMBRESALA())) {
						this.panel.getTxtNombre().setText("");
						this.panel.getTxtNumeroComputadores().setText("");
						this.panel.getTxtBuscarSala().setText("");
						this.panel.getBtnEliminar().setEnabled(false);
						this.panel.getBtnLimpiar().setEnabled(false);
						this.panel.getTxtBuscarSala().setEditable(true);
						JOptionPane.showMessageDialog(null, "Sala eliminada correctamente");
					}else {
						JOptionPane.showMessageDialog(null, "Ocurrió un error al eliminar la sala");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Esta sala no existe!");
				}
			}else {
				JOptionPane.showMessageDialog(null, "Por favor, llene el campo para buscar!");
			}
		}
		
		if(e.getSource() == this.panel.getBtnLimpiar()) {
			this.panel.getTxtNombre().setText("");
			this.panel.getTxtNumeroComputadores().setText("");
			this.panel.getTxtBuscarSala().setText("");
			this.panel.getBtnEliminar().setEnabled(false);
			this.panel.getBtnLimpiar().setEnabled(false);
			this.panel.getTxtBuscarSala().setEditable(true);
		}
	}

}
