package ru.netology

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.netology.WallService.add
import ru.netology.WallService.update

class WallServiceTest {

    @Test
    fun add_ShouldAddPostToPostsArray() {
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
        val result = add(post)
        val expected = Post(
            id = 1000000001,
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

        assertEquals(expected, result)

    }

    @Test
    fun update_ShouldUpdatePost() {
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
        add(post)
        val newPost = Post(
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
        val result = update(newPost)
        assertEquals(true, result)
    }

    @Test
    fun update_ShouldNotUpdatePost() {
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
        add(post)
        val newPost = Post(
            id = 1000000002,
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
        val result = update(newPost)
        assertEquals(false, result)
    }

}