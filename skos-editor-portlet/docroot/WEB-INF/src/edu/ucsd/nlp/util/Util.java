package edu.ucsd.nlp.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Util {
	
	public static void WriteFileFromURL (String urlString, String filename){

		URL url; // represents the location of the file we want to dl.
		URLConnection con; // represents a connection to the url we want to dl.
		DataInputStream dis; // input stream that will read data from the file.
		FileOutputStream fos; // used to write data from inut stream to file.
		byte[] fileData; // byte aray used to hold data from downloaded file.


		try {
			url = new URL(urlString);
			con = url.openConnection(); // open the url connection.
			dis = new DataInputStream(con.getInputStream()); // get a data
																// stream from
																// the url
																// connection.
			fileData = new byte[con.getContentLength()]; // determine how many
															// byes the file
															// size is and make
															// array big enough
															// to hold the data
			for (int x = 0; x < fileData.length; x++) { // fill byte array with
														// bytes from the data
														// input stream
				fileData[x] = dis.readByte();
			}
			dis.close(); // close the data input stream
			fos = new FileOutputStream(new File(filename)); // create an object
															// representing the
															// file we want to
															// save
			fos.write(fileData); // write out the file we want to save.
			fos.close(); // close the output stream writer
		} catch (MalformedURLException m) {
			System.out.println(m);
		} catch (IOException io) {
			System.out.println(io);
		}
		
	}
	
	public static String GetUnique (){
		long lDateTime = new Date().getTime();
		System.out.println(lDateTime);
		
		return String.valueOf(lDateTime);
	}
	
	public static String GenerateFileHash(String filePath){
        MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        byte[] dataBytes = new byte[1024];
 
        int nread = 0; 
        try {
			while ((nread = fis.read(dataBytes)) != -1) {
			  md.update(dataBytes, 0, nread);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
        byte[] mdbytes = md.digest();
        
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<mdbytes.length;i++) {
    	  hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
    	}
    	
    	return hexString.toString();
		
	}
	
    /*
     * Paramterized method to sort Map e.g. HashMap or Hashtable in Java
     * throw NullPointerException if Map contains null key
     */
    public static <K extends Comparable,V extends Comparable> Map<K,V> sortByKeys(Map<K,V> map){
        List<K> keys = new LinkedList<K>(map.keySet());
        Collections.sort(keys);
      
        //LinkedHashMap will keep the keys in the order they are inserted
        //which is currently sorted on natural ordering
        Map<K,V> sortedMap = new LinkedHashMap<K,V>();
        for(K key: keys){
            sortedMap.put(key, map.get(key));
        }
      
        return sortedMap;
    }

//Read more: http://javarevisited.blogspot.com/2012/12/how-to-sort-hashmap-java-by-key-and-value.html#ixzz2Xq6ja1Og
	
}
