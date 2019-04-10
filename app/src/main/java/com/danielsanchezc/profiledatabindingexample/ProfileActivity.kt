package com.danielsanchezc.profiledatabindingexample

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.request.RequestOptions
import com.danielsanchezc.profiledatabindingexample.databinding.ProfileActivityBinding
import java.text.SimpleDateFormat
import java.util.*


class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ProfileActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.profile_activity)

        val gc = GregorianCalendar()
        gc.set(GregorianCalendar.YEAR, 1687)
        gc.set(GregorianCalendar.MONTH, 2)
        gc.set(GregorianCalendar.DATE, 29)

        val guybrushProfile = Profile(
            firstName = "Guybrush",
            middleName = "Ulises",
            lastName = "Threepwood",
            bornDate = GregorianCalendar().apply {
                set(GregorianCalendar.YEAR, 1687)
                set(GregorianCalendar.MONTH, 2)
                set(GregorianCalendar.DATE, 29)
            }.time,
            deathDate = GregorianCalendar().apply {
                set(GregorianCalendar.YEAR, 2013)
                set(GregorianCalendar.MONTH, 4)
                set(GregorianCalendar.DATE, 3)
            }.time,
            photoUrl = "https://i.pinimg.com/originals/7f/dc/45/7fdc45bf7b245b896c12f1379750fe6e.jpg"
        )

        bind(guybrushProfile)
    }

    private fun bind(profile: Profile) {

        GlideApp.with(this)
            .load(profile.photoUrl)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.rounded_photo)
            .into(binding.profilePhotoIv)

        binding.profileCompleteNameTv.text = with(profile) { "$firstName $middleName $lastName" }

        val dateFormatter = SimpleDateFormat("yyyy")

        binding.profileBornAndDeathDateTv.text = with(profile) {
            if (deathDate != null)
                "${dateFormatter.format(bornDate)} - ${dateFormatter.format(deathDate)}"
            else
                dateFormatter.format(bornDate)
        }

        binding.profilePhotoIv.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply { data = Uri.parse(profile.photoUrl) })
        }
    }
}
