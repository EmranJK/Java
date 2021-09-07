import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class PartyList {

    private ArrayList<Party> parties = new ArrayList<Party>();
    Country country;
    EUDriver euDriver;


   // EUDriver eu = new EUDriver();


    public PartyList()
    {

    }

    public ArrayList<Party> getPartyList() {
        return parties;
    }

    public void setParties(ArrayList<Party> parties) {
        this.parties = parties;
    }

    Party getParty(int index)
    {

     if(Utilities.validIndex(index, parties))
       return parties.get(index);

    else
        return null;
    }
    public void addParty(Party party)                         /*This method adds the party required by the user*/
    {

//        System.out.println("write the details of the party:");
//        System.out.println("Name:");
//        String name = eu.getInput().next();
//        System.out.println("Leader:");
//        String leader = eu.getInput().next();
//        System.out.println("Genre");
//        String genre = eu.getInput().next();
//        System.out.println("Number of local representatives:");
//        int numlocalreps = eu.getInput().nextInt();
//        party = new Party(name, leader, genre, numlocalreps);
        parties.add(party);
    }

    public boolean removeParty(int index)                   /*This method checks if the index value stored by the user is valid in the parties array, if no
                                                        then it returns false, else it remove the party required by the user based on the index input
                                                        and returns true*/
    {
       /* System.out.println("Which party do you want to remove:");
        System.out.println(parties);
      //  index = eu.getInput().nextInt();
        if(index > parties.size() || index < parties.size())
        {
            return false;
        }
        else
            return true;
*/
        if(index >= parties.size() || index < 0)
        {
            return false;
        }
        else {
            parties.remove(index);
            return true;
        }
    }

    public int numberOfParties()                     /*This method returns the size of the parties arraylist*/
    {

        return parties.size();
    }

    public String listOfParties()                      /*This method initialise an empty string, then it generates a for loop, as long as i is less than the size of
                                                    the array list of parties then it keep increasing, every time i gets a new value it is used in
                                                    parties.then it get the party with the index stored in i, this way all the parties are listed as strings,
                                                     all of that is then added to the empty string and it is returned*/
    {
        String parListStr = "";
        for(int i=0;i<parties.size();i++){

            parListStr=parListStr+ i + ":"+parties.get(i).toString() +"\n";


        }
        if (parListStr.isEmpty())
            return "no parties in the list";
        else
        return parListStr;
    }

    public String listPartiesBySpecificGenre(String genre)    /*This method initialise an empty string, then checks if parties arraylist size is 0, if yes then
                                                          it returns "no parties", then it generates a for loop, as long as i is less than the size of
                                                    the array list of parties then it keep increasing, then it checks if a genre of a party in the arraylist
                                                     is equal to the genre required by the user and if the genre entered by the user is
                                                     valid, if yes then it lists the party with the genre required as a string, all of
                                                     this is then added to the empty string, then it checks if the number of this string
                                                      characters is bigger than 1, if yes then it returns it, else it returns "no parties with the genre"*/
    {
        String parListStrGenre = "";
        if(parties.size()==0)
            return "no parties";

        for(int i=0;i<parties.size();i++){
            if(parties.get(i).getPartyGenre().equals(Utilities.validGenre(genre)) && Utilities.validGenre(genre)!=null)
            //if(parties.get(i).getPartyGenre().equals(genre))

                parListStrGenre=parListStrGenre+parties.get(i).toString() +"\n";

        }
        if(parListStrGenre.length()>1)
            return parListStrGenre;
        else
            return  "no parties with the genre";
    }

    public Party largestParty()                    /*This method checks if parties arraylist have parties, if yes then an object for class party is initialise
                                                as the first party in the list, the all parties of the arraylist are listed with a for loop,
                                                then it checks if there is a party with a bigger number of local representatives than the first party,
                                                if yes then the first party takes the value of the party that is larger than it, this keeps happening
                                                until largest take the value of the largest party in the whole list, once this happen it is returned,
                                                if this doesn't happen then null is returned*/
    {
         if (!parties.isEmpty()){
                Party largest = parties.get(0);
                for (Party party : parties)
                {
            if(party.getNumLocalReps() > largest.getNumLocalReps())
                largest = party;
            }
            return largest;
         }
         else
         return null;
    }

    public Party mostMEPs(ArrayList<Country> mostMEPs) {          /*This method initialise an object for class party as null and an integer as 0, then it
                                                             lists all the parties in the parties arraylist with a for loop, in the body of that for loop
                                                             another integer is initialised as 0, then another for loop is generated, as long as i is less
                                                             than the size of the array list of mostMEPs then it keeps increasing, i is used to get every
                                                             mep in the arraylist then party is used to get the number of MEPs of every party of every MEP,
                                                             then all of this is added to total, then it checks if the total is larger than largestNumMep
                                                             which is 0, if yes then largestNumMep takes the value of total and largestP takes the value
                                                             of party which is the party with the most MEPs and then this party (largestP) is returned*/

//        int index = 1;
//        return parties.get(index);
  /*      if (!parties.isEmpty()){
            Party largest = parties.get(0);
            for (Party party : parties)
            {
                if(getPartyList().)
            }
        }
        return null;  */
Party  largestP   =   null;
int largestNumMep  =  0;
        for (Party party : parties) {
            //for (Country countries : country.getNoMEPs())
            int total = 0;
            for (int i = 0; i < mostMEPs.size(); i++) {

               // euDriver.getEuCountries().get(i).getNoMEPs();
               // int total = euDriver.getEuCountries().get(i).getNoMEPs();
                total += mostMEPs.get(i).noOfMEPsByParty(party);

                }
            if(total>largestNumMep)
            {
                largestNumMep=total;
                largestP  =   party;

            }

            }
               return largestP;

        }


    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("parties.xml"));
        parties = (ArrayList<Party>) is.readObject();
        is.close();
    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("parties.xml"));
        out.writeObject(parties);
        out.close();
    }

    @Override
    public String toString() {
        return "PartyList{" +
                "parties=" + parties +
                '}';
    }
}
