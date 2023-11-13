package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.sharp.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.ui.theme.MyappTheme
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import org.w3c.dom.Comment
import java.lang.Double.toString

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
            }
        }
    }


@Composable
fun MainScreen() {
    val systemUiController: SystemUiController = rememberSystemUiController()

    systemUiController.isStatusBarVisible = false
    systemUiController.isNavigationBarVisible = false
    MyappTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(R.color.c_050B18)
        ) {

            LazyColumn {
                item {
                    Header()
                }
                item {
                    Box (Modifier.padding(0.dp, 20.dp)) { Tags() }
                }
                item {
                    Box(Modifier.padding(20.dp, 5.dp)) { Description() }
                }
                item {
                    Box(Modifier.padding(0.dp, 15.dp)) { Videos() }
                }
                item {
                    Box(Modifier.padding(20.dp, 5.dp, 20.dp, 0.dp)) { ReviewRating() }
                }
                item {
                    Box(Modifier.padding(20.dp, 0.dp)) {
                        Comment()
                        Divider(
                            color = colorResource(R.color.c_1A1F29),
                            modifier = Modifier.padding(13.dp, 140.dp, 13.dp, 26.dp)
                        )
                    }
                }
                item {
                    Box(Modifier.padding(20.dp, 0.dp)) {
                        Comment()
                    }
                }
                item {
                    Box(Modifier.padding(20.dp, 0.dp, 20.dp, 20.dp)) { InstallButton() }
                }
            }
        }
    }
}

@Composable
fun Header() {

    ConstraintLayout {

        val (upperHeader, logo, text) = createRefs()

        Image(
            painter = painterResource(R.drawable.header),
            contentDescription = "header image",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(upperHeader) {}
        )

        Surface(
            modifier = Modifier
                .size(120.dp, 120.dp - 40.dp)
                .padding(20.dp, 0.dp)
                .clip(RoundedCornerShape(15.dp))
                .border(
                    3.dp,
                    color = colorResource(R.color.c_1f2430),
                    RoundedCornerShape(15.dp)
                )
                .constrainAs(logo) {
                    top.linkTo(upperHeader.bottom, margin = (-20).dp)
                },
            color = colorResource(R.color.black),
        ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "logo image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.padding(15.dp, 15.dp)
                )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colorResource(R.color.black).copy(alpha = 0.85f),
                            Color.Transparent,
                        ),
                    )
                ),
        ) { }
        Column(modifier = Modifier
            .constrainAs(text) {
            bottom.linkTo(logo.bottom, margin = 10.dp)
            start.linkTo(logo.end, margin = (-12).dp)
            }
        ) {
            Text(
                text = "DoTA 2",
                color = colorResource(R.color.white),
                fontWeight = FontWeight(700),
                fontSize = 20.sp,
                letterSpacing = 0.5.sp
                )
            Row {
                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "star_1",
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .height(13.dp)
                        .width(13.dp)
                )
                Spacer(Modifier.width(2.dp))
                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "star_2",
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .height(13.dp)
                        .width(13.dp)
                )
                Spacer(Modifier.width(2.dp))
                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "star_3",
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .height(13.dp)
                        .width(13.dp)
                )
                Spacer(Modifier.width(2.dp))
                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "star_4",
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .height(13.dp)
                        .width(13.dp)
                )
                Spacer(Modifier.width(2.dp))
                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "star_5",
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .height(13.dp)
                        .width(13.dp)
                )
                Spacer(Modifier.width(7.dp))
                Text(
                    text = "70M",
                    fontSize = 10.sp,
                    color = colorResource(R.color.c_45454D),
                    letterSpacing = 0.5.sp,
                    fontWeight = FontWeight(400),
                )
            }
        }
    }
}

@Composable
fun Tags(tags : List<String> = listOf(
    "MOBA",
    "MULTIPLAYER",
    "STRATEGY",
    "MOBA",
    "MULTIPLAYER",
    "STRATEGY",
)) {
    Column {
        LazyRow {
            item {Spacer(Modifier.width(20.dp))}
            items(tags) { tag ->
                Surface(
                    color = colorResource(R.color.c_44A9F4).copy(alpha = 0.24f),
                    modifier = Modifier.clip(RoundedCornerShape(20.dp))
                ) {
                    Text(
                        modifier = Modifier.padding(10.dp, 5.dp),
                        text = tag,
                        color = colorResource(R.color.c_44A9F4),
                        fontSize = 10.sp,
                        fontWeight = FontWeight(500)
                    )
                }
                Spacer(Modifier.width(10.dp))
            }
            item {Spacer(Modifier.width(10.dp))}
        }
    }
}

@Composable
fun Description(text : String = "Dota 2 is a multiplayer online " +
        "battle arena (MOBA) game which has two teams of " +
        "five players compete to collectively destroy a " +
        "large structure defended by the opposing team" +
        " known as the \"Ancient\", whilst defending their own.") {
    Text(
        text = text,
        color = colorResource(id = R.color.c_B2EEF2FB),
        fontSize = 12.sp,
        lineHeight = 19.sp,
        fontWeight = FontWeight(400)
    )
}

@Composable
fun Videos(videos : List<Int> = listOf(
    R.drawable.dota_video,
    R.drawable.dota_video
)) {
    LazyRow {
        item {Spacer(Modifier.width(20.dp))}
        items(videos) { video ->
            Image(
                painter = painterResource(id = video),
                contentDescription = "video_$video",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(220.dp, 120.dp)
                    .clip(RoundedCornerShape(15.dp))
            )
            Spacer(Modifier.width(15.dp))
        }
        item {Spacer(Modifier.width(5.dp))}
    }
}


@Composable
fun ReviewRating(rating : Double = 4.9) {

    Text(
        text = "Review & Ratings",
        fontSize = 16.sp,
        fontWeight = FontWeight(700),
        color = Color(0xFFEEF2FB),
        letterSpacing = 0.6.sp,
    )
    Row (Modifier.padding(0.dp, 25.dp, 0.dp, 15.dp)) {
        Text(
            text = rating.toString(),
            fontSize = 48.sp,
            fontWeight = FontWeight(700),
            color = Color(0xFFFFFFFF),
        )
        Column (Modifier.padding(14.dp, 18.dp)) {
            Row {
                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "star_1",
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .height(13.dp)
                        .width(13.dp)
                )
                Spacer(Modifier.width(2.dp))
                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "star_2",
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .height(13.dp)
                        .width(13.dp)
                )
                Spacer(Modifier.width(2.dp))
                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "star_3",
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .height(13.dp)
                        .width(13.dp)
                )
                Spacer(Modifier.width(2.dp))
                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "star_4",
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .height(13.dp)
                        .width(13.dp)
                )
                Spacer(Modifier.width(2.dp))
                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "star_half_1",
                    colorFilter = ColorFilter.tint(Color.Yellow),
                    modifier = Modifier
                        .height(13.dp)
                        .width(13.dp)
                )
                Spacer(Modifier.width(2.dp))
            }
            Spacer(Modifier.height(6.dp))
            Text(
                text = "70M Reviews",
                fontSize = 12.sp,
                color = Color(0xFFA8ADB7),
                letterSpacing = 0.5.sp,
                fontWeight = FontWeight(400),
            )
        }
    }
}

@Composable
fun Comment() {
    Row {
        Column (Modifier.padding(0.dp, 4.dp)){
            Image (
                painter = painterResource(R.drawable.com_pic),
                contentDescription = "com_pic",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
            )
        }
        Column(Modifier.padding(16.dp, 0.dp)) {
            Text(
                text = "Auguste Conte",
                fontSize = 16.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFFFFFFFF),
                letterSpacing = 0.5.sp,
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "February 14, 2019",
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                color = Color(0x66FFFFFF),
                letterSpacing = 0.5.sp,
            )
        }

    }
    Row (Modifier.padding(0.dp, 56.dp, 0.dp, 30.dp)) {
        Text(
            text = "“Once you start to learn its secrets, there’s a wild" +
                    " and exciting variety of play here that’s unmatched," +
                    " even by its peers.”",
            fontSize = 12.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight(400),
            color = Color(0xFFA8ADB7),
            letterSpacing = 0.5.sp,
        )
    }
}

@Composable
fun InstallButton() {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFF4D144)),
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
        ) {
        Text(
            text = "Install",
            fontSize = 20.sp,
            fontWeight = FontWeight(700),
            color = Color(0xFF050B18),
            letterSpacing = 0.6.sp,
        )
    }
}


@Preview
@Composable
fun RatingReviewsPreview() {
    ReviewRating()
}


@Preview
@Composable
fun CommentPreview() {
    Comment()
}


@Preview
@Composable
fun VideosPreview() {
    Videos()
}


@Preview
@Composable
fun DescriptionPreview() {
    Description()
}

@Preview
@Composable
fun HeaderPreview() {
    Header()
}

@Preview
@Composable
fun TagsPreview() {
    Tags()
}


