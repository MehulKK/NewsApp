/*
 * *
 *  * Mehul Kabaria on 21/04/2024, 10:30 AM
 *  * Copyright (c) 2022 . All rights reserved.
 *
 */

package com.mehul.newsapp.state

sealed class NetworkState<T>(val data: T? = null, val message: String? = null) {
    class Empty<T> : NetworkState<T>()
    class Loading<T> : NetworkState<T>()
    class Success<T>(data: T) : NetworkState<T>(data, null)

    @Suppress("UNUSED_PARAMETER")
    class Error<T>(message: String, data: T? = null) : NetworkState<T>(null, message)
}