package com.example.androiddemoproject.kotlinbasics

interface Worker {
    val name: String
    fun work(task: Task)

//    override fun toString() = "$name" // can't override methods of 'Any' in interface!
}

data class Task(val name: String, val assignedTo: Worker)

class Colleague(override val name: String) : Worker {
    override fun work(task: Task) {
        println("${task.name}, assigned to ${task.assignedTo} done by $name")
    }
}

class TaskManager(private val worker: Worker) : Worker by worker

fun main() {
    val denis = Colleague(name = "Denis")
    val ankit = TaskManager(denis)
    val task = Task("payment api integration", assignedTo = ankit)
    ankit.work(task)
}