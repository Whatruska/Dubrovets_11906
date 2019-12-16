package Lesson_14;

public class ShopDepartment {
    private Cashier[] cashiers;
    private int freeIndex = 0;

    public ShopDepartment(int cashiersLength) {
        cashiers = new Cashier[cashiersLength];
    }

    public void addCashier(Cashier cashier){
        if (freeIndex == cashiers.length){
            increaseCapacity();
        }
        cashiers[freeIndex] = cashier;
        freeIndex++;
    }

    private void increaseCapacity(){
        Cashier[] newCashiers = new Cashier[cashiers.length + 1];
        for (int i = 0; i < cashiers.length; i++){
            newCashiers[i] = cashiers[i];
        }
        cashiers = newCashiers;
    }

    public Cashier pushCashier(int index){
        if (isValidIndex(index)){
            Cashier result = cashiers[index];
            shift(index);
            return result;
        }
        return null;
    }

    private boolean isValidIndex(int index){
        return index < cashiers.length && index > -1;
    }

    private void shift(int index){
        cashiers[index] = null;
        int length = cashiers.length;
        for (int i = index + 1; i < length; i++){
            cashiers[i - 1] = cashiers[i];
        }
        cashiers[length - 1] = null;
    }

    public int getTotalMoney(){
        int sum = 0;
        for (Cashier cashier : cashiers){
            if (cashier != null) {
                sum += cashier.getMoney();
            }
        }
        return sum;
    }

    public Cashier getBestCashier(){
        int max = Integer.MIN_VALUE;
        Cashier result = null;
        for (Cashier cashier : cashiers){
            if (cashier.getMoney() > max){
                result = cashier;
            }
        }
        return result;
    }

    public Cashier getWorstCahier(){
        int min = Integer.MAX_VALUE;
        Cashier result = null;
        for (Cashier cashier : cashiers){
            if (cashier.getMoney() < min){
                result = cashier;
            }
        }
        return result;
    }

    public String toString(){
        String result = "";
        for (int i = 0; i < cashiers.length; i++){
            if (cashiers[i] != null) {
                result += (i + " - " + cashiers[i].toString() + "\n");
            }
        }
        return result;
    }
}
