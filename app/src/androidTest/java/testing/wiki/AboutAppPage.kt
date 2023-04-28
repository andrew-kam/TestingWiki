package testing.wiki

import org.wikipedia.R
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

class AboutAppPage : BasePage() {

    private val matcherAboutContributorsHeading = withText(R.string.about_contributors_heading)
    private val matcherAboutContributors = withId(R.id.about_contributors)
    private val matcherAboutTranslatorsHeading = withText(R.string.about_translators_heading)
    private val matcherAboutTranslators = withId(R.id.about_translators)
    private val matcherAboutAppLicenseHeading = withText(R.string.about_app_license_heading)
    private val matcherAboutAppLicense = withId(R.id.about_app_license)

    fun checkAboutContributorsHeadingIsDisplayed() =
        checkItemIsCompletelyDisplayed(matcherAboutContributorsHeading)

    fun checkAboutContributorsIsDisplayed() =
        checkItemIsCompletelyDisplayed(matcherAboutContributors)

    fun checkAboutTranslatorsHeadingIsDisplayed() =
        checkItemIsCompletelyDisplayed(matcherAboutTranslatorsHeading)

    fun checkAboutTranslatorsIsDisplayed() =
        checkItemIsCompletelyDisplayed(matcherAboutTranslators)

    fun checkAboutAboutAppLicenseHeadingIsDisplayed() =
        checkItemIsCompletelyDisplayed(matcherAboutAppLicense)

    fun checkAboutAboutAppLicenseIsDisplayed() =
        checkItemIsCompletelyDisplayed(matcherAboutAppLicenseHeading)
}