package com.ml34.aroundegypt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ml34.aroundegypt.data.model.ExperienceModel
import com.ml34.aroundegypt.ui.RecentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecentScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
}

@Composable
fun RecentScreen(
    viewModel: RecentViewModel = hiltViewModel()
) {
    val recentList by viewModel.getRecentLiveData.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.getRecent()  // Fetch data when the screen loads
    }

    LazyColumn {
        items(recentList) { experience ->
            ExperienceItem(experience)
        }
    }

}
@Composable
fun ExperienceItem(experience: ExperienceModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = experience.title, style = MaterialTheme.typography.h6)
            Text(text = experience.description, style = MaterialTheme.typography.body1)
        }
    }
}

