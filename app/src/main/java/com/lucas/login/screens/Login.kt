package com.lucas.login.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucas.login.R

@Composable
fun Login() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var erroEmail by remember{ mutableStateOf(false) }
    var mensagemEmail by remember { mutableStateOf("") }
    val tamanhoMaximo = 8

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.login),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
        Text(text = stringResource(id = R.string.subtitle))
        Spacer(modifier = Modifier.height(48.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    isError = erroEmail,
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = stringResource(id = R.string.email))
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )
                )
                Text(text = "E-mail é obrigatório", textAlign = TextAlign.End, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        if(it.length <= tamanhoMaximo){
                            password = it
                        }

                    },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = stringResource(id = R.string.password))
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )
                Spacer(modifier = Modifier.height(32.dp))

                Button(onClick = {
                    if(email.isEmpty()){
                        erroEmail = true
                    }else{
                        erroEmail = false
                    }
                })

                {
                    Text(
                        text = stringResource(id = R.string.enter),
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}