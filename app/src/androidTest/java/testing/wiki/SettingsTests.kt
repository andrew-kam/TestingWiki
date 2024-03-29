package testing.wiki

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.main.MainActivity
import testing.wiki.pages.AboutAppPage
import testing.wiki.pages.CustomizeFeedPage
import testing.wiki.pages.MainPage
import testing.wiki.pages.SettingsPage

// На устройстве для запуска тестов, анимация должна быть отключена!!!

@RunWith(AndroidJUnit4::class)
class SettingsTests {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun openSettingsPage() =
        MainPage().goToSettingsPage()

    @Test
    fun testCustomizeFeedPageAllBoxesAreChecked() {
        SettingsPage()
            .apply {
                pressCustomizeExploreFeed()
            }
        CustomizeFeedPage()
            .apply {
                checkAllCustomizeFeedBoxesAreChecked()
                swipeUp()
                checkAllCustomizeFeedBoxesAreChecked()
            }
    }

    @Test
    fun testScreenAboutApp() {
        SettingsPage()
            .apply {
                pressAboutWikipediaApp()
            }
        AboutAppPage()
            .apply {
                checkAboutContributorsHeadingIsCompletelyDisplayed()
                checkAboutContributorsIsCompletelyDisplayed()
                checkAboutTranslatorsHeadingIsCompletelyDisplayed()
                checkAboutTranslatorsIsCompletelyDisplayed()
                checkAboutAboutAppLicenseHeadingIsCompletelyDisplayed()
                checkAboutAboutAppLicenseIsCompletelyDisplayed()
            }
    }

    @Test
    fun testCallBrowser() {
        SettingsPage()
            .apply {
                checkCallBrowserAfterPressPrivacyPolicy()
            }
    }
}
