package testing.wiki.pages

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.awaitility.Awaitility
import java.util.concurrent.TimeUnit
import org.awaitility.Durations.ONE_HUNDRED_MILLISECONDS

open class BasePage {

    protected fun checkItemIsCompletelyDisplayed(matcher: Matcher<View>) {
        val timeOut = 5000L
        Awaitility.await()
            .atMost(timeOut, TimeUnit.MILLISECONDS)
            .ignoreExceptions()
            .pollInterval(ONE_HUNDRED_MILLISECONDS)
            .untilAsserted {
                onView(matcher)
                    .check(matches(isCompletelyDisplayed()))
            }
    }

    protected fun checkCallBrowserAfterPressItem(matcher: Matcher<View>) {
        Intents.init()

        clickItem(matcher)

        Intents.intended(hasAction(Intent.ACTION_VIEW))
        Intents.release()

        pressDeviceHome()
    }

    protected fun checkItemColor(matcher: Matcher<View>, matcherColor: Matcher<View>) {
        checkItemIsCompletelyDisplayed(matcher)
        onView(matcher).check(matches(matcherColor))
    }

    protected fun checkItemText(matcher: Matcher<View>, text: String) {
        checkItemIsCompletelyDisplayed(matcher)
        onView(matcher).check(matches(withText(text)))
    }


    protected fun clickItem(matcher: Matcher<View>) {
        checkItemIsClickable(matcher)
        onView(matcher).perform(click())
    }

    protected fun swipeUpRecycle(matcher: Matcher<View>) {
        val timeOut = 1000L
        checkItemIsCompletelyDisplayed(matcher)
        onView(matcher).perform(swipeUp())
        Thread.sleep(timeOut)
    }

    protected fun typeTextInField(matcher: Matcher<View>, text: String) {
        checkItemIsCompletelyDisplayed(matcher)
        onView(matcher).perform(typeText(text))
    }


    private fun checkItemIsClickable(matcher: Matcher<View>) {
        val timeOut = 5000L
        Awaitility.await()
            .atMost(timeOut, TimeUnit.MILLISECONDS)
            .ignoreExceptions()
            .pollInterval(ONE_HUNDRED_MILLISECONDS)
            .untilAsserted {
                onView(matcher)
                    .check(matches(isClickable()))
            }
    }

    private fun pressDeviceHome() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressHome()
    }
}