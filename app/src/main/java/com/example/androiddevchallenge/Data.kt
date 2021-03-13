/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

data class Item(val title: String, val imageUrl: String)

val favoriteCollections = listOf(
    Item(title = "Short mantras", imageUrl = ""), // TODO: missing
    Item(
        title = "Nature meditations",
        imageUrl = "https://images.pexels.com/photos/3571551/pexels-photo-3571551.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    ),
    Item(
        title = "Stress and anxiety",
        imageUrl = "https://images.pexels.com/photos/1557238/pexels-photo-1557238.jpeg?cs=srgb&dl=pexels-jim-1557238.jpg&fm=jpg"
    ),
    Item(
        title = "Self-massage",
        imageUrl = "https://images.pexels.com/photos/1029604/pexels-photo-1029604.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Item(
        title = "Overwhelmed",
        imageUrl = "https://images.pexels.com/photos/3560044/pexels-photo-3560044.jpeg?cs=srgb&dl=pexels-ruvim-3560044.jpg&fm=jpg"
    ),
    Item(
        title = "Nightly wind down",
        imageUrl = "https://images.pexels.com/photos/924824/pexels-photo-924824.jpeg?cs=srgb&dl=pexels-jakub-novacek-924824.jpg&fm=jpg"
    ),
)

val alignYourBodyItems = listOf(
    Item(title = "Inversions", imageUrl = "https://images.pexels.com/photos/317157/pexels-photo-317157.jpeg?cs=srgb&dl=pexels-chevanon-photography-317157.jpg&fm=jpg"),
    Item(
        title = "Quick yoga",
        imageUrl = "https://images.pexels.com/photos/3571551/pexels-photo-3571551.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
    ),
    Item(
        title = "Stretching",
        imageUrl = "https://images.pexels.com/photos/1557238/pexels-photo-1557238.jpeg?cs=srgb&dl=pexels-jim-1557238.jpg&fm=jpg"
    ),
    Item(
        title = "Tabata",
        imageUrl = "https://images.pexels.com/photos/1029604/pexels-photo-1029604.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260"
    ),
    Item(
        title = "HIIT",
        imageUrl = "https://images.pexels.com/photos/3560044/pexels-photo-3560044.jpeg?cs=srgb&dl=pexels-ruvim-3560044.jpg&fm=jpg"
    ),
    Item(
        title = "Pre-natal yoga",
        imageUrl = "https://images.pexels.com/photos/924824/pexels-photo-924824.jpeg?cs=srgb&dl=pexels-jakub-novacek-924824.jpg&fm=jpg"
    ),
)

val alignYourMindItems = listOf(
    Item(
        title = "Meditate",
        imageUrl = "https://images.pexels.com/photos/3822622/pexels-photo-3822622.jpeg?cs=srgb&dl=pexels-elly-fairytale-3822622.jpg&fm=jpg"
    ),
    Item(
        title = "With kids",
        imageUrl = "https://images.pexels.com/photos/3094230/pexels-photo-3094230.jpeg?cs=srgb&dl=pexels-valeria-ushakova-3094230.jpg&fm=jpg"
    ),
    Item(
        title = "Aromatherapy",
        imageUrl = "https://images.pexels.com/photos/4498318/pexels-photo-4498318.jpeg?cs=srgb&dl=pexels-karolina-grabowska-4498318.jpg&fm=jpg"
    ),
    Item(
        title = "On the go",
        imageUrl = "https://images.pexels.com/photos/1241348/pexels-photo-1241348.jpeg?cs=srgb&dl=pexels-suraphat-nueaon-1241348.jpg&fm=jpg"
    ),
    Item(
        title = "With pets",
        imageUrl = "https://images.pexels.com/photos/4056535/pexels-photo-4056535.jpeg?cs=srgb&dl=pexels-cottonbro-4056535.jpg&fm=jpg"
    ),
    Item(
        title = "High stress",
        imageUrl = "https://images.pexels.com/photos/897817/pexels-photo-897817.jpeg?cs=srgb&dl=pexels-nathan-cowley-897817.jpg&fm=jpg"
    ),
)
