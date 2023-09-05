package android.example.a6lemonade

import android.example.a6lemonade.ui.theme._6LemonadeTheme
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _6LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DrawScreen(Modifier)
                }
            }
        }
    }
}

@Composable
fun DrawScreen(modifier : Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var tapsLeft by remember { mutableStateOf(-1) }
    val image = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val text = when (result) {
        1 -> stringResource(R.string.tap_instruction)
        2 -> stringResource(R.string.lemon_tap_instruction)
        3 -> stringResource(R.string.drink_instruction)
        else -> stringResource(R.string.restart_instruction)
    }
    val contentDescription = when (result) {
        1 -> stringResource(R.string.lemon_tree)
        2 -> stringResource(R.string.lemon)
        3 -> stringResource(R.string.glass_of_lemonade)
        else -> stringResource(R.string.empty_glass)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = modifier.weight(1f).background(color = Color(249, 228, 76))
            ) {
                Text(
                    text = stringResource(R.string.title),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = modifier.fillMaxWidth().padding(bottom = 20.dp)
                )
            }

        Column(modifier = modifier.weight(12f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Surface(
                color = Color(195, 236, 210),
                shape = RoundedCornerShape(30.dp),
                modifier = modifier.clickable(onClick = {
                    if (result == 4) result = 1
                    else if (result == 2) { //tapped on lemon
                        if (tapsLeft == -1){ //need to set remaining taps
                            tapsLeft = (2..4).random()
                        }
                        tapsLeft-- //count current tap on the lemon
                        if (tapsLeft == 0) {
                            result = 3
                            tapsLeft = -1
                        }
                    }
                    else result++
                })
            ) {
                Image(
                    painter = painterResource(image),
                    contentDescription = contentDescription,
                    modifier = modifier.padding(25.dp).height(200.dp).width(200.dp)
                )
            }

            Text(text = text, modifier = modifier.padding(top = 30.dp))
        }
    }

}

/*@Composable
fun titleScreen() {
    StartScreen(stringResource(R.string.tap_instruction),
        painterResource(R.drawable.lemon_tree),
        stringResource(R.string.lemon_tree),
        Modifier)
}

@Composable
fun lemonScreen() {
    StartScreen(
        stringResource(R.string.lemon_tap_instruction),
        painterResource(R.drawable.lemon_squeeze),
        stringResource(R.string.lemon),
        Modifier)
}

@Composable
fun drinkScreen() {
    StartScreen(
        stringResource(R.string.drink_instruction),
        painterResource(R.drawable.lemon_drink),
        stringResource(R.string.glass_of_lemonade),
        Modifier)
}

@Composable
fun restartScreen() {
    StartScreen(
        stringResource(R.string.restart_instruction),
        painterResource(R.drawable.lemon_restart),
        stringResource(R.string.empty_glass),
        Modifier)
}
*/

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _6LemonadeTheme {
        DrawScreen(modifier = Modifier)
    }
}