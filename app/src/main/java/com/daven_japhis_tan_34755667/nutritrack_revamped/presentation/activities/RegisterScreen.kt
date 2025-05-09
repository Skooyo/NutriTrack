package com.daven_japhis_tan_34755667.nutritrack_revamped.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daven_japhis_tan_34755667.nutritrack_revamped.presentation.components.MaskedInputField
import com.daven_japhis_tan_34755667.nutritrack_revamped.presentation.components.RoundedButton
import com.daven_japhis_tan_34755667.nutritrack_revamped.presentation.viewmodels.RegisterViewModel
import com.daven_japhis_tan_34755667.nutritrack_revamped.ui.theme.Nutritrack_RevampedTheme

class RegisterScreen : ComponentActivity() {
    private val viewModel by viewModels<RegisterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Nutritrack_RevampedTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegisterScreen(modifier = Modifier.padding(innerPadding), viewModel)
                }
            }
        }
    }
}

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    viewModel: RegisterViewModel
) {
    val context = LocalContext.current

    val userId = viewModel.userId;
    val phoneNumber = viewModel.phoneNumber;
    val phoneNumberVisibility = viewModel.phoneNumberVisibility;
    val password = viewModel.password;
    val passwordVisible = viewModel.passwordVisible;
    val confirmPassword = viewModel.confirmPassword;
    val confirmPasswordVisible = viewModel.confirmPasswordVisible;

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Register",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "User ID",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { }
                    .border(1.dp, Color.Gray)
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (userId.isEmpty()) "Select User ID" else userId,
                        color = if (userId.isEmpty()) Color.LightGray else Color.Black,
                    )
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "Dropdown Arrow"
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Phone Number",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left
                )
            }

            MaskedInputField(
                textInput = phoneNumber,
                onTextChange = { viewModel.updatePhoneNumber(it) },
                visibility = phoneNumberVisibility,
                toggleVisibility = { viewModel.togglePhoneNumberVisibility() },
                label = "Enter your phone number",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Password",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left
                )
            }

            MaskedInputField(
                textInput = password,
                onTextChange = { viewModel.updatePassword(it) },
                visibility = passwordVisible,
                toggleVisibility = { viewModel.toggleVisibility() },
                label = "Enter your password",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Confirm Password",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left
                )
            }

            MaskedInputField(
                textInput = confirmPassword,
                onTextChange = { viewModel.updateConfirmPassword(it) },
                visibility = confirmPasswordVisible,
                toggleVisibility = { viewModel.toggleConfirmVisibility() },
                label = "Confirm your password",
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "This application is only for pre-registered users, please enter your ID, phone number," +
                        " and password to claim your account.",
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            RoundedButton(
                text = "Register",
                onClick = {
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            RoundedButton(
                text = "Login",
                onClick = {
                    context.startActivity(Intent(context, LoginScreen::class.java));
                }
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}