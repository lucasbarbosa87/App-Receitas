package br.com.lucas.receitaapp.ui.login.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import br.com.mercury.myapp.R
import br.com.lucas.receitaapp.ui.theme.ReceitasAppTheme

@Composable
fun LoginView(context: Context) = ReceitasAppTheme {
    val email = ""
    val password = ""
    Surface(color = MaterialTheme.colors.primary) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(modifier = Modifier.height(40.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_icon),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 120.dp)
            )
            Box(modifier = Modifier.height(40.dp))
            LoginFields(
                email = email,
                password = password,
                context = context
            )
        }

    }
}

@Composable
fun LoginFields(
    email: String,
    password: String,
//    onEmailChange: (String) -> Unit,
//    onPasswordChange: (String) -> Unit,
//    onLoginClick: (String) -> Unit,
    context: Context
) {
    val focusManager = LocalFocusManager.current

    ConstraintLayout {
        val (emailRef, passwordRef, loginRef, loginWithGoogleRef, registerRef, recoveryPasswordRef) = createRefs()

        OutlinedTextField(
            value = password,
            placeholder = { Text(text = "user@email.com") },
            label = { Text(text = "E-mail") },
            onValueChange = { },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                focusedLabelColor = Color.White
            ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            modifier = Modifier.constrainAs(emailRef) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        OutlinedTextField(
            value = password,
            placeholder = { Text(text = "senha") },
            label = { Text(text = "Senha") },
            onValueChange = { },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                focusedLabelColor = Color.White
            ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            modifier = Modifier.constrainAs(passwordRef) {
                top.linkTo(emailRef.bottom, 12.dp)
                start.linkTo(emailRef.start)
                end.linkTo(emailRef.end)
            }
        )

        Button(
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            ),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White
            ),
            modifier = Modifier
                .constrainAs(loginRef) {
                    top.linkTo(passwordRef.bottom, margin = 12.dp)
                    start.linkTo(passwordRef.start)
                    end.linkTo(passwordRef.end)
                    width = Dimension.fillToConstraints
                },
            onClick = {
                if (email.isNotBlank() && password.isNotBlank()) {
//                onLoginClick(email)
                    focusManager.clearFocus()
                } else {
                    Toast.makeText(
                        context,
                        "Please enter an email and password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }) {
            Text(
                stringResource(id = R.string.login_bt_login).uppercase(),
                style = MaterialTheme.typography.button
            )
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White
            ),
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            ),
            modifier = Modifier
                .constrainAs(loginWithGoogleRef) {
                    top.linkTo(loginRef.bottom, margin = 12.dp)
                    start.linkTo(loginRef.start)
                    end.linkTo(loginRef.end)
                    width = Dimension.fillToConstraints
                },
            onClick = {
                if (email.isNotBlank() && password.isNotBlank()) {
//                onLoginClick(email)
                    focusManager.clearFocus()
                } else {
                    Toast.makeText(
                        context,
                        "Please enter an email and password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_google_logo), contentDescription = "",
                modifier = Modifier.background(Color.Unspecified)
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSize))
            Text(
                stringResource(id = R.string.login_bt_login_with_goole).uppercase(),
                style = MaterialTheme.typography.button
            )
        }

        Button(
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            ),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.White
            ),
            modifier = Modifier
                .constrainAs(registerRef) {
                    top.linkTo(loginWithGoogleRef.bottom, margin = 12.dp)
                    start.linkTo(loginWithGoogleRef.start)
                    end.linkTo(loginWithGoogleRef.end)
                    width = Dimension.fillToConstraints
                },
            onClick = {
                if (email.isNotBlank() && password.isNotBlank()) {
//                onLoginClick(email)
                    focusManager.clearFocus()
                } else {
                    Toast.makeText(
                        context,
                        "Please enter an email and password",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }) {
            Text(
                stringResource(id = R.string.login_bt_register).uppercase(),
                style = MaterialTheme.typography.button
            )
        }

        TextButton(
            onClick = {},
            modifier = Modifier
                .constrainAs(recoveryPasswordRef) {
                    top.linkTo(registerRef.bottom, margin = 20.dp)
                    start.linkTo(registerRef.start)
                    end.linkTo(registerRef.end)
                    width = Dimension.fillToConstraints
                },
        ) {
            Text(
                stringResource(id = R.string.login_bt_recovery_password).uppercase(),
                style = MaterialTheme.typography.body1.copy(
                    color = Color.White
                )
            )
        }

    }

}

@Preview
@Composable
fun PreviewLogin() = LoginView(context = LocalContext.current)