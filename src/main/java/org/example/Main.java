/**
 * this is just for learning, no money will be made form this.
 * also first time trying to make a webcrawler.
 * author : wkraam
 * time spent on this project : 10h
 * (also tried with jsoup and with no dependencies.... did not get far :D)
 */

package org.example;

import org.example.objects.ApteegiInfoRida;
import org.example.webcrawlers.ApteegiInfo;

import java.util.ArrayList;

public class Main {

    public static ArrayList<ApteegiInfoRida> apteegiInfoRidaArrayList = new ArrayList<>();


    public static void main(String[] args){

        ApteegiInfo ai = new ApteegiInfo();
        ai.apteegiInfo(1500);

        System.out.println(apteegiInfoRidaArrayList.get(2).getPharmacyName());
    }
}