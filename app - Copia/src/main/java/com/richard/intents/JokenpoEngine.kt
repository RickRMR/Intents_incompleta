package com.richard.intents

import kotlin.random.Random

enum class Result{
    WIN, DRAW, LOSS
}

class JokenpoEngine(private val availablePlays: Array<String>) {

    fun calculateResult(playerPlay: String): Result{
        val aIPlay= getAIPlay()

        return when{
            playerPlay == aIPlay -> Result.DRAW
            playerPlay == "Pedra" && aIPlay == "Tesoura" -> Result.WIN
            playerPlay == "Pedra" && aIPlay == "Papel" -> Result.LOSS
            playerPlay == "Papel" && aIPlay == "Pedra" -> Result.WIN
            playerPlay == "Papel" && aIPlay == "Tesoura" -> Result.LOSS
            playerPlay == "Tesoura" && aIPlay == "Papel" -> Result.WIN
            playerPlay == "Tesoura" && aIPlay == "Pedra" -> Result.LOSS
            else -> Result.LOSS
        }
    }

    private fun getAIPlay() : String{
        val playIndex = Random.nextInt(0 , 2)

        return availablePlays[playIndex]
    }
}