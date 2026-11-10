package com.hrm.tests.java_prac;

public class Tata extends Maruti {  
    @Override
    public void price() {
        System.out.println("Tata Price");
    }
    
  
   
    public static void main(String[] args){
        Tata t=new Tata();
        t.speed();
        t.price();
    }
    
}
