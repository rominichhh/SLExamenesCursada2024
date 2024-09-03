package com.example.examenescursada2024

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var etNota1: EditText
    lateinit var etNota2: EditText
    lateinit var btnPromedio: Button
    lateinit var tvResultado: TextView
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etNota1 = findViewById(R.id.editNota1)
        etNota2 = findViewById(R.id.editNota2)
        btnPromedio = findViewById(R.id.btnPromedio)
        tvResultado = findViewById(R.id.tvResultado)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = resources.getString(R.string.titulo)

        btnPromedio.setOnClickListener {
            var numero1 = etNota1.text.toString()
            var numero2 = etNota2.text.toString()
            var promedio = (numero1.toInt() + numero2.toInt())/2
            tvResultado.text = promedio.toString()
        }
        saludarUsuario()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_manu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.item_listado){
            val intent = Intent(this, ListadoExamenActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saludarUsuario() {
        val bundle: Bundle? = intent.extras
        if(bundle != null){
            val nombreUsuario = bundle?.getString("NOMBRE")
            Toast.makeText(this, "Bienvenido/a $nombreUsuario", Toast.LENGTH_LONG).show()
        }
    }
}