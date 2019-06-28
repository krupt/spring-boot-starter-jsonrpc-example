package ru.krupt.jsonrpc.example.web.rest

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import ru.krupt.jsonrpc.example.dto.UserCreateRequest
import ru.krupt.jsonrpc.example.model.User
import ru.krupt.jsonrpc.example.service.UserService

@RestController
@RequestMapping("api/v1/users")
class UserController(
        private val userService: UserService
) {

    @PostMapping
    fun loadUsersFromFile(@RequestParam file: MultipartFile): List<User> {
        // parse file and store users to createRequests variable
        val createRequests = emptyList<UserCreateRequest>()

        return userService.createUsers(createRequests)
    }
}
