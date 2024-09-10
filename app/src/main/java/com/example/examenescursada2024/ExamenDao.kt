package com.example.examenescursada2024

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ExamenDao {

    @Query("select * from examen_entity")
    fun getAll(): List<Examen>

    @Insert
    fun insert(examen: Examen)


}