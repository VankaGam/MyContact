package com.example.mycontact

data class Contact(
    val name: String, //Имя
    val surname: String? = null, //Отчествоо
    val familyName: String, //Фамилия
    val imageRes: Int? = null,//Ресурс фотографии
    val isFavorite: Boolean = false,//Признак избранного контакта
    val phone: String, //Телефон
    val address: String, //Адрес
    val email: String? = null, //E-maill
)
