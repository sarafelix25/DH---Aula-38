package com.e.revisaowebservice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.revisaowebservice.R
import kotlinx.android.synthetic.main.item_result.view.*
import org.json.JSONObject

class AdapterResult(val listResults: ArrayList<String>) :
    RecyclerView.Adapter<AdapterResult.ResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val result = listResults[position]
        holder.resultado.text = result
    }

    override fun getItemCount() = listResults.size

    inner class ResultViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val resultado: TextView = view.tv_item_result

    }
}