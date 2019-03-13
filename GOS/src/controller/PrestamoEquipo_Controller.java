package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import interfaces.PrestarEquipo;
import logic.Carrera;
import logic.PrestamoEquipo;
import logic.PrestamoSala;
import logic.Sala;
import logic.Tipo;
import logic.Usuario;
import models.Modelo_Prestamo_Sala;
import models.Modelo_Sala;
import models.Modelo_Usuario;

public class PrestamoEquipo_Controller implements ActionListener {

	private PrestamoEquipo prestamoEquipo;
	private Usuario usuario;
	private PrestarEquipo formPrestarEquipo;

	public PrestamoEquipo_Controller(PrestarEquipo formPrestarEquipo) {
		this.formPrestarEquipo = formPrestarEquipo;
		this.prestamoEquipo = new PrestamoEquipo();
		this.usuario = new Usuario();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (this.formPrestarEquipo.getBtnBuscarUsuario() == e.getSource()) {
			if (!this.formPrestarEquipo.getTxtUsuario().getText().equals("")) {
				Modelo_Usuario user = this.usuario
						.obtenerUsuario(Integer.parseInt(this.formPrestarEquipo.getTxtUsuario().getText()));
				if (user != null) {
					this.formPrestarEquipo.getLblNombre().setText(user.getNOMBREUSUARIO());
					this.formPrestarEquipo.getLblApellido().setText(user.getAPELLIDOUSUARIO());
					this.formPrestarEquipo.getLblCorreo().setText(user.getCORREO());

					Carrera c = new Carrera();
					String[] vecCarrera = c.obtenerCarrera(user.getIDCARRERA());
					this.formPrestarEquipo.getLblCarrera().setText(vecCarrera[1]);

					Tipo t = new Tipo();
					String[] vecTipo = t.obtenerTipo(user.getIDTIPO());
					this.formPrestarEquipo.getLblTipo().setText(vecTipo[1]);

					this.formPrestarEquipo.getTxtUsuario().setEditable(false);

					// Trae todos los prestamos de las salas
					PrestamoSala ps = new PrestamoSala();
					ArrayList<Modelo_Prestamo_Sala> prestamos = ps.obtenerPrestamosSala();

					// Trae todas las salas
					Sala sala = new Sala();
					ArrayList<Modelo_Sala> salas = sala.obtenerSalas();
					System.out.println(salas);
					// calcular que salas estan disponibles
					ArrayList<Modelo_Sala> salasDisponibles = null;
					for (int i = 0; i < salas.size(); i++) {
						for (int j = 0; j < prestamos.size(); j++) {
							
							if (salas.get(i).getIDSALA() == prestamos.get(j).getIDSALA() && prestamos.get(j).getFECHA_FIN() != null) {
								salasDisponibles.add(salas.get(i));
							} else if (salas.get(i).getIDSALA() != prestamos.get(j).getIDSALA()) {
								salasDisponibles.add(salas.get(i));
							}
						}
					}
					if (salasDisponibles != null) {
						for (int i = 0; i < salasDisponibles.size(); i++) {
							System.out.println(salasDisponibles.get(i).getNOMBRESALA());
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "Este usuario no se encuentra registrado");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Por favor ingresa un código a buscar");
			}
		}

	}

}
