package main.kotlin.com.paysys.server.model

import javax.persistence.*

@Entity(name = "Merchandise")
data class Merchendise(

        //barcode
        @Id
        var id:Int =0,

        val name:String = "",

        val price:Int = -1


)