package edu.jakubkt.soundpressurelevelmeter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import edu.jakubkt.soundpressurelevelmeter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        setOnClickListeners()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_access_screenshots -> {
                Toast.makeText(applicationContext, R.string.placeholder_string, Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_access_settings_activity -> {
                Intent(this, SettingsActivity::class.java).also {
                    startActivity(it)
                }
                return true
            }
            R.id.action_access_help_activity -> {
                Toast.makeText(applicationContext, R.string.placeholder_string, Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setOnClickListeners() {
        // Switch to a different activity after pressing a button
        binding.mainMenuLayout.buttonSplGraph.setOnClickListener {
            Intent(this, SPLGraphActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.mainMenuLayout.buttonSplMeter.setOnClickListener {
            Intent(this, SPLMeterActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.mainMenuLayout.buttonRawDataGraph.setOnClickListener {
            Intent(this, RawDataActivity::class.java).also {
                startActivity(it)
            }
        }
        //TODO create a CalibrationActivity layout
        binding.mainMenuLayout.buttonCalibration.setOnClickListener {
            Toast.makeText(applicationContext, R.string.placeholder_string, Toast.LENGTH_SHORT).show()
        }
    }
}
