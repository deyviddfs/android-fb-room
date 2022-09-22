package br.com.fiap.feedbackroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fiap.feedbackroom.database.AppDatabase
import br.com.fiap.feedbackroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Carrega o recyclerview
        load()

        //Abre activity do formulário
        binding.buttonForm.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }
    }

    private fun load() {
        val appDb = AppDatabase.getDatabase(binding.root.context)
        val alunos = appDb.alunoDao().getAll()
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        recyclerView.adapter = AlunoAdapter(alunos)

        val itemDecor = DividerItemDecoration(binding.root.context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecor)
    }

    override fun onResume() {
        super.onResume()
        load()
    }
}