package com.example.examenescursada2024

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AgregarExamenActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var etMateria: EditText
    lateinit var etFecha: EditText
    lateinit var btnAgregar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agregar_examen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.titulo)

        etMateria = findViewById(R.id.etMateria)
        etFecha = findViewById((R.id.etFecha))
        btnAgregar = findViewById(R.id.btnGuardar)

        btnAgregar.setOnClickListener {
            var materia = etMateria.text.toString()
            var fecha = etFecha.text.toString()

            if(materia.isEmpty() || fecha.isEmpty()){
                Toast.makeText(this, "Es necesario completar todos los datos", Toast.LENGTH_SHORT).show()
            } else {
                var nuevoExamen = Examen(materia, fecha)
                AppDatabase.getDatabase(applicationContext).examenDao().insert(nuevoExamen)
                var intentListado = Intent(this, ListadoExamenActivity::class.java)
                startActivity(intentListado)
            }
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_volver){
            var intent = Intent(this, ListadoExamenActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}