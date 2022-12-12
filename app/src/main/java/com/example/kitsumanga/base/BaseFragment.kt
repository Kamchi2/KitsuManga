package com.example.kitsumanga.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.viewbinding.ViewBinding
import com.example.kitsumanga.common.Resource

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel>(@LayoutRes layoutId: Int) :
    Fragment(layoutId) {

    protected abstract val binding: VB
    protected abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        setupListeners()
        setupRequest()
        setupSubscribes()
    }

    protected open fun initialize() {}

    protected open fun setupListeners() {}

    protected open fun setupRequest() {}

    protected open fun setupSubscribes() {}

    protected fun <T> LiveData<Resource<T>?>.subscribe(
        onSuccess: (result: T) -> Unit,
        onError: (message: String) -> Unit
    ) {
        observe(viewLifecycleOwner) {
            it.let {
                when (it) {
                    is Resource.Error -> {
                        onError(it.message.toString())
                    }
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        it.data?.let { data -> onSuccess(data) }
                    }
                    else -> {}
                }
            }
        }
    }
}