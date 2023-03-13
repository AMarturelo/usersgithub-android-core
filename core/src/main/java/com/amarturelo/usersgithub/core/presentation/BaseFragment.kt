package com.amarturelo.usersgithub.core.presentation

import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class BaseFragment<T : ViewModel> {
    @Inject
    lateinit var viewModel: T
}