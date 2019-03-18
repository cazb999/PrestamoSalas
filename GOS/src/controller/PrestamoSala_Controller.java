package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

public class PrestamoSala_Controller implements ActionListener {

	private PrestamoSala prestamoSala;
	private Usuario usuario;
	private PrestarSala prestarSala;
	private Sala sala;

	public PrestamoSala_Controller(PrestarSala prestarSala) {
		this.prestamoSala = new PrestamoSala();
		this.usuario = new Usuario();
		this.prestarSala = prestarSala;
		this.sala = new Sala();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (this.prestarSala.getBtnBuscarUsuario() == e.getSource()) {
			if (!this.prestarSala.getTxtUsuario().getText().equals("")) {
				Modelo_Usuario user = this.usuario
						.obtenerUsuario(Integer.parseInt(this.prestarSala.getTxtUsuario().getText()));
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
					this.prestarSala.getDateDia().setEnabled(true);
					this.prestarSala.getBtnDisponibilidad().setEnabled(true);

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

		if (this.prestarSala.getBtnDisponibilidad() == e.getSource()) {
			String itemSeleecionado = (String) this.prestarSala.getCbxSalas().getSelectedItem();

			Calendar lunes = Calendar.getInstance();
			Calendar martes = Calendar.getInstance();
			Calendar miercoles = Calendar.getInstance();
			Calendar jueves = Calendar.getInstance();
			Calendar viernes = Calendar.getInstance();
			Calendar sabado = Calendar.getInstance();
			Calendar domingo = Calendar.getInstance();

			if (this.prestarSala.getCbxSalas().getSelectedIndex() > 0) {
				
				ArrayList<Calendar> fechasSemana = new ArrayList<Calendar>();
				SimpleDateFormat sdf_semana = new SimpleDateFormat("yyyy-MM-dd");
				Calendar hoy = Calendar.getInstance();
				switch (hoy.get(Calendar.DAY_OF_WEEK)) {
				case 1:
					lunes.add(Calendar.DAY_OF_YEAR, 1);
					martes.add(Calendar.DAY_OF_YEAR, 2);
					miercoles.add(Calendar.DAY_OF_YEAR, 3);
					jueves.add(Calendar.DAY_OF_YEAR, 4);
					viernes.add(Calendar.DAY_OF_YEAR, 5);
					sabado.add(Calendar.DAY_OF_YEAR, 6);
					fechasSemana.add(hoy);
					fechasSemana.add(lunes);
					fechasSemana.add(martes);
					fechasSemana.add(miercoles);
					fechasSemana.add(jueves);
					fechasSemana.add(viernes);
					fechasSemana.add(sabado);
					break;
				case 2:
					domingo.add(Calendar.DAY_OF_YEAR, -1);
					martes.add(Calendar.DAY_OF_YEAR, 1);
					miercoles.add(Calendar.DAY_OF_YEAR, 2);
					jueves.add(Calendar.DAY_OF_YEAR, 3);
					viernes.add(Calendar.DAY_OF_YEAR, 4);
					sabado.add(Calendar.DAY_OF_YEAR, 5);
					fechasSemana.add(domingo);
					fechasSemana.add(hoy);
					fechasSemana.add(martes);
					fechasSemana.add(miercoles);
					fechasSemana.add(jueves);
					fechasSemana.add(viernes);
					fechasSemana.add(sabado);
					break;
				case 3:
					domingo.add(Calendar.DAY_OF_YEAR, -2);
					lunes.add(Calendar.DAY_OF_YEAR, -1);
					miercoles.add(Calendar.DAY_OF_YEAR, 1);
					jueves.add(Calendar.DAY_OF_YEAR, 2);
					viernes.add(Calendar.DAY_OF_YEAR, 3);
					sabado.add(Calendar.DAY_OF_YEAR, 4);
					fechasSemana.add(domingo);
					fechasSemana.add(lunes);
					fechasSemana.add(hoy);
					fechasSemana.add(miercoles);
					fechasSemana.add(jueves);
					fechasSemana.add(viernes);
					fechasSemana.add(sabado);
					break;
				case 4:
					fechasSemana.add(domingo);
					fechasSemana.add(lunes);
					fechasSemana.add(martes);
					fechasSemana.add(hoy);
					fechasSemana.add(jueves);
					fechasSemana.add(viernes);
					fechasSemana.add(sabado);
					break;
				case 5:
					domingo.add(Calendar.DAY_OF_YEAR, -4);
					lunes.add(Calendar.DAY_OF_YEAR, -3);
					martes.add(Calendar.DAY_OF_YEAR, -2);
					miercoles.add(Calendar.DAY_OF_YEAR, -1);
					viernes.add(Calendar.DAY_OF_YEAR, 1);
					sabado.add(Calendar.DAY_OF_YEAR, 2);
					fechasSemana.add(domingo);
					fechasSemana.add(lunes);
					fechasSemana.add(martes);
					fechasSemana.add(miercoles);
					fechasSemana.add(hoy);
					fechasSemana.add(viernes);
					fechasSemana.add(sabado);
					break;
				case 6:
					domingo.add(Calendar.DAY_OF_YEAR, -5);
					lunes.add(Calendar.DAY_OF_YEAR, -4);
					martes.add(Calendar.DAY_OF_YEAR, -3);
					miercoles.add(Calendar.DAY_OF_YEAR, -2);
					jueves.add(Calendar.DAY_OF_YEAR, -1);
					sabado.add(Calendar.DAY_OF_YEAR, 1);
					fechasSemana.add(domingo);
					fechasSemana.add(lunes);
					fechasSemana.add(martes);
					fechasSemana.add(miercoles);
					fechasSemana.add(jueves);
					fechasSemana.add(hoy);
					fechasSemana.add(sabado);
					break;

				case 7:
					domingo.add(Calendar.DAY_OF_YEAR, -6);
					lunes.add(Calendar.DAY_OF_YEAR, -5);
					martes.add(Calendar.DAY_OF_YEAR, -4);
					miercoles.add(Calendar.DAY_OF_YEAR, -3);
					jueves.add(Calendar.DAY_OF_YEAR, -2);
					sabado.add(Calendar.DAY_OF_YEAR, -1);
					fechasSemana.add(domingo);
					fechasSemana.add(lunes);
					fechasSemana.add(martes);
					fechasSemana.add(miercoles);
					fechasSemana.add(jueves);
					fechasSemana.add(viernes);
					fechasSemana.add(hoy);
					break;

				default:
					break;
				}
				
				// Trae todos los prestamos de las salas de cada semana
				PrestamoSala ps = new PrestamoSala();
				SimpleDateFormat sdf = new SimpleDateFormat("HH");
				for (int i = 0; i < fechasSemana.size(); i++) {
					ArrayList<Modelo_Prestamo_Sala> prestamosHoy = ps.obtenerPrestamosSalaPorFecha(fechasSemana.get(i));
					for (int j = 0; j < prestamosHoy.size(); j++) {
						for (int j2 = 7; j2 <= 22; j2++) {
							if(Integer.parseInt(sdf.format(prestamosHoy.get(j).getFECHA_INICIO().getTime())) == (j2)) {
								System.out.println("j2->"+j2);
								System.out.println("Fecha fin ->"+sdf.format(prestamosHoy.get(j).getFECHA_FIN().getTime()));
								for (int k = j2; k < Integer.parseInt(sdf.format(prestamosHoy.get(j).getFECHA_FIN().getTime())); k++) {
									System.out.println("k->"+k);
									this.prestarSala.getTableHorarios().setValueAt("si", (k-7), i+1);
								}
								
							}
						}
					}
				}

			}

		}

	}

}
