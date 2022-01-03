package com.example.sunmadinepal.framework.data

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sunmadinepal.R
import com.example.sunmadinepal.model.RecipesData
import com.example.sunmadinepal.ui.fragment.recipes.InsideRecipes


class CustomAdapter(private val mList: List<RecipesData>, val parent: ViewGroup?) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view =
            LayoutInflater.from(parent?.context).inflate(R.layout.recipedetails, parent, false)

        return ViewHolder(view)
    }


    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
/*
        Glide.with(parent?.context!!)
            .load(mList.get(position).getItemImage())
            .into( holder.imageView)*/
        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(mList.get(position).getItemImage())

        // sets the text to the textview from our itemHolder class
        holder.textView.text = mList.get(position).itemName //ItemsViewModel.itemName
        holder.textViewt.text = mList.get(position).itemDescription //ItemsViewModel.itemDescription


        holder.imageView.setOnClickListener { v ->
            val intent = Intent(v.context, InsideRecipes::class.java)
            // intent.putExtra("Image",mList.get(position).getItemImage())
            intent.putExtra("Image", mList.get(holder.bindingAdapterPosition).getItemImage())
            intent.putExtra("Title", mList.get(holder.bindingAdapterPosition).getItemName())
            intent.putExtra("Description",
                mList.get(holder.bindingAdapterPosition).getItemDescription())
            v.context.startActivity(intent)
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.IvImage)
        val textView: TextView = itemView.findViewById(R.id.tvTitle)
        val textViewt: TextView = itemView.findViewById(R.id.tvDescription)

    }


}




