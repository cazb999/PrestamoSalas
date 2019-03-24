package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.PanelBuscarUsuario;
import logic.Carrera;
import logic.Usuario;
import models.Modelo_Usuario;

public class BuscarUsuario_Controller implements ActionListener {

	private PanelBuscarUsuario panel;
	private Usuario usuario;
	private Carrera carrera;

	public BuscarUsuario_Controller(PanelBuscarUsuario panel) {
		this.panel = panel;
		this.usuario = new Usuario();
		this.carrera = new Carrera();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.panel.getBtnBuscar()) {

			if (!this.panel.getTxtBuscarEstudiante().getText().equals("")) {
				Modelo_Usuario user = this.usuario
						.obtenerUsuario(Integer.parseInt(this.panel.getTxtBuscarEstudiante().getText()));
				if (user != null) {
					this.panel.getTxtApellido().setText(user.getAPELLIDOUSUARIO());
					this.panel.getTxtCodigo().setText("" + user.getCODIGOUSUARIO());
					this.panel.getTxtNombre().setText(user.getNOMBREUSUARIO());

					switch (user.getIDTIPO()) {
					case 1:
						this.panel.getTxtTipo().setText("Estudiante");
						break;
					case 2:
						this.panel.getTxtTipo().setText("Docente");
						break;
					case 3:
						this.panel.getTxtTipo().setText("Administrativo");
						break;
					case 4:
						this.panel.getTxtTipo().setText("Becario");
						break;
					case 5:
						this.panel.getTxtTipo().setText("Administrador");
						break;
					default:
						break;
					}

					if (user.getIDCARRERA() != 0) {
						ArrayList<String[]> carreras = carrera.obtenerCarreras();
						for (int i = 0; i < carreras.size(); i++) {
							if (Integer.parseInt(carreras.get(i)[0]) == user.getIDCARRERA()) {
								this.panel.getTxtCarrera().setText(carreras.get(i)[1]);
							}
						}
					} else {
						this.panel.getTxtCarrera().setText("No Aplica");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Este usuario no existe!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Por favor, ingrese un código para buscar");
			}
		}

		if (e.getSource() == this.panel.getBtnLimpiar()) {
			this.panel.getTxtApellido().setText("");
			this.panel.getTxtBuscarEstudiante().setText("");
			this.panel.getTxtCarrera().setText("");
			this.panel.getTxtCodigo().setText("");
			this.panel.getTxtNombre().setText("");
			this.panel.getTxtTipo().setText("");
		}

	}
}
