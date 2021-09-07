public class Party {


  private  String PartyName;
  private  String PartyLeader;
  private  String PartyGenre;
  private  int numLocalReps;

    public Party(String partyName, String partyLeader, String partyGenre, int numLocalReps) {
        PartyName = Utilities.max30Chars(partyName);
        PartyLeader = Utilities.max30Chars(partyLeader);
        PartyGenre = Utilities.validGenre(partyGenre);
        if (Utilities.validIntNonNegative(numLocalReps))
        this.numLocalReps = numLocalReps;
    }

    public String getPartyName() {
        return PartyName;
    }

    public void setPartyName(String partyName) {

        PartyName = Utilities.max30Chars(partyName);
    }

    public String getPartyLeader() {
        return PartyLeader;
    }

    public void setPartyLeader(String partyLeader) {
        PartyLeader = partyLeader;
    }

    public String getPartyGenre() {
        return PartyGenre;
    }

    public void setPartyGenre(String partyGenre) {                               /*This method checks if the value entered by user is valid as a party genre,
                                                                                   if yes then it sets the user input value as the party genre*/
        if (partyGenre.toUpperCase().equals(Utilities.validGenre(partyGenre))) {
            PartyGenre = Utilities.validGenre(partyGenre);
        }

    }

    public int getNumLocalReps() {
        return numLocalReps;
    }

    public void setNumLocalReps(int numLocalReps) {
        if(Utilities.validIntNonNegative(numLocalReps))
            this.numLocalReps = numLocalReps;
    }

    @Override
    public String toString() {
        return "Party{" +
                "PartyName='" + PartyName + '\'' +
                ", PartyLeader='" + PartyLeader + '\'' +
                ", PartyGenre='" + PartyGenre + '\'' +
                ", numLocalReps=" + numLocalReps +
                '}';
    }
}
