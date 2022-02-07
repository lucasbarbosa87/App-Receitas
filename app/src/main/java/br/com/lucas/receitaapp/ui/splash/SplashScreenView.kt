package br.com.lucas.receitaapp.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import br.com.mercury.myapp.R
import br.com.lucas.receitaapp.ui.theme.ReceitasAppTheme

@Composable
@Preview
fun SplashScreenView() {
    ReceitasAppTheme {
        Surface(color = MaterialTheme.colors.primary) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                val imageRef = createRef()

                Image(
                    painter = painterResource(id = R.drawable.ic_icon_horizontal),
                    contentDescription = "",
                    modifier = Modifier
                        .constrainAs(imageRef) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        }
                        .fillMaxWidth()
                        .defaultMinSize(minHeight = 64.dp)
                )
            }
        }

    }
}