package com.example.searchid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.searchid.api.Documents

class DocumentsAdapter(val documents: MutableList<Documents>): RecyclerView.Adapter<DocumentsVieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentsVieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.docu_layout, parent, false)
        return DocumentsVieHolder(view)
    }

    override fun onBindViewHolder(holder: DocumentsVieHolder, position: Int) {
        return holder.bindView(documents[position])
    }

    override fun getItemCount(): Int {
        return documents.size
    }
}


class DocumentsVieHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val dctype: TextView = itemView.findViewById(R.id.document_type)
    private val dctnum: TextView = itemView.findViewById(R.id.document_number)

    fun bindView(documents: Documents){
        dctype.text = documents.document_type
        dctnum.text = documents.numero_id

    }
}