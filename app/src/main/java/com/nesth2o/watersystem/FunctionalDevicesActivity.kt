package com.nesth2o.watersystem

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_functional_devices.*

class FunctionalDevicesActivity : BaseActivity() {
    lateinit var tvTapName: TextView
    lateinit var tvTapValue: TextView
    var isChecked = true;
    var tapValue = 0
    lateinit var radio: RadioButton
    lateinit var userId: String
    lateinit var currentUserDb: DatabaseReference

    //Firebase references
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null

    lateinit var radClose: RadioButton
    lateinit var rad10DegOP: RadioButton
    lateinit var rad20DegOP: RadioButton
    lateinit var rad30DegOP: RadioButton
    lateinit var rad40DegOP: RadioButton
    lateinit var rad50DegOP: RadioButton
    lateinit var rad60DegOP: RadioButton
    lateinit var rad70DegOP: RadioButton
    lateinit var rad80DegOP: RadioButton
    lateinit var rad90DegOP: RadioButton
    lateinit var rad100DegOP: RadioButton
    lateinit var rad110DegOP: RadioButton
    lateinit var rad120DegOP: RadioButton
    lateinit var rad130DegOP: RadioButton
    lateinit var rad140DegOP: RadioButton
    lateinit var rad150DegOP: RadioButton
    lateinit var rad160DegOP: RadioButton
    lateinit var rad170DegOP: RadioButton
    lateinit var radOpen: RadioButton
    val tapName:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_functional_devices)
        initialise()

        //https://android--code.blogspot.com/2018/02/android-kotlin-radiogroup-and.html
        // Get radio group selected item using on checked change listener
        radio_group.setOnCheckedChangeListener { _, checkedId ->
            radio = findViewById(checkedId)
            /*Toast.makeText(applicationContext, " On checked change : ${radio.text}",
                    Toast.LENGTH_SHORT).show()*/
        }

        // Get radio group selected status and text using button click event
        btn_select_gauge.setOnClickListener {
            // Get the checked radio button id from radio group
            val id = radio_group.checkedRadioButtonId
            if (id != -1) { // If any radio button checked from radio group
                // Get the instance of radio button using id
                radio = findViewById(id)
                saveDataInFirebase()
                val intent = Intent(this, AvailableDevicesActivity::class.java)
                startActivity(intent)

            } /*else {
                // If no radio button checked in this radio group
                Toast.makeText(applicationContext, "On button click : nothing selected",
                        Toast.LENGTH_SHORT).show()
            }*/
        }

    }

    private fun initialise() {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference.child("Users")


        mAuth = FirebaseAuth.getInstance()
        userId = mAuth!!.currentUser!!.uid
        currentUserDb = mDatabaseReference!!.child(userId)

        tvTapName = findViewById(R.id.tv_tapName)
        tvTapValue = findViewById(R.id.tv_tapValue)
        val intent = getIntent()
        tapValue = intent.getIntExtra(AvailableDevicesActivity.TAP_KEY, 0)
        when (tapValue) {

            R.id.imgBtnYard     -> tvTapName.text = resources.getString(R.string.yard_tap)
            R.id.imgBtnShower   -> tvTapName.text = resources.getString(R.string.shower_room)
            R.id.btnColdWater   -> tvTapName.text = resources.getString(R.string.cold_water_tap)
            R.id.btnHotWater    -> tvTapName.text = resources.getString(R.string.hot_water_tap)
        }
        currentUserDb.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.child(replaceSpacesInString((tvTapName.text).toString())).exists())
                    tvTapValue.text = (snapshot.child(replaceSpacesInString((tvTapName.text).toString())).value).toString()
                //radio.text = snapshot?.child(radio.text as String).value.toString()

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

        radClose = findViewById<View>(R.id._close) as RadioButton
        rad10DegOP = findViewById<View>(R.id._10DegOP) as RadioButton
        rad20DegOP = findViewById<View>(R.id._20DegOP) as RadioButton
        rad30DegOP = findViewById<View>(R.id._30DegOP) as RadioButton
        rad40DegOP = findViewById<View>(R.id._40DegOP) as RadioButton
        rad50DegOP = findViewById<View>(R.id._50DegOP) as RadioButton
        rad60DegOP = findViewById<View>(R.id._60DegOP) as RadioButton
        rad70DegOP = findViewById<View>(R.id._70DegOP) as RadioButton
        rad80DegOP = findViewById<View>(R.id._80DegOP) as RadioButton
        rad90DegOP = findViewById<View>(R.id._90DegOP) as RadioButton
        rad100DegOP = findViewById<View>(R.id._100DegOP) as RadioButton
        rad110DegOP = findViewById<View>(R.id._110DegOP) as RadioButton
        rad120DegOP = findViewById<View>(R.id._120DegOP) as RadioButton
        rad130DegOP = findViewById<View>(R.id._130DegOP) as RadioButton
        rad140DegOP = findViewById<View>(R.id._140DegOP) as RadioButton
        rad150DegOP = findViewById<View>(R.id._150DegOP) as RadioButton
        rad160DegOP = findViewById<View>(R.id._160DegOP) as RadioButton
        rad170DegOP = findViewById<View>(R.id._170DegOP) as RadioButton
        radOpen = findViewById<View>(R.id._open) as RadioButton

        /*when (tapValue) {

            R.id.imgBtnYard     -> tvTapName.text = resources.getString(R.string.yard_tap)
            R.id.imgBtnShower   -> tvTapName.text = resources.getString(R.string.shower_room)
            R.id.btnColdWater   -> tvTapName.text = resources.getString(R.string.cold_water_tap)
            R.id.btnHotWater    -> tvTapName.text = resources.getString(R.string.hot_water_tap)
        }*/

    }

    fun saveDataInFirebase() {
        currentUserDb.child(replaceSpacesInString((tvTapName.text).toString()) as String).setValue(radio.text)
        //radio
        Toast.makeText(applicationContext, "${radio.text} selected!",
                Toast.LENGTH_SHORT).show()

    }



}
