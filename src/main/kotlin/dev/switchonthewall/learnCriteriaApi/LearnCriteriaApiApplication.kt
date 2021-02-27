package dev.switchonthewall.learnCriteriaApi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@EnableJpaRepositories("dev.switchonthewall.learnCriteriaApi.repository")
@EntityScan("dev.switchonthewall.learnCriteriaApi.model")
@ComponentScan("dev.switchonthewall.learnCriteriaApi.service")

@SpringBootApplication
class LearnCriteriaApiApplication

fun main(args: Array<String>) {
	runApplication<LearnCriteriaApiApplication>(*args)
}
