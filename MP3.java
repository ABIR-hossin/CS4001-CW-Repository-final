public class MP3 extends Gadget
{
    private int memory;

    public MP3(String model, double price, int weight, String size, int memory)
    {
        super(model, price, weight, size);
        this.memory = memory;
    }

    public int getMemory()
    {
        return memory;
    }

    public void downloadMusic(int amount)
    {
        if (amount <= memory)
        {
            memory -= amount;
            System.out.println("Music downloaded. Remaining memory: " + memory);
        }
        else
        {
            System.out.println("Not enough memory to download music.");
        }
    }

    public void deleteMusic(int amount)
    {
        memory += amount;
        System.out.println("Music deleted. Available memory: " + memory);
    }

    public void display()
    {
        super.display();
        System.out.println("Available memory: " + memory + " MB");
    }
}
