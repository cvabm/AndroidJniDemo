package com.example.androidjnidemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidjnidemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
        binding.sampleText.text = stringFromJNI()
        val encodeToBase64 = encodeToBase64("hello")
        with(binding.sampleText) {
            text = "$text\n'hello'经base64加密后结果为：$encodeToBase64"
        }
    }

    /**
     * A native method that is implemented by the 'androidjnidemo' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String
    external fun encodeToBase64(string: String): String

    companion object {
        // Used to load the 'androidjnidemo' library on application startup.
        init {
            System.loadLibrary("androidjnidemo")
        }
    }
}
