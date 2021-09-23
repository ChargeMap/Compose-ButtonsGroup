package com.chargemap.android.sample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.chargemap.compose.buttonsgroup.ButtonsGroup
import com.chargemap.compose.buttonsgroup.StateColors

@Composable
fun MainActivityUI() {

    val scrollState = rememberScrollState()

    var buttonsGroup1 by remember { mutableStateOf(0) }
    var buttonsGroup2 by remember { mutableStateOf(3) }

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text(stringResource(id = R.string.app_name)) })
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    ButtonsGroup(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        size = 3,
                        value = buttonsGroup1,
                        onValueChange = {
                            buttonsGroup1 = it
                        }
                    ) {
                        Text("Button $it")
                    }

                    ButtonsGroup(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        size = 5,
                        strokeWidth = 2.dp,
                        strokeColors = StateColors(Color.Magenta, Color.DarkGray.copy(alpha = 0.75f)),
                        value = buttonsGroup2,
                        onValueChange = {
                            buttonsGroup2 = it
                        }
                    ) {
                        Text("Button $it")
                    }
                }
            }
        }
    }
}