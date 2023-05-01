package testing.wiki.pages

import org.wikipedia.R
import androidx.test.espresso.matcher.ViewMatchers.withId

class MainPage {

    private val matcherButtonSkip =
        withId(R.id.fragment_onboarding_skip_button)

    private val matcherButtonMenuMore =
        withId(R.id.nav_more_container)

    private val matcherButtonSettingsInMenuMore =
        withId(R.id.main_drawer_settings_container)

    private val matcherButtonLogInWikipediaInMenuMore =
        withId(R.id.main_drawer_account_container)

    private fun pressButtonSkip() =
        GeneralPageFunctions().clickItem(matcherButtonSkip)

    private fun pressButtonMenuMore() =
        GeneralPageFunctions().clickItem(matcherButtonMenuMore)

    private fun pressButtonSettingsInMenuMore() =
        GeneralPageFunctions().clickItem(matcherButtonSettingsInMenuMore)

    private fun pressButtonLogInWikipediaInMenuMore() =
        GeneralPageFunctions().clickItem(matcherButtonLogInWikipediaInMenuMore)

    fun goToSettingsPage() {
        pressButtonSkip()
        pressButtonMenuMore()
        pressButtonSettingsInMenuMore()
    }

    fun goToLoginPage() {
        pressButtonSkip()
        pressButtonMenuMore()
        pressButtonLogInWikipediaInMenuMore()
    }
}
