package com.arena.ui.activity.user

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.arena.R
import com.arena.databinding.ActivityUserBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ensure the toolbar is set as the action bar
        setSupportActionBar(binding.toolbarUser)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_user) as NavHostFragment
        navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_home, R.id.nav_chat, R.id.nav_search, R.id.nav_orders, R.id.nav_profile)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        val bottomNavigationView: BottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setupWithNavController(navController)
    }

    fun hideToolbarAndNavbar() {
        supportActionBar?.hide()
        findViewById<View>(R.id.bottomNavigationView)?.visibility = View.GONE
    }

    fun showToolbarAndNavbar() {
        supportActionBar?.show()
        findViewById<View>(R.id.bottomNavigationView)?.visibility = View.VISIBLE
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
