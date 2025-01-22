package com.mariods.pokeapp.ui.screens.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(val firebaseAuth: FirebaseAuth) : ViewModel() {

    private val _signupState = MutableLiveData<Boolean>()
    val signupState: LiveData<Boolean> = _signupState


    fun signup(email: String, pass: String, passConfirm: String) {

        if (pass == passConfirm) {
            firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                _signupState.value = it.isSuccessful
            }
        }else {
            _signupState.value = false
        }
    }

}