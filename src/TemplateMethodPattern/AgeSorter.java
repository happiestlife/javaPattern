package TemplateMethodPattern;

public class AgeSorter extends Sorter{
    @Override
    int compare(Person a, Person b) {
        if(a.getAge() >= b.getAge()) return 1;
        else return 0;
    }
}
