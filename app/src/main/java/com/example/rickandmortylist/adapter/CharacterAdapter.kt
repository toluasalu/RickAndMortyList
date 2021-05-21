package com.example.rickandmortylist.adapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortylist.R
import com.example.rickandmortylist.model.MyCharacter
import com.squareup.picasso.Picasso

class CharacterAdapter( private val dataset: List<MyCharacter.Result>): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){


    /**
     * Provides a reference for the views needed to display items in your list.
     */
    class CharacterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var imageView:ImageView = view.findViewById(R.id.avatar_view_example)
        var nameTextView:TextView = view.findViewById(R.id.name)
        var statusTextView:TextView = view.findViewById(R.id.status)
        var speciesTextView:TextView = view.findViewById(R.id.species)



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return  CharacterViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        Log.d("Response", "List Count :${dataset.size} ")
        val result = dataset[position]
        Picasso.get().load(result.image).into(holder.imageView)
        holder.nameTextView.text =result.name
        holder.statusTextView.text = result.status
        holder.speciesTextView.text = result.species
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    }



