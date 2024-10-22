
package product;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		 
		/* find a way to update listOfData if update new .csv file
		 * sooo... add a input 
		*/
		Scanner scannerInp = new Scanner(System.in);
		String file = scannerInp.nextLine();
		file = "productsData.csv";
		
		Scanner scanner = new Scanner(new File(file));  
		scanner.useDelimiter(",");   //sets the delimiter pattern 

		// creating 2D array containing data of Products 
		ArrayList<String[]> listOfData = new ArrayList<>();	
		
		while (scanner.hasNext()) {
			
			String dataLine = scanner.nextLine();
			String[] arr = dataLine.split(",");
			listOfData.add(arr);	
		}
		
		/* using the current .csv file 
		 * each array representing the Product's data has 16 elements */
		
		int numOfProducts = listOfData.size();
		ArrayList<Product> listOfProducts = new ArrayList<>();

		
		
		scanner.close();  //closes the scanner  
		scannerInp.close();
		//printArrayList(listOfData);	//print func


	}
	
	private static void printArrayList(ArrayList<String[]> data) {  //print the ArrayList of String[]
		int size = data.size();
		for (int i = 0; i < size; i++ ) {
			
			for(String j : data.get(i)) {
				System.out.print(j + "_");
			}
			System.out.println(data.get(i).length);
		}		
	}

	
}
