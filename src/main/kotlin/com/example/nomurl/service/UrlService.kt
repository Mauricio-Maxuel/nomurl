package com.example.nomurl.service

import com.example.nomurl.domain.dto.CreateShortURL
import com.example.nomurl.domain.entity.CompleteUrl
import com.example.nomurl.domain.repository.CompleteUrlRepository
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.net.URI
import java.util.*


@Service
class UrlService {
    private val logger = KotlinLogging.logger {}

    @Autowired
    private lateinit var repository: CompleteUrlRepository

    fun createUrlShort(url: String): String? {
        logger.info { "creating a URl short" }

        // validation http:// or https://

//        validProtocol(createShorterUrl)
        val code = UUID.randomUUID().mostSignificantBits;
        val save = try {
            repository.save(CompleteUrl(null, url.trim(), "$URL_NOMURL$code", 60L))
        } catch (ex: Exception) {
            throw Exception("Erro ao salvar URL", ex)
        }

        return save.shortUrl;
    }


    fun redirectToUrl(id: String): ResponseEntity<Any> {
        logger.info { "Redirect " }

        // validation http:// or https://

//        validProtocol(createShorterUrl)
        val findByShortUrl = repository.findByShortUrl(URL_NOMURL + id)
        val cleanedString = findByShortUrl.url.trim().replace("\"", "")
        val headers = HttpHeaders()
        headers.location = URI.create(cleanedString)
        return ResponseEntity<Any>(headers, HttpStatus.MOVED_PERMANENTLY)
    }

    private fun validProtocol(createShorterUrl: CreateShortURL) {
        logger.info { "valid a URL" }
        // to do ("Not yet implemented")
    }

    companion object {
        val URL_NOMURL = "http://localhost:8080/api/nomurl/redirect/"
    }

}