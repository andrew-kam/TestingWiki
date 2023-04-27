package testing.wiki

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
import org.hamcrest.Matcher
import org.awaitility.Awaitility
import java.util.concurrent.TimeUnit
import org.awaitility.Durations.ONE_HUNDRED_MILLISECONDS

open class BasePage {

    fun checkItemIsCompletelyDisplayed(matcher: Matcher<View>) {
        val timeOut = 10000L
        Awaitility.await()
            .atMost(timeOut, TimeUnit.MILLISECONDS)
            .ignoreExceptions()
            .pollInterval(ONE_HUNDRED_MILLISECONDS)
            .untilAsserted {
                onView(matcher)
                    .check(matches(isCompletelyDisplayed()))
            }
    }

    fun clickItem(matcher: Matcher<View>) {
        checkItemIsCompletelyDisplayed(matcher)
        onView(matcher).perform(click())
    }

    fun swipeUpRecycle(matcher: Matcher<View>) {
        val timeOut = 1000L
        onView(matcher).perform(swipeUp())
        Thread.sleep(timeOut)
    }

    fun checkCallBrowser(matcher: Matcher<View>) {
        Intents.init()

        clickItem(matcher)

        Intents.intended(hasAction(Intent.ACTION_VIEW))
        Intents.release()
    }

    fun pressDeviceHome() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressHome()
    }

    fun typeTextInField(matcher: Matcher<View>, text: String) {
        onView(matcher).perform(typeText(text))
    }
}
