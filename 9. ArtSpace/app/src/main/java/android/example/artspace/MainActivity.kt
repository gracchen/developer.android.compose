package android.example.artspace

import android.example.artspace.ui.theme.ArtSpaceTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val image = when (result) {
        1 -> R.drawable.art1
        2 -> R.drawable.art2
        3 -> R.drawable.art3
        4 -> R.drawable.art4
        5 -> R.drawable.art5
        6 -> R.drawable.art6
        7 -> R.drawable.art7
        else -> R.drawable.art8
    }
    val title = when (result) {
        1 -> "Kyoto"
        2 -> "Osaka"
        3 -> "Ueno, Tokyo"
        4 -> "Rainbw Japan"
        5 -> "Ship in the Sunset"
        6 -> "Santa Cruz Boardwalk"
        7 -> "Clouds at the dock"
        else -> "Reflections at Night"
    }
    val date = when (result) {
        1 -> "April 2023"
        2 -> "April 2023"
        3 -> "December 2022"
        4 -> "N/A"
        5 -> "N/A"
        6 -> "Summer 2023"
        7 -> "N/A"
        else -> "Summer 2023"
    }

    Column(modifier = modifier
        .fillMaxSize()
        .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Surface(shadowElevation = 9.dp) {
            Image(
                modifier = modifier.padding(30.dp),
                painter = painterResource(image),
                contentDescription = title
            )
        }
        Spacer(modifier = Modifier.height(80.dp))
        Column(
            modifier = modifier
                .background(Color(225, 225, 225))
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = title,
                fontSize = 30.sp,
                modifier = modifier
            )
            Text(
                text = date,
                modifier = modifier
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row {
            Button(modifier = modifier.width(130.dp),
                onClick = { if (result == 1) result = 8 else result-- }
            ) {
                Text("Previous")
            }
            Spacer(modifier = Modifier.width(40.dp))
            Button(modifier = modifier.width(130.dp),
                onClick = { if (result == 8) result = 1 else result++ }
            ) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        Greeting()
    }
}