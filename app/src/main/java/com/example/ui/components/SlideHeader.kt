package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.SlideItem

@Composable
fun SlideHeader(
    slide: SlideItem,
    totalSlides: Int = 10,
    onOpenSpeakerScript: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        // Metadata row with unboxed text and clean typographic separator
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = String.format("%02d / %02d", slide.id, totalSlides),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = OceanBlue
                )
                Text(
                    text = "·",
                    fontSize = 11.sp,
                    color = Slate400
                )
                Text(
                    text = slide.category.uppercase(),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Slate400,
                    letterSpacing = 0.8.sp
                )
                Text(
                    text = "·",
                    fontSize = 11.sp,
                    color = Slate400
                )
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(3.dp)) {
                    Icon(Icons.Filled.Timer, contentDescription = null, tint = AmberGold, modifier = Modifier.size(12.dp))
                    Text(
                        text = slide.speakerTimeAllocation,
                        fontSize = 10.sp,
                        color = AmberGold,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            // Clean button to open 15-Minute Presenter Speech Script
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFF1E293B))
                    .clickable(onClick = onOpenSpeakerScript)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        Icons.Filled.RecordVoiceOver,
                        contentDescription = null,
                        tint = Color(0xFF38BDF8),
                        modifier = Modifier.size(13.dp)
                    )
                    Text(
                        text = "15-Min Speech Script",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }
        }

        // Slide Title (Clean title case, no code prefixes)
        Text(
            text = slide.title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            lineHeight = 22.sp
        )

        // Subtitle kicker
        Text(
            text = slide.subtitle,
            fontSize = 11.sp,
            color = Color(0xFF94A3B8),
            lineHeight = 14.sp
        )
    }
}
