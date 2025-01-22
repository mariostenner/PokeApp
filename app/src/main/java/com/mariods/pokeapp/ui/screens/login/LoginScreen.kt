package com.mariods.pokeapp.ui.screens.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mariods.pokeapp.R
import com.mariods.pokeapp.ui.theme.BluePrincipal
import com.mariods.pokeapp.ui.theme.YellowPrincipal

@Composable
fun LoginScreen(
    navigateToHome: () -> Unit = {},
    navigateToSignup: () -> Unit = {},
    loginViewModel: LoginViewModel = hiltViewModel(),
) {

    val context = LocalContext.current

    val loginState by loginViewModel.loginState.observeAsState()
    var tfLogin by remember { mutableStateOf("") }
    var tfPassword by remember { mutableStateOf("") }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BluePrincipal)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(
            alignment = Alignment.Center,
            contentDescription = "",
            painter = painterResource(R.drawable.ic_launcher_foreground),
            modifier = Modifier.size(300.dp)
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 32.sp,
            color = Color.White,
            text = "Bienvenido\nIngresa tus credenciales"
        )

        Spacer(modifier = Modifier.weight(1f))
        TextField(
            value = tfLogin,
            onValueChange = { tfLogin = it },
            placeholder = { Text("usuario@correo.com") },
            label = { Text("Usuario (email)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 16.dp),
            textStyle = TextStyle(fontSize = 30.sp),
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = BluePrincipal,
                focusedContainerColor = Color.White,

                unfocusedTextColor = Color.Black,
                unfocusedContainerColor = Color.White,
                unfocusedPlaceholderColor = Color.Red

            )
        )

        TextField(
            value = tfPassword,
            onValueChange = { tfPassword = it },
            placeholder = { Text("********") },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = 30.sp),
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = BluePrincipal,
                focusedContainerColor = Color.White,

                unfocusedTextColor = Color.Black,
                unfocusedContainerColor = Color.White,
                unfocusedPlaceholderColor = Color.Red

            )
        )
        Spacer(modifier = Modifier.weight(2f))

        Button(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            shape = RoundedCornerShape(16.dp),
            onClick = {
                loginViewModel.login(tfLogin, tfPassword)
            },
            colors = ButtonColors(
                containerColor = Color.White,
                contentColor = Color.Black,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.Black
            )
        ) {
            Text(
                fontSize = 24.sp,
                color = BluePrincipal,
                text = "Ingresar"
            )
        }
        Button(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            shape = RoundedCornerShape(16.dp),
            onClick = {
                navigateToSignup()
            },
            colors = ButtonColors(
                containerColor = YellowPrincipal,
                contentColor = Color.Black,
                disabledContainerColor = YellowPrincipal,
                disabledContentColor = Color.Black
            )
        ) {
            Text(
                fontSize = 24.sp,
                color = BluePrincipal,
                text = "Registrarse"
            )
        }
        Spacer(modifier = Modifier.weight(2f))
    }

    loginState?.let { isLoggedIn ->
        if (isLoggedIn) {
            LaunchedEffect(Unit) {
                navigateToHome()
            }
        } else {
            Toast.makeText(context, "Sin acceso", Toast.LENGTH_LONG).show()
        }
    }

}