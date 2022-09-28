public class Client {
  public static void main(String[] args) {
    Chinchilla c = new Chinchilla();
    c.setName("Grumpy");
    System.out.println("The " + c.classOfAnimal() + "'s name is " + c.getName());

    ZebraFinch z = new ZebraFinch();
    z.setName("Happy");
    System.out.println("The " + z.classOfAnimal() + "'s name is " + z.getName());

    // My addition
    // Chinchilla has all the attributes and methods from Pet
    Pet p = new Chinchilla();
    p.setName("Grumpy");
    System.out.println("The " + p.classOfAnimal() + "'s name is " + p.getName());

    // Polymorphism has been performed on ZebraFinch
    // ZebraFinch also has attributes of Pet
    p = new ZebraFinch();
    p.setName("Happy");
    System.out.println("The " + p.classOfAnimal() + "'s name is " + p.getName());
  }
}
