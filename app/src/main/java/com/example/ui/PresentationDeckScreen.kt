package com.example.ui

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items as gridItems
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.data.PresentationRepository
import com.example.model.SlideItem
import com.example.ui.components.*
import com.example.ui.slides.*
import kotlinx.coroutines.delay

@Composable
fun PresentationDeckScreen() {
    var currentSlideIndex by remember { mutableIntStateOf(0) }
    var showSpeakerModal by remember { mutableStateOf(false) }
    var showSlideGridModal by remember { mutableStateOf(false) }
    var isFullDocumentMode by remember { mutableStateOf(false) }

    // 15-Minute Countdown Presentation Timer
    var timerSecondsRemaining by remember { mutableIntStateOf(15 * 60) }
    var isTimerRunning by remember { mutableStateOf(false) }

    LaunchedEffect(isTimerRunning) {
        while (isTimerRunning && timerSecondsRemaining > 0) {
            delay(1000L)
            timerSecondsRemaining -= 1
        }
    }

    val slides = PresentationRepository.slides
    val currentSlide = slides[currentSlideIndex]

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFF090D16),
        topBar = {
            PresentationTopBar(
                timerSeconds = timerSecondsRemaining,
                isTimerRunning = isTimerRunning,
                onToggleTimer = { isTimerRunning = !isTimerRunning },
                onResetTimer = {
                    isTimerRunning = false
                    timerSecondsRemaining = 15 * 60
                },
                onOpenGrid = { showSlideGridModal = true },
                isFullDocMode = isFullDocumentMode,
                onToggleDocMode = { isFullDocumentMode = !isFullDocumentMode }
            )
        },
        bottomBar = {
            if (!isFullDocumentMode) {
                PresentationBottomBar(
                    currentIndex = currentSlideIndex,
                    totalSlides = slides.size,
                    onPrev = {
                        if (currentSlideIndex > 0) currentSlideIndex--
                    },
                    onNext = {
                        if (currentSlideIndex < slides.size - 1) currentSlideIndex++
                    },
                    onOpenGrid = { showSlideGridModal = true }
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (isFullDocumentMode) {
                // Continuous 10-slide submission document view
                FullPresentationReport(
                    slides = slides,
                    onOpenSpeakerScript = { slide ->
                        currentSlideIndex = slide.id - 1
                        showSpeakerModal = true
                    }
                )
            } else {
                // Single-slide presentation deck mode
                AnimatedContent(
                    targetState = currentSlideIndex,
                    transitionSpec = {
                        if (targetState > initialState) {
                            (slideInHorizontally { width -> width } + fadeIn()).togetherWith(
                                slideOutHorizontally { width -> -width } + fadeOut()
                            )
                        } else {
                            (slideInHorizontally { width -> -width } + fadeIn()).togetherWith(
                                slideOutHorizontally { width -> width } + fadeOut()
                            )
                        }
                    },
                    label = "SlideTransition"
                ) { targetIndex ->
                    val slide = slides[targetIndex]
                    when (slide.id) {
                        1 -> Slide1ProblemStatement(slide = slide, onOpenSpeakerScript = { showSpeakerModal = true })
                        2 -> Slide2ExistingFlaws(slide = slide, onOpenSpeakerScript = { showSpeakerModal = true })
                        3 -> Slide3AiArchitecture(slide = slide, onOpenSpeakerScript = { showSpeakerModal = true })
                        4 -> Slide4LogicFlow(slide = slide, onOpenSpeakerScript = { showSpeakerModal = true })
                        5 -> Slide5PlacesDiscovery(slide = slide, onOpenSpeakerScript = { showSpeakerModal = true })
                        6 -> Slide6HotelBooking(slide = slide, onOpenSpeakerScript = { showSpeakerModal = true })
                        7 -> Slide7GoaItinerary(slide = slide, onOpenSpeakerScript = { showSpeakerModal = true })
                        8 -> Slide8BudgetMatrix(slide = slide, onOpenSpeakerScript = { showSpeakerModal = true })
                        9 -> Slide9LiveAgentDemo(slide = slide, onOpenSpeakerScript = { showSpeakerModal = true })
                        10 -> Slide10DefenseSummary(slide = slide, onOpenSpeakerScript = { showSpeakerModal = true })
                        else -> Slide1ProblemStatement(slide = slide, onOpenSpeakerScript = { showSpeakerModal = true })
                    }
                }
            }
        }
    }

    // Modal: 15-Minute Defense Speech Script
    if (showSpeakerModal) {
        SpeakerScriptModal(
            slide = currentSlide,
            onDismiss = { showSpeakerModal = false }
        )
    }

    // Modal: Slide Grid / Jump to Slide
    if (showSlideGridModal) {
        SlideGridModal(
            slides = slides,
            currentIndex = currentSlideIndex,
            onSelectSlide = { idx ->
                currentSlideIndex = idx
                showSlideGridModal = false
            },
            onDismiss = { showSlideGridModal = false }
        )
    }
}

/**
 * Top bar conforming to clean layout & 15-minute presentation timer.
 */
@Composable
private fun PresentationTopBar(
    timerSeconds: Int,
    isTimerRunning: Boolean,
    onToggleTimer: () -> Unit,
    onResetTimer: () -> Unit,
    onOpenGrid: () -> Unit,
    isFullDocMode: Boolean,
    onToggleDocMode: () -> Unit
) {
    val minutes = timerSeconds / 60
    val seconds = timerSeconds % 60
    val timeFormatted = String.format("%02d:%02d", minutes, seconds)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0F172A))
            .padding(horizontal = 14.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Brand Title
        Column {
            Text(
                "INTELLIGENT TRAVEL AGENT",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                letterSpacing = 0.5.sp
            )
            Text(
                "Autonomous Booking & Goa Itinerary Pitch",
                fontSize = 9.sp,
                color = Slate400
            )
        }

        // Center / Right Controls
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // 15-Minute Presentation Timer
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFF1E293B))
                    .border(1.dp, if (timerSeconds < 180) CoralRed else Color(0xFF334155), RoundedCornerShape(6.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    Icons.Filled.Timer,
                    contentDescription = null,
                    tint = if (timerSeconds < 180) CoralRed else AmberGold,
                    modifier = Modifier.size(13.dp)
                )
                Text(
                    text = timeFormatted,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (timerSeconds < 180) CoralRed else Color.White
                )
                Box(
                    modifier = Modifier
                        .clickable(onClick = onToggleTimer)
                        .padding(2.dp)
                ) {
                    Icon(
                        if (isTimerRunning) Icons.Filled.Pause else Icons.Filled.PlayArrow,
                        contentDescription = "Timer toggle",
                        tint = Color.White,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }

            // Document vs Slide Mode Switcher
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(if (isFullDocMode) OceanBlue else Color(0xFF1E293B))
                    .clickable(onClick = onToggleDocMode)
                    .padding(horizontal = 8.dp, vertical = 5.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Icon(
                        if (isFullDocMode) Icons.Filled.Slideshow else Icons.Filled.Article,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(13.dp)
                    )
                    Text(
                        if (isFullDocMode) "Slides" else "Full Doc",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
            }

            // Grid button
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFF1E293B))
                    .clickable(onClick = onOpenGrid)
                    .padding(horizontal = 6.dp, vertical = 5.dp)
            ) {
                Icon(Icons.Filled.GridView, contentDescription = "Grid", tint = Color.White, modifier = Modifier.size(15.dp))
            }
        }
    }
}

/**
 * Bottom navigation bar with slide indicator and Next / Prev buttons.
 */
@Composable
private fun PresentationBottomBar(
    currentIndex: Int,
    totalSlides: Int,
    onPrev: () -> Unit,
    onNext: () -> Unit,
    onOpenGrid: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0F172A))
            .border(1.dp, Color(0xFF1E293B), RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            .padding(horizontal = 14.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Prev Button
        Button(
            onClick = onPrev,
            enabled = currentIndex > 0,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1E293B),
                disabledContainerColor = Color(0xFF1E293B).copy(alpha = 0.4f)
            ),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Icon(Icons.Filled.ArrowBack, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
                Text("Previous", fontSize = 11.sp, color = Color.White)
            }
        }

        // Slide Counter Indicator
        Row(
            modifier = Modifier
                .clickable(onClick = onOpenGrid)
                .clip(RoundedCornerShape(6.dp))
                .background(Color(0xFF1E293B))
                .padding(horizontal = 10.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                "Slide ${currentIndex + 1} of $totalSlides",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Icon(Icons.Filled.KeyboardArrowUp, contentDescription = null, tint = Slate400, modifier = Modifier.size(14.dp))
        }

        // Next Button
        Button(
            onClick = onNext,
            enabled = currentIndex < totalSlides - 1,
            colors = ButtonDefaults.buttonColors(
                containerColor = OceanBlue,
                disabledContainerColor = OceanBlue.copy(alpha = 0.4f)
            ),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(if (currentIndex == totalSlides - 1) "Finish" else "Next", fontSize = 11.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Icon(Icons.Filled.ArrowForward, contentDescription = null, tint = Color.White, modifier = Modifier.size(14.dp))
            }
        }
    }
}

/**
 * Slide Grid Modal for jumping to any slide.
 */
@Composable
private fun SlideGridModal(
    slides: List<SlideItem>,
    currentIndex: Int,
    onSelectSlide: (Int) -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.85f),
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFF0F172A)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Jump to Slide (1 - 10)",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Filled.Close, contentDescription = null, tint = Color.White)
                    }
                }

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    gridItems(slides) { slide ->
                        val isCurrent = slide.id - 1 == currentIndex
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(95.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (isCurrent) Color(0xFF0369A1) else Color(0xFF1E293B))
                                .border(
                                    1.dp,
                                    if (isCurrent) Color(0xFF38BDF8) else Color(0xFF334155),
                                    RoundedCornerShape(8.dp)
                                )
                                .clickable { onSelectSlide(slide.id - 1) }
                                .padding(8.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        String.format("%02d", slide.id),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isCurrent) Color.White else AmberGold
                                    )
                                    Text(slide.speakerTimeAllocation, fontSize = 8.sp, color = Slate400)
                                }
                                Text(
                                    slide.title,
                                    fontSize = 9.5.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.White,
                                    maxLines = 2,
                                    lineHeight = 11.sp
                                )
                                Text(slide.category, fontSize = 8.sp, color = if (isCurrent) Color(0xFFBAE6FD) else Slate400, maxLines = 1)
                            }
                        }
                    }
                }
            }
        }
    }
}

/**
 * Continuous Full 10-Slide Report View for instant academic submission.
 */
@Composable
private fun FullPresentationReport(
    slides: List<SlideItem>,
    onOpenSpeakerScript: (SlideItem) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFF1E293B))
                    .border(1.dp, OceanBlue, RoundedCornerShape(12.dp))
                    .padding(16.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text("PROJECT PRESENTATION DOSSIER", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = OceanBlue)
                    Text("Intelligent Travel Assistant and Booking Agent", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Text("Complete 10-slide dossier with AI multi-agent architecture, problem analysis, Goa trip plans, hotel selection, and viva defense guide.", fontSize = 10.sp, color = Slate400)
                }
            }
        }

        items(slides) { slide ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFF0F172A))
                    .border(1.dp, Color(0xFF334155), RoundedCornerShape(10.dp))
                    .padding(14.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text(
                                text = String.format("SLIDE %02d", slide.id),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = OceanBlue
                            )
                            Text("·", fontSize = 11.sp, color = Slate400)
                            Text(
                                text = slide.category.uppercase(),
                                fontSize = 9.5.sp,
                                color = Slate400
                            )
                        }

                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(4.dp))
                                .background(Color(0xFF1E293B))
                                .clickable { onOpenSpeakerScript(slide) }
                                .padding(horizontal = 6.dp, vertical = 3.dp)
                        ) {
                            Text("Speaker Script", fontSize = 9.sp, color = Color(0xFF38BDF8), fontWeight = FontWeight.SemiBold)
                        }
                    }

                    Text(slide.title, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Text(slide.subtitle, fontSize = 10.sp, color = Color(0xFF94A3B8))

                    // Brief Speech Script snippet
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFF1E293B))
                            .padding(8.dp)
                    ) {
                        Text(
                            text = slide.speakerScript,
                            fontSize = 9.5.sp,
                            color = Color(0xFFE2E8F0),
                            lineHeight = 13.sp
                        )
                    }

                    // Key Viva Point
                    if (slide.vivaDefensePoints.isNotEmpty()) {
                        Text(
                            text = "Key Defense: ${slide.vivaDefensePoints.first()}",
                            fontSize = 9.sp,
                            color = AmberGold,
                            lineHeight = 12.sp
                        )
                    }
                }
            }
        }
    }
}
