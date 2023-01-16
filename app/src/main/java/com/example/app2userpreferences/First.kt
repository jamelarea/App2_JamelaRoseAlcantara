package com.example.app2userpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.app2userpreferences.fragments.AboutUsFragment
import com.example.app2userpreferences.fragments.HomeFragment
import com.example.app2userpreferences.fragments.InstructionsFragment
import com.example.app2userpreferences.fragments.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_first.*

class First : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        setUpTabs()
    }

    // menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.calculator -> {
                val intent = Intent(this, Calculator::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), title = "Home")
        adapter.addFragment(AboutUsFragment(), title = "About us")
        adapter.addFragment(InstructionsFragment(), title = "Instructions")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_info_24)
        tabs.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_contact_support_24)
    }
}