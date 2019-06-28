package ru.krupt.jsonrpc.example.service

import com.github.krupt.jsonrpc.annotation.JsonRpcService
import com.github.krupt.jsonrpc.annotation.NoJsonRpcMethod
import ru.krupt.jsonrpc.example.dto.UserCreateRequest
import ru.krupt.jsonrpc.example.model.User
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

@JsonRpcService
class UserService {

    private val users = ConcurrentHashMap<UUID, User>()

    fun get(userId: UUID) =
            users[userId] ?: User(
                    UUID.randomUUID(),
                    "krupt",
                    "Andrey",
                    "Kovalev"
            )

    fun create(createRequest: UserCreateRequest): User {
        val user = User(
                UUID.randomUUID(),
                createRequest.username,
                createRequest.firstName,
                createRequest.lastName
        )

        users[user.id] = user

        return user
    }

    fun list(count: Int) = users.values.take(count)

    @NoJsonRpcMethod
    fun createUsers(createRequests: List<UserCreateRequest>) = emptyList<User>()
}
