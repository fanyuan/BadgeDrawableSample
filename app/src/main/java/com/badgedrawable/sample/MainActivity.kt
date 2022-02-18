package com.badgedrawable.sample

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.badgedrawable.sample.databinding.ActivityMainBinding
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        initTextview(binding.tvBadge)
    }


    private fun initTextview(tvBadge: TextView) {
        tvBadge.viewTreeObserver.addOnGlobalLayoutListener (object :ViewTreeObserver.OnGlobalLayoutListener{
            @SuppressLint("UnsafeExperimentalUsageError")
            override fun onGlobalLayout() {
                BadgeDrawable.create(this@MainActivity).apply {
                    badgeGravity = BadgeDrawable.TOP_END
                    number = 6
                    backgroundColor = ContextCompat
                        .getColor(this@MainActivity,R.color.red)
                    isVisible = true
                    BadgeUtils.attachBadgeDrawable(this,tvBadge)
                }
                tvBadge.viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        })
    }

    fun tabLayout(view: View) {
        startActivity(Intent(this,TabLayoutActivity::class.java))
    }
}