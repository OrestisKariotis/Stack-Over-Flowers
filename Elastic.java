package gr.ntua.ece.softeng.kidspiration;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
//import org.elasticsearch.common.document.DocumentField;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.ScoreSortBuilder;
import org.elasticsearch.search.sort.SortOrder;


import java.awt.Event;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Elastic {

    private RestHighLevelClient client;
    private String index;

    public void setup(String host, int port, String index) { //8a kanei to set up
        try {												 // gia	auta pou tou dinw

            this.index = index;

            //create the high-level client
            client = new RestHighLevelClient(
                    RestClient.builder(
                            new HttpHost(host, port, "http")
                    )
            );

            if (!indexExists()) { //an den uparxei o index ftiaxnei me to kataljlo mapping
                //create the index using the appropriate event mapping
                CreateIndexRequest req = Requests.createIndexRequest(index).  //sunarthsh kanei request gia dhmiorgia index
                        mapping("event", createEventMapping(), XContentType.JSON); //metatrepei se katalhlo tupo json
                CreateIndexResponse resp = client.indices().create(req);
                if (! resp.isAcknowledged()) {
                    throw new Exception("Index creation failed");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }

    void shutdown() {//kleisimo tou client
        try {
            if (client != null) {
                client.close();
            }
        } catch (IOException e) {

        }
    }

    private boolean indexExists() throws Exception { //h sunarthsh gia elenxo me index exists
        //check that the index exists using the low-level client
        Response response = client.getLowLevelClient().performRequest("HEAD", "/" + index);
        return (response.getStatusLine().getStatusCode() == 200);
    }




    private String createEventMapping() throws Exception {


        StringWriter sw = new StringWriter();
        JsonWriter writer = new JsonWriter(sw); //json me th morfh key/values





        writer.beginObject();
        writer.name("properties");
        writer.beginObject();	 //arxizw eisagw keys/values
        //prosexw gia nested
        //8eloun ksana beginobject

        writer.name("title");	//titlos
        writer.beginObject();
        writer.name("type").value("text"); //greek analyzer & text
        writer.name("analyzer").value("greek");//gia stemming kai tokenization//oxi tlk gt den paei mefuzzy
        writer.endObject();

        writer.name("desc");	//to escription
        writer.beginObject();
        writer.name("type").value("text");//greek analyzer & text
        writer.name("analyzer").value("greek");//gia stemming kai tokenization ///oxi oi analyzer gaman to fuzzy
        writer.endObject();

        writer.name("date");	//h hmer/mnia
        writer.beginObject();
        writer.name("type").value("date");
        writer.name("format").value("yyyy-MM-dd"); //tp date 8e;ei format
        writer.endObject();

        writer.name("tags");
        writer.beginObject();
        writer.name("type").value("keyword");//ta tags prepei keywords
        writer.endObject();						//giati exact values

        writer.name("location");
        writer.beginObject();
        writer.name("type").value("geo_point");
        writer.endObject();

        //to age kai to cost 8a ta vrei mono tou (ta kanei long )


        writer.endObject();
        writer.endObject();
        writer.close();

        return sw.toString();
    }


    //8a kanei add to event afou metatrepsei se json
    public void add(Event2 event) throws RuntimeException { //edw mpainoun ta event  //THN ALLAKSA SE PUBLIC
        try {
            //jsonify the event
            StringWriter sw = new StringWriter(); //xrhsimopoume katalhla tous writer
            JsonWriter writer = new JsonWriter(sw);
            writer.beginObject();
            writer.name("title").value(event.getTitle());
            writer.name("desc").value(event.getDesc());
            writer.name("location");//to location pio tricky
            writer.beginObject();
            writer.name("lat").value(event.getLoc().getX());
            writer.name("lon").value(event.getLoc().getY());
            writer.endObject();
            writer.name("tags").value(event.getType());  //to pedio tags enai pio tricky
            //8eloume ousistika sto json key kai multiple values
            //to elastic katalaveni to ["fox","apple"]-->string
//          		writer.beginArray();

            //        			for(String i : event.getType()) {
            //      				writer.value(i);   //8a gemisei to pinaka me ta tags tou event
            //    			}						// pou einai se morfh listas

            //    		writer.endArray();   //eipame ena pedio


            writer.name("cost").value(event.getTicket_cost());
            // writer.name("age").value(event.getAge());  //to allaksame eipame
            writer.name("lowage").value(event.getLowage());
            writer.name("highage").value(event.getHighage());
            writer.name("date").value(event.getDate());
            writer.name("sqlid").value(event.getEvent_id());
            writer.name("start_time").value(event.getStarting_time());
            //           writer.name("subject").value(event.getSubject());
//            writer.name("hasTickets").value(event.getTicketsAvailable() > 0);
            writer.endObject();
            writer.close();

            IndexRequest req = Requests.indexRequest(index).// sunarhshs pou kanei request sto sugegrimwno index...diaforetikh apo create index req
                    //   id(String.valueOf(event.getId())).  //to paraleipw gia na ftiaksei mono tou to id
                            type("event").//o typos tou document pou 8a eisagw
                    source(sw.toString(), XContentType.JSON); //to idio to document se katalhlh json morfh
            client.index(req);	//pernaei olo to request sto client													//  to dhmiourgei

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }








    //dokimastiko add
    /**
     void add2(Event2 event) throws RuntimeException { //edw mpainoun ta event
     try {
     //jsonify the event
     StringWriter sw = new StringWriter(); //xrhsimopoume katalhla tous writer
     JsonWriter writer = new JsonWriter(sw);
     writer.beginObject();
     writer.name("title").value(event.getTitle());

     writer.endObject();
     writer.close();

     IndexRequest req = Requests.indexRequest(index).// sunarhshs pou kanei request sto sugegrimwno index...diaforetikh apo create index req
     //   id(String.valueOf(event.getId())).  //to paraleipw gia na ftiaksei mono tou to id
     type("event").//o typos tou document pou 8a eisagw
     source(sw.toString(), XContentType.JSON); //to idio to document se katalhlh json morfh
     client.index(req);	//pernaei olo to request sto client													//  to dhmiourgei

     } catch (IOException e) {
     throw new RuntimeException(e.getMessage(), e);
     }
     }
     **/



    //gia to delete apo adminc..to id kapou 8a kruvetai sto session
 public    void deleteById(String id) throws IOException {


        DeleteRequest request = new DeleteRequest(this.index,"event",id); //panata kai response meta
        DeleteResponse deleteResponse = client.delete(request);		//gia na parw info
    }


    //8a kanei tis mazikes diagrafes me vash to date automation
 public   void bulkedDelete (List <String> ids) throws IOException {

        BulkRequest request = new BulkRequest();

        for(String i : ids) {

            request.add(new DeleteRequest(this.index, "event", i));
            client.bulk(request);

        }

    }








    // kanei ta update alla 8elei json me paidio times		kai id
    //   void updateById (String id,Map<String, Object> jsonMap) {
    //  	UpdateRequest request = new UpdateRequest(this.index,"event",id).doc(jsonMap);//h8ele katalhlo json map
    //   }



  public  List<String> searchIdsToDelee(String today) throws IOException {

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery(); //to query pou 8a xtisw
        boolQuery.filter(
                QueryBuilders.rangeQuery("date").lte(today).format("yyyy-MM-dd")//fi;tro pouranaw sto query
        );


        SearchSourceBuilder builder = new SearchSourceBuilder(); //o builder gia na pairasw to request
        builder.query(boolQuery);

        SearchRequest req = Requests.searchRequest(index).source(builder);//kanei to requst sto katalhlo index painotas kai ton builder
        SearchResponse response = client.search(req); //travaei reespose apo to client pou edwse to request



        SearchHits searchHits = response.getHits();//gia na parei to response searchhits
        SearchHit[] hits = searchHits.getHits(); //ta hits se pianaka

        List <String> ids= new ArrayList();
        for(SearchHit i : hits ) {
            ids.add((i.getId())); //gia ka8e search pou ekanes pare to id kai vale to sth lista
        }
        return ids;
    }











    //dokimastikh search perilamvanei
    //free text search (dec,title)
    //distance (geo search)
    //date (gia filter)
    //cost(gia filter)
    //age (gia filte)
    //tags (gia filter kai me th logikh ka8e tag OR)
    //guenaei ta hits se pinaka
    //   public List<Map<String,Object>> search(String text,String taggs, Long distanceInKm, Location fromLoc, int from, int count,Long age,Long costu,Long costl,String dateu,String datel) {
    public List<String> search(String text,List <String> taggs, Long distanceInKm, Location fromLoc, int from, int count,Long age,Long costu,Long costl,String dateu,String datel) {


        try {


            Map<String, Float> fields=new HashMap<String,Float>();  //dhlwh tou map field me ta boost
            fields.put("title", (float) 2);
            fields.put("desc", (float) 1.3);//8a xreiastei meta


            BoolQueryBuilder boolQuery = QueryBuilders.boolQuery(); //to boolquery pou xtizoume

            //           boolQuery.must(
            //               QueryBuilders.termQuery("hasTickets", hasTickets)
            //           );

            //an edw kanei match de 8a kanei match sta alla opote de paizei provlhma
            if ((text==null) && (taggs==null) && (age==null) && (costu==null) && (costl== null) && (dateu==null) && (datel==null) && (distanceInKm == null) && (fromLoc== null)){

                boolQuery.must( QueryBuilders.matchAllQuery() );
            }



            if (text != null) {//tittlos kai desc

                //to edit distance--megalo gia mpala --mpoula
                boolQuery.should(   QueryBuilders.fuzzyQuery("title", text).fuzziness(Fuzziness.TWO).maxExpansions(200).boost((float) 1.8));
                boolQuery.should(   QueryBuilders.fuzzyQuery("desc", text).fuzziness(Fuzziness.TWO).maxExpansions(200).boost((float) 1.3));
                //	boolQuery.must(// must gia na einan and
                //      QueryBuilders.queryStringQuery(text).fields(fields).analyzer("greek").autoGenerateSynonymsPhraseQuery(true)) ;

                boolQuery.minimumShouldMatch(1); //lunei nmz to 8ema ton should pou einai optiomnal

                //STOY PLAKA HTAN INT KAI EPAIZE

                //search sto title kai desc
                //pros8etoume kai
            }															//greek gia serch-time

            if (taggs != null) {//ta taggs
                boolQuery.must( //must me term squery prpei na ginei
                        QueryBuilders.termsQuery("tags", taggs).boost((float) 1.4)//to kanw me terms (any of therms match)


                );
            }


            if (age !=null ) { //to range gia ta age ..h times tou eurous dhmiourgountai gia +2 xronia
                boolQuery.filter(
                        QueryBuilders.rangeQuery("lowage").lte(age)//boost 1.3


                        //!	!!!!!!!!!!!!! prosoxh NA DW HLIKIA
                        //QueryBuilders.rangeQuery("age").gte(event.).lte(age+3)
                );
                boolQuery.filter(
                        QueryBuilders.rangeQuery("highage").gte(age)//boost 1.3

                );
            }


            if (costu !=null && costl!= null) {
                boolQuery.filter(
                        QueryBuilders.rangeQuery("cost").gte(costl).lte(costu)
                );

            }

            if(dateu!=null && datel!= null) {
                boolQuery.filter(
                        QueryBuilders.rangeQuery("date").gte(datel).lte(dateu).format("yyyy-MM-dd")//to format tou
                );													 // date to pairnei apo  to field

            }



            if (distanceInKm != null && fromLoc != null) {
                boolQuery.filter(
                        QueryBuilders.geoDistanceQuery("location").
                                distance(distanceInKm, DistanceUnit.KILOMETERS).//eprpe na valw unit
                                point(fromLoc.getX(),fromLoc.getY()));

            }

            SearchSourceBuilder builder = new SearchSourceBuilder(); //se auto mesa 8a mpei to wuery
            //  builder.from(from).size(count).query(boolQuery); //o builder metaferei to query
            builder.query(boolQuery).from(from).size(count).sort(new ScoreSortBuilder().order(SortOrder.DESC)); // edw prepei na mpei kai sortarisma !!!!! kai from kai xount

            SearchRequest req = Requests.searchRequest(index).source(builder);//kanei to requst sto katalhlo index painotas kai ton builder
            SearchResponse response = client.search(req); //travaei reespose apo to client pou edwse to request



            SearchHits searchHits = response.getHits();//gia na parei to response searchhits
            SearchHit[] hits = searchHits.getHits();//to metatrpri sep inaka

            List<String> results = new ArrayList<>();
            //   List<Map<String,Object>> results = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper(); ;//= mapper.readValue(json, Map.class);

            for (SearchHit hit : hits) {
                //        tits.add(hit.field("title"));
                //paradeigma
                ///map knk alla dkmzw json
                ///Map<String, Object> sourceAsMap = hit.getSourceAsMap();

                Gson gson = new Gson();
                String json = gson.toJson(hit.getSourceAsMap());




                //	Map<String,Object> map = mapper.readValue(json, Map.class );


                ///GIA KA8E HIT PAIRNEI TO MAP KAI TO METATREPEI SE JSON KAO TA GURNAI SE LISTA
                //	results.add(map);
                results.add(json);
                //AN 8ELEI O   MIT JSON STRING TO ALLAZW TO RETURN TO RESULT KAI
                //AFAIRW TO JACKSON


            }
            //     return new SearchResults2(searchHits.totalHits, from, hits.length, tits);
            return results;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }
}
