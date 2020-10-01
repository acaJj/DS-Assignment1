package sheridan.jaca.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sheridan.jaca.assignment1.databinding.ActivityOutputBinding

class OutputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOutputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputBinding.inflate(layoutInflater)
        var rootView = binding.root
        setContentView(rootView)

        val player = intent.getStringExtra("playerChoice")
        val computer = intent.getStringExtra("computerChoice")
        val txtPlayerChoice = binding.txtPlayerChoice
        val txtComputerChoice = binding.txtComputerChoice
        val txtWinner = binding.txtWinner
        val btnReplay = binding.btnReplay

        txtPlayerChoice.text = player
        txtComputerChoice.text = computer

        val result = determineResult(player,computer)

        txtWinner.text = result
    }

    private fun determineResult(player: String?, computer:String?): String{
        var result:String = ""
        if(player=="Rock"){
            if (computer=="Rock"){
                result = "It's a Draw!!!"
            }else if (computer == "Paper"){
                result = "The Computer!!!"
            }else if (computer == "Scissors"){
                result = "The Player!!!"
            }
        }else if (player == "Paper"){
            if (computer=="Rock"){
                result = "The Player!!!"
            }else if (computer == "Paper"){
                result = "It's a Draw!!!"
            }else if (computer == "Scissors"){
                result = "The Computer!!!"
            }
        }else if (player == "Scissors"){
            if (computer=="Rock"){
                result = "The Computer!!!"
            }else if (computer == "Paper"){
                result = "The Player!!!"
            }else if (computer == "Scissors"){
                result = "It's a Draw!!!"
            }
        }else {
            result = "WHAT something went wrong!!!"
        }

        return result
    }
}