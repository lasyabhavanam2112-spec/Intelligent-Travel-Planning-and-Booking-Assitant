package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Clean architectural palette
val Navy900 = Color(0xFF0F172A)
val Navy800 = Color(0xFF1E293B)
val Navy700 = Color(0xFF334155)
val Slate100 = Color(0xFFF1F5F9)
val Slate200 = Color(0xFFE2E8F0)
val Slate400 = Color(0xFF94A3B8)
val Slate600 = Color(0xFF475569)
val Slate700 = Color(0xFF334155)
val Slate900 = Color(0xFF0F172A)

val OceanBlue = Color(0xFF0284C7)
val OceanLight = Color(0xFFE0F2FE)
val EmeraldGreen = Color(0xFF059669)
val EmeraldLight = Color(0xFFECFDF5)
val CoralRed = Color(0xFFDC2626)
val CoralLight = Color(0xFFFEF2F2)
val AmberGold = Color(0xFFD97706)
val AmberLight = Color(0xFFFFFBEB)
val WarmSand = Color(0xFFF59E0B)

/**
 * Slide 1 Graphic: Realistic visual depiction of travel planning chaos.
 * Displays messy browser tabs, conflicting price alerts, and cognitive anxiety.
 */
@Composable
fun TravelChaosIllustration(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(210.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xFF1E293B), Color(0xFF0F172A))
                )
            )
            .border(1.dp, Color(0xFF334155), RoundedCornerShape(14.dp))
            .padding(14.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Fake browser top window with 8 overlapping chaotic tabs
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .background(Color(0xFF090D16), RoundedCornerShape(6.dp))
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                // Window dots
                Box(Modifier.size(8.dp).clip(RoundedCornerShape(4.dp)).background(CoralRed))
                Box(Modifier.size(8.dp).clip(RoundedCornerShape(4.dp)).background(AmberGold))
                Box(Modifier.size(8.dp).clip(RoundedCornerShape(4.dp)).background(EmeraldGreen))
                Spacer(Modifier.width(8.dp))

                // Overlapping chaotic open tabs
                val tabs = listOf("Skyscanner (Tab 1)", "Booking (Tab 7)", "TripAdvisor (Tab 14)", "Airfare surge!", "Reddit r/Goa", "+19 more tabs")
                tabs.take(4).forEach { tabName ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(if (tabName.contains("surge")) Color(0xFF451A1A) else Color(0xFF1E293B))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = tabName,
                            fontSize = 9.sp,
                            color = if (tabName.contains("surge")) Color(0xFFF87171) else Color(0xFF94A3B8),
                            maxLines = 1
                        )
                    }
                }
            }

            Spacer(Modifier.height(10.dp))

            // Split visual view: Conflicting price spikes and confusion metrics
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Left: Price surge warning card
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFF182234))
                        .border(1.dp, Color(0xFFE11D48).copy(alpha = 0.4f), RoundedCornerShape(10.dp))
                        .padding(10.dp)
                ) {
                    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize()) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Icon(Icons.Filled.Warning, contentDescription = null, tint = CoralRed, modifier = Modifier.size(16.dp))
                            Text("SURGE ALERT DETECTED", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = CoralRed)
                        }
                        Column {
                            Text("Hotel tariff increased by +32%", fontSize = 11.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
                            Text("15 minutes of hesitation caused ₹4,800 loss", fontSize = 10.sp, color = Slate400)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("Status: Decision Paralysis", fontSize = 9.sp, color = AmberGold)
                        }
                    }
                }

                // Right: Cognitive fragmentation metrics
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFF182234))
                        .border(1.dp, Color(0xFF334155), RoundedCornerShape(10.dp))
                        .padding(10.dp)
                ) {
                    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxSize()) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Icon(Icons.Filled.Psychology, contentDescription = null, tint = AmberGold, modifier = Modifier.size(16.dp))
                            Text("COGNITIVE DRAIN", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = AmberGold)
                        }
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text("• 24 disparate web tabs open", fontSize = 10.sp, color = Color.White)
                            Text("• 8.5 hours spent cross-referencing", fontSize = 10.sp, color = Color.White)
                            Text("• Zero flight-to-hotel auto sync", fontSize = 10.sp, color = CoralRed)
                        }
                        Text("Traditional OTA Model Failure", fontSize = 9.sp, color = Slate400)
                    }
                }
            }
        }
    }
}

/**
 * Slide 2 Graphic: Legacy OTA commission trap and disconnected silos diagram.
 */
@Composable
fun LegacyOtaSiloIllustration(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(14.dp))
            .background(Color(0xFF0F172A))
            .border(1.dp, Color(0xFF334155), RoundedCornerShape(14.dp))
            .padding(12.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "LEGACY OTA ECOSYSTEM: WALLED GARDENS & COMMISSIONS",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF94A3B8)
                )
                Text(
                    "18% - 28% Hidden Cut",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = CoralRed
                )
            }

            // 4 Siloed Disconnected Pillars
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val silos = listOf(
                    Triple("Flight Portals", "Rigid seat selection & surge pricing", Icons.Filled.FlightTakeoff),
                    Triple("Hotel OTAs", "Inflated markups & sponsored listings", Icons.Filled.Hotel),
                    Triple("Cab Aggregators", "Zero flight landing sync", Icons.Filled.DirectionsCar),
                    Triple("Review Blogs", "Scattered unverified recommendations", Icons.Filled.RateReview)
                )

                silos.forEach { (title, subtitle, icon) ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(115.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF1E293B))
                            .border(1.dp, Color(0xFF475569), RoundedCornerShape(8.dp))
                            .padding(8.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(icon, contentDescription = null, tint = AmberGold, modifier = Modifier.size(18.dp))
                            Column {
                                Text(title, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.White, maxLines = 1)
                                Text(subtitle, fontSize = 8.sp, color = Slate400, maxLines = 3, lineHeight = 10.sp)
                            }
                            Text("Isolated API", fontSize = 8.sp, color = CoralRed, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }

            // Bottom note
            Text(
                "❌ Problem: If Flight is delayed 3 hrs, Hotels & Cabs do not auto-reschedule. Manual user panic ensues.",
                fontSize = 10.sp,
                color = Color(0xFFCBD5E1),
                maxLines = 1
            )
        }
    }
}

/**
 * Slide 5 Scenic Graphic: Stunning vector illustration of Goa's natural coastal beauty.
 */
@Composable
fun GoaBeachScenicIllustration(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(160.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, Color(0xFF38BDF8).copy(alpha = 0.3f), RoundedCornerShape(12.dp))
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height

            // Sky gradient (warm sunset into azure)
            drawRect(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFFF7E47), Color(0xFFFFAE34), Color(0xFF70C9E8), Color(0xFF0284C7))
                )
            )

            // Warm Golden Sun
            drawCircle(
                color = Color(0xFFFFED8A),
                radius = 32.dp.toPx(),
                center = Offset(w * 0.72f, h * 0.35f)
            )
            // Sun glow
            drawCircle(
                color = Color(0x33FFD54F),
                radius = 48.dp.toPx(),
                center = Offset(w * 0.72f, h * 0.35f)
            )

            // Far cliff (Vagator / Chapora headland)
            val cliffPath = Path().apply {
                moveTo(0f, h * 0.55f)
                cubicTo(w * 0.15f, h * 0.42f, w * 0.32f, h * 0.48f, w * 0.45f, h * 0.65f)
                lineTo(0f, h * 0.65f)
                close()
            }
            drawPath(cliffPath, color = Color(0xFF5D4037))

            // Ocean waves (Arabian Sea)
            drawRect(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF0284C7), Color(0xFF0369A1), Color(0xFF075985))
                ),
                topLeft = Offset(0f, h * 0.55f),
                size = Size(w, h * 0.45f)
            )

            // White foam lines
            drawLine(
                color = Color(0x88FFFFFF),
                start = Offset(0f, h * 0.68f),
                end = Offset(w, h * 0.68f),
                strokeWidth = 2.dp.toPx()
            )
            drawLine(
                color = Color(0x66FFFFFF),
                start = Offset(w * 0.1f, h * 0.76f),
                end = Offset(w * 0.9f, h * 0.76f),
                strokeWidth = 3.dp.toPx()
            )

            // Golden Beach sand shoreline
            val sandPath = Path().apply {
                moveTo(0f, h * 0.82f)
                cubicTo(w * 0.35f, h * 0.75f, w * 0.7f, h * 0.84f, w, h * 0.78f)
                lineTo(w, h)
                lineTo(0f, h)
                close()
            }
            drawPath(
                sandPath,
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFFDE68A), Color(0xFFD97706))
                )
            )

            // Palm tree silhouettes on left
            drawLine(
                color = Color(0xFF1E293B),
                start = Offset(w * 0.12f, h * 0.95f),
                end = Offset(w * 0.16f, h * 0.32f),
                strokeWidth = 4.dp.toPx()
            )
            // Palm fronds
            val trunkX = w * 0.16f
            val trunkY = h * 0.32f
            for (i in -3..3) {
                val angle = i * 22f
                val frondEndX = trunkX + (i * 18).dp.toPx()
                val frondEndY = trunkY - 14.dp.toPx() + (kotlin.math.abs(i) * 6).dp.toPx()
                drawLine(
                    color = Color(0xFF0F172A),
                    start = Offset(trunkX, trunkY),
                    end = Offset(frondEndX, frondEndY),
                    strokeWidth = 2.5.dp.toPx()
                )
            }
        }

        // Overlay Title Pill
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(10.dp)
                .background(Color.Black.copy(alpha = 0.7f), RoundedCornerShape(6.dp))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                "Palolem Crescent Bay & South Goa Coastline",
                color = Color.White,
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

/**
 * Slide 6 Graphic: Heritage & Luxury Hotel visual card.
 */
@Composable
fun HotelVibeVisual(tierName: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xFF0F172A), Color(0xFF1E293B))
                )
            )
            .border(1.dp, Color(0xFF334155), RoundedCornerShape(8.dp))
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Visual badge icon
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        when (tierName) {
                            "Heritage" -> Color(0xFF78350F)
                            "Eco Beachfront" -> Color(0xFF065F46)
                            "Ultra-Luxury" -> Color(0xFF581C87)
                            else -> Color(0xFF1E3A8A)
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    when (tierName) {
                        "Heritage" -> Icons.Filled.Castle
                        "Eco Beachfront" -> Icons.Filled.BeachAccess
                        "Ultra-Luxury" -> Icons.Filled.Diamond
                        else -> Icons.Filled.Apartment
                    },
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "AI Verified Inventory",
                        fontSize = 10.sp,
                        color = EmeraldGreen,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Zero OTA Markups",
                        fontSize = 10.sp,
                        color = AmberGold,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "Direct Amadeus & PMS Real-Time Handshake",
                    fontSize = 11.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Live review sentiment parsed across 10,000+ stays to exclude noisy rooms.",
                    fontSize = 10.sp,
                    color = Slate400,
                    lineHeight = 12.sp
                )
            }
        }
    }
}
