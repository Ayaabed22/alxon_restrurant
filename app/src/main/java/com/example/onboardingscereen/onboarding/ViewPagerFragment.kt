package com.example.onboardingscereen.onboarding

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.onboardingscereen.R
import com.example.onboardingscereen.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout


class ViewPagerFragment : Fragment() {
    var textViewSkip:TextView?=null
    var buttonNext:Button?=null
    var position=0
    var tabLayout: TabLayout? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewSkip=view.findViewById(R.id.text_skip)
        buttonNext=view.findViewById(R.id.Button_next)
        tabLayout = view.findViewById(R.id.tabLayout)
        val fragmentList = arrayListOf<Fragment>(FristScreen(), SconedScreen(), ThridScreen())
        val viewpager = getView()?.findViewById<ViewPager2>(R.id.screenPager)
        viewpager?.adapter = ViewPagerAdapter(fragmentList, childFragmentManager, lifecycle)

        textViewSkip?.setOnClickListener {
            view.findNavController().navigate(R.id.action_viewPagerFragment_to_signinFragment)
        }

        buttonNext?.setOnClickListener {
                if (position < fragmentList.size) {
                    position++
                    viewpager?.currentItem=position
                }
            if (position==fragmentList.size) {
                view.findNavController().navigate(R.id.action_viewPagerFragment_to_signinFragment)
            }
                if (position==fragmentList.size-1){
                buttonNext?.text = "GetStarted"
                val value = buttonNext?.getLayoutParams()
                if (value != null) {
                    value.width = 610
                    value.height = 100
                    buttonNext?.setLayoutParams(value)
                }

                textViewSkip?.text = ""
            } else {
                buttonNext?.text = "Next"
            }


            }

        }
//            tabLayout?.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//                @SuppressLint("SetTextI18n")
//                override fun onTabSelected(tab: TabLayout.Tab?) {
//                    position = tab!!.position
//                    if (tab.position == fragmentList.size - 1) {
//                        buttonNext?.text = "GetStarted"
//                        val value = buttonNext?.getLayoutParams()
//                        if (value != null) {
//                            value.width = 610
//                            value.height = 100
//                            buttonNext?.setLayoutParams(value)
//                        }
//
//                        textViewSkip?.text = ""
//                    } else {
//                        buttonNext?.text = "Next"
//                    }
//
//
//                }
//
//                override fun onTabUnselected(tab: TabLayout.Tab?) {
//
//                }
//
//                override fun onTabReselected(tab: TabLayout.Tab?) {
//
//                }
//
//            })


        }







