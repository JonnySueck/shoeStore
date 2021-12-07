package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mainMenu: Menu? = null
    private var menuShowing = false

    // initialize a variable for the nav controller
    lateinit var navController: NavController
    // initialize a variable for the appBarConfiguration
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) // assign DataBindingUtil to a variable
        setSupportActionBar(binding.toolbar)

        val toolbar = binding.toolbar // assigning ID of the toolbar to a var
        setSupportActionBar(toolbar) // using toolbar as an ActionBar

        // Create a NavController instance, reference: https://medium.com/@ermarajhussain/how-to-work-with-navigation-controller-in-android-with-kotlin-part-2-152aa6dc3839
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupWithNavController(toolbar, navController,
            appBarConfiguration)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    // Functions to inflate the menu options
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar, menu)
        mainMenu = menu
        return super.onCreateOptionsMenu(menu)
    }

    // toggle the menu item when the menu toggle button is clicked
    // resource : https://www.codevscolor.com/android-show-hide-menu-button-dynamically
    fun toggleMenuVisibility(view: View) {
        mainMenu?.findItem(R.id.loginFragment)?.isVisible = !menuShowing
        menuShowing = !menuShowing
    }

    // navigate to the destination upon selection of a menu item
    // resource for below fn: https://stackoverflow.com/questions/60682102/how-to-navigate-to-a-fragment-on-menu-item-click-using-android-jetpack-navigatio
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }

    // hide the menu item when going back to the login screen
    fun toggleMenuVisibility(item: MenuItem) {
        navController.navigate(R.id.loginFragment)
        mainMenu?.findItem(R.id.loginFragment)?.isVisible = !menuShowing
        menuShowing = !menuShowing
    }

}
