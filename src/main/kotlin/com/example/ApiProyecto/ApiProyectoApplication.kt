package com.example.ApiProyecto

import com.example.ApiProyecto.security.RSAKeysProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(RSAKeysProperties::class)
class ApiProyectoApplication

fun main(args: Array<String>) {
	runApplication<ApiProyectoApplication>(*args)
}
