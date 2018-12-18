package com.nesth2o.watersystem

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class MainActivity : BaseActivity() {

    //Firebase references
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null
    //UI elements
    private var tvFirstName: TextView? = null
    private var tvLastName: TextView? = null
    private var tvEmail: TextView? = null
    private var tvEmailVerifiied: TextView? = null

    private var btnBathroom1: Button? = null
    private var btnBathroom2: Button? = null
    private var btnKitchen: Button? = null
    private var firstName:String? = null
    private var lastName:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialise()
    }

    private fun initialise() {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference.child("Users")
        mAuth = FirebaseAuth.getInstance()
        tvFirstName = findViewById(R.id.tv_first_name)
        tvLastName = findViewById(R.id.tv_last_name)
        tvEmail = findViewById(R.id.tv_email)
        tvEmailVerifiied = findViewById(R.id.tv_email_verifiied)
        btnBathroom1 = findViewById(R.id.btn_bathroom1)
        btnBathroom2 = findViewById(R.id.btn_bathroom2)
        btnKitchen = findViewById(R.id.btn_kitchen)
        firstName = replaceSpacesInString((resources.getString(R.string.first_name)))
        lastName = replaceSpacesInString((resources.getString(R.string.last_name)))

        btnBathroom1!!.setOnClickListener {
            val intent = Intent(this@MainActivity, AvailableDevicesActivity::class.java)
            startActivity(intent)
        }

        btnBathroom2!!.setOnClickListener {
            //todo
        }

        btnKitchen!!.setOnClickListener {
            //todo
            val intent = Intent(this@MainActivity, CarouselsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        val mUser = mAuth!!.currentUser
        val mUserReference = mDatabaseReference!!.child(mUser!!.uid)
        tvEmail!!.text = mUser.email
        tvEmailVerifiied!!.text = mUser.isEmailVerified.toString()
        mUserReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                tvFirstName!!.text = snapshot.child(firstName!!).value.toString()
                tvLastName!!.text = snapshot.child(lastName!!).value.toString()
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
    }
}

