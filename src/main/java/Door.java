/**
 * This class implements the Door component of the sushi bar assignment
 * The Door corresponds to the Producer in the producer/consumer problem
 */
public class Door extends Thread {
    private WaitingArea waitingArea;

    /**
     * Creates a new Door. Make sure to save the
     * @param waitingArea   The customer queue waiting for a seat
     */
    public Door(WaitingArea waitingArea) {
        this.waitingArea = waitingArea;
    }

    /**
     * This method will run when the door thread is created (and started)
     * The method should create customers at random intervals and try to put them in the waiting area
     */
    @Override
    public void run() {
        while(SushiBar.isOpen) {
            Customer customer = new Customer(SushiBar.customerCounter.incrementAndGet());
            SushiBar.write(Thread.currentThread().getName() + ": Customer #" + customer.getCustomerID() + " is now created.");
            waitingArea.enter(customer);
            try {
                Thread.sleep(SushiBar.doorWait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Add more methods as you see fit
}
