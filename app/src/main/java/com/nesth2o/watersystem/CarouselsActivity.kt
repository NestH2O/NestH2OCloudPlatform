package com.nesth2o.watersystem

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.nesth2o.watersystem.util.CarouselAdapter
import com.nesth2o.watersystem.util.CarouselLayoutManager
import com.nesth2o.watersystem.util.ScreenUtils

class CarouselsActivity: BaseActivity() {

    private lateinit var rvShowerHorizontalPicker: RecyclerView
    private lateinit var rvColdTapHorizontalPicker: RecyclerView
    private lateinit var rvHotTapHorizontalPicker: RecyclerView

    private lateinit var tvShowerSelectedItem: TextView
    private lateinit var tvHotTapSelectedItem: TextView
    private lateinit var tvColdTapSelectedItem: TextView

    private lateinit var rvShowerCarousel: View
    private lateinit var rvColdTapCarousel: View
    private lateinit var rvHotTapCarousel : View

    private lateinit var tvWatermeter : TextView
    private lateinit var tvWaterprice : TextView
    private lateinit var tvWatersaving : TextView

    private var waterUsage = 0

    private var padding : Int  = 0
    private val data = (0..20 step 1).toList().map { it.toString() } as ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carousels)

        rvShowerCarousel = findViewById(R.id.rv_shower_carousel)
        rvColdTapCarousel = findViewById(R.id.coldWater_carousel)
        rvHotTapCarousel = findViewById(R.id.hotWater_carousel)

        rvShowerHorizontalPicker = rvShowerCarousel.findViewById(R.id.rv_horizontal_picker)
        rvColdTapHorizontalPicker = rvColdTapCarousel.findViewById(R.id.rv_horizontal_picker)
        rvHotTapHorizontalPicker = rvHotTapCarousel.findViewById(R.id.rv_horizontal_picker)

        tvWatermeter = findViewById(R.id.tv_watermeter)
        tvWaterprice = findViewById(R.id.tv_waterprice)
        tvWatersaving = findViewById(R.id. tv_watersaving)

        padding = ScreenUtils.getScreenWidth(this)/2 - ScreenUtils.dpToPx(this, 40)
    }

    override fun onStart() {
        super.onStart()
        
        setTvShowerSelectedItem()
        setShowerHorizontalPicker()

        setTvColdTapSelectedItem()
        setColdTapHorizontalPicker()

        setTvHotTapSelectedItem()
        setHotTapHorizontalPicker()
    }

    override fun onResume() {
        super.onResume()
        calculateWaterFlow()
    }

    private fun setTvShowerSelectedItem() {
        tvShowerSelectedItem = findViewById(R.id.tv_shower_selected_item)
        tvShowerSelectedItem.setText(String.format(resources.getString(R.string.flow_gpm), 0))
        //rvShowerHorizontalPicker.setPadding(padding, 0, padding, 0)
    }

    private fun setTvColdTapSelectedItem() {
        tvColdTapSelectedItem = findViewById(R.id.tv_coldTap_selected_item)
        tvColdTapSelectedItem.setText(String.format(resources.getString(R.string.flow_gpm), 0))
        //rvColdTapHorizontalPicker.setPadding(padding, 0, padding, 0)

    }

    private fun setTvHotTapSelectedItem() {
        tvHotTapSelectedItem = findViewById(R.id.tv_hotTap_selected_item)
        tvHotTapSelectedItem.setText(String.format(resources.getString(R.string.flow_gpm), 0))
        //tvHotTapSelectedItem.setPadding(padding, 0, padding, 0)
    }

    private fun setShowerHorizontalPicker() {
        //View bookmarks_container_2 = findViewById(R.id.bookmarks_favourite);
        //bookmarks_container_2.findViewById(R.id.bookmarks_list);

        //rvShowerHorizontalPicker = findViewById(R.id.rv_horizontal_picker)

        // Setting the padding such that the items will appear in the middle of the screen
        //val padding= ScreenUtils.getScreenWidth(this)/2 - ScreenUtils.dpToPx(this, 40)
        //rvShowerHorizontalPicker.setPadding(padding, 0, padding, 0)

        // Setting layout manager
        rvShowerHorizontalPicker.layoutManager = CarouselLayoutManager(this).apply {
            callback = object : CarouselLayoutManager.OnItemSelectedListener {
                override fun onItemSelected(layoutPosition: Int) {
                    tvShowerSelectedItem.setText(String.format(resources.getString(R.string.flow_gpm), data[layoutPosition]))
                   // waterUsage += data[layoutPosition].toInt()
                }
            }
        }

        // Setting Adapter
        rvShowerHorizontalPicker.adapter = CarouselAdapter().apply {
            setData(data)
            callback = object : CarouselAdapter.Callback {
                override fun onItemClicked(view: View) {
                    rvShowerHorizontalPicker.smoothScrollToPosition(rvShowerHorizontalPicker.getChildLayoutPosition(view))
                }
            }
        }
    }

    private fun setColdTapHorizontalPicker() {

        // Setting layout manager
        rvColdTapHorizontalPicker.layoutManager = CarouselLayoutManager(this).apply {
            callback = object : CarouselLayoutManager.OnItemSelectedListener {
                override fun onItemSelected(layoutPosition: Int) {
                    //tvColdTapSelectedItem.setText(data[layoutPosition])
                    tvColdTapSelectedItem.setText(String.format(resources.getString(R.string.flow_gpm), data[layoutPosition]))
                   // waterUsage += data[layoutPosition].toInt()
                }
            }
        }

        // Setting Adapter
        rvColdTapHorizontalPicker.adapter = CarouselAdapter().apply {
            setData(data)
            callback = object : CarouselAdapter.Callback {
                override fun onItemClicked(view: View) {
                    rvColdTapHorizontalPicker.smoothScrollToPosition(rvColdTapHorizontalPicker.getChildLayoutPosition(view))
                }
            }
        }
    }

    private fun setHotTapHorizontalPicker() {

        // Setting layout manager
        rvHotTapHorizontalPicker.layoutManager = CarouselLayoutManager(this).apply {
            callback = object : CarouselLayoutManager.OnItemSelectedListener {
                override fun onItemSelected(layoutPosition: Int) {
                    //tvHotTapSelectedItem.setText(data[layoutPosition])
                    tvHotTapSelectedItem.setText(String.format(resources.getString(R.string.flow_gpm), data[layoutPosition]))
                   // waterUsage += data[layoutPosition].toInt()

                }
            }
        }

        // Setting Adapter
        rvHotTapHorizontalPicker.adapter = CarouselAdapter().apply {
            setData(data)
            callback = object : CarouselAdapter.Callback {
                override fun onItemClicked(view: View) {
                    rvHotTapHorizontalPicker.smoothScrollToPosition(rvHotTapHorizontalPicker.getChildLayoutPosition(view))
                }
            }
        }
    }

    private fun calculateWaterFlow () {
        tvWatermeter.setText(waterUsage.toString() + resources.getString(R.string.gpm))//+ tvColdTapSelectedItem.text + tvHotTapSelectedItem+text
    }
}