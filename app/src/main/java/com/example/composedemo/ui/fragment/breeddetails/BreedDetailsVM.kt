package com.example.composedemo.ui.fragment.breeddetails

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composedemo.domain.repository.BreedsRepository
import kotlinx.coroutines.launch

class BreedDetailsVM(private val breedsRepository: BreedsRepository) : ViewModel() {
    private val _imageList = mutableStateListOf<String>()
    val imageList: List<String>
        get() = _imageList

    var errorMessage: String by mutableStateOf("")
    var isLoading: Boolean by mutableStateOf(false)

    fun getBreedDetails(selectedBreed: String) {
        viewModelScope.launch {
            isLoading = true
            val result = kotlin.runCatching {
                try {
                    _imageList.clear()
                    _imageList.addAll(
                        breedsRepository.getBreedDetails(selectedBreed).listOfImages
                    )

                } catch (e: Exception) {
                    errorMessage = e.message.toString()
                }
            }
            result.onFailure {
                isLoading = false
                errorMessage = it.message.toString()
            }.onSuccess {
                isLoading = false
            }
        }
    }
}