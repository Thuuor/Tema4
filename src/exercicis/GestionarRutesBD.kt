package exercicis

import java.sql.DriverManager

class GestionarRutesBD {
	
	constructor(){
		val url = "jdbc:sqlite:Rutes.sqlite"
		val con = DriverManager.getConnection(url)
	}
	
	fun close(){
		
	}
	
	fun inserir(Ruta r){
		
	}
	
	fun buscar(int i): Ruta{
		
	}
	
	fun llistat() : ArrayList<Ruta>{
		
	}
	
	fun esborrar(int i){
		
	}
}