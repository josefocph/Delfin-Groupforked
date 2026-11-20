import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Club {

    private String clubName;
    private List<Member> members;

    public Club(String clubName) {
        this.clubName = clubName;
        this.members = new ArrayList<>();
    }

    public String getClubName() {
        return clubName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void addMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        members.add(member);
    }

    public boolean removeMember(int memberNumber) {
        return members.removeIf(m ->
                m.getMemberNumber() == memberNumber);
    }

    public Member findMember(int memberNumber) {
        for (Member member : members) {
            if (member.getMemberNumber() == memberNumber) {
                return member;
            }
        }
        return null;
    }

    public int getMemberCount() {
        return members.size();
    }
    public int calculateExpectedIncome(LocalDate date) {
        int total = 0;

        for (Member member : members) {
            total += member.calculateFee(date);
        }

        return total;
    }
}