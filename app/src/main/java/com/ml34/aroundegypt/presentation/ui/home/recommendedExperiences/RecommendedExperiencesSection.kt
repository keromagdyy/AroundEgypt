package com.ml34.aroundegypt.presentation.ui.home.recommendedExperiences

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ml34.aroundegypt.data.model.ExperienceModel
import com.ml34.aroundegypt.presentation.ui.home.ExperienceCard

@Composable
fun RecommendedExperiencesSection(recommendedItems: List<ExperienceModel>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Recommended Experiences",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(recommendedItems) { item ->
                ExperienceCard(item)
            }
        }
    }
}
