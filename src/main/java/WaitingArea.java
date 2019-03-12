import java.util.LinkedList;
import java.util.Queue;

/**
 * This class implements a waiting area used as the bounded buffer, in the producer/consumer problem.
 */
public class WaitingArea {
    private int size;
    private Queue<Customer> customers;

    /**
     * Creates a new waiting area.
     *
     * @param size The maximum number of Customers that can be waiting.
     */
    public WaitingArea(int size) {
        this.size = size;
        this.customers = new LinkedList<>();
    }

    /**
     * This method should put the customer into the waitingArea
     *
     * @param customer A customer created by Door, trying to enter the waiting area
     */
    public synchronized void enter(Customer customer) {
        while (this.getSize() <= this.getCustomers().size()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (SushiBar.isOpen) {
            this.getCustomers().add(customer);
            SushiBar.write(Thread.currentThread().getName() + ": Customer #" + customer.getCustomerID() + " is now waiting.");
            notify();
        }
    }

    /**
     * @return The customer that is first in line.
     */
    public synchronized Customer next() {
        while (this.getCustomers().isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Customer customer = this.getCustomers().poll();
        SushiBar.write(Thread.currentThread().getName() + ": Customer #" + customer.getCustomerID() + " is now fetched.");
        notify();
        return customer;
    }

    // Add more methods as you see fit
    public int getSize() {
        return this.size;
    }

    public Queue<Customer> getCustomers() {
        return this.customers;
    }

}
