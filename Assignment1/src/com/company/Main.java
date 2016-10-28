
package com.company;


import java.io.*;
import java.util.*;

public class Main {


    public Main() {
    }











    public void StoringFiles(Map<String, List<String>> MyList, String generated_file) throws IOException {

        FileWriter writr_obj = new FileWriter(generated_file); // passed file and created a FileWriter Object

        for (String entry : MyList.keySet()) {   // getting keyset value from MyList for start string

            for (String end : MyList.keySet()) {   // getting keyset value from MyList for end string

                StringBuilder build = new StringBuilder();
                //built a string to store combinations
                build.append(entry + "-" + end); //appending words one by one
                build.append(",");

                Map<String, String> pathFinder = new HashMap<>();  //defined a path finder



                    build.append("\n");

                    writr_obj.append(build.toString());
                    writr_obj.flush();

                }
            }
        }





    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner scan = new Scanner(System.in);
        String csvFile = "/Users/Nustian/Downloads/Documents/dictionary.csv"; //importing dictionary
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = "  ";   //splitting it by " "







        Map<String, List<String>>  two_letter = new HashMap<>();  //defining new hash map


        try {

            br = new BufferedReader(new FileReader(csvFile));
            int check = 0;

            while ((line = br.readLine()) != null) {
                if (check > 1) {
                    // use comma as separator
                    String[] splitter = line.split(cvsSplitBy);


                    ArrayList<String> ArrayObj = new ArrayList<>();


                    String item = splitter[0]; //retrieving first column


                    if (item.length() == 2) {  //check if it has length 2

                        two_letter.put(item, ArrayObj);

                    }

                }

                check++;
            }


            Main myObj = new Main();
            String myFile = "/Users/Nustian/Downloads/Documents/2_letters.csv"; //creating new file

            myObj.StoringFiles(two_letter,myFile);    //calling our stroning function to put data on file




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
