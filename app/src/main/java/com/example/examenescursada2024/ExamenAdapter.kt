package com.example.examenescursada2024

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExamenAdapter(var examenes: MutableList<Examen>, var context: Context):
    RecyclerView.Adapter<ExamenAdapter.ExamenViewHolder>(){

        class ExamenViewHolder(view: View): RecyclerView.ViewHolder(view) {
            var txtMateria: TextView
            var txtFecha: TextView

            init {
                txtMateria = view.findViewById(R.id.tv_materia)
                txtFecha = view.findViewById(R.id.tv_fecha)
            }

         }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamenViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_examen, parent, false)
        return ExamenViewHolder(view)
    }

    override fun getItemCount() = examenes.size

    override fun onBindViewHolder(holder: ExamenViewHolder, position: Int) {
        val item = examenes.get(position)
        holder.txtMateria.text = item.materia
        holder.txtFecha.text = item.fecha
    }
}