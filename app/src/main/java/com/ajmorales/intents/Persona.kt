package com.ajmorales.intents
import java.io.Serializable

/**
 *  Created by Antonio J Morales "el colega informático" on 23/05/2020
 *  Puedes ver como se ha realizado esta App : https://www.youtube.com/watch?v=UwQ_QS3Qizc
 *  Si te interesa, subscribete a mi Canal en Youtube: https://www.youtube.com/channel/UC2XTU132H9tHCnM_A3opCzQ
 *
 *  Más información sobre Serializable: https://developer.android.com/reference/kotlin/java/io/Serializable
 */

class Persona (nombre: String, edad:String) : Serializable {

    var nombre : String=""
    var edad : String="0"

    init {  //También se puede poner como Constructor
        this.nombre=nombre
        this.edad=edad
    }
}