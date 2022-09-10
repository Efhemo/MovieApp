package com.efhem.moviegalore.core.local.storage

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StorageImp @Inject constructor(
    @ApplicationContext context: Context
) : Storage {

    private var sharePreferences: SharedPreferences =
        context.getSharedPreferences("movie_galore_storage", Context.MODE_PRIVATE)

    override fun popularCurrentPage() = sharePreferences.getInt(Storage.POPULAR_CURRENT_PAGE, 0)

    override fun topRatedCurrentPage() = sharePreferences.getInt(Storage.TOP_RATED__CURRENT_PAGE, 0)

    override fun insertPopularCurrentPage(page: Int) {
        sharePreferences.edit().putInt(Storage.POPULAR_CURRENT_PAGE, page).apply()
    }

    override fun insertTopRatedPage(page: Int) {
        sharePreferences.edit().putInt(Storage.TOP_RATED__CURRENT_PAGE, page).apply()
    }

}