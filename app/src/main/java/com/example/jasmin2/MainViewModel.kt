package com.example.jasmin2

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jasmin2.fitness.FitnessList
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private val _fitnessDetail = mutableStateOf(FitnessDetailStat())
    val fitnessDetail: State<FitnessDetailStat> = _fitnessDetail

    fun getFitnessById(id: Long): FitnessList? {
        return _categorieStat.value.list.find { it.id == id }
    }

    fun fetchFitnessDetail(id: Long) {
        viewModelScope.launch {
            try {
                _fitnessDetail.value = FitnessDetailStat(loading = true) // 로딩 시작
                val response = FitnessListService.getFitnessById(id)
                _fitnessDetail.value = FitnessDetailStat(
                    fitness = response,
                    loading = false
                )
            } catch (e: Exception) {
                _fitnessDetail.value = FitnessDetailStat(
                    loading = false,
                    error = "Error fetching FitnessDetail ${e.message}"
                )
            }
        }
    }

    data class FitnessDetailStat(
        val loading: Boolean = true,
        val fitness: FitnessList? = null,
        val error: String? = null
    )



    private val _categorieStat = mutableStateOf(FitnessListStat())
    val categorieState: State<FitnessListStat> = _categorieStat

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = FitnessListService.getFitnessList()
                _categorieStat.value = _categorieStat.value.copy(
                    list = response,
                    loading = false,
                    error = null
                )
            } catch (e: Exception) {
                _categorieStat.value = _categorieStat.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    data class FitnessListStat(
        val loading: Boolean = true,
        val list: List<FitnessList> = emptyList(),
        val error: String? = null
    )

    private val _loginState = mutableStateOf(LoginState())
    val loginState: State<LoginState> = _loginState

    fun login(username: String, password: String) {
        // 로딩 시작
        _loginState.value = LoginState(loading = true)

        viewModelScope.launch {
            try {
                val response = FitnessListService.login(username, password)
                if (response.isSuccessful && response.body()?.success == true) {
                    // 로그인 성공 시 토큰 저장 및 처리
                    val token = response.body()?.token
                    // TODO: SharedPreferences 등에 토큰 저장 로직 추가

                    // 로그인 성공 상태 업데이트
                    _loginState.value = LoginState(success = true)
                } else {
                    // 로그인 실패 시 오류 처리
                    val error = response.body()?.error ?: "Unknown error"
                    _loginState.value = LoginState(error = error)
                }
            } catch (e: Exception) {
                // 네트워크 오류나 기타 예외 처리
                _loginState.value = LoginState(error = "Login failed: ${e.message}")
            }
        }
    }

    data class LoginState(
        val loading: Boolean = false,
        val success: Boolean = false,
        val error: String? = null
    )

    private val _registerState = mutableStateOf(RegisterState())
    val registerState: State<RegisterState> = _registerState

    fun register(username: String, password: String, displayName: String) {
        viewModelScope.launch {
            try {
                val response = FitnessListService.register(username, password, displayName)
                if (response.isSuccessful) {
                    _registerState.value = RegisterState(success = true)
                } else {
                    _registerState.value = RegisterState(error = response.body()?.message ?: "Unknown error")
                }
            } catch (e: Exception) {
                _registerState.value = RegisterState(error = "Registration failed: ${e.message}")
            }
        }
    }

    data class RegisterState(
        val loading: Boolean = false,
        val success: Boolean = false,
        val error: String? = null
    )


}