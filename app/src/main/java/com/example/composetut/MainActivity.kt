package com.example.composetut

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composetut.ui.theme.ComposeTutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Rec(name = "HELLO")
//                    //Greeting("nothing")
//                }
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp
                Calculator(state = state,
                    onAction = viewModel::onAction,
                    buttonSpacing = buttonSpacing,
                    modifier = Modifier.fillMaxSize().background(Color.White).padding(16.dp))

            }
        }
    }
}
@Composable
fun Rec(name: String) {
    var count by remember {
        mutableStateOf(0)
    }
    Column {
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(100) { item ->
                Icon(
                    imageVector = Icons.Default.MailOutline,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
            }
        }
        Text(text = count.toString(), fontSize = 30.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally))
        Button(onClick = { count++ },
            modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "Increment Count")
        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(200) { item ->
                Row(modifier = Modifier
                    .shadow(6.dp)
                    .padding(15.dp)
                    .fillMaxWidth()) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null,
                        modifier = Modifier.size(80.dp)
                    )
                    Text(
                        text = "Hello $name!",
                        color = Color.Red,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(20.dp)
                            .align(Alignment.Top)
                    )
                }
            }
        }
    }
}

@Composable
fun listDemo(name: String) {
    var name by remember {
        mutableStateOf("")
    }
    var names by remember {
        mutableStateOf(listOf<String>())
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(value = name,
                onValueChange = {
                    text -> name = text
                },
                modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                if (name.isNotBlank()) {
                    names = names + name
                    name = ""
                }
            }) {
                Text(text = "Add")
            }
        }
        LazyColumn {
            items(names) {
                currentName ->
                Text(
                text = currentName,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
                Divider()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .size(30.dp)
            )
        Row {
            Icon(imageVector = Icons.Default.Add,
                contentDescription = null,
                Modifier.background(Color.Gray))
            Text(
                text = "Hello $name!",
                color = Color.Red,
                fontSize = 30.sp,
                modifier = Modifier
                    .background(Color.DarkGray)
                    .padding(20.dp)
            )
        }
        Row {
            Icon(imageVector = Icons.Default.Add,
                contentDescription = null,
                Modifier.background(Color.Gray))
            Text(
                text = "Hello $name!",
                color = Color.Red,
                fontSize = 30.sp,
                modifier = Modifier
                    .background(Color.DarkGray)
                    .padding(20.dp)
            )
        }
        Row {
            Icon(imageVector = Icons.Default.Add,
                contentDescription = null,
                Modifier.background(Color.Gray))
            Text(
                text = "Hello $name!",
                color = Color.Red,
                fontSize = 30.sp,
                modifier = Modifier
                    .background(Color.DarkGray)
                    .padding(20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecPreview() {
    ComposeTutTheme {
        Rec("HELLO")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTutTheme {
        //listDemo(name = "")
    }
}