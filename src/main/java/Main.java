package main.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

	
	public void sortHotel() {
		System.out.println("enter number of hotel entries");
		try(Scanner in = new Scanner(System.in)){
			int numberOfHotelEntries=in.nextInt();
			int i=0;
			int hotelId=0;
			int hotelRank=0;
			Map <Integer, Integer> hotelIdToRankMapping = new HashMap<Integer, Integer>();
			
			for(i=0; i<numberOfHotelEntries; i++) {
				System.out.println("enter hotelId space hotelRank");
				hotelId=in.nextInt();
				hotelRank=in.nextInt();
				if(hotelIdToRankMapping.containsKey(hotelId)) {
					hotelIdToRankMapping.put(hotelId, (hotelIdToRankMapping.get(hotelId)+hotelRank)/2);
				}else {
					hotelIdToRankMapping.put(hotelId, hotelRank);
				}
			}
			
			hotelIdToRankMapping.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

			System.out.println(hotelIdToRankMapping.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new)));
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main m=new Main();
		m.sortHotel();
	}

}
