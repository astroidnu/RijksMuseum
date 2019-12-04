package com.scoproject.rijksmuseum.presentation

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.widget.TextView
import com.scoproject.base.presentation.ui.activity.BaseActivity
import com.scoproject.rijksmuseum.R
import com.scoproject.rijksmuseum.features.listart.presentation.ListArtActivity
import com.scoproject.rijksmuseum.features.profile.presentation.ProfileActivity
import com.tunaikumobile.base.data.session.LoginSession
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import javax.inject.Inject

abstract class BaseNavigationDrawerActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
    @Inject
    lateinit var mLoginSession: LoginSession

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onActivityReady(savedInstanceState: Bundle?) {
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        setupContentNavBar()

    }

    private fun setupContentNavBar(){
        val userName =  mLoginSession.getUsername()
        val headerView = nav_view.getHeaderView(0)
        val navUsername = headerView.findViewById(R.id.tvNavUserName) as TextView
        navUsername.text = "Welcome $userName"
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                val intent = Intent(this, ListArtActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
            }
            R.id.nav_profile -> {
                val intent = Intent(this, ProfileActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
