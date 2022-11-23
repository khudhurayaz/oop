package de.khudhur.internship.internship5;

public class MyListTest {
    public static void main(String[] args) {
        MyList list = new MyList();
        //Neuen Elementen
        list.addToList(0, 10);
        list.addToList(1, 20);
        list.addToList(2, 30);
        list.addToList(3, 40);
        list.addToList(4, 50);
        list.addToList(5, 60);
        list.addToList(6, 70);
        list.addToList(7, 80);
        list.addToList(8, 90);
        list.addToList(9, 100);
        list.addToList(10, 90);

        System.out.println("Elemente Hinzufügen");
        show(list.getArray());

        System.out.println("Entferntes Element: " + list.removeFromList(2)); //30

        System.out.println("Duplikate Entfernen Anzahl: " + list.removeDuplicates());

        System.out.println("Sortieren: ");
        list.sortList();
        show(list.getArray());
    }

    private static void show(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
