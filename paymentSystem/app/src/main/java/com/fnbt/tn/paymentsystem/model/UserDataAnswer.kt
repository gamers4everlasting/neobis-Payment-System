package com.fnbt.tn.paymentsystem.model

import com.google.gson.annotations.SerializedName

data class UserDataAnswer(@SerializedName("OTP")
                          var opt: String,
                          @SerializedName("redirect-link")
                          var redirectLink: String)