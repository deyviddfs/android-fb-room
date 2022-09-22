package br.com.fiap.feedbackroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.feedbackroom.database.Aluno

class AlunoAdapter (private val dataSet: List<Aluno>): RecyclerView.Adapter<AlunoAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textViewNome: TextView
        val textViewRm: TextView
        val textViewTurma: TextView

        init {
            textViewNome = view.findViewById(R.id.textViewNome)
            textViewRm = view.findViewById(R.id.textViewRm)
            textViewTurma = view.findViewById(R.id.textViewTurma)
        }
    }

    //Define o layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.recyclerview_item, parent, false)

        return ViewHolder(view)
    }

    //De/para
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val aluno = dataSet[position]
        holder.textViewNome.text = aluno.nome
        holder.textViewRm.text = aluno.rm
        holder.textViewTurma.text = aluno.turma
    }

    //Retorna o tamanho da lista
    override fun getItemCount(): Int {
        return dataSet.size
    }
}