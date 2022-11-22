package com.example.searchid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.searchid.api.Reports

class ReportsAdapter(val reports: MutableList<Reports>): RecyclerView.Adapter<ReportsVieHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportsVieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.report_layout, parent, false)
        return ReportsVieHolder(view)
    }

    override fun onBindViewHolder(holder: ReportsVieHolder, position: Int) {
        return holder.bindView(reports[position])
    }

    override fun getItemCount(): Int {
        return reports.size
    }
}


class ReportsVieHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    private val rptype: TextView = itemView.findViewById(R.id.reported_type)

    fun bindView(reports: Reports){
        rptype.text = reports.document_number

    }
}