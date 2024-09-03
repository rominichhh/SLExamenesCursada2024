package com.example.examenescursada2024

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class ListadoExamenActivity : AppCompatActivity() {
    lateinit var rvExamenes: RecyclerView
    lateinit var examenesAdapter: ExamenAdapter
    lateinit var toolbar: Toolbar
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listado_examen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.titulo)

        rvExamenes = findViewById(R.id.rvExamenes)


        examenesAdapter = ExamenAdapter(getExamenes(), this)
        rvExamenes.adapter = examenesAdapter
    }

    private fun getExamenes(): MutableList<Examen> {
        var examenes: MutableList<Examen> = ArrayList()
        examenes.add(Examen(1, "Ingenieria de Software 1", "2022-04-05"))
        examenes.add(Examen(2, "Algoritmos y Estructuras de Datos", "2022-04-07"))
        examenes.add(Examen(3, "Prueba de Software", "2022-04-08"))
        examenes.add(Examen(4, "Matematica", "2022-04-10"))
        examenes.add(Examen(5, "Ingenieria de Software 1", "2022-04-05"))
        examenes.add(Examen(6, "Algoritmos y Estructuras de Datos", "2022-04-07"))
        examenes.add(Examen(7, "Prueba de Software", "2022-04-08"))
        examenes.add(Examen(8, "Matematica", "2022-04-10"))
        examenes.add(Examen(9, "Ingenieria de Software 1", "2022-04-05"))
        examenes.add(Examen(10, "Ingenieria de Software 1", "2022-04-05"))
        examenes.add(Examen(11, "Ingenieria de Software 1", "2022-04-05"))
        examenes.add(Examen(12, "Algoritmos y Estructuras de Datos", "2022-04-07"))
        examenes.add(Examen(13, "Prueba de Software", "2022-04-08"))
        examenes.add(Examen(14, "Matematica", "2022-04-10"))
        examenes.add(Examen(15, "Ingenieria de Software 1", "2022-04-05"))
        examenes.add(Examen(16, "Algoritmos y Estructuras de Datos", "2022-04-07"))
        examenes.add(Examen(17, "Prueba de Software", "2022-04-08"))
        examenes.add(Examen(18, "Matematica", "2022-04-10"))
        return examenes

    }
}