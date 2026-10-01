package com.example.ui.slides

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PresentationRepository
import com.example.model.*
import com.example.ui.components.*

/**
 * Slide 1: Problem Statement
 */
@Composable
fun Slide1ProblemStatement(
    slide: SlideItem,
    onOpenSpeakerScript: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            SlideHeader(slide = slide, onOpenSpeakerScript = onOpenSpeakerScript)
        }

        // Realistic Visual of Trouble Scene
        item {
            TravelChaosIllustration()
        }

        // Trouble Vectors
        item {
            Text(
                "CORE FRICTION VECTORS IDENTIFIED",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = OceanBlue
            )
        }

        items(PresentationRepository.travelTroublePoints) { point ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF1E293B))
                    .border(1.dp, Color(0xFF334155), RoundedCornerShape(8.dp))
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF451A1A)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Filled.Warning, contentDescription = null, tint = CoralRed, modifier = Modifier.size(18.dp))
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(point.title, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            Text(point.stat, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = AmberGold)
                        }
                        Text(point.description, fontSize = 9.5.sp, color = Slate400, lineHeight = 12.sp)
                    }
                }
            }
        }

        // Bottom takeaway box
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF0F172A))
                    .border(1.dp, Color(0xFF0284C7).copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                    .padding(10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(Icons.Filled.Lightbulb, contentDescription = null, tint = AmberGold, modifier = Modifier.size(18.dp))
                    Text(
                        "Goal: Shift tourism from human cognitive exhaustion into an autonomous agent that reasons, balances budgets, and books directly.",
                        fontSize = 10.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

/**
 * Slide 2: Existing Systems & Flaws
 */
@Composable
fun Slide2ExistingFlaws(
    slide: SlideItem,
    onOpenSpeakerScript: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            SlideHeader(slide = slide, onOpenSpeakerScript = onOpenSpeakerScript)
        }

        item {
            LegacyOtaSiloIllustration()
        }

        item {
            Text(
                "SYSTEMIC ARCHITECTURAL GAPS: TRADITIONAL OTAS VS AI AGENT",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = OceanBlue
            )
        }

        // Comparison Table Rows
        val comparisons = listOf(
            Triple("Architecture", "Monolithic Search Directories", "Autonomous Multi-Agent System"),
            Triple("Pricing Model", "18-28% Hidden OTA Markup", "Zero Commission Direct GDS Access"),
            Triple("Rerouting", "Zero adaptation during flight delay", "Dynamic, real-time schedule refactoring"),
            Triple("Personalization", "Generic sponsored rankings", "Hyper-personalized context & review ABSA")
        )

        items(comparisons) { (metric, traditional, intelligent) ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF1E293B))
                    .border(1.dp, Color(0xFF334155), RoundedCornerShape(8.dp))
                    .padding(10.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(metric, fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Slate400)
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Traditional OTA", fontSize = 8.5.sp, color = CoralRed, fontWeight = FontWeight.SemiBold)
                            Text(traditional, fontSize = 10.sp, color = Color(0xFFCBD5E1))
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Our AI Agent", fontSize = 8.5.sp, color = EmeraldGreen, fontWeight = FontWeight.SemiBold)
                            Text(intelligent, fontSize = 10.sp, color = Color.White, fontWeight = FontWeight.Medium)
                        }
                    }
                }
            }
        }
    }
}

/**
 * Slide 3: Multi-Agent Architecture Solution
 */
@Composable
fun Slide3AiArchitecture(
    slide: SlideItem,
    onOpenSpeakerScript: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            SlideHeader(slide = slide, onOpenSpeakerScript = onOpenSpeakerScript)
        }

        item {
            MultiAgentArchitectureDiagram()
        }

        item {
            Text(
                "WHY MULTI-AGENT ARCHITECTURE MATTERS",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = OceanBlue
            )
        }

        val benefits = listOf(
            Triple("Separation of Concerns", "Decouples pricing math from geographic routing, reducing hallucinations by 87%.", Icons.Filled.DeviceHub),
            Triple("Deterministic Guardrails", "Budgets and check-in dates are mathematical invariants, not fuzzy LLM guesses.", Icons.Filled.Security),
            Triple("Idempotent Transactions", "Direct supplier API tokens guarantee user accounts are never double charged.", Icons.Filled.Lock)
        )

        items(benefits) { (title, desc, icon) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF1E293B))
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier.size(32.dp).clip(RoundedCornerShape(6.dp)).background(Color(0xFF0369A1)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(title, fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Text(desc, fontSize = 9.5.sp, color = Slate400, lineHeight = 12.sp)
                }
            }
        }
    }
}

/**
 * Slide 4: AI Logic Flow & Pipeline
 */
@Composable
fun Slide4LogicFlow(
    slide: SlideItem,
    onOpenSpeakerScript: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            SlideHeader(slide = slide, onOpenSpeakerScript = onOpenSpeakerScript)
        }

        item {
            AiLogicFlowDiagram()
        }

        item {
            Text(
                "FAULT TOLERANCE & DYNAMIC COMPENSATION",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = OceanBlue
            )
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF1E293B))
                    .border(1.dp, Color(0xFF334155), RoundedCornerShape(8.dp))
                    .padding(12.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Icon(Icons.Filled.SyncProblem, contentDescription = null, tint = AmberGold, modifier = Modifier.size(16.dp))
                        Text("Autonomous Self-Healing Loop", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    }
                    Text(
                        "If a boutique property gets booked by a third party while the user confirms, the Hospitality Agent triggers a zero-delay substitute search within 400ms, preserving price and location parameters without resetting the user session.",
                        fontSize = 10.sp,
                        color = Slate400,
                        lineHeight = 14.sp
                    )
                }
            }
        }
    }
}

/**
 * Slide 5: Places Discovery & Natural Goa
 */
@Composable
fun Slide5PlacesDiscovery(
    slide: SlideItem,
    onOpenSpeakerScript: () -> Unit
) {
    var selectedCategory by remember { mutableStateOf("All") }

    val filteredPlaces = remember(selectedCategory) {
        if (selectedCategory == "All") PresentationRepository.goaPlaces
        else PresentationRepository.goaPlaces.filter { it.region.contains(selectedCategory) }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            SlideHeader(slide = slide, onOpenSpeakerScript = onOpenSpeakerScript)
        }

        // Natural Scenic Art
        item {
            GoaBeachScenicIllustration()
        }

        // Interactive Region Filter (Functional Segmented Control)
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF1E293B))
                    .padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                listOf("All", "South Goa", "Central Goa", "North Goa").forEach { filter ->
                    val isSelected = selectedCategory == filter
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (isSelected) OceanBlue else Color.Transparent)
                            .clickable { selectedCategory = filter }
                            .padding(vertical = 6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = filter,
                            fontSize = 9.5.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) Color.White else Slate400,
                            maxLines = 1
                        )
                    }
                }
            }
        }

        items(filteredPlaces) { place ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF1E293B))
                    .border(1.dp, Color(0xFF334155), RoundedCornerShape(8.dp))
                    .padding(10.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(place.name, fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(Color(0xFF065F46))
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text("AI Score: ${place.aiRecommendationScore}%", fontSize = 8.5.sp, color = Color(0xFF6EE7B7), fontWeight = FontWeight.Bold)
                        }
                    }

                    // Metadata unboxed
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(place.region, fontSize = 9.sp, color = OceanBlue, fontWeight = FontWeight.SemiBold)
                        Text("·", fontSize = 9.sp, color = Slate400)
                        Text(place.category, fontSize = 9.sp, color = Slate400)
                        Text("·", fontSize = 9.sp, color = Slate400)
                        Text(place.idealDuration, fontSize = 9.sp, color = AmberGold)
                    }

                    Text(place.description, fontSize = 9.5.sp, color = Color(0xFFCBD5E1), lineHeight = 12.sp)

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.padding(top = 2.dp)
                    ) {
                        Icon(Icons.Filled.Star, contentDescription = null, tint = AmberGold, modifier = Modifier.size(12.dp))
                        Text(place.highlight, fontSize = 9.sp, color = Color(0xFFFDE68A), fontWeight = FontWeight.Medium)
                    }
                }
            }
        }
    }
}

/**
 * Slide 6: Hotel Selection & Hospitality Vetting
 */
@Composable
fun Slide6HotelBooking(
    slide: SlideItem,
    onOpenSpeakerScript: () -> Unit
) {
    var selectedHotel by remember { mutableStateOf(PresentationRepository.goaHotels[0]) }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            SlideHeader(slide = slide, onOpenSpeakerScript = onOpenSpeakerScript)
        }

        item {
            HotelVibeVisual(tierName = selectedHotel.tier)
        }

        item {
            Text(
                "VERIFIED DIRECT-PARTNER HOTEL INVENTORY",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = OceanBlue
            )
        }

        items(PresentationRepository.goaHotels) { hotel ->
            val isSelected = selectedHotel.id == hotel.id
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (isSelected) Color(0xFF1E3A8A).copy(alpha = 0.4f) else Color(0xFF1E293B))
                    .border(
                        1.dp,
                        if (isSelected) OceanBlue else Color(0xFF334155),
                        RoundedCornerShape(8.dp)
                    )
                    .clickable { selectedHotel = hotel }
                    .padding(10.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(hotel.name, fontSize = 11.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            Text("${hotel.location} · ${hotel.tier}", fontSize = 9.sp, color = Slate400)
                        }
                        Column(horizontalAlignment = Alignment.End) {
                            Text("₹${hotel.pricePerNightInr}/night", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = AmberGold)
                            Text("Saves ₹${hotel.savingsVsOta} vs OTA", fontSize = 8.5.sp, color = EmeraldGreen, fontWeight = FontWeight.SemiBold)
                        }
                    }

                    // AI Sentiment
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xFF0F172A))
                            .padding(6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(Icons.Filled.Psychology, contentDescription = null, tint = OceanBlue, modifier = Modifier.size(14.dp))
                        Text(
                            hotel.aiSentimentSummary,
                            fontSize = 8.5.sp,
                            color = Color(0xFFBAE6FD),
                            lineHeight = 11.sp
                        )
                    }

                    // Amenities unboxed
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        hotel.keyAmenities.take(3).forEach { amenity ->
                            Text("• $amenity", fontSize = 8.5.sp, color = Slate400)
                        }
                    }
                }
            }
        }
    }
}

/**
 * Slide 7: Complete 4-Day Goa Itinerary
 */
@Composable
fun Slide7GoaItinerary(
    slide: SlideItem,
    onOpenSpeakerScript: () -> Unit
) {
    var activeDayNumber by remember { mutableStateOf(1) }
    val currentDay = PresentationRepository.goaItinerary.first { it.dayNumber == activeDayNumber }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            SlideHeader(slide = slide, onOpenSpeakerScript = onOpenSpeakerScript)
        }

        // Day Selector Tabs
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF1E293B))
                    .padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                (1..4).forEach { dayNum ->
                    val isSelected = activeDayNumber == dayNum
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (isSelected) OceanBlue else Color.Transparent)
                            .clickable { activeDayNumber = dayNum }
                            .padding(vertical = 6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Day $dayNum",
                            fontSize = 10.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) Color.White else Slate400
                        )
                    }
                }
            }
        }

        // Active Day Title & Logistics
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF0F172A))
                    .border(1.dp, Color(0xFF334155), RoundedCornerShape(8.dp))
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("DAY ${currentDay.dayNumber}: ${currentDay.title.uppercase()}", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        Text("${currentDay.routeDistanceKm} km total · ${currentDay.transitTimeMin} min transit", fontSize = 9.sp, color = AmberGold)
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xFF065F46))
                            .padding(horizontal = 6.dp, vertical = 3.dp)
                    ) {
                        Text("Optimized TSP Route", fontSize = 8.5.sp, color = Color(0xFF6EE7B7), fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        // Day Activities Breakdown
        val activities = listOf(
            Triple("Morning Phase", currentDay.morningActivity, Icons.Filled.WbSunny),
            Triple("Afternoon Phase", currentDay.afternoonActivity, Icons.Filled.BeachAccess),
            Triple("Evening Sunset", currentDay.eveningActivity, Icons.Filled.NightsStay),
            Triple("Culinary Pairing", currentDay.culinaryHighlight, Icons.Filled.Restaurant)
        )

        items(activities) { (phase, text, icon) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF1E293B))
                    .border(1.dp, Color(0xFF334155), RoundedCornerShape(8.dp))
                    .padding(10.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(if (phase.contains("Culinary")) Color(0xFFB45309) else Color(0xFF0284C7)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(15.dp))
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text(phase, fontSize = 9.5.sp, fontWeight = FontWeight.Bold, color = if (phase.contains("Culinary")) AmberGold else Color.White)
                    Text(text, fontSize = 9.5.sp, color = Color(0xFFCBD5E1), lineHeight = 13.sp)
                }
            }
        }

        // AI Tip Card
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF064E3B).copy(alpha = 0.4f))
                    .border(1.dp, Color(0xFF059669), RoundedCornerShape(8.dp))
                    .padding(10.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Icon(Icons.Filled.AutoAwesome, contentDescription = null, tint = Color(0xFF34D399), modifier = Modifier.size(16.dp))
                    Text(
                        "AI Adaptive Advice: ${currentDay.aiTips}",
                        fontSize = 9.5.sp,
                        color = Color(0xFFA7F3D0),
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

/**
 * Slide 8: Dynamic Budget Matrix
 */
@Composable
fun Slide8BudgetMatrix(
    slide: SlideItem,
    onOpenSpeakerScript: () -> Unit
) {
    var travelTier by remember { mutableStateOf("Balanced") }

    val multiplier = when (travelTier) {
        "Backpacker" -> 0.6f
        "Luxury" -> 1.8f
        else -> 1.0f
    }

    val totalBudget = (52000 * multiplier).toInt()
    val totalSaved = (11400 * multiplier).toInt()

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            SlideHeader(slide = slide, onOpenSpeakerScript = onOpenSpeakerScript)
        }

        // Tier Selector
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF1E293B))
                    .padding(4.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                listOf("Backpacker", "Balanced", "Luxury").forEach { tier ->
                    val isSelected = travelTier == tier
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(6.dp))
                            .background(if (isSelected) OceanBlue else Color.Transparent)
                            .clickable { travelTier = tier }
                            .padding(vertical = 6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            tier,
                            fontSize = 10.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) Color.White else Slate400
                        )
                    }
                }
            }
        }

        item {
            DynamicBudgetDistributionBar(
                totalInr = totalBudget,
                savedInr = totalSaved
            )
        }

        item {
            Text(
                "ITEMIZED EXPENSE MATRIX & OPTIMIZATION TACTICS",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = OceanBlue
            )
        }

        items(PresentationRepository.budgetItems) { item ->
            val adjustedCost = (item.allocatedInr * multiplier).toInt()
            val adjustedSaved = (item.aiSavedInr * multiplier).toInt()

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF1E293B))
                    .border(1.dp, Color(0xFF334155), RoundedCornerShape(8.dp))
                    .padding(10.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(item.category, fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text("₹$adjustedCost", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            Text("(+₹$adjustedSaved Saved)", fontSize = 9.sp, color = EmeraldGreen, fontWeight = FontWeight.SemiBold)
                        }
                    }
                    Text(item.optimizationStrategy, fontSize = 8.5.sp, color = Slate400, lineHeight = 11.sp)
                }
            }
        }
    }
}

/**
 * Slide 9: Autonomous Booking Agent Live Demo
 */
@Composable
fun Slide9LiveAgentDemo(
    slide: SlideItem,
    onOpenSpeakerScript: () -> Unit
) {
    var isExecuting by remember { mutableStateOf(false) }
    var executionStep by remember { mutableIntStateOf(0) }
    var isBookingComplete by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            SlideHeader(slide = slide, onOpenSpeakerScript = onOpenSpeakerScript)
        }

        // Live Simulation Terminal
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFF090D16))
                    .border(1.dp, Color(0xFF334155), RoundedCornerShape(10.dp))
                    .padding(12.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Box(Modifier.size(8.dp).clip(RoundedCornerShape(4.dp)).background(if (isBookingComplete) EmeraldGreen else AmberGold))
                            Text("AGENT RUNTIME LOGS", fontSize = 9.sp, color = Slate400, fontWeight = FontWeight.Bold)
                        }
                        Text(if (isBookingComplete) "EXECUTION ID: PNR-GOA-7892" else "READY FOR DISPATCH", fontSize = 8.5.sp, color = OceanBlue)
                    }

                    val logs = listOf(
                        "1. Parsing natural language constraints (Budget: ₹52,000, 4D Goa, Serene Beach)... DONE",
                        "2. Amadeus GDS API seat lock (Indigo 6E-241 GOX)... VERIFIED",
                        "3. PMS API Handshake: Direct room reserve at Palolem Eco Cabana... CONFIRMED",
                        "4. Encrypted token settlement (₹52,000 two-phase commit)... SUCCESS",
                        "5. Emitting digital QR boarding pass & syncing Google Calendar... COMPLETED"
                    )

                    logs.forEachIndexed { idx, line ->
                        val isVisible = isBookingComplete || (isExecuting && executionStep >= idx)
                        if (isVisible) {
                            Text(
                                text = line,
                                fontSize = 9.sp,
                                color = if (idx == 4) EmeraldGreen else Color(0xFFE2E8F0),
                                lineHeight = 12.sp
                            )
                        }
                    }

                    if (!isBookingComplete && !isExecuting) {
                        Text(
                            text = "Waiting for human-in-the-loop authorization trigger...",
                            fontSize = 9.sp,
                            color = Slate400
                        )
                    }
                }
            }
        }

        // Trigger Button
        item {
            Button(
                onClick = {
                    isExecuting = true
                    executionStep = 4
                    isBookingComplete = true
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isBookingComplete) EmeraldGreen else OceanBlue
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(
                        if (isBookingComplete) Icons.Filled.CheckCircle else Icons.Filled.PlayArrow,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        if (isBookingComplete) "Booking Verified & Locked!" else "Execute Autonomous Booking Demo",
                        fontSize = 11.5.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // Generated Voucher Display
        item {
            AnimatedVisibility(visible = isBookingComplete) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            Brush.linearGradient(
                                listOf(Color(0xFF064E3B), Color(0xFF0F172A))
                            )
                        )
                        .border(1.dp, Color(0xFF10B981), RoundedCornerShape(10.dp))
                        .padding(12.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("CONFIRMED ITINERARY VOUCHER", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color(0xFF34D399))
                            Text("PNR: 6E-GOA982", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        }
                        Text("Guest: Rahul & Sneha · 4 Days / 3 Nights · Palolem Beach Cabana", fontSize = 10.sp, color = Color.White)
                        Text("Total Debited: ₹52,000 (Saved ₹11,400) · Zero Cancellation Penalties", fontSize = 9.sp, color = Color(0xFFBAE6FD))
                        Text("✓ Google Calendar Sync ✓ WhatsApp Trip Bot ✓ Real-time Flight Gate Tracking", fontSize = 8.5.sp, color = Color(0xFFA7F3D0))
                    }
                }
            }
        }
    }
}

/**
 * Slide 10: Conclusion & Defense Summary
 */
@Composable
fun Slide10DefenseSummary(
    slide: SlideItem,
    onOpenSpeakerScript: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            SlideHeader(slide = slide, onOpenSpeakerScript = onOpenSpeakerScript)
        }

        item {
            Text(
                "QUANTITATIVE IMPACT BENCHMARKS",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = OceanBlue
            )
        }

        // Metrics Grid
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val stats = listOf(
                    Triple("92%", "Planning Time Reduced", OceanBlue),
                    Triple("21%", "Cost Savings vs OTAs", EmeraldGreen),
                    Triple("< 1.5s", "End-to-End Latency", AmberGold)
                )

                stats.forEach { (num, label, color) ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF1E293B))
                            .border(1.dp, Color(0xFF334155), RoundedCornerShape(8.dp))
                            .padding(10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(num, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = color)
                            Text(label, fontSize = 8.5.sp, color = Slate400, maxLines = 1)
                        }
                    }
                }
            }
        }

        item {
            Text(
                "PRODUCTION TECH STACK ARCHITECTURE",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = OceanBlue
            )
        }

        val stack = listOf(
            Triple("Frontend Engine", "Android Jetpack Compose, Material 3, Coroutines Flow", Icons.Filled.PhoneAndroid),
            Triple("AI Orchestration", "Gemini 2.5 Flash Multi-Agent Framework, JSON Tool Schemas", Icons.Filled.AutoAwesome),
            Triple("GDS & Inventory", "Amadeus REST APIs, Sabre GDS, OpenStreetMap TSP Solver", Icons.Filled.CloudSync),
            Triple("State & Security", "Room SQLite offline cache, AES-256 tokenization sandbox", Icons.Filled.Lock)
        )

        items(stack) { (title, subtitle, icon) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF1E293B))
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier.size(28.dp).clip(RoundedCornerShape(6.dp)).background(Color(0xFF0369A1)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(15.dp))
                }
                Column {
                    Text(title, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Text(subtitle, fontSize = 9.sp, color = Slate400)
                }
            }
        }

        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF0F172A))
                    .border(1.dp, EmeraldGreen.copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                    .padding(12.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("READY FOR 15-MINUTE EVALUATION DEFENSE", fontSize = 10.5.sp, fontWeight = FontWeight.Bold, color = EmeraldGreen)
                    Text(
                        "Click '15-Min Speech Script' above to read the exact presentation defense lines or examine the Viva Q&A cheat sheet.",
                        fontSize = 9.5.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}
