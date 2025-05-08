package com.daven_japhis_tan_34755667.nutritrack_revamped.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.daven_japhis_tan_34755667.nutritrack_revamped.R
import com.daven_japhis_tan_34755667.nutritrack_revamped.presentation.components.RoundedButton
import com.daven_japhis_tan_34755667.nutritrack_revamped.ui.theme.Nutritrack_RevampedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Nutritrack_RevampedTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WelcomeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp).padding(top=48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "NutriTrack",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )

        Image(
            painter = painterResource(id = R.drawable.homeimage),
            contentDescription = "NutriTrack",
            modifier = Modifier.size(300.dp)
        )

        Text(
            text = "This app provides general health and nutrition information for educational purposes only. " +
                    "It is not intended as medical advice, diagnosis, or treatment. " +
                    "Always consult a qualified healthcare professional before making any changes to your diet, " +
                    "exercise, or health regimen. Use this app at your own risk. If you’d like to an Accredited " +
                    "Practicing Dietitian (APD), please visit the Monash Nutrition/Dietetics Clinic " +
                    "(discounted rates for students):\n" +
                    "https://www.monash.edu/medicine/scs/nutrition/clinics/nutrition",
            modifier = modifier,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            fontSize = 13.sp
        )

        RoundedButton(
            text = "Login",
            onClick = {
                context.startActivity(Intent(context, LoginScreen::class.java))
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Designed by Daven Japhis Tan - 34755667",
            fontSize = 12.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Bold
        )
    }
}