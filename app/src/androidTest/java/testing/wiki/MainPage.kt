package testing.wiki

import org.wikipedia.R
import androidx.test.espresso.matcher.ViewMatchers.withId

class MainPage : BasePage() {

    private val matcherButtonSkip = withId(R.id.fragment_onboarding_skip_button)
    private val matcherButtonMenuMore = withId(R.id.menu_icon)
    private val matcherButtonSettingsInMenuMore = withId(R.id.main_drawer_settings_container)
    private val matcherButtonLogInWikipediaMenuMore = withId(R.id.main_drawer_login_button)

    fun pressButtonSkip() =
        clickButtonWait(matcherButtonSkip)

    fun pressButtonMenuMore() =
        clickButtonWait(matcherButtonMenuMore)

    fun pressButtonSettingsInMenuMore() =
        clickButtonWait(matcherButtonSettingsInMenuMore)

    fun pressButtonLogInWikipediaMenuMore() =
        clickButtonWait(matcherButtonLogInWikipediaMenuMore)
}
