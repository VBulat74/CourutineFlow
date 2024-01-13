package ru.com.bulat.courutineflowsoumin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.com.bulat.courutineflowsoumin.databinding.ActivityMainBinding
import ru.com.bulat.courutineflowsoumin.lessons.lesson_02.UsersActivity

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.buttonUsersActivity.setOnClickListener {
            startActivity(UsersActivity.newIntent(this))
        }
    }
}