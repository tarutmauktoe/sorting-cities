package org.launchcode.comparators;

import org.launchcode.City;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CompoundComparator implements Comparator<City> {
    private List<Comparator<City>> comparatorList;

    public CompoundComparator() {
        comparatorList = new ArrayList<>();
    }

    public void add(Comparator<City> comparator) {
        comparatorList.add(comparator);
    }

    @Override
    public int compare(City c1, City c2) {
        if (comparatorList.isEmpty()) {
            return 0;
        }
        else {
            int r = 0;
            int i = 0;
            while (i < comparatorList.size()) {
                r = comparatorList.get(i).compare(c1, c2);
                if (r == 0) {
                    i++;
                }
                else {
                    break;
                }
            }
            return r;
        }
    }
}
