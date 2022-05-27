
package com.example.project1.data.repositories;

import com.example.project1.data.TacoOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);
    List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(
            String deliveryZip, Date startDate, Date endDate);
    List<TacoOrder> findByDeliveryStateAndDeliveryCityEqualsIgnoreCase(
            String deliveryState, String deliveryCity);

    @Query(value = "SELECT o FROM TacoOrder o where o.deliveryCity='Seattle'")
    List<TacoOrder> readOrdersDeliveredInSeattle();

    @Query("SELECT t FROM TacoOrder t WHERE t.deliveryCity = ?1")
    TacoOrder findTacoOrderByDeliveryCity(String deliveryCity);
}