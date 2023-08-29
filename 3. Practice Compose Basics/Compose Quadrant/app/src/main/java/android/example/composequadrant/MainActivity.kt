package android.example.composequadrant

import android.example.composequadrant.ui.theme.ComposeQuadrantTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.stringResource
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
                    Display()
                }
            }
        }
    }
}

@Composable
fun Display(modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {

        Row(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
        ) {
            InfoCard(
                stringResource(R.string.text_title), stringResource(R.string.text_description),
                Color(0xFFEADDFF) , Modifier.weight(1f))

            InfoCard(
                stringResource(R.string.image_title), stringResource(R.string.image_description),
                Color(0xFFD0BCFF) , Modifier.weight(1f))
        }

        Row(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
        ) {
            InfoCard(
                stringResource(R.string.row_title), stringResource(R.string.row_description),
                Color(0xFFB69DF8) , Modifier.weight(1f))

            InfoCard(
                stringResource(R.string.col_title), stringResource(R.string.col_description),
                Color(0xFFF6EDFF) , Modifier.weight(1f))
        }
    }
}
@Composable
fun InfoCard(
    title: String, description: String, backgroundColor: Color, modifier: Modifier = Modifier
) {
    Surface (
        modifier = modifier
            .fillMaxSize(),
        color = backgroundColor// Change background color
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp))
            Text(text = description,
                textAlign = TextAlign.Justify)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Display()
    }
}