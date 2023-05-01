package testing.wiki.pages

import org.wikipedia.R
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

class AboutAppPage {

    private val matcherAboutContributorsHeading =
        withText(R.string.about_contributors_heading)

    private val matcherAboutContributors =
        withId(R.id.about_contributors)

    private val matcherAboutTranslatorsHeading =
        withText(R.string.about_translators_heading)

    private val matcherAboutTranslators =
        withId(R.id.about_translators)

    private val matcherAboutAppLicenseHeading =
        withText(R.string.about_app_license_heading)

    private val matcherAboutAppLicense =
        withId(R.id.about_app_license)

    fun checkAboutContributorsHeadingIsCompletelyDisplayed() =
        GeneralPageFunctions().checkItemIsCompletelyDisplayed(matcherAboutContributorsHeading)

    fun checkAboutContributorsIsCompletelyDisplayed() =
        GeneralPageFunctions().checkItemIsCompletelyDisplayed(matcherAboutContributors)

    fun checkAboutTranslatorsHeadingIsCompletelyDisplayed() =
        GeneralPageFunctions().checkItemIsCompletelyDisplayed(matcherAboutTranslatorsHeading)

    fun checkAboutTranslatorsIsCompletelyDisplayed() =
        GeneralPageFunctions().checkItemIsCompletelyDisplayed(matcherAboutTranslators)

    fun checkAboutAboutAppLicenseHeadingIsCompletelyDisplayed() =
        GeneralPageFunctions().checkItemIsCompletelyDisplayed(matcherAboutAppLicense)

    fun checkAboutAboutAppLicenseIsCompletelyDisplayed() =
        GeneralPageFunctions().checkItemIsCompletelyDisplayed(matcherAboutAppLicenseHeading)
}
