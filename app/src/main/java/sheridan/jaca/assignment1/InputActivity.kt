package sheridan.jaca.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import sheridan.jaca.assignment1.databinding.ActivityMainBinding

class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var playerChoice: String
    private lateinit var computerChoice: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)

        val btnPlay = binding.btnPlay
        btnPlay.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, OutputActivity::class.java)
            intent.putExtra("playerChoice",playerChoice)
            intent.putExtra("computerChoice",computerChoice)
            startActivity(intent)
        })
    }

}