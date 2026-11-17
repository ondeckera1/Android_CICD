package com.example.studentprofileapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.studentprofileapp.model.Student

@Composable
fun StudentDetailScreen(
    student: Student,
    onBackClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Image(
            painter = painterResource(id = student.imageRes),
            contentDescription = student.name,
            modifier = Modifier.size(250.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Name: ${student.name}")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Major: ${student.major}")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Bio: ${student.bio}")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onBackClick
        ) {
            Text("Back")
        }
    }
}