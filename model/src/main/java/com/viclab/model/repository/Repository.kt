package com.viclab.model.repository

data class Repository(
    val name: String,
    val score: Float,
    val forks: Int,
    val owner: Owner,
)
