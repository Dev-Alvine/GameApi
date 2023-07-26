package com.alvinem.gameinfoapi_calling.domain

import com.alvinem.gameinfoapi_calling.domain.items.GameItem
import com.alvinem.gameinfoapi_calling.repo.GameRepository
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(private  val gameRepository: GameRepository) {
    suspend operator fun invoke(): List<GameItem>{
        return gameRepository.getGames().shuffled()
    }
}