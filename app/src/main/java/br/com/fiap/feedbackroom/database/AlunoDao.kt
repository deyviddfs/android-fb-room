package br.com.fiap.feedbackroom.database

import androidx.room.*

@Dao
interface AlunoDao {
    @Query("SELECT * FROM aluno ORDER BY nome ASC")
    fun getAll(): List<Aluno>

    @Insert
    fun insert(vararg aluno: Aluno)
}