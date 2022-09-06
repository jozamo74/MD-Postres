package com.example.mdpostres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.mdpostres.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class MainActivity : AppCompatActivity() {

    private val navController by lazy {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navHostFragment.navController
    }

    private lateinit var mBottomSheetBehavior: BottomSheetBehavior<View>

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

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

        // Hide bottom_sheet
        //binding.bottomSheetExit.bottomSheet.visibility = View.GONE
        mBottomSheetBehavior = BottomSheetBehavior.from(binding.bottomSheetExit.bottomSheet)
        mBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        setupListener()


    }

    private fun setupListener() {
        binding.bottomSheetExit.btnClose.setOnClickListener {
            mBottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }

        binding.bottomSheetExit.btnExit.setOnClickListener {
            finish()
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
            mBottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            //dialog()

            //super.onBackPressed()
        }
        /*if (navController.currentDestination?.id != R.id.productsFragment) {
            super.onBackPressed()
        } else {
            navController.navigate(R.id.action_confirmationFragment_to_productsFragment)

        }*/
    }

    private fun dialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.bottom_sheet_title)
            .setNegativeButton(R.string.bottom_sheet_cancel, null)
            .setPositiveButton(R.string.bottom_sheet_exit) { _, _ -> finish() }
            .show()
    }
}