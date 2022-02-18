package com.badgedrawable.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.badgedrawable.sample.databinding.ActivityTabLayoutBinding

class TabLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil
            .setContentView<ActivityTabLayoutBinding>(this,R.layout.activity_tab_layout)
        //不带数字颜色点
        binding.tabLayout.getTabAt(0)?.let {
             it.orCreateBadge.apply {
                 backgroundColor = ContextCompat
                     .getColor(this@TabLayoutActivity,R.color.red)
             }
        }
        //带数字颜色点
        binding.tabLayout.getTabAt(1)?.let {
            it.orCreateBadge.apply {
                backgroundColor = ContextCompat
                    .getColor(this@TabLayoutActivity,R.color.purple_500)
                badgeTextColor = ContextCompat
                    .getColor(this@TabLayoutActivity,R.color.yellow)
                number = 6
            }
        }
        //不带数字颜色点
        binding.tabLayout.getTabAt(2)?.let {
            it.orCreateBadge.apply {
                backgroundColor = ContextCompat
                    .getColor(this@TabLayoutActivity,R.color.blue)
            }
        }
    }
}