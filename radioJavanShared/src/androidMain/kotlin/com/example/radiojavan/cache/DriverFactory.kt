package com.example.radiojavan.cache

import com.example.radiojavan.db.Database
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import org.koin.android.ext.koin.androidContext
import org.koin.core.scope.Scope

internal actual fun Scope.createDriver(databaseName : String) : SqlDriver = AndroidSqliteDriver(
    Database.Schema, context = androidContext(), databaseName)