package com.shj.time_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView);
        loadFragment(TodayFragment())

        bottomNavigationView.setOnNavigationItemSelectedListener { MenuItem ->
            when {
                MenuItem.itemId == R.id.navigationToday -> {
                    loadFragment(TodayFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                MenuItem.itemId == R.id.navigationHome -> {
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                MenuItem.itemId == R.id.navigationNote -> {
                    loadFragment(NoteFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener  false
                }
            }
        }

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().also { fragmentTransaction ->
            fragmentTransaction.replace(R.id.FragmentContainer, fragment)
            fragmentTransaction.commit()
        }
    }
}