package com.gmail.kadoshnikovkirill

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicReference

@RestController
@RequestMapping("/tinyurl")
class URLShortenerController {

    private val urls = AtomicReference<Array<String>>(emptyArray())

    @PostMapping
    fun link(@RequestParam url: String): String {
        while (true) {
            val curr = urls.get()
            if (curr.contains(url)) {
                return "http://127.0.0.1:8080/tinyurl/" + curr.indexOf(url)
            }
            val tinyUrl = "http://127.0.0.1:8080/tinyurl/${curr.size}"
            if (urls.compareAndSet(curr, curr + url)) {
                println("shortUrl: $tinyUrl, original url: $url")
                return tinyUrl
            }
        }
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): String = urls.get()[id]
}