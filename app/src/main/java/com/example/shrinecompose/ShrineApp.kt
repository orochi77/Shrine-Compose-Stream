package com.example.shrinecompose

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun ShrineApp() {
    var sheetState by rememberSaveable { mutableStateOf(CartBottomSheetState.Collapsed) }

    BoxWithConstraints(
        Modifier.fillMaxSize()
    ) {
        Backdrop(
            showScrim = sheetState == CartBottomSheetState.Expanded
        ) { revealed ->
            if (revealed) {
                sheetState = CartBottomSheetState.Hidden
            } else {
                sheetState = CartBottomSheetState.Collapsed
            }
        }
        CartBottomSheet(
            modifier = Modifier.align(Alignment.BottomEnd),
            sheetState = sheetState,
            maxHeight = maxHeight,
            maxWidth = maxWidth
        ) {
            sheetState = it
        }
    }
}

enum class CartBottomSheetState {
    Collapsed,
    Expanded,
    Hidden,
}