package testing.wiki.pages

import org.wikipedia.R
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import org.junit.Assert.assertTrue

class CustomizeFeedPage {

    private val timeOut = 3000L

    private val selectorCheckBox =
        "org.wikipedia.alpha:id/feed_content_type_checkbox"

    private val matcherRecycle =
        withId(R.id.content_types_recycler)

    fun checkAllCustomizeFeedBoxesAreChecked() {
        val uiDevice = UiDevice.getInstance(getInstrumentation())

        uiDevice.wait(Until.findObjects(By.res(selectorCheckBox)), timeOut)
        uiDevice.findObjects(By.res(selectorCheckBox))
            .forEach {
                assertTrue("Check-box isn`t checked!", it.isChecked)
            }
    }

    fun swipeUp() =
        GeneralPageFunctions().swipeUpRecycle(matcherRecycle)
}
