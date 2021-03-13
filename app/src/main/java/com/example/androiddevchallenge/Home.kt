package com.example.androiddevchallenge

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun Home() {
    Scaffold(
        bottomBar = {
            BottomNavigation(backgroundColor = MaterialTheme.colors.background) {
                BottomNavigationItem(selected = true, onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Spa, contentDescription = "Home",
                            modifier = Modifier.size(18.dp)
                        )
                    }, label = {
                        Text("HOME", style = MaterialTheme.typography.caption)
                    })
                BottomNavigationItem(selected = false, onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Account",
                            modifier = Modifier.size(18.dp)
                        )
                    }, label = {
                        Text("PROFILE", style = MaterialTheme.typography.caption)
                    })
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(onClick = { }, backgroundColor = MaterialTheme.colors.primary) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = "Start",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
                .padding(it)
        ) {
            SearchBar()
            FavoriteCollections()
            AlignYourBody()
            AlignYourMind()
        }
    }
}

@Composable
fun SearchBar() {
    TextField(
        modifier = Modifier
            .padding(top = 56.dp)
            .requiredHeight(height = 56.dp)
            .fillMaxWidth(),
        value = "Search",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                modifier = Modifier.size(16.dp)
            )
        },
        textStyle = MaterialTheme.typography.body1,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface)
    )
}

@Composable
fun FavoriteCollections() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            "Favourite collections".toUpperCase(),
            style = MaterialTheme.typography.h2,
            modifier = Modifier.paddingFromBaseline(top = 40.dp)
        )

        HorizontalGrid {
            for (item in favoriteCollections) {
                CardRow(item)
            }
        }
    }
}

@Composable
fun CardRow(item: Item) {
    Box(modifier = Modifier.padding(end = 8.dp, bottom = 8.dp)) {
        Surface(
            shape = MaterialTheme.shapes.small,
        ) {
            Row(
                modifier = Modifier
                    .size(192.dp, 56.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CoilImage(
                    modifier = Modifier
                        .requiredSize(56.dp),
                    data = item.imageUrl,
                    contentScale = ContentScale.Crop,
                    contentDescription = item.title,
                    fadeIn = true,
                )

                Text(
                    item.title,
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.h3
                )
            }
        }
    }
}

@Composable
fun HorizontalGrid(rows: Int = 2, children: @Composable () -> Unit) {
    Layout(
        content = children, modifier = Modifier
            .padding(vertical = 8.dp)
            .horizontalScroll(
                rememberScrollState()
            )
    ) { measurables, constraints ->

        val rowWidths = IntArray(rows) { 0 }
        val rowMaxHeights = IntArray(rows) { 0 }

        val placeables = measurables.mapIndexed { index, measurable ->
            val placeable = measurable.measure(constraints)
            val row = index % rows
            rowWidths[row] = rowWidths[row] + placeable.width
            rowMaxHeights[row] = kotlin.math.max(rowMaxHeights[row], placeable.height)
            placeable
        }

        val width = rowWidths.maxOrNull()
            ?.coerceIn(constraints.minWidth.rangeTo(constraints.maxWidth)) ?: constraints.minWidth
        val height = rowMaxHeights.sumBy { it }
            .coerceIn(constraints.minHeight.rangeTo(constraints.maxHeight))

        val rowY = IntArray(rows) { 0 }
        for (i in 1 until rows) {
            rowY[i] = rowY[i - 1] + rowMaxHeights[i - 1]
        }

        layout(width, height) {
            val rowX = IntArray(rows) { 0 }

            placeables.forEachIndexed { index, placeable ->
                val row = index % rows
                placeable.placeRelative(
                    x = rowX[row],
                    y = rowY[row]
                )
                rowX[row] += placeable.width
            }
        }
    }
}

@Composable
fun AlignYourBody() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            "Align your body".toUpperCase(),
            style = MaterialTheme.typography.h2,
            modifier = Modifier.paddingFromBaseline(top = 40.dp, bottom = 8.dp)
        )
        ItemsList(alignYourBodyItems)
    }
}

@Composable
fun AlignYourMind() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            "Align your mind".toUpperCase(),
            style = MaterialTheme.typography.h2,
            modifier = Modifier.paddingFromBaseline(top = 48.dp, bottom = 8.dp)
        )
        ItemsList(alignYourMindItems)
    }
}

@Composable
fun ItemsList(list: List<Item>) {
    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
        for (item in list) {
            ItemWidget(item)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun ItemWidget(item: Item) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CoilImage(
            modifier = Modifier
                .requiredSize(88.dp)
                .clip(RoundedCornerShape(50)),
            data = item.imageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = item.title,
            fadeIn = true,
        )

        Text(
            text = item.title,
            modifier = Modifier.paddingFromBaseline(top = 24.dp),
            style = MaterialTheme.typography.h3
        )
    }
}
