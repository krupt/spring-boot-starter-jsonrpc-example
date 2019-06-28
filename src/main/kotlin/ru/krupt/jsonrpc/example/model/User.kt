package ru.krupt.jsonrpc.example.model

import java.util.UUID

data class User(
        val id: UUID,
        val username: String,
        val firstName: String?,
        val lastName: String?
)
