package testing.wiki.pages

import org.wikipedia.R
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Assert

class CustomizeFeedPage : BasePage() {

    private val matcherCheckBox = "org.wikipedia.alpha:id/feed_content_type_checkbox"
    private val matcherRecycle = withId(R.id.content_types_recycler)

    fun checkAllCustomizeFeedBoxesAreChecked() {
        val timeOut = 3000L
        val uiDevice = UiDevice.getInstance(getInstrumentation())

        uiDevice.wait(Until.hasObject(By.res(matcherCheckBox)), timeOut)
        val listCheckBox = uiDevice.findObjects(By.res(matcherCheckBox))

        Assert.assertFalse("Check-boxes were not found!", listCheckBox.isEmpty())
        for (checkBox in listCheckBox) {
            Assert.assertTrue("Check-box isn`t checked!", checkBox.isChecked)
        }
    }

    fun swipeUp() =
        swipeUpRecycle(matcherRecycle)
}
