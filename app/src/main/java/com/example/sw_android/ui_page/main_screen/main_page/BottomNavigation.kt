package com.example.sw_android.ui_page.main_screen.main_page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.sw_android.R
import com.example.sw_android.Screen


data class BottomNavItem(
    val icon: @Composable () -> Unit,
    val route: String
)

@Composable
fun AddIcon(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(52.dp)
            .background(
                color = Color(0xffC6CBDD),
                shape = RoundedCornerShape(50)
            )
    ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(44.dp)
                .background(
                    color = Color(0xff2E2E2E),
                    shape = RoundedCornerShape(50)
                )
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = null,
                tint = Color(0xffFFFFFF),
                modifier = Modifier
                    .size(30.dp)
            )
        }
    }
}

@Composable
fun MenuIcon(){
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .width(21.dp)
            .height(19.dp)
    ) {
        Icon(painter = painterResource(id = R.drawable.menu_rectangle), contentDescription = null)
        Icon(painter = painterResource(id = R.drawable.menu_rectangle), contentDescription = null)
        Icon(painter = painterResource(id = R.drawable.menu_rectangle), contentDescription = null)
    }
}

@Composable
fun BottomNavigationGraph(
    navControllerBottom: NavController,
    navController: NavController
){
    val items = listOf(
        BottomNavItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
            },
            route = Screen.SearchScreen.route
        ),
        BottomNavItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.task),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
            },
            route = Screen.TaskScreen.route
        ),
        BottomNavItem(
            icon = {
                AddIcon()
            },
            route = Screen.AddNewTaskScreen.route
        ),
        BottomNavItem(
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.pie_chart),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
            },
            route = Screen.AnaliticScreen.route
        ),
        BottomNavItem(
            icon = { MenuIcon() },
            route = Screen.MenuScreen.route
        ),

    )
    BottomNavigation(
        backgroundColor = Color(0xffF6F7FB)
    ) {
        val navBackStackEntry by navControllerBottom.currentBackStackEntryAsState()
        items.forEach { item ->
            val selected = item.route == navBackStackEntry?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = {
                    if (item.route == Screen.AddNewTaskScreen.route){
                        navController.navigate(item.route){
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                        }

                    }else{
                        navControllerBottom.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                        }
                    }

                },
                icon = item.icon,
                selectedContentColor = Color(0xff000000),
                unselectedContentColor = Color(0xffD3D3D3)
            )
        }
    }
}

@Preview
@Composable
private fun AddIconPreview(){
    AddIcon()
}

@Preview
@Composable
private fun MenuIconPreview(){
    MenuIcon()
}