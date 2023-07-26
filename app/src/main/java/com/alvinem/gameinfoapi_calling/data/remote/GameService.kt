package com.alvinem.gameinfoapi_calling.data.remote

import com.alvinem.gameinfoapi_calling.data.remote.model.GamesModel
import com.alvinem.gameinfoapi_calling.data.remote.model.SpecificGameModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject

class GameService @Inject constructor(private val  gameApi: GameApi){
    suspend fun getGames():List<GamesModel>
    {
        return withContext(Dispatchers.IO){
            val games= gameApi.getGames()
            games.body() ?: emptyList()
        }
    }

    suspend fun getGameById(Id:Int): SpecificGameModel{
        return withContext(Dispatchers.IO){
            val game= gameApi.getGameById(Id)
            game.body()!!
        }
    }

}