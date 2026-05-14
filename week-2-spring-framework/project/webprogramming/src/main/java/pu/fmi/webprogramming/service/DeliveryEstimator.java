package pu.fmi.webprogramming.service;

import org.springframework.stereotype.Component;
import pu.fmi.webprogramming.model.Customer;
import pu.fmi.webprogramming.model.Delivery;
import pu.fmi.webprogramming.model.Warehouse;

import java.time.LocalDateTime;

@Component
public class DeliveryEstimator {

    public LocalDateTime estimateArrivalTime(Delivery delivery) {

        // В Delivery е добавено ново поле LocalDateTime estimatedArrivalAt
        // Този метод се използва в createDelivery на DeliveryService

        LocalDateTime estimatedArrivalAt;
        if (delivery.getWarehouse().getCity().equals(delivery.getCustomer().getCity())) {
            estimatedArrivalAt=delivery.getCreatedAt().plusDays(1);
        } else {
            estimatedArrivalAt = delivery.getCreatedAt().plusDays(3);
        }

        if (delivery.getCourier()==null) {
            estimatedArrivalAt = estimatedArrivalAt.plusDays(2);
        }
        return estimatedArrivalAt;
    }
}
