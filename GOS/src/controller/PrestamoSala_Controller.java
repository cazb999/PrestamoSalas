package controller;

import java.awt.Checkbox;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import interfaces.PrestarSala;
import logic.Carrera;
import logic.PrestamoSala;
import logic.Sala;
import logic.Tipo;
import logic.Usuario;
import models.Modelo_Prestamo_Sala;
import models.Modelo_Sala;
import models.Modelo_Usuario;

public class PrestamoSala_Controller implements ActionListener, MouseListener{

	private PrestamoSala prestamoSala;
	private Usuario usuario;
	private PrestarSala prestarSala;
	private Sala sala;

	Object[][] data = {
			{"7 - 8", "", "", "", "", "", ""},
			{"8 - 9", "", "", "", "", "", ""},
			{"9 - 10", "", "", "", "", "", ""},
			{"10 - 11", "", "", "", "", "", ""},
			{"11 - 12", "", "", "", "", "", ""},
			{"12 - 13", "", "", "", "", "", ""},
			{"13 - 14", "", "", "", "", "", ""},
			{"14 - 15", "", "", "", "", "", ""},
			{"15 - 16", "", "", "", "", "", ""},
			{"16 - 17", "", "", "", "", "", ""},
			{"17 - 18", "", "", "", "", "", ""},
			{"18 - 19", "", "", "", "", "", ""},
			{"19 - 20", "", "", "", "", "", ""},
			{"20 - 21", "", "", "", "", "", ""},
			{"21 - 22", "", "", "", "", "", ""},
		};
	private String[] columnas = { "Hora", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado" };
	
	ArrayList<Calendar> fechasSemana = new ArrayList<Calendar>();

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
				JOptionPane.showMessageDialog(null, "Por favor ingresa un c�digo a buscar");
			}
		}

		if (this.prestarSala.getBtnDisponibilidad() == e.getSource()) {
			this.prestarSala.getTableHorarios().setModel(new DefaultTableModel(data, columnas));
			
			Date fehcaSeleccionada = this.prestarSala.getDateDia().getCalendar().getTime();

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

			if (this.prestarSala.getCbxSalas().getSelectedIndex() > 0) {
				
				fechasSemana = new ArrayList<Calendar>();
				Calendar hoy =new GregorianCalendar();
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
					ArrayList<Modelo_Prestamo_Sala> prestamosHoy = ps.obtenerPrestamosSalaPorFecha(fechasSemana.get(i));
					for (int j = 0; j <prestamosHoy.size(); j++) {
						if(Integer.parseInt(sdf.format(prestamosHoy.get(j).getFECHA_INICIO().getTime())) == 24) {
							prestamosHoy.get(j).getFECHA_INICIO().add(Calendar.HOUR_OF_DAY, 12);
						}
						if(Integer.parseInt(sdf.format(prestamosHoy.get(j).getFECHA_FIN().getTime())) == 24) {
							prestamosHoy.get(j).getFECHA_FIN().add(Calendar.HOUR_OF_DAY, 12);
						}
					}
					
					// este for llena las casillas de la tabla
					for (int j = 0; j < prestamosHoy.size(); j++) {
						
						for (int j2 = 7; j2 <= 22; j2++) {
							if (Integer.parseInt(sdf.format(prestamosHoy.get(j).getFECHA_INICIO().getTime())) == j2) {								
									this.prestarSala.getTableHorarios().setValueAt("Prestada", (j2 - 7), i);								
							}
						}
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "Por favor, Seleccione una sala");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		int fila = this.prestarSala.getTableHorarios().getSelectedRow();
		int columna = this.prestarSala.getTableHorarios().getSelectedColumn();
		
		TableModel model = this.prestarSala.getTableHorarios().getModel();
		String valorCelda = model.getValueAt(fila, columna).toString();
		if(valorCelda.equals("")) {
			
			SimpleDateFormat sdf_full = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			SimpleDateFormat sdf_Date = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				
				//Obtener las fechas y parsearlas
				Date date_inicio = sdf_full.parse(sdf_Date.format(fechasSemana.get(columna).getTime())+" "+(fila+7)+":00:00");
				Date date_fin = sdf_full.parse(sdf_Date.format(fechasSemana.get(columna).getTime())+" "+(fila+7)+":00:00");
				
				Calendar calendar_inicio = Calendar.getInstance();
				calendar_inicio.setTime(date_inicio);
				
				Calendar calendar_fin = Calendar.getInstance();
				calendar_fin.setTime(date_fin);
				
				//Obtener sala
				Sala sale = new Sala();
				Modelo_Sala s = sale.obtenerSala(this.prestarSala.getCbxSalas().getSelectedItem().toString());
				
				//Obtener usuario
				Usuario user = new Usuario();
				Modelo_Usuario u = user.obtenerUsuario(Integer.parseInt(this.prestarSala.getTxtUsuario().getText()));
				
				//Crear Prestamo
				Modelo_Prestamo_Sala modelo_prestamo = new Modelo_Prestamo_Sala(0, calendar_inicio, calendar_fin, u.getIDUSUARIO(), s.getIDSALA());
				if(this.prestamoSala.crearPrestamoSala(modelo_prestamo)) {
					JOptionPane.showMessageDialog(null, "Prestamo efectuado con exito para:\n"+u.getNOMBREUSUARIO());
				}
				
				
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
		} else if(valorCelda.equals("Prestada")) {
			
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
}
