package com.example.model

data class SlideItem(
    val id: Int,
    val title: String,
    val subtitle: String,
    val category: String,
    val speakerTimeAllocation: String, // e.g., "1.5 Mins"
    val speakerScript: String,
    val vivaDefensePoints: List<String>
)

data class TravelTroublePoint(
    val title: String,
    val description: String,
    val stat: String,
    val impact: String
)

data class AiAgentNode(
    val name: String,
    val role: String,
    val inputData: String,
    val outputData: String,
    val latencyMs: Int
)

data class GoaPlace(
    val id: String,
    val name: String,
    val region: String, // "North Goa", "South Goa", "Central Goa"
    val category: String, // "Beaches & Sunset", "Heritage & Culture", "Nature & Wildlife"
    val description: String,
    val highlight: String,
    val idealDuration: String,
    val aiRecommendationScore: Int // out of 100
)

data class HotelOption(
    val id: String,
    val name: String,
    val location: String,
    val tier: String,
    val pricePerNightInr: Int,
    val rating: Double,
    val reviewCount: Int,
    val aiSentimentSummary: String,
    val keyAmenities: List<String>,
    val savingsVsOta: Int
)

data class ItineraryDay(
    val dayNumber: Int,
    val title: String,
    val morningActivity: String,
    val afternoonActivity: String,
    val eveningActivity: String,
    val culinaryHighlight: String,
    val routeDistanceKm: Double,
    val transitTimeMin: Int,
    val aiTips: String
)

data class BudgetItem(
    val category: String,
    val allocatedInr: Int,
    val percentage: Int,
    val aiSavedInr: Int,
    val optimizationStrategy: String
)
