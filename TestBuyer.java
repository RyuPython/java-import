public class TestBuyer{
    public static void main(String args[]){
        Buyer b = new Buyer(1000);
        b.buy(new Tv());
        b.buy(new Computer());
        b.buy(new Tv());
        b.buy(new Audio());
        b.buy(new Computer());
        b.buy(new Computer());
        b.buy(new Computer());
        b.print_summary();
    }
}

abstract class Product{
    private int price;
    protected Product(int price) { this.price = price; }
    public int getPrice(){ return price; }
    public String toString() { return this.getClass().getName(); }
}

class Tv extends Product{
    public Tv() { super(100); }
}

class Computer extends Product{
    public Computer() { super(200); }
}

class Audio extends Product{
    public Audio() { super(50); }
}

class Buyer{
    private int money;
    private Product[] cart = new Product [1024];
    private int nitems=0;
    private int minus, exchange;
    
    Buyer(int won) { money = won; }
    
    public void buy(Product p){
        if(p.getPrice()>money){
            minus = p.getPrice()-money;
            System.out.println("NOT_ENOUGH_MONEY_" + minus);
        }else{
            money = money - p.getPrice();
            add(p);
        }
    }
    
    public void add(Product p){ 
        cart[nitems] = p;
        nitems++;
    }
    
    public void print_summary(){
        exchange = 1000-money;
        System.out.print("Products: ");
        for(int i=0; i<nitems; i++){
            System.out.print(cart[i].toString() + " ");
        }
        System.out.println("\nUsed money: " + exchange);
        System.out.print("Reamining money: " + money);
    }
}