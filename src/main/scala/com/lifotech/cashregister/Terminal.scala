package com.lifotech.cashregister

/**
  * Case class for terminal
  * @param pricingInfo
  */
case class Terminal(pricingInfo: PricingInfo) {

  /**
    * Returns total price for the list of {@link Product}
    * @param product
    * @return total price
    */
  def getTotalPrice(product: List[String]): Double = {

    val shopingCart: ShopingCart = ShopingCart(pricingInfo)

    product.foreach(item => shopingCart.scan(item))

    shopingCart.getTotalPrice()

  }

  /**
    * Returns total price for the list of product names
    * @param products
    * @return total price
    */
  def getTotalPrice(products: String): Double = {

    val shopingCart: ShopingCart = ShopingCart(pricingInfo)
    val productArr = products.toCharArray()

    for (item <- productArr) {
      shopingCart.scan(String.valueOf(item))
    }

    shopingCart.getTotalPrice()
  }
}
