package com.example.radiojavan.di

import com.example.radiojavan.network.DefaultNetworkService
import com.example.radiojavan.network.NetworkService
import com.example.radiojavan.repository.RadioJavanRepository
import com.example.radiojavan.repository.remote_source.DefaultRemoteSource
import com.example.radiojavan.repository.remote_source.RemoteSource
import com.example.radiojavan.util.getDispatcherProvider
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val repositoryModule = module {
    single {
        RadioJavanRepository()
    }
    factory<RemoteSource> {
        DefaultRemoteSource(get(),get())
    }
}

val networkModule = module {
    factory<NetworkService> {
        DefaultNetworkService()
    }
}

val utilityModule = module {
    factory {
        getDispatcherProvider()
    }
}

val sharedModule = listOf(repositoryModule, networkModule, utilityModule)

fun initKoin(appDeclaration : KoinAppDeclaration) = startKoin {
    appDeclaration()
    modules(sharedModule)
}

fun initKoin() = initKoin { }