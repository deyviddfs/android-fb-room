package br.com.fiap.feedbackroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (private val dataSet: List<String>): RecyclerView.Adapter<ItemAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textView1: TextView
        val textView2: TextView
        val textView3: TextView

        init {
            textView1 = view.findViewById(R.id.textView1)
            textView2 = view.findViewById(R.id.textView2)
            textView3 = view.findViewById(R.id.textView3)
        }
    }

    //Define o layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.recyclerview_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    //Retorna o tamanho da lista
    override fun getItemCount(): Int {
        return dataSet.size
    }
}