package com.example.tablayoutwviewpager2kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageList = listOf(
                R.drawable.photo1,
                R.drawable.photo2,
                R.drawable.photo3,
                R.drawable.photo4,
                R.drawable.photo5,
                R.drawable.photo6,
                R.drawable.photo7,
        )

        val adapter = ViewPagerAdapter(imageList)
        viewPager.adapter = adapter

        // Connecting TabLayout to ViewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Tab ${position + 1}"

            // Adding 4rd tab a badge with number 5
            if(position == 3)
            tab.orCreateBadge.number = 5

        }.attach()

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Selected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Unselected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "Reselected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

        })

        /*
        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL

        viewPager.beginFakeDrag()
        viewPager.fakeDragBy(-10f)
        viewPager.endFakeDrag()

         */
    }
}