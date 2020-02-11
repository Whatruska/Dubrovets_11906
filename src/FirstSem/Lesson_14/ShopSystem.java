package FirstSem.Lesson_14;

public class ShopSystem {
    private Shop[] shops;
    private int freeIndex = 0;

    public ShopSystem() {
        shops = new Shop[0];
    }

    public void addShop(Shop shop){
        if (freeIndex == shops.length){
            increaseCapacity();
        }
        shops[freeIndex] = shop;
        freeIndex++;
    }

    private void increaseCapacity(){
        Shop[] newDeparts = new Shop[shops.length + 1];
        for (int i = 0; i < shops.length; i++){
            newDeparts[i] = shops[i];
        }
        shops = newDeparts;
    }

    public int getTotalMoney(){
        int totalMoney = 0;
        for (Shop shop : shops){
            totalMoney += shop.getTotalMoney();
        }
        return totalMoney;
    }

    public Cashier getBestCashier(){
        Cashier best = null;
        for (Shop shop : shops){
            Cashier departmentBest = shop.getBestCashier();
            if (best == null || departmentBest.getMoney() > best.getMoney()){
                best = departmentBest;
            }
        }
        return best;
    }

    public Cashier getWorstCashier(){
        Cashier best = null;
        for (Shop shop : shops){
            Cashier departmentBest = shop.getWorstCashier();
            if (best == null || departmentBest.getMoney() < best.getMoney()){
                best = departmentBest;
            }
        }
        return best;
    }

    public Shop getBestShop(){
        Shop best = null;
        for (Shop shop : shops){
            if (best == null || shop.getTotalMoney() > best.getTotalMoney()){
                best = shop;
            }
        }
        return best;
    }

    public Shop getWorstShop(){
        Shop best = null;
        for (Shop shop : shops){
            if (best == null || shop.getTotalMoney() < best.getTotalMoney()){
                best = shop;
            }
        }
        return best;
    }

    public Cashier pushCashierFromShop(int shopInd, int departInd, int cashierInd){
        if (isValidIndex(shopInd)){
            return shops[shopInd].pushCashierFromDepart(departInd, cashierInd);
        }
        return null;
    }

    public void addCashierToShop(int shopInd, int departInd, Cashier cashier){
        if (isValidIndex(shopInd)){
            shops[shopInd].addCashierToDepart(departInd, cashier);
        }
    }

    private boolean isValidIndex(int shopInd){
        return shopInd > -1 && shopInd < shops.length;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < shops.length; i++){
            result += "Shop num " + i + "\n" + shops[i].toString() + "\n";
        }
        return result;
    }
}
