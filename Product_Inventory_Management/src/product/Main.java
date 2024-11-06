
package product;

import java.io.*;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		 

		//scanners
		Scanner inputScanner = new Scanner(System.in);
		String fileName = inputScanner.nextLine();
		
		// creating 2D array containing data of Products 
		ArrayList<String[]> listOfData = new ArrayList<>();	
		// create list of products
		ArrayList<Product> listOfProducts = new ArrayList<Product>();
		
		while (fileName != "CANCEL") {
			
			try {
				Scanner fileScanner = new Scanner(new File(fileName)); 
				fileScanner.useDelimiter(",");   //sets the delimiter pattern 
			
				//list of update data
				ArrayList<String[]> listOfUpdateData = new ArrayList<>();		
				// list of update products
				ArrayList<Product> listOfUpdateProducts = new ArrayList<>();

				
				
				//read csv file into data list
				while (fileScanner.hasNext()) {
					String dataLine = fileScanner.nextLine();
					String[] arr = dataLine.split(",");
					listOfUpdateData.add(arr);
				}
				
				listOfUpdateProducts = createProductList(listOfUpdateData);	//this works
				
				//keep merging into the main list of data
				listOfData = mergeData(listOfData, listOfUpdateData);
				
				System.out.println(listOfUpdateData.size() + "\t" + listOfUpdateProducts.size());
				System.out.println(listOfData.size()); 	
				
				
				//to reiterate
				fileName = inputScanner.nextLine();
				fileScanner.close();
			}
			
			catch (FileNotFoundException e) {
				break;
			}
		}			
	
		listOfProducts = createProductList(listOfData);
		
		
		
		//test 
		System.out.println();
		System.out.println(listOfData.size() + "\t" + listOfProducts.size());
		for (Product product : listOfProducts) {
			System.out.println(product.getId() + "\t" + product.getName() + "\t" + product.getQuantity() + "\t"+ product.getClass());
		}
		
		
		
		inputScanner.close();
		
		

	}

	
	
public static ArrayList<Product> createProductList(ArrayList<String[]> listOfData){
		
		ArrayList<Product> listOfProducts = new ArrayList<Product>();
		int numOfProducts = listOfData.size();

		for (int i = 0; i < numOfProducts; i++) {
			
			String[] productData = listOfData.get(i);
			String category = productData[2];
			
			if (category.equals("Book")) {	//book
				listOfProducts.add(Main.createBook(productData));
			}
			else if (category.equals("Toy")) {	//toy
				listOfProducts.add(Main.createToy(productData));
			}
			else if (category.equals("Stationery")) {	//stationery
				listOfProducts.add(Main.createStationery(productData));
			}
			
		}
		return listOfProducts;
	}
	
	
	
	private static void printArrayList(ArrayList<String[]> data) {  //print the ArrayList of String[]
		int size = data.size();
		for (int i = 0; i < size; i++ ) {
			
			for(String j : data.get(i)) {
				System.out.print(j + "_");
			}
			System.out.println();
		}		
	}
	
	
	
	public static ArrayList<String[]> mergeData(ArrayList<String[]> arr, ArrayList<String[]> updateArr) {
				
		if (arr.size() == 0) {
			return updateArr;
		}
		else if (updateArr.size() == 0) {
			return arr;
		}
		else {
		
			ArrayList<String[]> tempArr = new ArrayList<String[]>();
			for (String[] updateData : updateArr) {
				for (String[] data : arr) {
					//System.out.println(updateData[0] + "\t" + data[0] + "\t" + updateData[1] + "_" + data[1] 
						//	+ "\n" + (updateData[0].equals(data[0]) && updateData[1].equals(data[1])));
					if (updateData[0].equals(data[0]) && updateData[1].equals(data[1])) {
						int tempQuantity = Integer.valueOf(data[5]) + Integer.valueOf(updateData[5]);
	 					data[5] = String.valueOf(tempQuantity);
						break;
					}
					else if  (updateData.equals(data) == false && arr.indexOf(data) +1 == arr.size()) {
						tempArr.add(updateData);
					}
				}
			}
			
			for (String[] tempData : tempArr) {
				arr.add(tempData);
			}
			
			return arr;
			
		}
	}
	
	
	
	
	
	public static Book createBook(String[] arr) {
		
		String id = arr[0];
		String name = arr[1];
		double sellingPrice = Double.valueOf(arr[3]);
		double purchasePrice = Double.valueOf(arr[4]);
		int quantity = Integer.valueOf(arr[5]);
		String author = arr[11];
		long ISBN = new BigDecimal(arr[12]).longValue();
		int year = Integer.valueOf(arr[13]);
		String genre = arr[14];
		String publisher = arr[15];
		
		Book book = new Book(id, name, sellingPrice, purchasePrice, quantity,
				author, publisher, ISBN, year, genre);
		return book;
	}
	
	
	public static Toy createToy(String[] arr) {

		String id = arr[0];
		String name = arr[1];
		double sellingPrice = Double.valueOf(arr[3]);
		double purchasePrice = Double.valueOf(arr[4]);
		int quantity = Integer.valueOf(arr[5]);
		String brand = arr[6];
		int suitableAge = Integer.valueOf(arr[8]);
		String safetyStandards = arr[9];
		String material = arr[10];
		
		Toy toy = new Toy(id, name, sellingPrice, purchasePrice, quantity, 
				brand, suitableAge, safetyStandards, material);
		return toy;
	}
	

	public static Stationery createStationery(String[] arr) {

		String id = arr[0];
		String name = arr[1];
		double sellingPrice = Double.valueOf(arr[3]);
		double purchasePrice = Double.valueOf(arr[4]);
		int quantity = Integer.valueOf(arr[5]);
		String brand = arr[6];
		String stationeryType = arr[7];
		String material = arr[10];
		
		Stationery stationery = new Stationery(id, name, sellingPrice, purchasePrice, quantity,
				brand, stationeryType, material);
		return stationery;
	}

	
}
