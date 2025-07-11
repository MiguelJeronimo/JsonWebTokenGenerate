package org.mike

import com.auth0.jwt.algorithms.Algorithm
import org.mike.JWTUtils.JsonWebToken
import java.util.Scanner

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val scanner = Scanner(System.`in`)
    val jsonWebToken = JsonWebToken()
    println(
        """
        ╔══════════════════════════════════════╗
        ║  🎯 Script: JsonWebTokenGenerate     ║
        ║  🧑‍💻 Created by: Mike                 ║
        ╚══════════════════════════════════════╝
        """.trimIndent()
    )
    var continueFlow: Boolean
    while (true){
        print("INGRESA TU KEY: ")
        val key = scanner.nextLine()
        print("INGRESA TU SECRET: ")
        val secret = scanner.nextLine()
        val token = jsonWebToken
            .key(key= key)
            .algorithm(algorithm = Algorithm.HMAC256(secret))
            .generate()
        println("**********---------------*-**-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*")
        println("JSON WEB TOKEN: $token")
        println("**********---------------*-**-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*")
        println("DESEAS GENERAR OTRO WEB TOKEN? YES(Y)/No(N)...")
        val brand  = scanner.nextLine()
        continueFlow = brand.lowercase() == "y"
        if (continueFlow){
            break
        }
    }
}