package com.fnbt.tn.paymentsystem

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainAdapter.OnMainItemClick {
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        adapter = MainAdapter(arrayOf("https://knews.kg/wp-content/uploads/2015/12/86928_w300_h207_crop.jpg","https://www.almanac.com/sites/default/files/styles/primary_image_in_article/public/image_nodes/winter-solstice.jpg", "https://www.almanac.com/sites/default/files/styles/primary_image_in_article/public/image_nodes/winter-solstice.jpg", "https://www.almanac.com/sites/default/files/styles/primary_image_in_article/public/image_nodes/winter-solstice.jpg", "https://www.almanac.com/sites/default/files/styles/primary_image_in_article/public/image_nodes/winter-solstice.jpg", "https://www.almanac.com/sites/default/files/styles/primary_image_in_article/public/image_nodes/winter-solstice.jpg", "https://www.almanac.com/sites/default/files/styles/primary_image_in_article/public/image_nodes/winter-solstice.jpg", "https://www.almanac.com/sites/default/files/styles/primary_image_in_article/public/image_nodes/winter-solstice.jpg"), this)
        rec_view.layoutManager = GridLayoutManager(this, 2)
        rec_view.adapter = adapter
    }

    override fun onMainItemClickListener(id: Int) {

    }
}