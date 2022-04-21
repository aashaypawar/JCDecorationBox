package com.geeksforgeeks.jcdecorationbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Creating a Simple Scaffold Layout for the application
            Scaffold(

                // Creating a Top Bar
                topBar = { TopAppBar(title = { Text("GFG | Decoration Box", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },

                // Creating Content
                content = {

                    // Creating a Column Layout
                    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                        var value by remember { mutableStateOf(TextFieldValue("")) }
                        BasicTextField(
                            value = value,
                            onValueChange = { value = it },
                            decorationBox = { innerTextField ->
                                Row(
                                    Modifier
                                        .background(Color.LightGray, RoundedCornerShape(percent = 30))
                                        .padding(16.dp)
                                        .fillMaxWidth()
                                ) {

                                    if (value.text.isEmpty()) {
                                        Text("Enter Something...")
                                    }
                                    innerTextField()  //<-- Add this
                                }
                            },
                        )

                    }
                }
            )
        }
    }
}