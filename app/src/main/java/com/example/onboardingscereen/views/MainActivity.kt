package com.example.onboardingscereen.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onboardingscereen.R


class MainActivity : AppCompatActivity() {
//    var imageView:ImageView?=null
//    var imageViewSplashScreen:ImageView?=null
//    var  viewPager: ViewPager?=null
//    var  constraintLayout:ConstraintLayout?=null
//    var onBoardingViewPagerAdapter: OnBoardingViewPagerAdapter? = null
//    var tabLayout: TabLayout? = null
//    var onBoardingViewPager: ViewPager? = null
//    var buttonNext: Button? = null
//    var textViewSkip: TextView? = null
//    var position = 0
//    //    lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if (restorePrefData()){
//            val intent =Intent(applicationContext,HomeActivity::class.java)
//            startActivity(intent)
//            finish()
//            }
//        viewPager=findViewById(R.id.screenPager)
//        tabLayout = findViewById(R.id.tabLayout)
//        buttonNext = findViewById(R.id.Button_next)
//        textViewSkip = findViewById(R.id.text_skip)
//        constraintLayout=findViewById(R.id.constraintlayout)
//        imageView=findViewById(R.id.image_Logo)
//        imageViewSplashScreen=findViewById(R.id.splash_image)
//
//        val onBoardingData: MutableList<OnBoardingData> = ArrayList()
//        onBoardingData.add(
//            OnBoardingData(
//                "Choose a Favourite Food",
//                "When you oder Eat Steet, we’ll hook you up with \n " + "    exclusive coupon, specials and rewards ",
//                R.drawable.onboardingscreenone
//            )
//        )
//        onBoardingData.add(
//            OnBoardingData(
//                "Hot Delivery to Home",
//                "We make food ordering fasr, simple and free-no \n" +
//                        "          matter if you order online or cash",
//                R.drawable.onboardingscreentwo
//            )
//        )
//        onBoardingData.add(
//            OnBoardingData(
//                "Receive the Great Food",
//                "You’ll receive the great food within a hour. And \n" +
//                        "      get free delivery credits for every order.",
//                R.drawable.onboardingscreenthree
//            )
//        )
//
//        setOnBoardingViewPagerAdapter(onBoardingData)
//
//        position = onBoardingViewPager!!.currentItem
//
//        textViewSkip?.setOnClickListener {
//            val signinFragment= SigninFragment()
//            val fragment: Fragment? =
//                supportFragmentManager.findFragmentByTag(SigninFragment::class.java.simpleName)
//
//            if (fragment !is HomeFragment) {
//                supportFragmentManager.beginTransaction()
//                    .add(R.id.relativeLayout, signinFragment, SigninFragment::class.java.simpleName)
//                    .commit()
//            }
//            tabLayout?.visibility=View.GONE
//            constraintLayout?.visibility=View.GONE
//            viewPager?.visibility=View.GONE
//            imageView?.visibility=View.GONE
//            imageViewSplashScreen?.visibility=View.GONE
//
//            }
//
//            buttonNext?.setOnClickListener {
//                if (position < onBoardingData.size) {
//                    position++
//                    onBoardingViewPager!!.currentItem = position
//                }
//
//                if (position == onBoardingData.size) {
//                    //savePrefData()
//                    val signinFragment = SigninFragment()
//                    val fragment: Fragment? =
//                        supportFragmentManager.findFragmentByTag(SigninFragment::class.java.simpleName)
//
//                    if (fragment !is HomeFragment) {
//                        supportFragmentManager.beginTransaction()
//                            .add(R.id.relativeLayout, signinFragment, SigninFragment::class.java.simpleName)
//                            .commit()
//
//                    }
//                    tabLayout?.visibility=View.GONE
//                    constraintLayout?.visibility=View.GONE
//                    viewPager?.visibility=View.GONE
//                    imageView?.visibility=View.GONE
//                    imageViewSplashScreen?.visibility=View.GONE
//                }
//
//
//            }
//
//            tabLayout?.setOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//                @SuppressLint("SetTextI18n")
//                override fun onTabSelected(tab: TabLayout.Tab?) {
//                    position = tab!!.position
//                    if (tab.position == onBoardingData.size - 1) {
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
//
//
//        }
//
//        private fun setOnBoardingViewPagerAdapter(onBoardingData: List<OnBoardingData>) {
//            onBoardingViewPager = findViewById(R.id.screenPager)
//            onBoardingViewPagerAdapter = OnBoardingViewPagerAdapter(this, onBoardingData)
//            onBoardingViewPager!!.adapter = onBoardingViewPagerAdapter
//            tabLayout?.setupWithViewPager(onBoardingViewPager)
//
//
//        }

//    private fun savePrefData() {
//        sharedPreferences = applicationContext.getSharedPreferences("pref", MODE_PRIVATE)
//        val editor: SharedPreferences.Editor = sharedPreferences.edit()
//        editor.putBoolean("isYourFirstTime", true)
//        editor.apply()
//    }
//
//    private fun restorePrefData(): Boolean {
//        sharedPreferences = applicationContext.getSharedPreferences("pref", MODE_PRIVATE)
//        return sharedPreferences.getBoolean("isYourFirstTime", false)
//
//   }
    }
}


