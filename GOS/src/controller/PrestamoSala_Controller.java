package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.PrestarSala;
import logic.Carrera;
import logic.PrestamoSala;
import logic.Sala;
import logic.Tipo;
import logic.Usuario;
import models.Modelo_Prestamo_Sala;
import models.Modelo_Sala;
import models.Modelo_Usuario;

public class PrestamoSala_Controller implements ActionListener{
	
	private PrestamoSala prestamoSala;
	private Usuario usuario;
	private PrestarSala prestarSala;
	
	public PrestamoSala_Controller(PrestarSala prestarSala) {
		this.prestamoSala = new PrestamoSala();
		this.usuario = new Usuario();
		this.prestarSala = prestarSala;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (this.prestarSala.getBtnBuscarUsuario() == e.getSource()) {
			if (!this.prestarSala.getTxtUsuario().getText().equals("")) {
				Modelo_Usuario user = this.usuario.obtenerUsuario(Integer.parseInt(this.prestarSala.getTxtUsuario().getText()));
				if (user != null) {
					this.prestarSala.getLblNombre().setText(user.getNOMBREUSUARIO());
					this.prestarSala.getLblApellido().setText(user.getAPELLIDOUSUARIO());
					this.prestarSala.getLblCorreo().setText(user.getCORREO());

					Carrera c = new Carrera();
					String[] vecCarrera = c.obtenerCarrera(user.getIDCARRERA());
					this.prestarSala.getLblCarrera().setText(vecCarrera[1]);

					Tipo t = new Tipo();
					String[] vecTipo = t.obtenerTipo(user.getIDTIPO());
					this.prestarSala.getLblTipo().setText(vecTipo[1]);
					
					// Seteo de los campos en el FRAME
					this.prestarSala.getTxtUsuario().setEnabled(false);
					this.prestarSala.getCbxSalas().setEnabled(true);
					this.prestarSala.getCbxSalas().removeAllItems();
					

					// Trae todos los prestamos de las salas
					PrestamoSala ps = new PrestamoSala();
					ArrayList<Modelo_Prestamo_Sala> prestamos = ps.obtenerPrestamosSala();

					// Trae todas las salas
					Sala sala = new Sala();
					ArrayList<Modelo_Sala> salas = sala.obtenerSalas();
					this.prestarSala.getCbxSalas().addItem("Seleccione una sala");
					for (int i = 0; i < salas.size(); i++) {
						this.prestarSala.getCbxSalas().addItem(salas.get(i).getNOMBRESALA());
					}
					// calcular que salas estan disponibles

				} else {
					JOptionPane.showMessageDialog(null, "Este usuario no se encuentra registrado");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Por favor ingresa un código a buscar");
			}
		}
		
	}

}
