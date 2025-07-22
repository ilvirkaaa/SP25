package com.example.sp25

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ItemAdapter(
    private val models: MutableList<ItemModel>,
    private val onItemClick: (position: Int) -> Unit,
    private val onImageClick: (position: Int) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ModelViewHolder>() {

    inner class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageViewItem)
        val titleView: TextView = itemView.findViewById(R.id.textViewTitle)
        val descriptionView: TextView = itemView.findViewById(R.id.textViewDescription)

        init {
            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION)
                    onItemClick(adapterPosition)
            }
            imageView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION)
                    onImageClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_model, parent, false)
        return ModelViewHolder(view)
    }

    override fun getItemCount() = models.size

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val model = models[position]
        holder.titleView.text = model.title
        holder.descriptionView.text = model.description

        Glide.with(holder.imageView.context)
            .load(model.imageUrl)
            .placeholder(android.R.color.darker_gray)
            .error(android.R.color.holo_red_dark)
            .centerCrop()
            .into(holder.imageView)
    }

    fun updateImageAt(position: Int, newImageUrl: String) {
        models[position] = models[position].copy(imageUrl = newImageUrl)
        notifyItemChanged(position)
    }

}