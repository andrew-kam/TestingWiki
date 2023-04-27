package testing.wiki

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import org.hamcrest.Matcher
import androidx.test.espresso.action.ViewActions.click
import android.view.View
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.action.ViewActions.typeText
import org.awaitility.Awaitility
import java.util.concurrent.TimeUnit
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice

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

    fun checkCallBrowser(matcher: Matcher<View>) {
        Intents.init()

        clickButtonWait(matcher)

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
