package ru.com.bulat.courutineflowsoumin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.com.bulat.courutineflowsoumin.crypto_app.CryptoActivity
import ru.com.bulat.courutineflowsoumin.databinding.ActivityMainBinding
import ru.com.bulat.courutineflowsoumin.lessons.lesson_02.UsersActivity
import ru.com.bulat.courutineflowsoumin.team_score.TeamScoreActivity

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
        binding.buttonCryptoActivity.setOnClickListener {
            startActivity(CryptoActivity.newIntent(this))
        }

        binding.teamScoreActivity.setOnClickListener {
            startActivity(TeamScoreActivity.newIntent(this))
        }
    }
}