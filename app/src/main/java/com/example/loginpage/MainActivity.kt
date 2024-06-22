package com.example.loginpage

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.Visibility
//import com.example.loginpage.ui.theme.LoginPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            LoginScreen()
        }
    }
}


@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .background(Color(0xFFE3F2FD), RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Jetpack Compose",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1976D2),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.jetpack_compose_icon_rgb),
                        contentDescription = "Jetpack Logo",
                        modifier = Modifier.size(100.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Login",
                        fontSize = 29.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF136c48),
                        modifier = Modifier.align(Alignment.Start)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    var email by remember { mutableStateOf("") }
                    BasicTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .height(56.dp)
                            .border(
                                width = 1.dp,
                                color = Color.Gray,
                                shape = MaterialTheme.shapes.small
                            ),
                        singleLine = true,
                        textStyle = LocalTextStyle.current.copy(color = Color.Black),
                        decorationBox = { innerTextField ->
                            Box(
                                Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 16.dp, vertical = 8.dp),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                if (email.isEmpty()) {
                                    Text(text = "Email ID or Mobile Number", color = Color.Gray)
                                }
                                innerTextField()
                            }
                        }
                    )

                    var password by remember { mutableStateOf("") }
                    var passwordVisible by remember { mutableStateOf(false) }
                    BasicTextField(
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .height(56.dp)
                            .border(
                                width = 1.dp,
                                color = Color.Gray,
                                shape = MaterialTheme.shapes.small
                            ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default,
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        textStyle = LocalTextStyle.current.copy(color = Color.Black),
                        decorationBox = { innerTextField ->
                            Box(
                                Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 16.dp, vertical = 8.dp),
                                contentAlignment = Alignment.CenterStart
                            ) {
                                if (password.isEmpty()) {
                                    Text("Password", color = Color.Gray)
                                }
                                Row(
                                    Modifier.fillMaxSize(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    innerTextField()
                                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                        val image = if (passwordVisible)
                                            Icons.Default.Visibility
                                        else Icons.Default.VisibilityOff
                                        Icon(imageVector = image, contentDescription = null)
                                    }
                                }
                            }
                        }
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Forgot Password?",
                        fontSize = 14.sp,
                        color = Color(0xFF388E3C),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { /*Handle Forgot Password*/ }
                            .padding(end = 16.dp),
                        textAlign = TextAlign.End
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { /*Handle Login*/ },
                        modifier = Modifier.align(Alignment.Start)
                        .width(150.dp)
                        .height(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2))
                    ) {
                        Text(text = "Login", color = Color.White, fontSize = 18.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Text(text = "Don't have an account?", fontSize = 14.sp, color = Color.Gray)
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Register",
                    fontSize = 14.sp,
                    color = Color(0xFF1976D2),
                    modifier = Modifier.clickable { /* Handle register */ }
                )
            }
        }
    }
}
