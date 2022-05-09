package com.example.ejerciciofinal.view.noticias

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.ejerciciofinal.R
import com.example.ejerciciofinal.databinding.ActivityMainBinding
import com.example.ejerciciofinal.view.Fragnoticias.*
import com.example.ejerciciofinal.view.usuarios.Login
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    //ViewBinding
    lateinit var binding: ActivityMainBinding

    //Drawer
    private lateinit var toogle: ActionBarDrawerToggle

    //Toolbar
    lateinit var myToolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_EjecicioAppNoticiasConRecyclerView)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //
        binding.myNavigationView2.setNavigationItemSelectedListener(this)

        //Toolbar
        myToolbar = findViewById(R.id.myToolbar)




        supportFragmentManager.beginTransaction().add(R.id.myFrame, FragHomeNoticia()).commit()


        setSupportActionBar(myToolbar)


        toogle = setDrawerToogle()
        supportFragmentManager.beginTransaction().add(R.id.myFrame, FragHomeNoticia()).commit()

    }

        private fun setDrawerToogle(): ActionBarDrawerToggle {
            return ActionBarDrawerToggle(
                this,
                binding.myDrawerLayout,
                myToolbar, R.string.drawer_open,
                R.string.drawer_close
            )
        }

        override fun onConfigurationChanged(newConfig: Configuration) {
            super.onConfigurationChanged(newConfig)
            toogle.onConfigurationChanged(newConfig)
        }

        override fun onPostCreate(savedInstanceState: Bundle?) {
            super.onPostCreate(savedInstanceState)
            toogle.syncState()
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return if (toogle.onOptionsItemSelected(item)) {
                true
            } else {
                super.onOptionsItemSelected(item)
            }
        }

        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            //para mostrar los fragmentos
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            when (item.itemId) {

                R.id.navglobal-> ft.replace(R.id.myFrame,FragHomeNoticia()).commit()
                R.id.nav_deportes -> ft.replace(R.id.myFrame, FragDeportes()).commit()
                R.id.nav_ciencia ->  ft.replace(R.id.myFrame, FragCiencia()).commit()
                R.id.navIdioma ->    ft.replace(R.id.myFrame,FragIdiomaView()).commit()

                R.id.salir -> {


                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                }
            }
            title = item.title //para mostrar el título

            binding.myDrawerLayout.closeDrawers() //para cerrar drawer

            return true
        }

}
