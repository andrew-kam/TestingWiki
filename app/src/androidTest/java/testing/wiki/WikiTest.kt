package testing.wiki

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.main.MainActivity

@RunWith(AndroidJUnit4::class)
class WikiTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testCustomizeFeedPageAllBoxesAreChecked() {
        MainPage()
            .apply {
                pressButtonSkip()
                pressButtonMenuMore()
                pressButtonSettingsInMenuMore()
            }

        SettingsPage()
            .pressButtonCustomizeExploreFeed()

        Thread.sleep(5000)

        CustomizeFeedPage()
            .checkAllBoxesAreChecked()
    }

    @Test
    fun testAllBlocks() {
        MainPage()
            .apply {
                pressButtonSkip()
                pressButtonMenuMore()
                pressButtonSettingsInMenuMore()
            }
    }
}
