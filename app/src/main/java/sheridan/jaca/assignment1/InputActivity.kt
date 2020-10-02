package sheridan.jaca.assignment1

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import sheridan.jaca.assignment1.databinding.ActivityMainBinding
import kotlin.random.Random

class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var playerChoice: String
    private lateinit var computerChoice: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)

        val rbGroup: RadioGroup = binding.options
        val btnPlay = binding.btnPlay

        btnPlay.setOnClickListener{
            val checkedRB = findViewById<RadioButton>(rbGroup.checkedRadioButtonId)
            playerChoice = checkedRB.text as String
            computerChoice = computerTurn()

            val intent = Intent(this, OutputActivity::class.java)
            intent.putExtra("playerChoice",playerChoice)
            intent.putExtra("computerChoice",computerChoice)
            startActivity(intent)
        }
    }

    private fun computerTurn():String{
        return when (Random.nextInt(0,2)){
            0 -> "Rock"
            1 -> "Paper"
            2 -> "Scissors"
            else -> {
                "WHAT"
            }
        }
    }

}