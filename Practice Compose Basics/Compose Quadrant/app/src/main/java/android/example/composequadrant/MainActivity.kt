package android.example.composequadrant

import android.example.composequadrant.ui.theme.ComposeQuadrantTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
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
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {

        Row(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
        ) {
            Surface (
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                color = Color(0xFFEADDFF) // Change background color
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Text composable", fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp))
                    Text(text = "Displays text and follows the recommended Material Design guidelines.",
                        textAlign = TextAlign.Justify)
                }
            }
            Surface (
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                color = Color(0xFFD0BCFF) // Change background color
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Image composable", fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp))
                    Text(text = "Creates a composable that lays out and draws a given Painter class object.",
                        textAlign = TextAlign.Justify)
                }
            }
        }

        Row(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
        ) {
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                color = Color(0xFFB69DF8) // Change background color
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Row composable", fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp))
                    Text(text = "A layout composable that places its children in a horizontal sequence.",
                        textAlign = TextAlign.Justify)
                }
            }
            Surface(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                color = Color(0xFFF6EDFF) // Change background color
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Column composable", fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp))
                    Text(text = "A layout composable that places its children in a vertical sequence.",
                        textAlign = TextAlign.Justify)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Greeting()
    }
}