/*
 * *
 *  * Mehul Kabaria on 21/04/2024, 10:30 AM
 *  * Copyright (c) 2024 . All rights reserved.
 *
 */

package com.mehul.newsapp.utils

import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {

    private const val RESOURCE = "GLOBAL"

    @JvmField
    val countingIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        countingIdlingResource.increment()
    }

    fun decrement() {
        if (!countingIdlingResource.isIdleNow) {
            countingIdlingResource.decrement()
        }
    }
}