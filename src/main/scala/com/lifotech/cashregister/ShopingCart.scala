package com.lifotech.cashregister

import scala.collection.mutable

/**
  * Case class for shopping cart
  * @param pricingInfo
  */
case class ShopingCart(pricingInfo: PricingInfo) {

  private[this] val itemMap: mutable.Map[Product, Int] = mutable.Map.empty[Product, Int]


  /**
    * Gets the total price
    * @return total price
    */
  def getTotalPrice(): Double = {

    var totalPrice: Double = 0.0


    for (item <- itemMap) yield {
      val product: Product = item._1
      val itemCount: Int = item._2


      if (product.isVolumePrice) {
        val volumePrice: VolumePrice = product.volumePrice

        val volumePriceMultiple = itemCount / volumePrice.quantity;
        val unitPriceMultiple = itemCount % volumePrice.quantity;

        var totalPriceforAllItemsOfThisProdut = 0.0

        totalPriceforAllItemsOfThisProdut = volumePriceMultiple.floor * volumePrice.price
        totalPriceforAllItemsOfThisProdut += unitPriceMultiple * product.unitPrice

        totalPrice += totalPriceforAllItemsOfThisProdut


      } else {
        totalPrice += itemCount * product.unitPrice
      }
    }

    totalPrice


  }

  /**
    * The method is used to scan the item.
    * @param productName
    *
    */
  def scan(productName: String) = {

    val product = pricingInfo.getProduct(productName).get
    if (product == null) throw new Exception("Product price is not available in the system!");

    val itemVal: Option[Int] = itemMap.get(product)
    if (itemVal == None) itemMap.put(product, 1) else itemMap.update(product, itemVal.get + 1)

  }


}
