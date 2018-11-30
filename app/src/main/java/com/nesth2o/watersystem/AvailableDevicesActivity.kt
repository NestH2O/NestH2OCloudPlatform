package com.nesth2o.watersystem

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class AvailableDevicesActivity : BaseActivity(), View.OnClickListener {

    companion object {
        val TAP_KEY = "TAP_KEY"
    }
    private var imgBtn_Shower: ImageButton? = null
    private var btn_ColdWate: ImageButton? = null
    private var btn_HotWate: ImageButton? = null
    private var tv_LeakDetection: TextView? = null
    private var tv_leakDescription: TextView? = null
    private var leakDetection: String? = null

    private var ll_leak: LinearLayout? = null

    lateinit var userId : String
    lateinit var currentUserDb : DatabaseReference

    //Firebase references
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_available_devices)
        val rootView = getWindow().getDecorView().getRootView()
        initialise(rootView)
    }

    private fun initialise(view : View) {
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference.child("Users")


        mAuth = FirebaseAuth.getInstance()
        userId = mAuth!!.currentUser!!.uid
        currentUserDb = mDatabaseReference!!.child(userId)

        imgBtn_Shower = findViewById(R.id.imgBtnShower) as ImageButton
        btn_ColdWate = findViewById(R.id.btnColdWater) as ImageButton
        btn_HotWate = findViewById(R.id.btnHotWater) as ImageButton
        tv_LeakDetection = findViewById(R.id.leakDescription) as TextView
        ll_leak =  findViewById(R.id.ll_leakContainer) as LinearLayout
        leakDetection =  resources.getString(R.string.leakDetection) as String

        imgBtn_Shower!!.setOnClickListener(this)
        btn_ColdWate!!.setOnClickListener(this)
        btn_HotWate!!.setOnClickListener(this)


        currentUserDb.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.child(leakDetection!!).exists() && (snapshot.child(leakDetection!!).value).toString().isNotEmpty()) {
                    tv_LeakDetection?.text = String.format(resources.getString(R.string.leakDescription), (snapshot.child(leakDetection!!).value).toString())
                    //tv_LeakDetection?.text = snapshot.child(leakDetection!!).value as String
                    onLeakVisible(view)
                } else {
                    currentUserDb.child(leakDetection!!).push().key
                    currentUserDb.child(leakDetection!!).setValue("")
                    onLeakInvisible(view)

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}

        })
    }

    override fun onClick(v: View?) {

        val intent = Intent(this@AvailableDevicesActivity, FunctionalDevicesActivity::class.java)
        when (v!!.id) {
            R.id.imgBtnShower -> intent.putExtra(TAP_KEY, R.id.imgBtnShower)
            R.id.btnColdWater -> intent.putExtra(TAP_KEY, R.id.btnColdWater)
            R.id.btnHotWater -> intent.putExtra(TAP_KEY, R.id.btnHotWater)
        }
        startActivity(intent)

    }

    fun onLeakInvisible(view: View){
        ll_leak!!.visibility= View.INVISIBLE // v letter should be capital
    }
    fun onLeakVisible(view: View){
        ll_leak!!.visibility= View.VISIBLE // v letter should be capital
    }
}