package testing.wiki

import androidx.test.espresso.Espresso.onView
import org.hamcrest.Matcher
import androidx.test.espresso.action.ViewActions.click
import android.view.View
import androidx.test.espresso.action.ViewActions.swipeUp
import org.awaitility.Awaitility
import java.util.concurrent.TimeUnit
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed

open class BasePage {

    fun checkIsDisplayed(matcher: Matcher<View>) {
        onView(matcher).check(matches(isDisplayed()))
    }

    fun clickButtonWait(matcher: Matcher<View>) {
        val timeOut = 5000L
        Awaitility.await()
            .atMost(timeOut, TimeUnit.MILLISECONDS)
            .untilAsserted {
                onView(matcher).perform(click())
            }
    }

    fun swipeUpRecycle(matcher: Matcher<View>) {
        onView(matcher).perform(swipeUp())
        Thread.sleep(1000)
    }
}
