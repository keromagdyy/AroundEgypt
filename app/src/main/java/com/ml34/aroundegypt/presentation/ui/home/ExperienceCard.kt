package com.ml34.aroundegypt.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ml34.aroundegypt.R
import com.ml34.aroundegypt.data.model.ExperienceModel
import com.ml34.aroundegypt.presentation.theme.black
import com.ml34.aroundegypt.presentation.theme.gray
import com.ml34.aroundegypt.presentation.theme.orange
import com.ml34.aroundegypt.presentation.theme.white

@Composable
fun ExperienceCard(item: ExperienceModel) {
    Card(
        modifier = Modifier
            .width(350.dp) // Adjust width to fit design
            .height(200.dp) // Fixed height
            .clip(RoundedCornerShape(12.dp))
            .clickable { /* Handle Click */ },
        colors = CardDefaults.cardColors(containerColor = white), // Set background to white
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Box(modifier = Modifier.height(140.dp)
                .fillMaxWidth()
            ) {
                // Background Image
                AsyncImage(
                    model = item.coverPhoto,
                    contentDescription = item.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp) // Adjust height to maintain aspect ratio
                )

                // Overlays
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    // Recommended Badge
                    if (item.recommended == 1) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .background(black.copy(alpha = 0.6f), shape = RoundedCornerShape(8.dp))
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = "RECOMMENDED",
                                color = white,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    // Info Button (Top-Right)
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = "Info",
                        tint = white,
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .size(24.dp)
                            .background(black.copy(alpha = 0.5f), CircleShape)
                            .padding(4.dp)
                    )

                    // View Count (Bottom-Left)
                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .background(black.copy(alpha = 0.6f), shape = RoundedCornerShape(8.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_eye),
                            contentDescription = "Views",
                            tint = white,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = item.viewsNo.toString(), color = white)
                    }
                }
            }

            // Title & Views Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = item.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Text(text = item.likesNo.toString(), fontSize = 14.sp, color = gray)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    imageVector = if (item.isLiked) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = "Like",
                    tint = orange,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}
