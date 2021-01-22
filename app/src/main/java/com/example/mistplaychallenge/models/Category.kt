package com.example.mistplaychallenge.models

data class Category(
    var list_title:String,
    var games: List<CategoryGameTile>) {
}