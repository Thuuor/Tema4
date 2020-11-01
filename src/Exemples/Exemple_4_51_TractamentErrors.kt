package Exemples

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

fun main(args: Array<String>) {

	var connectat = false
	var con: Connection? = null
	println("tractamentErrorConnexio()")

	try {
		// Carrega el driver en mem�ria. Si no es troba el driver, saltar� l'excepci� ClassNotFoundException
		Class.forName("com.mysql.jdbc.Driver")

		val url = "jdbc:mysql://89.36.214.106:3306/geo"

		val usuari = "geo"
		val contrasenyes = arrayOf("geo0", "geo1", "geo")

		for (i in 0 until contrasenyes.size) {
			try {
				con = DriverManager.getConnection(url, usuari, contrasenyes[i])
				connectat = true
				break
			} catch (ex: SQLException) {
				if (!ex.getSQLState().equals("28000")) {
					// NO �s un error d'autenticaci�
					throw ex
				}
			}
		}
		if (connectat)
			println("Connexi� efectuada correctament")
		else
			println("Error en la contrasenya")
	} catch (ex: SQLException) {
		if (ex.getSQLState().equals("08001")) {
			println(
				"S'ha detectat un problema de connexi�. Reviseu els cables de xarxa i assegureu-vos que el SGBD est� operatiu."
						+ " Si continua sense connectar, aviseu el servei t�cnic"
			)

		} else {
			println(
				"S'ha produ�t un error inesperat. Truqueu al servei t�cnic indicant el seg�ent codi d'error SQL:"
						+ ex.getSQLState()
			)
		}
	} catch (ex: ClassNotFoundException) {
		println("No s'ha trobat el controlador JDBC (" + ex.message + "). Truqueu al servei t�cnic")
	} finally {
		try {
			if (con != null && !con.isClosed()) {
				con.close()
			}
		} catch (ex: SQLException) {
			throw ex
		}
	}
}