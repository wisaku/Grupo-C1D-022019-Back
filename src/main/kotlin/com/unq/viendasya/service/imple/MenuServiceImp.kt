package com.unq.viendasya.service.imple

import com.unq.viendasya.controller.apiModels.MiniMenu
import com.unq.viendasya.exception.CurrencyMenuException
import com.unq.viendasya.model.Menu
import com.unq.viendasya.repository.MenuRepository
import com.unq.viendasya.repository.UserRepository
import com.unq.viendasya.service.MenuService
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.joda.time.LocalDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*
import javax.transaction.Transactional

@Service
class MenuServiceImp(@Autowired private val  dao: MenuRepository, @Autowired private val service: UserRepository) : MenuService {

    private val logger: Logger = LogManager.getLogger("log-Process")


    override fun createMenu(data: MiniMenu): Menu? {
        val provider = service.findById(data.idProvider)
        val menu = Menu.Builder().name(data.name)
                .cantMin(data.cantMin)
                .cantMax(data.cantMax)
                .cantMaxPeerDay(data.cantMaxPerDay)
                .description(data.description)
                .urlImage(data.urlImage)
                .category(data.category)
                //.deliveryTime(data.DeliveryTime)
                .deliveryValue(data.priceDelivery.toDouble())
                //.expiration(LocalDate(data.dateEnd))
                .price(data.price.toDouble())
                .priceCantMin(data.priceMin.toDouble())
                .priceCantMax(data.priceMax.toDouble())
                .provider(provider.get()).build()
        logger.info("menu created")

        return dao.save(menu)
    }

    override fun findAll(pageable: Pageable): Page<Menu> {
        return dao.findAll(pageable)
    }
    override fun findByQuery(query: String): List<Menu> {
        return dao.findByQuery("%${query.toUpperCase()}%")
    }

    override fun findById(idMenu: Int): Menu? {
        return dao.findByIdOrNull(idMenu)
    }

    override fun findByProviderId(providerId: Int): List<Menu> {
        return dao.findByProviderId(providerId)
    }
}