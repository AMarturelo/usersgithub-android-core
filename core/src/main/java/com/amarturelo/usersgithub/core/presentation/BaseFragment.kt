package com.amarturelo.usersgithub.core.presentation

import androidx.lifecycle.ViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<T : ViewModel> : DaggerFragment() {
    @Inject
    lateinit var viewModel: T
}