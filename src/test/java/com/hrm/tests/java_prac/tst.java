package com.hrm.tests.java_prac;
import java.util.Date;
import java.text.SimpleDateFormat;
public class tst {
// java -cp target\test-classes com.qa.ui.nzdpu.tests.Test
    static int plusMethod(int x, int y) {
  return x + y;
}

static double plusMethod(double x, double y) {
  return x + y;
}
    public static void main(String[] args) {
        // Date d = new Date();
        // SimpleDateFormat sdf=new SimpleDateFormat("d-M-yyyy");
        // System.out.println(sdf.format(d));
        // System.out.println(d);
        int myNum1 = plusMethod(8, 5);
  double myNum2 = plusMethod(4.3, 6.26);
  System.out.println("int: " + myNum1);
  System.out.println("double: " + myNum2);
    }
    
}
