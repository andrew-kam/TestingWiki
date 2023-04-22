package testing.wiki

import androidx.test.espresso.Espresso.onView
import org.hamcrest.Matcher
import androidx.test.espresso.action.ViewActions.click
import android.view.View

open class BasePage {

    fun clickButton(matcher: Matcher<View>) {
        onView(matcher).perform(click())
    }
}