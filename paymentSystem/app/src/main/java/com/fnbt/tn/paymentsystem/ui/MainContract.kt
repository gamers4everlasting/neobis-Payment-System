package com.fnbt.tn.paymentsystem.ui

import android.widget.TextView
import com.fnbt.tn.paymentsystem.model.UserData
import com.fnbt.tn.paymentsystem.model.UserDataAnswer

interface MainContract {

    interface  View {
        fun onElsomSuccess(userDataAnswer: UserDataAnswer)
        fun onElsomError(message: String)
        fun fillField(message: String)
        fun onValidUserImpute(userData: UserData)
        fun onInvalidUserImpute()
    }

    interface Presenter {
        fun sendUserDataToElsom(userData: UserData)
        fun validateUserImpute(textView: Array<TextView>)
    }
}