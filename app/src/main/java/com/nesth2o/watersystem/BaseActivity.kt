package com.nesth2o.watersystem

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.eclipsesource.v8.V8



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

/*    private fun generateNodes() {
        val runtime = V8.createV8Runtime()
        runtime.executeVoidScript(""
            + "var http = require('http');\n"
            + "var express = require('express');\n"
            + "var RED = require('node-red');\n"
            + "var app = express();\n"
            + "app.use(\"/\",express.static(\"public\"));\n"
            + "var server = http.createServer(app);\n"
            + "var settings = {\n" +
                    "            httpAdminRoot:\"/red\",\n" +
                    "            httpNodeRoot: \"/api\",\n" +
                    "            userDir:\"/home/nol/.nodered/\",\n" +
                    "            functionGlobalContext: { }    // enables global context\n" +
                    "        };\n"
            + "RED.init(server,settings);\n"
            + "app.use(settings.httpAdminRoot,RED.httpAdmin);\n"
            + "app.use(settings.httpNodeRoot,RED.httpNode);\n"
            + "server.listen(8000);\n"
            + "RED.start();\n")
        runtime.release();
    }*/

    fun replaceSpacesInString(word: String) : String {
        //return word.replace("\\s+", "_").toLowerCase().capitalize()
        //return word.replace(" ", "_").toLowerCase()

        var myString = word.split(' ').joinToString("") { it.capitalize() }
        return Character.toLowerCase(myString[0]) + myString.substring(1)
    }


// Create an Express app


// Add a simple route for static content served from 'public'


// Create a server


// Create the settings object - see default settings.js file for other options


// Initialise the runtime with a server and settings


// Serve the editor UI from /red


// Serve the http nodes UI from /api




// Start the runtime

}