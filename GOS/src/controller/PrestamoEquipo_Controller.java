package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import interfaces.MenuBecario;
import interfaces.PrestarEquipo;
import interfaces.PrestarSala;
import logic.Carrera;
import logic.Equipo;
import logic.PrestamoEquipo;
import logic.PrestamoSala;
import logic.Sala;
import logic.Tipo;
import logic.Usuario;
import models.Modelo_Equipo;
import models.Modelo_Prestamo_Equipo;
import models.Modelo_Prestamo_Sala;
import models.Modelo_Sala;
import models.Modelo_Usuario;

public class PrestamoEquipo_Controller implements ActionListener, MouseListener {

	private PrestamoSala prestamoSala;
	private PrestamoEquipo prestamoEquipo;
	private Usuario usuario;
	private PrestarEquipo prestarEquipo;
	private Sala sala;

	Object[][] data = { { "07:00 am - 08:00 am", "", "", "", "", "", "" }, { "08:00 am - 09:00 am", "", "", "", "", "", "" },
			{ "09:00 am - 10:00 am", "", "", "", "", "", "" }, { "10:00 am - 11:00 am", "", "", "", "", "", "" },
			{ "11:00 am - 12:00 m", "", "", "", "", "", "" }, { "12:00 m - 01:00 pm", "", "", "", "", "", "" },
			{ "01:00 pm - 02:00 pm", "", "", "", "", "", "" }, { "02:00 pm - 03:00 pm", "", "", "", "", "", "" },
			{ "03:00 pm - 04:00 pm", "", "", "", "", "", "" }, { "04:00 pm - 05:00 pm", "", "", "", "", "", "" },
			{ "05:00 pm - 06:00 pm", "", "", "", "", "", "" }, { "06:00 pm - 07:00 pm", "", "", "", "", "", "" },
			{ "07:00 pm - 08:00 pm", "", "", "", "", "", "" }, { "08:00 pm - 09:00 pm", "", "", "", "", "", "" },
			{ "09:00 pm - 10:00 pm", "", "", "", "", "", "" }, };
	private String[] columnas = { "Hora", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" };

	ArrayList<Calendar> fechasSemana = new ArrayList<Calendar>();

	public PrestamoEquipo_Controller(PrestarEquipo prestarEquipo) {
		this.prestamoSala = new PrestamoSala();
		this.prestamoEquipo = new PrestamoEquipo();
		this.usuario = new Usuario();
		this.prestarEquipo = prestarEquipo;
		this.sala = new Sala();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (this.prestarEquipo.getBtnBuscarUsuario() == e.getSource()) {
			if (!this.prestarEquipo.getTxtUsuario().getText().equals("")) {
				Modelo_Usuario user = this.usuario
						.obtenerUsuario(Integer.parseInt(this.prestarEquipo.getTxtUsuario().getText()));
				if (user != null) {
					this.prestarEquipo.getLblNombre().setText(user.getNOMBREUSUARIO());
					this.prestarEquipo.getLblApellido().setText(user.getAPELLIDOUSUARIO());
					this.prestarEquipo.getLblCorreo().setText(user.getCORREO());

					Carrera c = new Carrera();
					String[] vecCarrera = c.obtenerCarrera(user.getIDCARRERA());
					this.prestarEquipo.getLblCarrera().setText(vecCarrera[1]);

					Tipo t = new Tipo();
					String[] vecTipo = t.obtenerTipo(user.getIDTIPO());
					this.prestarEquipo.getLblTipo().setText(vecTipo[1]);

					// Seteo de los campos en el FRAME
					this.prestarEquipo.getTxtUsuario().setEnabled(false);
					this.prestarEquipo.getCbxSalas().setEnabled(true);
					this.prestarEquipo.getCbxSalas().removeAllItems();
					this.prestarEquipo.getDateDia().setEnabled(true);
					this.prestarEquipo.getBtnDisponibilidad().setEnabled(true);

					// Trae todas las salas
					Sala sala = new Sala();
					ArrayList<Modelo_Sala> salas = sala.obtenerSalas();
					this.prestarEquipo.getCbxSalas().addItem("Seleccione una sala");
					for (int i = 0; i < salas.size(); i++) {
						this.prestarEquipo.getCbxSalas().addItem(salas.get(i).getNOMBRESALA());
					}
					// calcular que salas estan disponibles

				} else {
					JOptionPane.showMessageDialog(null, "Este usuario no se encuentra registrado");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Por favor ingresa un código a buscar");
			}
		}

		if (this.prestarEquipo.getBtnDisponibilidad() == e.getSource()) {
			llenarTabla();
		}
		
		if(this.prestarEquipo.getBtnRegresar() == e.getSource()) {
			MenuBecario mb = new MenuBecario();
			mb.setVisible(true);
			mb.setLocationRelativeTo(null);
			mb.setResizable(false);
			this.prestarEquipo.dispose();
		}
		
		if(e.getSource() == this.prestarEquipo.getBtnCambiarUsuario()) {
			this.prestarEquipo.getTxtUsuario().setEnabled(true);
			this.prestarEquipo.getTxtUsuario().setText("");
			this.prestarEquipo.getCbxSalas().setEnabled(false);
			this.prestarEquipo.getCbxSalas().removeAllItems();
			this.prestarEquipo.getDateDia().setEnabled(false);
			this.prestarEquipo.getBtnDisponibilidad().setEnabled(false);
			this.prestarEquipo.getTableHorarios().setModel(new DefaultTableModel(data, columnas));
			this.prestarEquipo.getLblApellido().setText("");
			this.prestarEquipo.getLblCarrera().setText("");
			this.prestarEquipo.getLblCorreo().setText("");
			this.prestarEquipo.getLblNombre().setText("");
			this.prestarEquipo.getLblTipo().setText("");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int fila = this.prestarEquipo.getTableHorarios().getSelectedRow();
		int columna = this.prestarEquipo.getTableHorarios().getSelectedColumn();

		TableModel model = this.prestarEquipo.getTableHorarios().getModel();
		String valorCelda = model.getValueAt(fila, columna).toString();
		if (valorCelda.equals("")) {
			JOptionPane.showMessageDialog(null, "Para prestar un equipo primero debe apartar la sala!");

		} else if (valorCelda.equals("Prestada")) {
			int input = JOptionPane.showConfirmDialog(null, "¿Desea prestar un equipo a\n"+ this.prestarEquipo.getLblNombre().getText() + " " + this.prestarEquipo.getLblApellido().getText()+"\nEn la sala "+this.prestarEquipo.getCbxSalas().getSelectedItem()+"?");
			if(input == 0) {
				Equipo equipo = new Equipo();
				if(equipo.obtenerEquipoDisponible(this.prestarEquipo.getCbxSalas().getSelectedItem().toString()) != null) {
					SimpleDateFormat sdf_full = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					SimpleDateFormat sdf_Date = new SimpleDateFormat("yyyy-MM-dd");

					try {

						// Obtener las fechas y parsearlas
						Date date_inicio = sdf_full.parse(sdf_Date.format(fechasSemana.get(columna).getTime()) + " " + (fila + 7) + ":00:00");
						Date date_fin = sdf_full.parse(sdf_Date.format(fechasSemana.get(columna).getTime()) + " " + (fila + 7) + ":00:00");

						Calendar calendar_inicio = Calendar.getInstance();
						calendar_inicio.setTime(date_inicio);

						Calendar calendar_fin = Calendar.getInstance();
						calendar_fin.setTime(date_fin);

						// Obtener Equipo
						Modelo_Equipo modelo_equipo = equipo.obtenerEquipoDisponible(this.prestarEquipo.getCbxSalas().getSelectedItem().toString());

						// Obtener usuario
						Usuario user = new Usuario();
						Modelo_Usuario u = user
								.obtenerUsuario(Integer.parseInt(this.prestarEquipo.getTxtUsuario().getText()));

						// Crear Prestamo
						Modelo_Prestamo_Equipo modelo_prestamo = new Modelo_Prestamo_Equipo(0, u.getIDUSUARIO(), modelo_equipo.getIDEQUIPO(), calendar_inicio, calendar_fin);
						if(!this.prestamoEquipo.prestamoUsuarioExiste(modelo_prestamo)) {
							if (this.prestamoEquipo.crearPrestamoEquipo(modelo_prestamo)) {
								llenarTabla();
								JOptionPane.showMessageDialog(null, "Prestamo de equipo realizado exitosamente");
							}
						}else {
							JOptionPane.showMessageDialog(null, "El usuario "+u.getNOMBREUSUARIO()+" "+u.getAPELLIDOUSUARIO()+"\nTiene un equipo prestado en esta sala!");
						}
						

					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "No hay equipos disponibles en esta sala!");
				}
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	private void llenarTabla() {
		this.prestarEquipo.getTableHorarios().setModel(new DefaultTableModel(data, columnas));

		Date fehcaSeleccionada = this.prestarEquipo.getDateDia().getCalendar().getTime();

		Calendar lunes = new GregorianCalendar();
		lunes.setTime(fehcaSeleccionada);
		Calendar martes = new GregorianCalendar();
		martes.setTime(fehcaSeleccionada);
		Calendar miercoles = new GregorianCalendar();
		miercoles.setTime(fehcaSeleccionada);
		Calendar jueves = new GregorianCalendar();
		jueves.setTime(fehcaSeleccionada);
		Calendar viernes = new GregorianCalendar();
		viernes.setTime(fehcaSeleccionada);
		Calendar sabado = new GregorianCalendar();
		sabado.setTime(fehcaSeleccionada);
		Calendar domingo = new GregorianCalendar();
		domingo.setTime(fehcaSeleccionada);

		if (this.prestarEquipo.getCbxSalas().getSelectedIndex() > 0) {

			fechasSemana = new ArrayList<Calendar>();
			Calendar hoy = new GregorianCalendar();
			hoy.setTime(fehcaSeleccionada);
			switch (hoy.get(Calendar.DAY_OF_WEEK)) {
			case 1:
				lunes.add(Calendar.DAY_OF_YEAR, 1);
				martes.add(Calendar.DAY_OF_YEAR, 2);
				miercoles.add(Calendar.DAY_OF_YEAR, 3);
				jueves.add(Calendar.DAY_OF_YEAR, 4);
				viernes.add(Calendar.DAY_OF_YEAR, 5);
				sabado.add(Calendar.DAY_OF_YEAR, 6);
				fechasSemana.add(domingo);
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
				fechasSemana.add(lunes);
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
				fechasSemana.add(martes);
				fechasSemana.add(miercoles);
				fechasSemana.add(jueves);
				fechasSemana.add(viernes);
				fechasSemana.add(sabado);

				break;
			case 4:
				domingo.add(Calendar.DAY_OF_YEAR, -3);
				lunes.add(Calendar.DAY_OF_YEAR, -2);
				martes.add(Calendar.DAY_OF_YEAR, -1);
				jueves.add(Calendar.DAY_OF_YEAR, 1);
				viernes.add(Calendar.DAY_OF_YEAR, 2);
				sabado.add(Calendar.DAY_OF_YEAR, 3);
				fechasSemana.add(domingo);
				fechasSemana.add(lunes);
				fechasSemana.add(martes);
				fechasSemana.add(miercoles);
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
				fechasSemana.add(jueves);
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
				fechasSemana.add(viernes);
				fechasSemana.add(sabado);
				break;

			case 7:
				domingo.add(Calendar.DAY_OF_YEAR, -6);
				lunes.add(Calendar.DAY_OF_YEAR, -5);
				martes.add(Calendar.DAY_OF_YEAR, -4);
				miercoles.add(Calendar.DAY_OF_YEAR, -3);
				jueves.add(Calendar.DAY_OF_YEAR, -2);
				viernes.add(Calendar.DAY_OF_YEAR, -1);
				fechasSemana.add(domingo);
				fechasSemana.add(lunes);
				fechasSemana.add(martes);
				fechasSemana.add(miercoles);
				fechasSemana.add(jueves);
				fechasSemana.add(viernes);
				fechasSemana.add(sabado);
				break;

			default:
				break;
			}

			// Trae todos los prestamos de las salas de cada semana
			PrestamoSala ps = new PrestamoSala();
			SimpleDateFormat sdf = new SimpleDateFormat("kk");
			SimpleDateFormat sdf_aux = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
			// este for cambiar la hora 24 por 12
			for (int i = 0; i < fechasSemana.size(); i++) {
				ArrayList<Modelo_Prestamo_Sala> prestamosHoy = ps.obtenerPrestamosSalaPorFecha(fechasSemana.get(i), this.prestarEquipo.getCbxSalas().getSelectedItem().toString());
				for (int j = 0; j < prestamosHoy.size(); j++) {
					if (Integer.parseInt(sdf.format(prestamosHoy.get(j).getFECHA_INICIO().getTime())) == 24) {
						prestamosHoy.get(j).getFECHA_INICIO().add(Calendar.HOUR_OF_DAY, 12);
					}
					if (Integer.parseInt(sdf.format(prestamosHoy.get(j).getFECHA_FIN().getTime())) == 24) {
						prestamosHoy.get(j).getFECHA_FIN().add(Calendar.HOUR_OF_DAY, 12);
					}
				}

				// este for llena las casillas de la tabla
				for (int j = 0; j < prestamosHoy.size(); j++) {

					for (int j2 = 7; j2 <= 22; j2++) {
						if (Integer.parseInt(sdf.format(prestamosHoy.get(j).getFECHA_INICIO().getTime())) == j2) {
							this.prestarEquipo.getTableHorarios().setValueAt("Prestada", (j2 - 7), i);
						}
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Por favor, Seleccione una sala");
		}
		this.prestarEquipo.getTableHorarios().setDefaultRenderer(Object.class, new TableRenderer());
	}

}
