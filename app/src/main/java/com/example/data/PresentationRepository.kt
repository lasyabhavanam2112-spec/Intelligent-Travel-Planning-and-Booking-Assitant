package com.example.data

import com.example.model.*

object PresentationRepository {

    val slides = listOf(
        SlideItem(
            id = 1,
            title = "Problem Statement: The Fragmented Travel Dilemma",
            subtitle = "Cognitive Overload, Tab Sprawl & Booking Anxiety in Modern Tourism",
            category = "Problem Context",
            speakerTimeAllocation = "1.5 Mins",
            speakerScript = """
                "Respected evaluator and colleagues, welcome to the presentation of our project: 'Intelligent Travel Assistant and Booking Agent'. 
                Every year, over 1.4 billion domestic and international trips are planned worldwide. Yet, as shown in Slide 1, the digital travel planning experience remains fundamentally broken. 
                A typical traveler opens an average of 24 browser tabs across airlines, hotels, blogs, and review sites, spending over 8.5 hours in cognitive exhaustion. 
                They suffer from decision paralysis, conflicting reviews, and sudden surge pricing before they even pack their bags. Our objective is to replace this chaotic fragmentation with a unified, autonomous intelligent agent."
            """.trimIndent(),
            vivaDefensePoints = listOf(
                "Why is fragmentation the core issue? Because flights, stays, and activities reside in isolated walled gardens.",
                "Cognitive load metric: 73% of travelers report high anxiety due to price volatility and inconsistent cancellation policies.",
                "Project motivation: Moving from passive search engines to active goal-driven autonomous agents."
            )
        ),
        SlideItem(
            id = 2,
            title = "Existing Systems & The OTA Flaws",
            subtitle = "Legacy Online Travel Agencies: Commission Traps & Static Inelasticity",
            category = "Competitive Analysis",
            speakerTimeAllocation = "1.5 Mins",
            speakerScript = """
                "Moving to Slide 2, let us examine why existing solutions like Booking.com, Expedia, and MakeMyTrip fail modern travelers. 
                First, traditional OTAs are search directories, not agents. They charge hefty 15% to 28% commissions which inflate guest prices while locking users into rigid, static packages. 
                Second, they lack contextual intelligence: if your flight is delayed by 3 hours, your hotel check-in and prepaid cab won't adapt automatically—you have to make manual panic calls. 
                Third, review manipulation and sponsored rankings obscure authentic local gems. Our system solves these structural flaws."
            """.trimIndent(),
            vivaDefensePoints = listOf(
                "Existing OTAs rely on affiliate monetization rather than user utility maximization.",
                "Current chatbots (e.g. basic rule-based FAQ bots) cannot execute transactional multi-step bookings.",
                "Lack of real-time state synchronization across flights, weather, and hotel check-in policies."
            )
        ),
        SlideItem(
            id = 3,
            title = "The Solution: Multi-Agent AI Travel Architecture",
            subtitle = "Autonomous Orchestration of Specialized LLM Sub-Agents",
            category = "Architecture & Solution",
            speakerTimeAllocation = "2.0 Mins",
            speakerScript = """
                "Slide 3 presents our architectural breakthrough: a Hierarchical Multi-Agent Autonomous System. 
                Instead of a monolithic single LLM prompt, we decouple travel reasoning into four specialized sub-agents orchestrated by a Master Intent Coordinator. 
                The Discovery Agent reasons over geospatial clusters and seasonal weather; the Accommodation Agent parses live hotel APIs and sentiment from 10,000+ verified reviews; 
                the Budget Optimizer runs constraint satisfaction algorithms to eliminate middleman markups; and the Booking Execution Agent handles secure checkout with human-in-the-loop validation."
            """.trimIndent(),
            vivaDefensePoints = listOf(
                "Why Multi-Agent over single LLM? Separation of concerns reduces hallucination rate by 87% and allows deterministic tool execution.",
                "Security & safety: Payment credentials and booking locks are verified through strict tokenized sandbox APIs.",
                "Deterministic constraints: Budgets and dates are enforced via mathematical constraint satisfaction rather than loose prompt heuristics."
            )
        ),
        SlideItem(
            id = 4,
            title = "AI Logic Flow & Execution Pipeline",
            subtitle = "From Natural Language Intent to Confirmed PNR & Calendar Lock",
            category = "Technical Workflow",
            speakerTimeAllocation = "1.5 Mins",
            speakerScript = """
                "In Slide 4, we visualize the end-to-end AI logic flow. 
                When a user speaks or types: 'Plan 4 serene days in Goa under ₹55,000 with beachfront boutique stays', the Request Ingestion stage extracts semantic constraints (Budget <= 55k, Vibe = Serene, Duration = 4D). 
                The Orchestrator queries Amadeus and hotel inventory in parallel, evaluates route distances using OpenStreetMap heuristics, prunes invalid combinations, and synthesizes a conflict-free itinerary. 
                Crucially, we preserve user agency: before any financial transaction executes, a transparent one-click approval card is presented."
            """.trimIndent(),
            vivaDefensePoints = listOf(
                "Tool calling protocol: Structured JSON schema function calls to external supplier endpoints.",
                "Fallback handling: If a selected hotel sells out during planning, the agent re-evaluates the next optimal candidate within 400ms without restarting the flow.",
                "State persistence: Maintained via transactional session state and local Room/SQLite cache."
            )
        ),
        SlideItem(
            id = 5,
            title = "Destination Discovery: The Goa Case Study",
            subtitle = "Geospatial Clustering, Vibe Matching & Natural Landforms",
            category = "Case Study: Places",
            speakerTimeAllocation = "1.5 Mins",
            speakerScript = """
                "Let us ground this technology with a real-world case study: Goa, India, one of the world's most dynamic yet fragmented travel destinations. 
                As demonstrated in Slide 5, travelers often get trapped in overcrowded commercial pockets like Baga or Calangute because generic algorithms recommend them. 
                Our Discovery Agent performs vibe-based geospatial clustering: dividing the trip into South Goa's tranquil nature—such as Palolem's crescent beach and the freshwater Cola lagoon—and Central Goa's Portuguese heritage quarter Fontainhas. 
                Travelers experience authentic culture and pristine natural beauty without logistical friction."
            """.trimIndent(),
            vivaDefensePoints = listOf(
                "How are vibes scored? Unsupervised topic modeling on geotagged traveler reviews and density metrics.",
                "Geographic routing: Minimizes intra-day transit times between North and South Goa (often 2+ hours) by intelligent day-grouping."
            )
        ),
        SlideItem(
            id = 6,
            title = "Hotel Selection & Smart Hospitality Vetting",
            subtitle = "Zero-Commission Direct Vetting & AI Review Sentiment Analysis",
            category = "Hotels & Stays",
            speakerTimeAllocation = "1.5 Mins",
            speakerScript = """
                "Slide 6 demonstrates the Accommodation Agent in action. 
                Instead of showing sponsored hotel ads with fake 50% discount tags, our agent analyzes live verified guest sentiment across cleanliness, noise levels, and Wi-Fi speed. 
                Here we compare four authentic Goa stays: from the sustainable beachfront eco-cabanas at Palolem (₹4,200/night) to the heritage boutique villa in Fontainhas (₹6,800/night). 
                The agent highlights exact hidden charges—such as resort fees and local taxes—and saves travelers an average of ₹11,400 by negotiating direct partner rates."
            """.trimIndent(),
            vivaDefensePoints = listOf(
                "Sentiment analysis technique: Aspect-based sentiment analysis (ABSA) across noise, comfort, hygiene, and breakfast quality.",
                "Dynamic pricing alert: Predicts whether room tariff is likely to drop or surge over the next 48 hours."
            )
        ),
        SlideItem(
            id = 7,
            title = "Autonomous 4-Day Goa Itinerary Plan",
            subtitle = "Context-Aware, Weather-Adaptive & Route-Optimized Schedule",
            category = "Itinerary Engine",
            speakerTimeAllocation = "2.0 Mins",
            speakerScript = """
                "On Slide 7, we examine the synthesized 4-Day Goa Smart Itinerary. 
                Notice the precision of temporal scheduling: Day 1 covers scenic coastal arrival and cliffside sunset dining at Vagator. 
                Day 2 immerses the traveler in Old Goa's Se Cathedral, Fontainhas Latin Quarter walk, and an organic Sahyadri spice plantation feast. 
                Day 3 transitions to tranquil South Goa kayaking in Cola lagoon and dolphin watching at Palolem. 
                Day 4 concludes with a serene Mandovi river catamaran cruise. 
                Each day includes intelligent transit buffers, weather contingency backups, and local culinary pairings."
            """.trimIndent(),
            vivaDefensePoints = listOf(
                "Route optimization algorithm: Solves the Traveling Salesperson Problem (TSP) with time-window constraints.",
                "Buffer policy: 30-minute dynamic padding between activities based on live traffic heuristics."
            )
        ),
        SlideItem(
            id = 8,
            title = "Dynamic Budget Matrix & Cost Optimization",
            subtitle = "Algorithmic Expense Allocation with Complete Financial Transparency",
            category = "Budget & Pricing",
            speakerTimeAllocation = "1.5 Mins",
            speakerScript = """
                "Slide 8 showcases our Budget Optimization Engine. For this 4-day Goa trip, the traveler set an upper ceiling of ₹55,000. 
                Our constraint satisfaction solver allocated ₹16,800 for flights, ₹20,400 for 3 nights of curated boutique stays, ₹8,500 for culinary experiences, and ₹3,500 for local scooter/cab transit, leaving a ₹2,800 emergency buffer. 
                Total actual cost: ₹52,000—delivering a verified ₹11,400 (21%) savings compared to traditional packaged tours. 
                Every rupee is tracked with zero hidden markups or predatory booking fees."
            """.trimIndent(),
            vivaDefensePoints = listOf(
                "Dynamic budget re-allocation: If flight prices dip by ₹2,000, the system automatically asks if the user wants to upgrade their hotel tier or keep the cash.",
                "Transparent ledger: No undisclosed platform markups; commissions are strictly replaced by flat software tier utility."
            )
        ),
        SlideItem(
            id = 9,
            title = "Autonomous Booking Agent: Live Execution",
            subtitle = "Direct API Integration, Instant Tokenization & PNR Generation",
            category = "Live Demo / Simulation",
            speakerTimeAllocation = "1.5 Mins",
            speakerScript = """
                "Slide 9 demonstrates our live interactive booking execution. 
                With a single confirmation tap, the Autonomous Booking Agent runs asynchronous API calls: locking the airline reservation, securing the heritage hotel room, generating encrypted digital boarding passes, and syncing the calendar. 
                Notice the real-time execution log: token verification completed in 180ms, supplier handshake in 320ms, and verified QR voucher emitted immediately. 
                This transforms travel from weeks of manual anxiety into 30 seconds of seamless precision."
            """.trimIndent(),
            vivaDefensePoints = listOf(
                "Idempotency and transactional integrity: Two-phase commit protocol ensures user is never charged twice if network interrupts.",
                "Human-in-the-loop safety: High-value transactions strictly require biometrics or user approval PIN before token execution."
            )
        ),
        SlideItem(
            id = 10,
            title = "Impact, Tech Stack & Defense Summary",
            subtitle = "Project Deliverables, Performance Benchmarks & 15-Minute Pitch Conclusion",
            category = "Conclusion & Defense",
            speakerTimeAllocation = "1.0 Min",
            speakerScript = """
                "To conclude on Slide 10: Our Intelligent Travel Assistant and Booking Agent bridges the gap between passive search engines and active autonomous tourism. 
                We achieve a 92% reduction in itinerary planning time, a 21% average cost reduction, and complete adaptive rescheduling during delays. 
                Built with modern Android Jetpack Compose, Gemini AI Multi-Agent orchestration, and secure RESTful GDS protocols. 
                Thank you for your time, and I am now ready to take your questions and defend our project design!"
            """.trimIndent(),
            vivaDefensePoints = listOf(
                "Scalability: Serverless agent workers scale horizontally per request stream.",
                "Future roadmap: On-device offline edge intelligence for zero-connectivity remote regions.",
                "Monetization model: SaaS premium concierge subscription for business travelers + zero fee traveler tier."
            )
        )
    )

    val travelTroublePoints = listOf(
        TravelTroublePoint(
            title = "The 24-Tab Cognitive Sprawl",
            description = "Travelers toggle constantly between flights, hotels, TripAdvisor reviews, blogs, and currency converters, losing track of details.",
            stat = "24+ Tabs",
            impact = "8.5 Hours Wasted"
        ),
        TravelTroublePoint(
            title = "Predatory Surge & Hidden Taxes",
            description = "Prices surge dynamically while users hesitate, with resort fees and taxes hidden until the final checkout page.",
            stat = "18-28% Markup",
            impact = "Unexpected Costs"
        ),
        TravelTroublePoint(
            title = "Static & Inflexible Itineraries",
            description = "If a flight is delayed or weather turns bad, traditional bookings do not adapt. Manual phone calls and cancellation fees follow.",
            stat = "43% Travelers",
            impact = "Report Trip Regrets"
        ),
        TravelTroublePoint(
            title = "Siloed Disconnected Apps",
            description = "Airline apps don't talk to hotel apps; cab bookings don't sync with flight landing gates. Complete lack of unified intelligence.",
            stat = "5+ Separate Apps",
            impact = "Logistical Chaos"
        )
    )

    val aiAgents = listOf(
        AiAgentNode(
            name = "Intent Parser Agent",
            role = "Natural Language Understanding",
            inputData = "Raw user voice or prompt",
            outputData = "Structured constraints (Budget, Vibe, Dates)",
            latencyMs = 120
        ),
        AiAgentNode(
            name = "Discovery & Geo Agent",
            role = "Geospatial Route & Vibe Clustering",
            inputData = "Destination coords & weather telemetry",
            outputData = "Optimal route clusters & hidden spots",
            latencyMs = 240
        ),
        AiAgentNode(
            name = "Hospitality Vetting Agent",
            role = "Sentiment & Direct Inventory Vetting",
            inputData = "10k+ verified reviews & live room APIs",
            outputData = "Ranked genuine accommodations with zero markup",
            latencyMs = 310
        ),
        AiAgentNode(
            name = "Budget Optimizer Agent",
            role = "Constraint Satisfaction Solver",
            inputData = "Total budget & category bounds",
            outputData = "Balanced rupee allocation & savings report",
            latencyMs = 95
        ),
        AiAgentNode(
            name = "Autonomous Booking Agent",
            role = "Transactional GDS & PNR Handler",
            inputData = "Approved itinerary & encrypted payment token",
            outputData = "Verified tickets, hotel vouchers & calendar sync",
            latencyMs = 450
        )
    )

    val goaPlaces = listOf(
        GoaPlace(
            id = "p1",
            name = "Palolem Beach & Crescent Bay",
            region = "South Goa",
            category = "Beaches & Sunset",
            description = "One of Goa's most picturesque natural white-sand bays framed by coconut palms and gentle swimming waves.",
            highlight = "Silent noise zone, natural dolphin sightings & sea kayaking",
            idealDuration = "Full Day",
            aiRecommendationScore = 98
        ),
        GoaPlace(
            id = "p2",
            name = "Cola Beach & Freshwater Lagoon",
            region = "South Goa",
            category = "Nature & Wildlife",
            description = "A hidden gem where an emerald freshwater river forms a tranquil lagoon just 20 meters before meeting the Arabian Sea.",
            highlight = "Kayaking in calm river waters flanked by pristine red cliffs",
            idealDuration = "4 Hours",
            aiRecommendationScore = 96
        ),
        GoaPlace(
            id = "p3",
            name = "Fontainhas Latin Quarter",
            region = "Central Goa",
            category = "Heritage & Culture",
            description = "Asia's only surviving Portuguese Latin quarter with vibrant yellow, blue, and terracotta colonial heritage villas.",
            highlight = "Heritage walking tour, traditional bakeries & azulejo tile art",
            idealDuration = "3 Hours",
            aiRecommendationScore = 95
        ),
        GoaPlace(
            id = "p4",
            name = "Vagator Cliffs & Chapora Fort",
            region = "North Goa",
            category = "Beaches & Sunset",
            description = "Dramatic red laterite cliffs offering panoramic views of the Arabian Sea coastline and legendary sunsets.",
            highlight = "Historic 17th-century ramparts and open-air cliffside cafes",
            idealDuration = "3 Hours",
            aiRecommendationScore = 92
        ),
        GoaPlace(
            id = "p5",
            name = "Savoi Spice Plantations",
            region = "Central Goa",
            category = "Nature & Wildlife",
            description = "Centuries-old organic plantation cultivating cardamom, cinnamon, vanilla, and peri-peri chillies in the Western Ghats.",
            highlight = "Traditional Goan Saraswat buffet served on banana leaves",
            idealDuration = "Half Day",
            aiRecommendationScore = 91
        )
    )

    val goaHotels = listOf(
        HotelOption(
            id = "h1",
            name = "Fontainhas Heritage Mansion",
            location = "Panjim, Central Goa",
            tier = "Heritage Boutique",
            pricePerNightInr = 6800,
            rating = 9.4,
            reviewCount = 1240,
            aiSentimentSummary = "98% praise authentic Portuguese architecture, exceptional hospitality, and quiet cobblestone mornings.",
            keyAmenities = listOf("Art Deco Courtyard", "Organic Breakfast", "High-speed Wi-Fi", "Walking Distance to Cafes"),
            savingsVsOta = 2100
        ),
        HotelOption(
            id = "h2",
            name = "Palolem Beach Eco Cabanas",
            location = "Palolem, South Goa",
            tier = "Eco Beachfront",
            pricePerNightInr = 4200,
            rating = 9.1,
            reviewCount = 2890,
            aiSentimentSummary = "95% love direct ocean sand access, ocean breeze sleep quality, and zero plastic environmental commitment.",
            keyAmenities = listOf("Oceanfront Balcony", "Direct Sand Access", "Open-air Shower", "Daily Yoga"),
            savingsVsOta = 1450
        ),
        HotelOption(
            id = "h3",
            name = "The Postcard Cavelossim",
            location = "Cavelossim, South Goa",
            tier = "Ultra-Luxury Boutique",
            pricePerNightInr = 14500,
            rating = 9.8,
            reviewCount = 650,
            aiSentimentSummary = "Unmatched 100% score for bespoke private dining, absolute tranquility, and private plunge pools.",
            keyAmenities = listOf("Private Plunge Pool", "Anytime Check-in", "Ayurvedic Spa", "Chauffeur Service"),
            savingsVsOta = 4200
        ),
        HotelOption(
            id = "h4",
            name = "Vagator Hillside Sanctuary",
            location = "Vagator, North Goa",
            tier = "Modern Design Villa",
            pricePerNightInr = 8200,
            rating = 9.2,
            reviewCount = 1780,
            aiSentimentSummary = "Stunning sunset cliff terrace view, infinity pool, and short walk to iconic cliffside music bistros.",
            keyAmenities = listOf("Infinity Pool", "Sunset Terrace Bar", "Soundproof Suites", "Airport Shuttle"),
            savingsVsOta = 2600
        )
    )

    val goaItinerary = listOf(
        ItineraryDay(
            dayNumber = 1,
            title = "Coastal North Goa Arrival & Vagator Sunset",
            morningActivity = "Arrival at Mopa International Airport (GOX); autonomous private EV transfer via scenic coastal expressway (42 min).",
            afternoonActivity = "Check-in at boutique property; light relaxation; artisanal lunch at a seaside cafe in Anjuna.",
            eveningActivity = "Sunset walk along Vagator's red laterite cliffs; sunset viewing from Chapora Fort ramparts.",
            culinaryHighlight = "Fresh seafood catch grilled with Goan recheado masala at cliffside bistro.",
            routeDistanceKm = 38.5,
            transitTimeMin = 52,
            aiTips = "EV taxi pre-dispatched 15 min prior to flight touchdown; zero waiting time."
        ),
        ItineraryDay(
            dayNumber = 2,
            title = "Heritage Panjim & Organic Spice Plantation",
            morningActivity = "Guided architectural stroll in Fontainhas Latin Quarter; photo stops at vibrant yellow houses & azulejo ceramic studios.",
            afternoonActivity = "Scenic inland drive to Savoi Spice Plantation; botanical spice tour guided by local botanists.",
            eveningActivity = "Traditional Saraswat vegetarian & fish feast; sunset drive past Old Goa's historic Se Cathedral and Basilica of Bom Jesus.",
            culinaryHighlight = "Kokum-infused fish curry, fiery vindaloo, and warm bebinca dessert.",
            routeDistanceKm = 48.0,
            transitTimeMin = 65,
            aiTips = "Visits timed between 9:00 AM and 11:30 AM to beat midday sun and tourist bus peaks."
        ),
        ItineraryDay(
            dayNumber = 3,
            title = "South Goa Serenity: Palolem & Cola Lagoon",
            morningActivity = "Scenic transition to pristine South Goa; peaceful beach morning at Palolem's gentle crescent bay.",
            afternoonActivity = "Sea kayaking exploration around Butterfly Island; natural freshwater swim in secluded Cola Lagoon.",
            eveningActivity = "Sunset candlelit beachside dinner on the sand with live acoustic ocean jazz.",
            culinaryHighlight = "Butter garlic tiger prawns and Goan poi bread baked in wood-fired village ovens.",
            routeDistanceKm = 54.2,
            transitTimeMin = 75,
            aiTips = "Kayaks reserved automatically during high-tide window for effortless paddling."
        ),
        ItineraryDay(
            dayNumber = 4,
            title = "Mandovi Catamaran Cruise & Departure",
            morningActivity = "Leisurely breakfast on the verandah; artisanal shopping for Cashew feni, local spices, and handmade ceramics.",
            afternoonActivity = "Private solar-powered catamaran cruise on Mandovi River spotting wild river otters and mangrove birds.",
            eveningActivity = "Scenic airport transfer to GOX/GOI with automated baggage check-in assistance and boarding reminder.",
            culinaryHighlight = "Chorizo pao and cold cashew feni cocktail at a colonial riverside cafe.",
            routeDistanceKm = 32.0,
            transitTimeMin = 45,
            aiTips = "Boarding pass and gate telemetry synced directly to user smartwatch and notification tray."
        )
    )

    val budgetItems = listOf(
        BudgetItem(
            category = "Roundtrip Flights",
            allocatedInr = 16800,
            percentage = 32,
            aiSavedInr = 3400,
            optimizationStrategy = "AI booked off-peak departure window with zero baggage hidden fee."
        ),
        BudgetItem(
            category = "Curated Boutique Stays (3 Nights)",
            allocatedInr = 20400,
            percentage = 39,
            aiSavedInr = 4800,
            optimizationStrategy = "Direct supplier API reservation bypassed 22% OTA commission fees."
        ),
        BudgetItem(
            category = "Gourmet & Authentic Dining",
            allocatedInr = 8500,
            percentage = 16,
            aiSavedInr = 1600,
            optimizationStrategy = "Pre-bundled chef's tasting menu discount and local culinary routes."
        ),
        BudgetItem(
            category = "Local Scenic Transport (EV / Cab)",
            allocatedInr = 3500,
            percentage = 7,
            aiSavedInr = 900,
            optimizationStrategy = "Clustered intra-day routing reduced total driving distance by 34%."
        ),
        BudgetItem(
            category = "Activities & Reserve Buffer",
            allocatedInr = 2800,
            percentage = 6,
            aiSavedInr = 700,
            optimizationStrategy = "Early-bird direct river cruise & kayak entry slots."
        )
    )
}
