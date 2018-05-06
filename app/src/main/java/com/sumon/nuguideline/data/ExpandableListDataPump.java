package com.sumon.nuguideline.data;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        LinkedHashMap<String, List<String>> expandableListDetail = new LinkedHashMap<String, List<String>>();

        List<String> menu1 = new ArrayList<String>();
        List<String> menu3 = new ArrayList<String>();
        List<String> menu4 = new ArrayList<String>();


        List<String> list1 = new ArrayList<String>();
        list1.add("CSE");
        list1.add("ECE");
        list1.add("BBA");


        List<String> list2 = new ArrayList<String>();
        list2.add("Calculation Details");
        list2.add("Calculator");
        list2.add("Calculation History");

        expandableListDetail.put("Admission", menu1);
        expandableListDetail.put("Syllabus", list1);
        expandableListDetail.put("CGPA", list2);
        expandableListDetail.put("Semester Form Fillup", menu3);
        expandableListDetail.put("Notice", menu4);


        return expandableListDetail;
    }
}
