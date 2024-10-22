public class Task {
    static int[] arrayer1 = {1, 76, 45, 34, 97, 56, 45, 100, 54, 37, 65, 89, 23, 13, 47, 61, 43, 24, 59, 43, 22, 64, 89};
    static int[] arrayer2 = {2, 45, 45, 45, 67, 52, 91, 100, 100, 23, 1, 1, 0, -2, 43, 94, -87, 32, 12, 19, -18, -300, -94, -65, -55, 2, -33};

    public static void main(String[] args) {
        System.out.println("Sortie time!");
        String before1 = displayIntArray(arrayer1);
        String before2 = displayIntArray(arrayer2);

        int[][] arrays = {arrayer1, arrayer2};

        for (int i = 0; i < arrays.length; i++) {
            System.out.printf("(%d, BEFORE)%n", i);
            String printee = displayIntArray(arrays[i]);
            System.out.println(printee);
        }
        // Had to look up https://www.programiz.com/java-programming/enhanced-for-loop because I'd forgotten.
        for (int[] array : arrays) {
            quickSort(array, 0, array.length-1);
        }
        System.out.println("_______________\n_______________");
        for (int i = 0; i < arrays.length; i++) {
            System.out.printf("(%d, AFTER)%n", i);
            String printee = displayIntArray(arrays[i]);
            System.out.println(printee);
        }
    }

    // Again, from another project.
    private static String displayIntArray(int[] arraye) { // Returns a string that displays the main array, though choice of array is redundant.
        String strungler = "";
        for (int i = 0; i < arraye.length; i++) {
            if (i == 0)
                strungler += '{';
            strungler += String.valueOf(arraye[i]);
            if (i < arraye.length-1)
                strungler += ", ";
            else
                strungler += '}';
        }
        return strungler;
    }

    // I'd already done this... so I guess I'll copy it??? I don't know
    // Source 1: I saw "tail recursive" from w3 and got an idea (https://www.geeksforgeeks.org/quick-sort-algorithm/#advantages-of-quick-sort)
    // Source 2: https://www.w3schools.com/dsa/dsa_algo_quicksort.php
    // Source 3: Algorithm visual under the Algorithm header helped here: https://en.wikipedia.org/wiki/Quicksort
    public static void quickSort(int[] array, int start, int end) {
        int pivot = end;
        int nextDown = pivot - 1;

        boolean moved = false;

        for (int i = start; i < pivot; i++) {
            if (array[i] > array[pivot]) {
                int stored = array[nextDown];
                int diff = end - start;
                if (diff > 1) { // If not just 2 elements, then swap; else the code below will go ahead with it anyway.
                    array[nextDown] = array[i];
                    array[i] = stored;
                }

                stored = array[pivot];
                array[pivot] = array[nextDown];
                array[nextDown] = stored;

                pivot--;
                nextDown--;
                i--;

                if (!moved && diff > 1)
                    moved = true;
            }
        }

        if (moved) { // Removed end - start > 1 from here and moved it above 'moved = true' and it actually sorts more correctly now!!! (I think)
            quickSort(array, start, nextDown);
            pivot++; // Just a probable speed trick, I don't know.
            quickSort(array, pivot, end);
        }
    }
}