package com.unq.viendasya.model

import java.util.*

class Menu (
    var name: String,
    var description: String,
    var deliveryValue: Double,
    var validity: Date,
    var expiration: Date,
    //Turnos/Horarios de entrega/Envio
    var turn: String,
    var deliveryTime: String,
    var price :Double,
    var cantMin : Int,
    var priceCantMin: Double,
    var cantMax : Int,
    var priceCantMax: Double,
    var cantMaxPeerDay: Int) {

    val category: MutableList<ServiceCategory> = mutableListOf()

    data class Builder(
            var name: String = "",
            var description: String = "",
            var deliveryValue: Double = 0.0,
            var validity: Date = Date(),
            var expiration: Date = Date(),
            //Turnos/Horarios de entrega/Envio
            var turn: String = "",
            var deliveryTime: String = "",
            var price :Double = 0.0,
            var cantMin : Int = 0,
            var priceCantMin: Double = 0.0,
            var cantMax : Int = 0,
            var priceCantMax: Double = 0.0,
            var cantMaxPeerDay: Int = 0
    ){

        val category: MutableList<ServiceCategory> = mutableListOf()

        fun name(name: String) = apply { this.name = name }
        fun description(description: String) = apply { this.description= description}
        fun category(category: ServiceCategory) = apply { this.category.add(category)}
        fun deliveryValue(deliveryValue: Double) = apply { this.deliveryValue= deliveryValue}
        fun validity(validity: Date) = apply { this.validity= validity}
        fun expiration(expiration: Date) = apply { this.expiration= expiration}
        fun turn(turn: String) = apply { this.turn= turn}
        fun deliveryTime(deliveryTime: String) = apply { this.deliveryTime= deliveryTime}
        fun price(price: Double) = apply { this.price= price}
        fun cantMin(cantMin: Int) = apply { this.cantMin= cantMin}
        fun priceCantMin(priceCantMin: Double) = apply { this.priceCantMin= priceCantMin}
        fun cantMax(cantMax: Int) = apply { this.cantMax= cantMax}
        fun priceCantMax(priceCantMax: Double) = apply { this.priceCantMax= priceCantMax}
        fun cantMaxPeerDay(cantMaxPeerDay: Int) = apply { this.cantMaxPeerDay= cantMaxPeerDay}


        fun build() = Menu(name, description, deliveryValue, validity, expiration, turn,
                deliveryTime, price, cantMin, priceCantMin, cantMax, priceCantMax, cantMaxPeerDay)

    }

}
