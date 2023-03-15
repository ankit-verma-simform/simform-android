package com.example.androiddemoproject.revision.misc

interface Engine {
    fun runsOn()
    fun transmission()
}

class ElectricEngine: Engine {
    override fun runsOn() {
        println("Runs on electricity")
    }

    override fun transmission() {
        println("Manual transmission")
    }
}

class TeslaEngine(private val engine: Engine): Engine {
    override fun runsOn() {
        engine.runsOn()
    }

    override fun transmission() {
        engine.transmission()
    }
}

class Electra(private val engine: Engine): Engine by engine {
    override fun transmission() {
        println("Not applicable")
    }
}

fun main() {
    val teslaEngine = TeslaEngine(engine = ElectricEngine())
    val electraEngine = TeslaEngine(engine = ElectricEngine())

    teslaEngine.runsOn()
    teslaEngine.transmission()

    electraEngine.runsOn()
    electraEngine.transmission()
}