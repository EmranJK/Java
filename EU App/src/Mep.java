public class Mep {


private String MEPName;
private String MEPEmail;
private String MEPPhone;
private Party MEPParty;

    public Mep(String MEPName, String MEPEmail, String MEPPhone, Party MEPParty, PartyList partyList)
    {
        this.MEPName = Utilities.max30Chars(MEPName);
        if(Utilities.validEmail(MEPEmail))
            this.MEPEmail = MEPEmail;
        else
            this.MEPEmail = "invalid format email";
        if(Utilities.onlyContainsNumbers(MEPPhone))
            this.MEPPhone = MEPPhone;
        else
            this.MEPPhone="unknown";
        this.MEPParty = Utilities.validParty(MEPParty.getPartyName(), partyList);
    }


    public String getMEPName() {
        return MEPName;
    }

    public void setMEPName(String MEPName) {
        //Utilities.max30Chars(MEPName);
        this.MEPName = Utilities.max30Chars(MEPName);
    }

    public String getMEPEmail() {
        return MEPEmail;
    }

    public void setMEPEmail(String MEPEmail) {
        if(Utilities.validEmail(MEPEmail))
        this.MEPEmail = MEPEmail;
    }

    public String getMEPPhone() {
        return MEPPhone;
    }

    public void setMEPPhone(String MEPPhone) {
        if(Utilities.onlyContainsNumbers(MEPPhone))
            this.MEPPhone = MEPPhone;
    }

    public Party getMEPParty() {
        return MEPParty;
    }

    public void setMEPParty(String MEPPartyName, PartyList partyList) {          /*This method make sure that the value for party name entered exists in the
                                                                                    partylist, if it does then it sets the entered value as the party name*/
        if (Utilities.validParty(MEPPartyName, partyList)!=null) {
            //this.MEPParty = MEPParty;
            this.MEPParty = Utilities.validParty(MEPPartyName, partyList);
            //Utilities.validParty(MEPPartyName, partyList);
            //Utilities.validParty(Utilities.max30Chars(MEPPartyName), partyList);
        }
    }
    @Override
    public String toString() {
        return "Mep{" +
                "MEPName='" + MEPName + '\'' +
                ", MEPEmail='" + MEPEmail + '\'' +
                ", MEPPhone='" + MEPPhone + '\'' +
                ", MEPParty=" + MEPParty +
                '}';
    }


}
