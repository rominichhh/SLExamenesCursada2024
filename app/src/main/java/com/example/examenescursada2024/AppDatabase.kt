package com.example.examenescursada2024

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Examen::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun examenDao(): ExamenDao

    companion object {
        private var INSTANCIA: AppDatabase? = null
        fun getDatabase(context: Context):AppDatabase {
            if (INSTANCIA == null) {
                synchronized(this){
                    INSTANCIA = Room.databaseBuilder(context,
                        AppDatabase::class.java,"examenes_database"
                    ).allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCIA!!
        }
    }
}