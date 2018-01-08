package com.jorgehernandezramirez.codewars;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JosephusSurvivor {


    public static int josephusSurvivor(final int n, final int k) {
        Integer counter = 0;
        final List<Integer> circleList = IntStream.rangeClosed(1, n).boxed().map(operand -> Integer.valueOf(operand)).collect(Collectors.toList());
        while(circleList.size() > 1){
            counter = getNext(circleList.size(), counter, k - 1);
            circleList.remove(circleList.get(counter));
        }
        return circleList.get(0);
    }

    private static long getAliveNumber(final List<StateNumber> stateNumbers){
        return stateNumbers.stream().filter(StateNumber::getAlive).count();
    }

    private static int getNext(final Integer n, final Integer index, final Integer k){
        return index + k >= n ? k - (n - index)  : index + k;
    }

    private static class StateNumber{

        private Integer number;

        private Boolean alive;

        public StateNumber(Integer number, Boolean alive) {
            this.number = number;
            this.alive = alive;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        public Boolean getAlive() {
            return alive;
        }

        public void setAlive(Boolean alive) {
            this.alive = alive;
        }
    }



}
