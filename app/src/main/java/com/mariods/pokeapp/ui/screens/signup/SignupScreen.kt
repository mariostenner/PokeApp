package com.mariods.pokeapp.ui.screens.signup

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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mariods.pokeapp.R
import com.mariods.pokeapp.ui.screens.login.LoginViewModel
import com.mariods.pokeapp.ui.theme.BluePrincipal
import com.mariods.pokeapp.ui.theme.RedPrincipal
import com.mariods.pokeapp.ui.theme.YellowPrincipal

@Composable
fun SignupScreen(
    navigateToHome: () -> Unit = {},
    signupViewModel: SignupViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    val signupState by signupViewModel.signupState.observeAsState()
    var tfUser by remember { mutableStateOf("") }
    var tfPassword by remember { mutableStateOf("") }
    var tfPasswordConfirm by remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RedPrincipal)
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
            fontWeight = FontWeight.Bold,
            text = "Crea tu cuenta"
        )

        Spacer(modifier = Modifier.weight(1f))
        TextField(
            value = tfUser,
            onValueChange = { tfUser = it },
            placeholder = { Text("usuario@correo.com") },
            label = { Text("Usuario (email)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp),
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
            modifier = Modifier.fillMaxWidth().padding(0.dp, 8.dp),
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
            value = tfPasswordConfirm,
            onValueChange = { tfPasswordConfirm = it },
            placeholder = { Text("********") },
            label = { Text("Confirma Contraseña") },
            modifier = Modifier.fillMaxWidth().padding(0.dp, 8.dp),
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
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            onClick = {
                signupViewModel.signup(tfUser, tfPassword, tfPasswordConfirm)
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
                text = "SIGN UP"
            )
        }
        Spacer(modifier = Modifier.weight(2f))
    }

    signupState?.let { isSignup ->
        if (isSignup) {
            LaunchedEffect(Unit) {
                navigateToHome()
            }
        } else {
            Toast.makeText(context, "Intente de nuevo", Toast.LENGTH_LONG).show()
        }
    }
}