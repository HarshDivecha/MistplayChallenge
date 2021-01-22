package com.example.mistplaychallenge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mistplaychallenge.R
import com.example.mistplaychallenge.models.CategoryGameTile

class GameTilesRecyclerAdapter(
        private val context: Context,
        private val gameTiles: List<CategoryGameTile>)
    :RecyclerView.Adapter< GameTilesRecyclerAdapter.GameTileViewHolder >()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameTileViewHolder {
        return GameTileViewHolder( LayoutInflater
                .from(context)
                .inflate(R.layout.game_tile_card,parent,false)
        )
    }

    override fun onBindViewHolder(holder: GameTileViewHolder, position: Int) {
        holder.bindPhoto(gameTiles.get(position).img)
        holder.bindGameTitle(gameTiles.get(position).title)
    }

    override fun getItemCount(): Int {
        return gameTiles.size
    }


    class GameTileViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        private var gameImage: ImageView? = null
        private var gameTitle: TextView? = null
        init {
            gameImage = itemView.findViewById(R.id.game_image)
            gameTitle = itemView.findViewById(R.id.game_title)
        }

        fun bindPhoto(photoUrl: String){
            Glide.with(itemView)
                    .load(photoUrl)
                    .into(gameImage!!)
        }

        fun bindGameTitle(title: String){
            gameTitle!!.text = title
        }
    }
}

