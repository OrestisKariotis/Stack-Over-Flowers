package com.plakic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.elasticsearch.common.document.DocumentField;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;

public class MaMain {

	public static void main(String[] args) throws IOException {
		
		
		Elastic leplak=new Elastic();
		
		leplak.setup("localhost", 9200, "zoooo"); // kanei to set up to server
												// me ta katallhla orismata
		Event2 event=new Event2( "pardon");
		
		// public Event2( String title, String date, List<String> type, int ticket_cost,Location loc, String desc,  int age
		//o constuctoras
		Location pagrati =new Location(37.965740,23.751456);//location
		
		List<String> tags0= new ArrayList() ; //ta taagas gia ton event
		
	//	tags0.add("μπαλα");
	//	tags0.add("νταλμοθτι");
		tags0.add("πεπ");
	
		
		//                     string title, String date, List<String> type, int ticket_cost,Location loc, String desc,  int age
		Event2 event21=new Event2("ωρεε", "4-4-2016", tags0, 10, pagrati, "μπαλα για τα παιδια",10);
		
	//	leplak.add2(event);
		leplak.add(event21);  //stamataw add na dokimasw delete
		
		SearchHit[] res ;
		
		
		//ta u..einai ta anw oria ..ta l ta katw oria
		//search(String text,List<String> taggs, Long distanceInKm, Location fromLoc, int from, int count,Long age,Long costu,Long costl,String date,String datel) {
		res=leplak.search("μπiλα",null, null, null, 0, 5, (long) 12 , (long)40,(long)5, "1-2-2020", "1-11-2010");
		System.out.println(res.length);													//to anw!!    //to katw!!
		
		Map<String, Object> sourceAsMap ; //gia na parw ta antikeimena..to json na to vlepw san map
		
		for(SearchHit i :res) {
			sourceAsMap =i.getSourceAsMap(); //parnei ka8e hit kai to kanei iso me map 
			System.out.println(sourceAsMap.get("title")); //kakos programmatismos
		}				//prosoxh an 8elw kati apo taggs einai nested na dw document
		
		
		
		//na diagrapsei oti vrhke
	//	for (SearchHit i: res) {
	//		leplak.deleteById(i.getId());
	//	}
		
		List<String> list = leplak.searchIdsToDelee("3-4-2016"); //vriskei ta ids pou kovontia me auth thn hmermnhia
	//	leplak.bulkedDelete(list); //diagrafei to date
		
		System.out.println("paprika");
		leplak.shutdown();
		
	}

}
