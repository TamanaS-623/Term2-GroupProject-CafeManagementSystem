package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservationList extends ArrayList<Reservation> {

        public ReservationList() {
                // constructor of its parent class
                super();
        }

        //method to add the Reservation objects to array List and then save them to file output
        public void saveData(Reservation r) {
                this.add(r);

                PrintWriter writer = null;
                try {
                        //creating object of File class
                        File fileDescriptor = new File("ReservationList.txt");
                        writer = new PrintWriter(fileDescriptor);

                        //writes the data into file
                        for (int index = 0; index < this.size(); index++) {
                                Reservation r1 = this.get(index);
                                writer.println(r1.getUserName() + "," + r1.getTiming());
                        }

                } catch (FileNotFoundException e) {
                        System.out.println("The file could not be created, please try again");
                } finally {
                        //condition to check if file is not null and then close it
                        if (writer != null) {
                                writer.close();
                        }
                }

        }

        // Load the list from a file.
        public void load() {
                Scanner reader = null;
                try {
                        File fileDescriptor = new File("ReservationList.txt");
                        reader = new Scanner(fileDescriptor);

                        while (reader.hasNext()) {
                                String record = reader.nextLine();
                                // splits the string and parse each field
                                String[] fields = record.split(",");
                                String _userName = fields[0];
                                int _timing = Integer.parseInt(fields[1]);
                        }
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                } finally {
                        //condition to check if file is not null and then close it
                        if (reader != null) {
                                reader.close();
                        }
                }
        }

}
