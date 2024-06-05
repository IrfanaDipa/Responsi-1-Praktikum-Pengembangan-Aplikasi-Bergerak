package com.example.responsippab.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.responsippab.ui.dashboard.HistoryFragment
import com.example.responsippab.ui.dashboard.InstructorFragment
import com.example.responsippab.ui.dashboard.PurposeFragment

class SectionPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = HistoryFragment()
            1 -> fragment = PurposeFragment()
            2 -> fragment = InstructorFragment()
        }

        return fragment as Fragment
    }
}