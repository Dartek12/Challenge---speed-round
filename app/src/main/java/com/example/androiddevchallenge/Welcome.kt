package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

@Composable
fun Welcome(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        WelcomeImage()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            BrandingName()
            Spacer(modifier = Modifier.height(32.dp))
            BigButton("Sign up", backgroundColor = MaterialTheme.colors.primary)
            Spacer(modifier = Modifier.height(8.dp))
            BigButton("Log in", backgroundColor = MaterialTheme.colors.secondary, onClick = {
                navController.navigate("login")
            })
        }
    }
}

@Composable
fun BrandingName() {
    val vectorRes = if (MaterialTheme.colors.isLight) {
        R.drawable.ic_light_logo
    } else {
        R.drawable.ic_dark_logo
    }

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Image(imageVector = ImageVector.vectorResource(id = vectorRes), contentDescription = "Logo")
    }
}

@Composable
fun WelcomeImage() {

    val vectorRes = if (MaterialTheme.colors.isLight) {
        R.drawable.ic_light_welcome
    } else {
        R.drawable.ic_dark_welcome
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