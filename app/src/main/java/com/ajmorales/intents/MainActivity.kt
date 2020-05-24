package com.ajmorales.intents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 *  Created by Antonio J Morales "el colega informático" on 23/05/2020
 *  Puedes ver como se ha realizado esta App : https://www.youtube.com/watch?v=UwQ_QS3Qizc
 *  Si te interesa, subscribete a mi Canal de Youtube: https://www.youtube.com/channel/UC2XTU132H9tHCnM_A3opCzQ
 *
 */

class MainActivity : AppCompatActivity() {

    //Companion object (Similar a Static) es para que un objeto, sea común a todas las instancias de esa clase
    companion object{
        var miPersona: Persona ?=null

        fun setPersona(persona:Persona){ this.miPersona=persona }

        fun getNombre() : String { return miPersona!!.nombre }

        fun getEdad() : String {  return miPersona!!.edad }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edNombreCompleto =findViewById<EditText>(R.id.edNombreCompleto)
        val edEdad =findViewById<EditText>(R.id.edEdad)

        //Intent explicito o dirigido a Actividad 2.
        findViewById<Button>(R.id.bEnviar).setOnClickListener {
            miPersona=Persona(edNombreCompleto.text.toString(),edEdad.text.toString())//Inicializamos

            val intent =Intent(this,Actividad2::class.java)
            intent.putExtra("NombreCompleto",edNombreCompleto.text.toString())
            intent.putExtra("Edad",edEdad.text.toString())
            Toast.makeText(applicationContext," Intent explicito putExtra -> Actividad2 ", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        //Intent explicito usando Bundle
        findViewById<Button>(R.id.bEnviar2).setOnClickListener {
            miPersona=Persona(edNombreCompleto.text.toString(),edEdad.text.toString())//Inicializamos

            val intent = Intent(this, Actividad2::class.java)
            intent.putExtra("NombreBundle",edNombreCompleto.text.toString())
            intent.putExtra("EdadBundle",edEdad.text.toString())
            Toast.makeText(applicationContext," Intent explicito Bundle -> Actividad2 ", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        //Pasando el objeto miPersona por intent Serializable
        findViewById<Button>(R.id.bEnviar3).setOnClickListener {
            val miPersona2 = Persona(edNombreCompleto.text.toString(),edEdad.text.toString()) //Inicializo
            setPersona(miPersona2)

            val intent = Intent(this,Actividad2::class.java)
            intent.putExtra("miObjeto",miPersona2) //Paso el objeto mediante un intent
            Toast.makeText(applicationContext," Intent explicito Objeto Serializable", Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        //No enviamos nada por intent, tan solo lo utilizamos para cambiar de actividad y usamos POO
        findViewById<Button>(R.id.bEnviar4).setOnClickListener {
            val miPersona2 = Persona(edNombreCompleto.text.toString(),edEdad.text.toString())
            setPersona(miPersona2)

            Toast.makeText(applicationContext," Utilizando POO Clásica", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Actividad2::class.java)
            startActivity(intent)
        }
    }
}
