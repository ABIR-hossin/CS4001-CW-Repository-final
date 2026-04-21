public class Mobile extends Gadget
{
    private int credit;

    public Mobile(String model, double price, int weight, String size, int credit)
    {
        super(model, price, weight, size);
        this.credit = credit;
    }

    public int getCredit()
    {
        return credit;
    }

    public void addCredit(int amount)
    {
        if (amount > 0)
        {
            credit += amount;
        }
        else
        {
            System.out.println("Please enter a positive amount of credit.");
        }
    }

    public void makeCall(String number, int duration)
    {
        if (duration <= credit)
        {
            System.out.println("Calling " + number + " for " + duration + " minutes.");
            credit -= duration;
        }
        else
        {
            System.out.println("Insufficient credit to make the call.");
        }
    }

    public void display()
    {
        super.display();
        System.out.println("Calling credit remaining: " + credit + " minutes");
    }
}
