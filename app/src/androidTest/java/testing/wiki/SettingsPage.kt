package testing.wiki

import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.wikipedia.R
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.instanceOf

class SettingsPage : BasePage() {

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

    private val matcherRecycle = withId(R.id.recycler_view)

    fun pressCustomizeExploreFeed() =
        clickItem(matcherFieldWithCustomizeExploreFeed)

    fun pressAboutWikipediaApp() =
        clickItem(matcherFieldWithAboutWikipediaApp)

    fun checkCallBrowserAfterPressPrivacyPolicy() =
        checkCallBrowserAfterPressItem(matcherFieldWithPrivacyPolicy)

    fun swipeUp() =
        swipeUpRecycle(matcherRecycle)
}
