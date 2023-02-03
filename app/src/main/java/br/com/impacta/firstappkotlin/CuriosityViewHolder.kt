package br.com.impacta.firstappkotlin

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CuriosityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleTextView: TextView = itemView.findViewById(R.id.text_view_item_curiosity_title)
    private val descriptionTextView: TextView = itemView.findViewById(R.id.text_view_item_curiosity_description)

    fun bind(curiosity: Curiosity) {
        titleTextView.text = curiosity.title
        descriptionTextView.text = curiosity.description
    }
}
