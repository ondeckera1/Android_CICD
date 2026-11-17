package com.example.studentprofileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.studentprofileapp.data.StudentData
import com.example.studentprofileapp.screens.StudentDetailScreen
import com.example.studentprofileapp.screens.StudentListScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudentProfileApp()
        }
    }
}

@Composable
fun StudentProfileApp() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "list"
    ) {

        composable("list") {

            StudentListScreen(
                students = StudentData.students,
                onStudentClick = { student ->

                    navController.navigate(
                        "detail/${student.id}"
                    )
                }
            )
        }

        composable(
            route = "detail/{studentId}",
            arguments = listOf(
                navArgument("studentId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val studentId =
                backStackEntry.arguments?.getInt("studentId")

            val student =
                StudentData.students.find {
                    it.id == studentId
                }

            if (student != null) {

                StudentDetailScreen(
                    student = student,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )

            } else {

                androidx.compose.material3.Text(
                    text = "Student not found"
                )
            }
        }
    }
}