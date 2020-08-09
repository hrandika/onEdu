package com.hrandika.angular.onedu.ui.home

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hrandika.angular.onedu.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {

    @Before
    fun setUp() {
        launchFragmentInContainer<HomeFragment>() // UI -> time / emulated real device
//        launchFragment<HomeFragment>()// Headless -> less time simulated
    }

    @Test
    fun homeFragment_title_isVisible() {
        onView(withId(R.id.text_home)).check(matches(withText("This is home Fragment")))
    }

}