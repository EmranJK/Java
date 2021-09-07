import org.w3c.dom.ls.LSOutput;


import java.util.ArrayList;

public class Country {

    PartyList partyList;

    private String name;
    private ArrayList<Mep> meps = new ArrayList<Mep>();
    private int noMEPs;




    public Country(String name, int noMEPs) {

        this.name = Utilities.max30Chars(name);
        if (Utilities.validIntNonNegative(noMEPs) )
            this.noMEPs = noMEPs;
        else this.noMEPs=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        //.toString());
        //while (Utilities.onlyContainsNumbers(name)==false)
        //if (Utilities.onlyContainsNumbers(name))
        if (name.length()<30)
        this.name = name;
    }

    public ArrayList<Mep> getMeps() {
        return meps;
    }

    public void setMeps(ArrayList<Mep> meps) {

        this.meps = meps;
    }

    public int getNoMEPs() {
        return noMEPs;
    }

    public void setNoMEPs(int noMEPs) {
        if (Utilities.validIntNonNegative(noMEPs))
        this.noMEPs = noMEPs;
    }

    public void addMEP(Mep mep)                          /*This method add the user value stored in mep to meps arraylist if the size of the arraylist + 1 is
                                                   less or equal to the number of MEPs set for a country*/
    {
       if(meps.size() + 1 <= noMEPs)
            meps.add(mep);
    }

    public boolean removeMEP(int i)                      /*This method checks if the user input value is within the range of the meps arraylist, if yes then
                                                      it removes the required MEP depending on the index value, and returns true, if no then it
                                                      returns false*/
    {
    /*    if(i > meps.size() || i < 0)
        {
            return false;
        }
        else {
            meps.remove(i);
            return true;*/

        if(Utilities.validIntRange(0,meps.size(),i) &&  i >=0 && i  < meps.size())
        {
            meps.remove(i);
            return true;
        }
        else {

            return false;
        }

    }

    public Mep getMEP(int i)                  /*This method checks if the user input of i is valid, if no the n it returns null, else it returns the mep required
                                        by the user based on the index input*/
    {

        if(i < 0 || i > meps.size())
        {
         return null;
        }
        else
            return meps.get(i);
    }

    public int numberOfMEPs()                          /*This method returns the size of the meps arraylist*/
    {

        return meps.size();
    }

    public String listOfMEPs()                         /*This method initialise an empty string, then generates a for loop, as long as i is less than the size of
                                                    the array list of meps then it keep increasing, every time i gets a new value it is used in
                                                    meps.then it get the mep with the index stored in i, this way all the meps are listed as strings,
                                                     all of that is then added to the empty string and it is returned*/
    {
        String mepListStr = "";
        for(int i=0;i<meps.size();i++){

                mepListStr=mepListStr+i +":"+ meps.get(i).toString() +"\n";

          // if (partyList.listOfParties().equals(0))
               //if (partyList.listOfParties().isEmpty())
              // return "no parties in the list";



        }
        return mepListStr;


    }



    public String listOfMEPsByParty(Party party)              /*This method initialise an empty string, then generates a for loop, as long as i is less than the size of
                                                    the array list of meps then it keep increasing, then it checks if a party of a mep is the same as the
                                                    party required by the user, if yes then it get the mep with the index stored in i, this way all the meps are listed as strings,
                                                     all of that is then added to the empty string and it is returned*/
    {
        String mepListStr = "";
        for(int i=0;i<meps.size();i++){
              if(meps.get(i).getMEPParty().equals(party))
                mepListStr=mepListStr+meps.get(i).toString() +"\n";

            }
              return mepListStr;
            }

    public int noOfMEPsByParty(Party party)                  /*This method initialise an integer as 0, then generates a for loop, as long as i is less than the size of
                                                    the array list of meps then it keep increasing, then it checks if each party of each mep is not equal
                                                    to null and if a party of a mep is the same as the party required by the user, if yes then numMEP
                                                    increase by 1 every time this statement is fulfilled, then numMEP is returned*/

    {
        int numMEP = 0;
        for(int i=0;i<meps.size();i++){
            if(meps.get(i).getMEPParty()!=null && meps.get(i).getMEPParty().equals(party))
                numMEP++;

        }
        return numMEP;
    }



    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", meps=" + meps +
                ", noMEPs=" + noMEPs +
                '}';
    }
}
