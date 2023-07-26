package com.alvinem.gameinfoapi_calling.domain

import com.alvinem.gameinfoapi_calling.domain.items.SpecificGameItem
import com.alvinem.gameinfoapi_calling.repo.GameRepository
import javax.inject.Inject

class GetGameByIdUseCase @Inject constructor(
    private val gameRepository: GameRepository
) {
    suspend operator fun invoke(Id:Int) : SpecificGameItem{
        return gameRepository.getGameById(Id)
    }
}