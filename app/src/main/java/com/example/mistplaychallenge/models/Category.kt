package com.example.mistplaychallenge.models

/**
 * Represents Game Category and list of games belonging to it.
 */
data class Category(
    var list_title:String,
    var games: List<CategoryGameTile>) {
}