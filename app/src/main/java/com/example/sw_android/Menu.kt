package com.example.sw_android

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.startActivityForResult

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.example.sw_android.model.User
import com.example.sw_android.ui.theme.custom.CustomTextField
import com.example.sw_android.ui_page.auth_screen.singin_page.SingInFormEvent


@Composable
fun SetImage() {
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val context = LocalContext.current
    val bitmap = remember {
        mutableStateOf<Bitmap?>(null)
    }

    val launcher = rememberLauncherForActivityResult(
        contract =
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }
    Column() {
        Spacer(modifier = Modifier.height(12.dp))

        IconButton(onClick = {
            launcher.launch("image/*")
        },
             modifier = Modifier.size(200.dp)) {
            imageUri?.let {
                if (Build.VERSION.SDK_INT < 28) {
                    bitmap.value = MediaStore.Images
                        .Media.getBitmap(context.contentResolver, it)

                } else {
                    val source = ImageDecoder
                        .createSource(context.contentResolver, it)
                    bitmap.value = ImageDecoder.decodeBitmap(source)
                }

                bitmap.value?.let { btm ->
                    Image(
                        bitmap = btm.asImageBitmap(),
                        contentDescription = "image",
                        modifier = Modifier
                            .size(200.dp)
                            .clip(CircleShape)
                    )
                }
            }
        }
    }
}


@Composable
fun Menu(){ //Отображение экрана

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val context = LocalContext.current
    val bitmap = remember {
        mutableStateOf<Bitmap?>(null)
    }

    val launcher = rememberLauncherForActivityResult(
        contract =
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    Column(modifier = Modifier  // эл-ты по вертикали
        .fillMaxSize()
        .background(Color(0xFFDFDCDC))) {

        Card(modifier = Modifier // Верхняя шапка с надписью "Профиль"
            .fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            Color(0xFF2E2E2E))
        {
            Box(modifier =Modifier.padding(start = 20.dp, top = 15.dp, bottom =  15.dp))
            {
                Text(text = "Профиль",fontSize = 25.sp, color = Color.White)
            }
        }

    }

    Card(modifier = Modifier
        .fillMaxSize()
        .padding(top = 110.dp),
        shape = RoundedCornerShape(30.dp),
        elevation = 5.dp,
        backgroundColor = Color(0xFF2E2E2E)
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)) {
            Column() {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { launcher.launch("image/*") },
                        modifier = Modifier.size(120.dp)) {
                        Text(text = "None", color = Color.White)
                        imageUri?.let {
                            if (Build.VERSION.SDK_INT < 28) {
                                bitmap.value = MediaStore.Images
                                    .Media.getBitmap(context.contentResolver, it)
                            } else {
                                val source = ImageDecoder
                                    .createSource(context.contentResolver, it)
                                bitmap.value = ImageDecoder.decodeBitmap(source)
                            }
                            bitmap.value?.let { btm ->
                                Image(
                                    bitmap = btm.asImageBitmap(),
                                    contentDescription = "image",
                                    modifier = Modifier
                                        .size(120.dp)
                                        .clip(CircleShape)
                                )
                            }
                        }
                    }
                    Column() {
                        Text(text = "Андрушкевич", fontSize = 24.sp, color = Color.White)
                        Text(text = "Максим", fontSize = 20.sp, color = Color.White)
                    }
                }
                CardName(Text = "Имя", 50)
                CardName(Text = "Фамилия", 0)
                Card(
                    shape = RoundedCornerShape(20.dp),
                    elevation = 5.dp,
                    backgroundColor = Color.White,
                    modifier = Modifier
                        .padding(start = 80.dp, end = 80.dp, bottom = 30.dp)
                        .fillMaxWidth()
                ) {
                    Button(onClick = { /*TODO*/ },modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White) ) {
                        Text(text = "Сохранить")
                    }
                }
            }
        }

    }
}


@Composable
fun CardName(Text: String, top_dp : Int){
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = 5.dp,
        backgroundColor = Color.White,
        modifier = Modifier
            .padding( top = top_dp.dp, bottom = 30.dp)
            .fillMaxWidth()
    ) {
        TextName(Text)
    }
}

@Composable
fun TextName(Text:String) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = { Text(text = Text) },
        placeholder = { Text(text = "") },
    )
}


@Preview
@Composable
fun MenuShow() {
    Menu()
}

