package testing.wiki

import org.wikipedia.R
import androidx.test.espresso.matcher.ViewMatchers.withId

class MainPage : BasePage() {

    private val matcherButtonSkip = withId(R.id.fragment_onboarding_skip_button)
    private val matcherButtonMenuMore = withId(R.id.nav_more_container)
    private val matcherButtonSettingsInMenuMore = withId(R.id.main_drawer_settings_container)
    private val matcherButtonLogInWikipediaInMenuMore = withId(R.id.main_drawer_account_container)

    fun pressButtonSkip() =
        clickItem(matcherButtonSkip)

    fun pressButtonMenuMore() =
        clickItem(matcherButtonMenuMore)

    fun pressButtonSettingsInMenuMore() =
        clickItem(matcherButtonSettingsInMenuMore)

    fun pressButtonLogInWikipediaMenuMore() =
        clickItem(matcherButtonLogInWikipediaInMenuMore)
}
