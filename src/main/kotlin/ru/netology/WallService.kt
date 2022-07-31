package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    private var postIDGenerator = 0

    fun add(post: Post): Post {
        postIDGenerator++
        posts += post.copy(id = post.id + postIDGenerator)
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
}