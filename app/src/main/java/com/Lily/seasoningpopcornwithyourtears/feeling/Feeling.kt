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

    val FEELING_KEY: String = "FEELING_KEY"

    /**
     * An array of sample (feeling) items.
     */
    val ITEMS: MutableList<FeelingInstance> = ArrayList()

    /**
     * A map of sample (feeling) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, FeelingInstance> = HashMap()

    init {
        addItem(createFeelingInstance( "lonely", arrayOf("1")))
        addItem(createFeelingInstance( "angry", arrayOf("2")))
        addItem(createFeelingInstance("heart-broken", arrayOf("1", "2")))
        addItem(createFeelingInstance("hopeless", arrayOf("3")))
        addItem(createFeelingInstance("hopeful", arrayOf("2", "3")))
    }


    private fun addItem(item: FeelingInstance) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createFeelingInstance(feelingName: String, recipeIds: Array<String>): FeelingInstance {
        val instanceIndex: Int = FeelingInstance.getAndIncrementInstanceCount()
        return FeelingInstance(instanceIndex.toString(), feelingName, recipeIds)
    }


    /**
     * A feeling item representing a piece of content.
     */
    data class FeelingInstance(val id: String, val name: String, var recipeIds: Array<String>) {
        companion object{
            private var instanceCount: Int = 0
            fun getAndIncrementInstanceCount(): Int{
                instanceCount += 1
                return instanceCount
            }
        }
        override fun toString(): String = name
    }
}