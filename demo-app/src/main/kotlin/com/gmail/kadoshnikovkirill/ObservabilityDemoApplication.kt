package com.gmail.kadoshnikovkirill.observability_demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ObservabilityDemoApplication

fun main(args: Array<String>) {
	runApplication<ObservabilityDemoApplication>(*args)
}
