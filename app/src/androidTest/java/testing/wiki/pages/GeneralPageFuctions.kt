package testing.wiki.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.assertion.ViewAssertions.matches
import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import org.hamcrest.Matcher
import org.awaitility.Awaitility
import java.util.concurrent.TimeUnit
import org.awaitility.Durations.ONE_HUNDRED_MILLISECONDS

class GeneralPageFunctions {

    private val timeOut = 5000L

    fun checkItemIsCompletelyDisplayed(matcher: Matcher<View>) {
        Awaitility.await()
            .atMost(timeOut, TimeUnit.MILLISECONDS)
            .ignoreExceptions()
            .pollInterval(ONE_HUNDRED_MILLISECONDS)
            .untilAsserted {
                onView(matcher).check(matches(isCompletelyDisplayed()))
            }
    }

    fun checkItemIsClickable(matcher: Matcher<View>) {
        Awaitility.await()
            .atMost(timeOut, TimeUnit.MILLISECONDS)
            .ignoreExceptions()
            .pollInterval(ONE_HUNDRED_MILLISECONDS)
            .untilAsserted {
                onView(matcher).check(matches(isClickable()))
            }
    }

    fun clickItem(matcher: Matcher<View>) {
        checkItemIsClickable(matcher)
        onView(matcher).perform(click())
    }

    fun swipeUpRecycle(matcher: Matcher<View>) {
        checkItemIsCompletelyDisplayed(matcher)
        onView(matcher).perform(swipeUp())
    }
}
