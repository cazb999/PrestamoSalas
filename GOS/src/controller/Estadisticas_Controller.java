package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import logic.PrestamoSala;
import logic.Sala;
import logic.Usuario;
import models.Modelo_Sala;
import models.Modelo_Usuario;

public class Estadisticas_Controller {
	
	public Estadisticas_Controller(){
		
	}
	
	public void salasMasConsultadas(JList list) {
		PrestamoSala ps = new PrestamoSala();
		
		DefaultListModel modelo = new DefaultListModel();
		
		ArrayList<String[]> salasContadas = ps.salasMasSolicitadas();
		for (int i = 0; i < salasContadas.size(); i++) {
			Sala s = new Sala();
			Modelo_Sala ms = s.obtenerSalaID(Integer.parseInt(salasContadas.get(i)[0]));
			modelo.addElement("ID Sala: "+ms.getIDSALA()+"   Nombre Sala: "+ms.getNOMBRESALA()+"   Total Prestamos: "+salasContadas.get(i)[1]);
			list.setModel(modelo);
		}
	}
	
	public void usuariosMasRecurrentes(JList list) {
		Usuario u = new Usuario();
		
		DefaultListModel modelo = new DefaultListModel();
		
		ArrayList<String[]> usuariosContados = u.usuariosMasRecurrentes();
		for (int i = 0; i < usuariosContados.size(); i++) {
			Usuario u_2 = new Usuario();
			Modelo_Usuario mu = u_2.obtenerUsuarioID(Integer.parseInt(usuariosContados.get(i)[0]));
			modelo.addElement("COD: "+mu.getCODIGOUSUARIO()+"   Nombre: "+mu.getNOMBREUSUARIO() +" "+mu.getAPELLIDOUSUARIO()+"   Total Prestamos: "+usuariosContados.get(i)[1]);
			list.setModel(modelo);
		}
	}

}
