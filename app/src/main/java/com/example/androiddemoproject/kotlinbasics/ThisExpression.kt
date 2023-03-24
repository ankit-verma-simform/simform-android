package com.example.androiddemoproject.kotlinbasics

class Universe(private val name: String) {

    private var _worlds = mutableListOf<World>()
    val worlds: List<World>
        get() = _worlds

    inner class World(private val name: String) {

        private var _planets = mutableListOf<Planet>()
        val planets: List<Planet>
            get() = _planets

        inner class Planet(private val name: String) { // can only have inner class inside inner class
            fun info() {
                println("Planet - $name")
                println("World - ${this@World.name}")
                println("Universe - ${this@Universe.name}")
            }

            override fun toString() = "Planet(name=$name)"
        }

        //        data class Planet(private val name: String) // can't have data class inside inner class
        fun add(planetName: String) {
            _planets.add(Planet(name = planetName))
        }

        override fun toString() = "World(name=$name, planets=[$_planets])"
    }

    fun add(worldName: String) {
        _worlds.add(World(name = worldName))
    }

    override fun toString() = "Universe(name=$name, worlds=[$_worlds])"
}

fun main() {
    val universe = Universe(name = "the only universe")
    val solarSystem = universe.World(name = "solar system")
    val earth = solarSystem.Planet(name = "earth")
    earth.info()

    println(universe.worlds)

    solarSystem.add(planetName = "mars")
    solarSystem.add(planetName = "saturn")

    println("Planets:", solarSystem.planets)

    // showing whole universe
    println(universe)
}
