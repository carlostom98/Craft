package org.carams.project.mvvm

import kotlinx.coroutines.flow.Flow

open class MultiplatformArticlesFlow<T: Any>(delegate: Flow<T>): Flow<T> by delegate

fun <T: Any> Flow<T>.multiplatform() = MultiplatformArticlesFlow(this)