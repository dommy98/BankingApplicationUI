package com.example.bankingapplicationui

import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankingapplicationui.data.Card
import com.example.bankingapplicationui.ui.theme.BlueEnd
import com.example.bankingapplicationui.ui.theme.BlueStart
import com.example.bankingapplicationui.ui.theme.GreenEnd
import com.example.bankingapplicationui.ui.theme.GreenStart
import com.example.bankingapplicationui.ui.theme.OrangeEnd
import com.example.bankingapplicationui.ui.theme.OrangeStart
import com.example.bankingapplicationui.ui.theme.PurpleEnd
import com.example.bankingapplicationui.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "4478 1500 1099 3223",
        cardName = "Business",
        balance = 55.76,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTERCARD",
        cardNumber = "5196 6500 1099 3945",
        cardName = "Savings",
        balance = 31.46,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "4478 1500 3535 2316",
        cardName = "School",
        balance = 2.76,
        color = getGradient(OrangeStart, OrangeEnd)
    ),
    Card(
        cardType = "MASTERCARD",
        cardNumber = "5196 5266 2468 3688",
        cardName = "Trips",
        balance = 35.76,
        color = getGradient(GreenStart, GreenEnd)
    ),

)
fun getGradient(
    startColor: Color,
    endColor: Color
): Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Preview
@Composable
fun CardsSection(){
    LazyRow{
        items(cards.size){index ->
            CardItem(index)

        }
    }
}
@Composable
fun CardItem(
    index : Int
){
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size -1){
        lastItemPaddingEnd = 16.dp
    }
    var Image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTERCARD"){
        Image = painterResource(id = R.drawable.ic_mastercard)
    }
    Box(modifier = Modifier
        .padding(start = 16.dp, end = lastItemPaddingEnd)
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            androidx.compose.foundation.Image(
                painter = Image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text ="Ksh ${card.balance}" ,
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}