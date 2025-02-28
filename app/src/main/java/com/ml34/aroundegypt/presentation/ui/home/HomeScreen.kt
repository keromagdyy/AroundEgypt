package com.ml34.aroundegypt.presentation.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.ml34.aroundegypt.presentation.ui.home.WelcomeSection
import com.ml34.aroundegypt.presentation.ui.home.mostRecentExperiences.MostRecentSection
import com.ml34.aroundegypt.presentation.ui.home.mostRecentExperiences.RecentViewModel
import com.ml34.aroundegypt.presentation.ui.home.recommendedExperiences.RecommendedExperiencesSection
import com.ml34.aroundegypt.presentation.ui.home.recommendedExperiences.RecommendedViewModel

@Composable
fun HomeScreen(
    mostRecentViewModel: RecentViewModel = hiltViewModel(),
    recommendedViewModel: RecommendedViewModel = hiltViewModel(),
) {
    val recentList by mostRecentViewModel.getRecentLiveData.observeAsState(emptyList())
    val recommendedList by recommendedViewModel.getRecommendedLiveData.observeAsState(emptyList())

    val isRecentLoading by mostRecentViewModel.isLoading.observeAsState(false)
    val isRecommendedLoading by recommendedViewModel.isLoading.observeAsState(false)

    val isRefreshing = isRecentLoading || isRecommendedLoading

    LaunchedEffect(Unit) {
        mostRecentViewModel.getRecent()
        recommendedViewModel.getRecommended()
    }

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        onRefresh = {
            mostRecentViewModel.getRecent()
            recommendedViewModel.getRecommended()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar({})
            Spacer(modifier = Modifier.height(16.dp))
            WelcomeSection()
            Spacer(modifier = Modifier.height(16.dp))
            RecommendedExperiencesSection(recommendedList)
            Spacer(modifier = Modifier.height(16.dp))
            MostRecentSection(mostRecentItems = recentList)
        }
    }
}
