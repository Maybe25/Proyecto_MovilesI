package com.proyecto.veterinaria_app.models

import java.util.*

data class ConsultaMedica(
    val idConsulta: String = "",
    val petName: String = "",
    val petWeight: Int = 0,
    val nombreCliente: String = "",
    val fechaConsulta: String = "",
    val descripcion: String = "",
)