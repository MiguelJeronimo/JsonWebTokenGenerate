package org.mike.JWTUtils

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm

import java.util.Date

/**
 * Generate web token
 * @param token issuer
 * @param secret generado por Kong
 * **/
class JsonWebToken {
        private var keyValue = ""
        private lateinit var algorithmValue: Algorithm

        fun key(key: String): JsonWebToken {
            keyValue = key
            return this
        }

        fun algorithm(algorithm: Algorithm): JsonWebToken {
            algorithmValue = algorithm
            return this
        }

        fun generate(): String? {
            // 1 hora de expiración
            val now = System.currentTimeMillis()
            val expiresAt = Date(now + 3600 * 1000) // 1 hora
            return JWT.create()
                .withIssuer(keyValue)
                .withIssuedAt(Date(now))
                .withExpiresAt(expiresAt)
                .sign(algorithmValue)
        }
}

