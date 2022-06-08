package ru.netology

fun main() {
    val post = Post(
        id = 1000000000,
        ownerId = 1000000100,
        fromId = 1000000200,
        createdBy = 1000000300,
        date = 1000000400,
        text = "Новый пост",
        replyOwnerId = 1000000500,
        replyPostId = 1000000600,
        friendsOnly = false,
        comments = Comments(),
        likes = Likes(),
        copyright = Copyright(),
        reposts = Reposts(),
        views = Views(),
        postType = "post",
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = false,
        markedAsAds = false,
        isFavorite = true,
        donut = Donut()
    )

    val post1 = Post(
        id = 1000000000,
        ownerId = 1000000110,
        fromId = 1000000210,
        createdBy = 1000000310,
        date = 1000000410,
        text = "Ещё один пост",
        replyOwnerId = 1000000510,
        replyPostId = 1000000610,
        friendsOnly = false,
        comments = Comments(),
        likes = Likes(),
        copyright = Copyright(),
        reposts = Reposts(),
        views = Views(),
        postType = "post",
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = false,
        markedAsAds = false,
        isFavorite = true,
        donut = Donut()
    )

    val post2 = Post(
        id = 1000000000,
        ownerId = 1000000120,
        fromId = 1000000220,
        createdBy = 1000000320,
        date = 1000000420,
        text = "Третий пост",
        replyOwnerId = 1000000520,
        replyPostId = 1000000620,
        friendsOnly = false,
        comments = Comments(),
        likes = Likes(),
        copyright = Copyright(),
        reposts = Reposts(),
        views = Views(),
        postType = "post",
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = false,
        markedAsAds = false,
        isFavorite = true,
        donut = Donut()
    )

    val post3 = Post(
        id = 1000000001,
        ownerId = 1000000100,
        fromId = 1000000200,
        createdBy = 1000000300,
        date = 1000000400,
        text = "Новый пост (апдейт)",
        replyOwnerId = 1000000500,
        replyPostId = 1000000600,
        friendsOnly = false,
        comments = Comments(),
        likes = Likes(),
        copyright = Copyright(),
        reposts = Reposts(),
        views = Views(),
        postType = "post",
        canPin = true,
        canDelete = true,
        canEdit = true,
        isPinned = false,
        markedAsAds = false,
        isFavorite = true,
        donut = Donut()
    )

    WallService.add(post)
    WallService.add(post1)
    WallService.add(post2)

    WallService.print()

    if (WallService.update(post3)) {
        println("Обновляем пост с ID ${post3.id}")
    } else {
        println("Поста с таким ID не существует")
    }

    WallService.print()

}