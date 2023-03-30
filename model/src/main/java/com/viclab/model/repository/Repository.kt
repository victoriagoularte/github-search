package com.viclab.model.repository

data class Repository(
    val id: Long,
    val name: String,
    val score: Int,
    val forks: Int,
    val owner: Owner,
)
