package com.example.demo;
import java.awt.print.Book;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.annotations.Mode;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.fasterxml.jackson.databind.*;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5)
@Measurement(iterations = 5)
public class demo {
		/*HashMap <String,String> metadata = new HashMap<String,String>();
		private String created_at = null;
		private long id = 0;
		private String id_str = null;
		private String text = null;
		private String source = null;
		private boolean truncated = false;
		private String in_reply_to_status_id = null;
		private String in_reply_to_status_id_str = null;
		private int in_reply_to_user_id = 0;
		private String in_reply_to_user_id_str = null;
		private String in_reply_to_screen_name = null;
		HashMap <String,String> user = new HashMap<String,String>();
		private String geo = null;
		private String coordinates = null;
		private String place = null;
		private String contributors = null;
		private int retweet_count = 0;
		private int favorite_count = 0;
		HashMap <String,String[]> entities = new HashMap<String,String[]>();	
		private boolean favorited = false;
		private boolean retweeted = false;
		private String lang = null;
	    

	    public String getat() { return this.created_at; }
	    public void setat(String created_at){ this.created_at = created_at;}
	    public long getid() { return this.id; }
	    public void setid(long id){ this.id = id;}
	    public String getidstr() { return this.id_str; }
	    public void setidstr(String id_str){ this.id_str = id_str;};
	    public boolean truncated() { return this.truncated; }
	    public void settruncated(boolean truncated){ this.truncated = truncated;}
	    public String getreply1() { return this.in_reply_to_status_id; }
	    public void setreply1(String in_reply_to_status_id){ this.in_reply_to_status_id = in_reply_to_status_id;}
	    public String getreply2() { return this.in_reply_to_status_id_str; }
	    public void setreply2(String in_reply_to_status_id_str){ this.in_reply_to_status_id_str = in_reply_to_status_id_str;}
	    public int getreply3() { return this.in_reply_to_user_id; }
	    public void setreply3(int in_reply_to_user_id){ this.in_reply_to_user_id = in_reply_to_user_id;}
	    public String getreply4() { return this.in_reply_to_user_id_str; }
	    public void setreply4(String in_reply_to_user_id_str){ this.in_reply_to_user_id_str = in_reply_to_user_id_str;}
	    public String getreply5() { return this.in_reply_to_screen_name; }
	    public void setreply5(String in_reply_to_screen_name){ this.in_reply_to_screen_name = in_reply_to_screen_name;}
	    public String getgeo() { return this.geo; }
	    public void setgeo(String geo){ this.geo = geo;}
	    public String getcoord() { return this.coordinates; }
	    public void setcoord(String coordinates){ this.coordinates = coordinates;}
	    public String getplace() { return this.place; }
	    public void setplace(String place){ this.place = place;}
	    public String getcont() { return this.contributors; }
	    public void setcont(String contributors){ this.contributors = contributors;}
	    public int gettweet() { return this.retweet_count; }
	    public void settweet(int retweet_count){ this.retweet_count = retweet_count;}
	    public int getfav() { return this.favorite_count; }
	    public void setfav(int favorite_count){ this.favorite_count = favorite_count;}
	    public boolean getf() { return this.favorited; }
	    public void setf(boolean favorited){ this.favorited = favorited;}
	    public boolean getret() { return this.retweeted; }
	    public void setret(boolean retweeted){ this.retweeted = retweeted;}
	    public String getlang() { return this.lang; }
	    public void setlang(String lang){ this.lang = lang;}
	    */
	    
	
	@State(Scope.Benchmark)	
	public static class parser{
        
        byte[] json;
        //String jsonstr;
        
        //@Configuration
        /*public class JacksonConfiguration {

            @Bean
            public ObjectMapper objectMapper() {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                return objectMapper;
            }
        }*/
        static ObjectMapper objectMapper = new ObjectMapper();

        public parser() {
            String location = "twitter.json";
            Path f = FileSystems.getDefault().getPath(location);
            System.out.println("Trying to read "+f); 
            try {
              this.json = Files.readAllBytes(f);
              //this.jsonstr = Files.readString(f);
              /*Map<String,String> myMap = new HashMap<String, String>();
              myMap = objectMapper.readValue(json,HashMap.class);
      		  System.out.println("Map is: "+myMap);
              demo books = objectMapper.readValue(Paths.get("twitter.json").toFile(), demo.class);
              System.out.println(books);*/
              //demo dem = objectMapper(this.json,demo.class);
            } catch(Exception e) {
              e.printStackTrace();
            }
            System.out.println(this.json);
            /*for (int itr=0; itr < this.json.length;itr++) {
            	System.out.println(this.json[itr]);
            }
            for (int itr2=0; itr2 < this.jsonstr.size();itr2++) {
            	System.out.println(this.jsonstr.get(itr2));
            }*/
            System.out.println("Read "+this.json.length+" bytes"); 
            /*System.out.println("Hell-o");
    		parser p = new parser();
    		p.objectMapper.readTree(p.json);
            JsonNode jsonnode = objectMapper.readTree(p.jsonstr);
    		demo dem = objectMapper.treeToValue(jsonnode,demo.class);*/

         }

	
    @Benchmark
	
		// TODO Auto-generated method stub
    	public JsonNode parse(parser p) throws IOException{
            return p.objectMapper.readTree(p.json);
		
		//JsonNode jsonnode = objectMapper.readTree(p.jsonstr);

		//demo dem = objectMapper.treeToValue(jsonnode,demo.class);
    	}
		
	}

	}

