package com.example.lokal_demo.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LokalApp(modifier: Modifier = Modifier) {

    var bottomNavColorJob by remember{ mutableStateOf(Color.Green) }
    var bottomNavColorBookmerk by remember{ mutableStateOf(Color.Green) }


    Column ( modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.Bottom) {

        // content body

        Box(modifier = Modifier)

        //bottom navigation
        Row ( modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.12f)
            .padding(start = 10.dp, top = 10.dp, bottom = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
            ){

            Row (
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f)
                    .border(1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
                    .background(bottomNavColorJob, shape = RoundedCornerShape(10.dp))
                    .clickable {
                        if (bottomNavColorJob == Color.Green) bottomNavColorJob = Color.Gray
                        else bottomNavColorJob = Color.Green
                    }
                    ,
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Jobs" ,fontSize = 23.sp, textDecoration = TextDecoration.Underline)
            }

            Spacer(modifier = Modifier.width(10.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .border(1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp))
                    .background(bottomNavColorBookmerk, shape = RoundedCornerShape(10.dp))
                    .clickable {
                        if (bottomNavColorBookmerk == Color.Green) bottomNavColorBookmerk =
                            Color.Gray
                        else bottomNavColorBookmerk = Color.Green
                    },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Bookmerks", fontSize = 23.sp, textDecoration = TextDecoration.Underline)
            }

        }

        

    }
}

@Preview (showBackground = true)
@Composable
private fun LokalAppPreview() {
    LokalApp()
}