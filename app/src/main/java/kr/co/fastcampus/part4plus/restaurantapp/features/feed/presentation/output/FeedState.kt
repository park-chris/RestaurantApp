package kr.co.fastcampus.part4plus.restaurantapp.features.feed.presentation.output

import kr.co.fastcampus.part4plus.restaurantapp.features.common.entity.CategoryEntity


sealed class FeedState {
    object Loading: FeedState()
    class Main(
        val categories: List<CategoryEntity>
    ): FeedState()
    class Failed(
        val reason: String
    ): FeedState()
}
