package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

@Composable
fun Login(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        LoginImage()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                "LOG IN",
                modifier = Modifier.paddingFromBaseline(top = 200.dp, bottom = 32.dp),
                style = MaterialTheme.typography.h1,
            )

            TextField(
                modifier = Modifier
                    .requiredHeight(height = 56.dp)
                    .fillMaxWidth(),
                value = "Email address",
                onValueChange = {},
                textStyle = MaterialTheme.typography.body1,
                colors = TextFieldDefaults.textFieldColors(backgroundColor =  MaterialTheme.colors.surface)
            )

            Spacer(modifier = Modifier.height(8.dp))


            TextField(
                modifier = Modifier
                    .requiredHeight(height = 56.dp)
                    .fillMaxWidth(),
                value = "Password",
                onValueChange = {},
                textStyle = MaterialTheme.typography.body1,
                colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface)
            )

            Spacer(modifier = Modifier.height(8.dp))

            BigButton(text = "Log in", backgroundColor = MaterialTheme.colors.primary, onClick = {
                navController.navigate("home")
            })

            val signUpText = with(AnnotatedString.Builder("Don't have account? ")) {
                withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append("Sign up")
                }
                toAnnotatedString()
            }

            Text(
                signUpText,
                modifier = Modifier
                    .paddingFromBaseline(top = 32.dp),
            )
        }
    }
}

@Composable
fun LoginImage() {

    val vectorRes = if (MaterialTheme.colors.isLight) {
        R.drawable.ic_light_login
    } else {
        R.drawable.ic_dark_login
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            imageVector = ImageVector.vectorResource(id = vectorRes),
            contentDescription = "Background",
            contentScale = ContentScale.Crop
        )
    }
}