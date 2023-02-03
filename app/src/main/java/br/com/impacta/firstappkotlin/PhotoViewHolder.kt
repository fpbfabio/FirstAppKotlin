package br.com.impacta.firstappkotlin

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textView: TextView = itemView.findViewById(R.id.text_view_item_photo_description)
    private val imageView: ImageView = itemView.findViewById(R.id.image_view_item_photo)

    fun bind(photo: Photo) {
        textView.text = photo.description
        Glide.with(itemView.context).load(photo.imageURL).into(imageView)
    }
}
