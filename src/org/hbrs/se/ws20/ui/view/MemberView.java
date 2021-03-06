package org.hbrs.se.ws20.ui.view;

import org.hbrs.se.ws20.al.model.Member;
import org.hbrs.se.ws20.al.entity.Userstory;

import java.util.Comparator;
import java.util.List;

public class MemberView {
    public void dump(List<Member> list){
        List<?> t = list;
        List<Userstory> l = (List<Userstory>) t;
        l.stream().sorted(Comparator.comparingDouble(Userstory::getPrio))
                .forEach(System.out::println);
    }

    public void dumpStatus(List<Member> list, String status) throws IllegalArgumentException{
        List<?> t = list;
        List<Userstory> l = (List<Userstory>) t;
        l.stream().sorted(Comparator.comparingDouble(Userstory::getPrio))
                .filter(userstory -> userstory.getStatus() == Userstory.statusWerte.valueOf(status))
                .forEach(System.out::println);
    }
}
