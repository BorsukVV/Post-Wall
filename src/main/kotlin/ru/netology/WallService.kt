package ru.netology

import ru.netology.Comments
import kotlin.jvm.Throws

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comments>()
    private var postIDGenerator = 0
    private var commentsIDGenerator = 101

    fun add(post: Post): Post {
        postIDGenerator++
        posts += post.copy(id = postIDGenerator)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        var updated = false
        for (i in 0..posts.lastIndex) {
            if (posts[i].id == post.id) {
                posts[i] = post.copy(
                    fromId = post.fromId,
                    createdBy = post.createdBy,
                    text = post.text,
                    replyOwnerId = post.replyOwnerId,
                    replyPostId = post.replyPostId,
                    friendsOnly = post.friendsOnly,
                    comments = post.comments,
                    likes = post.likes,
                    copyright = post.copyright,
                    reposts = post.reposts,
                    views = post.views,
                    postType = post.postType,
                    canPin = post.canPin,
                    canDelete = post.canDelete,
                    canEdit = post.canEdit,
                    isPinned = post.isPinned,
                    markedAsAds = post.markedAsAds,
                    isFavorite = post.isFavorite,
                    donut = post.donut
                )
                updated = true
                break
            }
        }
        return updated
    }

    fun print() {
        for (post in posts) {
            println("Post ID: ${post.id}, post ownerID: ${post.ownerId}, post unix time: ${post.date}, text: ${post.text}")
        }
    }

    fun clear() {
        posts = emptyArray()
    }


    @Throws(PostNotFoundException::class)
    fun findById (id: Int): Post {
        for (post in posts) {
            if (post.id == id) return post
        }
        throw PostNotFoundException("no post with ID $id")
    }

    fun createComment(postId: Int, comment: Comments): Comments? {
        val parentPost = findById(postId)
        val linkedComment = comment.copy(parentPostID = postId)
        val commentedPost = parentPost.copy(comments = linkedComment)
        if (update(commentedPost)) {comments += linkedComment}
        println("К посту с ID $postId добавлен комментарий: \n $comment.text")
        return comment
    }

}