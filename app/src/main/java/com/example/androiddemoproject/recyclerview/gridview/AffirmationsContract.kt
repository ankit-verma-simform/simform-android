package com.example.androiddemoproject.recyclerview.gridview

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class AffirmationsContract : ActivityResultContract<Int, Boolean>() {
    companion object {
        const val SCROLL_POSITION = "scroll position"
        const val ANY_AFFIRMATION_DELETED = "any affirmation deleted"
    }

    override fun createIntent(context: Context, input: Int): Intent {
        return Intent(context, HorizontalAffirmationsActivity::class.java).also {
            it.putExtra(SCROLL_POSITION, input)
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Boolean {
        return intent?.getBooleanExtra(ANY_AFFIRMATION_DELETED, true) ?: true
    }
}