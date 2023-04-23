package testing.wiki

import android.view.View
import android.widget.TextView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

class MatcherTextViewUniqueDrawingId(private val uniqueDrawingId: Int) :
    BoundedMatcher<View, TextView>(TextView::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("uniqueDrawingId is $uniqueDrawingId")
    }

    override fun matchesSafely(textView: TextView): Boolean {
        return textView.uniqueDrawingId == uniqueDrawingId.toLong()
    }
}
