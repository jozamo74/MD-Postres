package com.example.mdpostres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.mdpostres.databinding.ActivityMainBinding
import com.example.mdpostres.databinding.FragmentConfirmationBinding

class MainActivity : AppCompatActivity() {

    private val navController by lazy {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.navController
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val toolbar: Toolbar = binding.toolbar

        setSupportActionBar(toolbar)


        // esto es lo mismo que la declaración inicial de arriba
        /*
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController
        */

        val appBarConfiguration = AppBarConfiguration(navController.graph)

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)

        //Hide navigation icon
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            toolbar.title = destination.label
            toolbar.navigationIcon = null
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_confirmation) {
            navController.navigate(R.id.action_global_confirmationFragment)
        }
        //return super.onOptionsItemSelected(item)
        return NavigationUI.onNavDestinationSelected(item, navController) ||
                super.onOptionsItemSelected(item)
    }

    // Cancel back button
    override fun onBackPressed() {
        if (navController.currentDestination?.id ==R.id.productsFragment) {
            super.onBackPressed()
        }
        /*if (navController.currentDestination?.id != R.id.productsFragment) {
            super.onBackPressed()
        } else {
            navController.navigate(R.id.action_confirmationFragment_to_productsFragment)

        }*/
    }
}