package model
/*
HBXProductList
├── curPage: Int
├── totalPages: Int
├── title: String
├── sorts: Array<String>
└── products: Array<HBXProductListProduct>
    ├── HBXProductListNormalProduct
    └── HBXProductListPreOrderProduct
 */

interface HBXProductListProduct {
    val id: Int
    val name: String

    val display: String
        get() = "(${this.id})\t${this.name}"
}

data class HBXProductList(
    val curPage: Int,
    val totalPages: Int,
    val title: String,
    val sorts: List<String>,
    val products: List<HBXProductListProduct>
)

data class HBXProductListNormalProduct(
    override val id: Int,
    override val name: String
) : HBXProductListProduct

data class HBXProductListPreOrderProduct(
    override val id: Int,
    override val name: String,
    val price: String
) : HBXProductListProduct