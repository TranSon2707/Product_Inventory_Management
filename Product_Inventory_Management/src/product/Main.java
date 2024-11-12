package product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {


		//scanners
		Scanner inputScanner = new Scanner(System.in);
		String fileName = inputScanner.nextLine();

		// creating 2D array containing data of Products
		ArrayList<String[]> listOfData = new ArrayList<>();
		// create list of products
		ArrayList<Product> listOfProducts = new ArrayList<Product>();

		while (true) {

			try {
				Scanner fileScanner = new Scanner(new File(fileName));
				fileScanner.useDelimiter(",");   //sets the delimiter pattern

				//list of update data
				ArrayList<String[]> listOfUpdateData = csvToArrayList(fileScanner);
				// list of update products
				ArrayList<Product> listOfUpdateProducts = new ArrayList<>();
				listOfUpdateProducts = createProductList(listOfUpdateData);

				//keep merging into the main list of data
				listOfData = mergeData(listOfData, listOfUpdateData);

				//to reiterate
				fileName = inputScanner.nextLine();
				fileScanner.close();
			}

			catch (FileNotFoundException e) {
				break;
			}
		}

		listOfProducts = createProductList(listOfData);

		writeDataToFile("products.csv", listOfData);	//write data into products.csv

		inputScanner.close();
	}


	//create list of Products from list of data (data imported from csv file)
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


	//create a 2D arr of Data using scanner of a csv file 
	public static ArrayList<String[]> csvToArrayList(Scanner scanner){

		ArrayList<String[]> arrList = new ArrayList<String[]>();

		while (scanner.hasNext()) {
			String[] arr = scanner.nextLine()
					.split(",");
			arrList.add(arr);
		}

		return arrList;
	}


	//from 2D arr of data write those data into file 
	public static void writeDataToFile(String fileName, ArrayList<String[]> listOfData) throws FileNotFoundException {

        File csvOutputFile = new File(fileName);
        PrintWriter pw = new PrintWriter(csvOutputFile);

		pw.println("ID,Name,Category,sellingPrice,purchasePrice,Quantity,"
				+ "Brand,StationeryType,suitableAge,safetyStandards,Material,Author,ISBN,Year,Genre,Publisher");

		for (String[] productData : listOfData) {

			String category = productData[2];

			if (category.equals("Book")) {
				pw.printf("%s,%s,Book,%f,%f,%d,"
						, productData[0].trim(), productData[1].trim(), Double.valueOf(productData[3].trim()), Double.valueOf(productData[4].trim()), Integer.valueOf(productData[5].trim()) );

				pw.printf(",,,,,%s,%d,%d,%s,%s\n",
						productData[11].trim(), new BigDecimal(productData[12].trim()).longValue(), Integer.valueOf(productData[13].trim()), productData[14].trim(), productData[15].trim());
			}
			else if (category.equals("Toy")) {
				pw.printf("%s,%s,Toy,%f,%f,%d,"
						, productData[0].trim(), productData[1].trim(), Double.valueOf(productData[3].trim()), Double.valueOf(productData[4].trim()), Integer.valueOf(productData[5].trim()) );

				pw.printf("%s,,%d,%s,%s,,,,,\n"
						, productData[6].trim(), Integer.valueOf(productData[8].trim()), productData[9].trim(), productData[10].trim());
			}
			else if (category.equals("Stationery")) {
				pw.printf("%s,%s,Stationery,%f,%f,%d,"
						, productData[0].trim(), productData[1].trim(), Double.valueOf(productData[3].trim()), Double.valueOf(productData[4].trim()), Integer.valueOf(productData[5].trim()) );

				pw.printf("%s,%s,,,%s,,,,,\n"
						, productData[6].trim(), productData[7].trim(), productData[10].trim());
			}
		}

		pw.close();
	}


	//no
	//chưa dùng được method .getClass nên chưa tìm cách viết được cái này
	public static void writeProductsToFile(String fileName, ArrayList<Product> listOfProducts) throws FileNotFoundException {

        File csvOutputFile = new File(fileName);
        PrintWriter pw = new PrintWriter(csvOutputFile);

		pw.println("ID,Name,Category,sellingPrice,purchasePrice,Quantity,"
				+ "Brand,StationeryType,suitableAge,safetyStandards,Material,Author,ISBN,Year,Genre,Publisher");

		for (Product product : listOfProducts) {


		}

		pw.close();
	}


	//merge update data into main data (dùng cho nhập kho)
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

					if (updateData[0].equals(data[0]) && updateData[1].equals(data[1])) {
						int tempQuantity = Integer.valueOf(data[5]) + Integer.valueOf(updateData[5]);
	 					data[5] = String.valueOf(tempQuantity);
						break;
					}
					else if  (!updateData.equals(data) && arr.indexOf(data) +1 == arr.size()) {
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


	//used in createProductList (this is unimportant)
	public static Book createBook(String[] arr) {

		String id = arr[0].trim();
		String name = arr[1].trim();
		double sellingPrice = Double.valueOf(arr[3].trim());
		double purchasePrice = Double.valueOf(arr[4].trim());
		int quantity = Integer.valueOf(arr[5].trim());

		String author = arr[11].trim();
		long ISBN = new BigDecimal(arr[12].trim()).longValue();
		int year = Integer.valueOf(arr[13].trim());
		String genre = arr[14].trim();
		String publisher = arr[15].trim();

		Book book = new Book(id, name, sellingPrice, purchasePrice, quantity,
				author, publisher, ISBN, year, genre);
		return book;
	}


	//used in createProductList (this is unimportant)
	public static Toy createToy(String[] arr) {

		String id = arr[0].trim();
		String name = arr[1].trim();
		double sellingPrice = Double.valueOf(arr[3].trim());
		double purchasePrice = Double.valueOf(arr[4].trim());
		int quantity = Integer.valueOf(arr[5].trim());

		String brand = arr[6].trim();
		int suitableAge = Integer.valueOf(arr[8].trim());
		String safetyStandards = arr[9].trim();
		String material = arr[10].trim();

		Toy toy = new Toy(id, name, sellingPrice, purchasePrice, quantity,
				brand, suitableAge, safetyStandards, material);
		return toy;
	}


	//used in createProductList (this is unimportant)
	public static Stationery createStationery(String[] arr) {

		String id = arr[0].trim();
		String name = arr[1].trim();
		double sellingPrice = Double.valueOf(arr[3].trim());
		double purchasePrice = Double.valueOf(arr[4].trim());
		int quantity = Integer.valueOf(arr[5].trim());

		String brand = arr[6].trim();
		String stationeryType = arr[7].trim();
		String material = arr[10].trim();

		Stationery stationery = new Stationery(id, name, sellingPrice, purchasePrice, quantity,
				brand, stationeryType, material);
		return stationery;
	}


	//for testing
	public static void printArrayList(ArrayList<String[]> data) {  //print the ArrayList of String[]
		int size = data.size();
		for (int i = 0; i < size; i++ ) {
			for(String j : data.get(i)) {
				System.out.print(j + "_");
			}
			System.out.println();
		}
	}



}
