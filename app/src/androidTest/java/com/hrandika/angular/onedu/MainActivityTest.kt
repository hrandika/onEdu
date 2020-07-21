package com.hrandika.angular.onedu

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivity_onFabClick_showSnackbar() {
//        onView(isRoot()).perform(waitFor(2000))
        onView(withId(R.id.fab)).perform(click())
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText("Replace with your own action")))
    }

//    fun waitFor(millis: Long): ViewAction? {
//        return object : ViewAction {
//            override fun getConstraints(): Matcher<View> {
//                return isRoot()
//            }
//            override fun getDescription(): String {
//                return "Wait for $millis milliseconds."
//            }
//
//            override fun perform(uiController: UiController, view: View?) {
//                uiController.loopMainThreadForAtLeast(millis)
//            }
//        }
//    }

}