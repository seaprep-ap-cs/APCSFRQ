package practiceexam.two.question3;
import java.util.*;
public class ClubMembers {
    private ArrayList<MemberInfo> memberList;

    public void addMembers(String[] names, int gradYear) {
        for (String name : names) {
//            MemberInfo mTemp = new MemberInfo(name, gradYear, true);
            this.memberList.add(new MemberInfo(name, gradYear, true));
        }
    }

    public ArrayList<MemberInfo> removerMembers(int year) {
        ArrayList<MemberInfo> graduatedMembers = new ArrayList<MemberInfo>();

        // get graduated and good standing members and put them in a separate list
        for (MemberInfo member : memberList) {
            if (member.getGradYear() <= year && member.inGoodStanding()) {
                graduatedMembers.add(member);
            }
        }

        // remove graduated members from memberList
        // CAREFUL! When removing things from an array while iterating, you will miss checking an element
        // Instead, iterate backwards to ensure that you check every element
        for (int i = memberList.size() - 1; i >= 0; i--) {
            MemberInfo memberTemp = memberList.get(i);
            if (memberTemp.getGradYear() <= year) {
                memberList.remove(i);
            }
        }

        return graduatedMembers;
    }
}
