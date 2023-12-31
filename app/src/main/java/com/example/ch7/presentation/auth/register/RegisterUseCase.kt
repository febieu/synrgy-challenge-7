package com.example.ch7.presentation.auth.register

import com.example.ch7.domain.repository.AuthRepository
import java.lang.UnsupportedOperationException

class RegisterUseCase(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(
        username: String,
        email: String,
        password: String,
        confirmPassword: String,
    ) {
        if (authRepository.validateInput(username, email, password, confirmPassword)) {
            return authRepository.register(username, email, password, confirmPassword)
        } else {
            throw UnsupportedOperationException("Input tidak valid!")
        }
    }
}
