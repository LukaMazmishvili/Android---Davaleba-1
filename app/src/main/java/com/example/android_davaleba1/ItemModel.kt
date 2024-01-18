package com.example.android_davaleba1

data class Items(
    val items: List<ItemModel>
) {
    data class ItemModel(
        val manufacturer: String,
        val deviceName: String,
        val androidVersion: String,
        val cover: String
    )
}