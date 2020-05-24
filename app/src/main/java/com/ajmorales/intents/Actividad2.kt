package com.ajmorales.intents

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


/**
 *  Created by Antonio J Morales "el colega informático" on 23/05/2020
 *  Puedes ver como se ha realizado esta App : https://www.youtube.com/watch?v=UwQ_QS3Qizc
 *  Si te interesa, subscribete a mi Canal de Youtube: https://www.youtube.com/channel/UC2XTU132H9tHCnM_A3opCzQ
 *
 *  Más información sobre intents: https://developer.android.com/guide/components/intents-filters?hl=es#ExampleExplicit
 */

class Actividad2 : AppCompatActivity() {

        //Variables auxiliares, las inicializamos a "" para dejar la pantalla en blanco en caso de no recibir nada
        var varNombre=""
        var varEdad=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)

        //Asignamos las etiquetas textview de nuestro XML activity_actividad2, a vbles para que podamos trabajar con ellas.
        var tvNombreActividad1 = findViewById<TextView>(R.id.tvNombreActividad1)
        var tvEdadAct1 = findViewById<TextView>(R.id.tvEdadAct1)


        //Declaramos un objeto bundle y lo inicializamos tomando el intent previo.
        var b: Bundle? = intent.extras


        //Intent explicito Genérico - Verificamos que no está vacío el contenido
        if(intent?.getStringExtra("NombreCompleto")!=null) {
            varNombre= intent?.getStringExtra("NombreCompleto").toString()
            varEdad= intent?.getStringExtra("Edad").toString()
        }

        //Intent explicito Bundle - Verificamos que no está vacío el contenido
        if(b?.getString("NombreBundle")!=null){
            varNombre = b.getString("NombreBundle").toString() //Only Safe ?
            varEdad = b.getString("EdadBundle").toString()   //Non null asserted !!
        }

        if(intent.getSerializableExtra ("miObjeto")!=null) //Si es verdadero
        {
           val miPersona  = intent.getSerializableExtra ("miObjeto") as Persona
           varNombre=miPersona.nombre
           varEdad=miPersona.edad
        }

        else{ //Utilizando programación orientada a objetos clásica
            varNombre=MainActivity.getNombre()
            varEdad=MainActivity.getEdad()
        }

        //Pintamos el contenido en pantalla
        tvNombreActividad1.text=varNombre
        tvEdadAct1.text=varEdad

        //Log de depuración, para ver en consola (logcat) el contenido de las etiquetas TextView
        Log.d("Nombre : ", tvNombreActividad1.text.toString() + " Edad: "+ tvEdadAct1.text.toString())


        //Cuando pulsemos botón volver, vuelva a la actividad anterior
        findViewById<Button>(R.id.bVolver).setOnClickListener {
            onBackPressed()
        }
    }
}
