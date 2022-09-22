package br.com.fiap.feedbackroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.fiap.feedbackroom.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Botão salvar
        binding.buttonSalvar.setOnClickListener {

            Toast.makeText(binding.root.context, R.string.registro_cadastrado_com_sucesso, Toast.LENGTH_LONG).show()
            clearForm()
        }
    }


    private fun clearForm() {
        //Limpa o formulário
        binding.editText1.setText(R.string.vazio)
        binding.editText2.setText(R.string.vazio)
        binding.editText3.setText(R.string.vazio)
        finish()
    }
}