package com.nesth2o.watersystem

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

open class BaseActivity  : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        mAuth = FirebaseAuth.getInstance()
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.action_one) {
            Toast.makeText(this, "Logout Clicked", Toast.LENGTH_LONG).show()
            mAuth?.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            this.finish()

            return true
        }

        return super.onOptionsItemSelected(item)

    }

    private fun logout() {
    }
}