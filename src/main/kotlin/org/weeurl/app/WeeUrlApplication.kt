package org.weeurl.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WeeUrlApplication

fun main(args: Array<String>) {
    SpringApplication.run(WeeUrlApplication::class.java, *args)
}
