package kr.co.fastcampus.part4plus.restaurantapp.ui.components.dialog.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kr.co.fastcampus.part4plus.restaurantapp.ui.components.buttons.PrimaryButton
import kr.co.fastcampus.part4plus.restaurantapp.ui.components.buttons.SecondaryBorderlessButton
import kr.co.fastcampus.part4plus.restaurantapp.ui.components.buttons.SecondaryButton
import kr.co.fastcampus.part4plus.restaurantapp.ui.components.buttons.UnderlinedTextButton
import kr.co.fastcampus.part4plus.restaurantapp.ui.models.dialog.DialogButton
import kr.co.fastcampus.part4plus.restaurantapp.ui.theme.Paddings

@Composable
fun DialogButtonsColumn(
    buttons: List<DialogButton>?
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        buttons?.forEachIndexed { index, dialogButton ->
            if (index > 0) {
                Spacer(modifier = Modifier.height(Paddings.large))
            }
            when (dialogButton) {
                is DialogButton.Primary -> {
                    PrimaryButton (
                        text = dialogButton.title,
                        leadingIconData = dialogButton.leadingIconData
                    ) { dialogButton.action?.invoke() }
                }
                is DialogButton.Secondary -> {
                    SecondaryButton (
                        text = dialogButton.title
                    ) { dialogButton.action?.invoke() }
                }
                is DialogButton.SecondaryBorderless -> {
                    SecondaryBorderlessButton (
                        text = dialogButton.title
                    ) { dialogButton.action?.invoke() }
                }
                is DialogButton.UnderlinedText -> {
                    UnderlinedTextButton (
                        text = dialogButton.title
                    ) { dialogButton.action?.invoke() }
                }
            }
        }
    }
}

