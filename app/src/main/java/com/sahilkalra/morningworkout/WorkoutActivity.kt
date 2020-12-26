package com.sahilkalra.morningworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class WorkoutActivity : AppCompatActivity() {
  lateinit var drawerLayout:DrawerLayout
    lateinit var coordinationLayout:CoordinatorLayout
    lateinit var toolBar:Toolbar
    lateinit var frameLayout:FrameLayout
    lateinit var navigationView:NavigationView
    var previousMenuItem: MenuItem?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)
       drawerLayout=findViewById(R.id.drawerLayout)
        coordinationLayout=findViewById(R.id.coordinationLayout)
        toolBar=findViewById(R.id.toolBar)
        frameLayout=findViewById(R.id.frameLayout)
        navigationView=findViewById(R.id.navigationView)
        setUpToolBar()
        openHome()
        val actionBarDrawerToggle=ActionBarDrawerToggle(this@WorkoutActivity,drawerLayout,
                R.string.open_drawer,
                R.string.close_drawer)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        navigationView.setNavigationItemSelectedListener {
            if (previousMenuItem!=null){
                previousMenuItem?.isChecked=false
            }
            it.isCheckable=true
            it.isChecked=true
            previousMenuItem=it
            when(it.itemId){
                R.id.homePage->{
                    openHome()
                    drawerLayout.closeDrawers()
                }

                R.id.aboutApp->{
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.frameLayout,AboutAppFragment())
                            .commit()
                    supportActionBar?.title="About App"
                    drawerLayout.closeDrawers()
                }
                R.id.exit->{
                   exitApp()

                }
            }
            return@setNavigationItemSelectedListener true

        }

    }
    fun setUpToolBar(){
        setSupportActionBar(toolBar)

        supportActionBar?.title="Home"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if (id==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
    fun openHome(){
        val fragment=ExerciseFragment()
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout,fragment).commit()
     supportActionBar?.title="Exercise Menu"
    navigationView.setCheckedItem(R.id.homePage)

    }
    fun exitApp(){
        val alertDialog= AlertDialog.Builder(this@WorkoutActivity)
        alertDialog.setTitle("Exit")
        alertDialog.setMessage("Do you want to exit the app ?")
        alertDialog.setPositiveButton("Exit"){text,Listener->
            ActivityCompat.finishAffinity(this@WorkoutActivity)
        }
        alertDialog.setNegativeButton("Cancel"){
                text,Listener->
        }
        alertDialog.create()
        alertDialog.show()
    }

    override fun onBackPressed() {
         val frag=supportFragmentManager.findFragmentById(R.id.frameLayout)
        when(frag){
            !is ExerciseFragment->openHome()
            is ExerciseFragment-> exitApp()
            else->super.onBackPressed()
        }

    }
}