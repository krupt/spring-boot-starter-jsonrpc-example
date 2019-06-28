package ru.krupt.jsonrpc.example.dto

data class UserCreateRequest(
        val username: String,
        val firstName: String?,
        val lastName: String?
)
