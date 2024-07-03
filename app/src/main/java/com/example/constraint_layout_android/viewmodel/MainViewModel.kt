// MainViewModel.kt
package com.example.constraint_layout_android.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    enum class ImageSelection {
        NONE, IMAGE1, IMAGE2, IMAGE3
    }

    val selectedImageId = MutableLiveData<Int>()
    val text = MutableLiveData<String>()

    init {
        // Initialize default values
        selectedImageId.value = 0
        text.value = ""
    }

    fun onImageSelected(imageId: Int) {
        selectedImageId.value = imageId
    }
}
