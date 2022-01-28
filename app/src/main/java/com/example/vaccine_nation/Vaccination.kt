package com.example.vaccine_nation
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Vaccination(val country : String,
                       val timeline : Array<vaccinationMap>
) : Parcelable {

}