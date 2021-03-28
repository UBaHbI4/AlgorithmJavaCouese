package softing.UBaH4ukDev.HomeWorks.HomeWork8;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork8

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.28
 v1.0
 */
public class HashTable {
    private Item[] hashArr;
    private int arrSize;
    private Item nonItem;

    public HashTable(int size) {
        this.arrSize = size;
        hashArr = new Item[arrSize];
        nonItem = new Item(-1);
    }

    public void display() {
        System.out.print("\tХеш таблица: ");
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null) {
                System.out.print(hashArr[i].getKey() + ", ");
            } else {
                System.out.print("***, ");
            }
        }
        System.out.println();
    }

    public int hashFunc(int key) {
        return key % arrSize;
    }

    public int hasFuncDouble(int key) {
        return 5 - key % 5;
    }

    public void insert(Item item, boolean isDouble) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int stepSize = hasFuncDouble(key);
        while (hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1) {
            if (isDouble) {
                hashVal += stepSize;
            } else {
                ++hashVal;
            }

            hashVal %= arrSize;
        }

        hashArr[hashVal] = item;
    }

    public Item delete(int key, boolean isDouble) {
        int hashVal = hashFunc(key);
        int stepSize = hasFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                Item temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            if (isDouble) {
                hashVal += stepSize;
            } else {
                ++hashVal;
            }
            hashVal %= arrSize;
        }
        return null;
    }

    public Item find(int key, boolean isDouble) {
        int hashVal = hashFunc(key);
        int stepSize = hasFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                return hashArr[hashVal];
            }
            if (isDouble) {
                hashVal += stepSize;
            } else {
                ++hashVal;
            }
            hashVal %= arrSize;
        }
        return null;
    }

    public int findPosition(int key, boolean isDouble) {
        int hashVal = hashFunc(key);
        int stepSize = hasFuncDouble(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                return hashVal;
            }
            if (isDouble) {
                hashVal += stepSize;
            } else {
                ++hashVal;
            }
            hashVal %= arrSize;
        }
        return -1;
    }

    private int getPrime(int min) {
        for (int i = min + 1; true; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    private boolean isPrime(int n) {
        for (int j = 2; (j * j <= n); j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }
}
