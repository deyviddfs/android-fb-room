package br.com.fiap.feedbackroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.fiap.feedbackroom.database.Aluno
import br.com.fiap.feedbackroom.database.AppDatabase
import br.com.fiap.feedbackroom.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Botão salvar
        binding.buttonSalvar.setOnClickListener {
            val appDb = AppDatabase.getDatabase(binding.root.context)
            val nome = binding.editTextNome.text.toString()
            val rm = binding.editTextRm.text.toString()
            val ano = ""
            val turma = binding.editTextTurma.text.toString()
            val aluno = Aluno(0, nome, rm, ano, turma)
            appDb.alunoDao().insert(aluno)

            Toast.makeText(binding.root.context, R.string.registro_cadastrado_com_sucesso, Toast.LENGTH_LONG).show()
            clearForm()
        }
    }


    private fun clearForm() {
        //Limpa o formulário
        binding.editTextNome.setText(R.string.vazio)
        binding.editTextRm.setText(R.string.vazio)
        binding.editTextTurma.setText(R.string.vazio)
        finish()
    }
}