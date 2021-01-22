package com.example.mistplaychallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mistplaychallenge.adapters.CategoryRecyclerAdapter
import com.example.mistplaychallenge.helpers.Utils
import com.example.mistplaychallenge.models.Category
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    private var gameCategoryRecyclerView : RecyclerView? =null
    private var gameCategoryRecyclerAdapter : CategoryRecyclerAdapter? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setGameCategoryRecycler()
    }

    private fun setGameCategoryRecycler(){
        val gson = Gson()
        val utils = Utils()

        val toType = object : TypeToken<List<Category>>(){}.type
        val jsonStr = utils.getJsonFromAsset(applicationContext,"mistplay_games.json")

        val categories: List<Category> = gson.fromJson(jsonStr, toType)
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)

        gameCategoryRecyclerView = findViewById(R.id.game_category_recycler)
        gameCategoryRecyclerAdapter = CategoryRecyclerAdapter(applicationContext,categories)
        gameCategoryRecyclerView!!.layoutManager = layoutManager
        gameCategoryRecyclerView!!.adapter = gameCategoryRecyclerAdapter
    }
}