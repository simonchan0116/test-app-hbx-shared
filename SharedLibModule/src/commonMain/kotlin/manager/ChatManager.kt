package manager

import kotlinx.coroutines.flow.MutableSharedFlow

object ChatManager {
    /*
    MutableSharedFlow = PassthroughSubject
    MutableStateFlow = CurrentValueSubject
     */
    val msgFlow = MutableSharedFlow<String>()

    suspend fun add(str: String) {
        this.msgFlow.emit("$str - From kmp")
    }
}