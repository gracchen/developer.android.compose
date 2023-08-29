package android.example.businesscard

import android.example.businesscard.ui.theme.BusinessCardTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Grace Chen", "Android Developer Extraordinaire",
                        "+1 (650) 209 2513", "@grace_the_artist",
                        "gracetheartist@g.ucla.edu")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, title: String,
             phoneNumber: String, socialMedia: String,
             email: String,
             modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo) //fetch image

    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = modifier
            .fillMaxWidth()
            .weight(5f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = image, //set as content
                contentDescription = null, //for blind ppl, but since decorative omit
                modifier = modifier.height(110.dp),
                contentScale = ContentScale.FillHeight
            )

            Text(
                text = name,
                fontSize = 42.sp,
                modifier = modifier
            )

            Text(
                text = title,
                fontSize = 14.sp,
                modifier = modifier.padding(top = 8.dp),
                color = Color(3, 135, 72),
                fontWeight = FontWeight.Bold
            )
        }
        Column(modifier = modifier
            .weight(1f),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ){

            var image = painterResource(R.drawable.phone_call) //fetch image
            contactEntry(image, phoneNumber)
            image = painterResource(R.drawable.sharing) //fetch image
            contactEntry(image, socialMedia)
            image = painterResource(R.drawable.mail) //fetch image
            contactEntry(image, email)

        }
    }
}

@Composable
fun contactEntry(icon : Painter, info: String, modifier: Modifier = Modifier) {
    Row (modifier = modifier.padding(6.dp)) {
        Image(
            painter = icon, //set as content
            contentDescription = null, //for blind ppl, but since decorative omit
            modifier = modifier.height(16.dp).padding(end = 12.dp),
            contentScale = ContentScale.FillHeight
        )
        Text(
            text = info,
            fontSize = 16.sp,
            modifier = modifier.padding(start = 12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Greeting("Grace Chen", "Android Developer Extraordinaire",
            "+1 (650) 209 2513", "@grace_the_artist",
            "gracetheartist@g.ucla.edu")
    }
}