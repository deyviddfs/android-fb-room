package br.com.fiap.feedbackroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Aluno::class], version = 1)
abstract class AppDatabase: RoomDatabase(){

    abstract fun alunoDao(): AlunoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "database_fb_room")
                    .allowMainThreadQueries() //Possibilita execução de operações de banco de dados na MainThread, não deve ser executado em produção
                    .fallbackToDestructiveMigration()//Habilita destruição do banco e criação de um novo a cada upgrade do modelo
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}