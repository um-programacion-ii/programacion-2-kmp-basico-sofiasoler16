package org.basic.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kmpbasico.composeapp.generated.resources.Res
import kmpbasico.composeapp.generated.resources.compose_multiplatform


@Composable
fun App() {
    MaterialTheme {
        Navigator(
            screen = MainScreen()
        )
    }
}
class MainScreen: Screen {
    @Composable
    override fun Content() {
            val navigator: Navigator = LocalNavigator.currentOrThrow
            var name: String by remember {mutableStateOf(value = "")}
            var word: String by remember {mutableStateOf(value = "")}
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .safeContentPadding()
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = name,
                    onValueChange = {
                        name = it
                    }
                )

                Spacer(modifier = Modifier.height(50.dp))

                AnimatedVisibility(name.isNotEmpty()) {
                    Text(
                        text = "Version animada: $name",
                        fontSize = 24.sp
                    )
                }

                TextField(
                    value = word,
                    onValueChange = {
                        word = it
                    }
                )

                Spacer(modifier = Modifier.height(70.dp))

                AnimatedVisibility(word.isNotEmpty()) {
                    Text(
                        text = "Version animada: $word",
                        fontSize = 30.sp
                    )
                }
                Spacer(modifier = Modifier.height(70.dp))
                Button(
                    onClick = {
                        navigator.push(SecondScreen())
                    }
                ) {
                    Text(
                        text = "Boton"
                    )

                }

                Spacer(modifier = Modifier.height(70.dp))
                Button(
                    onClick = {
                        navigator.push(ThirdScreen())
                    }
                ) {
                    Text(
                        text = "Tercer pantalla"
                    )

                }

            }

    }
}

class SecondScreen: Screen {

    @Composable
    override fun Content() {
        val navigator: Navigator = LocalNavigator.currentOrThrow
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Segunda pantalla",
                fontSize = 20.sp,
                color = Color.Black
            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            Button(
                onClick = {
                    navigator.pop()
                }
            ) {
                Text(
                    text = "Vamos para atrás"
                )
            }
        }
    }

}

class ThirdScreen: Screen {

    @Composable
    override fun Content() {
        val navigator: Navigator = LocalNavigator.currentOrThrow
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Tercera pantalla",
                fontSize = 20.sp,
                color = Color.Magenta
            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            Button(
                onClick = {
                    navigator.pop()
                }
            ) {
                Text(
                    text = "Vamos para atrás"
                )
            }
        }
    }

}