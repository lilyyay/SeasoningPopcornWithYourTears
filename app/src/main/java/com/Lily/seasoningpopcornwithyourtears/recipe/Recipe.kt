package com.Lily.seasoningpopcornwithyourtears.recipe

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object Recipe {

    /**
     * An array of sample (recipe) items.
     */
    val ITEMS: MutableList<RecipeInstance> = ArrayList()

    /**
     * A map of sample (recipe) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, RecipeInstance> = HashMap()

    private val COUNT = 25

    init {
        // Add some sample items.

            addItem(createRecipeInstance(1, "Pizza rolls"))
    }

    private fun addItem(item: RecipeInstance) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createRecipeInstance(position: Int, recipeName: String): RecipeInstance {

    return RecipeInstance(position.toString(), recipeName, makeDetails(position))
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
     * A recipe item representing a piece of content.
     */
    data class RecipeInstance(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}