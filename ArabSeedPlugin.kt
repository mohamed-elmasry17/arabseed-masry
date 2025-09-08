package com.lagradost.arabseed

import com.lagradost.cloudstream3.*
import com.lagradost.cloudstream3.utils.*

class ArabSeedPlugin : Plugin() {
    override fun load(context: LoadContext) {
        registerMainAPI(ArabSeed())
    }
}

class ArabSeed : MainAPI() {
    override var mainUrl = "https://arabseed.show" // غيّره لو عندك دومين أحدث
    override var name = "ArabSeed"
    override val hasMainPage = true
    override var lang = "ar"
    override val supportedTypes = setOf(TvType.Movie, TvType.TvSeries)

    override suspend fun getMainPage(page: Int, request: MainPageRequest): HomePageResponse {
        // هنا هنرجع بيانات مبدئية (فارغة أو تجريبية)
        val home = newHomePageResponse(
            listOf(
                HomePageList("أفلام عربية", listOf()),
                HomePageList("مسلسلات", listOf())
            )
        )
        return home
    }

    override suspend fun search(query: String): List<SearchResponse> {
        // لسه مش عامل بحث حقيقي
        return listOf()
    }

    override suspend fun load(url: String): LoadResponse {
        // تحميل تفاصيل فيلم/حلقة - مبدئياً تجريبي
        return MovieLoadResponse(
            name = "فيلم تجريبي من عرب سيد",
            url = url,
            apiName = name,
            type = TvType.Movie,
            dataUrl = url,
            posterUrl = null,
            plot = "هذه نسخة مبدئية فقط لاختبار الإضافة"
        )
    }
}

