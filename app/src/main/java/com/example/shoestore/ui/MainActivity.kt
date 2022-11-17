package com.example.shoestore.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding  = DataBindingUtil.setContentView(this , R.layout.activity_main)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        val topLevelDestinations = setOf(
            R.id.loginFragment,
            R.id.welcomeFragment,
            R.id.shoeListFragment
        )

        appBarConfiguration = AppBarConfiguration(topLevelDestinations)

        // connecting between action bar and navController
        setupActionBarWithNavController(navController, appBarConfiguration)


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController =this.findNavController(R.id.nHostFragment)
        return super .onSupportNavigateUp() ||navController.navigateUp(appBarConfiguration)
    }
}