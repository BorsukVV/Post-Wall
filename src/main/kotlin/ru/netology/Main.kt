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
        donut = Donut(),
        attachments = PhotoAttachments(
            id = 10001,
            albumId = 10002,
            ownerId = 10003,
            userId = 10004,
            null,
            date = 1000100111,
            width = 2056,
            height = 1654,
            null,
            null,
            null,
            "URL 807x807px",
            null,
            null
        )
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
        donut = Donut(),
        attachments = AudioAttachments(
            id = 10011,
            ownerId = 10013,
            artist = "Metallica",
            title = "Master of Puppets",
            duration = 515,
            url = "https://music.yandex.ru/album/4808586/track/37847969",
            lyricsId = 37847969,
            albumId = 4808586,
            genreId = 100,
            date = 1000100112,
            noSearch = false,
            isHQ = true
        )
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
        donut = Donut(),
        attachments = EventAttachments(
            id = 10021,
            time = 1000100112,
            memberStatus = 2,
            isFavorite = false,
            address = "Невский проспект, 128",
            text = "Сегодня будет туса",
            buttonText = "Туса",
            friends = mutableListOf(90001, 90002, 90003, 90004, 90005)
        )
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
        donut = Donut(),
        attachments = DocumentAttachments(
            id = 10031,
            ownerId = 10033,
            title = "Прикрепленный документ",
            size = 1024,
            ext = "doc",
            url = "https://vk.com/doc21893325_598388878",
            date = 1000000426,
            docType = 5,
            preview = Preview(null, null, audioMessage = AudioMessage(
                duration = 1001,
                waveform = mutableListOf(32, 54, 47, 22, 41, 37),
                linkOgg = "OggURL",
        null
                )
            )
        )
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