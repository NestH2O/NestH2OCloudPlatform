package com.nesth2o.watersystem

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.nesth2o.watersystem.util.CarouselAdapter
import com.nesth2o.watersystem.util.CarouselLayoutManager
import com.nesth2o.watersystem.util.ScreenUtils
import kotlinx.android.synthetic.main.activity_functional_devices.*

class FunctionalCarouselActivity: BaseActivity() {

    private lateinit var rvHorizontalPicker: RecyclerView
    private lateinit var tvSelectedItem: TextView

    lateinit var tvTapName: TextView
    lateinit var tvTapValue: TextView
    var tapValue = 0
    lateinit var userId: String
    lateinit var currentUserDb: DatabaseReference
    //val tapName:String? = null

    //Firebase references
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null

    private val data = (0..180 step 10).toList().map { it.toString() } as ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_functional_carousel)
        initialise()
        setTvSelectedItem()
        setHorizontalPicker()

        // Get radio group selected status and text using button click event
        btn_select_gauge.setOnClickListener {
                saveDataInFirebase()
                val intent = Intent(this, AvailableDevicesActivity::class.java)
                startActivity(intent)
        }
    }

    private fun setTvSelectedItem() {
        tvSelectedItem = findViewById(R.id.tv_tapValue)
    }

    private fun setHorizontalPicker() {
        rvHorizontalPicker = findViewById(R.id.rv_horizontal_picker)

        // Setting the padding such that the items will appear in the middle of the screen
        val padding: Int = ScreenUtils.getScreenWidth(this)/2 - ScreenUtils.dpToPx(this, 40)
        rvHorizontalPicker.setPadding(padding, 0, padding, 0)

        // Setting layout manager
        rvHorizontalPicker.layoutManager = CarouselLayoutManager(this).apply {
            callback = object : CarouselLayoutManager.OnItemSelectedListener {
                override fun onItemSelected(layoutPosition: Int) {
                    tvSelectedItem.setText(data[layoutPosition])
                }
            }
        }

        // Setting Adapter
        rvHorizontalPicker.adapter = CarouselAdapter().apply {
            setData(data)
            callback = object : CarouselAdapter.Callback {
                override fun onItemClicked(view: View) {
                    rvHorizontalPicker.smoothScrollToPosition(rvHorizontalPicker.getChildLayoutPosition(view))
                }
            }
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
    }



    fun saveDataInFirebase() {
        currentUserDb.child(replaceSpacesInString((tvTapName.text).toString()) as String).setValue(tvTapValue.text)

        Toast.makeText(applicationContext, "${tvTapValue.text} selected!",
                Toast.LENGTH_SHORT).show()

    }
}