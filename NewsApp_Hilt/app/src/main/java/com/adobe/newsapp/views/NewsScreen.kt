package com.adobe.newsapp.views

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adobe.newsapp.R
import com.adobe.newsapp.model.News
import com.adobe.newsapp.viewModel.NewsViewModel

@Composable
fun NewsScreen(modifier: Modifier = Modifier,
               vModel: NewsViewModel = viewModel()) {

    vModel.fetchNews("us")

    val newsListState = vModel.newsList.observeAsState()

    LazyColumn(modifier = modifier.background(Color.Gray)) {

        newsListState.value?.let {
            items(it){ news ->
                NewsItem(news)
            }
        }
        

    }

}

@Composable
fun NewsItem(news: News) {
    val ctx = LocalContext.current
    Card (
        onClick = {
//            Toast.makeText(ctx, "${news.description}",
//                Toast.LENGTH_LONG).show()

            val i = Intent(Intent.ACTION_VIEW,
                Uri.parse(news.url ?: ""))
            ctx.startActivity(i)
        },
        modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Yellow)
    ) {
        Row() {
            Surface {

                Image(
                    painter = painterResource(id = R.drawable.ic_news),
                    contentDescription = "newsimg"
                )
            }
            Column {
                Text(text = news.title ?: "")
                Text(text = news.publishedAt ?: "")
            }
        }
    }
}
