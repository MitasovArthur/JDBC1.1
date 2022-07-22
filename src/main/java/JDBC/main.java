package JDBC;

import JDBC.entity.Info;
import JDBC.entity.SelectWorkers;
import JDBC.entity.Statements;

import java.util.List;

public class main {
    public static void main(String[] args) {
        MyJoinsDB myJoinsDB = new MyJoinsDB();
        List<Info> info = myJoinsDB.getAllInfo();
        List<Statements> statements = myJoinsDB.getAllStatements();
        List<SelectWorkers> sw = myJoinsDB.getInfoWorkers();

//        List<Integer> infoNumber = info.stream()
//                .map(Info::getNumber).collect(Collectors.toList());
//        infoNumber.forEach(System.out::println);
//
//        List<String> statementsPlaceOfResidence = statements.stream()
//                .map(Statements::getPlaceOfResidence).collect(Collectors.toList());
//        infoNumber.forEach(System.out::println);
//        statementsPlaceOfResidence.forEach(System.out::println);

        for (Info infos : info) {
            System.out.println("name " + infos.getName() + "; number " + infos.getNumber());
        }
        for (Statements stats : statements) {
            System.out.println(stats.getPlaceOfResidence());
        }
        for (SelectWorkers sl:sw) {
            System.out.println(sl.getDataOfBieth()+" "+sl.getNumber());
        }

    }
}
