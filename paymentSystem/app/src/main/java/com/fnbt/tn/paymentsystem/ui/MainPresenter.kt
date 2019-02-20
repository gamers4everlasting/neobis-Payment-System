package com.fnbt.tn.paymentsystem.ui

import android.text.TextUtils
import android.widget.TextView
import com.fnbt.tn.paymentsystem.ForumService
import com.fnbt.tn.paymentsystem.e
import com.fnbt.tn.paymentsystem.model.UserData
import com.fnbt.tn.paymentsystem.model.UserDataAnswer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val v: MainContract.View) : MainContract.Presenter {
    private val emptyFieldError: String = "Заполните поле"
    private val invalidEmail: String = "Введите валидный email"
    private val invalidPhoneNumber: String = "Введите валидный номер телефона"
    override fun validateUserImpute(textView: Array<TextView>) {
        var ok: Boolean = true

        //first name
        if (textView[0].text.isEmpty() || textView[0].text.isBlank()) {
            textView[0].error = emptyFieldError
            ok = false
        }

        //second name
        if (textView[1].text.isEmpty() || textView[1].text.isBlank()) {
            textView[1].error = emptyFieldError
            ok = false
        }


        //email
        if (textView[2].text.isEmpty() || textView[2].text.isBlank()) {
            textView[2].error = emptyFieldError
            ok = false
        } else if (textView[2].text.isNotEmpty() || textView[2].text.isNotBlank()) {
            val email: String = textView[2].text.toString()
            if (!email.contains('@') || !email.contains('.')) {
                textView[2].error = invalidEmail
                ok = false
            }
        }

        //phone
        if (textView[3].text.isEmpty() || textView[3].text.isBlank()) {
            ok = false
            if (textView[3].text.toString().length != 13) {
                textView[3].error = emptyFieldError
            }
        } else if (textView[3].text.isNotEmpty() || textView[3].text.isNotBlank()) {
            val phoneNumber: String = textView[3].text.toString()
            if (phoneNumber.length != 13) {
                textView[3].error = "+996 XXX YY YY YY"
                ok = false
            }
        }


        if (ok) {
            v.onValidUserImpute(UserData(textView[0].text.toString(), textView[1].text.toString(), textView[2].text.toString(), textView[3].text.toString()))
        } else {
        }
    }

    override fun sendUserDataToElsom(userData: UserData) {
        ForumService.invoke().sendUserInfo(userData)
                .enqueue(object : Callback<UserDataAnswer> {
                    override fun onFailure(call: Call<UserDataAnswer>?, t: Throwable?) {
                        v.onElsomError(t?.message!!)
                    }

                    override fun onResponse(call: Call<UserDataAnswer>?, response: Response<UserDataAnswer>?) {
                        if (response?.isSuccessful!! && response.body() != null)
                            v.onElsomSuccess(response.body()!!)
                        else
                            v.onElsomError(response.message())
                    }

                })
    }
}

fun isValidEmail(target: CharSequence?): Boolean {
    return if (target == null) {
        false
    } else {
        android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}