package com.example.mycontact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import com.example.mycontact.ui.composable.ContactDetails

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ContactDetails(
                    contact = Contact(
                        name = "Василий",
                        surname = null,
                        familyName = "Кузякин",
                        imageRes = R.drawable.lastocka_photo,
                        isFavorite = false,
                        phone = "---",
                        address = "Ивановская область, дер. Крутово, д. 4",
                        email = null
                    ),
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview(name = "Избранный без фото, с email", showBackground = true)
@Composable
private fun FavoriteNoPhotoPreview() {
    MaterialTheme {
        ContactDetails(
            contact = Contact(
                name = "Евгений",
                surname = "Андреевич",
                familyName = "Лукашин",
                imageRes = null,
                isFavorite = true,
                phone = "+7 495 495 95 95",
                address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12", //деревня рядоам
                email = "ELukashin@practicum.ru"
            ),
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(name = "Обычный с фото, без email", showBackground = true)
@Composable
private fun NotFavoriteWithPhotoPreview() {
    MaterialTheme {
        ContactDetails(
            contact = Contact(
                name = "Василий",
                surname = null,
                familyName = "Кузякин",
                imageRes = R.drawable.lastocka_photo,
                isFavorite = false,
                phone = "---",
                address = "Ивановская область, дер. Крутово, д. 4", //kiy
                email = null
            ),
            modifier = Modifier.fillMaxSize()
        )
    }
}