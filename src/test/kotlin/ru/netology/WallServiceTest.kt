package ru.netology

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import ru.netology.WallService.add
import ru.netology.WallService.createComment
import ru.netology.WallService.findById
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
            comments = null,
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
            attachments = null
        )
        val result = add(post)
        //println(result.id)
        val expected = Post(
            id = 3,
            ownerId = 1000000100,
            fromId = 1000000200,
            createdBy = 1000000300,
            date = 1000000400,
            text = "Новый пост",
            replyOwnerId = 1000000500,
            replyPostId = 1000000600,
            friendsOnly = false,
            comments = null,
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
            attachments = null
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
            comments = null,
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
            attachments = null
        )
        add(post)
        val newPost = Post(
            id = 1,
            ownerId = 1000000100,
            fromId = 1000000200,
            createdBy = 1000000300,
            date = 1000000400,
            text = "Новый пост (апдейт)",
            replyOwnerId = 1000000500,
            replyPostId = 1000000600,
            friendsOnly = false,
            comments = null,
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
            attachments = null
        )
        val result = update(newPost)
        assertEquals(true, result)
    }

    @Test
    fun update_ShouldNotUpdatePost() {
        val post = Post(
            id = 343,
            ownerId = 1000000100,
            fromId = 1000000200,
            createdBy = 1000000300,
            date = 1000000400,
            text = "Новый пост",
            replyOwnerId = 1000000500,
            replyPostId = 1000000600,
            friendsOnly = false,
            comments = null,
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
            attachments = null
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
            comments = null,
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
            attachments = null
        )
        val result = update(newPost)
        assertEquals(false, result)
    }

    @Test(expected = PostNotFoundException::class)
    fun createComment_shouldThrowException() {
        val comment = Comments(
            300001,
            1000000001,
            400004568,
            "коммент под постом",
            null,
            null,
            null,
            null,
            0
        )
        createComment(32, comment)
    }

    @Test
    fun createComment_shouldCreateComment() {
        val comment = Comments(
            300001,
            1000000001,
            400004568,
            "коммент под постом",
            null,
            null,
            null,
            null,
            0
        )
        val postID = 1
        createComment(postID, comment)
        val result = findById(postID)
        assertEquals(300001, result.comments?.id)
    }

}