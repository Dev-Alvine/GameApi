package com.alvinem.gameinfoapi_calling.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.alvinem.gameinfoapi_calling.ui.vm.GameViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    id:String,
    gameViewModel: GameViewModel,
    navController: NavController) {
    gameViewModel.getGameById(id.toInt())
    val game = gameViewModel.game.observeAsState().value

    LazyColumn {
        item {
            Column {
                TopAppBar(

                    navigationIcon = {

                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                        }

                    },

                    title = {

                        Text(text = game?.title ?: "", fontWeight = FontWeight.Bold)

                    }

                )

                Image(
                    painter = rememberImagePainter(game?.thumbnail),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxWidth().height(300.dp)
                )

                Text(text = game?.description ?: "", modifier = Modifier.padding(10.dp))

            }

        }
    }
}