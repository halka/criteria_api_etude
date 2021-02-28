package dev.switchonthewall.learnCriteriaApi

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories("dev.switchonthewall.learnCriteriaApi.repository")
@EntityScan("dev.switchonthewall.learnCriteriaApi.model")

class LearnCriteriaApiApplication

fun main(args: Array<String>) {
	runApplication<LearnCriteriaApiApplication>(*args)
}
