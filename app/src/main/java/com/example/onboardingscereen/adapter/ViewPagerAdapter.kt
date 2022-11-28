package com.example.onboardingscereen.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class ViewPagerAdapter(list:ArrayList<Fragment>, fragmentManager: FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager,lifecycle) {
    private val framentList:ArrayList<Fragment> = list
    override fun getItemCount(): Int {

        return framentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return framentList[position]
    }

}
