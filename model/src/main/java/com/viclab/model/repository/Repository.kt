package com.viclab.model.repository

data class Repository(
    val name: String,
    val score: Int,
    val forks: Int,
    val owner: Owner,
)
