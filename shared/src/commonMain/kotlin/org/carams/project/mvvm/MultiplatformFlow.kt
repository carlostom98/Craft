package org.carams.project.mvvm

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalForInheritanceCoroutinesApi
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


fun <T> StateFlow<T>.toMultiplatform(coroutineScope: CoroutineScope) = MultiplatformFlow(this, coroutineScope)

open class Close(private val onClose: () -> Unit) {
    fun close() = onClose()
}

@OptIn(ExperimentalForInheritanceCoroutinesApi::class)
class MultiplatformFlow<T> (private val delegate: StateFlow<T>, private val scope: CoroutineScope): StateFlow<T> by delegate {
    fun watch(onEmit: (T) -> Unit): Close {
       val job =  scope.launch {
            delegate.collect {
                onEmit(it)
            }
        }

        return Close { job.cancel() }
    }
}