package com.health.kotlincheatsheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.health.kotlincheatsheet.ui.theme.KotlinCheatSheetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinCheatSheetTheme {
                Surface() {
                    Scaffold(
                        topBar = {
                            TopAppBar(title = { Text("Welcome to the Home Screen") })
                        },
                        bottomBar = {
                            BottomAppBar {
                                Button(
                                    onClick = { /* Handle Close App */ },
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(text = "Close App")
                                }
                            }
                        }
                    ) { paddingValues -> MyContent(Modifier.padding(paddingValues))
                    }
                }
            }
        }
    }
}

@Composable
fun MyContent(modifier: Modifier = Modifier){
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(), // Specifies how the surface takes up space
        color = MaterialTheme.colors.background, // Background color of the surface
        shape = MaterialTheme.shapes.medium, // Shape of the surface (e.g., rounded corners)
        elevation = 4.dp // Adds shadow to give a "lifted" effect
    ) {
        // UI components within the Surface
        Column(modifier.padding()) {
            Row {
                CustomButton("Button1")
                CustomButton("Button2")
                CustomButton("Button3")
            }
            Row() {
                CustomButton("Button4")
                CustomButton("Button5")
                CustomButton("Button6")
            }
        }
    }
}

@Composable
fun CustomButton(name : String) {
    Button(onClick = { /* Handle button click */ }, modifier = Modifier.padding(6.dp)) {
        Text(text = "Click Me!")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KotlinCheatSheetTheme {
        MyContent()
    }
}