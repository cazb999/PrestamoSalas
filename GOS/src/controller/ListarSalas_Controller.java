package controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import logic.Sala;
import models.Modelo_Sala;

public class ListarSalas_Controller {
	
	public ListarSalas_Controller() {
		// TODO Auto-generated constructor stub
	}
	
	public void listar(JList lista) {
		Sala sala = new Sala();
		ArrayList<Modelo_Sala> salas = sala.obtenerSalas();
		DefaultListModel modelo = new DefaultListModel();
		for(int i = 0; i < salas.size(); i++){
		        modelo.addElement((i+1)+". Nombre de la sala: "+salas.get(i).getNOMBRESALA()+"     Número de PC's: "+salas.get(i).getCAPACIDADSALA());
		}
		lista.setModel(modelo);
	}

}
