package com.etiya.rentACarSpring.entities.message.fakeServices;

public class PosService {

    public boolean checkCreditCardBalance(String cardNumber,String cvv,Integer totalPrice) {
        int creditCardBalance=7500;
        if (totalPrice<creditCardBalance){
            return true;
        }
        return  false;
    }
}
