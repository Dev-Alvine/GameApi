package com.alvinem.gameinfoapi_calling.repo

import com.alvinem.gameinfoapi_calling.data.remote.GameService
import com.alvinem.gameinfoapi_calling.domain.items.GameItem
import com.alvinem.gameinfoapi_calling.domain.items.SpecificGameItem
import com.alvinem.gameinfoapi_calling.domain.items.toGameItem
import com.alvinem.gameinfoapi_calling.domain.items.toSpecificGameItem
import javax.inject.Inject

class GameRepository  @Inject constructor(private val  gameService: GameService){

    suspend fun getGames(): List<GameItem>{
        return gameService.getGames().map {
            it.toGameItem()

        }
    }

    suspend fun getGameById(Id:Int) :SpecificGameItem{
        return gameService.getGameById(Id).toSpecificGameItem()
    }

}