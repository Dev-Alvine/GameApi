package com.alvinem.gameinfoapi_calling.domain.items

import com.alvinem.gameinfoapi_calling.data.remote.model.SpecificGameModel


data class SpecificGameItem (

    val id: Int,
    val thumbnail: String,
    val title: String,
    val description: String

    )

fun SpecificGameModel.toSpecificGameItem() = SpecificGameItem(id, thumbnail,title, description )
