package exercicis

import java.sql.DriverManager
import java.io.ObjectInputStream
import java.io.FileInputStream
import java.io.EOFException

fun main(args: Array<String>) {
    val url = "jdbc:sqlite:Rutes.sqlite"
    val con = DriverManager.getConnection(url)

    val st = con.createStatement ()
	
   
	val f_in = ObjectInputStream(FileInputStream("Rutes.obj"))
	var c = 0
	try {
        while (true) {
			c++
            val r = f_in.readObject() as Ruta
			
			var nom = r.nom
			var desnivell = r.desnivell
			var desnivellAcum = r.desnivellAcumulat

            st.executeUpdate("INSERT INTO RUTES VALUES($c,'$nom','$desnivell','$desnivellAcum')")

			for(punts in 0 until r.size()){
				
				var nomPunt = r.getPuntNom(punts)
				var latitud = r.getPuntLatitud(punts)
				var longitud = r.getPuntLongitud(punts)
				
				var countPunt = (punts+1)
				
				st.executeUpdate("INSERT INTO PUNTS VALUES($c,$countPunt,'$nomPunt',$latitud,$longitud)")
			
			}
			
        }

    } catch (e: EOFException) {
        f_in.close()
		st.close()
		con.close()

	}
    
	
}