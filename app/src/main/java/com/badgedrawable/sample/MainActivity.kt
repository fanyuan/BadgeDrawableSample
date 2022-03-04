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
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        initTextview(binding.tvBadge)
        initButton(binding.mbBadge)
    }
    fun tabLayout(view: View) {
        startActivity(Intent(this,TabLayoutActivity::class.java))
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
    @SuppressLint("UnsafeExperimentalUsageError")
    private fun initButton(mbBadge: MaterialButton) {
        mbBadge.viewTreeObserver.addOnGlobalLayoutListener (object : ViewTreeObserver.OnGlobalLayoutListener{
            override fun onGlobalLayout() {
                BadgeDrawable.create(this@MainActivity).apply {
                    badgeGravity = BadgeDrawable.TOP_START
                    number = 6
                    backgroundColor = ContextCompat.getColor(this@MainActivity,R.color.yellow)
                    badgeTextColor = ContextCompat.getColor(this@MainActivity,R.color.black)
                    // MaterialButton本身有间距，不设置为0dp的话，可以设置badge的偏移量
                    verticalOffset = 15
                    horizontalOffset = 10
                    BadgeUtils.attachBadgeDrawable(this,mbBadge)
                }
                mbBadge.viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        })
    }

}