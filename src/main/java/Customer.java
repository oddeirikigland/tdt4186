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
        numberOfOrders = (int)(Math.random() * SushiBar.maxOrder + 1);
        eatenOrders = (int)(Math.random() * numberOfOrders + 1);
        takeAwayOrders = numberOfOrders - eatenOrders;
        SushiBar.totalOrders.add(numberOfOrders);
        SushiBar.servedOrders.add(eatenOrders);
        SushiBar.takeawayOrders.add(takeAwayOrders);
    }

    /**
     *
     * @return Should return the customerID
     */
    public int getCustomerID() {
        return id;
    }

    // Add more methods as you see fit
}
