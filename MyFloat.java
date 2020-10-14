package com.company;

public class MyFloat
{
    private long mantissa;
    private long exponent;
    private long myInteger;
    private long myFraction;
    private long resultInteger;
    private long resultFraction;
    private long resultExp;
    private long resultMantissa;

    public MyFloat(long mantissa, long exponent)
    {
        this.mantissa = mantissa;
        this.exponent = exponent;
        intFract();
        this.resultFraction = 0;
        this.resultInteger = 0;
    }

    private void intFract()
    {
        this.myInteger = (long)(this.mantissa / Math.pow(10, this.exponent));
        this.myFraction = (long)(this.mantissa % Math.pow(10, this.exponent));
    }



    public void sum(com.company.MyFloat b)
    {
        this.resultExp = this.exponent <= b.getExponent() ? b.getExponent() : this.exponent;

        if(this.exponent >= b.getExponent())
        {
            b.setMyFraction((long)(b.getMyFraction() * Math.pow(10, this.exponent - b.getExponent())));
        }
        else
        {
            this.myFraction *= (long)Math.pow(10, b.getExponent() - this.exponent);
        }

        this.resultFraction = this.myFraction + b.myFraction;
        this.resultInteger += this.resultFraction / (long)(Math.pow(10, this.resultExp));
        this.resultFraction = this.resultFraction % (long)(Math.pow(10, this.resultExp));

        this.resultInteger += (this.myInteger + b.getMyInteger());

        System.out.println(this.resultInteger + "." + this.resultFraction);
    }
    public void dif(com.company.MyFloat b){
        if(b.exponent >= this.exponent){
            for(int i = 0; i < b.exponent - this.exponent; i++)
                this.mantissa *= 10;
            this.resultExp = b.exponent;
        }
        else{
            for(int j = 0; j<this.exponent - b.exponent; j++)
                b.mantissa *= 10;
            this.resultExp = this.exponent;
        }
        this.resultMantissa = this.mantissa - b.mantissa;
        boolean min = false;
        if(this.resultMantissa < 0)
        {
            this.resultMantissa *= (-1);
            min = true;
        }
        long before = this.resultMantissa / (long)(Math.pow(10,this.resultExp));
        long after = this.resultMantissa % (long)(Math.pow(10,this.resultExp));
        long afterCheck = after;
        long afternum = 0;
        while (afterCheck != 0)
        {
            afternum++;
            afterCheck /= 10;
        }
        String afterdot = Long.toString(after);
        if(resultExp != afternum)
        {
            for(int i = 0;i < resultExp - afternum; i++)
            {
                afterdot = "0" + after;
            }
        }
        String beforedot = Long.toString(before);
        String answer = before + "." + after;
        if(min)
            answer = "-"+answer;
        System.out.println(answer);
    }


    public long getMyInteger()
    {
        return myInteger;
    }

    public long getMyFraction()
    {
        return myFraction;
    }

    public void setMyFraction(long myFraction)
    {
        this.myFraction = myFraction;
    }

    public long getExponent()
    {
        return exponent;
    }

}