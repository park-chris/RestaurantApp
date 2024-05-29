package kr.co.fastcampus.part4plus.restaurantapp.features.feed.dialog

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.stringResource
import dagger.hilt.android.AndroidEntryPoint
import kr.co.fastcampus.part4plus.restaurantapp.ui_components.R
import kr.co.fastcampus.part4plus.restaurantapp.ui_components.components.dialog.Alert
import kr.co.fastcampus.part4plus.restaurantapp.ui_components.components.dialog.DialogPopup
import kr.co.fastcampus.part4plus.restaurantapp.ui_components.models.dialog.DialogButton
import kr.co.fastcampus.part4plus.restaurantapp.ui_components.theme.RestaurantAppTheme

@AndroidEntryPoint
class InfoDialogFragment : kr.co.fastcampus.part4plus.restaurantapp.core.BaseDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        dialog?.apply {
            isCancelable = true
            setCanceledOnTouchOutside(true)
            window?.setBackgroundDrawable(ColorDrawable(requireContext().getColor(android.R.color.transparent)))
        }

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                RestaurantAppTheme(
                    themeState = themeViewModel.themeState.collectAsState()
                ) {
                    DialogPopup.Alert(
                        title = stringResource(kr.co.fastcampus.part4plus.restaurantapp.features.feed.R.string.app_name),
                        bodyText = stringResource(R.string.info_message),
                        buttons = listOf(
                            DialogButton.UnderlinedText(getString(R.string.close)) {
                                dismiss()
                            }
                        )
                    )
                }
            }
        }
    }
}
