package testing.wiki

import android.content.Intent
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.main.MainActivity

@RunWith(AndroidJUnit4::class)
class WikiTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun goToSettingPage() {
        MainPage()
            .apply {
                pressButtonSkip()
                pressButtonMenuMore()
                pressButtonSettingsInMenuMore()
            }
    }

    @Test
    fun testCustomizeFeedPageAllBoxesAreChecked() {

        SettingsPage()
            .pressButtonCustomizeExploreFeed()

        CustomizeFeedPage()
            .apply {
                checkAllBoxesAreChecked()
                swipeUp()
                checkAllBoxesAreChecked()
            }
    }

    @Test
    fun testScreenAboutApp() {

        SettingsPage()
            .apply {
                swipeUp()
                pressButtonAboutWikipediaApp()
            }
        AboutAppPage()
            .apply {
                checkAboutContributorsIsDisplayed()
                checkAboutTranslatorsIsDisplayed()
                checkAboutAboutAppLicenseIsDisplayed()
            }
    }

    @Test
    fun testSwitchBrowser() {

        Intents.init()

        SettingsPage()
            .apply {
                swipeUp()
                pressButtonPrivacyPolicy()
            }

        Intents.intended(hasAction(Intent.ACTION_VIEW))
        Intents.release()
    }
}

//Thread.sleep(5000)
