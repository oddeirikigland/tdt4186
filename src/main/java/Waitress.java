/**
 * This class implements the consumer part of the producer/consumer problem.
 * One waitress instance corresponds to one consumer.
 */
public class Waitress extends Thread {
    private WaitingArea waitingArea;

    /**
     * Creates a new waitress. Make sure to save the parameter in the class
     *
     * @param waitingArea The waiting area for customers
     */
    Waitress(WaitingArea waitingArea) {
        this.waitingArea = waitingArea;
    }

    /**
     * This is the code that will run when a new thread is
     * created for this instance
     */
    @Override
    public void run() {
        while(SushiBar.isOpen || !waitingArea.getCustomers().isEmpty()) {
            Customer customer = waitingArea.next();
            try {
                Thread.sleep(SushiBar.waitressWait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            customer.order();
            SushiBar.write(Thread.currentThread().getName() + ": Customer #" + customer.getCustomerID() + " is now eating.");
            try {
                Thread.sleep(SushiBar.customerWait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SushiBar.write(Thread.currentThread().getName() + ": Customer #" + customer.getCustomerID() + " is now leaving.");
        }
    }
}