package exercicis

import java.sql.DriverManager

fun main(args: Array<String>) {
    val url = "jdbc:sqlite:Rutes.sqlite"

    val    con = DriverManager.getConnection(url)

    val st = con.createStatement ()
    val sentSQL = "CREATE TABLE RUTES(" +
			"num_r INTEGER, " +
			"nom_r TEXT, " +
			"desn TEXT, " +
			"desn_Acum TEXT, " +
			"CONSTRAINT cp_rutes PRIMARY KEY(num_r)" +
			")"
	
	 val sentSQL1 = "CREATE TABLE PUNTS(" +
			"num_r INTEGER, " +
			"num_p INTEGER, " +
			"nom_p TEXT, " +
			"latitud REAL, " +
			"longitud REAL, " +
			"CONSTRAINT cp_punts PRIMARY KEY (num_r,num_p)," +
			"CONSTRAINT ce_punts_rutes FOREIGN KEY (num_r) REFERENCES RUTES" +
			")"
	
	st.executeUpdate(sentSQL)
	st.executeUpdate(sentSQL1)
    st.close()

    con.close()
	
}