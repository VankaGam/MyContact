package com.example.mycontact.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mycontact.Contact
import com.example.mycontact.R

@Composable
fun ContactDetails(contact: Contact, modifier: Modifier = Modifier) {
    val fullNameTop = buildString {
        append(contact.name)
        if (!contact.surname.isNullOrBlank()) append(" ${contact.surname}")
    }
    val lastName = contact.familyName

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AvatarOrInitials(
                imageRes = contact.imageRes,
                initials = "${contact.name.take(1)}${contact.familyName.take(1)}",
                modifier = Modifier.size(96.dp)
            )
            Spacer(Modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        fullNameTop,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        lastName,
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center
                    )
                }
                if (contact.isFavorite) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.star_big_on),
                        contentDescription = "favorite",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(24.dp)
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.75f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InfoRow(label = stringResource(R.string.phone), value = contact.phone)
            Spacer(Modifier.height(12.dp))
            InfoRow(label = stringResource(R.string.address), value = contact.address)
            if (!contact.email.isNullOrBlank()) {
                Spacer(Modifier.height(12.dp))
                InfoRow(label = stringResource(R.string.email), value = contact.email)
            }
        }
    }
}

@Composable
private fun AvatarOrInitials(
    imageRes: Int?,
    initials: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        if (imageRes != null) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(12.dp))
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.circle),
                contentDescription = null,
                tint = Color(0xFFE0E0E0),
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = initials.uppercase(),
                style = MaterialTheme.typography.titleMedium,
                color = Color.DarkGray
            )
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$label:",
            style = MaterialTheme.typography.bodyMedium.copy(fontStyle = FontStyle.Italic),
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.End
        )
        Spacer(Modifier.width(12.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(2f)
        )
    }
}