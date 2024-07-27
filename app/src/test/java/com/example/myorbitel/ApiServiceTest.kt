package com.example.myorbitel

import com.example.myorbitel.models.AuthRequest
import com.example.myorbitel.models.ClientInfo
import com.example.myorbitel.models.ContractInfo
import com.example.myorbitel.models.LoginResponse
import com.example.myorbitel.network.ApiService
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import retrofit2.Response

class ApiServiceTest {
    private lateinit var apiService: ApiService

    @Before
    fun setUp() {
        apiService = mock(ApiService::class.java)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `login test`() =
        runBlocking {
            val authRequest = AuthRequest("client_phone", "password")
            val loginResponse = LoginResponse("token")
            whenever(apiService.login(authRequest)).thenReturn(Response.success(loginResponse))

            val response = apiService.login(authRequest)

            assert(response.isSuccessful)
            assert(response.body() == loginResponse)
        }

    @Test
    fun `get client info test`() =
        runBlocking {
            // Arrange
            val token = "Bearer token"
            val clientInfo =
                ClientInfo(
                    16,
                    client_type = 1.toString(),
                    client_fio = "Никифоров Никита Денисович",
                    client_phone = "+79512055575",
                    client_address_registration = "Пичугина 16",
                )
            whenever(apiService.getClientInfo(token)).thenReturn(Response.success(clientInfo))

            val response = apiService.getClientInfo(token)

            assert(response.isSuccessful)
            assert(response.body() == clientInfo)
        }

    @Test
    fun `get contracts test`() =
        runBlocking {
            val token = "Bearer token"
            val contracts =
                listOf(
                    ContractInfo(24, "ул.Пичугина 16", "290", "№30124", "50500136"),
                    ContractInfo(25, "ул.Невежина 5", "0", "№30125", "50500137"),
                )
            whenever(apiService.getContracts(token)).thenReturn(Response.success(contracts))

            // Act
            val response = apiService.getContracts(token)

            assert(response.isSuccessful)
            assert(response.body() == contracts)
        }
}
