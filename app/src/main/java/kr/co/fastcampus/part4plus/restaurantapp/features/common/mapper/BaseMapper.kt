package kr.co.fastcampus.part4plus.restaurantapp.features.common.mapper

import kr.co.fastcampus.part4plus.restaurantapp.features.common.entity.EntityWrapper
import kr.co.fastcampus.part4plus.restaurantapp.library.network.model.ApiResponse
import kr.co.fastcampus.part4plus.restaurantapp.library.network.model.ApiResult

abstract class BaseMapper<M, E> {

    fun mapFromResult(result: ApiResult<M>, extra: Any? = null): EntityWrapper<E> =
        when (result.response) {
            is ApiResponse.Success -> getSuccess(model = result.response.data, extra = extra)
            is ApiResponse.Fail -> getFailure(error = result.response.error)
        }

    abstract fun getSuccess(model: M?, extra: Any?): EntityWrapper.Success<E>

    abstract fun getFailure(error: Throwable): EntityWrapper.Fail<E>
}
