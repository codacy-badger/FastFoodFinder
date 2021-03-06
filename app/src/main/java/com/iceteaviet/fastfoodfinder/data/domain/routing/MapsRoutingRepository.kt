package com.iceteaviet.fastfoodfinder.data.domain.routing

import com.iceteaviet.fastfoodfinder.data.remote.routing.model.MapsDirection
import com.iceteaviet.fastfoodfinder.data.remote.store.model.Store

import io.reactivex.Single

/**
 * Created by tom on 7/18/18.
 *
 * Main entry point for accessing routing data.
 */
interface MapsRoutingRepository {
    fun getMapsDirection(queries: Map<String, String>, store: Store): Single<MapsDirection>
}
