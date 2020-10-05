package com.hotel.array;

import java.util.*;
import java.util.stream.Collectors;

public class RestaurantFilter {
    public static void main(String[] args){
        List<Restaurant> restaurantList = new ArrayList<>();
        Restaurant r = new Restaurant();
        r.id = 1;
        r.rating=4;
        r.veganFriendly=true;
        r.maxPrice =40;
        r.maxDistance = 10;
        restaurantList.add(r);
        Restaurant r1 = new Restaurant();
        r.id = 3;
        r.rating=8;
        r.veganFriendly=true;
        r.maxPrice =30;
        r.maxDistance = 4;
        restaurantList.add(r1);
        Restaurant r2 = new Restaurant();
        r.id = 5;
        r.rating=1;
        r.veganFriendly=true;
        r.maxPrice =15;
        r.maxDistance = 1;
        restaurantList.add(r2);
        int[][] rs = {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
         System.out.println(new RestaurantFilter().filterRestaurants(rs, 1, 50, 10));
    }


    static class Restaurant {
        int id;
        int rating;
        boolean veganFriendly;
        int maxPrice;
        int maxDistance;
    }
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Restaurant> restaurantList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int[] r : restaurants){
            Restaurant restaurant = new Restaurant();
            restaurant.id = r[0];
            restaurant.rating = r[1];
            restaurant.veganFriendly = r[2] == 1;
            restaurant.maxPrice = r[3];
            restaurant.maxDistance = r[4];
            restaurantList.add(restaurant);
        }

        restaurantList = restaurantList
                .stream()
                .filter(r -> r.maxDistance <= maxDistance )
                .filter(r -> r.maxPrice <= maxPrice )
                .filter(r-> veganFriendly == 0  ||r.veganFriendly)
                .collect(Collectors.toList());

        restaurantList.sort((d1, d2) -> {
            if(d2.rating  == d1.rating) return d2.id - (d1.id);
            else return d2.rating - d1.rating;
        });
        for(Restaurant r : restaurantList) result.add(r.id);
        return result;
    }
}
