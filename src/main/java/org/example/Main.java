/**
 * this is just for learning, no money will be made form this.
 * also first time trying to make a webcrawler.
 * author : wkraam / Walther Kraam
 * time spent on this project : 15h
 * (also tried with jsoup and with no dependencies.... did not get far :D)
 *
 *
 * the idea is to put the different objects to a PostgreSQL database and then reading from that using javaFX library printing them out.
 *
 *
 * !!!!!!!!!! THIS WILL BE MUCH EASIER JUST COPYING THE STRUCTURE TO THE JavaFX ENABLED FILE THAN
 * GETTING THE JavaFX WORKING HERE !!!!!!!!!!!!!!!!!!
 *
 */

package org.example;

import javafx.stage.Stage;
import org.example.objects.ApteegiInfoRida;
import org.example.webcrawlers.ApteegiInfo;

import java.util.ArrayList;

public abstract class Main {
    public static ArrayList<ApteegiInfoRida> apteegiInfoRidaArrayList = new ArrayList<>();


    public static void main(String[] args){

        /*ApteegiInfo ai = new ApteegiInfo();
        ai.apteegiInfo(1500);

        System.out.println(apteegiInfoRidaArrayList.get(2).getPharmacyName());
        /**/
    }


}