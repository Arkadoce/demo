package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

@Embeddable
public class Stats {
    @Positive
    private int Str;
    @Positive
    private int Dex;
    @Positive
    private int Con;
    @Positive
    private int Wis;
    @Positive
    private int Int;
    @Positive
    private int Cha;

    protected Stats(){}

    public Stats(int Str, int Dex, int Con, int Wis, int Int, int Cha){
        this.Str=Str;
        this.Dex=Dex;
        this.Con=Con;
        this.Wis=Wis;
        this.Int=Int;
        this.Cha=Cha;
    }

    private int mod(int stat){
        return (stat-10)/2;
    }
    public int modStr(){return (mod(Str));}
    public int modDex(){return (mod(Dex));}
    public int modCon(){return (mod(Con));}
    public int modWis(){return (mod(Wis));}
    public int modInt(){return (mod(Int));}
    public int modCha(){return (mod(Cha));}

    public int Str(){return Str;}
    public int Dex(){return Dex;}
    public int Con(){return Con;}
    public int Wis(){return Wis;}
    public int Int(){return Int;}
    public int Cha(){return Cha;}

}

