package com.example.nomurl.domain.repository

import com.example.nomurl.domain.entity.CompleteUrl
import org.springframework.data.repository.CrudRepository

interface CompleteUrlRepository : CrudRepository<CompleteUrl, Long> {
    fun findByShortUrl(shortUrl : String) : CompleteUrl
}