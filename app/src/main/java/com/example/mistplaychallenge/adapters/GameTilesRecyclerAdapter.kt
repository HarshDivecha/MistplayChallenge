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

/**
 * - Adapter for "Game tiles/Horizontal" RecyclerView
 * - Tobe nested/initialized in "GameCategories/Vertical" RecyclerView
 * - Takes List of CategoryGameTile model objects as input
 */
class GameTilesRecyclerAdapter(
        private val context: Context,
        private val gameTiles: List<CategoryGameTile>
        ) :RecyclerView.Adapter< GameTilesRecyclerAdapter.GameTileViewHolder >()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameTileViewHolder {
        return GameTileViewHolder( LayoutInflater
                .from( context )
                .inflate( R.layout.game_tile_card, parent, false )
        )
    }

    override fun onBindViewHolder(holder: GameTileViewHolder, position: Int) {
        holder.bindImage( gameTiles.get(position).img )
        holder.bindGameTitle( gameTiles.get(position).title )
    }

    override fun getItemCount(): Int {
        return gameTiles.size
    }


    /**
     * Holds views for a game tile consisting of
     * - game Image
     * - game Title
     */
    class GameTileViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        private var gameImage: ImageView? = null
        private var gameTitle: TextView? = null
        init {
            gameImage = itemView.findViewById( R.id.game_image )
            gameTitle = itemView.findViewById( R.id.game_title )
        }

        /**
         * Takes game Image URL as String and binds to game tile ImageView
         */
        fun bindImage( imageUrl: String ){
            Glide.with( itemView )
                    .load( imageUrl )
                    .into( gameImage!! )
        }

        /**
         * Takes game Title as String and binds to game tile TextView
         */
        fun bindGameTitle(title: String){
            gameTitle!!.text = title
            gameImage!!.contentDescription = title
        }
    }
}

