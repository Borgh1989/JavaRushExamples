package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");

    }

    public static void main(String[] args) {


    }

    public static class IncomeDataAdapter implements Customer, Contact {

        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data=data;
        }

        @Override
        public String getCompanyName(){
            return data.getCompany();
        }        //example JavaRush Ltd.
        @Override
        public String getCountryName(){
           String country="";
           for(Map.Entry<String, String> pair : countries.entrySet()){
               if(data.getCountryCode().equals(pair.getKey())) {
                   country=pair.getValue();

               }
           }

           return country;
        }        //example Ukraine
        @Override
        public String getName(){
            return data.getContactLastName()+", "+data.getContactFirstName();
        }               //example Ivanov, Ivan
        @Override
        public String getPhoneNumber(){
           String number=Integer.toString(data.getPhoneNumber());
            while (number.length()<10) {
                String zero="0";
                number=zero.concat(number);
            }



            return "+"+Integer.toString(data.getCountryPhoneCode())+"("+number.substring(0,3)+")"+number.substring(3,6)+"-"+number.substring(6,8)+"-"+number.substring(8);


        }        //example +38(050)123-45-67

    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}