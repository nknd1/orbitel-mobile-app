package com.example.myorbitel.repository
import com.example.myorbitel.models.Auth
import com.example.myorbitel.service.auth.AuthApiService
import com.example.myorbitel.utils.apiRequestFlow
import javax.inject.Inject
class AuthRepository @Inject constructor(
    private val authApiService: AuthApiService,
) {
    fun login(auth: Auth) = apiRequestFlow {
        authApiService.login(auth)
    }
}