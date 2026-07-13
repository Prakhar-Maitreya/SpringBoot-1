package com.prakhar.demo;

class P {
    void m1()
    {

    }

    void m2()
    {

    }
}
class c1 extends  P
{
    void m3()
    {

    }
}
class Test
{
    c1 c1 = new c1();
    //c1 c1 = new P(); not possible as object is expected to run m3() as well which p class doesn't have
}

