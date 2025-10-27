package com.galvezsh.cmplogin.di

import com.galvezsh.cmplogin.presentation.login_screen.LoginViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val commonModule = module {

    //ViewModels
    viewModelOf( ::LoginViewModel )
}