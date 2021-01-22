package com.example.mistplaychallenge.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mistplaychallenge.R
import com.example.mistplaychallenge.models.Category
import com.example.mistplaychallenge.models.CategoryGameTile

class CategoryRecyclerAdapter(
    private val context: Context,
    private val categories: List<Category>)
    : RecyclerView.Adapter< CategoryRecyclerAdapter.CategoryViewHolder > ()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder( LayoutInflater
                .from(context)
                .inflate(R.layout.cat_game_tiles,parent,false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindCategoryTitle(categories.get(position).list_title)
        setGameTilesRecycler(holder.getTilesRecycler(),categories.get(position).games)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    private fun setGameTilesRecycler(recyclerView: RecyclerView, gameTiles: List<CategoryGameTile>){
        val tileRecyclerAdapter = GameTilesRecyclerAdapter(context, gameTiles)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL,false)
        recyclerView.adapter=tileRecyclerAdapter
    }


    class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var categoryTitle: TextView ?= null
        private var gameTilesRecycler : RecyclerView ?= null
        init {
            categoryTitle = itemView.findViewById(R.id.category_title_textview)
            gameTilesRecycler = itemView.findViewById(R.id.category_game_tiles_recycler)
        }

        fun bindCategoryTitle(title:String){
            categoryTitle!!.text=title;
        }
        fun getTilesRecycler():RecyclerView{
            return gameTilesRecycler!!
        }
    }
}

