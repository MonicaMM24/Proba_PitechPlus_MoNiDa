import java.util.*;

import domain.Client;
import domain.Delivery;
import domain.Driver;
import domain.Item;
import domain.Restaurant;
import domain.VehicleType;

public class FoodDelivery {

    List<Client> clients;
    List<Driver> drivers;
    List<Restaurant> restaurants;
    List<Delivery> deliveries;

    List<Item> items;

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double discountedValue() {
        //TODO(implementation)
        double discount = 0.0;
        double price = 0.0;
        for (Delivery delivery : deliveries) {
            if (delivery.getDuration() > 100) {
                delivery.computeTotalValue();
                price += delivery.getTotalValue() * 0.1;
            }
        }
        return price;
        //return 0.0;
    }

    public Map<VehicleType, Double> computeIncomesPerVehicleType() {
        //TODO(implementation)
        Map<VehicleType, Double> harta = new HashMap<>();
        if (deliveries == null) {
            return harta;
        }
        for (Delivery delivery : deliveries) {
            VehicleType tip = delivery.getDriver().getVehicleType();

            harta.putIfAbsent(tip, 0.0);
            delivery.computeTotalValue();

            harta.put(tip, delivery.getTotalValue() + harta.get(tip));

        }
        return harta;
    }

    public Collection<String> mostSuccessfulDrivers() {
        //TODO(implementation)
        LinkedList<String> soferi = new LinkedList<>();
        if (drivers == null)
            return soferi;

        Map<String, Double> soferi2 = new HashMap<>();

        for (Delivery delivery : deliveries) {
            VehicleType tip = delivery.getDriver().getVehicleType();
            String name = delivery.getDriver().getName();
            soferi2.putIfAbsent(name, 0.0);
            delivery.computeTotalValue();
            soferi2.put(name, delivery.getTotalValue() + soferi2.get(name));
        }

        List list = new LinkedList(soferi2.entrySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return (int) (((Map.Entry<String, Double>) (o1)).getValue() - ((Map.Entry<String, Double>) (o1)).getValue());
            }
        });
        List reTlist = new LinkedList<>();
        for (Map.Entry<String, Double> entry : list3) {
            reTlist.add(entry.getValue());
        }
        return reTlist;
    }

    public Map<String, Collection<String>> topNProductsPerRestaurants(final int n) {
        //TODO(implementation)
        return new HashMap<>();
    }

    public Map<String, Double> totalDeliveryValuePerRestaurants() {
        //TODO(implementation)
        return new HashMap<>();
    }
}
