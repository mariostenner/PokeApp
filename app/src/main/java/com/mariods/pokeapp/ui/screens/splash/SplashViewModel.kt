package com.mariods.pokeapp.ui.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _fadeAnim = MutableStateFlow(0f)
    val fadeAnim : StateFlow<Float> = _fadeAnim

    private val _navigateToLogin = MutableStateFlow<Unit>(Unit)
    val navigateToLogin : StateFlow<Unit> = _navigateToLogin

    init {
        startAnimationSplash()
    }

    private fun startAnimationSplash() {
        viewModelScope.launch {
            _fadeAnim.emit(0f)
            val animatable = Animatable(0f)
            animatable.animateTo(1f, animationSpec = tween(1000))
            _fadeAnim.emit(animatable.value)
            delay(1000)
            _navigateToLogin.emit(Unit)

        }
    }

}