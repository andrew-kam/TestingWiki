package testing.wiki

import org.wikipedia.R
import androidx.test.espresso.matcher.ViewMatchers.withId

class MainPage : BasePage() {

    private val matcherButtonSkip = withId(R.id.fragment_onboarding_skip_button)
    private val matcherButtonMenuMore = withId(R.id.menu_icon)
    private val matcherButtonSettingsInMenuMore = withId(R.id.main_drawer_settings_container)

    fun pressButtonSkip() =
        clickButton(matcherButtonSkip)

    fun pressButtonMenuMore() =
        clickButton(matcherButtonMenuMore)

    fun pressButtonSettingsInMenuMore() =
        clickButton(matcherButtonSettingsInMenuMore)
}
