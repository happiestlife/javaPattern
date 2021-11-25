package TemplateMethodPattern;

public class NameSorter extends Sorter{
    @Override
    int compare(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }
}
