package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import com.example.model.AiAgentNode

/**
 * Slide 3: Interactive Multi-Agent Architecture Diagram with clean minimalist icons.
 */
@Composable
fun MultiAgentArchitectureDiagram(
    modifier: Modifier = Modifier
) {
    var selectedNode by remember { mutableStateOf<String?>("Hospitality") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF0B132B))
            .border(1.dp, Color(0xFF1C2541), RoundedCornerShape(12.dp))
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // Architecture Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Icon(Icons.Filled.Hub, contentDescription = null, tint = OceanBlue, modifier = Modifier.size(18.dp))
                Text(
                    "HIERARCHICAL MULTI-AGENT ARCHITECTURE",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Text(
                "Tap node to inspect",
                fontSize = 9.sp,
                color = Slate400
            )
        }

        // Layer 1: User Request Ingestion
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFF1C2541))
                .padding(vertical = 8.dp, horizontal = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(Icons.Filled.RecordVoiceOver, contentDescription = null, tint = AmberGold, modifier = Modifier.size(16.dp))
                    Text(
                        "Natural Language Input: '4 Days in Goa under ₹55k, serene beach stay'",
                        fontSize = 10.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                }
                Text("Zero Prompt Engineering Required", fontSize = 8.sp, color = AmberGold)
            }
        }

        // Downward Flow Connector
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Icon(Icons.Filled.ArrowDownward, contentDescription = null, tint = Slate400, modifier = Modifier.size(14.dp))
        }

        // Layer 2: Central Orchestrator
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(
                    Brush.horizontalGradient(
                        listOf(Color(0xFF1E3A8A), Color(0xFF0369A1))
                    )
                )
                .border(1.dp, Color(0xFF38BDF8).copy(alpha = 0.5f), RoundedCornerShape(8.dp))
                .clickable { selectedNode = "Orchestrator" }
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(Icons.Filled.AutoAwesome, contentDescription = null, tint = Color.White, modifier = Modifier.size(20.dp))
                    Column {
                        Text("Master Intent Orchestrator (Reasoning Core)", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        Text("Decomposes goals · Enforces constraints · Validates sub-agent handoffs", fontSize = 9.sp, color = Color(0xFFE0F2FE))
                    }
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color.White.copy(alpha = 0.2f))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text("P95: 180ms", fontSize = 9.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
                }
            }
        }

        // Downward Flow Connector
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Icon(Icons.Filled.ArrowDownward, contentDescription = null, tint = Slate400, modifier = Modifier.size(14.dp))
        }

        // Layer 3: 4 Specialized Sub-Agents (Grid)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            SubAgentCard(
                title = "Discovery Agent",
                role = "Geospatial & Vibe",
                icon = Icons.Filled.Explore,
                isSelected = selectedNode == "Discovery",
                onClick = { selectedNode = "Discovery" },
                modifier = Modifier.weight(1f)
            )
            SubAgentCard(
                title = "Hospitality Agent",
                role = "Hotel Vetting & ABSA",
                icon = Icons.Filled.Hotel,
                isSelected = selectedNode == "Hospitality",
                onClick = { selectedNode = "Hospitality" },
                modifier = Modifier.weight(1f)
            )
            SubAgentCard(
                title = "Budget Agent",
                role = "Constraint Solver",
                icon = Icons.Filled.AccountBalanceWallet,
                isSelected = selectedNode == "Budget",
                onClick = { selectedNode = "Budget" },
                modifier = Modifier.weight(1f)
            )
            SubAgentCard(
                title = "Booking Agent",
                role = "Autonomous GDS PNR",
                icon = Icons.Filled.CheckCircle,
                isSelected = selectedNode == "Booking",
                onClick = { selectedNode = "Booking" },
                modifier = Modifier.weight(1f)
            )
        }

        // Interactive Inspector Details
        AnimatedVisibility(visible = selectedNode != null) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF1E293B))
                    .border(1.dp, Color(0xFF334155), RoundedCornerShape(8.dp))
                    .padding(10.dp)
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = when (selectedNode) {
                            "Discovery" -> "Discovery Agent: Analyzes OpenStreetMap nodes, tides, and crowd density to group activities geographically."
                            "Hospitality" -> "Hospitality Agent: Scrapes verified reviews with Aspect-Based Sentiment Analysis (ABSA) to exclude noise and dampness."
                            "Budget" -> "Budget Agent: Runs linear programming constraint satisfaction to optimize flight + hotel splits with 0% hidden fees."
                            "Booking" -> "Booking Agent: Emits tokenized REST calls to Amadeus / Sabre GDS APIs, locking PNRs with two-phase commit."
                            else -> "Master Orchestrator: Validates that all sub-agent responses fit within user constraints and safety bounds."
                        },
                        fontSize = 10.sp,
                        color = Color.White
                    )
                    Text(
                        text = "Deterministic JSON Schemas · Idempotent Execution · Human-in-the-Loop Safe",
                        fontSize = 9.sp,
                        color = EmeraldGreen,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Composable
private fun SubAgentCard(
    title: String,
    role: String,
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(78.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) Color(0xFF0369A1) else Color(0xFF1C2541))
            .border(
                1.dp,
                if (isSelected) Color(0xFF38BDF8) else Color(0xFF334155),
                RoundedCornerShape(8.dp)
            )
            .clickable(onClick = onClick)
            .padding(6.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                icon,
                contentDescription = null,
                tint = if (isSelected) Color.White else AmberGold,
                modifier = Modifier.size(16.dp)
            )
            Column {
                Text(title, fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color.White, maxLines = 1)
                Text(role, fontSize = 7.5.sp, color = if (isSelected) Color(0xFFBAE6FD) else Slate400, maxLines = 2, lineHeight = 9.sp)
            }
        }
    }
}

/**
 * Slide 4: AI Logic Flow & Execution Pipeline.
 * 5-stage sequential decision process.
 */
@Composable
fun AiLogicFlowDiagram(modifier: Modifier = Modifier) {
    val steps = listOf(
        Triple("01. INGEST", "Natural language parsing & semantic extraction", Icons.Filled.Mic),
        Triple("02. DISPATCH", "Concurrent sub-agent query parallelization", Icons.Filled.Share),
        Triple("03. PRUNE", "Constraint satisfaction & budget pruning", Icons.Filled.FilterAlt),
        Triple("04. VALIDATE", "One-click human-in-the-loop authorization", Icons.Filled.TouchApp),
        Triple("05. LOCK", "Two-phase atomic booking & calendar sync", Icons.Filled.DoneAll)
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF0B132B))
            .border(1.dp, Color(0xFF1C2541), RoundedCornerShape(12.dp))
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "AUTONOMOUS TRAVEL AGENT EXECUTION PIPELINE",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                "Total Latency: ~1.2s",
                fontSize = 9.sp,
                fontWeight = FontWeight.SemiBold,
                color = EmeraldGreen
            )
        }

        steps.forEachIndexed { index, (stage, desc, icon) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFF1C2541))
                    .padding(horizontal = 10.dp, vertical = 7.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Circle step index
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            when (index) {
                                3 -> AmberGold
                                4 -> EmeraldGreen
                                else -> OceanBlue
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(13.dp))
                }

                Column(modifier = Modifier.weight(1f)) {
                    Text(stage, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Text(desc, fontSize = 9.sp, color = Slate400, maxLines = 1)
                }

                Text(
                    text = when (index) {
                        0 -> "120ms"
                        1 -> "310ms"
                        2 -> "140ms"
                        3 -> "User Gate"
                        else -> "450ms"
                    },
                    fontSize = 8.sp,
                    color = Color(0xFF94A3B8)
                )
            }
        }
    }
}

/**
 * Slide 8: Dynamic Budget Allocation Bar & Cost Optimization.
 */
@Composable
fun DynamicBudgetDistributionBar(
    totalInr: Int = 52000,
    savedInr: Int = 11400,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFF0F172A))
            .border(1.dp, Color(0xFF334155), RoundedCornerShape(12.dp))
            .padding(14.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text("OPTIMIZED TOTAL BUDGET", fontSize = 9.sp, color = Slate400, fontWeight = FontWeight.Bold)
                Text("₹$totalInr", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFF064E3B))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    "AI Saved ₹$savedInr (21%)",
                    fontSize = 11.sp,
                    color = Color(0xFF34D399),
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // Multi-segment horizontal bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(14.dp)
                .clip(RoundedCornerShape(7.dp))
        ) {
            Box(Modifier.weight(0.32f).fillMaxHeight().background(Color(0xFF3B82F6))) // Flights
            Box(Modifier.weight(0.39f).fillMaxHeight().background(Color(0xFF8B5CF6))) // Hotels
            Box(Modifier.weight(0.16f).fillMaxHeight().background(Color(0xFFF59E0B))) // Food
            Box(Modifier.weight(0.07f).fillMaxHeight().background(Color(0xFF10B981))) // Transit
            Box(Modifier.weight(0.06f).fillMaxHeight().background(Color(0xFF6B7280))) // Buffer
        }

        // Legend
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BudgetLegendItem("Flights", "₹16.8k", Color(0xFF3B82F6))
            BudgetLegendItem("Stays", "₹20.4k", Color(0xFF8B5CF6))
            BudgetLegendItem("Dining", "₹8.5k", Color(0xFFF59E0B))
            BudgetLegendItem("Cabs", "₹3.5k", Color(0xFF10B981))
            BudgetLegendItem("Buffer", "₹2.8k", Color(0xFF6B7280))
        }
    }
}

@Composable
private fun BudgetLegendItem(label: String, amount: String, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Box(Modifier.size(8.dp).clip(RoundedCornerShape(2.dp)).background(color))
        Text("$label: $amount", fontSize = 8.5.sp, color = Color.White)
    }
}
