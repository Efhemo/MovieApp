package com.efhem.moviegalore.core.data.testdoubles

import com.efhem.moviegalore.core.local.storage.Storage

class TestStorage: Storage {

    private val preference: HashMap<String, Int> = HashMap()

    override fun popularCurrentPage(): Int = preference.getOrDefault(Storage.POPULAR_CURRENT_PAGE, 1)

    override fun topRatedCurrentPage(): Int = preference.getOrDefault(Storage.TOP_RATED__CURRENT_PAGE, 1)

    override fun insertPopularCurrentPage(page: Int) {
        preference[Storage.POPULAR_CURRENT_PAGE] = page
    }

    override fun insertTopRatedPage(page: Int) {
        preference[Storage.TOP_RATED__CURRENT_PAGE] = page
    }
}