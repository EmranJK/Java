import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.ArrayList;




public class EUDriver {


    private Scanner input = new Scanner(System.in);
    private ArrayList<Country> euCountries;
    private PartyList partylist = new PartyList();

    public EUDriver() {
        euCountries = new ArrayList<Country>();
        runMenu();
    }

    public EUDriver(int i) {
        euCountries = new ArrayList<Country>();
    }

    public static void main(String[] args) {
        System.out.println("hello");
        new EUDriver();
    }

    private int mainMenu() {                                 //This method returns an integer value that the user types depending on which choice he is looking for.
        System.out.println("EU Menu");
        System.out.println("----------------");
        System.out.println("1) Add a country to EU");
        System.out.println("2) Remova a country from EU");
        System.out.println("3) Update an EU country's information");
        System.out.println("4) List all the EU countries");
        System.out.println("----------------");
        System.out.println("Country Menu");
        System.out.println("5) Add an MEP");
        System.out.println("6) Remove an MEP");
        System.out.println("7) Update the information on an MEP");
        System.out.println("8) List all MEP's in this country");
        System.out.println("----------------");
        System.out.println("Party Menu");
        System.out.println("9) Add a new Party");
        System.out.println("10) Remove a Party");
        System.out.println("11) Update the Party information");
   /**/     System.out.println("12) List all Parties");
        System.out.println("----------------");
        System.out.println("Report Menu");
    /**/    System.out.println("13) Print all the Parties in the EU");
        System.out.println("14) Calculate and print the Party with the most local representatives");
        System.out.println("15) Calculate and print the Party with the most MEP's");
        System.out.println("16) List all Parties of a given genre");
        System.out.println("17) List all MEP's of a given Party");
        System.out.println("----------------");
        System.out.println("20) Save to XML");
        System.out.println("21) Load from XML");
        System.out.println("----------------");
        System.out.println("0) Exit");
        System.out.println("==>>");
        int option = input.nextInt();
        input.nextLine();
        return option;
    }


    private void runMenu() {                                 /*This method uses the input form the mainMenu method to execute the appropriate
                                                              method for the choice that has been chosen by the user in the Menu*/


        int option = mainMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    addCountry();
                    break;
                case 2:
                    deleteCountry();
                    break;
                case 3:
                    upDateCountry();
                    break;
                case 4:
                    System.out.println(listCountries());
                    break;
                case 5:
                    addMEP();
                    break;
                case 6:
                    deleteMEP();
                    break;
                case 7:
                    updateMEP();
                    break;
                case 8:
                    listMEPSOfCountry();
                    break;
                case 9:
                    addNewParty();
                    break;
                case 10:
                    removeParty();
                    break;
                case 11:
                    updateParty();
                    break;
                case 12:
                    System.out.println(partylist.getPartyList());
                    break;
                case 13:
                    System.out.println(partylist.getPartyList());
                    break;
                case 14:
                    System.out.println(partylist.largestParty());
                    break;
                case 15:
                    System.out.println(partylist.mostMEPs(euCountries));
                    break;
                case 16:
                    System.out.println(partylist.getPartyList());
                    System.out.println("What is the genre?");
                    String genre = input.next();
                    System.out.println(partylist.listPartiesBySpecificGenre(genre));
                    break;
                case 17:
                    System.out.println(listMEPsByPartyName());
                    break;
                case 20:

                    try {
                        saveCountries();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }

                    savePartyList();
                    break;
                case 21:
                    try {
                        loadCountries();
                    }
                    catch(Exception e)
                    {
                        System.out.println("Error");
                    }

                    loadPartyList();
                    break;
                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }

//pause the program
            System.out.println("\nPress any key to continue...");
            input.nextLine(); //for the bug in Scanner
//display the main menu again
            option = mainMenu();
        }
//the user chose option 0, so exit the program
        System.out.println("Exiting... bye");
        System.exit(0);
    }


    private void listMEPSOfCountry()                     /*This method lists the countries first then tells the user to right the index of
                                                           a country of his choice which is stored in num, then declares an object for class country
                                                             and use to catch the value of the index that the user entered which is num in that object,
                                                             then it uses the Country object to list the MEPs of a country and add them all to an empty String */ {

        Mep mep;
        System.out.println(listCountries());
        System.out.println("Which country you want its MEPs:");
        int num = input.nextInt();
        Country c = euCountries.get(num);
        String mepstr = "";
        for (int i = 0; i > c.getMeps().size(); i++) {
            mep = c.getMeps().get(i);
            mepstr = mepstr + mep.toString();
        }
        System.out.println(mepstr);
    }


    private void listPartyByGenre()                           /*This method stores the user input in an int called genre to use it when printing the
                                                                listPartiesBySpecificGenre method */ {
        System.out.println("Enter a genre:");
        String genre = input.next();
        System.out.println(partylist.listPartiesBySpecificGenre(genre));
    }


    private void addMEP()                           /*This method lists all countries and tells the user to fill every field for the addMEP like name etc..
                                                       Then stores all the user values in a new Mep class object and add that to the country that the user chose */ {
        System.out.println(listCountries());
        System.out.println("Chose a country to change its MEPs:");
        int num = input.nextInt();
        euCountries.get(num);
        System.out.println("Name:");
        String name = input.next();
        System.out.println("Email:");
        String email = input.next();
        System.out.println("Phone:");
        String phone = input.next();
        System.out.println(partylist.getPartyList());
        System.out.println("Party:");
        int party = input.nextInt();
        Mep mep = new Mep(name, email, phone, partylist.getParty(party), partylist);
        euCountries.get(num).addMEP(mep);
    }

    private void addCountry()                                 /*This method tells the user to fill every field for the addCountry like name etc..
                                                              Then adds that to the country that the user chose */ {
        System.out.println("Add the name of the country:");
        String con = input.next();
        System.out.println("Add the number of MEPs:");
        int mepNum = input.nextInt();
        input.nextLine();
        euCountries.add(new Country(con, mepNum));
        // System.out.println(euCountries.get(0));
    }

    private void deleteCountry()                           /*This method lists all countries then tells the user to put the index of the country he/she wants to delete and
                                                             and stores that as an int then uses it to remove the appropriate country from the eucountries arraylist
                                                             depending on the index stored as int */ {
        System.out.println(listCountries());
        System.out.println("Select a country to delete:");
        int remova = input.nextInt();
        if (remova > euCountries.size() || remova < euCountries.size())
            System.out.println("There is no Country for this index number");
        else {
            euCountries.remove(remova);
            System.out.println("Done");
        }


    }

    private void upDateCountry() {                  /*This method lists all countries if there is any and then tells the user to chose the country he want
                                                      update its information and then it asks the user to fill the fields appropriate in the country like
                                                        name etc.. Then it stores all the user input and uses it in the setter methods for country
                                                         to update its information. Also it contains some local validations.*/
        if (euCountries.size() > 0) {
            System.out.println(listCountries());

            System.out.println("Enter the number of the country you want to update:");
            int update = input.nextInt();
            if (update > euCountries.size() || update < 0) {
                System.out.println("There is no Country for this index number");
            } else {
                Country con = euCountries.get(update);
                System.out.println("Change the number of MEPs:");
                int mepNum = input.nextInt();
                if (mepNum == 0 || mepNum < 0)
                    System.out.println("0 or less is not allowed");
                else {
                    con.setNoMEPs(mepNum);
                    System.out.println("Done");
                }
                System.out.println("Change the name of the country:");
                String name = input.next();
                if (name.length() <= 2)
                    System.out.println("Not valid");
                else
                    con.setName(name);


            }
        }
    }

    public Country findCountry(String find) {                       /*This method generates a for loop, as long as i is less than the size of
                                                                     the array list of euCountries then it keep increasing, all euCountries are gotten then if find
                                                                      matches a country in the arraylist then this country is returned*/
        //loop    throuheuCountries
        //try  find  a country whos name matches find
        //if u find a match
        //return that country

        for (int i = 0; euCountries.size() > i; i++) {
            euCountries.get(i);
            if (euCountries.get(i).getName().equals(find))
                return euCountries.get(i);


        }

        return null;
    }
       /* System.out.println("Enter the name of the country:");
        find = input.next();
        System.out.println("How many MEPs does the country have:");
        int Mep = input.nextInt();
        Country con = new Country(find, Mep);
        if (euCountries.contains(new Country(find, Mep)))
            if (euCountries.contains(con))
            // if (euCountries.contains(find))
            {
                System.out.println("Found");
                return con;

            } else {
                System.out.println("Not found");
                return null;
            }
        return null;
        */





    public String listCountries()                    /*This method goes through all the countries in the eucountries arraylist with a for loop and gets all
                                                       the countries in the arraylist. */
    {//create a string to hold all the  = ""
        //for loop to go through each country
        //make the string by adding each country to it. (toString method for country)

        String listOfCountries = "";
        for (int i = 0; i < euCountries.size(); i++){
            listOfCountries = listOfCountries + i + ": " + euCountries.get(i) + "\n";
        }
        return listOfCountries;
    }

   private void updateMEP() {                    /*This method lists all countries if there is any and then tells the user to chose the country he want
                                                      update its MEPs information and then it asks the user to fill the fields appropriate in the MEPs like
                                                        name etc.. Then it stores all the user input and uses it in the setter methods for country
                                                         to update its information. Also it contains some local validations.*/

       Mep mep;
       if (euCountries.size() > 0) {
           System.out.println(listCountries());
           System.out.println("Chose a country to update its MEPs:");
           int num = input.nextInt();
           if (euCountries.size() < 0)
               System.out.println("No country for this  index");
           else {
               Country c = euCountries.get(num);

               System.out.println("Chose the MEP that you want to update:");
               int MEPnum = input.nextInt();
               if (MEPnum < 0)
                   System.out.println("No MEP for this  index");
               else {
                   mep = c.getMeps().get(MEPnum);
                   System.out.println("Change the name of the MEP:");
                   String name = input.next();
                   mep.setMEPName(name);
                   System.out.println("Change the Email of the MEP:");
                   String email = input.next();
                   mep.setMEPEmail(email);
                   System.out.println("Change the phone number of the MEP:");
                   String phone = input.next();
                   mep.setMEPPhone(phone);
                   System.out.println("Change the party of the MEP:");

                   String MepParty = input.next();

                   mep.setMEPParty(MepParty, partylist);

               }

               /**//**/          /**//**//**//**/         /**//**/
           }

         /*  System.out.println("Name:");
           String name = input.next();
           System.out.println("Email:");
           String email = input.next();
           System.out.println("Phone:");
           String phone = input.next();
           System.out.println(partylist.getPartyList());
           System.out.println("Party:");
           int party = input.nextInt();
           Mep mep = new Mep(name, email, phone, partylist.getParty(party), partylist);

           */
       }
   }

    private void deleteMEP()                     /*This method lists all countries then tells the user to put the index of the country he/she wants to delete its MEP and
                                                     and stores that as an int. it also checks if the country exists in the arraylist and if it does then it prints its
                                                      MEPs and tells the user to put the index of the MEP he wants to delete and stores that index as int and then
                                                      it use it to remove the chosen MEP. */
    {

//        for(int i = 0; euCountries.size()>i; i++) {
        //    list = list + i + ":" + euCountries.get(i).getMeps().get(i).toString();
        System.out.println(listCountries());
        System.out.println("Please enter country:");
        int connum = input.nextInt();
        if (Utilities.validIndex(connum, euCountries))
        {
            System.out.println(euCountries.get(connum).listOfMEPs());
            System.out.println("Choose an MEP to delete:");
            int delete = input.nextInt();
            euCountries.get(connum).getMeps().remove(delete);
        }

        }




    /**/  private void addNewParty() {                   /*This method tells the user to fill every field for the addParty class like name etc..
                                                              Then stores the values in a new Party class object to add it to the partylist. */
        if (euCountries.size() > 0) {
            System.out.println(listCountries());
            System.out.println("Choose a country to add party to it:");
            int con = input.nextInt();
            if (con < 0 || con > euCountries.size())
                System.out.println("There is no country for this index");
            else {
                System.out.println("Name:");
                String name = input.next();
                System.out.println("LeaderName:");
                String leaderName = input.next();
                System.out.println("Genre:");
                String genre = input.next();
                System.out.println("Number of local representatives:");
                int numOfLocalReps = input.nextInt();
                input.nextLine();
                Party party = new Party(name, leaderName, genre, numOfLocalReps);
                partylist.addParty(party);
            }
        }
    }

  /**/  private void removeParty()                         /*This method lists all the parties then tells the user to choose a party to remove by index,
                                                               then store the input as an integer, it also  store the  party delete code in a boolean called
                                                                 deleteOK, if the code is executed successfully (boolean true) then it prints "Deleted",
                                                                 else it prints "Not Deleted"*/
    {
       // PartyList partyList = new PartyList();
       System.out.println(partylist.listOfParties());
        if (partylist.getPartyList().size() > 0) {
            System.out.println("Choose a party to remove:");
            int party = input.nextInt();

            boolean deleteOK = partylist.removeParty(party);
            if(deleteOK)
                System.out.println("Deleted");
            else
                System.out.println("Not Deleted");
        }
    }

   private String listMEPsByPartyName()                    /*This method asks the user to enter the name of the party required by him and stores the input
                                                              as a string, then it uses the stored value in the listMEPsBySpecificParty method*/
    {
        System.out.println("Enter party name:");
        String name  = input.next();
        return listMEPsbySpecificParty(name);
    }


   public String listMEPsbySpecificParty(String poi)        /*This method checks if the entered value of the index of the party stored in string poi
                                                             exists in partylist,  if it does then an empty string is declared and a for loop generates,
                                                              in the loo, i increase as long as it is smaller than the countries number until it equals it,
                                                               every time i becomes a new number, it is used in the euCountries.get code to get all countries
                                                               then .listOfMEPsByParty() is used to list the MEPs of each party of each country gotten,
                                                               but instead of that poi is used in .listOfMEPsByParty() to get the MEPs of only the
                                                               required party instead of all the parties, then all of this is stored in the empty string
                                                               and it is returned. */
    {//go  through  euCountries
        //call listOfMEPsByPartyfor eac county
        //build string
Party  p1  = Utilities.validParty(poi, partylist);
       String lmbsp = "";
       if(p1!=null) {
           for (int i = 0; i < euCountries.size(); i++) {
               lmbsp = lmbsp + i + ": " + euCountries.get(i).listOfMEPsByParty(p1) + "\n";

           }
           return lmbsp;
       }
        return "There are no countries";
    }


    public  int noMEPSBySpecificParty(String nmbsp)                 /*This method checks if the entered value of the index of the party stored in string nmbsp
                                                                      exists in partylist, then it initialise int nom as 0, then it generates a for loop,
                                                                      in the for loop i increase as long as it is smaller than the countries number until
                                                                      it equals it, then i is used in euCountries.get to get all the countries p1 is used in
                                                                      noOfMEPsByParty to get the number of MEPs of the required party stored in nmbsp.*/

    {
      //  System.out.println("Enter the name of the party");
       // nmbsp = input.next();
        Party  p1  = Utilities.validParty(nmbsp, partylist);
        int nom =  0;
        for (int i = 0; i < euCountries.size(); i++){
            nom = nom + euCountries.get(i).noOfMEPsByParty(p1);

        }
        return nom;
    }




//    /**/  private void allParties()
//    {
//        PartyList list = new PartyList();
//        if (list.getPartyList().size() > 0)
//        System.out.println(list.listOfParties());
//        else
//            System.out.println("No parties");
//    }

    /**/  private void updateParty() {                     /*This method declares party as object for Class Party then it makes sure that there are parties
                                                              existing , if yes then it lists them, then it tells the user to fill all the field for updating
                                                              the party like index etc.. and stores the values entered, it also contains local validations,
                                                              and the n it uses the stored values int the setters to set them as the new values of the
                                                              chosen party.*/

        //PartyList list = new PartyList();
        Party party;
        if (partylist.getPartyList().size() > 0) {
            System.out.println(partylist.getPartyList());

            System.out.println("Enter the number of the party you want to update:");
            int update = input.nextInt();
            if (update > partylist.getPartyList().size() || update < 0) //Utilities
            {
                System.out.println("There is no Party for this index number");
            } else {
                party = partylist.getPartyList().get(update);
                System.out.println("Change the name of the leader:");
                String leader = input.next();
                if (leader.equals(""))
                    System.out.println("No empty input allowed");
                else {
                    party.setPartyLeader(leader);
                    System.out.println("Done");
                }
                System.out.println("write the genre:");
                String genre = input.next();
                if (genre.equals(""))
                    System.out.println("No empty input allowed");
                else {
                    party.setPartyGenre(genre);
                    System.out.println("Done");
                }
                System.out.println("Change the name of the party:");
                String name = input.next();
                if (name.length() <= 2)
                    System.out.println("Not valid");
                else {
                    party.setPartyName(name);
                    System.out.println("Done");
                }
                System.out.println("What is the number of local representatives:");
                int number = input.nextInt();
                if (number <= 0)
                    System.out.println("not valid input:");
                else
                    party.setNumLocalReps(number);
                System.out.println("Done");
            }
        }
    }
    public void loadCountries() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("countries.xml"));
        euCountries = (ArrayList<Country>) is.readObject();
        is.close();



    }

    public void saveCountries() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("countries.xml"));
        out.writeObject(euCountries);
        out.close();


    }
        private void savePartyList()
        {
            try {
                partylist.save();
            }
            catch(Exception e)
            {
                System.out.println("Error");
            }

        }

        public void loadPartyList()
        {

            try {
                partylist.load();
            }
            catch(Exception e)
            {
                System.out.println("Error");
            }
        }






    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public ArrayList<Country> getEuCountries() {
        return euCountries;
    }

    public void setEuCountries(ArrayList<Country> euCountries) {
        this.euCountries = euCountries;
    }

    public PartyList getPartyList() {
        return partylist;
    }

    public void setPartyList(PartyList partylist) {
        this.partylist = partylist;
    }





}
