package testing.wiki.pages

import android.content.Intent
import android.widget.LinearLayout
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.wikipedia.R
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf

class SettingsPage {

    private val matcherFieldWithCustomizeExploreFeed =
        allOf(
            isDescendantOfA(withId(R.id.recycler_view)),
            instanceOf(LinearLayout::class.java),
            hasDescendant(withText(R.string.preference_summary_customize_explore_feed))
        )

    private val matcherFieldWithAboutWikipediaApp =
        allOf(
            isDescendantOfA(withId(R.id.recycler_view)),
            instanceOf(LinearLayout::class.java),
            hasDescendant(withText(R.string.about_description))
        )

    private val matcherFieldWithPrivacyPolicy =
        allOf(
            isDescendantOfA(withId(R.id.recycler_view)),
            instanceOf(LinearLayout::class.java),
            hasDescendant(withText(R.string.privacy_policy_description))
        )

    private val matcherRecycle =
        withId(R.id.recycler_view)

    private fun swipeUp() =
        GeneralPageFunctions().swipeUpRecycle(matcherRecycle)

    private fun pressDeviceHome() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressHome()
    }

    fun pressCustomizeExploreFeed() =
        GeneralPageFunctions().clickItem(matcherFieldWithCustomizeExploreFeed)

    fun pressAboutWikipediaApp() {
        swipeUp()
        GeneralPageFunctions().clickItem(matcherFieldWithAboutWikipediaApp)
    }

    fun checkCallBrowserAfterPressPrivacyPolicy() {
        Intents.init()
        swipeUp()
        GeneralPageFunctions().clickItem(matcherFieldWithPrivacyPolicy)
        Intents.intended(IntentMatchers.hasAction(Intent.ACTION_VIEW))
        Intents.release()

        pressDeviceHome()
    }
}
