package com.example.leadminttask.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.leadminttask.R


@Composable
fun MainReferScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp)
    ) {
        ReferEarnHeader()

        Spacer(modifier = Modifier.height(100.dp))

        ReferEarnCard()

        Spacer(modifier = Modifier.height(16.dp))

        ShareReferCodeText()

        Spacer(modifier = Modifier.height(16.dp))

        ShareOfferCard()

        Spacer(modifier = Modifier.height(16.dp))

        ReferralRewards()
    }
}
@Composable
fun ReferEarnCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(300.dp)
    ) {
        Card(
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(300.dp)
                .border(1.dp, Color(0xFFBCD6FF), RoundedCornerShape(24.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colorStops = arrayOf(
                                0.0f to Color(0xFFBCD6FF),
                                0.6f to Color(0xFFFEFEFE),
                                1.0f to Color(0xFFFEFEFE)
                            ),
                            start = Offset(0f, 0f),
                            end = Offset(Float.POSITIVE_INFINITY, 0f)
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(12.dp)
                ) {
                    Text(
                        text = "Refer a Friend",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(
                            Font(
                                R.font.bold
                            )
                        ),
                        color = Color(0xFF82B1F9)
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Get ",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(R.font.extrabold)),
                            color = Color(0xFF3581F6)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.bolt),
                            contentDescription = null,
                            modifier = Modifier.size(22.dp)
                        )
                        Text(
                            text = " 2000 Coins",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(R.font.extrabold)),
                            color = Color(0xFF3581F6)
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "+",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF3581F6)
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Get 20% of your Friends\nPlaytime Earnings for\nlifetime!",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.extrabold)),
                        color = Color(0xFF3581F6),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }


        Image(
            painter = painterResource(id = R.drawable.refer_earn),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.TopCenter)
                .offset(y = -105.dp)
        )
    }
}

@Composable
fun ShareOfferCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFFEAF3FF))
            .drawDottedBorder(3.dp, Color(0xFF3581F6), 14f, 14f)
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 160.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "xxxxxxxx",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.extrabold)),
                    color = Color(0xFF3581F6)
                )
            }
        }


        Button(
            onClick = {  },
            modifier = Modifier
                .height(50.dp)
                .width(150.dp)
                .align(Alignment.CenterEnd)
                .offset(x = 16.dp)
                .border(
                    3.dp,
                    Color(0xFF4B8FF8),
                    RoundedCornerShape(18.dp)
                ),
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3581F6))
        ) {
            Text(
                text = "Share >",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.extrabold)),
                color = Color.White
            )
        }
    }
}


fun Modifier.drawDottedBorder(
    strokeWidth: Dp,
    color: Color,
    gap: Float,
    dashLength: Float
): Modifier {
    return this.then(
        Modifier.drawWithContent {
            drawContent()
            val stroke = Stroke(
                width = strokeWidth.toPx(),
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashLength, gap), 0f)
            )
            drawRoundRect(
                color = color,
                style = stroke,
                cornerRadius = CornerRadius(15.dp.toPx(), 15.dp.toPx())
            )
        }
    )
}

@Composable
fun ReferralRewards() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "You will receive your Rewards once your friend\nenters your Refer Code",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.regular)),
            color = Color(0xFF666666),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Share Via",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.regular)),
            color = Color(0xFF82B1F9),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                painter = painterResource(id = R.drawable.image1),
                contentDescription = "Share Option 1",
                modifier = Modifier.size(80.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.image2),
                contentDescription = "Share Option 2",
                modifier = Modifier.size(80.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.image3),
                contentDescription = "Share Option 3",
                modifier = Modifier.size(80.dp)
            )
        }
    }
}

@Composable
fun ReferEarnHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.arrow),
            contentDescription = "Back Arrow",
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Refer & Earn",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.extrabold)),
            color = Color(0xFF3581F6)
        )
    }
}

@Composable
fun ShareReferCodeText() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Share Your Refer Code with Your Friends",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.regular)),
            color = Color(0xFF82B1F9),
            textAlign = TextAlign.Center
        )
    }
}


