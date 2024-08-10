package com.example.nomurl.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
data class CompleteUrl(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long? = null,
    val url: String,
    val shortUrl: String,
    val ttl: Long?
)
