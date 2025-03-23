package com.richard.intents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.richard.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var drawer: DrawerLayout
    lateinit var navDrawer: NavigationView
    lateinit var bottomNav: BottomNavigationView
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar2)

        drawer = binding.root
        navDrawer = binding.navView
        bottomNav= binding.bottomNav

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.playerFragment,R.id.resultFragment), drawer)

        setupActionBarWithNavController(navController, appBarConfiguration)
        navDrawer.setupWithNavController(navController)

        setupBottomNavigation()
    }
    private fun setupBottomNavigation(){
        bottomNav.setOnItemSelectedListener { menuItem -> when(menuItem.itemId){
            R.id.bottom_option_1->{
                Snackbar.make(drawer,getString(R.string.bottom_nav_title_1),Snackbar.LENGTH_SHORT).show()
                true
            }
            R.id.bottom_option_2->{
                Snackbar.make(drawer,getString(R.string.bottom_nav_title_2),Snackbar.LENGTH_SHORT).show()
                true
            }
            else->false}
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        drawer.openDrawer(GravityCompat.START)
        return true
    }
}

    //override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       //menuInflater.inflate(R.menu.second_screen_menu,menu)
        //return true
    //}

    //override fun onOptionsItemSelected(item: MenuItem): Boolean {
       // return when(item.itemId){
          //  R.id.menu_save -> {
              //  Snackbar.make(this,drawer,getString(R.string.menu_save_title),Snackbar.LENGTH_SHORT
                //).show()
              //  true
           // }
           // R.id.meu_settings ->{
                    //Snackbar.make(this,drawer,getString(R.string.menu_settings_title),Snackbar.LENGTH_SHORT
                   // ).show()
                   // true
           // }
           // else-> false
        //}
    //}