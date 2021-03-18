package org.wikipedia.suggestededits

import android.content.Context
import android.content.Intent
import android.os.Bundle
import org.wikipedia.Constants
import org.wikipedia.Constants.INTENT_EXTRA_ACTION
import org.wikipedia.Constants.INTENT_EXTRA_INVOKE_SOURCE
import org.wikipedia.R
import org.wikipedia.activity.SingleFragmentActivity
import org.wikipedia.descriptions.DescriptionEditActivity.Action
import org.wikipedia.descriptions.DescriptionEditActivity.Action.*
import org.wikipedia.suggestededits.SuggestedEditsCardsFragment.Companion.newInstance

class SuggestionsActivity : SingleFragmentActivity<SuggestedEditsCardsFragment>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = getString(getActionBarTitleRes(intent.getSerializableExtra(INTENT_EXTRA_ACTION) as Action))
        setImageZoomHelper()
    }

    override fun createFragment(): SuggestedEditsCardsFragment {
        return newInstance(intent.getSerializableExtra(INTENT_EXTRA_ACTION) as Action,
                intent.getSerializableExtra(INTENT_EXTRA_INVOKE_SOURCE) as Constants.InvokeSource)
    }

    private fun getActionBarTitleRes(action: Action): Int {
        return if (action == ADD_IMAGE_TAGS) {
            R.string.suggested_edits_tag_images
        } else if (action == ADD_CAPTION || action == TRANSLATE_CAPTION) {
            R.string.suggested_edits_caption_images
        } else {
            R.string.suggested_edits_describe_articles
        }
    }

    companion object {
        const val EXTRA_SOURCE_ADDED_CONTRIBUTION = "addedContribution"

        @JvmStatic
        fun newIntent(context: Context, action: Action, source: Constants.InvokeSource): Intent {
            return Intent(context, SuggestionsActivity::class.java)
                    .putExtra(INTENT_EXTRA_ACTION, action)
                    .putExtra(INTENT_EXTRA_INVOKE_SOURCE, source)
        }
    }
}
