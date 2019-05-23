package com.lifotech.cashregister

import org.scalatest.{FunSuite, Matchers}

/**
  * Test class for the {@link ShopingCart} class
  */

class ShopingCartTest extends FunSuite with Matchers {

  val productA: Product = Product("A", 2.00, new VolumePrice(4, 7.00))
  val productB: Product = Product("B", 12.00, null)
  val productC: Product = Product("C", 1.25, new VolumePrice(6, 6.00))
  val productD: Product = Product("D", 0.15, null)

  val formatter = java.text.NumberFormat.getCurrencyInstance

  val products: Set[Product] = Set(productA, productB, productC, productD)

  val pricingInfo = PricingInfo(products)
  val terminal = Terminal(pricingInfo)


  test("ABCDABAA; Verify the total price is $32.40") {

    val productList = List("A", "B", "C", "D", "A", "B", "A", "A")
    val totalPrice = terminal.getTotalPrice(productList)
    val totalPriceFormatted = formatter.format(totalPrice)

    totalPriceFormatted should be("$32.40")

  }

  test("CCCCCCC; Verify the total price is $7.25.") {

    val productList = List("C", "C", "C", "C", "C", "C", "C")
    val totalPrice = terminal.getTotalPrice(productList)
    val totalPriceFormatted = formatter.format(totalPrice)

    totalPriceFormatted should be("$7.25")


  }
  test("ABCD; Verify the total price is $15.40.") {

    val productList = List("A", "B", "C", "D")
    val totalPrice = terminal.getTotalPrice(productList)
    val totalPriceFormatted = formatter.format(totalPrice)

    totalPriceFormatted should be("$15.40")


  }


}