package com.fnbt.tn.paymentsystem.ui


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.fnbt.tn.paymentsystem.R
import com.fnbt.tn.paymentsystem.model.UserData
import com.fnbt.tn.paymentsystem.model.UserDataAnswer
import com.fnbt.tn.paymentsystem.ui.response_activity.ResponseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainAdapter.OnMainItemClick, MainContract.View {
    override fun onInvalidUserImpute() {

    }


    private lateinit var adapter: MainAdapter
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        presenter = MainPresenter(this)
        adapter = MainAdapter(arrayOf("https://knews.kg/wp-content/uploads/2015/12/86928_w300_h207_crop.jpg", "https://www.almanac.com/sites/default/files/styles/primary_image_in_article/public/image_nodes/winter-solstice.jpg", "https://www.almanac.com/sites/default/files/styles/primary_image_in_article/public/image_nodes/winter-solstice.jpg", "https://www.almanac.com/sites/default/files/styles/primary_image_in_article/public/image_nodes/winter-solstice.jpg", "https://www.almanac.com/sites/default/files/styles/primary_image_in_article/public/image_nodes/winter-solstice.jpg", "https://www.almanac.com/sites/default/files/styles/primary_image_in_article/public/image_nodes/winter-solstice.jpg", "https://www.almanac.com/sites/default/files/styles/primary_image_in_article/public/image_nodes/winter-solstice.jpg", "https://www.almanac.com/sites/default/files/styles/primary_image_in_article/public/image_nodes/winter-solstice.jpg"), this)
        rec_view.layoutManager = GridLayoutManager(this, 2)
        rec_view.adapter = adapter

    }

    override fun onMainItemClickListener(id: Int) {
        if (id == 0) {
            presenter.validateUserImpute(arrayOf(first_name, second_name, email, phone))
        }
    }

    override fun onElsomSuccess(userDataAnswer: UserDataAnswer) {
        val intent = Intent(this, ResponseActivity::class.java)
        intent.putExtra("response", true)
        intent.putExtra("opt", userDataAnswer.opt)
        startActivity(intent)
    }

    override fun onElsomError(message: String) {
        val intent = Intent(this, ResponseActivity::class.java)
        intent.putExtra("response", false)
        startActivity(intent)

    }

    override fun fillField(message: String) {

    }
    override fun onValidUserImpute(userData: UserData) {
        presenter.sendUserDataToElsom(userData)
    }


}