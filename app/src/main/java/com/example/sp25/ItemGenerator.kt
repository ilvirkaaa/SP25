package com.example.sp25

fun generateOrderedModels(count: Int): List<ItemModel> {
    val sampleImages = listOf(
        "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a9/Example.jpg/320px-Example.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/HST-SM4.jpeg/320px-HST-SM4.jpeg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Golde33443.jpg/320px-Golde33443.jpg",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/320px-Image_created_with_a_mobile_phone.png"
    )

    val sampleTitles = listOf("Заголовок 1", "Заголовок 2", "Заголовок 3", "Заголовок 4", "Заголовок 5  ", "Заголовок 6")
    val sampleDescriptions = listOf("Описание 1", "Описание 2", "Описание 3", "Описание 4", "Описание 5", "Описание 6")

    return List(count) { index ->
        val i = index % sampleTitles.size // на случай если count > 6
        ItemModel(
            imageUrl = sampleImages.getOrElse(i) { sampleImages.random() },
            title = sampleTitles[i],
            description = sampleDescriptions[i]
        )
    }
}
