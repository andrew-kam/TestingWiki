package testing.wiki

import org.wikipedia.R
import androidx.test.espresso.matcher.ViewMatchers.withId

class AboutAppPage : BasePage() {

    private val matcherAboutContributors = withId(R.id.about_contributors)
    private val matcherAboutTranslators = withId(R.id.about_translators)
    private val matcherAboutAppLicense = withId(R.id.about_app_license)

    fun checkAboutContributorsIsDisplayed() =
        checkItemIsCompletelyDisplayed(matcherAboutContributors)

    fun checkAboutTranslatorsIsDisplayed() =
        checkItemIsCompletelyDisplayed(matcherAboutTranslators)

    fun checkAboutAboutAppLicenseIsDisplayed() =
        checkItemIsCompletelyDisplayed(matcherAboutAppLicense)
}