package main.kotlin.com.paysys.server.model


import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


@Entity
@Table(name="Costumer")
data class Costumer (

        //RFID
        @Id
        @Column(name = "id", unique = true, nullable = false)
        @NotNull
        @Size(min = 3, max = 32)
        val id: Int = 0,

        val name: String = "",

        val phone: Int = 0,

        val balance: Int = 0,

        val score: Double


)