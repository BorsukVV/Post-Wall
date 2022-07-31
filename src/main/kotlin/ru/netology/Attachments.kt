package ru.netology

interface Attachments {
    val type: String
}

class PhotoAttachments(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String?,
    val date: Int,

    //Ширина оригинала фотографии в пикселах.
    val width: Int,

    //Высота оригинала фотографии в пикселах
    val height: Int,

    //URL копии фотографии с максимальным размером 75x75px
    val photo75: String?,

    //URL копии фотографии с максимальным размером 130x130px.
    val photo130: String?,

    //URL копии фотографии с максимальным размером 604x604px.
    val photo604: String?,

    //URL копии фотографии с максимальным размером 807x807px.
    val photo807: String?,

    //URL копии фотографии с максимальным размером 1280x1024px.
    val photo1280: String?,

    //URL копии фотографии с максимальным размером 2560x2048px.
    val photo2560: String?
) : Attachments {
    override val type: String = "photo"
}

class AudioAttachments(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val lyricsId: Int,
    val albumId: Int?,
    val genreId: Int,
    val date: Int,
    val noSearch: Boolean,
    val isHQ: Boolean
) : Attachments {
    override val type: String = "audio"
}

class EventAttachments(
    val id: Int,
    val time: Int,
    val memberStatus: Int,
    val isFavorite: Boolean,
    val address: String,
    val text: String,
    val buttonText: String,
    val friends: List<Int> = mutableListOf()
) : Attachments {
    override val type: String = "event"
}

class DocumentAttachments(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
    val docType: Int,
    val preview: Preview
) : Attachments {
    override val type: String = "doc"
}

class Preview(
    val photo: Photo?,
    val graffiti: Graffiti?,
    val audioMessage: AudioMessage?
)

class Photo(
    private val photo: PhotoAttachments
) {
    val sizes: List<String?> = listOf(
        photo.photo75,
        photo.photo130,
        photo.photo604,
        photo.photo807,
        photo.photo1280,
        photo.photo2560
    )
}

class Graffiti(
    val src: String,
    val width: Int,
    val height: Int
)

class AudioMessage(
    val duration: Int = 1001,
    val waveform: List<Int> = mutableListOf(32, 54, 47, 22, 41, 37),
    val linkOgg: String? = "OggURL",
    val linkMp3: String? = "Mp3URL"
)

class PhotoAlbumAttachments(
    val id: Int,
    val thumb: PhotoAttachments,
    val ownerId: Int,
    val title: String,
    val description: String,
    val created: Int,
    val updated: Int,
    val size: Int
) : Attachments {
    override val type: String = "album"
}


