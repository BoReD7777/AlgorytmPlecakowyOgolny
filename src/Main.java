import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Algorytm plecakowy ogólmny");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ile elementów ma tablica");
        int size = scanner.nextInt();
        int[]valueArray = new int[size];
        int[] weightArray = new int[size];
        int[] numberUsedProducts = new int[size];
        System.out.printf("Podaj kolejno produkty, najpierw wartość potem wagę.");
        for(int i = 0 ; i < size; i++){

            valueArray[i] = scanner.nextInt();
            weightArray[i] = scanner.nextInt();

        }

        sortArrays(valueArray,weightArray);


        for(int i  = 0; i< size; i++) System.out.print(valueArray[i] + ";");
        System.out.println();
        for(int i  = 0; i< size; i++) System.out.print(weightArray[i] + ";");
        System.out.println();
        System.out.println("Podaj wage plecaka");
        int weight = scanner.nextInt();

        int value = packBackpack(valueArray, weightArray, weight, numberUsedProducts);
        System.out.print("Wartość plecaka wynosi: " + value);
        for(int i  = 0; i< size; i++) System.out.print(numberUsedProducts[i] + "");
        System.out.print("");
    }
        public static int packBackpack(int[]valueArray, int[]weightArray, int weight, int[]numberOfProducts){

        int size = valueArray.length;

        int value = 0;

        for(int i = 0;i < size;i++){
            numberOfProducts[i] = weight/weightArray[i];
            weight -= numberOfProducts[i] * weight;
            value += numberOfProducts[i] * valueArray[i];
            }
        return value;
        }

public static void sortArrays(int[] valueArray, int[]weightArray){
        int size = valueArray.length;
    int valueTemp;
    int weightTemp;
        for(int i  = 0; i< size; i++){
        weightTemp = weightArray[i];
        valueTemp = valueArray[i];
        for(int j = i - 1; j >= 0 ;j--) {
            if (((double) valueArray[j] / weightArray[j]) < ((double) valueTemp / weightTemp)) {
                valueArray[j + 1] = valueArray[j];
                weightArray[j + 1] = weightArray[j];
                valueArray[j] = valueTemp;
                weightArray[j] = weightTemp;
            }
        }

        }
    }

    }
