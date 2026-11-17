package com.example.studentprofileapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.studentprofileapp.model.Student

@Composable
fun StudentListScreen(
    students: List<Student>,
    onStudentClick: (Student) -> Unit
) {

    LazyColumn {

        items(students) { student ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        onStudentClick(student)
                    }
            ) {

                Row(
                    modifier = Modifier.padding(12.dp)
                ) {

                    Image(
                        painter = painterResource(student.imageRes),
                        contentDescription = student.name,
                        modifier = Modifier.size(80.dp)
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {

                        Text(student.name)

                        Text(student.major)

                    }
                }
            }
        }
    }
}