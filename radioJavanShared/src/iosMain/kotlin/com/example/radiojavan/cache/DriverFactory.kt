package com.example.radiojavan.cache

import com.example.radiojavan.db.Database
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import org.koin.core.scope.Scope

internal actual fun Scope.createDriver(databaseName : String) : SqlDriver =
    NativeSqliteDriver(Database.Schema,databaseName)