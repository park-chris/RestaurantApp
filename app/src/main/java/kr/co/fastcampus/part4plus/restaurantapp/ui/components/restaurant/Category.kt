package kr.co.fastcampus.part4plus.restaurantapp.ui.components.restaurant

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.co.fastcampus.part4plus.restaurantapp.features.common.entity.CategoryEntity
import kr.co.fastcampus.part4plus.restaurantapp.features.feed.presentation.input.IFeedViewModelInput
import kr.co.fastcampus.part4plus.restaurantapp.ui.theme.Paddings

@Composable
fun CategoryRow(
    categoryEntity: CategoryEntity,
    input: IFeedViewModelInput
) {
    Column {
        CategoryTitle(categoryEntity.neighborhood)

        LazyRow(
            contentPadding = PaddingValues(
                horizontal = Paddings.large
            )
        ) {
            itemsIndexed(categoryEntity.feedEntities) {
                _, item ->
                FeedItem(
                    feedItem = item,
                    input = input
                )
            }
        }
    }
}

@Composable
fun CategoryTitle(genre: String) {
    Text(
        text = genre,
        modifier = Modifier
            .padding(
                vertical = Paddings.large,
                horizontal = Paddings.extra
            ),
        style = MaterialTheme.typography.h5
    )
}
