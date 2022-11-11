package com.example.composedemo.ui.fragment.breedlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composedemo.domain.model.BreedModel
import com.example.composedemo.domain.repository.BreedsRepository
import kotlinx.coroutines.launch

class BreedListVM(private val breedsRepository: BreedsRepository) : ViewModel() {

    private val _breedList = mutableStateListOf<BreedModel>()
    var errorMessage: String by mutableStateOf("")
    var isLoading: Boolean by mutableStateOf(false)
    val breedList: List<BreedModel>
        get() = _breedList

    private fun getBreedList() {
        viewModelScope.launch {
            isLoading = true
            val result = kotlin.runCatching {
                try {
                    _breedList.clear()
                    breedsRepository.getAllCachedBreeds()?.message?.keys?.toList()
                        ?.forEach { breed ->
                            _breedList.add(
                                BreedModel(
                                    name = breed,
                                    imageUrls = listOf(breedsRepository.getBreedImage(breed).imageUrl)
                                )
                            )
                        }
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

    init {
        getBreedList()
    }

}