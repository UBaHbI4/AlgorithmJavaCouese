package softing.UBaH4ukDev.HomeWorks.HomeWork8;

/****
 Project Course2Algorithm
 Package softing.UBaH4ukDev.HomeWorks.HomeWork8

 Created by Ivan Sheynmaer (softing.UBaH4ukDev)

 2021.03.28
 v1.0
 */
public class Item {
    private int data;

    public Item(int data) {
        this.data = data;
    }

    public int getKey() {
        return this.data;
    }

    @Override
    public String toString() {
        return data+"";
    }
}
