package com.mariods.pokeapp.ui.screens.login

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val firebaseAuth: FirebaseAuth) : ViewModel() {

    private val _loginState = MutableLiveData<Boolean>()
    val loginState: LiveData<Boolean> = _loginState


    fun login(email: String, pass: String) {
        firebaseAuth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener {
                _loginState.value = it.isSuccessful
            }
    }

}