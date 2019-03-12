/**
 * This class implements a customer, which is used for holding data and update the statistics
 *
 */
public class Customer {
    private int id;
    private int numberOfOrders;
    private int eatenOrders;
    private int takeAwayOrders;


    /**
     *  Creates a new Customer.
     *  Each customer should be given a unique ID
     */
    public Customer(int id) {
        this.id = id;
    }


    /**
     * Here you should implement the functionality for ordering food as described in the assignment.
     */
    public synchronized void order(){
        this.setNumberOfOrders((int)(Math.random() * SushiBar.maxOrder + 1));
        this.setEatenOrders((int)(Math.random() * this.getNumberOfOrders() + 1));
        this.setTakeAwayOrders(this.getNumberOfOrders() - this.getEatenOrders());
        SushiBar.totalOrders.add(this.getNumberOfOrders());
        SushiBar.servedOrders.add(this.getEatenOrders());
        SushiBar.takeawayOrders.add(this.getTakeAwayOrders());
    }

    /**
     *
     * @return Should return the customerID
     */
    public int getCustomerID() {
        return id;
    }

    // Add more methods as you see fit
    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(int numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public int getEatenOrders() {
        return eatenOrders;
    }

    public void setEatenOrders(int eatenOrders) {
        this.eatenOrders = eatenOrders;
    }

    public int getTakeAwayOrders() {
        return takeAwayOrders;
    }

    public void setTakeAwayOrders(int takeAwayOrders) {
        this.takeAwayOrders = takeAwayOrders;
    }
}
