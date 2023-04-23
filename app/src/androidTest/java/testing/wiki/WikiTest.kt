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
    fun customizeFeedPageAllBoxCheckedTest() {
        MainPage()
            .apply {
                clickButtonSkip()
                clickButtonMenuMore()
                clickButtonSettingsInMenuMore()
            }

        SettingsPage()
            .clickButtonCustomizeExploreFeed()

        Thread.sleep(5000)

        CustomizeFeedPage()
            .allBoxIsChecked()
    }
}
