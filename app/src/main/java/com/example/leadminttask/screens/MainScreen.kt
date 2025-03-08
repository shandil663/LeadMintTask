package com.example.leadminttask.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import com.example.leadminttask.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun CashJoyScreen(navController: NavController) {
    var boostActive by remember { mutableStateOf(false) }
    var remainingTime by remember { mutableStateOf(59 * 60) }
    Scaffold(
        bottomBar = { BottomNavBar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeaderSection()
                Spacer(modifier = Modifier.padding(5.dp))
                PlayEarnCardWithOverflow(boostActive, remainingTime)
                Spacer(modifier = Modifier.padding(10.dp))
                PlayEarnCard()
                Spacer(modifier = Modifier.padding(10.dp))
                if (!boostActive) {
                    BoostOffers {
                        boostActive = true
                        startTimer { timeLeft -> remainingTime = timeLeft }
                    }
                }
                Spacer(modifier = Modifier.padding(10.dp))
                LockCardWithBottomSheet()
                Spacer(modifier = Modifier.padding(10.dp))
                SmallCards(navController)
                Spacer(modifier = Modifier.padding(10.dp))
                LeaderBoardCard()
                Spacer(modifier = Modifier.padding(10.dp))
            }
        }
    }
}


@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 32.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.cashjoy),
            contentDescription = "CashJoy Logo",
            modifier = Modifier
                .width(131.dp)
                .height(30.dp)
                .align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .height(60.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFEAF3FF))
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterStart)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = "My Balance",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color(0xFF82B1F9),
                            fontFamily = FontFamily(Font(R.font.regular))
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.bolt),
                                contentDescription = "Coin Icon",
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "499",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF3581F6),
                                fontFamily = FontFamily(Font(R.font.bold))
                            )
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .height(60.dp)
                    .width(150.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFF4B8FF8))
                    .clickable { }
                    .align(Alignment.CenterEnd)
                    .offset(x = (-20).dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "Redeem",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.bold)),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = ">",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }


        }
    }
}


@Composable
fun PlayEarnCardWithOverflow(boostActive: Boolean, remainingTime: Int) {
    val backgroundGradient = Brush.linearGradient(
        colorStops = arrayOf(
            0.0f to Color(0xFFFFCC00),
            0.1f to Color(0xFFFFCC00),
            1.0f to Color(0xFFFD9900)
        )
    )

    val borderGradient = Brush.linearGradient(
        colors = listOf(Color(0xFFF5B84C), Color(0xFF1C170E))
    )

    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(120.dp)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .align(Alignment.BottomCenter)
                .background(borderGradient, shape = RoundedCornerShape(24.dp))
                .padding(1.dp)
        ) {

            Card(
                shape = RoundedCornerShape(22.dp),
                elevation = CardDefaults.cardElevation(6.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(backgroundGradient)
                        .padding(start = 150.dp, end = 10.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Column {
                        Text(
                            text = "Play & Earn",
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF02275F),
                            fontFamily = FontFamily(Font(R.font.extrabold))
                        )
                        Text(
                            text = "UPTO $200 >",
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.extrabold))
                        )
                    }
                }
            }
        }
        if (boostActive) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 40.dp)
                    .offset(y=-15.dp)
            ) {
                BoostTimerBadge(remainingTime = remainingTime)
            }
        }



        Image(
            painter = painterResource(id = R.drawable.vr_guy),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .aspectRatio(1f)
                .align(Alignment.BottomStart)
                .offset(x = -10.dp, y = -20.dp)
        )
    }
}


@Composable
fun PlayEarnCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(horizontal = 20.dp)
            .border(1.dp, Color(0xFF635DFF), RoundedCornerShape(24.dp))
    ) {
        Card(
            shape = RoundedCornerShape(22.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.linearGradient(
                            colorStops = arrayOf(
                                0.0f to Color(0xFFFEFEFE),
                                0.4f to Color(0xFFFEFEFE),
                                1.0f to Color(0xFFC2C0FF)
                            )
                        )
                    )
                    .padding(start = 150.dp),
                contentAlignment = Alignment.CenterStart
            )
            {
                Column {
                    Text(
                        text = "PLAY GAMES",
                        fontSize = 35.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF02275F),
                        fontFamily = FontFamily(Font(R.font.extrabold))
                    )
                    Text(
                        text = "& EARN",
                        fontSize = 35.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF02275F),
                        fontFamily = FontFamily(Font(R.font.extrabold))
                    )
                    Text(
                        text = "UPTO $200 >",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color(0xFF635DFF),
                        fontFamily = FontFamily(Font(R.font.extrabold))
                    )
                }
            }
        }


        Image(
            painter = painterResource(id = R.drawable.play_games),
            contentDescription = null,
            modifier = Modifier
                .height(130.dp)
                .aspectRatio(1f)
                .align(Alignment.CenterStart)
                .padding(start = 10.dp)
        )
    }
}

@Composable
fun BoostOffers(onActivate: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFFF7FEEE))
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
                    .padding(start = 16.dp, end = 100.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "2X Rewards for 1hr",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.extrabold)),
                    color = Color(0xFF65B504)
                )
            }
        }


        Button(
            onClick = { onActivate() },
            modifier = Modifier
                .height(50.dp)
                .width(180.dp)
                .align(Alignment.CenterEnd)
                .offset(x = 8.dp)
                .padding(end = 12.dp)
                .border(1.dp, Color(0xFF61AC05), RoundedCornerShape(12.dp)),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF65B504))
        ) {
            Text(
                text = "Activate 2X",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.extrabold)),
                color = Color.White
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LockCardWithBottomSheet() {
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Box {
        LockCard(onClick = { showBottomSheet = true })
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            containerColor = Color.White
        ) {
            DailySecretCodeBottomSheet()
        }
    }
}

@Composable
fun LockCard(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .border(1.dp, Color(0xFFBCD6FF), RoundedCornerShape(24.dp))
            .clickable { onClick() }
    ) {
        Card(
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.linearGradient(
                            colorStops = arrayOf(
                                0.0f to Color(0xFFFEFEFE),
                                0.1f to Color(0xFFFEFEFE),
                                1.0f to Color(0xFFD1E3FF)
                            )
                        )
                    )
                    .padding(start = 65.dp, end = 10.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Column {
                    Text(
                        text = "Daily Secret Code >",
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.bold)),
                        color = Color(0xFF3581F6)
                    )
                    Text(
                        text = "Get more coins from our Telegram",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.bold)),
                        color = Color(0xFF82B1F9)
                    )
                }
            }
        }

        Image(
            painter = painterResource(id = R.drawable.lock),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .align(Alignment.CenterStart)
                .offset(x = 10.dp)
        )
    }
}


@Composable
fun SmallCards(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SmallCard(
            title1 = "Scratch Cards",
            title2 = "Watch & Earn More Coins",
            imageRes = R.drawable.scratch_card,
            textColor1 = Color(0xFF3581F6),
            textColor2 = Color(0xFF82B1F9),
            isReferCard = false,
            modifier = Modifier.weight(1f),
            onClick = {}
        )

        SmallCard(
            title1 = "Refer & Earn",
            title2 = "upto 200k",
            imageRes = R.drawable.refer_earn,
            textColor1 = Color(0xFF3581F6),
            textColor2 = Color(0xFF65B504),
            isReferCard = true,
            modifier = Modifier.weight(1f),
            onClick = { navController.navigate("referEarnScreen") }
        )
    }
}

@Composable
fun SmallCard(
    title1: String,
    title2: String,
    imageRes: Int,
    textColor1: Color,
    textColor2: Color,
    isReferCard: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(24.dp),
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1.1f)
            .border(1.dp, Color(0xFFBCD6FF), RoundedCornerShape(24.dp))
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colorStops = arrayOf(
                            0.0f to Color(0xFFBCD6FF),
                            0.5f to Color(0xFFFEFEFE),
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
                    text = title1,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.extrabold)),
                    color = textColor1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                if (isReferCard) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 4.dp)
                    ) {
                        Text(
                            text = title2,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(R.font.bold)),
                            color = textColor2,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Image(
                            painter = painterResource(id = R.drawable.bolt),
                            contentDescription = null,
                            modifier = Modifier
                                .size(18.dp)
                                .padding(start = 4.dp)
                        )
                    }
                } else {
                    Text(
                        text = title2,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.bold)),
                        color = textColor2,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }

                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(top = 8.dp)
                )
            }
        }
    }
}


@Composable
fun LeaderBoardCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .border(1.dp, Color(0xFFBCD6FF), RoundedCornerShape(24.dp))
    ) {
        Card(
            shape = RoundedCornerShape(22.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(90.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.linearGradient(
                            colorStops = arrayOf(
                                0.0f to Color(0xFFFEFEFE),
                                0.1f to Color(0xFFFEFEFE),
                                1.0f to Color(0xFFD1E3FF)
                            )
                        )
                    )
                    .padding(start = 100.dp, end = 10.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Column {
                    Text(
                        text = "LeaderBoard >",
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.bold)),
                        color = Color(0xFF3581F6)
                    )
                    Text(
                        text = "Top the leaderboard & Earn More!",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.bold)),
                        color = Color(0xFF82B1F9)
                    )
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.badge),
            contentDescription = null,
            modifier = Modifier
                .size(70.dp)
                .align(Alignment.TopStart)
                .offset(x = 20.dp)
        )
    }
}

@Composable
fun BottomNavBar() {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color(0xFFBCD6FF))
        )

        BottomNavigation(
            backgroundColor = Color.White,
            contentColor = Color.Black,
            modifier = Modifier.height(72.dp)
        ) {
            BottomNavigationItem(
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_leaderboard),
                        contentDescription = "Leaderboard",
                        modifier = Modifier.size(28.dp),
                        colorFilter = ColorFilter.tint(Color(0xFFBCD6FF))
                    )
                },
                selected = false,
                onClick = {  }
            )
            BottomNavigationItem(
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_home),
                            contentDescription = "Home",
                            modifier = Modifier.size(28.dp),
                            colorFilter = ColorFilter.tint(Color(0xFF3581F6))
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Box(
                            modifier = Modifier
                                .width(24.dp)
                                .height(4.dp)
                                .background(Color(0xFF3581F6), RoundedCornerShape(50))
                        )
                    }
                },
                selected = true,
                onClick = { }
            )

            BottomNavigationItem(
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "Profile",
                        modifier = Modifier.size(28.dp),
                        colorFilter = ColorFilter.tint(Color(0xFFBCD6FF))
                    )
                },
                selected = false,
                onClick = {  }
            )
        }
    }
}

fun startTimer(onTick: (Int) -> Unit) {
    CoroutineScope(Dispatchers.Main).launch {
        for (i in 59 * 60 downTo 0) {
            delay(1000L)
            onTick(i)
        }
    }
}
@Composable
fun BoostTimerBadge(remainingTime: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.height(46.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(30))
                .border(1.dp, Color(0xFF65B504), RoundedCornerShape(30))
                .background(Color(0xFFF7FEEE))
                .padding(horizontal = 5.dp, vertical = 2.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(30)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(38.dp)
                    .padding(start = 14.dp, end = 10.dp)
            ) {
                Spacer(modifier = Modifier.width(24.dp))


                Text(
                    text = "${remainingTime / 60}:${String.format("%02d", remainingTime % 60)}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(R.font.extrabold)),
                    color = Color(0xFF65B504)
                )
            }
        }


        Box(
            modifier = Modifier
                .offset(x = (-18).dp)
                .height(50.dp)
                .clip(RoundedCornerShape(30))
                .background(Color(0xFF65B504))
                .padding(horizontal = 14.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "2X",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily(Font(R.font.extrabold))
            )
        }
    }
}
