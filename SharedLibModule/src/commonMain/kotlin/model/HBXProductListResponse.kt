package model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HBXProductListResponse(
    @SerialName("pagination")
    val pagination: HBXProductListPaginationResponse,
    @SerialName("meta")
    val meta: HBXProductListMetaResponse
) {
    val asModel: HBXProductList
        get() = HBXProductList(
            curPage = this.pagination.page,
            totalPages = this.pagination.total,
            title = this.meta.title,
            sorts = this.pagination.links.sorting.map { it.name },
            products = this.pagination.items.map {
                val id = it.id
                val name = it.name
                if (it.isPreOrder) {
                    HBXProductListPreOrderProduct(id = id, name = name, price = it.price.display)
                } else {
                    HBXProductListNormalProduct(id = id, name = name)
                }
            }
        )
}

@Serializable
data class HBXProductListPaginationResponse(
    @SerialName("page")
    val page: Int,
    @SerialName("pages")
    val pages: Int,
    @SerialName("limit")
    val limit: Int,
    @SerialName("total")
    val total: Int,
    @SerialName("_links")
    val links: HBXProductListLinkResponse,
    @SerialName("items")
    val items: List<HBXProductListItemResponse>
)

@Serializable
data class HBXProductListLinkResponse(
    @SerialName("sorting")
    val sorting: List<HBXProductListSortResponse>
)

@Serializable
data class HBXProductListSortResponse(
    @SerialName("name")
    val name: String
)

@Serializable
data class HBXProductListItemResponse(
    @SerialName("id")
    val id: Int,
    @SerialName("code")
    val code: String,
    @SerialName("name")
    val name: String,
    @SerialName("isPreOrder")
    val isPreOrder: Boolean,
    @SerialName("price")
    val price: HBXProductListPriceResponse
)

@Serializable
data class HBXProductListPriceResponse(
    @SerialName("amount")
    val amount: Int,
    @SerialName("currency")
    val currency: String,
    @SerialName("display")
    val display: String,
    @SerialName("fractionDisplay")
    val fractionDisplay: String
)

@Serializable
data class HBXProductListMetaResponse(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String?,
    @SerialName("icon")
    val icon: String?,
    @SerialName("disclaimer")
    val disclaimer: String?,
    @SerialName("banners")
    val banners: List<String>,
    @SerialName("ctas")
    val ctas: List<String>,
    @SerialName("accessRequirement")
    val accessRequirement: String?,
    @SerialName("type")
    val type: String
)