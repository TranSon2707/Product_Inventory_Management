package product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws Exception {



		//scanners
		Scanner inputScanner = new Scanner(System.in);
		String fileName = inputScanner.nextLine();

		// creating 2D array containing data of Products
		ArrayList<String[]> listOfData = new ArrayList<>();
		// create list of products
		ArrayList<Product> listOfProducts = new ArrayList<>();

		while (fileName != "CANCEL") {

			try {
				Scanner fileScanner = new Scanner(new File(fileName));
				fileScanner.useDelimiter(",");   //sets the delimiter pattern

				//list of update data
				ArrayList<String[]> listOfUpdateData = Main.csvToArrayList(fileScanner);
				// list of update products
				ArrayList<Product> listOfUpdateProducts = new ArrayList<>();
				listOfUpdateProducts = Main.createProductList(listOfUpdateData);

				//keep merging into the main list of data
				listOfData = Main.mergeData(listOfData, listOfUpdateData);

				//to reiterate
				fileName = inputScanner.nextLine();
				fileScanner.close();
			}

			catch (FileNotFoundException e) {
				break;
			}
		}

		listOfProducts = Main.createProductList(listOfData);



        File csvOutputFile = new File("products.csv");
        PrintWriter pw = new PrintWriter(csvOutputFile);

        
        
		pw.println("ID,Name,Category,sellingPrice,purchasePrice,Quantity,"
				+ "Brand,StationeryType,suitableAge,safetyStandards,Material,Author,ISBN,Year,Genre,Publisher");

		System.out.println(listOfProducts.get(0).category);
		for (int i = 0; i < listOfProducts.size(); i++) {

			System.out.println(listOfProducts.get(i).getClass());
			
			//product = (Book) product;
			/*
			if (listOfProducts.get(i).getClass()) {		//listOfProducts.get(i).getClass().equals(Book.class)

				Book tempBook = (Book) listOfProducts.get(i);
				pw.printf("%s,%s,Book,%f,%f,%d,"
						, tempBook.getId(), tempBook.getName(), tempBook.getSellingPrice(), tempBook.getPurchasePrice(), tempBook.getQuantity());

				pw.printf(",,,,,%s,%d,%d,%s,%s\n"
						, tempBook.getAuthor(), tempBook.getISBN(), tempBook.getYear(), tempBook.getGenre(), tempBook.getPublisher());
			}
			
			else if (listOfProducts.get(i).category.equals("Toy")) {		//listOfProducts.get(i).getClass().equals(Toy.class)

				Toy tempToy = (Toy) listOfProducts.get(i);
				pw.printf("%s,%s,Toy,%f,%f,%d,"
						, tempToy.getId(), tempToy.getName(), tempToy.getSellingPrice(), tempToy.getPurchasePrice(), tempToy.getQuantity());

				pw.printf("%s,,%d,%s,%s,,,,,\n"
						, tempToy.getBrand(), tempToy.getSuitableAge(), tempToy.getSafetyStandards(), tempToy.getMaterial());
			}
			
			else if (listOfProducts.get(i).category.equals("Stationery")) { 	//listOfProducts.get(i).getClass().equals(Stationery.class)

				Stationery tempStationery = (Stationery) listOfProducts.get(i);
				pw.printf("%s,%s,Stationery,%f,%f,%d,"
						, tempStationery.getId(), tempStationery.getName(), tempStationery.getSellingPrice(), tempStationery.getPurchasePrice(), tempStationery.getQuantity());

				pw.printf("%s,%s,,,%s,,,,,\n"
						, tempStationery.getBrand(), tempStationery.getStationeryType(), tempStationery.getMaterial());
			}*/
		}

		
		pw.close();

	}

	    private static String convertToCSV(String[] data) {
	        return String.join(",", data);
	}


}

