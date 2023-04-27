package testing.wiki

import androidx.test.espresso.matcher.ViewMatchers.withText
import org.wikipedia.R
import androidx.test.espresso.matcher.ViewMatchers.withId

class SettingsPage : BasePage() {

    private val matcherButtonCustomizeExploreFeed =
        withText(R.string.preference_summary_customize_explore_feed)

    private val matcherButtonAboutWikipediaApp =
        withText(R.string.about_description)

    private val matcherButtonPrivacyPolicy =
        withText(R.string.privacy_policy_description)

    private val matcherRecycle = withId(R.id.recycler_view)


    fun pressButtonCustomizeExploreFeed() =
        clickItem(matcherButtonCustomizeExploreFeed)

    fun pressButtonAboutWikipediaApp() =
        clickItem(matcherButtonAboutWikipediaApp)

    fun checkCallBrowserAfterPressButtonPrivacyPolicy() =
        checkCallBrowser(matcherButtonPrivacyPolicy)

    fun swipeUp() =
        swipeUpRecycle(matcherRecycle)
}
