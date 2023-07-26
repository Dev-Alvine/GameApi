package com.alvinem.gameinfoapi_calling.data.remote

import com.alvinem.gameinfoapi_calling.data.remote.model.GamesModel
import com.alvinem.gameinfoapi_calling.data.remote.model.SpecificGameModel
import com.alvinem.gameinfoapi_calling.util.Constants.Companion.GAMES_ENDPOINT
import com.alvinem.gameinfoapi_calling.util.Constants.Companion.GAME_ID_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApi {

    @GET(GAMES_ENDPOINT)
    suspend fun getGames():Response<List<GamesModel>>

    @GET(GAME_ID_ENDPOINT)
    suspend fun getGameById(@Query(value = "id") id: Int): Response<SpecificGameModel>

}