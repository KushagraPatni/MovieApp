package com.example.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.bawp.movieapp.model.Movie
import com.bawp.movieapp.model.getMovies

@Preview
@Composable
fun MovieRow(movie: Movie= getMovies()[0],
             onItemClick: (String)->Unit={}){
    var expanded = remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        //.height(130.dp)
        .shadow(6.dp)
        .clickable {
            onItemClick(movie.id)
        },
        shape = RoundedCornerShape(corner = CornerSize(12.dp))
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start) {
            Surface(modifier = Modifier
                .shadow(5.dp)
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape
            ) {

                val painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(movie.poster)
                        .crossfade(true)
                        .transformations(CircleCropTransformation())
                        .build()
                )
                Image(painter = painter ,contentDescription ="Movie Poster")

            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(text = movie.title,
                    style = MaterialTheme.typography.titleLarge)

                Text(text = "Director: ${movie.title}",
                    style =MaterialTheme.typography.labelSmall )

                Text(text = "Released: ${movie.title}",
                    style =MaterialTheme.typography.labelSmall )
                AnimatedVisibility(visible = expanded.value) {

                Column {
                    Text(buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.DarkGray,
                            fontSize = 13.sp)){
                            append("PLot: ")
                        }
                        withStyle(style = SpanStyle(color = Color.DarkGray,
                            fontSize = 13.sp,fontWeight = FontWeight.Light)){
                            append(movie.plot)
                        }

                    }, modifier = Modifier.padding(6.dp))
                    Divider(modifier = Modifier.padding(3.dp))
                    Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Actors: ${movie.actors}", style = MaterialTheme.typography.bodySmall)
                    Text(text = "Rating: ${movie.rating}", style = MaterialTheme.typography.bodySmall)
                }
                }

                Icon(imageVector = if(expanded.value) Icons.Filled.KeyboardArrowUp
                    else Icons.Filled.KeyboardArrowDown,
                    contentDescription ="Down Arrow",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expanded.value = !expanded.value
                        },
                    tint = Color.DarkGray)
            }
        }
    }
}