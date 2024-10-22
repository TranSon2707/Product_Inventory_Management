package product;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) throws Exception {
		 
		Scanner scannerInp = new Scanner(System.in);
		String file = scannerInp.nextLine();
		file = "productsData.csv";
		
		Scanner scanner = new Scanner(new File("productsData.csv"));  
		scanner.useDelimiter(",");   //sets the delimiter pattern 

		// creating 2D array containing data of Products 
		ArrayList<String[]> listOfData = new ArrayList<>();	
		
		while (scanner.hasNext()) {
			
			String dataLine = scanner.nextLine();
			String[] arr = dataLine.split(",");
			listOfData.add(arr);	
		}

		/* find a way to update listOfData if update new .csv file
		 * sooo... add a input 
		*/
		
		
		
		
		/* using the current .csv file 
		 * each array representing the Product's data has 16 elements */
		
		ArrayList<Product> listOfProducts = new ArrayList<>();
		ArrayList<Book> listOfBooks = new ArrayList<>();
		ArrayList<Toy> listOfToys = new ArrayList<>();
		ArrayList<Stationery> listOfStationeries = new ArrayList<>();

		
		for (int i = 0; i < listOfData.size(); i++) 
		{
			String[] data = listOfData.get(i);
			//System.out.println(data[2]);
			//System.out.println(data[2].getClass());

			
			if (data[2] == "Book") {
				/*Book tempBook = createBook(data);
				System.out.println(tempBook.getId());
				listOfProducts.add(tempBook);
				listOfBooks.add( createBook(data));*/
				System.out.println("why is this not running");
				
				int id = Integer.valueOf(data[0]);
				String name = data[1];
				double sellingPrice = Double.valueOf(data[3]);
				double purchasePrice = Double.valueOf(data[4]);
				int quantity = Integer.valueOf(data[5]);
				String author = data[11];
				long ISBN = Long.valueOf(data[12]);
				int year = Integer.valueOf(data[13]);
				String genre = data[14];
				String publisher = data[15];
				
				Book book = new Book(id, name, sellingPrice, purchasePrice, quantity,
						author, publisher, ISBN, year, genre);
				
				listOfProducts.add(book);
				listOfBooks.add(book);
				System.out.print(book.getId() + " ");
				System.out.println(listOfProducts.getLast().getId());

			}
			else if (data[2] == "Toy") {
				/*Toy tempToy = createToy(data);
				System.out.println(tempToy.getId());
				listOfProducts.add(tempToy);
				listOfToys.add(createToy(data));*/				
				System.out.println("why is this not running");
				
				int id = Integer.valueOf(data[0]);
				String name = data[1];
				double sellingPrice = Double.valueOf(data[3]);
				double purchasePrice = Double.valueOf(data[4]);
				int quantity = Integer.valueOf(data[5]);
				String brand = data[6];
				int suitableAge = Integer.valueOf(data[8]);
				String safetyStandards = data[9];
				String material = data[10];
				
				Toy toy = new Toy(id, name, sellingPrice, purchasePrice, quantity, 
						brand, suitableAge, safetyStandards, material);
				
				listOfProducts.add(toy);
				listOfToys.add(toy);
				System.out.println(toy.getId() + " ");
				System.out.println(listOfProducts.getLast().getId());

			}
			else if (data[2] == "Stationery") {
				/*Stationery tempStationery = createStationery(data);
				System.out.println(tempStationery.getId());
				listOfProducts.add(tempStationery);
				listOfStationeries.add(createStationery(data));*/
				System.out.println("why is this not running");

				int id = Integer.valueOf(data[0]);
				String name = data[1];
				double sellingPrice = Double.valueOf(data[3]);
				double purchasePrice = Double.valueOf(data[4]);
				int quantity = Integer.valueOf(data[5]);
				String brand = data[6];
				String stationeryType = data[7];
				String material = data[10];
				
				Stationery stationery = new Stationery(id, name, sellingPrice, purchasePrice, quantity,
						brand, stationeryType, material);
				
				listOfProducts.add(stationery);
				listOfStationeries.add(stationery);
				System.out.println(stationery.getId() + " ");
				System.out.println(listOfProducts.getLast().getId());

			}
		}
		
		scanner.close();  //closes the scanner  
		//printArrayList(listOfData);	//print func


	}
	
	private static void printArrayList(ArrayList<String[]> data) {  //print the ArrayList of String[]
		int size = data.size();
		for (int i = 0; i < size; i++ ) {
			
			for(String j : data.get(i)) {
				System.out.print(j);
			}
			System.out.println();
		}		
	}

	private static Book createBook(String[] arr) {
		
		int id = Integer.valueOf(arr[0]);
		String name = arr[1];
		double sellingPrice = Double.valueOf(arr[3]);
		double purchasePrice = Double.valueOf(arr[4]);
		int quantity = Integer.valueOf(arr[5]);
		String author = arr[11];
		long ISBN = Long.valueOf(arr[12]);
		int year = Integer.valueOf(arr[13]);
		String genre = arr[14];
		String publisher = arr[15];
		
		Book book = new Book(id, name, sellingPrice, purchasePrice, quantity,
				author, publisher, ISBN, year, genre);
		return book;
	}
		
	private static Toy createToy(String[] arr) {

		int id = Integer.valueOf(arr[0]);
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

	private static Stationery createStationery(String[] arr) {

		int id = Integer.valueOf(arr[0]);
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
