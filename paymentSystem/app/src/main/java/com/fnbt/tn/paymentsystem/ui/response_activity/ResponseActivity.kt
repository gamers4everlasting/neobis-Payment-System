package com.fnbt.tn.paymentsystem.ui.response_activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.fnbt.tn.paymentsystem.R
import kotlinx.android.synthetic.main.activity_response.*
import kotlinx.android.synthetic.main.toolbar.*

class ResponseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_response)
        val isSuccessful = intent.getBooleanExtra("response", false)
        if (isSuccessful) {
            val opt = intent.getIntExtra("opt", 0)
            error_text_body.text = "Ваш одноразовый код для оплаты через кошелек \"Элсом\": (например) $opt\n" +
                    "Оплатите по данному реквизиту в Личном кабинете \"Элсом\" или скачайте обновленное приложение в Google Play по ссылке ЭЛСОМ 2.0.\n" +
                    "Номер счета необходимо ввести в пункте «Разовый код оплаты».\n" +
                    "После завершения оплаты, сохраните чек."
            imageView.visibility = View.GONE
        }

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}
