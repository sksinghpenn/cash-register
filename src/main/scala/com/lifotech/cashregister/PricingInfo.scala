package com.lifotech.cashregister

/**
  * The case class which encapsulated PricingInfo.
  *
  * @param productList
  */
case class PricingInfo(val productList: Set[Product]) {

  val productMap: Map[String, Product] = buildProductMap


  /**
    * The method builds  map of  productName and {@link Product} and returns it.
    * @return Map[String, Product]
    */
  def buildProductMap(): Map[String, Product] = {
    productList.map(item => (item.name, item)).toMap
  }

  /**
    * The method is lookup method to get the {@link Product}
    * @param productName
    * @return Option[Product]
    */
  def getProduct(productName: String): Option[Product] = {
    productMap.get(productName)
  }
}


