package com.decathlon.app.data

import com.decathlon.app.data.remote.RemoteDataSource
import com.decathlon.app.model.BaseApiResponse
import com.decathlon.app.model.ProductListResponse
import com.decathlon.app.utils.NetworkResult
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


@ActivityRetainedScoped
class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse() {

    suspend fun getProductList(): Flow<NetworkResult<ProductListResponse>> {
        return flow<NetworkResult<ProductListResponse>> {
            emit(safeApiCall { remoteDataSource.getProductList() })
        }.flowOn(Dispatchers.IO)
    }

}
