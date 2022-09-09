package com.efhem.moviegalore.local.storage

interface Storage {

    fun popularCurrentPage() : Int

    fun topRatedCurrentPage() : Int

    fun insertPopularCurrentPage(page: Int)

    fun insertTopRatedPage(page: Int)

    companion object {
        const val POPULAR_CURRENT_PAGE: String = "popular_current_page"
        const val TOP_RATED__CURRENT_PAGE: String = "top_rated__current_page"
    }

}