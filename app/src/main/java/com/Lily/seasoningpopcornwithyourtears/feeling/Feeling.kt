package com.Lily.seasoningpopcornwithyourtears.feeling

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object Feeling {

    /**
     * An array of sample (feeling) items.
     */
    val ITEMS: MutableList<FeelingInstance> = ArrayList()

    /**
     * A map of sample (feeling) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, FeelingInstance> = HashMap()

    private val COUNT = 25

    init {

            addItem(createFeelingInstance(1, "lonely"))
        addItem(createFeelingInstance(2, "angry"))
        addItem(createFeelingInstance(3, "heart-broken"))
        addItem(createFeelingInstance(4, "hopeless"))
        addItem(createFeelingInstance(5, "hopeful"))
        }


    private fun addItem(item: FeelingInstance) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createFeelingInstance(position: Int, feelingName: String): FeelingInstance {
        return FeelingInstance(position.toString(), feelingName, makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A feeling item representing a piece of content.
     */
    data class FeelingInstance(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}