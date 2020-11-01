package exercicis

import javax.swing.JFrame
import java.awt.EventQueue
import java.awt.BorderLayout
import javax.swing.JPanel
import java.awt.FlowLayout
import javax.swing.JComboBox
import javax.swing.JButton
import javax.swing.JTextArea
import javax.swing.JLabel
import java.sql.DriverManager

class Finestra : JFrame() {

	init {
		val url = "jdbc:sqlite:Rutes.sqlite"
		val con = DriverManager.getConnection(url)

		// Sent�ncies per a fer la connexi�
		
		defaultCloseOperation = JFrame.EXIT_ON_CLOSE
		setTitle("JDBC: Visualitzar Rutes")
		setSize(450, 450)
		setLayout(BorderLayout())

		val panell1 = JPanel(FlowLayout())
		val panell2 = JPanel(BorderLayout())
		add(panell1, BorderLayout.NORTH)
		add(panell2, BorderLayout.CENTER)

		val llistaRutes = arrayListOf<String>()
		
		// Sent�ncies per a omplir l'ArrayList amb el nom de les rutes

		val combo = JComboBox<String>(llistaRutes.toTypedArray())
		panell1.add(combo)
		val eixir = JButton("Eixir")
		panell1.add(eixir)
		val area = JTextArea()
		panell2.add(JLabel("Llista de punts de la ruta:"),BorderLayout.NORTH)
		panell2.add(area,BorderLayout.CENTER)


		combo.addActionListener() {
			
			
			
			// Sent�ncis quan s'ha seleccionat un element del JComboBox
			// Han de consistir en omplir el JTextArea
			
		}
		
		eixir.addActionListener(){
			// Sent�ncies per a tancar la connexi� i eixir

			con.close()
			System.exit(0)
		}
	}
}

fun main(args: Array<String>) {
	EventQueue.invokeLater {
		Finestra().isVisible = true
	}
}