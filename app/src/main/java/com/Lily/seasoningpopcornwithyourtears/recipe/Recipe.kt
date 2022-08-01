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


    init {
        // Add some sample items.
        addItem(RecipeInstance("1", "Pizza rolls", "recipe", "ingredients"))
        addItem(RecipeInstance("2", "Recipe 2", "recipe", "ingredients"))
        addItem(RecipeInstance("3", "Recipe 3", "recipe", "ingredients"))
    }

    fun getRecipesByIds(itemIds: Array<String>): MutableList<RecipeInstance>{
        val requestedRecipes: MutableList<RecipeInstance> = ArrayList()
        for(requestedId in itemIds){
            val recipe: RecipeInstance?= ITEM_MAP[requestedId]
            if(recipe != null){
                requestedRecipes.add(recipe)
            }
        }
        return requestedRecipes;
    }

    private fun addItem(item: RecipeInstance) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }


    /**
     * A recipe item representing a piece of content.
     */
    data class RecipeInstance(val id: String,
                              val name: String,
                              val recipe: String,
                              val ingredients: String) {
        override fun toString(): String = name
    }
}