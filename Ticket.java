import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    private char row;
    private int seat;
    private int price;
    private Person person;

    public Ticket(char row, int seat,int price, Person person ){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public int getRow() {
        return row;
    }

    public void setRow(char row) {
        this.row = row;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void displayTicketInfo(){
        System.out.println("Seat: " + row + seat);
        System.out.println("Price: " + price);
        person.displayPersonInfo();
    }

    public void save(){
        String fileName = row + "" + seat + ".txt";
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("Seat: " + row + seat + "\n");
            writer.write("Price: £" + price + "\n");
            writer.write("Name: " + person.getName() + " " + person.getSurName() + "\n");
            writer.write("Email: " + person.getEmail() + "\n");
            writer.close();
            System.out.println("Ticket saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error Saving file");
        }


    }
}
