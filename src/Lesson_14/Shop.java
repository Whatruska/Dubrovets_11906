package Lesson_14;

public class Shop {
    private ShopDepartment[] departments;
    private int freeIndex = 0;

    public Shop(int length) {
        this.departments = new ShopDepartment[length];
    }

    public int size(){
        return freeIndex;
    }

    public void addDepartment(ShopDepartment department){
        if (freeIndex == departments.length){
            increaseCapacity();
        }
        departments[freeIndex] = department;
        freeIndex++;
    }

    private void increaseCapacity(){
        ShopDepartment[] newDeparts = new ShopDepartment[departments.length + 1];
        for (int i = 0; i < departments.length; i++){
            newDeparts[i] = departments[i];
        }
        departments = newDeparts;
    }

    public int getTotalMoney(){
        int totalMoney = 0;
        for (ShopDepartment department : departments){
            totalMoney += department.getTotalMoney();
        }
        return totalMoney;
    }

    public Cashier getBestCashier(){
        Cashier best = null;
        for (ShopDepartment department : departments){
            Cashier departmentBest = department.getBestCashier();
            if (best == null || departmentBest.getMoney() > best.getMoney()){
                best = departmentBest;
            }
        }
        return best;
    }

    public Cashier getWorstCashier(){
        Cashier best = null;
        for (ShopDepartment department : departments){
            Cashier departmentBest = department.getWorstCahier();
            if (best == null || departmentBest.getMoney() < best.getMoney()){
                best = departmentBest;
            }
        }
        return best;
    }

    public Cashier pushCashierFromDepart(int departInd, int cashierInd){
        if (isValidIndex(departInd)){
            return departments[departInd].pushCashier(cashierInd);
        }
        return null;
    }

    public void addCashierToDepart(int departInd, Cashier cashier){
        if (isValidIndex(departInd)){
            departments[departInd].addCashier(cashier);
        }
    }

    private boolean isValidIndex(int departInd){
        return departInd > -1 && departInd < departments.length;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < departments.length; i++){
            result += "Department num " + i + "\n" + departments[i].toString();
        }
        return result;
    }
}
