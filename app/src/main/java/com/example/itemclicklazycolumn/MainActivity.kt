package com.example.itemclicklazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.itemclicklazycolumn.screens.DetailScreen
import com.example.itemclicklazycolumn.screens.MainScreen
import com.example.itemclicklazycolumn.ui.theme.ItemClickLazyColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ItemClickLazyColumnTheme {

                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val imageId = arrayOf(
                        R.drawable.eminem,
                        R.drawable.avenged_sevenfold,
                        R.drawable.bmth,
                        R.drawable.green_day,
                        R.drawable.system_of_down,
                        R.drawable.my_chemical_romance
                    )
                    val names = arrayOf(
                        "Eminem",
                        "Avenged Sevenfold",
                        "Bring Me The Horizon",
                        "Green Day",
                        "System Of Down",
                        "My Chemical Romance"
                    )
                    val ingredients = arrayOf(
                        "Mockingbird, Cleanin' Out My Closet, Lose Yourself To Dream ",
                        "A Little Peace Of Heaven, Until The End, Unholy Confessions",
                        "Drown, Can You Feel My Hard, Sleepwalking",
                        "21 Guns, American Idiot, Good Riddance",
                        "Toxicity, Lonely Day, Chop Suey!",
                        "I Don't Love You, Disenchanted, Cancer"
                    )
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "MainScreen"
                    ) {
                        composable(route = "MainScreen") {
                            MainScreen(
                                imageId = imageId,
                                names = names,
                                ingredients = ingredients,
                                navController = navController
                            )
                        }
                        composable(route = "DetailScreen/{index}",
                            arguments = listOf(
                                navArgument(name = "index") {
                                    type = NavType.IntType
                                }
                            )
                        ) { index ->
                            DetailScreen(
                                photos = imageId,
                                names = names,
                                ingredients = ingredients,
                                itemIndex = index.arguments?.getInt("index"))
                        }
                    }
                }
            }
        }
    }
}

