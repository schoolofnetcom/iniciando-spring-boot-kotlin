package com.schoolofnet.KotlinSpring

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hello")
class HelloController {
	
	@GetMapping("/")
	fun hello() =
		"Hello World From Kotlin using SpringBoot"
}