package com.hrm.tests;
public class MoverRidingByInterface implements SuperClass1{

        @Override
        public void greenGo(){
            System.out.println("Green Green Go");
        }
        @Override
        public void redStop(){
            System.out.println("Red Stop");
        }
        @Override
        public void flashYellow(){
            System.out.println("Flash Yellow");
        }
        @Override
        public void newmethod(){
            System.out.println("New Method");
        }
    public static void main(String[] args){
        SuperClass1 sb=new MoverRidingByInterface();
        sb.greenGo();
        sb.redStop();
        sb.flashYellow();
        sb.newmethod();
    }

}