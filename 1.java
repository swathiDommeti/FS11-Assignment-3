import java.io.*;

class Customer implements Serializable {
    private int id;
    private String name;
    private String contactNo;
    private String address;

    public Customer(int id, String name, String contactNo, String address) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        // Create a Customer object
        Customer customer = new Customer(1, "John Doe", "1234567890", "123 Main St");

        // Serialize the object
        try {
            FileOutputStream fileOut = new FileOutputStream("JavaObject.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(customer);
            objectOut.close();
            fileOut.close();
            System.out.println("Customer object has been serialized and saved to JavaObject.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object
        try {
            FileInputStream fileIn = new FileInputStream("JavaObject.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Customer deserializedCustomer = (Customer) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("Customer object has been deserialized:");
            System.out.println("ID: " + deserializedCustomer.getId());
            System.out.println("Name: " + deserializedCustomer.getName());
            System.out.println("Contact No: " + deserializedCustomer.getContactNo());
            System.out.println("Address: " + deserializedCustomer.getAddress());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}