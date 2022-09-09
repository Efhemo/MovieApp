package com.efhem.moviegalore.domain.excutor

import kotlinx.coroutines.CoroutineDispatcher

public interface PostExecutionThread {
    public val main: CoroutineDispatcher
    public val io: CoroutineDispatcher
    public val default: CoroutineDispatcher
}