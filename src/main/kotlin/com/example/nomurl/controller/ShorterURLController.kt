package com.example.nomurl.controller

import com.example.nomurl.service.UrlService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI


@RestController
@RequestMapping("/api/nomurl")
class ShorterURLController(
    private val urlService: UrlService
) {
    @PostMapping
    fun createUrlShorter(@RequestBody url: String): ResponseEntity<String?> {
        return ResponseEntity.ok(urlService.createUrlShort(url))
    }

    @GetMapping("/redirect/{id}")
    fun redirectTo(@PathVariable id: String): ResponseEntity<Any> =
        urlService.redirectToUrl(id)


}