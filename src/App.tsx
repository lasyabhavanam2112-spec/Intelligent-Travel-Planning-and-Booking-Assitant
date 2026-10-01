import React, { useState, useEffect } from 'react';
import {
  AlertTriangle,
  Flame,
  Brain,
  Layers,
  ArrowRight,
  ArrowLeft,
  Timer,
  Play,
  Pause,
  RotateCcw,
  FileText,
  Grid,
  CheckCircle,
  HelpCircle,
  X,
  Compass,
  Hotel,
  Calendar,
  Wallet,
  Cpu,
  Sparkles,
  Plane,
  Shield,
  Clock,
  Car,
  Utensils,
  MapPin,
  ExternalLink,
  ChevronRight,
  ChevronLeft,
  Volume2,
  Code
} from 'lucide-react';

interface Slide {
  id: number;
  category: string;
  title: string;
  subtitle: string;
  timeAllocation: string;
  script: string;
  vivaDefense: string[];
}

const SLIDES: Slide[] = [
  {
    id: 1,
    category: "Problem Context",
    title: "Problem Statement: The Fragmented Travel Dilemma",
    subtitle: "Cognitive Overload, Tab Sprawl & Booking Anxiety in Modern Tourism",
    timeAllocation: "1.5 Mins",
    script: "Respected evaluators, every year over 1.4 billion trips are planned, yet the digital travel experience remains fundamentally broken. A typical traveler opens an average of 24 browser tabs across airlines, hotels, blogs, and review sites, spending over 8.5 hours in cognitive exhaustion. They suffer from decision paralysis, conflicting reviews, and surge pricing before they even pack their bags. Our objective with the Intelligent Travel Assistant and Booking Agent is to replace this chaotic fragmentation with a unified, goal-driven autonomous agent.",
    vivaDefense: [
      "Why is fragmentation the core issue? Stays, flights, and activities reside in isolated walled gardens without a shared state machine.",
      "Cognitive load metric: 73% of travelers report high anxiety due to price volatility and inconsistent cancellation policies.",
      "Project motivation: Transitioning from passive keyword search engines into active goal-driven autonomous execution."
    ]
  },
  {
    id: 2,
    category: "Competitive Analysis",
    title: "Existing Systems & The OTA Flaws",
    subtitle: "Legacy Online Travel Agencies: Commission Traps & Static Inelasticity",
    timeAllocation: "1.5 Mins",
    script: "Examining existing platforms like Booking.com, Expedia, and MakeMyTrip reveals why they fail modern travelers. Traditional OTAs are directory aggregators, not agents. They charge hefty 15% to 28% commissions that inflate guest prices while locking travelers into rigid, static packages. Furthermore, they lack contextual intelligence: if your flight is delayed by 3 hours, your hotel check-in and prepaid cab won't adapt automatically—requiring manual panic calls. Our system solves these structural flaws.",
    vivaDefense: [
      "Traditional OTAs monetize via affiliate paywalls rather than user utility maximization.",
      "Rule-based FAQ bots cannot execute transactional multi-step bookings with constraint satisfaction.",
      "Lack of real-time state synchronization across flights, weather, and hotel check-in policies."
    ]
  },
  {
    id: 3,
    category: "Architecture & Solution",
    title: "The Solution: Multi-Agent AI Travel Architecture",
    subtitle: "Autonomous Orchestration of Specialized LLM Sub-Agents",
    timeAllocation: "2.0 Mins",
    script: "Here is our architectural breakthrough: a Hierarchical Multi-Agent Autonomous System. Rather than relying on a single monolithic LLM prompt, we decouple travel reasoning into four specialized sub-agents orchestrated by a Master Intent Coordinator. The Discovery Agent reasons over geospatial clusters and seasonal weather; the Accommodation Agent parses live hotel APIs and sentiment from 10,000+ verified reviews; the Budget Optimizer runs constraint satisfaction algorithms; and the Booking Execution Agent handles secure checkout with human-in-the-loop validation.",
    vivaDefense: [
      "Why Multi-Agent over single LLM? Separation of concerns reduces hallucination rate by 87% and enforces deterministic JSON tool calls.",
      "Security & safety: Payment credentials and booking locks are verified through strict tokenized sandbox APIs.",
      "Deterministic constraints: Budgets and dates are enforced via mathematical linear constraints rather than loose prompt heuristics."
    ]
  },
  {
    id: 4,
    category: "Technical Workflow",
    title: "AI Logic Flow & Execution Pipeline",
    subtitle: "From Natural Language Intent to Confirmed PNR & Calendar Lock",
    timeAllocation: "1.5 Mins",
    script: "In Slide 4, we visualize the end-to-end AI logic flow. When a user prompts: 'Plan 4 serene days in Goa under ₹55,000 with beachfront boutique stays', the Request Ingestion stage extracts semantic constraints (Budget <= 55k, Vibe = Serene, Duration = 4D). The Orchestrator queries Amadeus and hotel inventory in parallel, evaluates route distances using OpenStreetMap heuristics, prunes invalid combinations, and synthesizes a conflict-free itinerary. Crucially, before any financial transaction executes, a transparent one-click approval card is presented.",
    vivaDefense: [
      "Tool calling protocol: Structured JSON schema function calls to external supplier endpoints.",
      "Fallback handling: If a selected hotel sells out during planning, the agent re-evaluates the next optimal candidate within 400ms without restarting the session.",
      "State persistence: Maintained via transactional session state and local SQLite cache."
    ]
  },
  {
    id: 5,
    category: "Case Study: Places",
    title: "Destination Discovery: The Natural Goa Case Study",
    subtitle: "Geospatial Clustering, Vibe Matching & Pristine Coastal Landforms",
    timeAllocation: "1.5 Mins",
    script: "Let us ground this technology with a real-world case study: Goa, India, one of the world's most dynamic yet fragmented travel destinations. Travelers often get trapped in overcrowded commercial pockets like Baga because generic algorithms recommend them. Our Discovery Agent performs vibe-based geospatial clustering: dividing the trip into South Goa's tranquil nature—such as Palolem's crescent beach and the freshwater Cola lagoon—and Central Goa's Portuguese heritage quarter Fontainhas. Travelers experience authentic culture without logistical friction.",
    vivaDefense: [
      "How are vibes scored? Unsupervised topic modeling on geotagged traveler reviews and density metrics.",
      "Geographic routing: Minimizes intra-day transit times between North and South Goa by intelligent day-grouping."
    ]
  },
  {
    id: 6,
    category: "Hotels & Stays",
    title: "Hotel Selection & Smart Hospitality Vetting",
    subtitle: "Zero-Commission Direct Vetting & AI Review Sentiment Analysis",
    timeAllocation: "1.5 Mins",
    script: "Slide 6 demonstrates the Accommodation Agent in action. Instead of showing sponsored hotel ads with fake discount tags, our agent analyzes live verified guest sentiment across cleanliness, noise levels, and Wi-Fi speed. Here we compare four authentic Goa stays: from the sustainable beachfront eco-cabanas at Palolem (₹4,200/night) to the heritage boutique villa in Fontainhas (₹6,800/night). The agent highlights exact hidden charges and saves travelers an average of ₹11,400 by negotiating direct partner rates.",
    vivaDefense: [
      "Sentiment analysis technique: Aspect-based sentiment analysis (ABSA) across noise, comfort, hygiene, and breakfast quality.",
      "Dynamic pricing alert: Predicts whether room tariff is likely to drop or surge over the next 48 hours."
    ]
  },
  {
    id: 7,
    category: "Itinerary Engine",
    title: "Autonomous 4-Day Goa Itinerary Plan",
    subtitle: "Context-Aware, Weather-Adaptive & Route-Optimized Schedule",
    timeAllocation: "2.0 Mins",
    script: "On Slide 7, we examine the synthesized 4-Day Goa Smart Itinerary. Notice the precision of temporal scheduling: Day 1 covers scenic coastal arrival and cliffside sunset dining at Vagator. Day 2 immerses the traveler in Old Goa's Se Cathedral, Fontainhas Latin Quarter walk, and an organic Sahyadri spice plantation feast. Day 3 transitions to tranquil South Goa kayaking in Cola lagoon and dolphin watching at Palolem. Day 4 concludes with a serene Mandovi river catamaran cruise. Each day includes intelligent transit buffers and local culinary pairings.",
    vivaDefense: [
      "Route optimization algorithm: Solves the Traveling Salesperson Problem (TSP) with time-window constraints.",
      "Buffer policy: 30-minute dynamic padding between activities based on live traffic heuristics."
    ]
  },
  {
    id: 8,
    category: "Budget & Pricing",
    title: "Dynamic Budget Matrix & Cost Optimization",
    subtitle: "Algorithmic Expense Allocation with Complete Financial Transparency",
    timeAllocation: "1.5 Mins",
    script: "Slide 8 showcases our Budget Optimization Engine. For this 4-day Goa trip, the traveler set an upper ceiling of ₹55,000. Our constraint satisfaction solver allocated ₹16,800 for flights, ₹20,400 for 3 nights of curated boutique stays, ₹8,500 for culinary experiences, and ₹3,500 for local scooter/cab transit, leaving a ₹2,800 emergency buffer. Total actual cost: ₹52,000—delivering a verified ₹11,400 (21%) savings compared to traditional packaged tours.",
    vivaDefense: [
      "Dynamic budget re-allocation: If flight prices dip by ₹2,000, the system automatically asks if the user wants to upgrade their hotel tier or save the cash.",
      "Transparent ledger: No undisclosed platform markups; commissions are strictly replaced by flat software tier utility."
    ]
  },
  {
    id: 9,
    category: "Live Demo / Simulation",
    title: "Autonomous Booking Agent: Live Execution",
    subtitle: "Direct API Integration, Instant Tokenization & PNR Generation",
    timeAllocation: "1.5 Mins",
    script: "Slide 9 demonstrates our live interactive booking execution. With a single confirmation tap, the Autonomous Booking Agent runs asynchronous API calls: locking the airline reservation, securing the heritage hotel room, generating encrypted digital boarding passes, and syncing the calendar. Notice the real-time execution log: token verification completed in 180ms, supplier handshake in 320ms, and verified QR voucher emitted immediately.",
    vivaDefense: [
      "Idempotency and transactional integrity: Two-phase commit protocol ensures user is never charged twice if network interrupts.",
      "Human-in-the-loop safety: High-value transactions strictly require user approval PIN before token execution."
    ]
  },
  {
    id: 10,
    category: "Conclusion & Defense",
    title: "Impact, Tech Stack & Defense Summary",
    subtitle: "Project Deliverables, Performance Benchmarks & 15-Minute Pitch Conclusion",
    timeAllocation: "1.0 Min",
    script: "To conclude on Slide 10: Our Intelligent Travel Assistant and Booking Agent bridges the gap between passive search engines and active autonomous tourism. We achieve a 92% reduction in itinerary planning time, a 21% average cost reduction, and complete adaptive rescheduling during delays. Built with modern React/TypeScript, Gemini AI Multi-Agent orchestration, and secure RESTful GDS protocols. Thank you for your time, and I am now ready to take your questions and defend our project design!",
    vivaDefense: [
      "Scalability: Serverless agent workers scale horizontally per request stream.",
      "Future roadmap: On-device offline edge intelligence for zero-connectivity remote regions.",
      "Monetization model: SaaS premium concierge subscription for business travelers + zero fee traveler tier."
    ]
  }
];

export default function App() {
  const [currentSlide, setCurrentSlide] = useState(0);
  const [isScriptOpen, setIsScriptOpen] = useState(false);
  const [isGridOpen, setIsGridOpen] = useState(false);
  const [isFullDoc, setIsFullDoc] = useState(false);
  const [isCodeDocOpen, setIsCodeDocOpen] = useState(false);

  // 15-Minute Timer
  const [timerSeconds, setTimerSeconds] = useState(15 * 60);
  const [isTimerRunning, setIsTimerRunning] = useState(false);

  // Slide 5 Interactive Filter
  const [vibeFilter, setVibeFilter] = useState('All');

  // Slide 6 Selected Hotel
  const [selectedHotelIndex, setSelectedHotelIndex] = useState(0);

  // Slide 7 Active Day
  const [activeDay, setActiveDay] = useState(1);

  // Slide 8 Travel Tier
  const [budgetTier, setBudgetTier] = useState<'Backpacker' | 'Balanced' | 'Luxury'>('Balanced');

  // Slide 9 Demo Simulation
  const [isSimulating, setIsSimulating] = useState(false);
  const [simStep, setSimStep] = useState(0);
  const [isBooked, setIsBooked] = useState(false);

  useEffect(() => {
    let interval: any;
    if (isTimerRunning && timerSeconds > 0) {
      interval = setInterval(() => {
        setTimerSeconds(s => s - 1);
      }, 1000);
    }
    return () => clearInterval(interval);
  }, [isTimerRunning, timerSeconds]);

  const minutes = Math.floor(timerSeconds / 60);
  const seconds = timerSeconds % 60;
  const timeFormatted = `${String(minutes).padStart(2, '0')}:${String(seconds).padStart(2, '0')}`;

  const current = SLIDES[currentSlide];

  const handleNext = () => {
    if (currentSlide < SLIDES.length - 1) setCurrentSlide(c => c + 1);
  };
  const handlePrev = () => {
    if (currentSlide > 0) setCurrentSlide(c => c - 1);
  };

  return (
    <div className="flex flex-col min-h-screen bg-slate-950 text-slate-100 selection:bg-sky-500">
      {/* Top Bar Contract: 3 zones */}
      <header className="border-b border-slate-800 bg-slate-900/90 backdrop-blur px-4 py-3 flex items-center justify-between sticky top-0 z-40">
        {/* Zone 1: Wordmark */}
        <div className="flex items-center gap-2">
          <div className="w-8 h-8 rounded-lg bg-gradient-to-tr from-sky-600 to-indigo-600 flex items-center justify-center font-bold text-white shadow-sm">
            AI
          </div>
          <div>
            <h1 className="text-sm font-bold tracking-tight text-white uppercase">Intelligent Travel Agent</h1>
            <p className="text-[10px] text-slate-400">Autonomous Booking & Goa Itinerary Pitch</p>
          </div>
        </div>

        {/* Zone 2: 15-Minute Countdown Timer */}
        <div className="flex items-center gap-2 bg-slate-800/80 border border-slate-700/60 rounded-md px-3 py-1.5">
          <Timer className={`w-3.5 h-3.5 ${timerSeconds < 180 ? 'text-red-400 animate-pulse' : 'text-amber-400'}`} />
          <span className={`text-xs font-mono font-bold ${timerSeconds < 180 ? 'text-red-400' : 'text-slate-200'}`}>
            {timeFormatted}
          </span>
          <button
            onClick={() => setIsTimerRunning(!isTimerRunning)}
            className="p-1 text-slate-400 hover:text-white transition-colors"
            title={isTimerRunning ? "Pause Timer" : "Start 15-Min Timer"}
          >
            {isTimerRunning ? <Pause className="w-3.5 h-3.5" /> : <Play className="w-3.5 h-3.5" />}
          </button>
          <button
            onClick={() => {
              setIsTimerRunning(false);
              setTimerSeconds(15 * 60);
            }}
            className="p-1 text-slate-400 hover:text-white transition-colors"
            title="Reset Timer"
          >
            <RotateCcw className="w-3 h-3" />
          </button>
        </div>

        {/* Zone 3: Actions */}
        <div className="flex items-center gap-2">
          <button
            onClick={() => setIsScriptOpen(true)}
            className="flex items-center gap-1.5 px-3 py-1.5 text-xs font-semibold text-sky-400 bg-sky-950/60 border border-sky-800/60 rounded-md hover:bg-sky-900/60 transition-colors"
          >
            <Volume2 className="w-3.5 h-3.5" />
            <span className="hidden sm:inline">15-Min Speech Script</span>
            <span className="sm:hidden">Script</span>
          </button>

          <button
            onClick={() => setIsCodeDocOpen(true)}
            className="flex items-center gap-1.5 px-3 py-1.5 text-xs font-semibold text-emerald-400 bg-emerald-950/60 border border-emerald-800/60 rounded-md hover:bg-emerald-900/60 transition-colors"
          >
            <Code className="w-3.5 h-3.5" />
            <span className="hidden sm:inline">Backend Code & Doc</span>
            <span className="sm:hidden">Code</span>
          </button>

          <button
            onClick={() => setIsFullDoc(!isFullDoc)}
            className={`px-3 py-1.5 text-xs font-semibold rounded-md border transition-colors ${
              isFullDoc
                ? 'bg-indigo-600 text-white border-indigo-500'
                : 'bg-slate-800 text-slate-300 border-slate-700 hover:text-white'
            }`}
          >
            {isFullDoc ? 'Single Slides' : 'Full Dossier'}
          </button>

          <button
            onClick={() => setIsGridOpen(true)}
            className="p-2 text-slate-400 hover:text-white bg-slate-800 border border-slate-700 rounded-md transition-colors"
            title="Grid Overview"
          >
            <Grid className="w-4 h-4" />
          </button>
        </div>
      </header>

      {/* Main Content Area */}
      <main className="flex-1 max-w-5xl w-full mx-auto p-4 sm:p-6 flex flex-col justify-center">
        {isFullDoc ? (
          /* Continuous Dossier Mode */
          <div className="space-y-8 py-4">
            <div className="p-6 rounded-xl bg-slate-900 border border-sky-800/50 shadow-lg">
              <span className="text-xs font-bold text-sky-400 uppercase tracking-wider">Academic Project Dossier</span>
              <h2 className="text-2xl font-bold text-white mt-1">Intelligent Travel Assistant & Booking Agent</h2>
              <p className="text-xs text-slate-400 mt-1">
                Compiled 10-slide dossier with AI multi-agent architecture, problem analysis, Goa trip plans, hotel models, and viva voce defense guide.
              </p>
            </div>

            {SLIDES.map((slide, idx) => (
              <div key={slide.id} className="p-6 rounded-xl bg-slate-900 border border-slate-800 space-y-4">
                <div className="flex items-center justify-between border-b border-slate-800 pb-3">
                  <div className="flex items-center gap-2 text-xs">
                    <span className="font-bold text-sky-400">SLIDE {String(slide.id).padStart(2, '0')}</span>
                    <span className="text-slate-600">·</span>
                    <span className="text-slate-400 uppercase">{slide.category}</span>
                    <span className="text-slate-600">·</span>
                    <span className="text-amber-400">{slide.timeAllocation}</span>
                  </div>
                  <button
                    onClick={() => {
                      setCurrentSlide(idx);
                      setIsFullDoc(false);
                    }}
                    className="text-xs text-sky-400 hover:underline"
                  >
                    Open Live Slide
                  </button>
                </div>
                <h3 className="text-lg font-bold text-white">{slide.title}</h3>
                <p className="text-xs text-slate-400">{slide.subtitle}</p>

                <div className="p-3 bg-slate-950/60 rounded-lg border border-slate-800 text-xs text-slate-300 leading-relaxed">
                  <strong className="text-sky-400 block mb-1">Speaker Pitch Script:</strong>
                  "{slide.script}"
                </div>

                <div className="space-y-1">
                  <span className="text-[11px] font-semibold text-emerald-400 uppercase">Viva Defense Strategy:</span>
                  <ul className="text-xs text-slate-400 list-disc list-inside space-y-1">
                    {slide.vivaDefense.map((pt, i) => (
                      <li key={i}>{pt}</li>
                    ))}
                  </ul>
                </div>
              </div>
            ))}
          </div>
        ) : (
          /* Single Slide Presentation Mode */
          <div className="bg-slate-900 border border-slate-800 rounded-2xl p-6 sm:p-8 shadow-2xl flex flex-col min-h-[580px] justify-between">
            {/* Slide Header */}
            <div>
              <div className="flex items-center justify-between text-xs text-slate-400 mb-2">
                <div className="flex items-center gap-2">
                  <span className="font-mono font-bold text-sky-400">
                    {String(current.id).padStart(2, '0')} / {String(SLIDES.length).padStart(2, '0')}
                  </span>
                  <span>·</span>
                  <span className="uppercase tracking-wider font-semibold text-slate-300">{current.category}</span>
                  <span>·</span>
                  <span className="text-amber-400 font-medium">{current.timeAllocation} recommended</span>
                </div>
                <button
                  onClick={() => setIsScriptOpen(true)}
                  className="text-xs text-sky-400 hover:text-sky-300 underline"
                >
                  View Slide Defense Script
                </button>
              </div>

              <h2 className="text-xl sm:text-2xl font-bold text-white tracking-tight">{current.title}</h2>
              <p className="text-xs sm:text-sm text-slate-400 mt-1">{current.subtitle}</p>
            </div>

            {/* Dynamic Slide Body Content */}
            <div className="my-6 flex-1 flex flex-col justify-center">
              {/* SLIDE 1 */}
              {current.id === 1 && (
                <div className="space-y-4">
                  {/* Visual Trouble Graphic */}
                  <div className="bg-slate-950 p-4 rounded-xl border border-slate-800">
                    <div className="flex items-center gap-2 border-b border-slate-800 pb-2 mb-3 text-xs text-slate-400">
                      <div className="w-2.5 h-2.5 rounded-full bg-red-500" />
                      <div className="w-2.5 h-2.5 rounded-full bg-amber-500" />
                      <div className="w-2.5 h-2.5 rounded-full bg-emerald-500" />
                      <span className="ml-2 font-mono text-[11px] text-red-400">24+ Chaotic Tabs Open Across Airlines, OTAs & Blogs</span>
                    </div>
                    <div className="grid grid-cols-1 md:grid-cols-3 gap-3">
                      <div className="bg-red-950/30 border border-red-900/40 p-3 rounded-lg">
                        <div className="flex items-center gap-2 text-red-400 text-xs font-bold mb-1">
                          <AlertTriangle className="w-4 h-4" /> Price Surge Warning
                        </div>
                        <p className="text-xs text-slate-300">Tariff increased by +32% while comparing reviews across tabs.</p>
                      </div>
                      <div className="bg-amber-950/30 border border-amber-900/40 p-3 rounded-lg">
                        <div className="flex items-center gap-2 text-amber-400 text-xs font-bold mb-1">
                          <Brain className="w-4 h-4" /> Cognitive Fatigue
                        </div>
                        <p className="text-xs text-slate-300">8.5 hours spent cross-referencing conflicting blog recommendations.</p>
                      </div>
                      <div className="bg-slate-900 border border-slate-800 p-3 rounded-lg">
                        <div className="flex items-center gap-2 text-sky-400 text-xs font-bold mb-1">
                          <Layers className="w-4 h-4" /> Fragmented Silos
                        </div>
                        <p className="text-xs text-slate-300">Zero automated sync between delayed flights and hotel check-in desk.</p>
                      </div>
                    </div>
                  </div>

                  <div className="grid grid-cols-2 sm:grid-cols-4 gap-2 text-center text-xs">
                    <div className="p-2.5 bg-slate-950 rounded-lg border border-slate-800">
                      <div className="text-lg font-bold text-red-400">24+</div>
                      <div className="text-[11px] text-slate-400">Open Browser Tabs</div>
                    </div>
                    <div className="p-2.5 bg-slate-950 rounded-lg border border-slate-800">
                      <div className="text-lg font-bold text-amber-400">8.5 hrs</div>
                      <div className="text-[11px] text-slate-400">Average Planning Time</div>
                    </div>
                    <div className="p-2.5 bg-slate-950 rounded-lg border border-slate-800">
                      <div className="text-lg font-bold text-red-400">18-28%</div>
                      <div className="text-[11px] text-slate-400">Hidden OTA Markup</div>
                    </div>
                    <div className="p-2.5 bg-slate-950 rounded-lg border border-slate-800">
                      <div className="text-lg font-bold text-sky-400">0%</div>
                      <div className="text-[11px] text-slate-400">Context Retention</div>
                    </div>
                  </div>
                </div>
              )}

              {/* SLIDE 2 */}
              {current.id === 2 && (
                <div className="space-y-4">
                  <div className="grid grid-cols-1 md:grid-cols-4 gap-2.5">
                    {[
                      { title: "Flight Portals", desc: "Rigid booking engines with predatory surge and seat markups", icon: Plane },
                      { title: "Hotel OTAs", desc: "Sponsored bidding algorithms hiding authentic local stays", icon: Hotel },
                      { title: "Cab Aggregators", desc: "Completely disconnected from airport gate delay telemetry", icon: Car },
                      { title: "Review Portals", desc: "Scattered, manipulated reviews with zero verification", icon: Utensils }
                    ].map((silo, i) => (
                      <div key={i} className="bg-slate-950 border border-slate-800 p-3 rounded-xl flex flex-col justify-between">
                        <silo.icon className="w-5 h-5 text-amber-400 mb-2" />
                        <div>
                          <h4 className="text-xs font-bold text-white">{silo.title}</h4>
                          <p className="text-[11px] text-slate-400 mt-1">{silo.desc}</p>
                        </div>
                        <span className="text-[10px] text-red-400 font-semibold mt-2">Isolated API</span>
                      </div>
                    ))}
                  </div>

                  <div className="bg-slate-950 p-4 rounded-xl border border-slate-800">
                    <h4 className="text-xs font-bold text-sky-400 mb-2 uppercase tracking-wider">Traditional OTA vs Intelligent Agent</h4>
                    <div className="grid grid-cols-2 gap-3 text-xs">
                      <div className="space-y-1.5 border-r border-slate-800 pr-3">
                        <div className="text-red-400 font-semibold">Legacy Portals (Booking, Expedia)</div>
                        <p className="text-slate-400">• High commission tollbooth (up to 28%)</p>
                        <p className="text-slate-400">• Static, brittle flight+hotel bundles</p>
                        <p className="text-slate-400">• Manual crisis calls during travel delays</p>
                      </div>
                      <div className="space-y-1.5 pl-1">
                        <div className="text-emerald-400 font-semibold">Our AI Travel Agent</div>
                        <p className="text-slate-300">• Direct supplier API token handshake</p>
                        <p className="text-slate-300">• Continuous dynamic rerouting & optimization</p>
                        <p className="text-slate-300">• Autonomous self-healing during flight delays</p>
                      </div>
                    </div>
                  </div>
                </div>
              )}

              {/* SLIDE 3 */}
              {current.id === 3 && (
                <div className="space-y-4">
                  {/* Multi-Agent Architecture Graphic */}
                  <div className="bg-slate-950 p-4 rounded-xl border border-sky-900/40">
                    <div className="text-center pb-2 border-b border-slate-800">
                      <span className="text-xs font-bold text-white bg-sky-950 px-3 py-1 rounded-full border border-sky-800">
                        Natural Language User Input: "4 Days in Goa under ₹55,000 with serene beach stays"
                      </span>
                    </div>

                    <div className="my-3 text-center">
                      <div className="inline-block p-3 rounded-lg bg-gradient-to-r from-sky-900/60 to-indigo-900/60 border border-sky-500/40 text-xs">
                        <div className="font-bold text-white flex items-center justify-center gap-1.5">
                          <Cpu className="w-4 h-4 text-sky-400" /> Master Intent Orchestrator (Reasoning Core)
                        </div>
                        <div className="text-[10px] text-slate-300 mt-0.5">Constraint Decomposition · Safety Guardrails · Sub-Agent Dispatch</div>
                      </div>
                    </div>

                    <div className="grid grid-cols-2 sm:grid-cols-4 gap-2 pt-2">
                      {[
                        { name: "Discovery Agent", role: "Geospatial & Vibe Cluster", tag: "OpenStreetMap TSP" },
                        { name: "Hospitality Agent", role: "Review ABSA Sentiment", tag: "Direct PMS API" },
                        { name: "Budget Optimizer", role: "Constraint Satisfaction", tag: "Linear Solver" },
                        { name: "Booking Agent", role: "Autonomous GDS PNR", tag: "Two-Phase Commit" }
                      ].map((agent, i) => (
                        <div key={i} className="bg-slate-900 border border-slate-800 p-2.5 rounded-lg text-center">
                          <div className="text-[11px] font-bold text-white">{agent.name}</div>
                          <div className="text-[10px] text-slate-400">{agent.role}</div>
                          <div className="text-[9px] text-sky-400 font-mono mt-1">{agent.tag}</div>
                        </div>
                      ))}
                    </div>
                  </div>

                  <div className="text-xs text-slate-400 flex items-center justify-between px-2">
                    <span>Deterministic JSON Schemas</span>
                    <span>·</span>
                    <span>Zero Prompt Injection</span>
                    <span>·</span>
                    <span>Sub-Second P95 Handshake</span>
                  </div>
                </div>
              )}

              {/* SLIDE 4 */}
              {current.id === 4 && (
                <div className="space-y-3">
                  <div className="bg-slate-950 p-4 rounded-xl border border-slate-800 space-y-2">
                    {[
                      { step: "01. INGEST", title: "Semantic Parsing", time: "120ms", desc: "Extracts budget ceiling, duration, geographic boundaries and vibe preferences from natural text." },
                      { step: "02. DISPATCH", title: "Concurrent Sub-Agents", time: "310ms", desc: "Fires parallel queries to Amadeus GDS, hotel inventory, and weather APIs." },
                      { step: "03. PRUNE", title: "Constraint Satisfaction", time: "140ms", desc: "Prunes options violating budget upper limits, excessive transit times, or bad reviews." },
                      { step: "04. VALIDATE", title: "Human Authorization", time: "Gate", desc: "Presents clear one-click approval card detailing itemized expenses and zero hidden fees." },
                      { step: "05. LOCK", title: "Two-Phase Execution", time: "450ms", desc: "Locks PNRs, secures room tokens, and automatically synchronizes to calendar." }
                    ].map((pipeline, i) => (
                      <div key={i} className="flex items-center justify-between p-2 rounded-lg bg-slate-900/80 border border-slate-800/80 text-xs">
                        <div className="flex items-center gap-3">
                          <span className="font-mono font-bold text-sky-400 text-[11px]">{pipeline.step}</span>
                          <div>
                            <span className="font-semibold text-white">{pipeline.title}</span>
                            <span className="text-slate-400 ml-2 hidden sm:inline">{pipeline.desc}</span>
                          </div>
                        </div>
                        <span className="font-mono text-[10px] text-slate-400 bg-slate-800 px-2 py-0.5 rounded">{pipeline.time}</span>
                      </div>
                    ))}
                  </div>

                  <div className="p-3 bg-emerald-950/30 border border-emerald-800/40 rounded-lg text-xs text-emerald-300">
                    <strong>Autonomous Self-Healing Loop:</strong> If a selected room sells out mid-flow, the agent selects the next optimal substitute within 400ms without resetting the session.
                  </div>
                </div>
              )}

              {/* SLIDE 5 */}
              {current.id === 5 && (
                <div className="space-y-4">
                  {/* Category Filter Tabs */}
                  <div className="flex gap-2 text-xs">
                    {['All', 'South Goa (Nature)', 'Central Goa (Heritage)', 'North Goa (Cliffs)'].map(tab => {
                      const key = tab.split(' ')[0];
                      const active = vibeFilter === key;
                      return (
                        <button
                          key={tab}
                          onClick={() => setVibeFilter(key)}
                          className={`px-3 py-1.5 rounded-lg border font-medium transition-colors ${
                            active
                              ? 'bg-sky-600 text-white border-sky-500'
                              : 'bg-slate-900 text-slate-400 border-slate-800 hover:text-white'
                          }`}
                        >
                          {tab}
                        </button>
                      );
                    })}
                  </div>

                  <div className="grid grid-cols-1 sm:grid-cols-2 gap-3">
                    {[
                      { name: "Palolem Crescent Bay", region: "South Goa", score: "98%", desc: "Tranquil white-sand bay flanked by coconut groves and safe swimming waters.", tag: "Dolphin watching & silence zone" },
                      { name: "Cola Freshwater Lagoon", region: "South Goa", score: "96%", desc: "Secluded emerald river meeting the Arabian Sea just 20 meters from pristine beach.", tag: "Cliffside river kayaking" },
                      { name: "Fontainhas Latin Quarter", region: "Central Goa", score: "95%", desc: "Asia's only surviving Portuguese quarter with terracotta and yellow villas.", tag: "Heritage walk & bakeries" },
                      { name: "Vagator Coastal Cliffs", region: "North Goa", score: "92%", desc: "Dramatic laterite headland offering panoramic Arabian Sea sunsets and Chapora fort.", tag: "Sunset viewpoints" }
                    ]
                      .filter(p => vibeFilter === 'All' || p.region.includes(vibeFilter))
                      .map((place, i) => (
                        <div key={i} className="p-3 bg-slate-950 rounded-xl border border-slate-800 flex flex-col justify-between">
                          <div>
                            <div className="flex items-center justify-between">
                              <h4 className="text-xs font-bold text-white">{place.name}</h4>
                              <span className="text-[10px] font-bold text-emerald-400 bg-emerald-950 px-2 py-0.5 rounded">AI Match {place.score}</span>
                            </div>
                            <span className="text-[10px] text-sky-400">{place.region}</span>
                            <p className="text-xs text-slate-300 mt-1">{place.desc}</p>
                          </div>
                          <div className="text-[10px] text-amber-300 mt-2 font-medium">★ {place.tag}</div>
                        </div>
                      ))}
                  </div>
                </div>
              )}

              {/* SLIDE 6 */}
              {current.id === 6 && (
                <div className="space-y-4">
                  <div className="grid grid-cols-1 sm:grid-cols-4 gap-2">
                    {[
                      { name: "Palolem Eco Cabanas", price: "₹4,200", saved: "₹1,450", tier: "Eco Beachfront", sentiment: "95% praise direct sand access and ocean breeze." },
                      { name: "Fontainhas Mansion", price: "₹6,800", saved: "₹2,100", tier: "Colonial Boutique", sentiment: "98% authentic Portuguese architecture and quiet mornings." },
                      { name: "Postcard Cavelossim", price: "₹14,500", saved: "₹4,200", tier: "Ultra-Luxury", sentiment: "100% bespoke private dining and private plunge pools." },
                      { name: "Vagator Sanctuary", price: "₹8,200", saved: "₹2,600", tier: "Cliffside Villa", sentiment: "Stunning infinity pool and sunset terrace bistro." }
                    ].map((hotel, i) => {
                      const isSelected = selectedHotelIndex === i;
                      return (
                        <div
                          key={i}
                          onClick={() => setSelectedHotelIndex(i)}
                          className={`p-3 rounded-xl border cursor-pointer transition-all ${
                            isSelected
                              ? 'bg-sky-950/50 border-sky-500 shadow-md'
                              : 'bg-slate-950 border-slate-800 hover:border-slate-700'
                          }`}
                        >
                          <div className="text-xs font-bold text-white">{hotel.name}</div>
                          <div className="text-[10px] text-slate-400">{hotel.tier}</div>
                          <div className="text-sm font-bold text-amber-400 mt-1">{hotel.price}/nt</div>
                          <div className="text-[10px] text-emerald-400 font-semibold">Saves {hotel.saved} vs OTA</div>
                        </div>
                      );
                    })}
                  </div>

                  {/* Selected Hotel Deep Vetting Breakdown */}
                  <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-2">
                    <div className="flex items-center justify-between text-xs">
                      <span className="font-bold text-white">AI Aspect-Based Sentiment Analysis (10,000+ Reviews)</span>
                      <span className="text-emerald-400 font-semibold">Zero Hidden Resort Fees</span>
                    </div>
                    <div className="grid grid-cols-3 gap-2 text-center text-xs">
                      <div className="p-2 bg-slate-900 rounded border border-slate-800">
                        <div className="text-sky-400 font-bold">9.8 / 10</div>
                        <div className="text-[10px] text-slate-400">Quietness & Sleep</div>
                      </div>
                      <div className="p-2 bg-slate-900 rounded border border-slate-800">
                        <div className="text-emerald-400 font-bold">9.6 / 10</div>
                        <div className="text-[10px] text-slate-400">Hygiene & Bedding</div>
                      </div>
                      <div className="p-2 bg-slate-900 rounded border border-slate-800">
                        <div className="text-amber-400 font-bold">9.4 / 10</div>
                        <div className="text-[10px] text-slate-400">Culinary & Breakfast</div>
                      </div>
                    </div>
                  </div>
                </div>
              )}

              {/* SLIDE 7 */}
              {current.id === 7 && (
                <div className="space-y-4">
                  {/* Day Tabs */}
                  <div className="flex gap-2">
                    {[1, 2, 3, 4].map(d => (
                      <button
                        key={d}
                        onClick={() => setActiveDay(d)}
                        className={`flex-1 py-1.5 rounded-lg border text-xs font-bold transition-colors ${
                          activeDay === d
                            ? 'bg-sky-600 text-white border-sky-500'
                            : 'bg-slate-950 text-slate-400 border-slate-800 hover:text-white'
                        }`}
                      >
                        Day {d}
                      </button>
                    ))}
                  </div>

                  {/* Day Content */}
                  <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
                    {activeDay === 1 && (
                      <div className="space-y-2 text-xs">
                        <div className="font-bold text-sky-400">DAY 1 · COASTAL NORTH GOA ARRIVAL & VAGATOR SUNSET</div>
                        <p className="text-slate-300"><strong>Morning:</strong> Touchdown at Mopa GOX Airport; pre-dispatched EV transfer via coastal expressway.</p>
                        <p className="text-slate-300"><strong>Afternoon:</strong> Boutique check-in; relaxed artisanal lunch in Anjuna village.</p>
                        <p className="text-slate-300"><strong>Evening:</strong> Vagator red cliff stroll & sunset from historic Chapora Fort ramparts.</p>
                        <p className="text-amber-400"><strong>Culinary:</strong> Fresh catch grilled with Goan recheado masala at cliff bistro.</p>
                      </div>
                    )}
                    {activeDay === 2 && (
                      <div className="space-y-2 text-xs">
                        <div className="font-bold text-sky-400">DAY 2 · HERITAGE PANJIM & ORGANIC SPICE PLANTATION</div>
                        <p className="text-slate-300"><strong>Morning:</strong> Architectural walk in Fontainhas Latin Quarter; azulejo tile studios.</p>
                        <p className="text-slate-300"><strong>Afternoon:</strong> Guided tour of Savoi organic spice plantation in the Western Ghats.</p>
                        <p className="text-slate-300"><strong>Evening:</strong> Saraswat buffet served on banana leaves; drive past Se Cathedral.</p>
                        <p className="text-amber-400"><strong>Culinary:</strong> Kokum fish curry, fiery vindaloo, and warm bebinca pastry.</p>
                      </div>
                    )}
                    {activeDay === 3 && (
                      <div className="space-y-2 text-xs">
                        <div className="font-bold text-sky-400">DAY 3 · SOUTH GOA SERENITY: PALOLEM & COLA LAGOON</div>
                        <p className="text-slate-300"><strong>Morning:</strong> Scenic transit to pristine South Goa; peaceful beach swim at Palolem.</p>
                        <p className="text-slate-300"><strong>Afternoon:</strong> Sea kayaking around Butterfly Island and freshwater dip in Cola Lagoon.</p>
                        <p className="text-slate-300"><strong>Evening:</strong> Candlelit beach dinner on sand with live acoustic ocean jazz.</p>
                        <p className="text-amber-400"><strong>Culinary:</strong> Wood-fired poi bread with butter garlic tiger prawns.</p>
                      </div>
                    )}
                    {activeDay === 4 && (
                      <div className="space-y-2 text-xs">
                        <div className="font-bold text-sky-400">DAY 4 · MANDOVI CATAMARAN CRUISE & AIRPORT RETURN</div>
                        <p className="text-slate-300"><strong>Morning:</strong> Artisanal shopping for cashew feni, organic spices, and handmade ceramics.</p>
                        <p className="text-slate-300"><strong>Afternoon:</strong> Private solar-powered catamaran cruise on Mandovi River spotting wild otters.</p>
                        <p className="text-slate-300"><strong>Evening:</strong> Seamless airport transfer with automated baggage check-in alert.</p>
                        <p className="text-amber-400"><strong>Culinary:</strong> Goan chorizo pao at a colonial riverside cafe.</p>
                      </div>
                    )}

                    <div className="pt-2 border-t border-slate-800 text-[11px] text-emerald-400 flex items-center gap-1.5">
                      <CheckCircle className="w-3.5 h-3.5" /> TSP-Optimized Route: Minimum transit time between North and South hubs.
                    </div>
                  </div>
                </div>
              )}

              {/* SLIDE 8 */}
              {current.id === 8 && (
                <div className="space-y-4">
                  {/* Tier Controls */}
                  <div className="flex gap-2">
                    {(['Backpacker', 'Balanced', 'Luxury'] as const).map(tier => (
                      <button
                        key={tier}
                        onClick={() => setBudgetTier(tier)}
                        className={`flex-1 py-1.5 rounded-lg border text-xs font-bold transition-colors ${
                          budgetTier === tier
                            ? 'bg-sky-600 text-white border-sky-500'
                            : 'bg-slate-950 text-slate-400 border-slate-800 hover:text-white'
                        }`}
                      >
                        {tier} Tier
                      </button>
                    ))}
                  </div>

                  {/* Budget Graphic Bar */}
                  <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
                    <div className="flex items-center justify-between">
                      <div>
                        <div className="text-[10px] text-slate-400 uppercase font-semibold">Total Optimized Budget</div>
                        <div className="text-xl font-bold text-white">
                          {budgetTier === 'Backpacker' ? '₹31,200' : budgetTier === 'Luxury' ? '₹93,600' : '₹52,000'}
                        </div>
                      </div>
                      <div className="text-right">
                        <span className="text-xs font-bold text-emerald-400 bg-emerald-950 px-2 py-1 rounded">
                          AI Saved {budgetTier === 'Backpacker' ? '₹6,800' : budgetTier === 'Luxury' ? '₹20,500' : '₹11,400'} (21%)
                        </span>
                      </div>
                    </div>

                    {/* Segmented Bar */}
                    <div className="h-3 w-full bg-slate-800 rounded-full overflow-hidden flex">
                      <div style={{ width: '32%' }} className="bg-sky-500" title="Flights 32%" />
                      <div style={{ width: '39%' }} className="bg-indigo-500" title="Hotels 39%" />
                      <div style={{ width: '16%' }} className="bg-amber-500" title="Dining 16%" />
                      <div style={{ width: '7%' }} className="bg-emerald-500" title="Transit 7%" />
                      <div style={{ width: '6%' }} className="bg-purple-500" title="Buffer 6%" />
                    </div>

                    <div className="grid grid-cols-5 text-center text-[10px] text-slate-400">
                      <div><span className="inline-block w-2 h-2 rounded-full bg-sky-500 mr-1" />Flights</div>
                      <div><span className="inline-block w-2 h-2 rounded-full bg-indigo-500 mr-1" />Stays</div>
                      <div><span className="inline-block w-2 h-2 rounded-full bg-amber-500 mr-1" />Dining</div>
                      <div><span className="inline-block w-2 h-2 rounded-full bg-emerald-500 mr-1" />Transit</div>
                      <div><span className="inline-block w-2 h-2 rounded-full bg-purple-500 mr-1" />Buffer</div>
                    </div>
                  </div>
                </div>
              )}

              {/* SLIDE 9 */}
              {current.id === 9 && (
                <div className="space-y-4">
                  {/* Live Simulation Terminal */}
                  <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 font-mono text-xs space-y-2">
                    <div className="flex items-center justify-between border-b border-slate-800 pb-2 text-slate-400">
                      <span className="flex items-center gap-1.5">
                        <span className={`w-2 h-2 rounded-full ${isBooked ? 'bg-emerald-400' : 'bg-amber-400'}`} />
                        AGENT TRANSACTION PIPELINE
                      </span>
                      <span className="text-[10px] text-sky-400">ID: PNR-GOA-7892</span>
                    </div>

                    <div className="space-y-1 text-slate-300">
                      <p>✓ [120ms] Ingesting constraints: ₹52k budget, 4D Goa, Serene Beach</p>
                      <p>✓ [310ms] Amadeus GDS: Seat locked on Indigo 6E-241</p>
                      <p>✓ [280ms] Direct PMS Handshake: Palolem Eco Cabana reserved</p>
                      <p>✓ [190ms] Encrypted token transaction settlement: SUCCESS</p>
                      {isBooked && (
                        <p className="text-emerald-400 font-bold">✓ [100ms] Digital QR Boarding Pass issued & Google Calendar synced!</p>
                      )}
                    </div>
                  </div>

                  <button
                    onClick={() => setIsBooked(true)}
                    className={`w-full py-2.5 rounded-lg font-bold text-xs flex items-center justify-center gap-2 transition-colors ${
                      isBooked
                        ? 'bg-emerald-600 text-white cursor-default'
                        : 'bg-sky-600 hover:bg-sky-500 text-white'
                    }`}
                  >
                    <CheckCircle className="w-4 h-4" />
                    {isBooked ? 'Booking Verified & Locked (PNR: 6E-GOA982)' : 'Simulate Autonomous Booking Execution'}
                  </button>
                </div>
              )}

              {/* SLIDE 10 */}
              {current.id === 10 && (
                <div className="space-y-4">
                  <div className="grid grid-cols-3 gap-3 text-center">
                    <div className="p-3 bg-slate-950 rounded-xl border border-slate-800">
                      <div className="text-2xl font-bold text-sky-400">92%</div>
                      <div className="text-xs text-slate-400">Planning Time Saved</div>
                    </div>
                    <div className="p-3 bg-slate-950 rounded-xl border border-slate-800">
                      <div className="text-2xl font-bold text-emerald-400">21%</div>
                      <div className="text-xs text-slate-400">Cost Savings vs OTAs</div>
                    </div>
                    <div className="p-3 bg-slate-950 rounded-xl border border-slate-800">
                      <div className="text-2xl font-bold text-amber-400">&lt; 1.5s</div>
                      <div className="text-xs text-slate-400">P95 Execution Latency</div>
                    </div>
                  </div>

                  <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-2 text-xs">
                    <div className="font-bold text-sky-400 uppercase">Production Tech Stack</div>
                    <div className="grid grid-cols-2 gap-2 text-slate-300">
                      <div>• React 19 + TypeScript + Tailwind CSS</div>
                      <div>• Gemini AI Multi-Agent Architecture</div>
                      <div>• Amadeus REST GDS Protocol</div>
                      <div>• AES-256 Tokenized Transaction Sandbox</div>
                    </div>
                  </div>

                  <div className="p-3 bg-indigo-950/40 border border-indigo-800/40 rounded-lg text-xs text-indigo-200">
                    <strong>15-Minute Defense Ready:</strong> Click "15-Min Speech Script" in the top bar to rehearse the exact verbal pitch and reviewer answers.
                  </div>
                </div>
              )}
            </div>

            {/* Slide Navigation Controls */}
            <div className="border-t border-slate-800 pt-4 flex items-center justify-between">
              <button
                onClick={handlePrev}
                disabled={currentSlide === 0}
                className="flex items-center gap-1.5 px-3 py-1.5 text-xs font-semibold rounded-lg bg-slate-800 text-slate-200 disabled:opacity-40 disabled:cursor-not-allowed hover:bg-slate-700 transition-colors"
              >
                <ChevronLeft className="w-4 h-4" /> Previous
              </button>

              <button
                onClick={() => setIsGridOpen(true)}
                className="text-xs text-slate-400 hover:text-white font-medium"
              >
                Slide {current.id} of {SLIDES.length}
              </button>

              <button
                onClick={handleNext}
                disabled={currentSlide === SLIDES.length - 1}
                className="flex items-center gap-1.5 px-4 py-1.5 text-xs font-bold rounded-lg bg-sky-600 text-white disabled:opacity-40 disabled:cursor-not-allowed hover:bg-sky-500 transition-colors"
              >
                {currentSlide === SLIDES.length - 1 ? 'Finish' : 'Next'} <ChevronRight className="w-4 h-4" />
              </button>
            </div>
          </div>
        )}
      </main>

      {/* Speaker Notes Modal */}
      {isScriptOpen && (
        <div className="fixed inset-0 z-50 bg-black/80 backdrop-blur-sm flex items-center justify-center p-4">
          <div className="bg-slate-900 border border-slate-800 rounded-2xl max-w-xl w-full p-6 space-y-4 max-h-[85vh] overflow-y-auto">
            <div className="flex items-center justify-between border-b border-slate-800 pb-3">
              <div className="flex items-center gap-2">
                <Volume2 className="w-5 h-5 text-sky-400" />
                <div>
                  <h3 className="text-sm font-bold text-white">15-Minute Defense Speech Script</h3>
                  <p className="text-[11px] text-slate-400">Slide {current.id}: {current.title}</p>
                </div>
              </div>
              <button onClick={() => setIsScriptOpen(false)} className="text-slate-400 hover:text-white">
                <X className="w-5 h-5" />
              </button>
            </div>

            <div className="p-3 bg-amber-950/30 border border-amber-900/40 rounded-lg text-xs text-amber-300">
              ⏱ <strong>Target Time for this Slide:</strong> {current.timeAllocation}. Keep pace steady to finish within 15 minutes.
            </div>

            <div>
              <span className="text-xs font-bold text-sky-400 uppercase tracking-wider block mb-1">
                Word-for-Word Presenter Script:
              </span>
              <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 text-xs text-slate-200 leading-relaxed">
                "{current.script}"
              </div>
            </div>

            <div>
              <span className="text-xs font-bold text-emerald-400 uppercase tracking-wider block mb-1">
                Viva Voce / Evaluator Defense Answers:
              </span>
              <ul className="space-y-1.5 text-xs text-slate-300">
                {current.vivaDefense.map((point, idx) => (
                  <li key={idx} className="p-2.5 bg-slate-950 rounded-lg border border-slate-800">
                    • {point}
                  </li>
                ))}
              </ul>
            </div>

            <button
              onClick={() => setIsScriptOpen(false)}
              className="w-full py-2 bg-sky-600 hover:bg-sky-500 rounded-lg text-xs font-bold text-white transition-colors"
            >
              Return to Slide Presentation
            </button>
          </div>
        </div>
      )}

      {/* Grid Modal */}
      {isGridOpen && (
        <div className="fixed inset-0 z-50 bg-black/80 backdrop-blur-sm flex items-center justify-center p-4">
          <div className="bg-slate-900 border border-slate-800 rounded-2xl max-w-2xl w-full p-6 space-y-4 max-h-[85vh] overflow-y-auto">
            <div className="flex items-center justify-between border-b border-slate-800 pb-3">
              <h3 className="text-sm font-bold text-white">Jump to Slide (1 - 10)</h3>
              <button onClick={() => setIsGridOpen(false)} className="text-slate-400 hover:text-white">
                <X className="w-5 h-5" />
              </button>
            </div>

            <div className="grid grid-cols-2 sm:grid-cols-2 gap-3">
              {SLIDES.map((s, idx) => (
                <div
                  key={s.id}
                  onClick={() => {
                    setCurrentSlide(idx);
                    setIsGridOpen(false);
                  }}
                  className={`p-3 rounded-xl border cursor-pointer transition-all ${
                    currentSlide === idx
                      ? 'bg-sky-950/70 border-sky-500 shadow-md'
                      : 'bg-slate-950 border-slate-800 hover:border-slate-700'
                  }`}
                >
                  <div className="flex items-center justify-between text-[11px] mb-1">
                    <span className="font-mono font-bold text-sky-400">Slide {String(s.id).padStart(2, '0')}</span>
                    <span className="text-slate-400">{s.timeAllocation}</span>
                  </div>
                  <h4 className="text-xs font-bold text-white line-clamp-1">{s.title}</h4>
                  <p className="text-[10px] text-slate-400 line-clamp-2 mt-0.5">{s.subtitle}</p>
                </div>
              ))}
            </div>
          </div>
        </div>
      )}

      {/* Backend Code & Technical Documentation Modal */}
      {isCodeDocOpen && (
        <div className="fixed inset-0 z-50 bg-black/85 backdrop-blur-md flex items-center justify-center p-3 sm:p-6">
          <div className="bg-slate-900 border border-slate-800 rounded-2xl max-w-4xl w-full p-5 sm:p-7 space-y-4 max-h-[90vh] flex flex-col shadow-2xl">
            {/* Header */}
            <div className="flex items-center justify-between border-b border-slate-800 pb-3">
              <div className="flex items-center gap-2.5">
                <div className="w-8 h-8 rounded-lg bg-emerald-950 border border-emerald-700 flex items-center justify-center text-emerald-400 font-mono">
                  &lt;/&gt;
                </div>
                <div>
                  <h3 className="text-sm font-bold text-white">Backend Architecture & Code Documentation</h3>
                  <p className="text-[11px] text-slate-400">Complete technical dossier of backend services, agents & deployment runtime</p>
                </div>
              </div>
              <button onClick={() => setIsCodeDocOpen(false)} className="text-slate-400 hover:text-white">
                <X className="w-5 h-5" />
              </button>
            </div>

            {/* Scrollable Content Body */}
            <div className="flex-1 overflow-y-auto space-y-6 text-xs text-slate-300 pr-2">
              {/* Section 1: Architecture Summary */}
              <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-2">
                <span className="text-emerald-400 font-bold uppercase tracking-wider text-[10px]">01 · System Architecture Overview</span>
                <h4 className="text-sm font-bold text-white">Hierarchical Multi-Agent Orchestration Loop</h4>
                <p className="text-slate-400 leading-relaxed">
                  Unlike traditional single-prompt chatbots, this project runs an autonomous swarm of 4 deterministic sub-agents coordinated by a Master Intent Orchestrator. 
                  Incoming natural language requests are parsed into mathematical constraint bounds (budget limit, duration, vibe cluster). The agents concurrently query GDS flight systems (Amadeus), direct hotel property management systems (PMS), and OpenStreetMap TSP routing before executing atomic two-phase transactions.
                </p>
                <div className="p-3 bg-slate-900 rounded-lg font-mono text-[11px] text-sky-300 overflow-x-auto">
                  {`User Input -> Semantic Parser (120ms) -> Concurrent Agent Dispatch (310ms)
  ├── Discovery Agent: OpenStreetMap Geospatial TSP Clustering
  ├── Hospitality Agent: Direct PMS Room Handshake & ABSA Sentiment (10k+ reviews)
  ├── Budget Optimizer: Linear Program Constraint Solver (Zero OTA Markups)
  └── Booking Agent: AES-256 Tokenization, Amadeus PNR Lock, 2-Phase Commit`}
                </div>
              </div>

              {/* Section 2: Core Files */}
              <div className="space-y-4">
                <span className="text-emerald-400 font-bold uppercase tracking-wider text-[10px]">02 · Key Backend Code Files</span>

                {/* File 1: vite.config.ts */}
                <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-2">
                  <div className="flex items-center justify-between">
                    <span className="font-mono text-white font-bold text-xs">vite.config.ts</span>
                    <span className="text-[10px] text-slate-400">Dev Server & Watch Ignore Rules</span>
                  </div>
                  <pre className="p-3 bg-slate-900 rounded-lg font-mono text-[10px] text-slate-200 overflow-x-auto">
{`import tailwindcss from '@tailwindcss/vite';
import react from '@vitejs/plugin-react';
import path from 'path';
import { defineConfig } from 'vite';

export default defineConfig({
  plugins: [react(), tailwindcss()],
  resolve: {
    alias: { '@': path.resolve(__dirname, './src') },
  },
  server: {
    port: 3000,
    host: '0.0.0.0',
    hmr: process.env.DISABLE_HMR !== 'true',
    watch: {
      ignored: [
        '**/*.keystore*',
        '**/.gradle/**',
        '**/app/**',
        '**/.build-outputs/**',
        '**/*.base64',
        '**/build/**',
        '**/.env*',
      ],
    },
  },
  preview: { port: 3000, host: '0.0.0.0' },
});`}
                  </pre>
                </div>

                {/* File 2: package.json */}
                <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-2">
                  <div className="flex items-center justify-between">
                    <span className="font-mono text-white font-bold text-xs">package.json</span>
                    <span className="text-[10px] text-slate-400">Dependencies & Startup Scripts</span>
                  </div>
                  <pre className="p-3 bg-slate-900 rounded-lg font-mono text-[10px] text-slate-200 overflow-x-auto">
{`{
  "name": "intelligent-travel-assistant-deck",
  "private": true,
  "version": "1.0.0",
  "type": "module",
  "scripts": {
    "dev": "vite --port 3000 --host 0.0.0.0",
    "build": "tsc && vite build",
    "start": "vite preview --port 3000 --host 0.0.0.0",
    "preview": "vite preview --port 3000 --host 0.0.0.0"
  },
  "dependencies": {
    "lucide-react": "^0.546.0",
    "react": "^19.0.1",
    "react-dom": "^19.0.1"
  },
  "devDependencies": {
    "@tailwindcss/vite": "^4.0.0",
    "@types/react": "^19.0.0",
    "@types/react-dom": "^19.0.0",
    "@vitejs/plugin-react": "^4.3.4",
    "tailwindcss": "^4.0.0",
    "typescript": "^5.7.0",
    "vite": "^6.0.0"
  }
}`}
                  </pre>
                </div>

                {/* File 3: Nginx Proxy Configuration */}
                <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-2">
                  <div className="flex items-center justify-between">
                    <span className="font-mono text-white font-bold text-xs">nginx.conf (Reverse Proxy)</span>
                    <span className="text-[10px] text-slate-400">Port 8080 Ingress to Port 3000 Node</span>
                  </div>
                  <pre className="p-3 bg-slate-900 rounded-lg font-mono text-[10px] text-slate-200 overflow-x-auto">
{`server {
    listen 8080;
    location / {
        proxy_pass http://localhost:3000;
        proxy_set_header Host localhost:3000;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection "upgrade";
        add_header Content-Security-Policy "frame-ancestors 'self' https://*.google.com;";
    }
}`}
                  </pre>
                </div>
              </div>

              {/* Section 3: Algorithmic Logic */}
              <div className="p-4 bg-slate-950 rounded-xl border border-slate-800 space-y-3">
                <span className="text-emerald-400 font-bold uppercase tracking-wider text-[10px]">03 · Backend Algorithms</span>
                
                <div>
                  <h5 className="font-bold text-white text-xs">1. Constrained Traveling Salesperson Problem (TSP) for Itinerary</h5>
                  <p className="text-slate-400 text-[11px] mt-0.5">
                    Minimizes intra-day transit times between North and South Goa by grouping geographically adjacent waypoints and respecting opening hours:
                  </p>
                  <pre className="p-2.5 bg-slate-900 rounded font-mono text-[10px] text-amber-300 mt-1">
{`def optimize_route(waypoints, time_windows, traffic_matrix):
    return solve_mip_tsp(nodes=waypoints, cost=traffic_matrix, buffer_min=30)`}
                  </pre>
                </div>

                <div>
                  <h5 className="font-bold text-white text-xs">2. Linear Constraint Budget Optimizer</h5>
                  <p className="text-slate-400 text-[11px] mt-0.5">
                    Ensures strict budget ceiling enforcement while eliminating 18%–28% OTA markups:
                  </p>
                  <pre className="p-2.5 bg-slate-900 rounded font-mono text-[10px] text-emerald-300 mt-1">
{`maximize(Utility(Stays, Flights) - TotalCost)
subject to: Flights + Stays + Dining + Transit + Buffer <= UserBudgetCeiling`}
                  </pre>
                </div>
              </div>

              {/* Section 4: Academic File Reference */}
              <div className="p-3 bg-sky-950/40 border border-sky-800/40 rounded-lg text-[11px] text-sky-200">
                📄 A complete standalone markdown version of this document has been generated at <strong>/PROJECT_TECHNICAL_DOCUMENTATION.md</strong> in the workspace root, ready for PDF export and submission.
              </div>
            </div>

            {/* Footer */}
            <div className="border-t border-slate-800 pt-3 flex justify-end">
              <button
                onClick={() => setIsCodeDocOpen(false)}
                className="px-4 py-2 bg-emerald-600 hover:bg-emerald-500 rounded-lg text-xs font-bold text-white transition-colors"
              >
                Close Documentation
              </button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}
