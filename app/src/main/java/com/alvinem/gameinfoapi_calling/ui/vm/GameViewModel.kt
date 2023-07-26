package com.alvinem.gameinfoapi_calling.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvinem.gameinfoapi_calling.domain.GetGameByIdUseCase
import com.alvinem.gameinfoapi_calling.domain.GetGamesUseCase
import com.alvinem.gameinfoapi_calling.domain.items.GameItem
import com.alvinem.gameinfoapi_calling.domain.items.SpecificGameItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getGamesUseCase : GetGamesUseCase,
    private val getGamesByIdUseCase : GetGameByIdUseCase
) : ViewModel() {
    private val _games= MutableLiveData<List<GameItem>>()
    val  games :LiveData<List<GameItem>> get() = _games

    private val _game= MutableLiveData<SpecificGameItem>()
    val game :LiveData<SpecificGameItem> get() = _game

    init {
        getGames()
    }

    private fun getGames(){
        viewModelScope.launch {
            try {
                val games =getGamesUseCase()
                _games.value= games

            }catch (_: Exception){

            }
        }
    }

    fun  getGameById(Id:Int){
        viewModelScope.launch {
            try {
                val game= getGamesByIdUseCase(Id)
                _game.value= game
            }catch (_: Exception){

            }
        }
    }
}