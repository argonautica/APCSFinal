package com.firebase.client;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


/**
 * @author sid
 *
 */
/**
 * @author sid
 *
 */
/**
 * @author sid
 *
 */
/**
 * @author sid
 *
 */
public class FirebaseClient {
	
	final ObjectMapper mapper;
	
	
	/**
	 * constrctor for firebase client class, used to read and write data to database
	 */
	public FirebaseClient() {
	mapper = new ObjectMapper();;

	}
	
	
	/**
	 * 
	 * used to post data to the database, in the form of student objects that are converted to json 
	 * @param postData the student object that is posted to the database
	 */
	public void postStudentData(final Student postData) {
		

		HttpClient client = HttpClientBuilder.create().build();
		try {
			String url = "https://apcsfinal-50ad1.firebaseio.com/studentDb.json";
			
			HttpPost post = new HttpPost(url);
			post.addHeader("Content-Type", "application/json");
			
			String postStr = new ObjectMapper().writeValueAsString(postData);
			
			// postStr = "{ \"first\": \"Jack\", \"last\": \"Sparrow\" }";
			// System.out.println("JSON String" + postStr);
					
			
			post.setEntity(new StringEntity(postStr));
			
			HttpResponse resp = client.execute(post);
			if (resp.getStatusLine().getStatusCode() != 200) {
				System.out.println("POST - failed " + resp.getStatusLine().getStatusCode());
				return;
			}
			
			String respStr = EntityUtils.toString(resp.getEntity());
			System.out.println("RESP " + respStr);
			
			
		} catch (Exception e) {
			
		} finally {
			client.getConnectionManager().shutdown();
		}
		
		
	}
	
/**
 * 
 * returns string format of database of students
 * 
 * @return string whole database of students as string, used to test get method
 */
public String getStudebtDbAsString() {
		

		HttpClient client = HttpClientBuilder.create().build();
		try {
			String url = "https://apcsfinal-50ad1.firebaseio.com/studentDb.json";
			
			HttpGet getRequest = new HttpGet(url);
	         
	        getRequest.addHeader("accept", "application/json");
	          
			HttpResponse resp = client.execute(getRequest);
			if (resp.getStatusLine().getStatusCode() != 200) {
				System.out.println("GET - failed " + resp.getStatusLine().getStatusCode());
				return null;
			}
			
			String respStr = EntityUtils.toString(resp.getEntity());
			System.out.println("RESP " + respStr);

			// StudentDb db = mapper.readValue(respStr, StudentDb.class);
			return respStr;
			
		} catch (Exception e) {
			
		} finally {
			client.getConnectionManager().shutdown();
		}
		
		return null;
	}
	
	
	/**
	 * returns all the students in a list 
	 * 
	 * @return returns the database as a list of student objects
	 */
	public List<Student> getStudentList() {
		

		HttpClient client = HttpClientBuilder.create().build();
		try {
			String url = "https://apcsfinal-50ad1.firebaseio.com/studentDb/.json";
			HttpGet getRequest = new HttpGet(url);
	         
	        getRequest.addHeader("accept", "application/json");
	          
			HttpResponse resp = client.execute(getRequest);
			if (resp.getStatusLine().getStatusCode() != 200) {
				System.out.println("GET - failed " + resp.getStatusLine().getStatusCode());
				return new ArrayList<Student>();
			}
			
			String respStr = EntityUtils.toString(resp.getEntity());
			// System.out.println("RESP " + respStr);

			// StudentDatabase db = new ObjectMapper().readValue(respStr, StudentDatabase.class);
			JsonNode db = new ObjectMapper().readValue(respStr, JsonNode.class);
			
			Iterator<JsonNode> it = db.iterator();
			List<Student> ret = new ArrayList<>();
			while (it.hasNext()) {
				JsonNode n = it.next();
				
				Student s = new ObjectMapper().convertValue(n, Student.class);
				ret.add(s);
			}
			
			return ret;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			client.getConnectionManager().shutdown();
		}
		
		return new ArrayList<Student>();
	}
	
	
	/**
	 * @author sid
	 *
	 */
	public static class Student {
		/**
		 * 
		 * returns the name of the student
		 * @return name of the student
		 */
		public String getName() {
			return name;
		}



		/**
		 * sets the name of the student
		 * @param name the name of the student
		 */
		public void setName(String name) {
			this.name = name;
		}



		/**
		 * @return returns the school of the student
		 */
		public String getSchool() {
			return school;
		}



		/**
		 * sets the school field of the student class
		 * @param school the school string to set the school field
		 */
		public void setSchool(String school) {
			this.school = school;
		}



		/**
		 * @return returns the gpa field of the student class
		 */
		public double getGpa() {
			return gpa;
		}



		/**
		 * @param gpa sets the gpa of the student
		 */
		public void setGpa(double gpa) {
			this.gpa = gpa;
		}



		/**
		 * @return returns the sat score of the student 
		 */
		public int getSat() {
			return sat;
		}



		/**
		 * @param sat sets the sat score of the student
		 */
		public void setSat(int sat) {
			this.sat = sat;
		}



		/**
		 * @return returns the sat score of the student
		 */
		public int getIq() {
			return iq;
		}



		/**
		 * @param iqsets the iq score of the student
		 */
		public void setIq(int iq) {
			this.iq = iq;
		}



		/**
		 * @return returns the happiness stat of the student
		 */
		public int getHappiness() {
			return happiness;
		}



		/**
		 * @param happiness
		 */
		public void setHappiness(int happiness) {
			this.happiness = happiness;
		}



		/**
		 * @return returns the ecs stat of the student
		 */
		public int getEcs() {
			return ecs;
		}



		/**
		 * @param ecs sets the ec stat of the user
		 */
		public void setEcs(int ecs) {
			this.ecs = ecs;
		}



		private String name;
		private String school;
		private double gpa;
		private int sat;
		private int iq, happiness, ecs;
		
		public Student() {
			
		}
		
		
		
		/**
		 * creates a student object, used to represent a student with a name, a list of schools that they got into, their gpa, their sat score, their extracurricular number, their iq, and their happiness number
		 * 
		 * @param name name of student
		 * @param schools schools student is accepted to 
		 * @param GPA gpa of the student
		 * @param sat sat score of the student
		 * @param ecs extracurricular rank of student
		 * @param iq intelligence quotient of student
		 * @param happiness happiness stat of student
		 */
		public Student(String name, String schools, double GPA, int sat, int ecs,  int iq , int happiness) {
			this.name = name;
			this.school = schools;
			this.gpa = GPA;
			this.sat = sat;
			this.iq = iq;
			this.happiness = happiness;
			this.ecs = ecs;
			
			
		}
		
		
	}
	
	
	

}
