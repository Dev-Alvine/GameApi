package com.alvinem.gameinfoapi_calling.domain.items

import com.alvinem.gameinfoapi_calling.data.remote.model.GamesModel

data class GameItem(

    val id: Int,
    val thumbnail: String,
    val title: String,
    val short_description: String,

    )

fun GamesModel.toGameItem()= GameItem(id, thumbnail, title, short_description)
