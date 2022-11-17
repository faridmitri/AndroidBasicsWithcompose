package com.fm.artspaceapp

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fm.artspaceapp.ui.theme.ArtSpaceappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceapp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceapp() {

    val img = arrayOf(R.drawable.img1, R.drawable.img2)
    val desc = arrayOf(R.string.img1Name, R.string.img2Name)
    val year = arrayOf(R.string.img1Year, R.string.img2Year)
    var i by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        DrawImag(img[i], desc[i],
            Modifier
                .border(5.dp, color = Color.Gray)
                .weight(3f))
        Spacer(Modifier.height(10.dp))
        text(
            desc[i], 30, Modifier
                .padding(all = 25.dp)
                .border(1.dp, color = Color.Gray)
                .weight(1f)
        )
        text(
            year[i], 30, Modifier
                .border(1.dp, color = Color.Gray)
        )
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(48.dp)
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Button(onClick = {
                if (i > 0) {
                    i -= 1
                }
            }
            ) {
                Text(stringResource(R.string.previous), fontSize = 24.sp)
            }
            Spacer(modifier = Modifier.size(size = 50.dp))
            Button(onClick = {
                if (i < 2) {
                    i += 1
                }
            }) {
                Text(stringResource(R.string.next), fontSize = 24.sp)
            }

        }
    }

}


@Composable
fun DrawImag(resid: Int, descid: Int, modifier: Modifier) {
    Image(
        painter = painterResource(resid), contentDescription = stringResource(id = descid),
        modifier = modifier
    )
}

@Composable
fun text(desc: Int, font: Int, modifier: Modifier) {
    Text(stringResource(desc), fontSize = font.sp, modifier = modifier)
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceappTheme {
        ArtSpaceapp()
    }
}