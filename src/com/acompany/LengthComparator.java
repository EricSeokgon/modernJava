package com.acompany;

class LengthComparator implements Comparable<String> {
    public int compare(String first, String second) {
        return first.length() - second.length();
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

}
