package com.cp.design;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

class Cashier {

    public static void main(String[] args){
        String date1="", date2="";
        String[] d1= date1.split("-"); String[] d2= date2.split("-");
        LocalDate from = LocalDate.of(Integer.parseInt(d1[0]), Integer.parseInt(d1[1]), Integer.parseInt(d1[2]));
        LocalDate to = LocalDate.of(Integer.parseInt(d2[0]), Integer.parseInt(d2[1]), Integer.parseInt(d2[2]));
        ChronoUnit.DAYS.between(from, to);
        int[] pro = {1,2,3,4,5,6,7};
        int pri[] = {100,200,300,400,300,200,100};
        Cashier cashier = new Cashier(3,50, pro,pri);
        int[] one = {1,2};
        int[] onep = {1,2};
        cashier.getBill(one,onep);// return 500.0, bill = 1 * 100 + 2 * 200 = 500.
        int[] one2 = {3,7};
        int[] onep2 = {10,10};
        cashier.getBill(one2,onep2);                      // return 4000.0
        int[] one3 = {1,2,3,4,5,6,7};
        int[] onep3 = {1,1,1,1,1,1,1};
        cashier.getBill(one3,onep3);    // return 800.0, The bill was 1600.0 but as this is the third customer, he has a discount of 50% which means his bill is only 1600 - 1600 * (50 / 100) = 800.
        //cashier.getBill({4},{10});                           // return 4000.0
        //cashier.getBill({7,3},{10,10});                      // return 4000.0
        //cashier.getBill({7,5,3,1,6,4,2},{10,10,10,9,9,9,7}); // return 7350.0, Bill was 14700.0 but as the system counted three more customers, he will have a 50% discount and the bill becomes 7350.0
        //cashier.getBill({2,3,5},{5,3,2});

    }

    int n;
    int discount;
    Map<Integer, Integer> priceMap = new HashMap<>();
    int counter;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        for(int i =0; i< products.length; i++)
            this.priceMap.put(products[i], prices[i]);
    }

    public double getBill(int[] product, int[] amount) {
        ++counter; double total =0, discount = 0;
        for(int i = 0; i< product.length; i++){
            total += (priceMap.get(product[i]) * amount[i]);
        }
        if(counter == n)
            discount = total *(this.discount/100d);

        return total - discount;
    }
}
