package com.mycompany.crystalpalacehotel;
public class Rate {
 private int FoodRate ;
 private int HousekeepingRate;
 private int ServiceRate;
 

    public Rate(int FoodRate, int HousekeepingRate,int ServiceRate) {
        if(FoodRate<=5&&FoodRate>=0&&HousekeepingRate<=5&&HousekeepingRate>=0&&ServiceRate<=5&&ServiceRate>=0){
        this.FoodRate = FoodRate;
        this.HousekeepingRate = HousekeepingRate;
        this.ServiceRate = ServiceRate;
    }else{System.out.println("Error invalid value");}}

    public int getFoodRate() {
        return FoodRate;
    }

    public void setFoodRate(int FoodRate) {
        this.FoodRate = FoodRate;
    }

    public int getHousekeepingRate() {
        return HousekeepingRate;
    }

    public void setHousekeepingRate(int HousekeepingRate) {
        this.HousekeepingRate = HousekeepingRate;
    }

    public int getServiceRate() {
        return ServiceRate;
    }

    public void setServiceRate(int ServiceRate) {
        this.ServiceRate = ServiceRate;
    }
 public double getRate(){
     return (FoodRate+ServiceRate+HousekeepingRate)/3.0;
 }
    
}

