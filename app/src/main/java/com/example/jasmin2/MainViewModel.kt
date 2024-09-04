package com.example.jasmin2

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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


}