package com.lifotech.cashregister

/**
  * Case class which encapsulates product's attributes.
  * @param name
  * @param unitPrice
  * @param volumePrice
  */
case class Product(name: String, unitPrice: Double, volumePrice: VolumePrice) {
  def isVolumePrice: Boolean = volumePrice != null
}

/**
  * Case class encapsulates product which has volume pricing.
  * @param quantity
  * @param price
  */
case class VolumePrice(quantity: Double, price: Double)



/* Trait for the price type */
sealed trait PriceType

/* Case object for unit price type */
case object UnitPriceType extends PriceType

/* Case object for volume price type */
case object VolumePrice extends PriceType

