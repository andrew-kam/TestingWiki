package testing.wiki

import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.anyOf
import org.wikipedia.R
import androidx.test.espresso.matcher.ViewMatchers.withId

class SettingsPage : BasePage() {

    private val matcherButtonCustomizeExploreFeed = anyOf(
        withText("Customize the Explore feed"),
        withText("Настроить ленту")
    )

    private val matcherButtonAboutWikipediaApp = anyOf(
        withText("About the Wikipedia app"),
        withText("О приложении «Википедия»")
    )

    private val matcherButtonPrivacyPolicy = anyOf(
        withText("Privacy policy"),
        withText("Политика конфиденциальности")
    )

    private val matcherRecycle = withId(R.id.recycler_view)


    fun pressButtonCustomizeExploreFeed() =
        clickButtonWait(matcherButtonCustomizeExploreFeed)

    fun pressButtonAboutWikipediaApp() =
        clickButtonWait(matcherButtonAboutWikipediaApp)

    fun pressButtonPrivacyPolicy() =
        clickButtonWait(matcherButtonPrivacyPolicy)

    fun swipeUp() =
        swipeUpRecycle(matcherRecycle)
}
