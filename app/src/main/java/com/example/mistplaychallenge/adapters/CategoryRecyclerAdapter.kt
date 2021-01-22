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
import java.util.*

class CategoryRecyclerAdapter(
    private val context: Context,
    private val categories: List<Category>)
    : RecyclerView.Adapter< CategoryRecyclerAdapter.CategoryViewholder > ()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewholder {
        return CategoryViewholder( LayoutInflater
                .from(context)
                .inflate(R.layout.cat_game_row,parent,false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewholder, position: Int) {
        holder.bindCategoryTitle(categories.get(position).list_title)
        setGameRowRecycler(holder.getTilesRecycler(),categories.get(position).games)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    private fun setGameRowRecycler(recyclerView: RecyclerView,gameTiles: List<CategoryGameTile>){
        val tileRecyclerAdapter = GameRowRecyclerAdapter(context, gameTiles)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL,false)
        recyclerView.adapter=tileRecyclerAdapter
    }


    class CategoryViewholder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var categoryTitle: TextView ?= null
        private var gameRow : RecyclerView ?= null
        init {
            categoryTitle = itemView.findViewById(R.id.category_title_textview)
            gameRow = itemView.findViewById(R.id.cat_game_row_recycler)
        }

        fun bindCategoryTitle(title:String){
            categoryTitle!!.text=title;
        }
        fun getTilesRecycler():RecyclerView{
            return gameRow!!
        }
    }
}

