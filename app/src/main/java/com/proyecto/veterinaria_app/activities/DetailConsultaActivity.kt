package com.proyecto.veterinaria_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.proyecto.veterinaria_app.R
import com.proyecto.veterinaria_app.models.ConsultaMedica

class DetailConsultaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_consulta)
        readDatabase()
    }

    private fun readDatabase() {
        val database = Firebase.database
        val data = database.reference

        Firebase.auth.currentUser?.let {
            data.child("consultas").child(it.uid).child("id1").addValueEventListener(object:ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val response=  snapshot.getValue<ConsultaMedica>();// snapshot.getValue(ConsultaMedica::class.java)
                    println("prueba")
                    println(response?.nombreCliente)
                    println(response?.fechaConsulta)
                    println(response?.descripcion)
                    println(response?.petName)
                    println(response?.petWeight)

                }

                override fun onCancelled(error: DatabaseError) {
                    println("no entro pe chorri")
                    println(error.message)
                }


            })
        }




    }

}