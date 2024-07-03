// MainActivity.kt
package com.example.constraint_layout_android

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.constraint_layout_android.databinding.ActivityMainBinding
import com.example.constraint_layout_android.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Set up image click listeners using data binding
        binding.image1.setOnClickListener {
            viewModel.onImageSelected(0)
            showToast("Image 1 clicked!")
        }

        binding.image2.setOnClickListener {
            viewModel.onImageSelected(1)
            showToast("Image 2 clicked!")
        }

        binding.image3.setOnClickListener {
            viewModel.onImageSelected(2)
            showToast("Image 3 clicked!")
        }

        // Observe selectedImageId changes to update UI
        viewModel.selectedImageId.observe(this) { selectedId ->
            updateImageSelection(selectedId)
        }
    }

    private fun updateImageSelection(selectedId: Int?) {
        // Reset all images to default state (remove borders)
        binding.image1.setBackgroundResource(0)
        binding.image2.setBackgroundResource(0)
        binding.image3.setBackgroundResource(0)

        // Set border to selected image
        when (selectedId) {
            0 -> binding.image1.setBackgroundResource(R.drawable.image_border)
            1 -> binding.image2.setBackgroundResource(R.drawable.image_border)
            2 -> binding.image3.setBackgroundResource(R.drawable.image_border)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
